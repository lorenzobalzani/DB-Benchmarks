package Benchmark;

import Test.InsertTest;
import Test.SelectTest;
import Test.Test;
import Utils.PostGreUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link Benchmark.Benchmarks Benchmarks} class.
 * @author lorenzobalzani
 */
public class MyBenchmarks implements Benchmarks {

    private final PostGreUtils utility;
    private int commitAfterX;

    public MyBenchmarks(final PostGreUtils utility) {
        this.utility = utility;
    }

    @Override
    public void startBenchmarks(final String benchmarkName, final int nInsert, final int nSelect, final int commitAfterX) {
        System.out.println("Benchmark: " + benchmarkName);
        this.commitAfterX = commitAfterX;
        performTest(new InsertTest(), nInsert, "Insert test");
        performTest(new SelectTest(), nSelect, "Select test");
    }

    @Override
    public void performTest(final Test testType, final int nExecutions, final String testName) {
        final List<Double> list = new ArrayList<>();
        try {
            for (int i = 1; i <= nExecutions; i++) {
                    final Class<?> testClass = testType.getClass();
                    final Method method = testClass.getMethod("executeTest", Connection.class);
                    Double timeToExecute = (Double) method.invoke(testType, utility.getConnection());
                    processResult(list, (i == nExecutions || i % this.commitAfterX == 0), timeToExecute);
            }
        } catch (NoSuchMethodException|IllegalAccessException| InvocationTargetException error) {
            System.err.println(error.getMessage());
        }
        createStats(testName, list);
    }

    private void processResult(List<Double> list, boolean commit, Double timeToExecute) {
        list.add(timeToExecute);
        try {
            if (commit) {
                utility.getConnection().commit();
            }
        } catch (SQLException e) {
            try {
                utility.getConnection().rollback();
                System.out.println(e.getMessage());
            } catch (SQLException e1) {
                System.out.println(e1.getMessage());
            }
        }
    }
}

package Benchmark;

import Test.InsertTest;
import Test.SelectTest;
import Utils.PostGreUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link Benchmarks Benchmarks} class.s
 * @author lorenzobalzani
 */
public class MyBenchmarks implements Benchmarks {

    private final PostGreUtils utility;
    private int commitAfterX;

    public MyBenchmarks(final PostGreUtils utility) {
        this.utility = utility;
    }

    @Override
    public void startBenchmarks(final int nInsert, final int nSelect, final int commitAfterX) {
        this.commitAfterX = commitAfterX;
        testInsert(nInsert);
        testSelect(nSelect);
    }

    @Override
    public void testInsert(final int nExecutions) {
        final List<Double> list = new ArrayList<>();
        for (int i = 1; i <= nExecutions; i++) {
            try {
                Double timeToExecute = new InsertTest().executeTest(utility.getConnection());
                processResult(list, (i % this.commitAfterX == 0 || i == nExecutions), timeToExecute);
            } catch (SQLException error) {
                System.err.println(error.getMessage());
            }
        }
        createStats("Insert statements", list);
    }

    @Override
    public void testSelect(final int nExecutions) {
        List<Double> list = new ArrayList<>();
        for (int i = 1; i <= nExecutions; i++) {
            try {
                Double timeToExecute = new SelectTest().executeTest(utility.getConnection());
                processResult(list, (i % this.commitAfterX == 0 || i == nExecutions), timeToExecute);
            } catch (SQLException error) {
                System.err.println(error.getMessage());
            }
        }
        createStats("Select statements", list);
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

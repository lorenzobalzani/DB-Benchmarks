package Benchmark;

import Test.InsertTest;
import Test.SelectTest;
import Utils.PostGreUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of {@link Benchmarks Benchmarks} class.s
 * @author lorenzobalzani
 */
public class MyBenchmarks implements Benchmarks {

    private final PostGreUtils utility;

    public MyBenchmarks(final PostGreUtils utility) {
        this.utility = utility;
    }

    @Override
    public void startBenchmarks(final int nInsert, final int nSelect) {
        //new DeleteTableTest().executeTest(utility.getConnection());
        testInsert(nInsert);
        testSelect(nSelect);
    }

    @Override
    public void testInsert(final int nExecutions) {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < nExecutions; i++) {
            Optional<Double> timeToExecute = new SelectTest().executeTest(utility.getConnection());
            if (timeToExecute.isPresent()) {
                list.add(timeToExecute.get());
            } else {
                System.err.println("Error!");
            }
        }
        createStats("Insert statements", list);
    }

    @Override
    public void testSelect(final int nExecutions) {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < nExecutions; i++) {
            Optional<Double> timeToExecute = new InsertTest().executeTest(utility.getConnection());
            if (timeToExecute.isPresent()) {
                list.add(timeToExecute.get());
            } else {
                System.err.println("Error!");
            }
        }
        createStats("Select statements", list);
    }
}

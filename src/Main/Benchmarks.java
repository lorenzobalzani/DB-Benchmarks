package Main;

import Test.DeleteTableTest;
import Test.InsertTest;
import Test.SelectTest;
import Utils.PostGreUtils;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;

public class Benchmarks {

    private final PostGreUtils utility;
    private static final int N_EXECUTIONS = 100;

    public Benchmarks(final PostGreUtils utility) {
        this.utility = utility;
    }

    public void startBenchmarks() {
        new DeleteTableTest().executeTest(utility.getConnection());
        testInsert();
        testSelect();
    }

    private void testInsert() {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < N_EXECUTIONS; i++) {
            Optional<Double> timeToExecute = new SelectTest().executeTest(utility.getConnection());
            if (timeToExecute.isPresent()) {
                list.add(timeToExecute.get());
            } else {
                System.err.println("Error!");
            }
        }
        createStats("Insert statements", list);
    }

    private void testSelect() {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < N_EXECUTIONS; i++) {
            Optional<Double> timeToExecute = new InsertTest().executeTest(utility.getConnection());
            if (timeToExecute.isPresent()) {
                list.add(timeToExecute.get());
            } else {
                System.err.println("Error!");
            }
        }
        createStats("Select statements", list);
    }

    public void createStats(String testName, List<? extends Number> timeList) {
        DoubleSummaryStatistics stats = timeList
                .stream()
                .mapToDouble(Number::doubleValue)
                .summaryStatistics();
        System.out.println("----TEST: " + testName + " in ms----");
        System.out.println("Min time: " + stats.getMin() / 1e6);
        System.out.println("Max time: " + stats.getMax() /1e6);
        System.out.println("Avg time: " + stats.getAverage() / 1e6);
    }
}

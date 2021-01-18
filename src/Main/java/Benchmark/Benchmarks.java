package Benchmark;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import Test.Test;

/**
 * Benchmarks interface to implement when creating new types of benchmarks
 * @author lorenzobalzani
 */
public interface Benchmarks {
    /**
     * Begin insert and select tests
     * @param benchmarkName name to be printed on screen
     * @param nInsert number of insert queries to perform
     * @param nSelect number of insert queries to perform
     * @param commitAfterX number of statements to perform before issue a commit
     */
    void startBenchmarks(String benchmarkName, int nInsert, int nSelect, int commitAfterX);

    /**
     *
     * @param testType type of test to be executed
     * @param nExecutions number of executions for the given test type
     * @param testName name to be printed on screen
     */
    void performTest(Test testType, int nExecutions, String testName);

    /**
     * It creates and prints time statistics (expressed in milliseconds) on screen.
     * @param testName string to be printed on screen
     * @param timeList list on which create min/max/avg statistics
     */
    default void createStats(String testName, List<? extends Number> timeList) {
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

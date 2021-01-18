package Benchmark;

import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * Benchmarks interface to implement when creating new types of benchmarks
 * @author lorenzobalzani
 */
public interface Benchmarks {
    /**
     * Begin insert and select tests
     * @param nInsert number of insert queries to perform
     * @param nSelect number of insert queries to perform
     */
    void startBenchmarks(int nInsert, int nSelect);

    /**
     * It performs nExecutions insert queries
     * @param nExecutions number of insert queries
     */
    void testInsert(int nExecutions);

    /**
     * It performs nExecutions select queries
     * @param nExecutions number of select queries
     */
    void testSelect(int nExecutions);

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

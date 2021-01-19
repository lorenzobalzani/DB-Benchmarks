package Main;

import Benchmark.Benchmarks;

/**
 * Developer can provide different types of benchmarks to the runner.
 * @author lorenzobalzani
 */
public class Runner {
    public Runner(Benchmarks myBenchmarks, int nInsert, int nSelect, int commitAfterX) {
        myBenchmarks.startBenchmarks("1", nInsert, nSelect, commitAfterX);
    }
}

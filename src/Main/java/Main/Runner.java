package Main;

import Benchmark.Benchmarks;

/**
 * According to strategy design pattern, developer can provide different types of benchmarks to the runner.
 * @author lorenzobalzani
 */
public class Runner {
    public Runner(Benchmarks benchmarks) {
        benchmarks.startBenchmarks(100, 100);
    }
}

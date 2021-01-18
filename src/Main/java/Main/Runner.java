package Main;

import Benchmark.Benchmarks;

/**
 * According to strategy design pattern, developer can provide different types of benchmarks to the runner.
 * @author lorenzobalzani
 */
public class Runner {
    public Runner(Benchmarks myBenchmarks) {
        myBenchmarks.startBenchmarks("1", 20, 20, 23);
        myBenchmarks.startBenchmarks("2", 1000, 1000, 50);
    }
}

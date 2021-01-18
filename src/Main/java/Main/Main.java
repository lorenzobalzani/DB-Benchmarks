package Main;

import Benchmark.MyBenchmarks;
import Utils.PostGreUtils;

/**
 * It establishes a new connection to the DB and run a benchmark.
 * @author lorenzobalzani
 */
public class Main {
    public static void main (final String[] args) {
        final PostGreUtils utility = new PostGreUtils();
        utility.connectToPostGreSQL("jdbc:postgresql://localhost/postgres", "postgres", "password", false);
        new Runner(new MyBenchmarks(utility));
    }
}

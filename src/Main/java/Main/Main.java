package Main;

import Benchmark.MyBenchmarks;
import Utils.PostGreUtils;

/**
 * It establishes a new connection to the DB and run benchmarks.
 * @author lorenzobalzani
 */
public class Main {
    public static void main (final String[] args) {
        if (args.length != 3) {
            System.err.println("Usage: <nInsert> <nSelect> <commitAfterX>");
            return;
        }
        final PostGreUtils utility = new PostGreUtils();
        utility.connectToPostGreSQL("jdbc:postgresql://localhost/postgres", "postgres", "password", false);
        int nInsert = Integer.parseInt(args[0]);
        int nSelect = Integer.parseInt(args[1]);
        int commitAfterX = Integer.parseInt(args[2]);
        new Runner(new MyBenchmarks(utility), nInsert, nSelect, commitAfterX);
    }
}

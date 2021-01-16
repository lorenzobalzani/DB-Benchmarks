package Main;
import Utils.PostGreUtils;

public class Main {

    public Main() {
        final PostGreUtils utility = new PostGreUtils();
        utility.connectToPostGreSQL("jdbc:postgresql://localhost/postgres", "postgres", "password");
        new Benchmarks(utility).startBenchmarks();
    }

    public static void main (final String[] args) {
        new Main();
    }
}

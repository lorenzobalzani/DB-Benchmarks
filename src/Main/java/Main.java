import Utils.PostGreUtils;

public class Main {
    public static void main (final String[] args) {
        final PostGreUtils utility = new PostGreUtils();
        utility.connectToPostGreSQL("jdbc:postgresql://localhost/postgres", "postgres", "password");
        new Benchmarks(utility).startBenchmarks();
    }
}

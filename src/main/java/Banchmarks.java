public class Banchmarks {
    private final PosteGreUtility utility = new PosteGreUtility();

    public Banchmarks() {
        utility.connect("jdbc:postgresql://localhost/postgres", "postgres", "password");
    }

    public static void main (String[] args) {
        new Banchmarks();
    }
}

package FileSize;

public class Main {
    public static void main(String[] args) {
        Thread th = new Thread(() -> new WriteFileSize().writeSize("C:\\yura"));
        th.run();
    }
}

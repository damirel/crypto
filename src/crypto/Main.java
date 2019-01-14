package crypto;

public class Main {

    public static void main(String[] args) {
        final Crypto crypto = new Crypto();
        crypto.invoke(args);
        crypto.start();
    }
}

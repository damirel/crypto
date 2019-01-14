package crypto.strategy;

public class CaesarCryptStrategy implements CryptStrategy {

    private int key;

    public CaesarCryptStrategy(int key) {
        this.key = key;
    }

    @Override
    public String encrypt(String input) {
        StringBuilder sb = new StringBuilder(input.length());
        for (char c : input.toCharArray()) {
            sb.append((char) (c + key));
        }
        return sb.toString();
    }

    @Override
    public String decrypt(String input) {
        StringBuilder sb = new StringBuilder(input.length());
        for (char c : input.toCharArray()) {
            sb.append((char) (c - key));
        }
        return sb.toString();
    }
}

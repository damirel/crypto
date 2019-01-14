package crypto.strategy;

public interface CryptStrategy {
    String encrypt(String input);
    String decrypt(String input);
}

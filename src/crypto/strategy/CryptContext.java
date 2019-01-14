package crypto.strategy;

public class CryptContext {

    private final CryptStrategy cryptStrategy;

    public CryptContext(CryptStrategy cryptStrategy) {
        this.cryptStrategy = cryptStrategy;
    }

    public String encrypt(String input) {
        return this.cryptStrategy.encrypt(input);
    }

    public String decrypt(String input) {
        return this.cryptStrategy.decrypt(input);
    }
}

package crypto;

import crypto.strategy.CaesarCryptStrategy;
import crypto.strategy.CryptStrategy;

public enum CypherTypes {
    CAESAR {
        @Override
        public CryptStrategy createCryptStrategy(int key) {
            return new CaesarCryptStrategy(key);
        }
    };

    public abstract CryptStrategy createCryptStrategy(int key);
}

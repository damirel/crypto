package crypto;

import crypto.strategy.CryptContext;

public class Crypto {

    private String mode = "enc";
    private String data = "";
    private int key;
    private String result;
    private String outputFile = "";
    private String algorithm = "caesar";
    private String inputFile = "";

    Crypto() {

    }

    public void invoke(String[] args) {
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    key = Integer.valueOf(args[i + 1]);
                    break;
                case "-data":
                    data = args[i + 1];
                    break;
                case "-in":
                    inputFile = args[i + 1];
                    break;
                case "-out":
                    outputFile = args[i + 1];
                    break;
                case "-alg":
                    algorithm = args[i + 1];
                    break;
            }
        }
    }

    public void start() {
        validateParams();

        if (!inputFile.isEmpty()) {
            data = CryptoUtility.readFromFile(inputFile);
        }

        process();

        makeResult();
    }

    private void validateParams() {
        if (key == 0) {
            key = Integer.valueOf(CryptoUtility.getUserInput("key"));
        }
        if (inputFile.isEmpty() && data.isEmpty()) {
            data = CryptoUtility.getUserInput("message for encryption");
        }
    }

    private void process() {
        CryptContext cryptContext = new CryptContext(
                CypherTypes.valueOf(algorithm.toUpperCase()).createCryptStrategy(key));
        switch (mode) {
            case "enc":
                result = cryptContext.encrypt(data);
                break;
            case "dec":
                result = cryptContext.decrypt(data);
                break;
            default:
                result = "Unknown operation!";
        }
    }

    private void makeResult() {
        if (!outputFile.isEmpty()) {
            CryptoUtility.writeToFile(outputFile, result);
        } else {
            System.out.println(result);
        }
    }
}

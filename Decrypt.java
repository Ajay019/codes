import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Decrypt {

    public static void main(String[] args) {
        try {
            File file = new File("D:\\ajay\\Vishwactf\\encoded_key.txt");
            FileInputStream fis = new FileInputStream(file);
            byte[] key = new byte[(int) file.length()];
            fis.read(key);
            fis.close();

            String encryptedText = "u5FUKxDUxH9y8yxvfaaU+GSXDwvJS6QxlN/3udOEzpU6fIVUExjDLsB3LKqUTz/x"; // Put your encrypted text here

            String decryptedText = decrypt(encryptedText, key);
            System.out.println(decryptedText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String decrypt(String encryptedText, byte[] key) {
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i++) {
            decryptedText.append((char) decryptChar(encryptedText.charAt(i), key[i % key.length]));
        }
        return decryptedText.toString();
    }

    public static int decryptChar(char c, byte k) {
        return (int) c - (int) k;
    }
}

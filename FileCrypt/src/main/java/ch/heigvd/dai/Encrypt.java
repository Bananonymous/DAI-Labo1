package ch.heigvd.dai;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Security;
import java.util.Base64;

public class Encrypt {

    static {
        // Add Bouncy Castle as a security provider
        Security.addProvider(new BouncyCastleProvider());
    }

    public static void encrypt(String input, String output) throws Exception {
        // Generate AES Key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES", "BC");
        keyGen.init(256); // 256-bit AES
        SecretKey secretKey = keyGen.generateKey();

        // Create cipher instance and initialize it for encryption
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding", "BC");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Read the input file to encrypt
        byte[] inputBytes = Files.readAllBytes(Paths.get(input));

        // Perform encryption
        byte[] encryptedBytes = cipher.doFinal(inputBytes);

        // Write encrypted data to output file
        Files.write(Paths.get(output), encryptedBytes);

        // Optionally: Encode key to a string and print or store
        String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        System.out.println("Secret Key (Base64 encoded): " + encodedKey);
    }
}

package ch.heigvd.dai;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.security.Security;
import java.util.Base64;

public class Encrypt {

    static {
        // Add Bouncy Castle as a security provider
        Security.addProvider(new BouncyCastleProvider());
    }

    public static String encrypt(String input, String output) throws Exception {
        // Generate AES Key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES", "BC");
        keyGen.init(256); // 256-bit AES
        SecretKey secretKey = keyGen.generateKey();

        // Create cipher instance and initialize it for encryption
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding", "BC");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Read the input file to encrypt
        byte[] inputBytes;
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(input))) {
            inputBytes = bis.readAllBytes();
        }

        // Perform encryption
        byte[] encryptedBytes = cipher.doFinal(inputBytes);

        // Write encrypted data to output file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            writer.write(Base64.getEncoder().encodeToString(encryptedBytes));
        }

        // Optionally: Encode key to a string and print or store
        String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        System.out.println("Secret Key (Base64 encoded): " + encodedKey);
        return encodedKey;
    }
}
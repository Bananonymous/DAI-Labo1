package ch.heigvd.dai.encryption.decrypts;

import ch.heigvd.dai.encryption.Decryptable;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.security.Security;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Decrypt implements Decryptable {

  static {
    // Add Bouncy Castle as a security provider
    Security.addProvider(new BouncyCastleProvider());
  }

  @Override
  public void decrypt(String input, String output, String secretKey) throws Exception {
    // Decode the secret key
    byte[] decodedKey = Base64.getDecoder().decode(secretKey);
    SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");

    // Create cipher instance and initialize it for decryption
    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding", "BC");
    cipher.init(Cipher.DECRYPT_MODE, originalKey);

    // Read the input file to decrypt
    byte[] encryptedBytes;
    try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(input))) {
      encryptedBytes = Base64.getDecoder().decode(bis.readAllBytes());
    }
    // Perform decryption
    byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

    // Write decrypted data to output file
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
      writer.write(new String(decryptedBytes));
    }
  }
}

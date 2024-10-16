package ch.heigvd.dai.encryption.decrypts;

import ch.heigvd.dai.encryption.Decryptable;

public class Decrypt implements Decryptable {
  @Override
  public void decrypt(String input, String output, String secretKey) {
    System.out.println("You're in the decryption method");
  }
}

package ch.heigvd.dai.encryption;

public interface Decryptable {
  void decrypt(String input, String output, String secretKey);
}

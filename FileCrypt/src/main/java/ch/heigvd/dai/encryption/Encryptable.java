package ch.heigvd.dai.encryption;

public interface Encryptable {
  void encrypt(String input, String output) throws Exception;
}

package ch.heigvd.dai.encryption.encrypts;

import ch.heigvd.dai.encryption.Encryptable;
import picocli.CommandLine;

public class Encrypt implements Encryptable {
  @Override
  public void encrypt(
      @CommandLine.Parameters(index = "0", description = "The name of the input file.")
          String input,
      @CommandLine.Parameters(index = "1", description = "The name of the output file.")
          String output) {
    System.out.println("Your in the encryption mehtod");
  }
}

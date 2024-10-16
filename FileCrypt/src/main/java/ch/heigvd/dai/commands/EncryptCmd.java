package ch.heigvd.dai.commands;

import ch.heigvd.dai.encryption.Encryptable;
import ch.heigvd.dai.encryption.encrypts.Encrypt;
import java.util.concurrent.Callable;
import picocli.CommandLine;

@CommandLine.Command(name = "ENCRYPT", description = "Encrypt a file.")
public class EncryptCmd implements Callable<Integer> {
  @CommandLine.ParentCommand protected Root parent;

  @Override
  public Integer call() {
    Encryptable encrypter = new Encrypt();

    System.out.println(
        "Encrypting "
            + parent.getInputfilename()
            + " using Bouncycastle, output in "
            + parent.getOutputfilename());

    encrypter.encrypt(parent.getInputfilename(), parent.getOutputfilename());
    return 0;
  }
}

package ch.heigvd.dai.commands;

import ch.heigvd.dai.encryption.Decryptable;
import ch.heigvd.dai.encryption.decrypts.Decrypt;
import java.util.concurrent.Callable;
import picocli.CommandLine;

@CommandLine.Command(name = "DECRYPT", description = "Decrypt a file.")
public class DecryptCmd implements Callable<Integer> {
  @CommandLine.ParentCommand protected Root parent;

  @Override
  public Integer call() {
    Decryptable decrypter = new Decrypt();

    System.out.println(
        "Decrypting "
            + parent.getInputfilename()
            + " with key "
            + parent.getSecretkey()
            + " using Bouncycastle, output in "
            + parent.getOutputfilename());

    decrypter.decrypt(parent.getInputfilename(), parent.getOutputfilename(), parent.getSecretkey());
    return 0;
  }
}

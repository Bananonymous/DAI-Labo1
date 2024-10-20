package ch.heigvd.dai.commands;

import ch.heigvd.dai.encryption.Decryptable;
import ch.heigvd.dai.encryption.decrypts.Decrypt;
import java.util.concurrent.Callable;
import picocli.CommandLine;

@CommandLine.Command(name = "DECRYPT", description = "Decrypt a file.")
public class DecryptCmd implements Callable<Integer> {
  @CommandLine.ParentCommand protected Root parent;

  @CommandLine.Parameters(index = "0", description = "The deciphering key.")
  protected String secretKey;

  @Override
  public Integer call() throws Exception {
    Decryptable decrypter = new Decrypt();

    System.out.println(
        "Decrypting "
            + parent.getInputfilename()
            + " with key "
            + secretKey
            + " using Bouncycastle, output in "
            + parent.getOutputfilename());

    decrypter.decrypt(parent.getInputfilename(), parent.getOutputfilename(), secretKey);
    return 0;
  }
}

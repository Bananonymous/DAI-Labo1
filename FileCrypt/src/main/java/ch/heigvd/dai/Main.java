package ch.heigvd.dai;

import static ch.heigvd.dai.Decrypt.decrypt;
import static ch.heigvd.dai.Encrypt.encrypt;

public class Main {
  public static void main(String[] args) throws Exception {
    // get the arguments and check if they are correct
    if (args.length != 3) {
      System.out.println("Usage: java -jar FileCrypt.jar <mode> <input file> <output file>");
      System.exit(1);
    }

    String secretKey = encrypt(args[1], args[2]);

    decrypt(args[2], "./decrypted.txt", secretKey);





    // Create root command
//    Root root = new Root();
//    int exitCode =
//            new CommandLine(root)
//                    .setCommandName(jarFilename)
//                    .setCaseInsensitiveEnumValuesAllowed(true)
//                    .execute(args);

  }
}

package ch.heigvd.dai;

import picocli.CommandLine;
import ch.heigvd.dai.commands.Root;
import java.io.File;
import picocli.CommandLine;

public class Main {
  public static void main(String[] args) {
    // get the arguments and check if they are correct
    if (args.length != 3) {
      System.out.println("Usage: java -jar FileCrypt.jar <mode> <input file> <output file>");
      System.exit(1);
    }




    // Create root command
//    Root root = new Root();
//    int exitCode =
//            new CommandLine(root)
//                    .setCommandName(jarFilename)
//                    .setCaseInsensitiveEnumValuesAllowed(true)
//                    .execute(args);

  }
}

package ch.heigvd.dai;

import ch.heigvd.dai.commands.Root;
import java.io.File;
import picocli.CommandLine;

public class Main {
  public static void main(String[] args) {
    // get the arguments and check if they are correct
    /*if (args.length != 3) {
      System.out.println("Usage: java -jar FileCrypt.jar <mode> <input file> <output file>");
      System.exit(1);
    }*/

    // Define command name - source: https://stackoverflow.com/a/11159435
    String jarFilename =
        new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath())
            .getName();

    // Create root command
    Root root = new Root();

    // Run the command
    int exitCode =
        new CommandLine(root)
            .setCommandName(jarFilename)
            .setSubcommandsCaseInsensitive(true)
            .execute(args);
    System.exit(exitCode);
  }
}

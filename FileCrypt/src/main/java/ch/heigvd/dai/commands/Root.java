/*-
--- This Root Class is a modified version of the one we used in the practical content
--- for Java IOs of the DAI course. You can find the original here:
--- https://github.com/heig-vd-dai-course/heig-vd-dai-course-java-ios-practical-content-template/tree/main/src/main/java/ch/heigvd/dai/commands
 */
package ch.heigvd.dai.commands;

import picocli.CommandLine;

@CommandLine.Command(
    description =
        "A small CLI to experiment with encryption and decryption in Java through the Bouncycastle library.",
    version = "1.0.0",
    subcommands = {
      EncryptCmd.class,
      DecryptCmd.class,
    },
    scope = CommandLine.ScopeType.INHERIT,
    mixinStandardHelpOptions = true)
public class Root {
  @CommandLine.Parameters(index = "0", description = "The name of the input file.")
  protected String Inputfilename;

  @CommandLine.Parameters(index = "1", description = "The name of the output file.")
  protected String Outputfilename;

  @CommandLine.Option(
      names = {"-k", "--key"},
      description = "The secret key to decrypt the file.")
  protected String Secretkey;

  public String getInputfilename() {
    return Inputfilename;
  }

  public String getOutputfilename() {
    return Outputfilename;
  }

  public String getSecretkey() {
    return Secretkey;
  }
}

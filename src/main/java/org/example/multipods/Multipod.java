package org.example.multipods;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

public class Multipod {
  protected static String image;
  protected static String tech;

  public static void main(String[] args) throws ArgumentParserException {
    ArgumentParser parser = commandParser();
    parseCmdArgs(parser, args);
  }

  public static ArgumentParser commandParser() {
    ArgumentParser parser = ArgumentParsers.newFor("Multipod").build()
            .defaultHelp(true)
            .description("Multipod - Command Line Options");
    parser.addArgument("--run")
            .type(String.class)
            .help("Name and Tag of the image to run (Example: mongo:10.0)");
    parser.addArgument("--pull")
            .type(String.class)
            .help("Name and Tag of the image to pull (Example: mongo:10.0)");
    parser.addArgument("--technology")
            .type(String.class)
            .help("Technology to use for virtualization of the image (Docker or Podman)");

    return parser;
  }

  public static void parseCmdArgs(ArgumentParser parser, String[] args) throws ArgumentParserException {
    Namespace ns = parser.parseArgs(args);
    image = ns.getString("run");
    image = ns.getString("pull");
    tech = ns.getString("technology");
  }
}

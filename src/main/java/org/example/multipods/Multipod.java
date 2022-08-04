package org.example.multipods;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.impl.Arguments;
import net.sourceforge.argparse4j.inf.*;

public class Multipod {
  protected static String image;
  protected static String tech;

  public static void main(String[] args){
    ArgumentParser parser = commandParser();
    try {
      parseCmdArgs(parser, args);
    }
    catch (ArgumentParserException error){
      System.err.println(error);
    }

  }

  public static ArgumentParser commandParser() {
    ArgumentParser parser = ArgumentParsers.newFor("Multipod").build()
            .defaultHelp(true)
            .description("Multipod - Command Line Options");

    Subparsers subparsers = parser.addSubparsers().help("sub-command help");
    Subparser parserRun = subparsers.addParser("run").help("Use this command to run a pod image");
    parserRun.addArgument("image").type(String.class)
            .help("Enter Name and Tag of the image to run (Example: mongo:10.0)");
    Subparser parserPull = subparsers.addParser("pull").help("Use this command to pull a pod image");
    parserPull.addArgument("image").type(String.class)
            .help("Enter Name and Tag of the image to pull (Example: mongo:10.0)");
    parser.addArgument("--technology")
            .type(String.class)
            .help("Technology to use for virtualization of the image (Docker or Podman)");

    return parser;
  }

  public static void parseCmdArgs(ArgumentParser parser, String[] args) throws ArgumentParserException {
    Namespace ns = parser.parseArgs(args);
    //parser.
    //image = ns.getString("run");
    //image = ns.getString("pull");
    //tech = ns.getString("technology");
  }
}

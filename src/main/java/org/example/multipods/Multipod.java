package org.example.multipods;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.impl.Arguments;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;
import net.sourceforge.argparse4j.inf.Subparsers;
import org.example.multipods.docker.DockerFactory;
import org.example.multipods.podman.PodmanFactory;

enum Command {
  PULL,
  RUN
}

/**
 * Clase Multipod que se utiliza para analizar la línea de comandos.
 */
public class Multipod {
  protected static String image;
  protected static String tech;

  /**
   * Method main .
   */
  public static void main(String[] args) {
    ArgumentParser parser = commandParser();
    try {
      Namespace ns = parser.parseArgs(args);

      System.out.println(ns);

      Command command = ns.get("command");
      String imageName = ns.getString("image");
      String imageTag = ns.getString("tag");
      ContainerTechnology technology = ns.get("technology");

      ContainerFactory factory;

      // factory selector
      switch (technology){
        case PODMAN:
          factory = new PodmanFactory();
          break;

        default:
          factory = new DockerFactory();
          break;
      }

      PodManager manager = PodManager.getInstance();

      // command selector
      switch (command){
        case RUN:
          manager.runController(factory, imageName, imageTag);
          break;

        case PULL:
          manager.pullPodImage(factory, imageName, imageTag);
          break;
      }


    } catch (ArgumentParserException error) {
      System.err.println(error);
    }

  }

  /**
   * Static method commandParser .
   */
  public static ArgumentParser commandParser() {
    ArgumentParser parser = ArgumentParsers.newFor("Multipod").build()
            .defaultHelp(true)
            .description("Multipod - Command Line Options");

    Subparsers subparsers = parser.addSubparsers()
            .help("sub-command help");

    // run subparser

    Subparser parserRun = subparsers
            .addParser("run")
            .setDefault("command", Command.RUN)
            .help("Use this command to run a pod image");

    parserRun.addArgument("image")
            .type(String.class)
            .help("Image name");
    parserRun.addArgument("tag")
            .type(String.class)
            .setDefault("latest")
            .required(false)
            .help("Image tag");

    // pull subparser

    Subparser parserPull = subparsers.addParser("pull")
            .setDefault("command", Command.PULL)
            .help("Use this command to pull a pod image");

    parserPull.addArgument("image")
            .type(String.class)
            .help("Image name");
    parserPull.addArgument("tag")
            .type(String.class)
            .setDefault("latest")
            .required(false)
            .help("Image tag");


    parser.addArgument("-T", "--technology")
            .type(ContainerTechnology.class)
            .choices(ContainerTechnology.values()).setDefault(ContainerTechnology.DOCKER)
            .help("Container technology to use for virtualization of the image.");

    return parser;
  }
}

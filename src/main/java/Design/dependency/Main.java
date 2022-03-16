package Design.dependency;

import Design.dependency.CommandExecutor.CommandProcessor;
import Design.dependency.CommandExecutor.impl.CommandProcessorImpl;

import java.util.Scanner;

/**
 * The entry point for the Test program
 */
public class Main {

    public static void main(String[] args) {

        //read input from stdin
        Scanner scan = new Scanner(System.in);
        CommandProcessor commandProcessor = (CommandProcessor) new CommandProcessorImpl();
        while (true) {
            String line = scan.nextLine();

            //no action for empty input
            if (line == null || line.length() == 0) {
                continue;
            }

            //the END command to stop the program
            if ("END".equals(line)) {
                System.out.println("END");
                break;
            }

            commandProcessor.process(line);

            //Please provide your implementation here

        }

    }
}
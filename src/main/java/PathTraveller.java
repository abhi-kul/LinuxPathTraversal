import command.Command;
import command.impl.CDCommand;
import command.impl.LSCommand;
import command.impl.MKDIRCommand;
import command.impl.PWDCommand;
import command.impl.RMCommand;
import command.impl.SessionCommand;
import model.CommandName;
import util.ApplicationConstants;
import util.Logger;

import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

/*
Driver class to perform all the operations.
*/

public class PathTraveller {
    static String root;
    public static void main(String [] args) throws IOException {
        System.out.println("Linux Path Traversal Started...");
        String baseDirectory = ApplicationConstants.DIRECTORY_SEPERATOR;
        Command.dirs.put(baseDirectory, new TreeSet<String>());
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (!command.isEmpty()) {
                if (CommandName.exit.name().equalsIgnoreCase(command)) {
                    break;
                }
                String[] split = command.split(" ");
                if (CommandName.pwd.name().equalsIgnoreCase(split[0])) {
                    Command cmd = new PWDCommand();
                    cmd.apply(baseDirectory, "");
                    continue;
                }
                if (CommandName.mkdir.name().equalsIgnoreCase(split[0])) {
                    Command cmd = new MKDIRCommand();
                    cmd.apply(baseDirectory, split[1]);
                    continue;
                }
                if (CommandName.ls.name().equalsIgnoreCase(split[0])) {
                    Command cmd = new LSCommand();
                    cmd.apply(baseDirectory, "");
                    continue;
                }
                if (CommandName.cd.name().equalsIgnoreCase(split[0])) {
                    Command cmd = new CDCommand();
                    baseDirectory = cmd.apply(baseDirectory, split[1]);
                    continue;
                }
                if (CommandName.rm.name().equalsIgnoreCase(split[0])) {
                    Command cmd = new RMCommand();
                    baseDirectory = cmd.apply(baseDirectory, split[1]);
                    continue;
                }
                if (CommandName.session.name().equalsIgnoreCase(split[0])) {
                    Command cmd = new SessionCommand();
                    baseDirectory = cmd.apply(root,split[1]);
                    continue;
                }
                Logger.logger(ApplicationConstants.UNRECOGNIZE_INPUT_ERROR);
            }
        }
    }


}

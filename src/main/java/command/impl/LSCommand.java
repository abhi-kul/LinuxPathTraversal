package command.impl;

import command.Command;
import util.ApplicationConstants;
import util.Logger;

import java.util.Set;

/*
Class responsible to list out all the child directories.
 */
public class LSCommand implements Command {

    @Override
    public String apply(String root, String arg) {
        Set<String> strings = dirs.get(root);
        String log = "";
        for (String dir : strings) {
            log = log.concat(dir.concat(ApplicationConstants.SPACE));
        }
        Logger.logger(ApplicationConstants.DIRS.concat(ApplicationConstants.COLON.concat(log)));
        return ApplicationConstants.SUCCESS;
    }
}

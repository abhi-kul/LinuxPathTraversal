package command.impl;

import command.Command;
import util.ApplicationConstants;
import util.Logger;

/*
Class responsible to perform change directory operation.
 */
public class CDCommand implements Command {

    @Override
    public String apply(String root, String arg) {
        if (arg.equals(ApplicationConstants.DIRECTORY_SEPERATOR)){
            Logger.logger(ApplicationConstants.SUCCESS_REACHED_MESSAGE);
            return arg;
        }
        if (arg.startsWith(ApplicationConstants.DIRECTORY_SEPERATOR) && (dirs.containsKey(arg) | dirs.containsKey(arg.concat(ApplicationConstants.DIRECTORY_SEPERATOR)))){
            Logger.logger(ApplicationConstants.SUCCESS_REACHED_MESSAGE);
            return arg;
        }
        if(dirs.containsKey(root.concat(arg.concat(ApplicationConstants.DIRECTORY_SEPERATOR)))) {
            Logger.logger(ApplicationConstants.SUCCESS_REACHED_MESSAGE);
            return root.concat(arg.concat(ApplicationConstants.DIRECTORY_SEPERATOR));
        }
        Logger.logger(ApplicationConstants.INVALID_PATH_ERROR);
        return root;
    }
}

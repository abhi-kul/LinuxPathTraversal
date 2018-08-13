package command.impl;

import command.Command;
import util.ApplicationConstants;
import util.Logger;

/*
Class responsible to show the current path of the directory.
 */
public class PWDCommand implements Command {

    @Override
    public String apply(String root, String args) {
        Logger.logger(ApplicationConstants.PATH.concat(ApplicationConstants.COLON).concat(root));
        return ApplicationConstants.SUCCESS;
    }
}

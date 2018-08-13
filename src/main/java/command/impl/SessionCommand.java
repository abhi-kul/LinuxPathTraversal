package command.impl;

import command.Command;
import util.ApplicationConstants;
import util.Logger;

import java.util.TreeSet;

/*
Class responsible to clear everything and again set the application to root level.
 */
public class SessionCommand implements Command {

    @Override
    public String apply(String root, String args) {
        Command.dirs.clear();
        Command.dirs.put(ApplicationConstants.DIRECTORY_SEPERATOR, new TreeSet<String>());
        Logger.logger(ApplicationConstants.SESSION_CLEAR_MESSAGE);
        return ApplicationConstants.DIRECTORY_SEPERATOR;
    }
}

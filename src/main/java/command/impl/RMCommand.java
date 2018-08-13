package command.impl;

import command.Command;
import util.ApplicationConstants;
import util.Logger;

import java.util.Set;


/*
Class responsible for removing the directories.
*/
public class RMCommand implements Command {

    @Override
    public String apply(String root, String arg) {

            if (root.equalsIgnoreCase(arg)) {
                Logger.logger(ApplicationConstants.INVALID_PATH_ERROR);
                return root;
            }
            if (arg.startsWith(ApplicationConstants.DIRECTORY_SEPERATOR)){
            String[] split = arg.split(ApplicationConstants.DIRECTORY_SEPERATOR);
            String tempFolder = "";
            for (int i =1 ; i < split.length ; i++) {
                tempFolder = tempFolder.concat(ApplicationConstants.DIRECTORY_SEPERATOR.concat(split[i]));
                if(i==split.length-1){
                    Set<String> directories = dirs.get(tempFolder.replace(split[i],""));
                    directories.remove(split[i]);
                    dirs.remove(arg);
                    Logger.logger(ApplicationConstants.SUCCESS_DELETE_MESSAGE);
                    return root;
                }
                if(!dirs.containsKey(tempFolder.concat(ApplicationConstants.DIRECTORY_SEPERATOR))){
                    Logger.logger(ApplicationConstants.INVALID_PATH_ERROR);
                    return root;
                }
            }
        }
        if (!root.equalsIgnoreCase(arg)){
            if (dirs.containsKey(root.concat(arg.concat(ApplicationConstants.DIRECTORY_SEPERATOR)))) {
                dirs.remove(arg);
                dirs.get(root).remove(arg);
                Logger.logger(ApplicationConstants.SUCCESS_DELETE_MESSAGE);
                return root;
            }
        }
        Logger.logger(ApplicationConstants.INVALID_PATH_ERROR);
        return root;
    }
}

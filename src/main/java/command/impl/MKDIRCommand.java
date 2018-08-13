package command.impl;

import command.Command;
import util.ApplicationConstants;
import util.Logger;

import java.util.Set;
import java.util.TreeSet;

/*
This class is responsible to create a new directory.
 */
public class MKDIRCommand implements Command {

    @Override
    public String apply(String root, String arg) {
        if (arg.startsWith(ApplicationConstants.DIRECTORY_SEPERATOR)){
            String[] split = arg.split(ApplicationConstants.DIRECTORY_SEPERATOR);
            String tempFolder = "";
            for (int i =0 ; i < split.length ; i++) {
                tempFolder = tempFolder.concat(ApplicationConstants.DIRECTORY_SEPERATOR.concat(split[i]));
                if(i==split.length-1){
                    if (dirs.containsKey(tempFolder)) {
                        Logger.logger(ApplicationConstants.DUPLICATE_DIRECTORY_ERROR);
                        return ApplicationConstants.SUCCESS;
                    }

                    dirs.put(tempFolder, new TreeSet<String>());
                    Set<String> strings1 = dirs.get(tempFolder.replace(ApplicationConstants.DIRECTORY_SEPERATOR+split[i],""));
                    strings1.add(split[i]);
                    Logger.logger(ApplicationConstants.SUCCESS_CREATED_MESSAGE);
                    return ApplicationConstants.SUCCESS;

                }
                if(!dirs.containsKey(tempFolder)){
                    Logger.logger(ApplicationConstants.INVALID_PATH_ERROR);
                    return ApplicationConstants.ERROR;
                }
            }
        }
        if (dirs.containsKey(root.concat(arg.concat(ApplicationConstants.DIRECTORY_SEPERATOR)))) {
            Logger.logger(ApplicationConstants.DUPLICATE_DIRECTORY_ERROR);
            return ApplicationConstants.DUPLICATE_DIRECTORY_ERROR;
        }
        dirs.put(root.concat(arg.concat(ApplicationConstants.DIRECTORY_SEPERATOR)), new TreeSet<String>());
        Set<String> strings1 = dirs.get(root);
        strings1.add(arg);
        Logger.logger(ApplicationConstants.SUCCESS_CREATED_MESSAGE);
        return ApplicationConstants.SUCCESS;

    }


}

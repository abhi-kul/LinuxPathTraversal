package command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
Interface for all the commands. Whenever there is a need to support a new command corresponding command class
needs to implement this Interface.
*/
public interface Command {

    Map<String,Set<String>> dirs = new HashMap<>();

    String apply(String root, String args) throws IOException;

}

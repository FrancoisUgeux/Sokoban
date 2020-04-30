package esi.atl.g43335.sokoban.model;

/**
 *
 * @author franc
 */
public interface Command {

    /**
     * Execute a commands.
     */
    void execute();

    /**
     * Undo the last command.
     */
    void unexecute();

    /**
     *
     * @return a string saying what is the last move of Soko
     */
    String getString();
}

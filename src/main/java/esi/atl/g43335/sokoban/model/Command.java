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
}

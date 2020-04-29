package esi.atl.g43335.sokoban.model;

import javafx.beans.Observable;

/**
 *
 * @author franc
 */
public interface Model extends Subject {

    /**
     *
     * @return the number of moves made by Soko.
     */
    int getNbMoves();

    /**
     *
     * @return the maze.
     */
    Maze getMaze();

    /**
     *
     * @param level is the level to play.
     */
    void start(int level);

    /**
     *
     * @return true if this level is over.
     */
    boolean isOver();

    /**
     * Check if there is a goal on this position
     *
     * @param p is a position to check.
     * @return true if there is a goal.
     */
    boolean isGoal(Position p);

    /**
     *
     */
    void restart();

    /**
     * Increment the level number.
     */
    void nextLevel();

    /**
     * Create the commands to move the items in the maze.
     *
     * @param next is the direction where Soko want to go.
     */
    void move(Direction next);

    /**
     * Check if the item on a position can move on the cell in the given
     * direction.
     *
     * @param pos is the starting position
     * @param dir the direction the item should move
     * @return true if the item can be placed in that direction.
     */
    public boolean canMove(Position pos, Direction dir);

    /**
     * undo the last command.
     */
    void undo();

    /**
     * Redo the last command. so undo the last undo.
     */
    void redo();

}

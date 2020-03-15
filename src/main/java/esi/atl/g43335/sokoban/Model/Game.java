package esi.atl.g43335.sokoban.model;

import esi.atl.g43335.sokoban.Model.commands.moveCommand;
import esi.atl.g43335.sokoban.Model.commands.moveCommandPB;
import esi.atl.g43335.sokoban.model.items.*;
import java.util.ArrayList;
import java.util.Stack;

/**
 * This class deal with the game's mechanics
 *
 * @author franc
 */
public class Game implements Model {

    private int nbMoves;
    private Maze maze;
    private int currentLevel;
    private Position sokoPos;
    private final Stack<Commands> undoStack;
    private final Stack<Commands> redoStack;

    /**
     *
     * @param nbMoves is the number of moves made by Soko
     */
    public Game(int nbMoves) {
        this.nbMoves = nbMoves;
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    @Override
    public int getNbMoves() {
        return nbMoves;
    }

    @Override
    public Maze getMaze() {
        return maze;
    }

    @Override
    public void start(int level) {
        maze = new Maze();
        sokoPos = maze.getStart();
    }

    @Override
    public String getCurrentLevel() {
        return " ";
    }


    @Override
    public boolean isOver() {
        ArrayList<Position> boxes = maze.getBoxes();
        for (Position box : boxes) {
            if (!isGoal(box)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isGoal(Position p) {
        return maze.isGoal(p);
    }

    @Override
    public void giveUp() {

    }

    @Override
    public void restart() {

    }

    @Override
    public void nextLevel() {
        currentLevel++;
    }

    @Override
    public void move(Direction dir) {
        Position target = sokoPos.next(dir);
        Item item = maze.getCell(sokoPos).getItem();
        if (maze.isFree(target) || maze.isGoal(target)) {
            Commands command = new moveCommand(maze, sokoPos, target, item, nbMoves);
            command.execute();
            undoStack.push(command);
            sokoPos = target;       //setStart dans maze ?
            nbMoves++;
        } else if (canMove(target, dir)) {
            Commands command = new moveCommandPB(maze, sokoPos, target, item, dir, nbMoves);
            command.execute();
            undoStack.push(command);
            sokoPos = target;
            nbMoves++;
        }
    }

    /**
     * Check if the item on a position can move on the cell in the given
     * direction.
     *
     * @param pos is the starting position
     * @param dir the direction the item should move
     * @return true if the item can be placed in that direction.
     */
    @Override
    public boolean canMove(Position pos, Direction dir) {
        return (maze.isFree(pos.next(dir)) || maze.isGoal(pos.next(dir)));
    }

    @Override
    public void undo() {
        redoStack.push(undoStack.peek());
        undoStack.pop().unexecute();
    }

    @Override
    public void redo() {
        undoStack.push(redoStack.peek());
        redoStack.pop().execute();
    }
}

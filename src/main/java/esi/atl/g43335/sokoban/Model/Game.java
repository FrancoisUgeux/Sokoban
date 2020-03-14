package esi.atl.g43335.sokoban.model;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author franc
 */
public class Game {

    private final int nbMoves;
    private Maze maze;
    private int currentLevel;
    private Position sokoPos;
    private final Stack<Commands> undoStack;
    private final Stack<Commands> redoStack;

    public Game(int nbMoves) {
        this.nbMoves = nbMoves;
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public int getNbMoves() {
        return nbMoves;
    }

    public Maze getMaze() {
        return maze;
    }

    public void start(int level) {
        maze = new Maze();
        sokoPos = maze.getStart();
    }

    public String getCurrentLevel() {
        return " ";
    }

    public boolean isOver() {
        ArrayList<Position> boxes = maze.getBoxes();
        for (Position box : boxes) {
            if (!isGoal(box)) {
                return false;
            }
        }
        return true;
    }

    public boolean isGoal(Position p) {
        return maze.isGoal(p);
    }

    public void giveUp() {

    }

    public void restart() {

    }

    public void nextLevel() {
        currentLevel++;
    }

    public void move(Direction dir) {
        Position target = sokoPos.next(dir);
        if (maze.isFree(target)) {
            maze.put(maze.getCell(sokoPos).getItem(), target);
            maze.remove(sokoPos);
        } else if (maze.isBox(target)) {
            if (canMove(target)) {
                maze.put(maze.getCell(target).getItem(), target.next(dir));
                maze.remove(target);
                maze.put(maze.getCell(sokoPos).getItem(), target);
                maze.remove(sokoPos);
            }
        }
        sokoPos = target;
    }

    public boolean canMove(Position pos) {
        return (maze.isFree(pos) || maze.isGoal(pos));
    }

    public void undo() {
        redoStack.push(undoStack.peek());
        undoStack.pop().unexecute();
    }

    public void redo() {
        redoStack.pop().execute();
        undoStack.push(redoStack.peek());
    }
}

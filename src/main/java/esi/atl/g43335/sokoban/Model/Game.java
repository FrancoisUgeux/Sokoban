package esi.atl.g43335.sokoban.model;

import esi.atl.g43335.sokoban.Model.commands.moveCommand;
import esi.atl.g43335.sokoban.Model.commands.moveCommandPB;
import esi.atl.g43335.sokoban.model.items.*;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author franc
 */
public class Game {

    private int nbMoves;
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

    public boolean canMove(Position pos, Direction dir) {
        return (maze.isFree(pos.next(dir)) || maze.isGoal(pos.next(dir)));
    }

    public void moveBoxGoal(Position start, Position target, Direction dir) {
        if (canMove(target, dir)) {
            if (maze.isGoal(target.next(dir))) {
                maze.put(new SokoGoal(), target.next(dir));
                maze.remove(target);
                maze.put(maze.getCell(start).getItem(), target);
                sokoPos = target;
                nbMoves++;
            } else if (maze.isFree(target.next(dir))) {
                maze.put(new Box(), target.next(dir));
                maze.remove(target);
                maze.put(new SokoGoal(), target);
                sokoPos = target;
                nbMoves++;
            }
            maze.remove(start);
        }

    }

    public void moveBox(Position start, Position target, Direction dir) {
        if (canMove(target, dir)) {
            if (maze.isGoal(target.next(dir))) {
                maze.put(new BoxGoal(), target.next(dir));
                maze.remove(target);
                sokoPos = target;
                nbMoves++;
            } else {
                maze.put(maze.getCell(target).getItem(), target.next(dir));
                maze.remove(target);
                sokoPos = target;
                nbMoves++;
            }
            maze.put(maze.getCell(start).getItem(), target);
            maze.remove(start);
        }
    }

    public void undo() {
        redoStack.push(undoStack.peek());
        undoStack.pop().unexecute();
    }

    public void redo() {
        undoStack.push(redoStack.peek());
        redoStack.pop().execute();
    }
}

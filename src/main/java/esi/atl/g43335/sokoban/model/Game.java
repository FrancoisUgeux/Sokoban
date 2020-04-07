package esi.atl.g43335.sokoban.model;

import esi.atl.g43335.sokoban.model.commands.moveCommand;
import esi.atl.g43335.sokoban.model.commands.moveCommandPB;
import java.util.ArrayList;
import java.util.Objects;
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
    private final Stack<Command> undoStack;
    private final Stack<Command> redoStack;

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

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setNbMoves(int nbMoves) {
        this.nbMoves = nbMoves;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.nbMoves;
        hash = 89 * hash + Objects.hashCode(this.maze);
        hash = 89 * hash + this.currentLevel;
        hash = 89 * hash + Objects.hashCode(this.sokoPos);
        hash = 89 * hash + Objects.hashCode(this.undoStack);
        hash = 89 * hash + Objects.hashCode(this.redoStack);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (this.nbMoves != other.nbMoves) {
            return false;
        }
        if (this.currentLevel != other.currentLevel) {
            return false;
        }
        if (!Objects.equals(this.maze, other.maze)) {
            return false;
        }
        if (!Objects.equals(this.sokoPos, other.sokoPos)) {
            return false;
        }
        if (!Objects.equals(this.undoStack, other.undoStack)) {
            return false;
        }
        if (!Objects.equals(this.redoStack, other.redoStack)) {
            return false;
        }
        return true;
    }

    @Override
    public void start(int level) {
        maze = new Maze();
        maze.chooseLevel(level);
        currentLevel = level;
        sokoPos = maze.getStart();
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
    public void restart() {
        start(currentLevel);
        nbMoves = 0;
    }

    @Override
    public void nextLevel() {
        currentLevel++;
        nbMoves = 0;
        start(currentLevel);
    }

    @Override
    public void move(Direction dir) {
        sokoPos = maze.getStart();
        Position target = sokoPos.next(dir);
        Item item = maze.getCell(sokoPos).getItem();
        if (maze.isFree(target) || maze.isGoal(target)) {
            Command command = new moveCommand(maze, sokoPos, target, item, nbMoves);
            command.execute();
            undoStack.push(command);
            redoStack.clear();
            // maze.setStart(target);
            nbMoves++;
        } else if (canMove(target, dir) && maze.getCell(target).getItem().
                getType() != ItemType.WALL) {
            Command command = new moveCommandPB(maze, sokoPos, target, item, dir, nbMoves);
            command.execute();
            undoStack.push(command);
            redoStack.clear();
            // maze.setStart(target);
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

    public boolean undoStackEmpty() {
        return undoStack.empty();
    }

    public boolean redoStackEmpty() {
        return redoStack.empty();
    }
}

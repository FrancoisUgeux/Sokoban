package esi.atl.g43335.sokoban.model;

import esi.atl.g43335.sokoban.model.commands.moveCommand;
import esi.atl.g43335.sokoban.model.commands.moveCommandPB;
import java.util.ArrayList;
import java.util.List;
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
    private final List<Observer> observers;
    private boolean surrend;

    /**
     *
     * @param nbMoves is the number of moves made by Soko
     */
    public Game() {
        this.nbMoves = 0;
        undoStack = new Stack<>();
        redoStack = new Stack<>();
        this.observers = new ArrayList<>();
        surrend = false;
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

    public int getNbGoals() {
        return maze.getNbGoals();
    }

    public int getMaxNbGoals() {
        return maze.getMaxNbGoals();
    }

    public void setNbMoves(int nbMoves) {
        this.nbMoves = nbMoves;
    }

    public Stack<Command> getUndoStack() {
        return undoStack;
    }

    public Stack<Command> getRedoStack() {
        return redoStack;
    }

    @Override
    public boolean isSurrend() {
        return surrend;
    }

    public void setSurrend() {
        surrend = true;
        notifyObservers();
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
        nbMoves = 0;
        surrend = false;
        maze = new Maze();
        maze.chooseLevel(level);
        currentLevel = level;
        sokoPos = maze.getStart();
        notifyObservers();
    }

    @Override
    public boolean isOver() {
        return maze.getNbGoals() == 0;
    }

    @Override
    public boolean isGoal(Position p) {
        return maze.isGoal(p);
    }

    @Override
    public void restart() {
        nbMoves = 0;
        undoStack.clear();
        start(currentLevel);
    }

    @Override
    public void nextLevel() {
        currentLevel++;
        nbMoves = 0;
        undoStack.clear();
        redoStack.clear();
        start(currentLevel);
    }

    @Override
    public void move(Direction dir) {
        sokoPos = maze.getStart();
        Position target = sokoPos.next(dir);
        Item item = maze.getCell(sokoPos).getItem();
        if (maze.isFree(target) || (maze.isGoal(target) && !maze.isBoxGoal(target))) {
            Command command = new moveCommand(maze, sokoPos, target, item, nbMoves, this);
            command.execute();
            undoStack.push(command);
            redoStack.clear();
        } else if (canMove(target, dir) && maze.getCell(target).getItem().
                getType() != ItemType.WALL && !maze.isBoxGoal(target.next(dir))) {
            Command command = new moveCommandPB(maze, sokoPos, target, item, dir, nbMoves, this);
            command.execute();
            undoStack.push(command);
            redoStack.clear();
        }
        notifyObservers();
    }

    @Override
    public boolean canMove(Position pos, Direction dir) {
        return (maze.isFree(pos.next(dir)) || maze.isGoal(pos.next(dir)));
    }

    @Override
    public void undo() {
        redoStack.push(undoStack.peek());
        undoStack.pop().unexecute();
        notifyObservers();
    }

    @Override
    public void redo() {
        undoStack.push(redoStack.peek());
        redoStack.pop().execute();
        notifyObservers();
    }

    @Override
    public boolean undoStackEmpty() {
        return undoStack.empty();
    }

    @Override
    public boolean redoStackEmpty() {
        return redoStack.empty();
    }

    @Override
    public void registerObserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void remove(Observer obs) {
        observers.remove(obs);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update);
    }
}

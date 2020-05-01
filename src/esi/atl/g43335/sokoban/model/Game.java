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
    private final int MAX_STACK_SIZE = 40;

    /**
     *
     * @param nbMoves is the number of moves made by Soko
     */
    public Game(int nbMoves) {
        this.nbMoves = nbMoves;
        undoStack = new Stack<>();
        redoStack = new Stack<>();
        this.observers = new ArrayList<>();
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
            fillUndoStackCommand(command);
            redoStack.clear();
            nbMoves++;
        } else if (canMove(target, dir) && maze.getCell(target).getItem().
                getType() != ItemType.WALL) {
            Command command = new moveCommandPB(maze, sokoPos, target, item, dir, nbMoves, this);
            command.execute();
            fillUndoStackCommand(command);
            redoStack.clear();
            nbMoves++;
        }
        notifyObservers();
    }

    @Override
    public boolean canMove(Position pos, Direction dir) {
        return (maze.isFree(pos.next(dir)) || maze.isGoal(pos.next(dir)));
    }

    @Override
    public void undo() {
        fillRedoStackPeek();
        undoStack.pop().unexecute();
        notifyObservers();
    }

    @Override
    public void redo() {
        fillUndoStackPeek();
        redoStack.pop().execute();
        notifyObservers();
    }

    public boolean undoStackEmpty() {
        return undoStack.empty();
    }

    public boolean redoStackEmpty() {
        return redoStack.empty();
    }

    private void fillUndoStackCommand(Command command) {
        if (undoStack.size() <= MAX_STACK_SIZE) {
            undoStack.push(command);
        } else {
            undoStack.remove(undoStack.firstElement());
            undoStack.push(command);
        }
    }

    private void fillUndoStackPeek() {
        if (undoStack.size() <= MAX_STACK_SIZE) {
            undoStack.push(redoStack.peek());
        } else {
            undoStack.remove(undoStack.firstElement());
            undoStack.push(redoStack.peek());
        }
    }

    private void fillRedoStackPeek() {
        if (redoStack.size() <= MAX_STACK_SIZE) {
            redoStack.push(undoStack.peek());
        } else {
            redoStack.remove(undoStack.firstElement());
            redoStack.push(undoStack.peek());
        }
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

package esi.atl.g43335.sokoban.model.commands;

import esi.atl.g43335.sokoban.model.*;
import esi.atl.g43335.sokoban.model.items.*;

/**
 *
 * @author franc This class apply a move when a box is involved. The player and
 * can move on the floor or on a goal. The list of option help to recognize the
 * different situation ex: player/box move from goal to floor is != player/box
 * moving from floor to floor.
 */
public class moveCommandPB implements Command {

    private final Game game;
    private final Maze maze;
    private final Position start;
    private final Position target;
    private final Direction dir;
    private int nbMoves;
    private int nbGoals;
    private int option;
    private String string;

    /**
     *
     * @param maze The current level.
     * @param start The position of Soko before the move.
     * @param target The position Soko want to move on.
     * @param item Soko.
     * @param dir The direction in which Soko want to move.
     * @param nbMoves The number of moves already made by Soko
     * @param game
     */
    public moveCommandPB(Maze maze, Position start, Position target,
            Item item, Direction dir, int nbMoves, Game game) {
        this.game = game;
        this.maze = maze;
        this.start = start;
        this.target = target;
        this.dir = dir;
        this.nbMoves = nbMoves;
        nbGoals = maze.getNbGoals();

    }

    /**
     * execute the move command with a box. depending on: player pushing box
     * from a goal to another goal. player pushing box from a goal to floor.
     * player pushing box from floor to goal. player pushing box from floor to
     * another goal.
     */
    @Override
    public void execute() {
        if (maze.isBoxGoal(target)) {
            if (maze.isGoal(target.next(dir))) {
                boxGoalToGoal();
            } else {
                boxGoalToFloor();
            }
        } else {
            if (maze.isGoal(target.next(dir))) {
                boxToGoal();
            } else {
                boxToFloor();
            }
        }
        sokoMove();
        maze.setStart(target);
        game.setNbMoves(++nbMoves);
    }

    /**
     * used to undo the last move using a box.
     */
    @Override
    public void unexecute() {
        switch (option) {
            case 0:
                undoStartSokoGoal();
                maze.put(new BoxGoal(), target);
                maze.put(new Goal(), target.next(dir));
                break;
            case 1:
                undoStartSokoGoal();
                maze.put(new BoxGoal(), target);
                maze.remove(target.next(dir));
                maze.setNbGoals(--nbGoals);
                break;
            case 2:
                undoStartSokoGoal();
                maze.put(new Box(), target);
                maze.put(new Goal(), target.next(dir));
                maze.setNbGoals(++nbGoals);
                break;
            case 3:
                undoStartSokoGoal();
                maze.put(new Box(), target);
                maze.remove(target.next(dir));
                break;
        }
        maze.setStart(start);
        game.setNbMoves(--nbMoves);
    }

    private void boxGoalToGoal() {
        maze.put(new BoxGoal(), target.next(dir));
        maze.put(new SokoGoal(), target);
        startSokoGoal();
        option = 0;
    }

    private void boxGoalToFloor() {
        maze.put(new Box(), target.next(dir));
        maze.put(new SokoGoal(), target);
        startSokoGoal();
        maze.setNbGoals(++nbGoals);
        option = 1;
    }

    private void boxToGoal() {
        maze.put(new BoxGoal(), target.next(dir));
        maze.put(new Player(), target);
        maze.setNbGoals(--nbGoals);
        startSokoGoal();
        option = 2;
    }

    private void boxToFloor() {
        maze.put(new Box(), target.next(dir));
        maze.put(new Player(), target);
        startSokoGoal();
        option = 3;
    }

    private void startSokoGoal() {
        if (maze.isSokoGoal(start)) {
            maze.put(new Goal(), start);
        } else {
            maze.remove(start);
        }
    }

    private void undoStartSokoGoal() {
        if (maze.isGoal(start)) {
            maze.put(new SokoGoal(), start);
        } else {
            maze.put(new Player(), start);
        }
    }

    @Override
    public String getString() {
        return string;
    }

    private void sokoMove() {
        if (start.getColumn() > target.getColumn()) {
            string = "soko pushing box on left";
        } else if (start.getColumn() < target.getColumn()) {
            string = "soko pushing box on right";
        } else if (start.getRow() > target.getRow()) {
            string = "soko pushing box up";
        } else {
            string = "soko pushing box down";
        }
    }
}

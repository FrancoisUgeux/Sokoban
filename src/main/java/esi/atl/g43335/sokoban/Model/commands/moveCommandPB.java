package esi.atl.g43335.sokoban.model.commands;

import esi.atl.g43335.sokoban.model.*;
import esi.atl.g43335.sokoban.model.items.*;
import java.util.ArrayList;

/**
 *
 * @author franc This class apply a move when a box is involved. The player and
 * can move on the floor or on a goal. The list of option help to recognize the
 * different situation ex: player/box move from goal to floor is != player/box
 * moving from floor to floor.
 */
public class moveCommandPB implements Commands {

    private Maze maze;
    private Position start;
    private Position saveStart;
    private Position target;
    private Item item;
    private Direction dir;
    private int nbMoves;
    private ArrayList<Integer> option = new ArrayList();

    /**
     *
     * @param maze The current level.
     * @param start The position of Soko before the move.
     * @param target The position Soko want to move on.
     * @param item Soko.
     * @param dir The direction in which Soko want to move.
     * @param nbMoves The number of moves already made by Soko
     */
    public moveCommandPB(Maze maze, Position start, Position target,
            Item item, Direction dir, int nbMoves) {
        this.maze = maze;
        this.start = start;
        this.target = target;
        this.item = item;
        this.dir = dir;
        this.nbMoves = nbMoves;
        saveStart = start;
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
                maze.put(new BoxGoal(), target.next(dir));
                maze.remove(target);
                maze.put(maze.getCell(start).getItem(), target);
                option.add(0);
            } else if (maze.isFree(target.next(dir))) {
                maze.put(new Box(), target.next(dir));
                maze.remove(target);
                maze.put(new SokoGoal(), target);
                option.add(1);
            }
            maze.remove(start);
        } else {
            if (maze.isGoal(target.next(dir))) {
                maze.put(new BoxGoal(), target.next(dir));
                maze.remove(target);
                option.add(2);
            } else {
                maze.put(maze.getCell(target).getItem(), target.next(dir));
                maze.remove(target);
                option.add(3);
            }
            maze.put(maze.getCell(start).getItem(), target);
            maze.remove(start);
        }
    }

    /**
     * used to undo the last move using a box.
     */
    @Override
    public void unexecute() {
        int last = option.size() - 1;
        switch (option.get(last)) {
            case 0:
                maze.put(item, saveStart);
                maze.put(new BoxGoal(), target);
                maze.put(new Goal(), target.next(dir));
            case 1:
                maze.put(item, saveStart);
                maze.put(new BoxGoal(), target);
                maze.remove(target.next(dir));
            case 2:
                maze.put(item, saveStart);
                maze.put(new Box(), target);
                maze.put(new Goal(), target.next(dir));
            case 3:
                maze.put(item, saveStart);
                maze.put(new Box(), target);
                maze.remove(target.next(dir));
        }
        option.remove(last);
    }
}

package esi.atl.g43335.sokoban.Model.commands;

import esi.atl.g43335.sokoban.model.*;
import esi.atl.g43335.sokoban.model.items.Box;
import esi.atl.g43335.sokoban.model.items.BoxGoal;
import esi.atl.g43335.sokoban.model.items.SokoGoal;

/**
 *
 * @author franc
 */
public class moveCommandPB implements Commands {

    private Maze maze;
    private Position start;
    private Position saveStart;
    private Position target;
    private Item item;
    private Direction dir;
    private int nbMoves;
    

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

    @Override
    public void execute() {
        if (maze.isBoxGoal(target)) {
            if (maze.isGoal(target.next(dir))) {
                maze.put(new SokoGoal(), target.next(dir));
                maze.remove(target);
                maze.put(maze.getCell(start).getItem(), target);
            } else if (maze.isFree(target.next(dir))) {
                maze.put(new Box(), target.next(dir));
                maze.remove(target);
                maze.put(new SokoGoal(), target);
            }
            maze.remove(start);
        } else {
            if (maze.isGoal(target.next(dir))) {
                maze.put(new BoxGoal(), target.next(dir));
                maze.remove(target);
            } else {
                maze.put(maze.getCell(target).getItem(), target.next(dir));
                maze.remove(target);
            }
            maze.put(maze.getCell(start).getItem(), target);
            maze.remove(start);
        }
    }

    @Override
    public void unexecute() {
        
    }

}

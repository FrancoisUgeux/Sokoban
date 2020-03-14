package esi.atl.g43335.sokoban.Model.commands;

import esi.atl.g43335.sokoban.model.Commands;
import esi.atl.g43335.sokoban.model.Item;
import esi.atl.g43335.sokoban.model.Maze;
import esi.atl.g43335.sokoban.model.Position;

/**
 *
 * @author franc
 */
public class moveCommand implements Commands {

    private Maze maze;
    private Position start;
    private Position target;
    private Item item;

    public moveCommand(Maze maze, Position start, Position target, Item item) {
        this.maze = maze;
        this.start = start;
        this.target = target;
        this.item = item;
    }

    @Override
    public void execute() {
        maze.put(maze.getCell(start).getItem(), target);
        maze.remove(start);
        maze.put(item, target);
        maze.remove(start);
    }

    @Override
    public void unexecute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

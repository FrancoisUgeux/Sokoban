package esi.atl.g43335.sokoban.Model.commands;

import esi.atl.g43335.sokoban.model.Commands;
import esi.atl.g43335.sokoban.model.Item;
import esi.atl.g43335.sokoban.model.Maze;
import esi.atl.g43335.sokoban.model.Position;
import esi.atl.g43335.sokoban.model.items.Goal;
import esi.atl.g43335.sokoban.model.items.Player;
import esi.atl.g43335.sokoban.model.items.SokoGoal;
import java.util.ArrayList;

/**
 *
 * @author franc This class apply a move when no box is involved. The player can
 * move on the floor or on a goal. The list of option help to recognize the
 * different situation ex: player move from a goal to a floor is != player
 * moving from floor to floor.
 */
public class moveCommand implements Commands {

    private Maze maze;
    private Position start;
    private Position saveStart;
    private Position target;
    private Item item;
    private int nbMoves;
    private ArrayList<Integer> option = new ArrayList();

    /**
     *
     * @param maze
     * @param start
     * @param target
     * @param item
     * @param nbMoves
     */
    public moveCommand(Maze maze, Position start, Position target,
            Item item, int nbMoves) {
        this.maze = maze;
        this.start = start;
        this.target = target;
        this.item = item;
        this.nbMoves = nbMoves;
        saveStart = start;
    }

    @Override
    public void execute() {

        if (maze.isFree(target) && !maze.isSokoGoal(start)) {
            maze.put(item, target);
            maze.remove(start);
            option.add(0);
        } else if (maze.isFree(target) && maze.isSokoGoal(start)) {
            maze.put(new Player(nbMoves), target);
            maze.remove(start);
            maze.put(new Goal(), start);
            option.add(0);
        } else {
            maze.put(new SokoGoal(), target);
            maze.remove(start);
            option.add(0);
        }
    }

    @Override
    public void unexecute() {
        int last = option.size() - 1;
        switch (option.get(last)) {
            case 0:
                maze.put(item, start);
                maze.remove(target);
                option.remove(last);
                break;
            case 1:
                maze.put(new SokoGoal(), start);
                maze.remove(target);
                option.remove(last);
                break;
            case 2:
                maze.put(item, start);
                maze.put(new Goal(), target);
                option.remove(last);
        }
        start = saveStart;
        nbMoves--;
    }
}

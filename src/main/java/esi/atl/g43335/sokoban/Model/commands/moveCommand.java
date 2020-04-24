package esi.atl.g43335.sokoban.model.commands;

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
     * @param maze The current level.
     * @param start The position of soko before the move.
     * @param target The place soko want to move on.
     * @param item Soko.
     * @param nbMoves The number of moves already made by soko.
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

    /**
     * execute the move command without box. depending on: player move from
     * floor to goal. player moving from floor to floor. player moving from goal
     * to floor.
     */
    @Override
    public void execute() {

        if (maze.isFree(target) && !maze.isSokoGoal(start)) {
            maze.put(item, target);
            maze.remove(start);
            option.add(0);
        } else if (maze.isFree(target) && maze.isSokoGoal(start)) {
            maze.put(new Player(nbMoves), target);
            maze.put(new Goal(), start);
            option.add(1);
        } else if (maze.isGoal(target) && maze.isSokoGoal(start)) {
            maze.put(new SokoGoal(), target);
            maze.put(new Goal(), start);
            option.add(2);
        } else {
            maze.put(new SokoGoal(), target);
            maze.remove(start);
            option.add(3);
        }
    }

    /**
     * used to undo the last move not using a box.
     */
    @Override
    public void unexecute() {
        int last = option.size() - 1;
        switch (option.get(last)) {
            case 0:
                maze.put(item, saveStart);
                maze.remove(target);
                break;
            case 1:
                maze.put(new SokoGoal(), saveStart);
                maze.remove(target);
                break;
            case 2:
                maze.put(new SokoGoal(), saveStart);
                maze.put(new Goal(), target);
            case 3:
                maze.put(item, saveStart);
                maze.put(new Goal(), target);
                break;
        }
        option.remove(last);
        start = saveStart;
        nbMoves--;
    }
}

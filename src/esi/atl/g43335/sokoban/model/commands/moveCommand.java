package esi.atl.g43335.sokoban.model.commands;

import esi.atl.g43335.sokoban.model.Command;
import esi.atl.g43335.sokoban.model.Direction;
import esi.atl.g43335.sokoban.model.Game;
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
public class moveCommand implements Command {

    private final Game game;
    private final Maze maze;
    private final Position start;
    private final Position target;
    private final Item item;
    private int nbMoves;
    private String string;
    private int option;

    /**
     *
     * @param maze The current level.
     * @param start The position of soko before the move.
     * @param target The place soko want to move on.
     * @param item Soko.
     * @param nbMoves The number of moves already made by soko.
     * @param game
     */
    public moveCommand(Maze maze, Position start, Position target,
            Item item, int nbMoves, Game game) {
        this.game = game;
        this.maze = maze;
        this.start = start;
        this.target = target;
        this.item = item;
        this.nbMoves = nbMoves;
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
            option = 0;
        } else if (maze.isFree(target) && maze.isSokoGoal(start)) {
            maze.put(new Player(), target);
            maze.put(new Goal(), start);
            option = 1;
        } else if (maze.isGoal(target) && maze.isSokoGoal(start)) {
            maze.put(new SokoGoal(), target);
            maze.put(new Goal(), start);
            option = 2;
        } else {
            maze.put(new SokoGoal(), target);
            maze.remove(start);
            option = 3;
        }
        sokoMove();
        maze.setStart(target);
    }

    /**
     * used to undo the last move not using a box.
     */
    @Override
    public void unexecute() {
        switch (option) {
            case 0:
                maze.put(item, start);
                maze.remove(target);
                break;
            case 1:
                maze.put(new SokoGoal(), start);
                maze.remove(target);
                break;
            case 2:
                maze.put(new SokoGoal(), start);
                maze.put(new Goal(), target);
            case 3:
                maze.put(item, start);
                maze.put(new Goal(), target);
                break;
        }
        maze.setStart(start);
        game.setNbMoves(--nbMoves);
    }

    @Override
    public String getString() {
        return string;
    }

    private void sokoMove() {
        if (start.getColumn() > target.getColumn()) {
            string = "soko moving left";
        } else if (start.getColumn() < target.getColumn()) {
            string = "soko moving right";
        } else if (start.getRow() > target.getRow()) {
            string = "soko moving up";
        } else {
            string = "soko moving down";
        }
    }

}

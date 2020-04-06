package esi.atl.g43335.sokoban.controller;

import esi.atl.g43335.sokoban.model.Direction;
import esi.atl.g43335.sokoban.model.Game;
import esi.atl.g43335.sokoban.view.View;

/**
 *
 * @author franc
 */
public class Controller {

    private Game game;
    private View view;
    private final String up = "z";
    private final String left = "q";
    private final String right = "d";
    private final String down = "s";

    public Controller(Game game, View view) {
        this.game = game;
        this.view = view;
    }

    public void start() {
        String[] arrayOfArgs;
        view.initialize();
        view.displayHelp();
        view.displayLevel();
        arrayOfArgs = view.askCommand().split(" ");
        game.start(Integer.parseInt(arrayOfArgs[0]));
        view.displayMaze(game.getMaze().getCells());
        do {
            arrayOfArgs = view.askCommand().split(" ");
            commands(arrayOfArgs);
        } while (!arrayOfArgs[0].equalsIgnoreCase("quit"));
        view.displayQuit();
    }

    public void commands(String[] arrayOfArgs) {

        switch (arrayOfArgs[0]) {
            case up:
                game.move(Direction.UP);
                break;
            case down:
                game.move(Direction.DOWN);
                break;
            case left:
                game.move(Direction.LEFT);
                break;
            case right:
                game.move(Direction.RIGHT);
                break;
            case "help":
                view.displayHelp();
                break;
            case "undo":
                game.undo();
                break;
            case "redo":
                game.redo();
                break;
            case "restart":
                game.restart();
                break;
            case "next":
                game.nextLevel();
                break;
        }
        view.displayMaze(game.getMaze().getCells());
        view.displayNbMoves(game.getNbMoves());
    }
}

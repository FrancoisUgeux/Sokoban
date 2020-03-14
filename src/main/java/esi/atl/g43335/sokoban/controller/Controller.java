package esi.atl.g43335.sokoban.controller;

import esi.atl.g43335.sokoban.model.Direction;
import esi.atl.g43335.sokoban.model.Game;
import esi.atl.g43335.sokoban.view.viewwwww;

/**
 *
 * @author franc
 */
public class Controller {

    private Game game;
    private viewwwww view;

    public Controller(Game game, viewwwww view) {
        this.game = game;
        this.view = view;
    }

    public void initialize() {
        game.start(0);
    }

    public void start() {
        view.displayHelp();
        String[] arrayOfArgs;
        do {
            arrayOfArgs = view.askCommand().split(" ");
            commands(arrayOfArgs);
        } while (!arrayOfArgs[0].equalsIgnoreCase("quit"));
    }

    public void commands(String[] arrayOfArgs) {
        switch (arrayOfArgs[0]) {
            case "move":
                moveItem(arrayOfArgs);
                break;
        }
    }

    private void moveItem(String[] arrayOfArgs) {
        switch (arrayOfArgs[1]) {
            case "UP":
                game.move(Direction.UP);
                break;
            case "DOWN":
                game.move(Direction.DOWN);
                break;
            case "LEFT":
                game.move(Direction.LEFT);
                break;
            case "RIGHT":
                game.move(Direction.RIGHT);
        }
        view.displayMaze(game.getMaze().getCells());
    }
}

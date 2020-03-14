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

    public Controller(Game game, View view) {
        this.game = game;
        this.view = view;
    }

    public void initialize() {
        game.start(0);
    }

    public void start() {
        view.initialize();
        view.displayHelp();
        String[] arrayOfArgs;
        do {
            arrayOfArgs = view.askCommand().split(" ");
            commands(arrayOfArgs);
        } while (!arrayOfArgs[0].equalsIgnoreCase("quit"));
        view.displayQuit();
    }

    public void commands(String[] arrayOfArgs) {
        switch (arrayOfArgs[0]) {
            case "z":
                game.move(Direction.UP);
                break;
            case "s":
                game.move(Direction.DOWN);
                break;
            case "q":
                game.move(Direction.LEFT);
                break;
            case "d":
                game.move(Direction.RIGHT);
                break;
            case "help":
                view.displayHelp();
        }
        view.displayMaze(game.getMaze().getCells());
    }

//    private void moveItem(String[] arrayOfArgs) {
//        switch (arrayOfArgs[1]) {
//            case "z":
//                game.move(Direction.UP);
//                break;
//            case "s":
//                game.move(Direction.DOWN);
//                break;
//            case "q":
//                game.move(Direction.LEFT);
//                break;
//            case "d":
//                game.move(Direction.RIGHT);
//        }
//        view.displayMaze(game.getMaze().getCells());
//    }
}

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
    private boolean surrender;
    private boolean isOver;
    private final String up = "z";
    private final String left = "q";
    private final String right = "d";
    private final String down = "s";

    public Controller(Game game, View view) {
        this.game = game;
        this.view = view;
        surrender = false;
        isOver = false;
    }

    public void start() {
        String[] arrayOfArgs;
        view.initialize();
        view.displayHelp();
        view.displayLevel();
        arrayOfArgs = view.askCommand().split(" ");
        game.start(Integer.parseInt(arrayOfArgs[0]));
        view.displayMaze(game.getMaze().getCells());
        playLevel(Integer.parseInt(arrayOfArgs[0]));
    }
    
    public void playLevel(int level) {
        String[] arrayOfArgs;
        do {
            arrayOfArgs = view.askCommand().split(" ");
            commands(arrayOfArgs);
        } while (!arrayOfArgs[0].equalsIgnoreCase("quit") && !surrender && !isOver);
        if (surrender) {
            surrender = false;
            start();
        } else if (isOver && game.getCurrentLevel() <= 1) {
            view.displayWinnerLvl();
            isOver = false;
            game.nextLevel();
            view.displayMaze(game.getMaze().getCells());
            playLevel(game.getCurrentLevel());
        } else if (isOver) {
            view.displayWinner();
        }
        view.displayQuit();
    }
    
    public void commands(String[] arrayOfArgs) {

        switch (arrayOfArgs[0]) {
            case up:
                move(Direction.UP);
                break;
            case down:
                move(Direction.DOWN);
                break;
            case left:
                move(Direction.LEFT);
                break;
            case right:
                move(Direction.RIGHT);
                break;
            case "help":
                view.displayHelp();
                break;
            case "undo":
                undo();
                break;
            case "redo":
                redo();
                break;
            case "restart":
                game.restart();
                view.displayMaze(game.getMaze().getCells());
                break;
            case "next":
                game.nextLevel();
                view.displayMaze(game.getMaze().getCells());
                break;
            case "surrender":
                game.setNbMoves(0);
                surrender = true;
                break;
        }
    }

    private void move(Direction dir) {
        game.move(dir);
        view.displayNbMoves(game.getNbMoves());
        view.displayMaze(game.getMaze().getCells());
        if (game.isOver()) {
            isOver = true;
        }
    }

    private void undo() {
        if (game.undoStackEmpty()) {
            view.displayErrorUndo();
        } else {
            game.undo();
            view.displayMaze(game.getMaze().getCells());
        }
    }

    private void redo() {
        if (game.redoStackEmpty()) {
            view.displayErrorRedo();
        } else {
            game.redo();
            view.displayMaze(game.getMaze().getCells());
        }
    }
}

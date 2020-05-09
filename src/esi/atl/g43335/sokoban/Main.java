package esi.atl.g43335.sokoban;

import esi.atl.g43335.sokoban.controller.Controller;
import esi.atl.g43335.sokoban.model.Game;
import esi.atl.g43335.sokoban.model.Maze;
import esi.atl.g43335.sokoban.view.View;
import javafx.application.Application;

/**
 *
 * @author franc
 */
public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        View view = new View();
        Controller controller = new Controller(game, view);
        Maze maze = new Maze();
        view.displayMaze(maze.getCells());
        controller.start();
    }
}

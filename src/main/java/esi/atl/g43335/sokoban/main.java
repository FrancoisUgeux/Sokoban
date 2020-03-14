package esi.atl.g43335.sokoban;

import esi.atl.g43335.sokoban.controller.Controller;
import esi.atl.g43335.sokoban.model.Direction;
import esi.atl.g43335.sokoban.model.Game;
import esi.atl.g43335.sokoban.model.Maze;
import esi.atl.g43335.sokoban.model.Move;
import esi.atl.g43335.sokoban.model.Position;
import esi.atl.g43335.sokoban.view.viewwwww;

/**
 *
 * @author franc
 */
public class main {

    public static void main(String[] args) {
        Game game = new Game(0);
        viewwwww view = new viewwwww();
        Controller controller = new Controller(game, view);
        Maze maze = new Maze();
        view.displayMaze(maze.getCells());
        game.start(0);
        controller.initialize();
        controller.start();
    }

}


package esi.atl.g43335.sokoban;

import esi.atl.g43335.sokoban.model.Game;
import esi.atl.g43335.sokoban.model.Maze;
import esi.atl.g43335.sokoban.view.viewwwww;

/**
 *
 * @author franc
 */
public class main {
    public static void main(String[] args) {
        Game game = new Game(0);
        viewwwww view = new viewwwww();
        Maze maze = new Maze();
        view.displayMaze(maze.getCells());
    }

}

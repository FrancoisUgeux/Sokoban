
package esi.atl.g43335.sokoban;

import esi.atl.g43335.sokoban.Model.Game;
import esi.atl.g43335.sokoban.Model.Maze;
import esi.atl.g43335.sokoban.view.View;

/**
 *
 * @author franc
 */
public class main {
    public static void main(String[] args) {
        Game game = new Game(0);
        View view = new View();
        Maze maze = new Maze();
        view.displayMaze(maze.getCells());
    }

}

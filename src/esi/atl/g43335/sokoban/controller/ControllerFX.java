package esi.atl.g43335.sokoban.controller;

import esi.atl.g43335.sokoban.model.Maze;
import esi.atl.g43335.sokoban.model.Model;
import esi.atl.g43335.sokoban.view.App;
import esi.atl.g43335.sokoban.view.BoardFX;
import esi.atl.g43335.sokoban.view.StatsLeftFX;

/**
 *
 * @author franc
 */
public class ControllerFX {

    private final Model game;
    private final App viewFX;
    private StatsLeftFX leftMenu;
    private BoardFX board;
    private final Maze maze;

    public ControllerFX(Model game, App viewFX) {
        this.game = game;
        this.viewFX = viewFX;
        maze = viewFX.getMaze();
    }

    public void start() {
        game.start(leftMenu.getLevelNb());
        board.mazeBuilder(maze);
    }
}

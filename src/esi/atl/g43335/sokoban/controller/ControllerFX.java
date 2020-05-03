package esi.atl.g43335.sokoban.controller;

import esi.atl.g43335.sokoban.model.Direction;
import esi.atl.g43335.sokoban.model.Model;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author franc
 */
public class ControllerFX {

    private final Model game;
    private final Scene scene;

    public ControllerFX(Model game, Scene scene) {
        this.game = game;
        this.scene = scene;
    }

    public void start() {
        scene.setOnKeyPressed((KeyEvent key) -> {
            if (!game.isOver() && !game.isSurrend()) {
                switch (key.getCode()) {
                    case Z:
                        game.move(Direction.UP);
                        break;
                    case Q:
                        game.move(Direction.LEFT);
                        break;
                    case S:
                        game.move(Direction.DOWN);
                        break;
                    case D:
                        game.move(Direction.RIGHT);
                        break;
                }
            }
        });
    }
}

package esi.atl.g43335.sokoban.view;

import esi.atl.g43335.sokoban.controller.ControllerFX;
import esi.atl.g43335.sokoban.model.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author franc
 */
public class PlayMenuFX extends GridPane {

    private ControllerFX controller;

    public PlayMenuFX(Game game, BoardFX board, StatsLeftFX leftMenu) {
        Label filler = new Label(" ");
        filler.setPrefWidth(600);
        this.add(filler, 0, 0);

        Button play = new Button();
        play.setText("Play !");
        this.add(play, 1, 0);

        play.setOnAction((ActionEvent event) -> {
            game.start(leftMenu.getLevelNb());
            board.mazeBuilder(game.getMaze());
//            controller.start();
        });
        {
        }
    }
}

package esi.atl.g43335.sokoban.view;

import esi.atl.g43335.sokoban.model.Game;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author franc
 */
public class PlayMenuFX extends GridPane {

    public PlayMenuFX(Game game, BoardFX board, StatsLeftFX leftMenu) {
        Label filler = new Label(" ");
        filler.setPrefWidth(600);
        this.add(filler, 0, 0);

        Button playBt = new Button();
        playBt.setText("Play !");
        this.add(playBt, 1, 0);

        Button leftBt = new Button();
        leftBt.setText("<-");
        this.add(leftBt, 2, 1);

        Button rightBt = new Button();
        rightBt.setText("->");
        this.add(rightBt, 4, 1);

        Button upBt = new Button();
        upBt.setText("^");
        this.add(upBt, 3, 0);

        Button downBt = new Button();
        downBt.setText("down");
        this.add(downBt, 3, 2);

        playBt.setOnAction((ActionEvent event) -> {
            game.start(leftMenu.getLevelNb());
            board.setMaze(game.getMaze());
            game.notifyObservers();
//            board.update();
        });
        {
        }
    }
}

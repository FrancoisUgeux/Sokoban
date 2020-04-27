package esi.atl.g43335.sokoban.view;

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

    public PlayMenuFX() {
        Label filler = new Label(" ");
        filler.setPrefWidth(600);
        this.add(filler, 0, 0);

        Button play = new Button();
        play.setText("Play !");
        this.add(play,1,0);
        
        play.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                
            }
        });{
        
    }
    }
}

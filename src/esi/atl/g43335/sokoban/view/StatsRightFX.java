package esi.atl.g43335.sokoban.view;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author franc
 */
public class StatsRightFX extends GridPane {

    public StatsRightFX() {

        Label undoStack = new Label("your lasts command");
        this.add(undoStack, 0, 0);

        Label redoStack = new Label("your lasts undo");
        this.add(redoStack, 0, 1);
    }

}

package esi.atl.g43335.sokoban.view;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author franc
 */
public class StatsRightFX extends GridPane {

    public StatsRightFX() {

        this.setHgap(100);

        Label undoStack = new Label("your lasts command");
        undoStack.setUnderline(true);
        this.add(undoStack, 0, 0);

        Label redoStack = new Label("your lasts undo");
        this.add(redoStack, 1, 0);
    }
}

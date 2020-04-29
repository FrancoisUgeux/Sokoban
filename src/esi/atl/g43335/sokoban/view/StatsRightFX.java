package esi.atl.g43335.sokoban.view;

import esi.atl.g43335.sokoban.model.Observer;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author franc
 */
public class StatsRightFX extends GridPane implements Observer {

    public StatsRightFX() {

        this.setHgap(100);

        Label undoStack = new Label("your lasts command");
        undoStack.setUnderline(true);
        this.add(undoStack, 0, 0);

        Label undoDisplay = new Label("");
        this.add(undoDisplay, 0, 1);

        Label redoStack = new Label("your lasts undo");
        redoStack.setUnderline(true);
        this.add(redoStack, 1, 0);

        Label redoDisplay = new Label("");
        this.add(redoDisplay, 1, 1);
    }

    @Override
    public void update() {

    }
}

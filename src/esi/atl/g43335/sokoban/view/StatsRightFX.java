package esi.atl.g43335.sokoban.view;

import esi.atl.g43335.sokoban.model.Game;
import esi.atl.g43335.sokoban.model.Observer;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author franc
 */
public class StatsRightFX extends GridPane implements Observer {

    private final Label undoDisplay;
    private final Label redoDisplay;
    private VBox undoList;
    private VBox redoList;
    private final Game game;

    public StatsRightFX(Game game) {

        this.game = game;
        this.setHgap(100);

//        TableView table = new TableView();
//        table.setEditable(true);
        Label undoStack = new Label("your lasts command");
        undoStack.setUnderline(true);
        this.add(undoStack, 0, 0);

        undoList = new VBox();
        this.add(undoList, 0, 1);

        undoDisplay = new Label("");
        undoList.getChildren().add(undoDisplay);
//        this.add(undoDisplay, 0, 1);

        Label redoStack = new Label("your lasts undo");
        redoStack.setUnderline(true);
        this.add(redoStack, 1, 0);

        redoList = new VBox();
        this.add(redoList, 1, 1);

        redoDisplay = new Label("");
        redoList.getChildren().add(redoDisplay);
    }

    @Override
    public void update() {
        undoList.getChildren().clear();
        redoList.getChildren().clear();
//        undoDisplay.setText(game.getUndoStack().peek().getString());
        game.getUndoStack().forEach((t) -> {
            Label undo = new Label(t.getString());
//            labels.add(label);
            undoList.getChildren().add(undo);
        });

        game.getRedoStack().forEach((t) -> {
            Label redo = new Label(t.getString());
            redoList.getChildren().add(redo);
        });
    }
}

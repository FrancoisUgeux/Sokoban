package esi.atl.g43335.sokoban.view;

import esi.atl.g43335.sokoban.model.Game;
import esi.atl.g43335.sokoban.model.Observer;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author franc
 */
public class StatsRightFX extends GridPane implements Observer {

    private VBox undoList;
    private VBox redoList;
    private final Game game;
    private Label undo = new Label("");
    private Label redo = new Label("");
    private final int MAX_STACK = 33;

    public StatsRightFX(Game game) {
        this.game = game;
        this.setHgap(100);

        initComponent();
    }

    private void initComponent() {
        Label undoStack = new Label("your lasts command");
        undoStack.setFont(Font.font(30));
        undoStack.setUnderline(true);
        this.add(undoStack, 0, 0);

        undoList = new VBox();
        this.add(undoList, 0, 1);

        Label redoStack = new Label("your lasts undo");
        redoStack.setFont(Font.font(30));
        redoStack.setUnderline(true);
        this.add(redoStack, 1, 0);

        redoList = new VBox();
        this.add(redoList, 1, 1);
    }

    @Override
    public void update() {
        undoList.getChildren().clear();
        redoList.getChildren().clear();

        game.getUndoStack().forEach((t) -> {
            if (undoList.getChildren().size() == MAX_STACK) {
                undoList.getChildren().remove(0);
            }
            undo = new Label(t.getString());
            undo.setFont(Font.font(15));
            undoList.getChildren().add(undo);
        });

        game.getRedoStack().forEach((t) -> {
            if (redoList.getChildren().size() == MAX_STACK) {
                redoList.getChildren().remove(0);
            }
            redo = new Label(t.getString());
            redo.setFont(Font.font(15));
            redoList.getChildren().add(redo);
        });
        undo.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        redo.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
    }
}

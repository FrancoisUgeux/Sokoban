package esi.atl.g43335.sokoban.view;

import esi.atl.g43335.sokoban.model.Game;
import esi.atl.g43335.sokoban.model.Observer;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 *
 * @author franc
 */
public class StatsLeftFX extends GridPane implements Observer {

    private ChoiceBox levelSelect;
    private Label nbMovesValue;
    private Label goalsValue;
    private Label boxGoalValue;
    private final Game myGame;
    private Button restart;
    private Button undo;
    private Button redo;
    private Button surrender;
    private final int DEFAULT_LVL = 42;

    public StatsLeftFX(Game game) {
        myGame = game;

        this.setHgap(10);
        this.setVgap(10);

        initComponent();
        initAction();

    }

    private void initComponent() {
        levelSelect = new ChoiceBox();
        levelSelect.setItems(FXCollections.observableArrayList("Level one",
                "Test level"));
        levelSelect.setValue("Level one");
        levelSelect.setMinSize(250, 70);
        this.add(levelSelect, 0, 0);

        restart = new Button();
        restart.setText("restart");
        restart.setMinSize(250, 70);
        restart.setFont(Font.font(40));
        this.add(restart, 0, 1);

        undo = new Button();
        undo.setText("undo");
        undo.setPadding(new Insets(5));
        undo.setMinSize(250, 70);
        undo.setFont(Font.font(40));
        this.add(undo, 0, 2);

        redo = new Button();
        redo.setText("redo");
        redo.setPadding(new Insets(5));
        redo.setMinSize(250, 70);
        redo.setFont(Font.font(40));
        this.add(redo, 0, 3);

        surrender = new Button();
        surrender.setText("surrender");
        surrender.setPadding(new Insets(5));
        surrender.setMinSize(250, 70);
        surrender.setFont(Font.font(40));
        this.add(surrender, 0, 4);

        Label nbMoves = new Label("Your moves :");
        nbMoves.setFont(Font.font(30));
        this.add(nbMoves, 1, 0);

        nbMovesValue = new Label("0");
        nbMovesValue.setFont(Font.font(30));
        this.add(nbMovesValue, 2, 0);

        Label goals = new Label("goals : ");
        goals.setFont(Font.font(30));
        this.add(goals, 1, 1);

        goalsValue = new Label("0");
        goalsValue.setFont(Font.font(30));
        this.add(goalsValue, 2, 1);

        Label boxGoal = new Label("goals already filled: ");
        boxGoal.setFont(Font.font(30));
        this.add(boxGoal, 1, 2);

        boxGoalValue = new Label("0");
        boxGoalValue.setFont(Font.font(30));
        this.add(boxGoalValue, 2, 2);
    }

    private void initAction() {
        restart.setOnAction((t) -> {
            if (myGame.getNbMoves() > 0) {
                myGame.restart();
            }
        });

        undo.setOnAction((t) -> {
            if (!myGame.getUndoStack().empty()) {
                myGame.undo();
            }
        });

        redo.setOnAction((t) -> {
            if (!myGame.getRedoStack().empty()) {
                myGame.redo();
            }
        });

        surrender.setOnAction((t) -> {
            myGame.setSurrend();
        });
    }

    private String getLevelSelect() {
        return levelSelect.getValue().toString();
    }

    public int getLevelNb() {
        String level = getLevelSelect();
        switch (level) {
            case "Level one":
                return 1;
            case "Test level":
                return 0;
            default:
                return DEFAULT_LVL;
        }
    }

    @Override
    public void update() {
        nbMovesValue.setText(Integer.toString(myGame.getNbMoves()));
        goalsValue.setText(Integer.toString(myGame.getNbGoals()));
        boxGoalValue.setText(Integer.toString(myGame.getMaxNbGoals() - (myGame.getNbGoals())));
    }
}

package esi.atl.g43335.sokoban.view;

import esi.atl.g43335.sokoban.model.Game;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author franc
 */
public class StatsLeftFX extends GridPane {

    public StatsLeftFX() {
        Game game = new Game(0);

        this.setHgap(10);
        this.setVgap(10);
        ChoiceBox levelSelect = new ChoiceBox();
        levelSelect.setItems(FXCollections.observableArrayList("Level one",
                "Test level"));
        levelSelect.setValue("Level one");
        this.add(levelSelect, 0, 0);

        Button restart = new Button();
        restart.setText("restart");
        restart.setPadding(new Insets(5));
        this.add(restart, 0, 1);

        Button undo = new Button();
        undo.setText("undo");
        undo.setPadding(new Insets(5));
        this.add(undo, 0, 2);

        Button redo = new Button();
        redo.setText("redo");
        redo.setPadding(new Insets(5));
        this.add(redo, 0, 3);

        Button surrender = new Button();
        surrender.setText("surrender");
        surrender.setPadding(new Insets(5));
        this.add(surrender, 0, 4);

        Label nbMoves = new Label("Your moves :");
        this.add(nbMoves, 1, 0);

        Label nbMovesValue = new Label(Integer.toString(game.getNbMoves()));
        this.add(nbMovesValue, 2, 0);

        Label goals = new Label("goals : ");
        this.add(goals, 1, 1);

//        Label goalsValue = new Label(Integer.toString(game.getMaze().getNbGoals()));
//        this.add(goalsValue, 1, 2);

        Label boxGoal = new Label("goals already filled: ");
        this.add(boxGoal, 1, 1);

//        Label boxGoalValue = new Label(Integer.toString(game.getMaze().getNbGoals()));
//        this.add(boxGoalValue, 1, 2);

    }
}

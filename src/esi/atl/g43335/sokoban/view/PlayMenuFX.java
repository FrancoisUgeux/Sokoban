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

    private Label fillerLeft;
    private Label fillerRight;
    private Button playBt;
    private Button nextLevelBt;
    private final Game game;
    private final StatsLeftFX leftMenu;

    public PlayMenuFX(Game game, StatsLeftFX leftMenu) {

        this.game = game;
        this.leftMenu = leftMenu;
        initComponent();
        initAction();
    }

    private void initComponent() {
        fillerLeft = new Label(" ");
        fillerLeft.setPrefWidth(585);
        this.add(fillerLeft, 0, 0);

        fillerRight = new Label(" ");
        fillerRight.setPrefWidth(585);
        this.add(fillerRight, 2, 0);

        playBt = new Button();
        playBt.setText("Play !");
        playBt.setMinSize(375, 140);
        this.add(playBt, 1, 0);

        nextLevelBt = new Button();
        nextLevelBt.setText("Next level");
        nextLevelBt.setMinSize(375, 140);
        this.add(nextLevelBt, 2, 0);
    }

    private void initAction() {
        playBt.setOnAction((ActionEvent event) -> {
            game.start(leftMenu.getLevelNb());
        });

        nextLevelBt.setOnAction((t) -> {
            if (game.getCurrentLevel() < 1) {
                game.nextLevel();
            }
        });
    }
}

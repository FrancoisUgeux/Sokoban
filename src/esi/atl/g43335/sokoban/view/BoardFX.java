package esi.atl.g43335.sokoban.view;

import esi.atl.g43335.sokoban.model.Game;
import esi.atl.g43335.sokoban.model.ItemType;
import esi.atl.g43335.sokoban.model.Observer;
import esi.atl.g43335.sokoban.model.Position;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author franc
 */
public class BoardFX extends GridPane implements Observer {

    private final int BOARD_SIZE = 30;
    private final Image wall;
    private final Image sokoGoal;
    private final Image box;
    private final Image boxGoal;
    private final Image floor;
    private final Image goal;
    private final Image player;
    private final Image endLevel;
    private final Image surrend;
    private final Game game;

    public BoardFX(Game game) {
        this.goal = new Image("/esi/atl/g43335/sokoban/resources/goal.png");
        this.floor = new Image("/esi/atl/g43335/sokoban/resources/floor.png");
        this.boxGoal = new Image("/esi/atl/g43335/sokoban/resources/boxGoal.png");
        this.box = new Image("/esi/atl/g43335/sokoban/resources/box.png");
        this.sokoGoal = new Image("/esi/atl/g43335/sokoban/resources/Sokogoal.png");
        this.wall = new Image("/esi/atl/g43335/sokoban/resources/wall.png");
        this.player = new Image("/esi/atl/g43335/sokoban/resources/player.png");
        this.endLevel = new Image("/esi/atl/g43335/sokoban/resources/win.png");
        this.surrend = new Image("/esi/atl/g43335/sokoban/resources/lose.png");
        this.game = game;
        game.start(42);
        mazeBuilder(game);

    }

    private void mazeBuilder(Game game) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                ItemType itemType = game.getMaze().getCell(new Position(i, j)).getItem().getType();
                Rectangle tile = new Rectangle(25, 25);
                switch (itemType) {
                    case BOX:
                        ImagePattern imagePatternBox = new ImagePattern(box);
                        tile.setFill(imagePatternBox);
                        break;
                    case BOXGOAL:
                        ImagePattern imagePatternBoxGoal = new ImagePattern(boxGoal);
                        tile.setFill(imagePatternBoxGoal);
                        break;
                    case FLOOR:
                        ImagePattern imagePatternFloor = new ImagePattern(floor);
                        tile.setFill(imagePatternFloor);
                        break;
                    case GOAL:
                        ImagePattern imagePatternGoal = new ImagePattern(goal);
                        tile.setFill(imagePatternGoal);
                        break;
                    case PLAYER:
                        ImagePattern imagePatternPlayer = new ImagePattern(player);
                        tile.setFill(imagePatternPlayer);
                        break;
                    case SOKOGOAL:
                        ImagePattern imagePatternSokoGoal = new ImagePattern(sokoGoal);
                        tile.setFill(imagePatternSokoGoal);
                        break;
                    case WALL:
                        ImagePattern imagePatternWall = new ImagePattern(wall);
                        tile.setFill(imagePatternWall);
                        break;
                }
//                tile.setStroke(Color.BLACK);

                GridPane.setRowIndex(tile, i);
                GridPane.setColumnIndex(tile, j);

                this.getChildren().add(tile);
            }
        }
    }

    @Override
    public void update() {
        if (!game.isOver() && !game.isSurrend()) {
            this.getChildren().clear();
            mazeBuilder(game);
        } else if (!game.isOver() && game.isSurrend()) {
            this.getChildren().clear();
            this.getChildren().add(new ImageView(surrend));
        } else {
            this.getChildren().clear();
            this.getChildren().add(new ImageView((endLevel)));
        }
    }
}

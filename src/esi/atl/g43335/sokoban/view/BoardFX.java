package esi.atl.g43335.sokoban.view;

import esi.atl.g43335.sokoban.model.ItemType;
import esi.atl.g43335.sokoban.model.Maze;
import esi.atl.g43335.sokoban.model.Position;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author franc
 */
public class BoardFX extends GridPane {

    private final int BOARD_SIZE = 30;

    public BoardFX() {
        Maze maze = new Maze();
        maze.chooseLevel(1);
//        this.setPrefSize(800, 800);
        Image wall = new Image("/esi/atl/g43335/sokoban/resources/wall.png");
        Image sokoGoal = new Image("/esi/atl/g43335/sokoban/resources/Sokogoal.png");
        Image box = new Image("/esi/atl/g43335/sokoban/resources/box.png");
        Image boxGoal = new Image("/esi/atl/g43335/sokoban/resources/boxGoal.png");
        Image floor = new Image("/esi/atl/g43335/sokoban/resources/floor.png");
        Image goal = new Image("/esi/atl/g43335/sokoban/resources/goal.png");
        Image player = new Image("/esi/atl/g43335/sokoban/resources/player.png");

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                ItemType itemType = maze.getCell(new Position(i, j)).getItem().getType();
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
                tile.setStroke(Color.BLACK);

                GridPane.setRowIndex(tile, i);
                GridPane.setColumnIndex(tile, j);

                this.getChildren().add(tile);
            }
        }
    }
}

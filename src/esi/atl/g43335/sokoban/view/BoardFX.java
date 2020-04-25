package esi.atl.g43335.sokoban.view;

import esi.atl.g43335.sokoban.model.ItemType;
import esi.atl.g43335.sokoban.model.Maze;
import esi.atl.g43335.sokoban.model.Position;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
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
        this.setPrefSize(800, 800);
//        Image wall = new Image("/esi/atl/g43335/sokoban/resources/wall.png");

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                ItemType itemType = maze.getCell(new Position(i, j)).getItem().getType();
                Rectangle tile = new Rectangle(25, 25);
                switch (itemType) {
                    case BOX:
                        tile.setFill(Color.RED);
                        break;
                    case BOXGOAL:
                        tile.setFill(Color.GREEN);
                        break;
                    case FLOOR:
                        tile.setFill(Color.BLUE);
                        break;
                    case GOAL:
                        tile.setFill(Color.BLUEVIOLET);
                        break;
                    case PLAYER:
                        tile.setFill(Color.VIOLET);
                        break;
                    case SOKOGOAL:
                        tile.setFill(Color.HOTPINK);
                        break;
                    case WALL:
                        tile.setFill(Color.BLACK);
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

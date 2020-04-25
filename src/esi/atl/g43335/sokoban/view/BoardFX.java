package esi.atl.g43335.sokoban.view;

import esi.atl.g43335.sokoban.model.Item;
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
    private Maze maze;

    public BoardFX() {
        this.setPrefSize(800, 800);

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                ItemType itemType = maze.getCell(new Position(i, j)).getItem().getType();
                Rectangle tile = new Rectangle(10, 10);
                switch (itemType) {
                    case BOX:
                        break;
                    case BOXGOAL:
                        break;
                    case FLOOR:
                        break;
                    case GOAL:
                        break;
                    case PLAYER:
                        break;
                    case SOKOGOAL:
                        break;
                    case WALL:
                        break;
                }
                tile.setFill(Color.CHARTREUSE);
//                tile.setStroke(Color.BLACK);

                GridPane.setRowIndex(tile, i);
                GridPane.setColumnIndex(tile, j);

                this.getChildren().add(tile);
            }
        }
    }

}

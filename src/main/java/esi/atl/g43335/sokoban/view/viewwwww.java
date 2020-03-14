
package esi.atl.g43335.sokoban.view;

import esi.atl.g43335.sokoban.model.Cell;
import esi.atl.g43335.sokoban.model.ItemType;

/**
 *
 * @author franc
 */
public class viewwwww {
    public void displayMaze(Cell[][] cells) {
        for (int i = 0; i < cells.length; i++) {
            for (Cell cell : cells[i]) {
                if (cell.isFree()) {
                    System.out.print(" ");
                } else if (cell.getItem().getType() == ItemType.FLOOR) {
                    System.out.print(".");
                } else if (cell.getItem().getType()== ItemType.WALL) {
                    System.out.print("#");
                } else if (cell.getItem().getType() == ItemType.PLAYER) {
                    System.out.print("@");
                } else if (cell.getItem().getType() == ItemType.BOX) {
                    System.out.print("$");
                }
            }
            System.out.println("");
        }
    }

    
}

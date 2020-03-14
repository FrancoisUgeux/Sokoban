package esi.atl.g43335.sokoban.view;

import esi.atl.g43335.sokoban.model.Cell;
import esi.atl.g43335.sokoban.model.ItemType;
import java.util.Scanner;

/**
 *
 * @author franc
 */
public class viewwwww {

    private Scanner in = new Scanner(System.in);

    public void displayMaze(Cell[][] cells) {
        for (int i = 0; i < cells.length; i++) {
            for (Cell cell : cells[i]) {
                if (cell.isFree()) {
                    System.out.print(" ");
                } else if (cell.getItem().getType() == ItemType.BOX) {
                    System.out.print("$");
                } else if (cell.getItem().getType() == ItemType.GOAL) {
                    System.out.print(".");
                } else if (cell.getItem().getType() == ItemType.WALL) {
                    System.out.print("#");
                } else if (cell.getItem().getType() == ItemType.PLAYER) {
                    System.out.print("@");

                }
            }
            System.out.println("");
        }
    }

    public void displayHelp() {
        System.out.println("move:");
    }

    public String askCommand() {
        return in.nextLine();
    }

}

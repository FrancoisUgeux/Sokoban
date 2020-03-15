package esi.atl.g43335.sokoban.view;

import esi.atl.g43335.sokoban.model.Cell;
import esi.atl.g43335.sokoban.model.ItemType;
import java.util.Scanner;

/**
 *
 * @author franc
 */
public class View {

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
                } else if (cell.getItem().getType() == ItemType.BOXGOAL) {
                    System.out.print("+");
                } else if (cell.getItem().getType() == ItemType.SOKOGOAL) {
                    System.out.print("*");
                }
            }
            System.out.println("");
        }
    }

    public void displayHelp() {
        System.out.println("zqsd: use zqsd to move");
        System.out.println("undo/redo: undo and redo your last command");
        System.out.println("restart: restart your current level");
        System.out.println("next: go to the next level");
    }

    public String askCommand() {
        return in.nextLine();
    }

    public void displayQuit() {
        System.out.println("Thanks for playing");
    }

    public void initialize() {
        System.out.println("Welcome in Sokoban !");
    }

    public void displayLevel() {
        System.out.println("Choose your level ! insert a number from 0 to 1");
    }
}

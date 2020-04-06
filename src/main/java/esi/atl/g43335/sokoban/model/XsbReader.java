package esi.atl.g43335.sokoban.model;

import esi.atl.g43335.sokoban.model.items.Box;
import esi.atl.g43335.sokoban.model.items.Floor;
import esi.atl.g43335.sokoban.model.items.Goal;
import esi.atl.g43335.sokoban.model.items.Player;
import esi.atl.g43335.sokoban.model.items.Wall;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author franc
 */
public class XsbReader {

    private static final int COLUMNS = 40;
    private Maze maze;
    private final char wall = '#';
    private final char box = '$';
    private final char goal = '.';
    private final char soko = '@';
    private final char floor = ' ';

    public XsbReader(Maze maze) {
        this.maze = maze;
    }

    public void levelBuilder(String level) {
        int currentLine = 0;
        try ( BufferedReader reader = new BufferedReader(new FileReader(level))) {
            String line = reader.readLine();
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    char item = line.charAt(i);
                    Position pos = new Position(currentLine, i);
                    switch (item) {
                        case wall:
                            maze.addWall(pos);
                            break;
                        case box:
                            maze.addBox(pos);
                            break;
                        case goal:
                            maze.addGoal(pos);
                            break;
                        case soko:
                            maze.addSoko(pos);
                            break;
                        case floor:
                            maze.addFloor(pos);
                            break;
                    }
                }
                for (int i = Math.min(COLUMNS, line.length()); i < COLUMNS; i++) {
                    Position pos = new Position(currentLine, i);
                    maze.addFloor(pos);
                }
                currentLine++;
                line = reader.readLine();
            }
        } catch (IOException exc) {
            System.out.println("error while creating the maze");
        }
    }
}

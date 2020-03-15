package esi.atl.g43335.sokoban.model;

import esi.atl.g43335.sokoban.model.items.Player;
import esi.atl.g43335.sokoban.model.items.Wall;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author franc
 */
public class MazeTest {

    public MazeTest() {
    }

    @Test
    public void testChooseLevel() {
        System.out.println("chooseLevel");
        int level = 0;
        Maze instance = new Maze();
        instance.chooseLevel(level);
        Cell[][] result = instance.getCells();
    }

    @Test
    public void testGetCellOnWall() {
        System.out.println("getCellOnWall");
        Position position = new Position(0, 0);
        Maze instance = new Maze();
        instance.chooseLevel(0);
        ItemType expResult = new Wall().getType();
        ItemType result = instance.getCell(position).getItem().getType();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetCellOnPlayer() {
        System.out.println("getCellOnPlayer");
        Position position = new Position(3, 2);
        Maze instance = new Maze();
        instance.chooseLevel(0);
        ItemType expResult = new Player(0).getType();
        ItemType result = instance.getCell(position).getItem().getType();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetBoxes() {
        System.out.println("getBoxes");
        Maze instance = new Maze();
        instance.chooseLevel(0);
        ArrayList<Position> expResult = new ArrayList();
        expResult.add(new Position(2, 2));
        ArrayList<Position> result = instance.getBoxes();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInside() {
        System.out.println("isInside");
        Position position = new Position(3, 3);
        Maze instance = new Maze();
        instance.chooseLevel(0);
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsNotInsideUp() {
        System.out.println("isNotInsideUp");
        Position position = new Position(2, -1);
        Maze instance = new Maze();
        instance.chooseLevel(0);
        boolean expResult = false;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsNotInsideLeft() {
        System.out.println("isNotInsideLeft");
        Position position = new Position(-1, 2);
        Maze instance = new Maze();
        instance.chooseLevel(0);
        boolean expResult = false;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsNotInsideRight() {
        System.out.println("isNotInsideRight");
        Position position = new Position(42, 2);
        Maze instance = new Maze();
        instance.chooseLevel(0);
        boolean expResult = false;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsNotInsideDown() {
        System.out.println("isNotInsideDown");
        Position position = new Position(2, 42);
        Maze instance = new Maze();
        instance.chooseLevel(0);
        boolean expResult = false;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsFree() {
        System.out.println("isFree");
        Position p = new Position(1, 1);
        Maze instance = new Maze();
        instance.chooseLevel(0);
        boolean expResult = true;
        boolean result = instance.isFree(p);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsNotFreeWall() {
        System.out.println("isNotFreeWall");
        Position p = new Position(0, 0);
        Maze instance = new Maze();
        instance.chooseLevel(0);
        boolean expResult = false;
        boolean result = instance.isFree(p);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsNotFreeGoal() {
        System.out.println("isNotFreeGoal");
        Position p = new Position(1, 2);
        Maze instance = new Maze();
        instance.chooseLevel(0);
        boolean expResult = false;
        boolean result = instance.isFree(p);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetCells() {
        System.out.println("getCells");
        Maze instance = new Maze();
        Maze test = new Maze();
        Cell[][] expResult = new Cell[40][40];
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                expResult[i][j] = new Cell();
            }
        }
        Cell[][] result = instance.getCells();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testGetStart() {
        System.out.println("getStart");
        Maze instance = new Maze();
        Position expResult = null;
        Position result = instance.getStart();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPut() {
        System.out.println("put");
        Item item = null;
        Position pos = null;
        Maze instance = new Maze();
        instance.put(item, pos);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRemove() {
        System.out.println("remove");
        Position pos = null;
        Maze instance = new Maze();
        instance.remove(pos);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIsBox() {
        System.out.println("isBox");
        Position pos = null;
        Maze instance = new Maze();
        boolean expResult = false;
        boolean result = instance.isBox(pos);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIsGoal() {
        System.out.println("isGoal");
        Position pos = null;
        Maze instance = new Maze();
        boolean expResult = false;
        boolean result = instance.isGoal(pos);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIsBoxGoal() {
        System.out.println("isBoxGoal");
        Position pos = null;
        Maze instance = new Maze();
        boolean expResult = false;
        boolean result = instance.isBoxGoal(pos);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIsSokoGoal() {
        System.out.println("isSokoGoal");
        Position pos = null;
        Maze instance = new Maze();
        boolean expResult = false;
        boolean result = instance.isSokoGoal(pos);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

}

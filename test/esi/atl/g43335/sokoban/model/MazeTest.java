package esi.atl.g43335.sokoban.model;

import esi.atl.g43335.sokoban.model.items.*;
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
        ItemType expResult = new Player().getType();
        ItemType result = instance.getCell(position).getItem().getType();
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
        instance.chooseLevel(0);
        Position expResult = new Position(3, 2);
        Position result = instance.getStart();
        assertEquals(expResult, result);
    }

    @Test
    public void testPutBox() {
        System.out.println("putBox");
        Item item = new Box();
        Position pos = new Position(0, 0);
        Maze instance = new Maze();
        instance.put(item, pos);
        assertTrue(instance.getCell(pos).getItem().getType() == new Box().getType());
    }

    @Test
    public void testPutGoal() {
        System.out.println("putGoal");
        Item item = new Goal();
        Position pos = new Position(0, 0);
        Maze instance = new Maze();
        instance.put(item, pos);
        assertTrue(instance.getCell(pos).getItem().getType() == new Goal().getType());
    }

    @Test
    public void testPutPlayer() {
        System.out.println("putPlayer");
        Item item = new Player();
        Position pos = new Position(0, 0);
        Maze instance = new Maze();
        instance.put(item, pos);
        assertTrue(instance.getCell(pos).getItem().getType() == new Player().getType());
    }

    @Test
    public void testPutSokoGoal() {
        System.out.println("putSokoGoal");
        Item item = new SokoGoal();
        Position pos = new Position(0, 0);
        Maze instance = new Maze();
        instance.put(item, pos);
        assertTrue(instance.getCell(pos).getItem().getType() == new SokoGoal().getType());
    }

    @Test
    public void testPutBoxGoal() {
        System.out.println("putBoxGoal");
        Item item = new BoxGoal();
        Position pos = new Position(0, 0);
        Maze instance = new Maze();
        instance.put(item, pos);
        assertTrue(instance.getCell(pos).getItem().getType() == new BoxGoal().getType());
    }

    @Test
    public void testRemove() {
        System.out.println("remove");
        Position pos = new Position(1, 1);
        Maze instance = new Maze();
        instance.put(new Item(ItemType.GOAL, false), pos);
        instance.remove(pos);
        Item expResult = new Floor();
        Item result = instance.getCell(pos).getItem();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsBox() {
        System.out.println("isBox");
        Position pos = new Position(1,1);
        Maze instance = new Maze();
        instance.put(new Box(), pos);
        boolean expResult = true;
        boolean result = instance.isBox(pos);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsNotBox() {
        System.out.println("isNotBox");
        Position pos = new Position(1,1);
        Maze instance = new Maze();
        instance.put(new Wall(), pos);
        boolean expResult = false;
        boolean result = instance.isBox(pos);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsGoal() {
        System.out.println("isGoal");
        Position pos = new Position(1,1);
        Maze instance = new Maze();
        instance.put(new Goal(), pos);
        boolean expResult = true;
        boolean result = instance.isGoal(pos);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsNotGoal() {
        System.out.println("isNotGoal");
        Position pos = new Position(1,1);
        Maze instance = new Maze();
        instance.put(new Wall(), pos);
        boolean expResult = false;
        boolean result = instance.isGoal(pos);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsBoxGoal() {
        System.out.println("isBoxGoal");
        Position pos = new Position(1,1);
        Maze instance = new Maze();
        instance.put(new BoxGoal(), pos);
        boolean expResult = true;
        boolean result = instance.isBoxGoal(pos);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsNotBoxGoal() {
        System.out.println("isNotBoxGoal");
        Position pos = new Position(1,1);
        Maze instance = new Maze();
        instance.put(new Wall(), pos);
        boolean expResult = false;
        boolean result = instance.isBoxGoal(pos);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsSokoGoal() {
        System.out.println("isSokoGoal");
        Position pos = new Position(1,1);
        Maze instance = new Maze();
        instance.put(new SokoGoal(), pos);
        boolean expResult = true;
        boolean result = instance.isSokoGoal(pos);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsNotSokoGoal() {
        System.out.println("isSokoGoal");
        Position pos = new Position(1,1);
        Maze instance = new Maze();
        instance.put(new Wall(), pos);
        boolean expResult = false;
        boolean result = instance.isSokoGoal(pos);
        assertEquals(expResult, result);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esi.atl.g43335.sokoban.Model;

import esi.atl.g43335.sokoban.model.Cell;
import esi.atl.g43335.sokoban.model.Item;
import esi.atl.g43335.sokoban.model.Maze;
import esi.atl.g43335.sokoban.model.Position;
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
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCell() {
        System.out.println("getCell");
        Position position = null;
        Maze instance = new Maze();
        Cell expResult = null;
        Cell result = instance.getCell(position);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetBoxes() {
        System.out.println("getBoxes");
        Maze instance = new Maze();
        ArrayList<Position> expResult = null;
        ArrayList<Position> result = instance.getBoxes();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetStart() {
        System.out.println("setStart");
        Position start = null;
        Maze instance = new Maze();
        instance.setStart(start);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIsInside() {
        System.out.println("isInside");
        Position position = null;
        Maze instance = new Maze();
        boolean expResult = false;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIsFree() {
        System.out.println("isFree");
        Position p = null;
        Maze instance = new Maze();
        boolean expResult = false;
        boolean result = instance.isFree(p);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCells() {
        System.out.println("getCells");
        Maze instance = new Maze();
        Cell[][] expResult = null;
        Cell[][] result = instance.getCells();
        assertArrayEquals(expResult, result);
        fail("The test case is a prototype.");
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

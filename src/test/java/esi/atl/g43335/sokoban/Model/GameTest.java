/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esi.atl.g43335.sokoban.Model;

import esi.atl.g43335.sokoban.model.Direction;
import esi.atl.g43335.sokoban.model.Game;
import esi.atl.g43335.sokoban.model.Maze;
import esi.atl.g43335.sokoban.model.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author franc
 */
public class GameTest {
    
    public GameTest() {
    }

    @Test
    public void testGetNbMoves() {
        System.out.println("getNbMoves");
        Game instance = null;
        int expResult = 0;
        int result = instance.getNbMoves();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetMaze() {
        System.out.println("getMaze");
        Game instance = null;
        Maze expResult = null;
        Maze result = instance.getMaze();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testStart() {
        System.out.println("start");
        int level = 0;
        Game instance = null;
        instance.start(level);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCurrentLevel() {
        System.out.println("getCurrentLevel");
        int level = 0;
        Game instance = null;
        String expResult = "";
        String result = instance.getCurrentLevel(level);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIsOver() {
        System.out.println("isOver");
        Game instance = null;
        boolean expResult = false;
        boolean result = instance.isOver();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIsGoal() {
        System.out.println("isGoal");
        Position p = null;
        Game instance = null;
        boolean expResult = false;
        boolean result = instance.isGoal(p);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGiveUp() {
        System.out.println("giveUp");
        Game instance = null;
        instance.giveUp();
        fail("The test case is a prototype.");
    }

    @Test
    public void testRestart() {
        System.out.println("restart");
        Game instance = null;
        instance.restart();
        fail("The test case is a prototype.");
    }

    @Test
    public void testNextLevel() {
        System.out.println("nextLevel");
        Game instance = null;
        instance.nextLevel();
        fail("The test case is a prototype.");
    }

    @Test
    public void testMove() {
        System.out.println("move");
        Direction dir = null;
        Game instance = null;
        instance.move(dir);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCanMove() {
        System.out.println("canMove");
        Position pos = null;
        Direction dir = null;
        Game instance = null;
        boolean expResult = false;
        boolean result = instance.canMove(pos, dir);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUndo() {
        System.out.println("undo");
        Game instance = null;
        instance.undo();
        fail("The test case is a prototype.");
    }

    @Test
    public void testRedo() {
        System.out.println("redo");
        Game instance = null;
        instance.redo();
        fail("The test case is a prototype.");
    }
    
}

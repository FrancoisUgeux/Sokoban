package esi.atl.g43335.sokoban.model;

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
        Game instance = new Game(0);
        int expResult = 0;
        int result = instance.getNbMoves();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetMaze() {
        System.out.println("getMaze");
        Game instance = new Game(0);
        Maze expResult = instance.getMaze();
        Maze result = instance.getMaze();
        assertEquals(expResult, result);
    }

    @Test
    public void testStart() {
        System.out.println("start");
        int level = 0;
        Game instance = new Game(level);
        instance.start(level);
    }

//    @Test
//    public void testIsOver() {
//        System.out.println("isOver");
//        Game instance = new Game(0);
//        instance.start(0);
//        boolean expResult = true;
//        instance.move(Direction.UP);
//        boolean result = instance.isOver();
//        assertEquals(expResult, result);
//    }

    @Test
    public void testIsGoal() {
        System.out.println("isGoal");
        Position p = new Position(1, 2);
        Game instance = new Game(0);
        instance.start(0);
        boolean expResult = true;
        boolean result = instance.isGoal(p);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsNoGoal() {
        System.out.println("isGoal");
        Position p = new Position(3, 2);
        Game instance = new Game(0);
        instance.start(0);
        boolean expResult = false;
        boolean result = instance.isGoal(p);
        assertEquals(expResult, result);
    }

    @Test
    public void testRestart() {
        System.out.println("restart");
        Game instance = new Game(0);
        instance.start(0);
        Maze result = instance.getMaze();
        instance.restart();
        Maze expResult = instance.getMaze();
        assertEquals(expResult, result);
    }

    @Test
    public void testNextLevel() {
        System.out.println("nextLevel");
        Game instance = new Game(0);
        instance.start(0);
        instance.nextLevel();
        Maze result = instance.getMaze();
        Game instanceTest = new Game(0);
        instanceTest.start(1);
        Maze expResult = instanceTest.getMaze();
        assertEquals(expResult, result);
    }

    @Test
    public void testMove() {
        System.out.println("move");
        Direction dir = Direction.UP;
        Game instance = new Game(0);
        instance.start(1);
        instance.move(dir);
        ItemType result = instance.getMaze().getCell(new Position(7, 11)).
                getItem().getType();
        ItemType expResult = ItemType.PLAYER;
        assertEquals(expResult, result);
    }

    @Test
    public void testMoveInWall() {
        System.out.println("moveInWall");
        Direction dir = Direction.LEFT;
        Game instance = new Game(0);
        instance.start(1);
        instance.move(dir);
        ItemType result = instance.getMaze().getCell(new Position(8, 11)).
                getItem().getType();
        ItemType expResult = ItemType.PLAYER;
        assertEquals(expResult, result);
    }

    @Test
    public void testCanMove() {
        System.out.println("canMove");
        Position pos = new Position(2, 5);
        Direction dir = Direction.DOWN;
        Game instance = new Game(0);
        instance.start(1);
        boolean expResult = true;
        boolean result = instance.canMove(pos, dir);
        assertEquals(expResult, result);
    }

    @Test
    public void testCantMove() {
        System.out.println("cantMove");
        Position pos = new Position(3, 7);
        Direction dir = Direction.DOWN;
        Game instance = new Game(0);
        instance.start(1);
        boolean expResult = false;
        boolean result = instance.canMove(pos, dir);
        assertEquals(expResult, result);
    }
}

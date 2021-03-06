package esi.atl.g43335.sokoban.model;

import esi.atl.g43335.sokoban.model.items.Player;
import java.util.Stack;
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
        Game instance = new Game();
        int expResult = 0;
        int result = instance.getNbMoves();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetMaze() {
        System.out.println("getMaze");
        Game instance = new Game();
        Maze expResult = instance.getMaze();
        Maze result = instance.getMaze();
        assertEquals(expResult, result);
    }

    @Test
    public void testStart() {
        System.out.println("start");
        int level = 0;
        Game instance = new Game();
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
        Game instance = new Game();
        instance.start(0);
        boolean expResult = true;
        boolean result = instance.isGoal(p);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsNoGoal() {
        System.out.println("isGoal");
        Position p = new Position(3, 2);
        Game instance = new Game();
        instance.start(0);
        boolean expResult = false;
        boolean result = instance.isGoal(p);
        assertEquals(expResult, result);
    }

    @Test
    public void testRestart() {
        System.out.println("restart");
        Game instance = new Game();
        instance.start(0);
        Maze result = instance.getMaze();
        instance.restart();
        Maze expResult = instance.getMaze();
        assertEquals(expResult, result);
    }

    @Test
    public void testNextLevel() {
        System.out.println("nextLevel");
        Game instance = new Game();
        instance.start(0);
        instance.nextLevel();
        Maze result = instance.getMaze();
        Game instanceTest = new Game();
        instanceTest.start(1);
        Maze expResult = instanceTest.getMaze();
        assertEquals(expResult, result);
    }

    @Test
    public void testMove() {
        System.out.println("move");
        Direction dir = Direction.UP;
        Game instance = new Game();
        instance.start(1);
        instance.move(dir);
        ItemType result = instance.getMaze().getCell(new Position(7, 11)).
                getItem().getType();
        ItemType expResult = ItemType.PLAYER;
        assertEquals(expResult, result);
    }

    @Test
    public void testMoveOnGoal() {
        System.out.println("moveOnGoal");
        Game instance = new Game();
        instance.start(0);
        instance.move(Direction.RIGHT);
        instance.move(Direction.UP);
        instance.move(Direction.UP);
        instance.move(Direction.LEFT);
        ItemType result = instance.getMaze().getCell(new Position(1, 2)).
                getItem().getType();
        ItemType expResult = ItemType.SOKOGOAL;
        assertEquals(expResult, result);
    }

    @Test
    public void testMoveInWall() {
        System.out.println("moveInWall");
        Direction dir = Direction.LEFT;
        Game instance = new Game();
        instance.start(1);
        instance.move(dir);
        ItemType result = instance.getMaze().getCell(new Position(8, 11)).
                getItem().getType();
        ItemType expResult = ItemType.PLAYER;
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMoveBox(){
        System.out.println("moveBox");
        Game instance = new Game();
        Position pos = new Position(2,3);
        instance.start(0);
        instance.move(Direction.LEFT);
        instance.move(Direction.UP);
        instance.move(Direction.RIGHT);
        ItemType result = instance.getMaze().getCell(pos).getItem().getType();
        ItemType expResult = ItemType.BOX;
        assertEquals(result, expResult);
    }
    
    @Test
    public void testMoveBoxInWall(){
        System.out.println("moveBoxInWall");
        Game instance = new Game();
        Position pos = new Position(2,3);
        instance.start(0);
        instance.move(Direction.LEFT);
        instance.move(Direction.UP);
        instance.move(Direction.RIGHT);
        instance.move(Direction.RIGHT);
        ItemType result = instance.getMaze().getCell(pos).getItem().getType();
        ItemType expResult = ItemType.BOX;
        assertEquals(result, expResult);
    }
    
    @Test
    public void testMoveBoxOnGoal(){
        System.out.println("moveBoxOnGoal");
        Game instance = new Game();
        Position pos = new Position(1,2);
        instance.start(0);
        instance.move(Direction.UP);
        ItemType result = instance.getMaze().getCell(pos).getItem().getType();
        ItemType expResult = ItemType.BOXGOAL;
        assertEquals(result, expResult);
    }
    
    @Test
    public void testMoveBoxFromGoal(){
        System.out.println("moveBoxFromGoal");
        Game instance = new Game();
        Position pos = new Position(1,1);
        instance.start(0);
        instance.move(Direction.UP);
        instance.move(Direction.RIGHT);
        instance.move(Direction.UP);
        instance.move(Direction.LEFT);
        ItemType result = instance.getMaze().getCell(pos).getItem().getType();
        ItemType expResult = ItemType.BOX;
        assertEquals(result, expResult);
    }
    
    @Test
    public void testMoveBoxinWallFromSokoGoal(){
        System.out.println("moveBoxInWallFromSokoGoal");
        Game instance = new Game();
        Position pos = new Position(1,1);
        instance.start(0);
        instance.move(Direction.UP);
        instance.move(Direction.RIGHT);
        instance.move(Direction.UP);
        instance.move(Direction.LEFT);
        instance.move(Direction.LEFT);
        ItemType result = instance.getMaze().getCell(pos).getItem().getType();
        ItemType expResult = ItemType.BOX;
        assertEquals(result, expResult);
    }
    
    @Test
    public void testMoveBoxinWallFromBoxGoal(){
        System.out.println("moveBoxInWallFromSokoGoal");
        Game instance = new Game();
        Position pos = new Position(1,2);
        instance.start(0);
        instance.move(Direction.UP);
        instance.move(Direction.UP);
        ItemType result = instance.getMaze().getCell(pos).getItem().getType();
        ItemType expResult = ItemType.BOXGOAL;
        assertEquals(result, expResult);
    }

    @Test
    public void testCanMove() {
        System.out.println("canMove");
        Position pos = new Position(2, 5);
        Direction dir = Direction.DOWN;
        Game instance = new Game();
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
        Game instance = new Game();
        instance.start(1);
        boolean expResult = false;
        boolean result = instance.canMove(pos, dir);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetCurrentLevel() {
        System.out.println("getCurrentLevel");
        Game instance = new Game();
        instance.start(1);
        int expResult = 1;
        int result = instance.getCurrentLevel();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetNbGoals() {
        System.out.println("getNbGoals");
        Game instance = new Game();
        instance.start(1);
        int expResult = 6;
        int result = instance.getNbGoals();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetMaxNbGoals() {
        System.out.println("getMaxNbGoals");
        Game instance = new Game();
        instance.start(1);
        int expResult = 6;
        int result = instance.getMaxNbGoals();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetNbMoves() {
        System.out.println("setNbMoves");
        int nbMoves = 10;
        Game instance = new Game();
        instance.setNbMoves(nbMoves);
        int expResult = 10;
        int result = instance.getNbMoves();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetUndoStack() {
        System.out.println("getUndoStack");
        Game instance = new Game();
        Stack<Command> expResult = null;
        Stack<Command> result = instance.getUndoStack();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetRedoStack() {
        System.out.println("getRedoStack");
        Game instance = new Game();
        Stack<Command> expResult = null;
        Stack<Command> result = instance.getRedoStack();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsSurrend() {
        System.out.println("isSurrend");
        Game instance = new Game();
        instance.start(0);
        boolean expResult = false;
        boolean result = instance.isSurrend();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetSurrend() {
        System.out.println("setSurrend");
        Game instance = new Game();
        instance.start(0);
        instance.setSurrend();
        boolean expResult = true;
        boolean result = instance.isSurrend();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsOver() {
        System.out.println("isOver");
        Game instance = new Game();
        instance.start(0);
        boolean expResult = false;
        boolean result = instance.isOver();
        assertEquals(expResult, result);
    }

    @Test
    public void testUndo() {
        System.out.println("undo");
        Game instance = new Game();
        instance.start(0);
        instance.undo();
        Item expResult = new Player();
    }

    @Test
    public void testRedo() {
        System.out.println("redo");
        Game instance = null;
        instance.redo();
        fail("The test case is a prototype.");
    }

    @Test
    public void testUndoStackEmpty() {
        System.out.println("undoStackEmpty");
        Game instance = new Game();
        boolean expResult = true;
        boolean result = instance.undoStackEmpty();
        assertEquals(expResult, result);
    }

    @Test
    public void testRedoStackEmpty() {
        System.out.println("redoStackEmpty");
        Game instance = null;
        boolean expResult = false;
        boolean result = instance.redoStackEmpty();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}

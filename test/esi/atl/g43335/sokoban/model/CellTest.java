package esi.atl.g43335.sokoban.model;

import esi.atl.g43335.sokoban.model.Cell;
import esi.atl.g43335.sokoban.model.Item;
import esi.atl.g43335.sokoban.model.ItemType;
import esi.atl.g43335.sokoban.model.items.Goal;
import esi.atl.g43335.sokoban.model.items.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author franc
 */
public class CellTest {

    public CellTest() {
    }

    @Test
    public void testGetItemFloor() {
        System.out.println("getItemFloor");
        Item item = new Item(ItemType.FLOOR, false);
        Cell instance = new Cell(item);
        Item expResult = item;
        Item result = instance.getItem();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetItemGoal() {
        System.out.println("getItemGoal");
        Item item = new Item(ItemType.GOAL, false);
        Cell instance = new Cell(item);
        Item expResult = item;
        Item result = instance.getItem();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetItemPlayer() {
        System.out.println("getItemPlayer");
        Item item = new Item(ItemType.PLAYER, false);
        Cell instance = new Cell(item);
        Item expResult = item;
        Item result = instance.getItem();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetItemBox() {
        System.out.println("getItemBox");
        Item item = new Item(ItemType.BOX, true);
        Cell instance = new Cell(item);
        Item expResult = item;
        Item result = instance.getItem();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetItemWall() {
        System.out.println("getItemWall");
        Item item = new Item(ItemType.WALL, false);
        Cell instance = new Cell(item);
        Item expResult = item;
        Item result = instance.getItem();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetItemSokoGoal() {
        System.out.println("getItemSokoGoal");
        Item item = new Item(ItemType.SOKOGOAL, true);
        Cell instance = new Cell(item);
        Item expResult = item;
        Item result = instance.getItem();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetItemBoxGoal() {
        System.out.println("getItemBoxGoal");
        Item item = new Item(ItemType.BOXGOAL, true);
        Cell instance = new Cell(item);
        Item expResult = item;
        Item result = instance.getItem();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsFree() {
        System.out.println("isFree");
        Cell instance = new Cell();
        boolean expResult = true;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsNotFree() {
        System.out.println("isNotFree");
        Item item = new Item(ItemType.BOXGOAL, true);
        Cell instance = new Cell(item);
        boolean expResult = false;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
    }

    @Test
    public void testPut() {
        System.out.println("put");
        Item item = new Item(ItemType.GOAL, false);
        Cell instance = new Cell();
        instance.put(item);
        Item expResult = item;
        Item result = instance.getItem();
    }

    @Test
    public void testRemove() {
        System.out.println("remove");
        Item item = new Item(ItemType.BOXGOAL, true);
        Cell instance = new Cell();
        instance.put(item);
        instance.remove();
        boolean expResult = true;
        boolean result = instance.isFree();
    }

}

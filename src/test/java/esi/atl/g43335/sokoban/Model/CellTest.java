package esi.atl.g43335.sokoban.Model;

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
    public void testGetItemDefault() {
        System.out.println("getItemDefault");
        Cell instance = new Cell();
        Item expResult = new Item(ItemType.FLOOR, false);
        Item result = instance.getItem();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetItemFloor() {
        System.out.println("getItemFloor");
        Cell instance = new Cell(new Item(ItemType.FLOOR, false));
        Item expResult = new Item(ItemType.FLOOR, false);
        Item result = instance.getItem();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetItemGoal() {
        System.out.println("getItemGoal");
        Cell instance = new Cell(new Goal());
        Item expResult = new Item(ItemType.GOAL, false);
        Item result = instance.getItem();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetItemPlayer() {
        System.out.println("getItemPlayer");
        Cell instance = new Cell(new Player(0));
        Item expResult = new Item(ItemType.GOAL, false);
        Item result = instance.getItem();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsFree() {
        System.out.println("isFree");
        Cell instance = new Cell();
        boolean expResult = false;
        boolean result = instance.isFree();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPut() {
        System.out.println("put");
        Item item = null;
        Cell instance = new Cell();
        instance.put(item);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRemove() {
        System.out.println("remove");
        Cell instance = new Cell();
        instance.remove();
        fail("The test case is a prototype.");
    }

}

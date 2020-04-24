package esi.atl.g43335.sokoban.model;

import esi.atl.g43335.sokoban.model.items.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author franc
 */
public class ItemTest {

    public ItemTest() {
    }

    @Test
    public void testGetType() {
        System.out.println("getType");
        Item instance = new Item(ItemType.GOAL, false);
        ItemType expResult = ItemType.GOAL;
        ItemType result = instance.getType();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsMoveable() {
        System.out.println("isMoveable");
        Item instance = new Box();
        boolean expResult = true;
        boolean result = instance.isMoveable();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsNotMoveable() {
        System.out.println("isNotMoveable");
        Item instance = new Goal();
        boolean expResult = false;
        boolean result = instance.isMoveable();
        assertEquals(expResult, result);
    }
}

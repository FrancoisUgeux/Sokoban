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
        Item instance = new Item(ItemType.GOAL);
        ItemType expResult = ItemType.GOAL;
        ItemType result = instance.getType();
        assertEquals(expResult, result);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esi.atl.g43335.sokoban.Model;

import esi.atl.g43335.sokoban.model.Item;
import esi.atl.g43335.sokoban.model.ItemType;
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
        Item instance = null;
        ItemType expResult = null;
        ItemType result = instance.getType();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIsMoveable() {
        System.out.println("isMoveable");
        Item instance = null;
        boolean expResult = false;
        boolean result = instance.isMoveable();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}

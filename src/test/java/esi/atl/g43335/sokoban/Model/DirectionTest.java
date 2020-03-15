/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esi.atl.g43335.sokoban.Model;

import esi.atl.g43335.sokoban.model.Direction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author franc
 */
public class DirectionTest {
    
    public DirectionTest() {
    }

    @Test
    public void testValues() {
        System.out.println("values");
        Direction[] expResult = null;
        Direction[] result = Direction.values();
        assertArrayEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String string = "";
        Direction expResult = null;
        Direction result = Direction.valueOf(string);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetRow() {
        System.out.println("getRow");
        Direction instance = null;
        int expResult = 0;
        int result = instance.getRow();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetColumn() {
        System.out.println("getColumn");
        Direction instance = null;
        int expResult = 0;
        int result = instance.getColumn();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}

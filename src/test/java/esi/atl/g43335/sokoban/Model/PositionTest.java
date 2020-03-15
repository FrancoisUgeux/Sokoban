/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esi.atl.g43335.sokoban.Model;

import esi.atl.g43335.sokoban.model.Direction;
import esi.atl.g43335.sokoban.model.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author franc
 */
public class PositionTest {
    
    public PositionTest() {
    }

    @Test
    public void testGetRow() {
        System.out.println("getRow");
        Position instance = null;
        int expResult = 0;
        int result = instance.getRow();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetColumn() {
        System.out.println("getColumn");
        Position instance = null;
        int expResult = 0;
        int result = instance.getColumn();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testNext() {
        System.out.println("next");
        Direction direction = null;
        Position instance = null;
        Position expResult = null;
        Position result = instance.next(direction);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}

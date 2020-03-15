/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esi.atl.g43335.sokoban.Model;

import esi.atl.g43335.sokoban.model.Move;
import esi.atl.g43335.sokoban.model.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author franc
 */
public class MoveTest {
    
    public MoveTest() {
    }

    @Test
    public void testGetStart() {
        System.out.println("getStart");
        Move instance = null;
        Position expResult = null;
        Position result = instance.getStart();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetEnd() {
        System.out.println("getEnd");
        Move instance = null;
        Position expResult = null;
        Position result = instance.getEnd();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}

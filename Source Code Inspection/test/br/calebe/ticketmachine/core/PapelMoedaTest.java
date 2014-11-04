/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.calebe.ticketmachine.core;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author 31238645
 */
public class PapelMoedaTest {
    
    public PapelMoedaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getValor method, of class PapelMoeda.
     */
    @Test
    public void testGetValorValido() {
        PapelMoeda instance = new PapelMoeda(100, 100);
        int expResult = 100;
        int result = instance.getValor();
        assertEquals(expResult, result);
    }
    
    @Test(expected = Exception.class)
    public void testGetValorInvalido() {
        PapelMoeda instance = new PapelMoeda(-100, 100);
    }

    /**
     * Test of getQuantidade method, of class PapelMoeda.
     */
    @Test
    public void testGetQuantidadeValido() {
        PapelMoeda instance = new PapelMoeda(100, 100);
        int expResult = 100;
        int result = instance.getQuantidade();
        assertEquals(expResult, result);
    }
    
    @Test(expected = Exception.class)
    public void testGetQuantidadeInvalido() {
        PapelMoeda instance = new PapelMoeda(100, -100);
    }
}
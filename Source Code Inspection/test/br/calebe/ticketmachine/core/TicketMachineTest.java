/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
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
public class TicketMachineTest {
    
    public TicketMachineTest() {
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
     * Test of inserir method, of class TicketMachine.
     */
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        int quantia = 20;
        TicketMachine instance = new TicketMachine(3);
        instance.inserir(quantia);
        System.out.println("\n\n\n\n");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getSaldo method, of class TicketMachine.
     */
    @Test
    public void testGetSaldo() {
        System.out.println("getSaldo");
        TicketMachine instance = new TicketMachine(3);
        int expResult = 0;
        int result = instance.getSaldo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getTroco method, of class TicketMachine.
     */
    @Test
    public void testGetTroco() throws PapelMoedaInvalidaException {
        System.out.println("getTroco");
        TicketMachine instance = new TicketMachine(3);
        instance.inserir(20);
        boolean expResult = true;
        boolean result = instance.getTroco();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of solicitaBilhete method, of class TicketMachine.
     */
    @Test
    public void testSolicitaBilhete() throws PapelMoedaInvalidaException {
        System.out.println("solicitaBilhete");
        Integer qtdBilhete = 1;
        TicketMachine instance = new TicketMachine(3);
        instance.inserir(20);
        String expResult = "Bilhetes comprados com sucesso!";
        String result = instance.solicitaBilhete(qtdBilhete);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of imprimir method, of class TicketMachine.
     */
    @Test
    public void testImprimir() throws Exception {
        System.out.println("imprimir");
        TicketMachine instance = new TicketMachine(3);
        instance.inserir(20);
        String expResult = "*****************\n";
               expResult += "*** R$ " + instance.getSaldo() + ",00 ****\n";
               expResult += "*****************\n";
        
        String result = instance.imprimir();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
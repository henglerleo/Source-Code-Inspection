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
    //TESTE DOS CAMINHOS ..57  E .. 234...
    @Test
    public void testInserirCam1() throws Exception {
        int quantia = 2;
        TicketMachine instance = new TicketMachine(3);
        instance.inserir(quantia);
        assertEquals(instance.getSaldo(), quantia);        
    }
    //TESTE DOS CAMINHOS ..56 E ..232...
    @Test(expected = Exception.class)
    public void testInserirCam2() throws Exception {
        int quantia = 3;
        TicketMachine instance = new TicketMachine(3);
        instance.inserir(quantia);   
    }
    @Test
    public void testInserirValido() throws Exception {
        int quantia = 20;
        TicketMachine instance = new TicketMachine(3);
        instance.inserir(quantia);
    }

    @Test(expected = Exception.class)
    public void testInserirInvalido() throws Exception {
        int quantia = -20;
        TicketMachine instance = new TicketMachine(3);
        instance.inserir(quantia);
    }
    /**
     * Test of getSaldo method, of class TicketMachine.
     */
    @Test
    public void testGetSaldoValido() {
        TicketMachine instance = new TicketMachine(3);
        int expResult = 0;
        int result = instance.getSaldo();
        assertEquals(expResult, result);
    }

    @Test(expected = Exception.class)
    public void testGetSaldoInvalido() {
        TicketMachine instance = new TicketMachine(2);
        instance.getSaldo();
    }
    
    /**
     * Test of getTroco method, of class TicketMachine.
     */
    @Test
    public void testGetTrocoValido() throws PapelMoedaInvalidaException {
        TicketMachine instance = new TicketMachine(3);
        instance.inserir(20);
        boolean expResult = true;
        boolean result = instance.getTroco();
        assertEquals(expResult, result);
    }
    
    @Test(expected = Exception.class)
    public void testGetTrocoInvalido() throws PapelMoedaInvalidaException {
        TicketMachine instance = new TicketMachine(3);
        instance.inserir(-20);
        instance.getTroco();
    }

    /**
     * Test of solicitaBilhete method, of class TicketMachine.
     */
    @Test
    public void testSolicitaBilheteValido() throws PapelMoedaInvalidaException {
        Integer qtdBilhete = 1;
        TicketMachine instance = new TicketMachine(3);
        instance.inserir(20);
        String expResult = "Bilhetes comprados com sucesso!";
        String result = instance.solicitaBilhete(qtdBilhete);
        assertEquals(expResult, result);
    }
    
    @Test(expected = Exception.class)
    public void testSolicitaBilheteInvalido() throws PapelMoedaInvalidaException {
        Integer qtdBilhete = -1;
        TicketMachine instance = new TicketMachine(3);
        instance.inserir(20);
        String result = instance.solicitaBilhete(qtdBilhete);
    }

    /**
     * Test of imprimir method, of class TicketMachine.
     */
    @Test
    public void testImprimirVaido() throws Exception {
        TicketMachine instance = new TicketMachine(3);
        instance.inserir(20);
        String expResult = "*****************\n";
               expResult += "*** R$ " + instance.getSaldo() + ",00 ****\n";
               expResult += "*****************\n";
        
        String result = instance.imprimir();
        assertEquals(expResult, result);
    }
    
    //teste do caminho 1234567
    @Test
    public void testImprimirCam1() throws Exception {
        TicketMachine instance = new TicketMachine(3);
        instance.inserir(20);
        String expResult = "*****************\n";
               expResult += "*** R$ " + instance.getSaldo() + ",00 ****\n";
               expResult += "*****************\n";
        
        String result = instance.imprimir();
        assertEquals(expResult, result);
    }
    
    //teste do caminho 12
    @Test(expected = Exception.class)
    public void testImprimirCam2() throws Exception {
        TicketMachine instance = new TicketMachine(3);
        instance.inserir(-20);
        instance.imprimir();
    }
    
    @Test(expected = Exception.class)
    public void testImprimir() throws Exception {
        TicketMachine instance = new TicketMachine(3);
        instance.inserir(-20);
        instance.imprimir();
    }
}
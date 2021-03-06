package br.calebe.ticketmachine.core;

import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TrocoTest {

    private Object aux;

    public TrocoTest() {
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
     * Test of getIterator method, of class Troco.
     */
    @Test
    public void getIteratorTestValido(){
        
        PapelMoeda[] papelMoedaList = new PapelMoeda[6];
        papelMoedaList[5] = new PapelMoeda(100, 0);
        papelMoedaList[4] = new PapelMoeda(50, 0);
        papelMoedaList[3] = new PapelMoeda(20, 0);
        papelMoedaList[2] = new PapelMoeda(10, 1);
        papelMoedaList[1] = new PapelMoeda(5, 1);
        papelMoedaList[0] = new PapelMoeda(2, 1);
        int i = 5;
        Troco troco = new Troco(17);
        Iterator result = troco.getIterator();
        while(result.hasNext()){
            Object next = result.next();
            assertEquals(papelMoedaList[i].getQuantidade(), ((PapelMoeda)next).getQuantidade());
            assertEquals(papelMoedaList[i].getValor(), ((PapelMoeda)next).getValor());
            i--;
        }
    }
    
    @Test(expected = Exception.class)
    public void getIteratorTestInvalido(){
        Troco troco = new Troco(-5);
    }
    
    //testa o caminho ..23  ..231...
    @Test
    public void hasNexttCam1(){
        Troco troco = new Troco(150);
        assertEquals(troco.getIterator().hasNext(), true);
    }
    
    @Test
    public void hasNexttCam2(){
        Troco troco = new Troco(0);
        Iterator it;
        it = troco.getIterator();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        
        assertEquals(it.hasNext(), false);
    }
}
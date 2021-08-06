/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homelibrary;

import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Brian
 */
public class LoanTest {
    
    public LoanTest() {
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
     * Test of getAllLoans method, of class Loan.
     */
    @Test
    public void testGetAllLoans() {
        System.out.println("getAllLoans");
        Loan instance = new Loan();
        Collection<Loan> expResult = null;
        Collection<Loan> result = instance.getAllLoans();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLoanDate method, of class Loan.
     */
    @Test
    public void testGetLoanDate() {
        System.out.println("getLoanDate");
        String aTitle = "";
        Loan instance = new Loan();
        String expResult = "";
        String result = instance.getLoanDate(aTitle);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addToAvailableTitles method, of class Loan.
     */
    @Test
    public void testAddToAvailableTitles() {
        System.out.println("addToAvailableTitles");
        String aTitle = "";
        Loan instance = new Loan();
        instance.addToAvailableTitles(aTitle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeTitleFromAvailable method, of class Loan.
     */
    @Test
    public void testRemoveTitleFromAvailable() {
        System.out.println("removeTitleFromAvailable");
        String aTitle = "";
        Loan instance = new Loan();
        instance.removeTitleFromAvailable(aTitle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

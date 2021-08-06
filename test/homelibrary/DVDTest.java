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
public class DVDTest {
    
    public DVDTest() {
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
    HomeLibrary library;
    /**
     * Test of getTitle method, of class DVD.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        DVD instance = new DVD();
        String aTitle = "Star Wars";
        String aRating = "12A";
        String aGenre = "Sci-Fi";
        library.addDVD(aTitle, aRating, aGenre);
        String expResult = "Star Wars";
        String result = instance.getTitle();
        if(expResult.equals(result))
        {
            System.out.println("Passed");
        }
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getDvdRating method, of class DVD.
     */
    @Test
    public void testGetDvdRating() {
        System.out.println("getDvdRating");
        DVD instance = new DVD();
        String aTitle = "Star Wars";
        String aRating = "12A";
        String aGenre = "Sci-Fi";
        library.addDVD(aTitle, aRating, aGenre);
        String expResult = "12A";
        String result = instance.getRating();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getGenre method, of class DVD.
     */
    @Test
    public void testGetGenre() {
        System.out.println("getGenre");
        DVD instance = new DVD();
        String aTitle = "Star Wars";
        String aRating = "12A";
        String aGenre = "Sci-Fi";
        library.addDVD(aTitle, aRating, aGenre);
        String expResult = "Sci-Fi";
        String result = instance.getGenre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    
}

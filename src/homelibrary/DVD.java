/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homelibrary;
import java.util.*;
/**
 *
 * @author Brian
 */


public class DVD
{
    String title;
    String rating;
    String genre;
    Person person;
    Loan loan;
    
    
    Map<String,DVD> dvdInfo = new HashMap<>();
    Set<String> dvdOnLoan = new HashSet<>();
    
    
    // zero argument constructor
    DVD()
    {
        super();
    }
    
    // Constructor for DVD
    DVD (String aTitle,String aRating,String aGenre)
    {
       this.title = aTitle;
        this.rating = aRating + " Cert";
        this.genre = aGenre;
        
    }
    
    
    
    //Returns a dvd title
    String getTitle()
    {
        return title;
    }
    
    // Returns a DVD's age rating
    String getRating()
    {
        return rating;
    }
    
    // returns the length of the film
    String getGenre()
    {
        return genre;
    }
        
     
    
    // end of constructor //
    
    void addDvdLoan(String aTitle)
    {
        dvdOnLoan.add(aTitle);
    }

    void removeDvdLoan(String aTitle)
    {
        dvdOnLoan.remove(aTitle);
    }
    
    // return all of the dvd objects to save function
    public Collection<DVD> getDVDs()
    {
        return dvdInfo.values();
    }
    
    // get all people from loan
    Set<String> getAlldvds()
    {
        return dvdInfo.keySet();
    }
    
    // remove a loan from the dvd title set
    public void removeTheDvd(String aTitle)
    {
        for(String d: dvdInfo.keySet())
        {
            if (d.equals(aTitle))
            {
                dvdInfo.keySet().remove(d);
            }
        }
        System.out.println("dvds = " + dvdInfo.keySet());
    }
    
    boolean isDvd(String aTitle)
    {
        boolean isSo = false;
        
        for(String aDvd: dvdInfo.keySet())
        {
            if(aDvd.equals(aTitle))
            {
                isSo = true;
            }
        }
        return isSo;
    }
    
    void addDvdInfo (String aName, DVD aDVD)
    {
        dvdInfo.put(aName, aDVD);
    }
    
    // get the rating of the selected dvd
    String getDvdInfo(String aTitle, boolean aRating)
    {
        String results = null;
        for (DVD theDvd: dvdInfo.values())
        {
            if ((aTitle == theDvd.getTitle()) && aRating == true)
            {
                results = theDvd.rating;
            }
            else if(aTitle == theDvd.getTitle())
            {
                    results = theDvd.getGenre();
            }
                       
            
        }
        return results;
    }
     
    // Delete a DVD from the system
    String deleteTheDVD(String aName)
    {
        String result = null;
        //boolean check = loan.checkTitleLoan(title);
        for (String theDvd: dvdInfo.keySet())
        {
            if((theDvd.contains(aName)))
            {
                System.out.println("delete dvd not " + theDvd);
                result = aName + " still has a loan.";
            }
            else
            {
                dvdInfo.remove(aName);
                result = aName + " has been removed.";
            }
        }
        return result;
           
           
    }
}
 
    
    


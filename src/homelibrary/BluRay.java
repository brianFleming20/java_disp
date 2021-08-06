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
public class BluRay
{
    String title;
    String rating;
    String genre;
    Loan loan;
    Set<String> blusOnLoan = new HashSet<>();
    Map<String,BluRay> bluInfo = new HashMap<>();
    
    
    // zero argument constructor
    BluRay()
    {
        super();
    }
    
    // BluRay constructor
    BluRay(String aTitle, String aRating,String aGenre)
    {
        this.title = aTitle;
        this.rating = aRating + " Cert";
        this.genre = aGenre;
        
    }
    
    // Returns a Bluray title
    public String getTitle()
    {
        return title;
    }
    
    // Returns a Bluray rating
    public String getBlurayRating()
    {
        return rating;
    }
    
   
    
    // returns the length od the film
    public String getGenre()
    {
        return genre;
    }
    
    
    
    // end of constructor //
    
    // returns all of the bluray objects to the save function
    public Collection<BluRay> getAllBlurays()
    {
        return bluInfo.values();
    }
    
     // add all of the blurays on loan
    public void addBlurayOnLoan(String aTitle)
    {
        blusOnLoan.add(aTitle);
    }
    
    public void removeBlurayOnLoan(String aTitle)
    {
        blusOnLoan.remove(aTitle);
    }
    
    // get all people from loan
    public Set<String> getBlurays()
    {
        return bluInfo.keySet();
    }
    
    void addBluInfo(String aTitle, BluRay aBluray)
    {
        bluInfo.put(aTitle, aBluray);
    }
    
    // check to see if the title belogs to the bluray titles
    public boolean isBlue(String aTitle)
    {
        boolean isSo = false;
        for(String aBlu: bluInfo.keySet())
        {
            if(aBlu.equals(aTitle))
            {
                isSo = true;
            }
        }
        return isSo;
    }
    
    // get rating of the selected blu-ray
    public String getBluInfo(String aTitle, boolean aRating)
    {
        String result = null;
        for (BluRay theBlu: bluInfo.values())
        {
            if ((theBlu.getTitle().equals(aTitle)) && (aRating == true))
            {
                result = theBlu.rating;
            }
            else if((theBlu.getTitle().equals(aTitle)) && (aRating == false))
            {
                result = theBlu.getGenre();
            }
        }
        return result;
    }
    
    // Delete a Bluray from the system
    String deleteTheBlu(String aTitle)
    {
        
        String result = null;
        boolean check = loan.checkTitleLoan(aTitle);
        for (String blu: bluInfo.keySet())
        {
            if((blu.contains(aTitle)) && (check = false))
            {
                System.out.println("delete bluray has loan " + blu);
                result = aTitle + " still has a loan.";
                
            }
            else
            {
                bluInfo.remove(aTitle);
                result = aTitle + " has been removed.";
            }
        }
        return result;
    }
}


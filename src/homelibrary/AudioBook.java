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
public class AudioBook
{
    String title;
    String nurrator;
    String author;
    Loan loan;
    Set<String> audioBookOnLoan = new HashSet<>();
    Map<String,AudioBook> audioInfo = new HashMap<>();
    
    // Zero argument constructor
    AudioBook()
    {
        super();
        
    }
    
    // Constructor for audiobook
    AudioBook(String aTitle, String aNurrator, String anAuthor)
    {
        title = aTitle;
        nurrator = aNurrator;
        author = anAuthor;
        
    }
    
    // getter for title
    String getTitle()
    {
        return title;
    }
    
    // getter for nurrator
    String getNurrator()
    {
        return nurrator;
    }
     //getter for author
    String getAuthor()
    {
        return author;
    }
    
    
    
    // end of constructor //
    // returns all of the audiobook objects to the save function
    public Collection<AudioBook> getAllAudio()
    {
        return audioInfo.values();
    }
    
     // add all of the audiobooks on loan
    void addAudioOnLoan(String aTitle)
    {
        audioBookOnLoan.add(aTitle);
    }
    
    public void removeAudioOnLoan(String aTitle)
    {
        audioBookOnLoan.remove(aTitle);
    }
    
    // get all people from loan
    Set<String> getAudioBooks()
    {
        return audioInfo.keySet();
    }
    
    // check to see if the title belong to the audio titles
     boolean isAudiob(String aTitle)
    {
         boolean isSo = false;
        for(String audio: audioInfo.keySet())
        {
            if(audio.equals(aTitle))
            {
                isSo = true;
            }
        }
        return isSo;
    }
     
    // Add the audiobooks to the audiobook class
    void addAudioInfo(String aTitle, AudioBook aAudiobook)
    {
        audioInfo.put(aTitle,aAudiobook);
    }
    
    // get autor for selected audiobook
    public String getAudioInfo(String aName, boolean anAuthor)
    {
        String result = null;
        for (AudioBook theAudio: audioInfo.values())
        {
            if ((aName.equals(theAudio.getTitle())) && (anAuthor == true))
            {
                result = theAudio.getAuthor();
            }
            else if((aName.equals(theAudio.getTitle())) && (anAuthor == false))
            {
                result = theAudio.getNurrator();
            }
        }
        return result;
    }
    
    // Delete a AudioBook from the system
    public String deleteTheAudio(String aName)
    {
        String result = null;
        //boolean check = loan.checkTitleLoan(title);
        for (String aud: audioInfo.keySet())
        {
            if((aud.contains(aName)))
            {
                System.out.println("delete audio not " + aud);
                result = aName + " still has a loan.";
                
            }
            else
            {
                audioInfo.remove(aName);
                result = aName + " has been removed.";
            }
        }
        return result;
    }
}

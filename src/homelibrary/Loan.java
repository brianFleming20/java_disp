/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homelibrary;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


//import m256date.*;

/**
 *
 * @author Brian
 */
public class Loan
{
    
    
    String date;
    String personWithLoan;
    String itemOnLoan;
    HomeLibrary library;
    Person person;
    Set<String> availableTitles = new HashSet<>();
    Map<String,Loan> loans = new HashMap<>();
    //Set<Loan> theLoans = new HashSet<>();
    
    
    // zero argument constructor for loan
    Loan ()
    {
       super();
    }
    
    // constructor of loans
    public Loan(String aPerson, String aTitle)
    {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String today = df.format(new Date());
        this.personWithLoan = aPerson;
        this.itemOnLoan = aTitle;
        this.date = today;
        
        
    }
    
    public Loan(String aPerson, String aTitle, String aDate)
    {
        this.personWithLoan = aPerson;
        this.itemOnLoan = aTitle;
        this.date = aDate;
        
    }
    
    // returning a list of people with loans
     String getPeopleWithLoans()
    {
        return personWithLoan;
    }
    
    // return a list of films on loan
    String getFilmsOnLoan()
    {
        return itemOnLoan;
    }
    
    // date of the load starting
    String getDate()
    {
        return date;
    }
      
    
    
    
    // end of constructor//
    
    // returns all of the loan objects to the save function
    public Collection<Loan> getAllLoans()
    {
       return loans.values();
    }
    // returns the collection that is the people with loans
    Collection getallPeopleWithLoans()
    {
       
       return loans.keySet();
    }
    
    // returns the collection of items on loanfrom the titles
    Collection getItemsOnLoan()
    {
        Collection results = new HashSet<>();
        for(Loan theLoan: loans.values())
        {
            results.add(theLoan.getFilmsOnLoan());
        }
        return results;
    }
    
    
    // check for a loan
    boolean checkPersonLoan(String aName)
    {
       return loans.containsKey(this);
    }
    
    // check for a loan
    boolean checkTitleLoan(String aTitle)
    {
         boolean check = false;
        for(Loan l: loans.values())
        {
            if (aTitle.contains(l.getFilmsOnLoan()))
            {
                check = true;
                System.out.println("check title during " + check);
            }
        }
        return check;
    }
   
    
    // return a loan / delete the loan from the system
    String returnAloan(String aTitle)
    {
        
        String result = null;
        boolean delete = false;
        String personWithLoan = null;
        for (Map.Entry<String, Loan> theLoan : loans.entrySet())
        {
            if (aTitle.contains(theLoan.getValue().getFilmsOnLoan()))
            {
                delete = true;
                personWithLoan = theLoan.getKey();
            }
        }
        if(delete = true)
        {
            loans.remove(personWithLoan);
            
        }
        return result;
    }
    
    // get the date of the loan title
    public String getLoanDate(String aTitle)
    {
        String personLoanDate = null;
        for (Loan l: loans.values())
        {
            if (aTitle.equals(l.getFilmsOnLoan()))
            {
                personLoanDate = l.getDate();
            }
        }
        return personLoanDate;
    }
    
    // returns the name of the person with a loan
    String getLoanName(String aTitle)
    {
        
        String result = null;
        for (Loan l: loans.values())
        {
            if (aTitle.equals(l.getFilmsOnLoan()))
            {
                result = l.getPeopleWithLoans();
            }
        }
        return result;
    }
    
    // return all the titles that are not on loan
    Collection getAvailabeTitles()
    {
        return availableTitles;
    }
    
    // gets all of the titles in the system
    public void addToAvailableTitles(String aTitle)
    {
        availableTitles.add(aTitle);  
    }
    
    // remove a title from the availble titles list
    public void removeTitleFromAvailable(String aTitle)
    {
        availableTitles.remove(aTitle);
    }
    
    // copy a loan into the loan class
    void addLoans(String aPerson, Loan aLoan)
    {
        
        loans.put(aPerson, aLoan);
        System.out.println(" loans in " + loans.keySet().toString());
    }
    
   
}



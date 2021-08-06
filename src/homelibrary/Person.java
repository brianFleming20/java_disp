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
public class Person
{
    int age;
    String name;
    String phoneNumber;
    String postcode;
    HomeLibrary library;
    Set<String> loanInfo;
    //Map<String,Set<String>> peopleWithLoans = new HashMap<>();
    Map<String,Person> personInfo = new HashMap<>();
    
    Loan loan;
    
    
    
    // zero argument constructor
    Person()
    {
        super();
        
    }
    
    // Constructor for person
    Person(String aName, int anAge, String aPhone, String aPostcode)
    {
        this.name = aName;
        this.age = anAge;
        this.phoneNumber = " " + aPhone;
        this.postcode = aPostcode;
        
    }
    
    void addLoanToPerson(String aTitle, String aPerson, String aDate)
    {
        loanInfo.add(aPerson);
        loanInfo.add(aDate);
        
    }
    
    
    
    // getter for person'a name
    String getName()
    {
        return name;
    }
    
    // getter for person's age
    int getAge()
    {
        return age;
    }
    
    // getter for person's phone number
    String getPhoneNumber()
    {
        return phoneNumber;
    }
    
    // getter for a persons postcode
    String getPostcode()
    {
        return postcode;
    }
    
    
    // end of constructor //
    
    // return all of the people objects to the save function
    Collection<Person> getPeoples()
    {
        return personInfo.values();
    }
    
    
    
    
    
    // get all people from loan
    Set<String> getAllPeople()
    {
        return personInfo.keySet();
    }
    
    //
    
    // add a name and a person object to the map for further processing
    void addPersonInfo(String aName, Person thePerson)
    {
        personInfo.put(aName,thePerson);
        
    }
    
    // Get a persons postcode from the collection of personData
    int getTheAge(String aName)
    {
         int theAge = 0;
         
         for(Person p: personInfo.values())
         {
             
             if (aName == p.getName())
             {
                 theAge = p.getAge();
             }
         }
         return theAge;
    }
    
     // Get age from the selected name from the JList
    String getPersonsInfo(String aName, boolean choose)
    {
        
        String result = null;
        
        for(Person p: personInfo.values())
        {
           if((aName == p.getName()) && choose == true)
            {
                result = p.getPostcode();
            }
            else if(aName == p.getName())
            {
                result = p.getPhoneNumber();
            }
            
        }
        
        return result;
    }
    
    String deleteAperson(String aName)
    {
        loan = new Loan();
       String result = null;
       boolean check = loan.checkPersonLoan(aName);
       System.out.println("check person = " + check);
            personInfo.remove(aName);
            result = aName + " has been removed.";
        return result;
    }
    
   
}

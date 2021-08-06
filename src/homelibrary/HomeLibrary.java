/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homelibrary;

import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;



/**
 *
 * @author Brian Fleming
 * This application is to record the people that wish to borrow
 * either DVD's Blu-Ray's or Audio books that I have in my collection.
 * 
 */
public class HomeLibrary implements Serializable
{
    Person person = new Person();
    Loan loan = new Loan();
    DVD dvd = new DVD();
    BluRay bluray = new BluRay();
    AudioBook audio = new AudioBook();
    
    String path;
    List delete;
    Date date;
    
    // zero argument constructor
    public HomeLibrary()
    {
        super();
    }
    
    // create a person object.
    public void addPerson(String aName, int anAge, String aPhone, String aPostcode)
    {
        person.addPersonInfo(aName, new Person(aName,anAge,aPhone,aPostcode) );
    }
    
    // Create a new loan from the user
    public String addNewLoan(String aPerson, String aTitle)
    {
        loan.addLoans( aPerson, new Loan(aPerson,aTitle) );
        String status = "Loan added...";
        return status;
    }
    
    // Create a loan object from the persistance
     public void loadLoanFromFile(String aName, String aTitle, String aDate)
    {
        loan.addLoans( aName, new Loan(aName, aTitle, aDate));
    }
    
    // create a dvd film object
    public void addDVD(String aTitle, String aRating, String aGenre)
    {
        dvd.addDvdInfo(aTitle, new DVD(aTitle,aRating,aGenre));
        loan.addToAvailableTitles(aTitle);
    }
    
    // create a bluRay film object
    public void addBluRay(String aTitle, String aRating, String aGenre)
    {
        bluray.addBluInfo(aTitle, new BluRay(aTitle,aRating,aGenre));
        loan.addToAvailableTitles(aTitle);
    }
    
    // create an audioBook object
    public void addAudioBook(String aTitle, String aNurrator, String anAuthor)
    {
        audio.addAudioInfo(aTitle, new AudioBook(aTitle,aNurrator,anAuthor));
        loan.addToAvailableTitles(aTitle);
    }
    
    // Perple section of the system 
    
    // Get age from the selected name from the JList
    public String getPersonInfo(String aName, boolean choose)
    {
        return person.getPersonsInfo(aName, choose);
    }
    
    // Get a persons postcode from the collection of personData
    public int getAge(String aName)
    {
        return person.getTheAge(aName);
    }
    
     // get all of the people from the system
    public Collection getAllPeople()
    {
        return person.getAllPeople();
    }
    
    //Delete a person from the system
    public String deletePerson(String aName)
    {
       
       return person.deleteAperson(aName);
    }
    // DVD section of the system.
    
    // get the rating of the selected dvd
    public String getDvdRating(String aTitle, boolean aRating)
    {
        return dvd.getDvdInfo(aTitle, aRating);
    }
    
     //get all of the DVD titles in the system
    public Collection getDVDTitles()
    {
        return dvd.getAlldvds();
    }
    
    // Delete a DVD from the system
    public String deleteDVD(String aName)
    {
        
       return dvd.deleteTheDVD(aName);
    }
    
     public boolean isDVD(String aTitle)
    {
        return dvd.isDvd(aTitle);
    }
    
    // Bluray section of the system.
    
    // get rating of the selected blu-ray
    public String getBluRating(String aTitle, boolean aRating)
    {
        return bluray.getBluInfo(aTitle, aRating);
    }
     // get all of the BluRays titles from the system
    public Collection getAllBluRays()
    {
        return bluray.getBlurays();
    }
    
    // delete a BluRay from the system
    public String deleteBlu(String aName)
    {
       
        return bluray.deleteTheBlu(aName);
    }
    
     public boolean isBlu(String aTitle)
    {
        return bluray.isBlue(aTitle);
    }
     
     
    
    // Audiobook section of the system.
    // get autor for selected audiobook
    public String getAudioAuthor(String aName, boolean anAuthor)
    {
        return audio.getAudioInfo(aName, anAuthor);
    }
    
    // get all of the AudioBooks titles from the system
    public Collection getAllAudioBooks()
    {
        return audio.getAudioBooks();
    }
    
    // delete the title of the audiobook
    public String deleteAudio(String aTitle)
    {
        return audio.deleteTheAudio(aTitle);
    }
    
    public boolean isAudio(String aTitle)
    {
        return audio.isAudiob(aTitle);
    }
    
   
    
    // Loans area of the system.
    
    // find all the load taken out
    public Collection getLoans()
    {
        return loan.getItemsOnLoan();
    }
    
    // get the person with the loan
    public String getPersonWithLoan(String aTitle)
    {
        return loan.getLoanName(aTitle);
    }
   
    // remove a title sfter ithas been taken out on loan
    public void removeLoanTitle(String aTitle)
    {
        loan.removeTitleFromAvailable(aTitle);
    }
    
    // return a set of all the titles in the system
    public Collection getTitles()
    {
        return loan.getAvailabeTitles();
    }
  
    // delete loan itemforreturn to all titles
    public String returnLoan(String aTitle)
    { 
       return loan.returnAloan(aTitle);
    }
    
    
    // get the date of the loan title
    public String getLoanDate(String aTitle)
    {
       
        return loan.getLoanDate(aTitle);
    }
    
   
    
   
    
    // Persistance of the system
    
    public void saveSystem() throws IOException
    {
        JOptionPane.showMessageDialog(null, "Saving System", "Home Library", 
                              JOptionPane.INFORMATION_MESSAGE);
        String pathPerson = "C:\\Users\\brian\\Documents\\TM470\\personalData/person.csv";
        String pathDvd = "C:\\Users\\brian\\Documents\\TM470\\personalData/dvd.csv";
        String pathBlu = "C:\\Users\\brian\\Documents\\TM470\\personalData/bluRay.csv";
        String pathAudio = "C:\\Users\\brian\\Documents\\TM470\\personalData/audio.csv";
        String pathLoan = "C:\\Users\\brian\\Documents\\TM470\\personalData/loan.csv";
        
        BufferedWriter bufferedFileWriter = null;
        try
        {
            // save the data for the person class
            File file = new File(pathPerson);
            bufferedFileWriter = new BufferedWriter(new FileWriter(file));
            for (Person p: person.getPeoples())
            {
                bufferedFileWriter.write(p.getName() + "," + p.getAge() + "," +
                        p.getPostcode() + "," + p.getPhoneNumber());
                bufferedFileWriter.newLine();
            }
             bufferedFileWriter.close();
             
            // save the data for the dvd class
             File fileDvd = new File(pathDvd);
             
            bufferedFileWriter = new BufferedWriter(new FileWriter(fileDvd));
            for (DVD advd: dvd.getDVDs())
            {
                bufferedFileWriter.write(advd.getTitle() + "," + advd.getRating()
                 + "," + advd.getGenre());
                bufferedFileWriter.newLine();
            }
             bufferedFileWriter.close();
             
            // save the data for the bluRay class
            File fileBlu = new File(pathBlu);
            bufferedFileWriter = new BufferedWriter(new FileWriter(fileBlu));
            for (BluRay ablu: bluray.getAllBlurays())
            {
                bufferedFileWriter.write(ablu.getTitle() + "," + ablu.getBlurayRating()
                 + "," + ablu.getGenre());
                bufferedFileWriter.newLine();
            }
            bufferedFileWriter.close();
            
            // save the data for the audio book class
            File fileAudio = new File(pathAudio);
            bufferedFileWriter = new BufferedWriter(new FileWriter(fileAudio));
            for (AudioBook book: audio.getAllAudio())
            {
                bufferedFileWriter.write(book.getTitle() + "," + book.getAuthor()
                 + "," + book.getNurrator());
                bufferedFileWriter.newLine();
            }
             bufferedFileWriter.close();
             
            // save the data for the loan class
            File fileLoan = new File(pathLoan);
            bufferedFileWriter = new BufferedWriter(new FileWriter(fileLoan));
            if (loan.getAllLoans().isEmpty())
            {
                bufferedFileWriter.write("No Loans");
            }
            else{
            for (Loan aLoan: loan.getAllLoans())
            {
                bufferedFileWriter.write(aLoan.getPeopleWithLoans() + "," + 
                        aLoan.getFilmsOnLoan() + "," + aLoan.getDate());
                bufferedFileWriter.newLine();
            }
            
            }
        }
        catch(Exception e)
        {
            System.out.println("Error..." + e);
            
        }
        finally
        {
            try
            {
                bufferedFileWriter.close();
            }
            catch(Exception ex)
            {
                System.out.println("Error..." + ex);
            }
        }
    }
    
    public void loadSystem()
    {
       
        JOptionPane.showMessageDialog(null, "Loading System", "Home Library", 
                              JOptionPane.PLAIN_MESSAGE);
        String pathPerson = "C:\\Users\\brian\\Documents\\TM470\\personalData/person.csv";
        String pathDvd = "C:\\Users\\brian\\Documents\\TM470\\personalData/dvd.csv";
        String pathBlu = "C:\\Users\\brian\\Documents\\TM470\\personalData/bluRay.csv";
        String pathAudio = "C:\\Users\\brian\\Documents\\TM470\\personalData/audio.csv";
        String pathLoan = "C:\\Users\\brian\\Documents\\TM470\\personalData/loan.csv";
        
        BufferedReader bufferedFileReader = null;
        String aName, aPost, aPhone;
        int anAge;
        String title, rating, genre, author, nurrator;
        String currentLine;
        Scanner lineScanner;
        try
        {
            File filePerson = new File(pathPerson);
            bufferedFileReader = new BufferedReader(new FileReader(filePerson));
            currentLine = bufferedFileReader.readLine();
            // load the data for the person class.
            while(currentLine != null)
            {
                lineScanner = new Scanner(currentLine);
                lineScanner.useDelimiter(",");
                aName = lineScanner.next();
                anAge = Integer.parseInt(lineScanner.next());
                aPost = lineScanner.next();
                aPhone = lineScanner.next();
                addPerson(aName,anAge,aPhone,aPost);
                currentLine = bufferedFileReader.readLine();
            }
             bufferedFileReader.close();
            // load the data for the dvd class
             File fileDvd = new File(pathDvd);
            bufferedFileReader = new BufferedReader(new FileReader(fileDvd));
            currentLine = bufferedFileReader.readLine();
            while(currentLine != null)
            {
                lineScanner = new Scanner(currentLine);
                lineScanner.useDelimiter(",");
                title = lineScanner.next();
                rating = lineScanner.next();
                genre = lineScanner.next();
                addDVD(title,rating,genre);
                
                currentLine = bufferedFileReader.readLine();
            }
             bufferedFileReader.close();
             
            // load the data for the bluray class
            File fileBlu = new File(pathBlu);
            bufferedFileReader = new BufferedReader(new FileReader(fileBlu));
            currentLine = bufferedFileReader.readLine();
            while(currentLine != null)
            {
                lineScanner = new Scanner(currentLine);
                lineScanner.useDelimiter(",");
                title = lineScanner.next();
                rating = lineScanner.next();
                genre = lineScanner.next();
                addBluRay(title,rating,genre);
                currentLine = bufferedFileReader.readLine();
            }
             bufferedFileReader.close();
             
            // load the data for the audio book class
            File fileAudio = new File(pathAudio);
            bufferedFileReader = new BufferedReader(new FileReader(fileAudio));
            currentLine = bufferedFileReader.readLine();
            while (currentLine != null)
            {
                lineScanner = new Scanner(currentLine);
                lineScanner.useDelimiter(",");
                title = lineScanner.next();
                nurrator = lineScanner.next();
                author = lineScanner.next();
                addAudioBook(title,nurrator,author);
                currentLine = bufferedFileReader.readLine();
            }
             bufferedFileReader.close();
             
            // load the data for the loan class
            File fileLoan = new File(pathLoan);
            
            bufferedFileReader = new BufferedReader(new FileReader(fileLoan));
            currentLine = bufferedFileReader.readLine();
            while (currentLine != null)
            {
                lineScanner = new Scanner(currentLine);
                lineScanner.useDelimiter(",");
                aName = lineScanner.next();
                title = lineScanner.next();
                String date = lineScanner.next();
                loadLoanFromFile(aName,title,date);
                loan.removeTitleFromAvailable(title);
                currentLine = bufferedFileReader.readLine();
            }
        }
        catch(Exception e)
        {
            System.out.println("Error on loading data" + e);
        }
        finally
        {
            try
            {
                bufferedFileReader.close();
            }
            catch(Exception ex)
            {
                System.out.println("Error..." + ex);
            }
        }

    }
    
   
    
    public void testData()
    {
        addPerson("Jack",21,"0124386312","PO12");
        addPerson("Brian",40,"0190372812","BN16");
        addPerson("Tiny Tim",90,"01903881201","BN18");
        addPerson("Mr. White",27,"01903001122","SW12");
        addPerson("Granny",85,"01817773432","BN17");
        addDVD("Star Wars","12A","Sci-Fi");
        addDVD("Tomas Tank goes awol","15","Adult Comerdy");
        addBluRay("The Kingsmen","15","Action");
        addBluRay("i Robot","15","Sci-Fi");
        addAudioBook("The Green Mile","somebody","Wilber Smith");
        addAudioBook("Cary","reader","Mr Jones");
    }

   
   
}

       
   


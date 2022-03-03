package emailapp;

import java.util.Scanner;
import java.util.Random;
public class Email {
   private String firstName;
   private String lastName;
   private String password;
   private String department;
   private String email;
   private String alternateEmail;
   private String companySuffix = "company.com";
   private int mailboxCapcity =500; // default chosen value 
   private int defaultPasswordLength = 10;
   //Constructor to receive First name and Last name
    public Email(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email Created: "+ this.firstName+" "+this.lastName);
       
       //Call a method asking for the department and return department
        this.department = this.SetDepatrment();
        System.out.println("Department: "+ this.department);
       
       //Call a method that return a random password
        this.password = RandomPassword(defaultPasswordLength);
        System.out.println("Your Password: "+ this.password);
        
       //Combine Elements to Generate Email
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase()+ "@" + this.department + "." + this.companySuffix;
        System.out.println("Your Email is: "+ this.email);
    }

    // Ask for the department
    private String SetDepatrment() {
        System.out.print("Enter the department: \n  1 for Sales\n  2 for Development\n  3 for Accounting\n  0 for None \n Enter Choice: ");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        if (choice == 1) {return "sales";}
        else if (choice == 2) {return "dev";}
        else if (choice == 3) {return "acc";}
        else if (choice == 0) {return "";}
        else
           {
             System.out.println("Wrong Choice");
             return this.SetDepatrment();
            }
        
  
    }
    
    
    //Generate a random Password
     private String RandomPassword(int length) {
         // alphabet and numbers and some special characters 
           String passwordSet ="ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxtz0123456789!@#$%^&*";
           Random rand = new Random();
           char[] Password = new char[length];
           int length_of_set = passwordSet.length();
           for (int i=0; i<length; i++ ) {
               Integer temp = rand.nextInt(length_of_set)-1;
               Password[i] =  passwordSet.charAt(temp);
           }
         return new String(Password);
        }
    
    // Set the mailbox capacity
     public void SetMailboxCapacity(int newCap) {
        this.mailboxCapcity = newCap;
      } 
    
    //Set alternate Email 
     public void SetAlternateEmail(String altEmail) {
          this.alternateEmail = altEmail;
      }

    // Change the password
     public void ChangePassword (String newPassword) {
        this.password = newPassword;
     }

    //Getters
    
     public int getMailboxCapcity() {return this.mailboxCapcity;}
     public String getAlternateEmail(){return this.alternateEmail;}
    
    //Display Information
     public String toString() {
        
        return "Name: "+this.firstName+" "+this.lastName+"\n"
        +"Department: "+this.department+"\n"
        +"Email: "+this.email+"\n"
        +"Password: "+this.password+"\n"
        +"Alternate Email: "+this.alternateEmail+"\n"
        +"Mailbox Capacity: "+this.mailboxCapcity;
         
     }
}

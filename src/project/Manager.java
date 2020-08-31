/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
/**
 *
 * @author Josh
 * Overview: Manager is a Person, has an array of customers, and is a singleton.
 * This class is mutable
 */
import java.util.*;
import java.io.*;
 
//AF(c) = {super.toString() + usernames}
 //Rep Invariant: No customer usernames are repeated && super.repOK()
public class Manager extends Person{
    
    private static Manager instance = null;
    private String fileName ="";
   private File f;
    private PrintWriter p;
    private static ArrayList<Customer> customers = new ArrayList<Customer>();
     private static ArrayList<String> usernames = new ArrayList<String>();
    private static File cFile = new File("initial.txt");
    /**
     * Requires:None
     * Modifies:None
     * Effects:Creates a manager object and initializes customers to the array from a data file
     */
    private Manager(){
        super("admin", "admin", true);   
        
               try{
            Scanner x1 = new Scanner(cFile);
            
            
           
        while(x1.hasNext()){
            usernames.add(x1.nextLine());
            
        }
        
       System.out.println(usernames);
        
        for(int i=0; i<usernames.size(); i++){
            Scanner x = new Scanner(new File(usernames.get(i)+".txt"));
           
                String user = x.nextLine();
                String passW = x.nextLine();
                String sd = x.nextLine();
               double d = Double.parseDouble(sd);
                
            
                Customer q = new Customer(user, passW);
                q.b.bal = d;
                customers.add(q);
            
            
        
        }
        
        
        
        }catch(Exception e){
            System.out.println("No customer file");
        }
        
        
    }
    /**
     * Requires:None
     * Modifies:None
     * Effects: Allows for there to be only a single instance of this class
     * @return the single instance of the manager class
     */
    public static Manager getInstance(){
        
        if(instance==null)
            instance = new Manager();
        return instance;
    }
    
    /**
     * Requires: 2 strings, one for the username and one for the password of the new customer
     * Modifies:None
     * Effects:Adds a customer to the customer array. If the customer exists already (based on the username) the customer will not be added or overwritten
     * @param u username of the customer to be added
     * @param pass password of the customer to be added
     * @return true if the customer is added, false if they are not
     */
    public boolean addCustomer(String u, String pass){
        boolean found = false;
        for(int i =0; i<customers.size(); i++){
            
            if(customers.get(i).username.equals(u))
            found = true;
            
        }
       
        if(!found){
       Customer c = new Customer(u, pass);
       customers.add(c);
      fileName = u;
            try{
                f= new File(fileName +".txt");
        p = new PrintWriter(f);
        
        String str = Double.toString(c.getBal());
        
        p.print(u + "\n" + pass + "\n" +str +"\n");
        
        FileWriter fw = new FileWriter(cFile, true);
        PrintWriter p2 = new PrintWriter(fw, true);
        p2.print(u + "\n");
        p2.close();
        
        
                p.close();
                return true;
}
catch(Exception e){
    System.out.println("IO Exception");
}
            
            
        }
        return false;
    }
    
    /**
     * Requires:The username of an existing customer
     * Effects:None
     * Modifies: Gives desired customer if they exist, and null otherwise
     * @param s The username of the customer
     * @return the customer if the customer exists. If not null
     */
    public Customer getCustomer(String s){
    	
    	for(int i=0; i<customers.size(); i++){
    		 if(customers.get(i).username.equals(s)){
    		return customers.get(i);
    	}
    	}
    	return null;
    }
    
    /**
     * Requires: A string that is the username of the desired customer to be deleted
     * Modifies:None
     * Effects: Deletes a customer if they exist and returns true. If they don't returns false
     * @param notUsed the username of the customer you want to delete
     * @return true if the customer is deleted, false otherwise
     */
    public boolean deleteCustomer(String notUsed){
        for(int i =0; i<customers.size(); i++){
            if(customers.get(i).username.equals(notUsed)){
              customers.remove(i);
                File a= new File(notUsed + ".txt");         
  
                try{
    		PrintWriter p = new PrintWriter(cFile);
    		
                for(int j=0; j<customers.size(); j++){
                    p.print(customers.get(j).username +"\n");
               
                }
                
             p.close();	
    	}
    	catch(Exception e){
    	}        
             a.delete();
             return true;
}

            }
        return false;
    }
    
    /**
     * Requires:None
     * Modifies:None
     * Effects:Implements Rep Invariant
     * @return true if super.repOK() and usernames(i) does not repeat, false otherwise
     */
    public boolean repOK(){
        if(!super.repOK(username, password))
                return false;
        for(int i =0; i<usernames.size(); i++){
            for(int j=i+1; j<usernames.size(); j++){
                if(usernames.get(i).equals(usernames.get(j)))
                return false;
            }
            
        }
        return true;
    }
    
    public String toString(){
        
        
        return super.toString() + "List of all customers: " + customers;
        
        
    }
    
    
    
}

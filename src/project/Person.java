/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
/**
 *
 * @author Josh
 *Overview: Class defines what a person is and basic elements for a banking application
 *This class is immutable
 */
 //AF(c) ={username + password + role | username && password != null}
  // Rep Invariant: username != null and password !=null true, false otherwise
public abstract class Person {
  
    protected String username;
    protected String password;
    protected boolean role;
    
    /**
     * //Requires: a string to be username, a string to be password, and a boolean to distin role
     * //Modifies:None
     * //Effects: Creates a person object
     * @param u persons username
     * @param p persons password
     * @param b persons role, false if they a customer, true if they are a manager
     */
    public Person(String u, String p, boolean b){
        username =u;
        password = p;
        role =b;
        
        
    }
    
    /**
     * Requires: username and password and neither should be null
     * Modifies:None
     * Effects: returns false if u or p are null true otherwise
     * @param u username for person
     * @param p password for person
     * @return false if u or p are null true otherwise
     */
    public boolean repOK(String u, String p){
       if(u == null || p== null)
        return false;
        
       return true;
    }
    
    /**
     * Requires:None
     * Modifies:None
     * Effects:Implements Abstraction Function
     * @return String of the object
     */
    public String toString(){
        String s;
        if(role){
              s = "Manager";
        }
        else{
             s = "Customer";
        }
        
        return "Username: " + username + " Password: " + password + " Role: " + s;
        
    }
    
    
    
    
}

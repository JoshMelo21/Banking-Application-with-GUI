/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
/**
 *
 * @author Josh
 * Overview: Customer which is a person and has a bank account. Uses state pattern.
 * This is a mutable class
 */


import java.util.*;
import java.io.*;

//AF(c): {super.toString() +b.toString() + level}
//Rep Invariant: level.equals("Silver") || level.equals("Gold") || level.equals("Platinum") &&super.repOK() return true, false otherwise
public class Customer extends Person {
    
   public String level = "Silver";
   public BankAccount b;
    private File f;
    
    /**
     * Requires:None
     * Modifies:None
     * Effects:Updates the file info of the customers balance
     */
    private void editFileBal(){
    	
    	try{
    		PrintWriter p = new PrintWriter(f);
    		String str = Double.toString(getBal());
    		 p.print(username + "\n" + password + "\n" +str +"\n");
             p.close();
    	
    		
    		
    		
    	}
    	catch(Exception e){
    		
    	}
    	
    	
    }
    
    
    /**
     * Requires: 2 strings, one is the user username and the second is the user password. The username and password must correspond with each other
     * Modifies:None
     * Effects: Creates a customer object and a file for that customer
     * @param u Customer username
     * @param p Customer password
     */
    public Customer(String u, String p){
        super(u, p, false); 
        b = new BankAccount();
        f= new File(u+".txt");
    }
    /**
     * Requires:None
     * Modifies:None
     * Effects:Uses the state pattern with BankAccount and calls the getState() method from the BankAccount this customer has. Updates the "state" or level.
     */
    public void setState(){
     level = b.getState();
    }
    
    /**
     * Requires: A double value greater than 0
     * Modifies: None
     * Effects: Deposits money into the users bank account. Updates the balance.
     * @param n Value to be deposited
     */
    public void deposit(double n){
    	b.bal = b.bal +n;
    	editFileBal();
    	setState();
    }
    
    /**
     * Requires: A double greater than 0 but less than or equal to the balance
     * Modifies:None
     * Effects:Takes money out of the customers bank account and updates the balance
     * @param n Value to be withdrawn
     * @return true if a withdraw is made, false otherwise
     */
    public boolean withdraw(double n){
    	if(n>b.bal){
    		return false;
    	}
        if(n>0 &&n<b.bal){
    	b.bal = b.bal - n;
    	setState();
    	editFileBal();
    	return true;
        }
        return false;
    }
   /**
    * Requires:None
    * Modifies:None
    * Effects:Returns the bank account balance
    * @return the balance of the bank account
    */
        public double getBal(){
        	setState();
        	return b.bal;
        }
        /**
         * Requires: A double value greater than 0 and less than or equal bal or bal + 10 or bal+20, depending on the state
         * Modifies:None
         * Effects: Makes a purchase based on input value. If state is silver, n=n=20. If state is gold, n=n+10. If state is platinum, n=n.
         * @param n an amount of money with which the customer wants to make a purchase
         * @return true if a purchase is made, false otherwise
         */
        public boolean purchase(double n){
        	if(level.equals("Silver")){
        		n= n+20;
        	}
        	else if(level.equals("Gold")){
        		n =n +10;
        	}
        	if(n>b.bal||n<50){
        		return false;
        	}
        	
        	
        	b.bal = b.bal-n;
        	editFileBal();
        	setState();
        	return true;
        }
        
        /**
         * Requires:None
         * Modifies:None
         * Effects:Implements Rep invariant
         * @return true if level is Silver Gold or Platinum, false otherwise
         */
        public boolean repOK(){
            if(!super.repOK(username, password))
                return false;
            if(level.equals("Silver") || level.equals("Gold") || level.equals("Platinum"))
                return true;
            return false;
            
        }
        /**
         * Requires:None
         * Modifies:None
         * Effects:Implements Abstraction Function
         * @return Object represented as a String
         */
        public String toString(){
            
            
            return super.toString() + " " + b.toString() + " Account Level: " + level;
            
        }
        
        
    }
    
    
    
    
    
    
    


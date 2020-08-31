/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
/**
 *
 * @author Josh
 * Overview: This class is a bank account for a single customer. Uses state pattern.
 * This is a mutable class
 */

 //AF: {bal | bal >= 0}
 //Rep Invariant: bal>=0 true, false otherwise
public class BankAccount {
  
	public double bal =0;
	
	/**
         * Required:None
         * Modifies:None
         * Effects:Sets initial balance to 100
         */
	public BankAccount(){
		bal =100;
	}
	
        /**
         * Requires:None
         * Modifies:None
         * Effects:Updates the state of the customer based on the balance of the account
         * @return the new value of the state the customer is in
         */
	public String getState(){
		String s ="";
		
		if(bal<10000){
		s = "Silver";
		}
		else if(bal<20000){
			s="Gold";
		}
		else{
			s="Platinum";
		}
		return s;
	}
	
        /**
         * Requires:None
         * Modifies:None
         * Effects: Implements rep invariant
         * @return false if bal less than 0 false otherwise
         */
        public boolean repOK(){
            if(bal<0)
            return false;
            return true;
                    
        }
        
        /**
         * Requires:None
         * Modifies:None
         * Effects:Implements Abstraction function
         * @return String representation of the object
         */
        public String toString(){
            
            
            return "The balance of this account is " + bal;
            
        }

	}
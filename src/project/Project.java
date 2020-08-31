/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author Josh
 * Overview: Main function for the banking application. Has a manager. This is an application and implements EventHandler. This class deals with the GUI and interface of the application.
 * This class is mutable
 */
public class Project extends Application implements EventHandler<ActionEvent> {
    Manager m = Manager.getInstance();
    FlowPane layout;
    Button mB;
    Button cB;
    Stage stage;
    Button mLogout = new Button();
    Button addCb = new Button();
    Button delCb = new Button();
    
    Button goHome = new Button();
    
     Button Enter = new Button();
          TextField mTP = new TextField();
          Label mLP = new Label("Enter Password:");
          Label mL = new Label("Enter Username:");
            TextField mT = new TextField();
            Label check = new Label("Incorrect Login Info");
            Label temp = new Label("");

            Customer q;
            
    TextField cT = new TextField();
    TextField cTP = new TextField();
             Label cPL = new Label("Enter Password:");
          Label cUL = new Label("Enter Username:");
          Button cEnter = new Button();  
            
         TextField money = new TextField();  
          Label tempL = new Label("Incorrect Login Info");
          Label t = new Label("Incorrect input");
          
          
          
          Button withdraw = new Button();
          Button deposit = new Button();
          Button purchase = new Button();
          Label balance = new Label();
          
          
          
            Scene s;
           
            
    /**
     * Requires:A stage for the GUI
     * Modifies:The stage passed into the method
     * Effects:Changes the stage based on clicked buttons and user inputs
     * @param primaryStage The initial Stage of the GUI
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Banking Application");
        
        stage = primaryStage;
        mB= new Button();
        mB.setText("Manager Login");
        mB.setOnAction(this);
        
         cB = new Button();
        cB.setText("Customer Login");
        cB.setOnAction(this);
       
        
        goHome.setText("Go Back");
        goHome.setOnAction(this);
        
        mLogout.setText("Logout");
        mLogout.setOnAction(this);
        
        addCb.setText("Add customer");
        addCb.setOnAction(this);
        
        delCb.setText("Delete Customer");
        delCb.setOnAction(this);
        
        withdraw.setText("Withdraw");
        withdraw.setOnAction(this);
        
        deposit.setText("Deposit");
        deposit.setOnAction(this);
        
        purchase.setText("Purchase");
        purchase.setOnAction(this);
        
        mTP.setOnAction(this);
        mT.setOnAction(this);
        
        layout = new FlowPane();
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(20);
        layout.setVgap(20);
        
        layout.getChildren().addAll(mB, cB);
   
        cEnter.setText("Enter");
        cEnter.setOnAction(this);
        
        s = new Scene(layout, 350, 300);
        primaryStage.setScene(s);
        primaryStage.show();
        
        
    }
    
    
    /**
     * Requires:an event
     * Modifies:None
     * Effects: Depending on the event source, changes the Scene, GUI, and data of customers/manager
     * @param event event of a clicked button to be handled
     */
    public void handle(ActionEvent event){
       
            
       
       if(event.getSource()==purchase){
           String s=  money.getText();
           double d = Double.parseDouble(s);
           if(d>0){
               t.setVisible(false);
               
               if(q.purchase(d)){
                   money.clear();
                    t.setText("Purchased");
                    t.setVisible(true);
                     String dub = Double.toString(q.b.bal);
            balance.setText("  Balance: " + dub + "     Level: " + q.level + "                  \n");
               }
               else{
                t.setText("Invalid Input");
                    money.clear();
                    t.setVisible(true);
           }
               
           }
           else{
                t.setText("Invalid Input");
                    money.clear();
                    t.setVisible(true);
           }
          
       }
       
       
       
       
       if(event.getSource()==withdraw){
           
           String s=  money.getText();
           double d = Double.parseDouble(s);
           if(d>0){
                t.setVisible(false);
           
                if(q.withdraw(d)){
                    money.clear();
                    t.setText("Money withdrawn");
                    t.setVisible(true);
                    String dub = Double.toString(q.b.bal);
            balance.setText("  Balance: " + dub + "     Level: " + q.level + "                  \n");
                }
                else{
                    t.setText("Invalid Input");
                    money.clear();
                    t.setVisible(true);
                }
           }
                else{
                    t.setText("Invalid Input");
                    money.clear();
                    t.setVisible(true);
                }
                
                
       
       }
       
       
       
       
       if(event.getSource()==deposit){
           
         String s=  money.getText();
           double d = Double.parseDouble(s);
           if(d>0){
               t.setVisible(true);
                t.setText("Money Deposited");
           q.deposit(d);
           String dub = Double.toString(q.b.bal);
            balance.setText("  Balance: " + dub + "     Level: " + q.level + "                  \n");
           money.clear();
           }
           else{
               t.setText("Invalid Input");
               money.clear();
               t.setVisible(true);
           }
       }
       
    if(event.getSource() == cEnter){
  
        String enteredName = cT.getText();
         q= m.getCustomer(enteredName);
        if(q==null|| !(q.password.equals(cTP.getText()))){

            layout.getChildren().add(tempL);
            cT.clear();
             cTP.clear();
        }
        else if(q.password.equals(cTP.getText())){
                layout = new FlowPane();
 layout.setAlignment(Pos.TOP_CENTER);
        layout.setHgap(20);
        layout.setVgap(20);
        s = new Scene(layout, 350, 300);
        stage.setScene(s);
           Label w = new Label(" Customer Home                                                \n");
           String dub = Double.toString(q.b.bal);
           q.setState();
           balance.setText("            Balance: " + dub + "    Level: " +q.level +"               \n");
            Label w1 = new Label("Enter Amount:");
           layout.getChildren().add(w);
           layout.getChildren().add(balance);
           layout.getChildren().add(w1);
           layout.getChildren().add(money);
           layout.getChildren().add(deposit);
            layout.getChildren().add(purchase);
             layout.getChildren().add(withdraw);
          layout.getChildren().add(mLogout);
          layout.getChildren().add(t);
          t.setVisible(false);
                
        }
        
    }
      
       
       if(event.getSource()==cB){
           layout = new FlowPane();
 layout.setAlignment(Pos.CENTER);
        layout.setHgap(20);
        layout.setVgap(20);
        s = new Scene(layout, 350, 300);
        stage.setScene(s);
        layout.getChildren().add(cUL);
         layout.getChildren().add(cT);
          layout.getChildren().add(cPL);
           layout.getChildren().add(cTP);
           layout.getChildren().add(cEnter);
           layout.getChildren().add(goHome);
       }
       
       if(event.getSource()==delCb){
           temp.setVisible(true);
           temp.setText("Customer Deleted");
           if(m.deleteCustomer(mT.getText())){
               temp.setText("Customer Deleted");
           }
           else{
               temp.setText("Customer does not exist");
              
           }
            mT.clear();
            mTP.clear();
       }
       
       
       if(event.getSource()==addCb ){
         temp.setVisible(true);
            temp.setText("Customer added");
            
                 if(mTP.getText().equals("")){
        temp.setText("Password Required");
           
    }
                 else if(mT.getText().equals("")){
        temp.setText("Username Required");
                
    }  
   else if( m.addCustomer(mT.getText(), mTP.getText())){

  mT.clear();
            mTP.clear();
    }

    else{
        temp.setText("Customer exists already");
       
    }
  
       mT.clear();
            mTP.clear();
       
       }
       
       
       if(event.getSource()==goHome || event.getSource() ==mLogout){
           money.clear();
           mT.clear();
            mTP.clear();
              cT.clear();
             cTP.clear();
 layout = new FlowPane();
 layout.setAlignment(Pos.CENTER);
        layout.setHgap(20);
        layout.setVgap(20);
        s = new Scene(layout, 350, 300);
        layout.getChildren().addAll(mB, cB);
        stage.setScene(s);
        mB.setVisible(true);
           cB.setVisible(true);
       }
     
       
        if(event.getSource()==mB){
            mB.setVisible(false);
            cB.setVisible(false);
            
            layout.getChildren().add(mL);
             layout.getChildren().add(mT);
            
          
                layout.getChildren().add(mLP);
             layout.getChildren().add(mTP);
             layout.getChildren().add(goHome);
             
             
             Enter.setText("Enter");
             Enter.setOnAction(this);
             layout.setAlignment(Pos.TOP_CENTER);
                 layout.getChildren().add(Enter);  
        }
        if(event.getSource()==Enter){
            if(mT.getText().equals("admin") && mTP.getText().equals("admin")){
                layout = new FlowPane();
 layout.setAlignment(Pos.TOP_CENTER);
        layout.setHgap(20);
        layout.setVgap(20);
        s = new Scene(layout, 350, 300);
          stage.setScene(s);
          Label manager_home = new Label("Manager home                                                       \n");
          Label mH = new Label("Customer username:");
          Label mH2 = new Label("Customer password:");
           layout.getChildren().add(manager_home);
          layout.getChildren().add(mH);
           layout.getChildren().add(mT);
           layout.getChildren().add(mH2);
           layout.getChildren().add(mTP);
          layout.getChildren().addAll(addCb, delCb, mLogout);
           layout.getChildren().add(temp);
           temp.setVisible(false);
            
            }
            else{
              layout.getChildren().add(check);
            }
            mT.clear();
            mTP.clear();
        }
        
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

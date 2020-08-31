# Banking-Application-with-GUI
Banking App with GUI, allows users to deposit, purchase, withdraw, and make purchases. Purchases have increased price based on the tier of the customer. and has memory of previous executions of the application. The program writes and read in files of current customer information. Manager is used to add/delete users and is implemented with a singleton design pattern. The customer uses a state design pattern. All relevant javadoc are included.

***IMPORTANT: IN ORDER TO LOG IN AS MANAGER USERNAME IS "admin" AND PASSWORD IS "admin". ***

The project was compiled using the netbeans IDE and javafx was used to build the GUI.

There are three different states a customer can have. If the user has below 10000 in their account, the state is “Silver”. If the user
has more than 10000 but less than 20000, the state is “Gold”. If the user has more than 20000, the state is “Platinum”. Relevant discounts are provided to the user 
for each. Silver customers are charged an additional 20 dollars for a purchase, gold customers an extra 10, and platinum no extra charge.

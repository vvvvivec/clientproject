// Client program to connect to game mysql database and interact with it
// Author: Brian D

package client;

// import necessary packages
import java.sql.*;
import com.mysql.jdbc.Driver;
import java.util.Scanner;

// main client class 
public class Client {

    // execute main program logic
    public static void main(String[] args) 
    {
        
        // PROGRAM LOGIC FLOW
        
        // ENTER MAIN MENU
            
            // LOGIN , CREATE ACCOUNT, EXIT           
            // LOGIN
                // Get email & pass , auth w/ server, on success leave main menu
                // on failure, show error message and prompt for reinput
            // CREATE ACCOUNT
                // Get player data and store to local vars
                // Check if email exists in DB
                    // if !exists, instert data into tables , return to main menu
                    // if exists, throw error, restart account details fetch
            // EXIT > system.exit
        
        // ON SUCCESSFUL LOGIN, PULL DATA FROM SERVER AND STORE TO LOCAL VARS
        
        // DISPLAY ACTIONS MENU
            
            // more will come later after incremental development
            // BUY RESOURCES , VIEW KINGDOM STATS , LOGOUT
            // BUY RESOURCES
                // Show resources menu: (resource,cost)
                // Select resource to buy , check if player can afford
                    // if player can afford transaction , update local vars
                    // push new data to server and commit
                    // if player !can afford transaction , throw error message
                    // and return to purchase menu
            // VIEW KINGDOM STATS
                // Display player kingdom data , on command 'exit' return to actions menu
            // LOGOUT
                // Sync data w/ server 
                // Close connection
                // System.exit
    }
    
}

// class to get input from player
class PlayerInput
{
    String playerInput = "";
    String Scan()
    {   
        Scanner input = new Scanner(System.in);
        System.out.println("INPUT:> ");
        playerInput = input.next(playerInput);
        
        return playerInput;
    }
}

// class to pull data from mysql server
class Pully{}

// class to push data to mysql server
class Pusher{}

// class to execute sql statements against mysql db
// takes sql statement in as string, opens connection, executes satement, returns results
class Sqlizer
{
    String command = "";
    
    String exec(String commandIn)
    {
        String output = null;
        command = commandIn;
        
        try
        {
            // Set connection, statement, result set
            // for debugging , replace $HOST, $USER, $PASS with actual vals
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/$HOST","$USER","$PASS");
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(command);
            ResultSetMetaData resultsMeta = results.getMetaData();
            
            // TESTED SUCCESSFUL AS OF 083117@1027
            // while there are results, print them (debug purposes, final client will not print these)
            while(results.next())
            {
                int numColumns = resultsMeta.getColumnCount();
                for (int i =1; i < numColumns; i ++)
                {
                    // DEV NOTE , this is probably broken , will need testing and refinement
                    output += results.getString(i);
                    System.out.print(output + " ");
                }
                System.out.println();
            }
            
            // When done, close the connection
            connection.close();
        }
        // If an error occurs, throw error message and print stack trace
        catch(SQLException e)
        {
            System.out.println("Error: Unexpected SQL exception");
            e.printStackTrace();
        }
        
        return output;
    }
}

// class to display menu based on current gamestate (main menu, actions menu, etc.)
class Display
{
    String currentState = "";
    
    // This string will eventually contain actual vars
    String displayHeader = "\nLIEGE: $playername KINGDOM: $kingdomname POPULATION: $population"
                         + "\nCITIZENS: $citizens SOLDIERS: $soldiers GOLD: $gold FOOD: $food"
                         + "\nLAND: $land sq/mi UPKEEP: $upkeep"; 
    
    String mainMenuString =   "\nWELCOME TO LIEGELORDS ALPHA"
                            + "\nThis is a product in development and does not reflect the final version."
                            + "\n\nOPTIONS:"
                            + "\nLogin"
                            + "\nCreate Account"
                            + "\nExit";
    
    String actionsMenuString =    "\nYou are logged in..."
                                + "\nACTIONS:"
                                + "\nPurchase resources"
                                + "\nRecruit soldiers"
                                + "\nView Realm Stats"
                                + "\nLogout";
    
    String purchaseMenuString = "";
    String recruitMenuString = "";
    String statsMenuString = "";
    String logoutString = "";
    
    void display(String gameState)
    {
        currentState = gameState;
        
        switch(currentState)
        {
            case "mainMenu":
            {
            
            }
            case "actionsMenu":
            {
            
            }
            default:
            {
            
            }
        }
    }
}

// Class for account creation
class Creator
{
    String fname = "";
    String lname = "";
    String email = "";
    String pass = "";
    String response = null;
    
    void createPlayer()
    {
        PlayerInput input = new PlayerInput();
        Sqlizer sqlizer = new Sqlizer();
        
        // Prompt player for account email 
        System.out.println("\nACCOUNT CREATION");
       
        // Loop logic until valid email obtained
        int looper = 1;
        while (looper == 1)
        {
            System.out.println("\nEMAIL ADDRESS?");
            email = input.Scan();

            // Check if email exists on server
            String command = "SELECT * FROM players WHERE email LIKE " + email + ";";
            response = sqlizer.exec(command);
            
             // If email exists , throw error and prompt for different email
            if(response != null)
            {
                System.out.println("\nERROR: An account with that email already exists");
            }
            else
            {
                looper = 0;
            }
        }       
        
        // If email doesn't exist already , get rest of acct vars 
        System.out.println("\nFIRST NAME?");
        fname = input.Scan();
        System.out.println("\nLAST NAME?");
        lname = input.Scan();
        System.out.println("\nPASSWORD?");
        pass = input.Scan();
        
        // Insert record into DB 
        String insertdata = "INSERT INTO players (fname,lname,email,pass) VALUES (\"" + fname + "\",\"" + lname + "\",\"" + email + "\",PASSWORD(\"" + pass + "\")";
        sqlizer.exec(insertdata);
    }
}
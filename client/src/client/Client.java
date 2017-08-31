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
class sqlizer
{
    String command = "";
    
    void exec(String commandIn)
    {
        command = commandIn;
        
        try
        {
            // Set connection, statement, result set
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/$DBNAME","$USER","$PASS");
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(command);
            
            // while there are results, print them (debug purposes, final client will not print these)
            while(results.next())
            {
                System.out.println(results.next());
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

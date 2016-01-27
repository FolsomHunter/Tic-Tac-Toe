/*******************************************************************************
* Title: Main.java - Main Source File for Tic-Tac-Toe
* Author: Hunter Schoonover
* Date: 01/26/16
*
* Purpose:
*
* This application is used to play a game of Tic-Tac-Toe with a friend.
*
*/

//------------------------------------------------------------------------------

package aa_tictactoe;

//------------------------------------------------------------------------------


import controller.MainController;

//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
// class Main
//

public class Main
{

    static MainController controller;

    //--------------------------------------------------------------------------
    // Main::main
    //

    public static void main(String[] args)
    {

        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.

        javax.swing.SwingUtilities.invokeLater(() -> { createController(); });

    }//end of Main::main
    //--------------------------------------------------------------------------
    
    //--------------------------------------------------------------------------
    // Main::createController
    //
    // This method creates an instance of the MainController class which will 
    // then take over.
    //
    // Since it will generally cause the creation of the GUI and show it, for
    // thread safety, this method should be invoked from the event-dispatching
    // thread. This is usually done by using invokeLater to schedule this 
    // funtion to be called from inside the event- dispatching thread. This is 
    // necessary because the main function is not operating in the 
    // event-dispatching thread.
    //
    // See the main function for more info.
    //

    private static void createController()
    {

        //create the program's controller which will create all other objects
        controller = new MainController();
        controller.init();

    }//end of Main::createController
    //--------------------------------------------------------------------------

}//end of class Main
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------

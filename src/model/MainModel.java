/*******************************************************************************
* Title: MainModel.java
* Author: Hunter Schoonover
* Date: 01/25/16
*
* Purpose:
*
* This class is the model in a Command-Model-View-Controller architecture. It 
* handles all retrieval and storing of data.
* 
*/

//------------------------------------------------------------------------------

package model;

import command.Command;
import command.CommandHandler;
import command.CommandMessage;
import java.util.logging.Level;
import java.util.logging.Logger;

//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
// class MainModel
//

public class MainModel implements CommandHandler
{
    
    private final CommandHandler downStream;

    //--------------------------------------------------------------------------
    // MainModel::MainModel (constructor)
    //

    public MainModel(CommandHandler pDownStream)
    {
        
        downStream = pDownStream;

    }//end of MainModel::MainModel (constructor)
    //--------------------------------------------------------------------------

    //--------------------------------------------------------------------------
    // MainModel::init
    //
    // Initializes the object. Must be called immediately after instantiation.
    //

    public void init()
    {
        
        //DEBUG NPS// -- should be removed later
        //performing command example
        Command c = new Command(CommandMessage.TEST_COMMAND);
        c.perform();
        //DEBUG NPS// -- should be removed later

    }// end of MainModel::init
    //--------------------------------------------------------------------------
    
    //--------------------------------------------------------------------------
    // MainController::handleCommand
    //
    // Performs different actions depending on pCommand.
    //
    // Command will usually be sent down the stream/chain after handling has
    // been done here.
    //

    @Override
    public void handleCommand(Command pCommand)
    {
        
        switch (pCommand.getMessage()) {
            
            case CommandMessage.TEST_COMMAND:
                break;
                
        }
        
        //pass the command down the stream
        downStream.handleCommand(pCommand);

    }//end of MainController::commandPerformed
    //--------------------------------------------------------------------------
    
    //--------------------------------------------------------------------------
    // MainModel::logSevere
    //
    // Logs pMessage with level SEVERE using the Java logger.
    //

    private void logSevere(String pMessage)
    {

        Logger.getLogger(getClass().getName()).log(Level.SEVERE, pMessage);

    }//end of MainModel::logSevere
    //--------------------------------------------------------------------------

    //--------------------------------------------------------------------------
    // MainModel::logStackTrace
    //
    // Logs stack trace info for exception pE with pMessage at level SEVERE 
    // using the Java logger.
    //

    private void logStackTrace(String pMessage, Exception pE)
    {

        Logger.getLogger(getClass().getName()).log(Level.SEVERE, pMessage, pE);

    }//end of MainModel::logStackTrace
    //--------------------------------------------------------------------------
    
}//end of class MainModel
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
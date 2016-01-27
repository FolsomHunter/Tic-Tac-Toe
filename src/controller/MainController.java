/*******************************************************************************
* Title: MainController.java
* Author: Hunter Schoonover
* Date: 01/25/16
*
* Purpose:
*
* This class is the controller in a Command-Model-View-Controller architecture.
* 
* All performed commands are sent here first and then travel down the 
* chain/stream: controller -> model -> view
* 
* The model and view are both created in this class. The view is created and
* initialized first and then handed to the model as a CommandHandler; the
* view is downstream of model.
*
* When the controller receives a command, he may take several different actions
* depending on the command message. For example, he might:
*   perform operations and calculations
*   add information to the command before sending it downstream
*   intercept the command, choosing to not send it downstream
*   etc.
*
* An instance of Command can be created and performed from any class in the
* project:
*   //you can do this from any class, and the command will always be sent here
*   Command c = new Command(CommandMessage.CHECK_LETTER_PLACEMENT);
*   c.perform();
* 
* The Command can store objects that can be retrieved at a later point in time:
*   Command c = new Command(CommandMessage.CHECK_LETTER_PLACEMENT);
*   c.put(CommandKey.LETTER, "x"); 
*   c.put(CommandKey.ROW, 1); 
*   c.put(CommandKey.COLUMN, 1);
*   c.perform();
* 
*   ...
* 
*   //the data stored in the Command can be retrieved and cast into objects from
*   //any class that the Command is sent to
*   String letter   = (String)c.get(CommandKey.LETTER);
*   int row         = (int)c.get(CommandKey.ROW);
*   int column      = (int)c.get(CommandKey.COLUMN);
*   
* Keep in mind that when retrieving objects from the Command, you should ALWAYS
* check the command message before trying to retrieve and cast objects:
*   if (c.getMessage().equals(CommandMessage.CHECK_LETTER_PLACEMENT) {
*       //then take action and get the stuff you know will be in a command with
*       //this message
*   }
* 
* //WIP HSS// -- describe more stuff here
*
*/

//------------------------------------------------------------------------------

package controller;

import command.CommandHandler;
import command.Command;
import command.CommandMessage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import view.MainView;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import model.MainModel;

//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
// class MainController
//

public class MainController implements CommandHandler
{

    private CommandHandler downStream;

    //--------------------------------------------------------------------------
    // MainController::MainController (constructor)
    //

    public MainController()
    {

    }//end of MainController::MainController (constructor)
    //--------------------------------------------------------------------------

    //--------------------------------------------------------------------------
    // MainController::init
    //
    // Initializes the object. Must be called immediately after instantiation.
    //

    public void init()
    {
        
        //register this as a command handler -- this should not be called
        //anywhere else in the entire program
        Command.registerHandler(this);
        
        //set up the logger
        setupJavaLogger();
        
        MainView view = new MainView();
        view.init();
        
        //set up the model, giving it view as its downstream
        downStream = new MainModel(view);
        ((MainModel)downStream).init();

    }// end of MainController::init
    //--------------------------------------------------------------------------
    
    //--------------------------------------------------------------------------
    // MainController::handleCommand
    //
    // Performs different actions depending on pCommand.
    //
    // Command will always be sent down the chain to view after handling has
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
    // MainController::deleteFileIfOverSizeLimit
    //
    // If file pFilename is larger than pLimit, the file is deleted.
    //

    private void deleteFileIfOverSizeLimit(String pFilename, int pLimit)
    {

        //delete the logging file if it has become too large

        Path p1 = Paths.get(pFilename);

        try { if (Files.size(p1) > pLimit){ Files.delete(p1); } }
        catch(NoSuchFileException nsfe){
            //do nothing if file not found -- will be recreated as needed
        }
        catch (IOException e) {
            //do nothing if error on deletion -- will be deleted next time
        }

    }//end of MainController::deleteFileIfOverSizeLimit
    //--------------------------------------------------------------------------
    
    //--------------------------------------------------------------------------
    // MainController::logSevere
    //
    // Logs pMessage with level SEVERE using the Java logger.
    //

    private void logSevere(String pMessage)
    {

        Logger.getLogger(getClass().getName()).log(Level.SEVERE, pMessage);

    }//end of MainController::logSevere
    //--------------------------------------------------------------------------

    //--------------------------------------------------------------------------
    // MainController::logStackTrace
    //
    // Logs stack trace info for exception pE with pMessage at level SEVERE 
    // using the Java logger.
    //

    private void logStackTrace(String pMessage, Exception pE)
    {

        Logger.getLogger(getClass().getName()).log(Level.SEVERE, pMessage, pE);

    }//end of MainController::logStackTrace
    //--------------------------------------------------------------------------
    
    //--------------------------------------------------------------------------
    // MainController::setupJavaLogger
    //
    // Prepares the Java logging system for use. Output is directed to a file.
    //
    // Each time the method is called, it checks to see if the file is larger
    // than the maximum allowable size and deletes the file if so.
    //

    private void setupJavaLogger()
    {

        String logFilename = "Java Logger File.txt";

        //prevent the logging file from getting too big
        deleteFileIfOverSizeLimit(logFilename, 10000);

        //remove all existing handlers from the root logger (and thus all child
        //loggers) so the output is not sent to the console

        Logger rootLogger = Logger.getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        for(Handler handler : handlers) {
            rootLogger.removeHandler(handler);
        }

        //add a new handler to send the output to a file

        Handler fh;

        try {

            //write log to logFilename, 10000 byte limit on each file, rotate
            //between two files, append the the current file each startup

            fh = new FileHandler(logFilename, 10000, 2, true);

            //direct output to a file for the root logger and  all child loggers
            Logger.getLogger("").addHandler(fh);

            //use simple text output rather than default XML format
            fh.setFormatter(new SimpleFormatter());

            //record all log messages
            Logger.getLogger("").setLevel(Level.WARNING);

        }
        catch(IOException e){ }

    }//end of MainController::setupJavaLogger
    //--------------------------------------------------------------------------
    
}//end of class MainController
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
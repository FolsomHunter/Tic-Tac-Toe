/*******************************************************************************
* Title: MainView.java
* Author: Hunter Schoonover
* Date: 01/26/16
*
* Purpose:
*
* This class is the view in a Command-Model-View-Controller architecture. It
* handles all things GUI and provides a way for users to interact with the
* program.
* 
* It receives commands from upstream containing messages, data, and information 
* that the view needs to display to the user.
*
*/

//------------------------------------------------------------------------------

package view;

//------------------------------------------------------------------------------

import command.Command;
import command.CommandHandler;
import command.CommandMessage;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import toolkit.Tools;

//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
// class MainView
//

public class MainView extends JFrame implements CommandHandler
{
    
    private final JPanel mainPanel;

    //--------------------------------------------------------------------------
    // MainView::MainView (constructor)
    //

    public MainView()
    {
        
        mainPanel = new JPanel();
        
    }//end of MainView::MainView (constructor)
    //--------------------------------------------------------------------------

    //--------------------------------------------------------------------------
    // MainView::init
    //
    // Initializes the object. Must be called immediately after instantiation.
    //

    public void init()
    {
        
        //set up the frame
        setUpFrame();
        
        //create and add the GUI
        createGui();
        
        //arrange all the GUI items
        pack();

        //center and make visible
        setVisible();

    }// end of MainView::init
    //--------------------------------------------------------------------------
    
    //--------------------------------------------------------------------------
    // MainView::handleCommand
    //
    // Performs different actions depending on pCommand.
    //
    // Command will always be sent down the chain to display after handling has
    // been done here.
    //

    @Override
    public void handleCommand(Command pCommand)
    {
        
        switch(pCommand.getMessage()) {
            case CommandMessage.TEST_COMMAND:
                break;
        }

    }//end of MainView::handleCommand
    //--------------------------------------------------------------------------
    
    //--------------------------------------------------------------------------
    // MainView::createGui
    //
    // Creates and adds the GUI to the main panel.
    //

    private void createGui()
    {
        
        //add padding to the main panel
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        //set the layout to add items top to bottom
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        //DEBUG NPS// -- should be removed later
        //Noah, the size of the mainPanel is only set just to show you what it
        //looks like. After you add the TicTacToeSquares, the code here should 
        //be removed, allowing the mainPanel to wrap to its contents
        Tools.setSizes(mainPanel, 600, 600);
        
        JLabel testLabel = new JLabel("Well, I do love my boxes.");
        testLabel.setAlignmentX(LEFT_ALIGNMENT);
        mainPanel.add(testLabel);
        //DEBUG NPS// -- should be removed later
        
        //add the tic-tac-toe grid to the mainPanel
        addTicTacToeSquaresToMainPanel();
        
    }// end of MainView::createGui
    //--------------------------------------------------------------------------
    
    //--------------------------------------------------------------------------
    // MainView::addTicTacToeSquaresToMainPanel
    //
    // Set up the TicTacToeSquares and add them to the main panel. 
    // 
    // 9 squares are created and added to the main panel in a 3x3 grid pattern:
    //      1 2 3
    //      4 5 6
    //      7 8 9
    //

    private void addTicTacToeSquaresToMainPanel()
    {

        //WIP NPS// -- create 9 TicTacToeSquare objects, add them to the main 
        //              panel, and store them in a list to be accessed later
        
    }// end of MainView::addTicTacToeSquaresToMainPanel
    //--------------------------------------------------------------------------
    
    //--------------------------------------------------------------------------
    // MainView::setUpFrame
    //
    // Sets up the frame by setting various options and styles.
    //

    private void setUpFrame()
    {

        //set the title of the frame
        setTitle("Tic-Tac-Toe");

        //turn off default bold for Metal look and feel
        UIManager.put("swing.boldMetal", Boolean.FALSE);

        //force "look and feel" to Java style
        try {
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println("Could not set Look and Feel");
        }

        //exit the program when the window closes
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //add a JPanel to the frame to provide a familiar container
        setContentPane(mainPanel);

    }// end of MainView::setUpFrame
    //--------------------------------------------------------------------------
    
     //--------------------------------------------------------------------------
    // MainView::setVisible
    //
    // Center the dialog and make it visible.
    //

    private void setVisible()
    {

        Tools.centerWindow(this);
        setVisible(true);

    }// end of MainView::setVisible
    //--------------------------------------------------------------------------

}//end of class MainView
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------

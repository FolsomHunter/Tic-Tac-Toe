/*******************************************************************************
* Title: TicTacToeSquare.java
* Author: Hunter Schoonover
* Date: 01/26/16
*
* Purpose:
*
* This class is a Tic-Tac-Toe square.
* 
* It extends JPanel so that it can be added to another panel.
*   
* Possible states:
*   choose letter -- display button. Be sure to call setLetter() first
*   letter selected -- display label. Be sure to call setLetter() first
*   display blank -- display empty
*
*/

//------------------------------------------------------------------------------

package view;

//------------------------------------------------------------------------------

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import toolkit.Tools;

//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
// class TicTacToeSquare
//

public class TicTacToeSquare extends JPanel
{
    
    private final int width;
    private final int height;
    private final int fontSize;
    
    private Font font;
    
    private JButton button;
    
    //--------------------------------------------------------------------------
    // TicTacToeSquare::TicTacToeSquare (constructor)
    //

    public TicTacToeSquare(int pWidth, int pHeight, int pFontSize)
    {
        
        width = pWidth;
        height = pHeight;
        fontSize = pFontSize;

    }//end of TicTacToeSquare::TicTacToeSquare (constructor)
    //--------------------------------------------------------------------------
    
    //--------------------------------------------------------------------------
    // TicTacToeSquare::init
    //
    // Initializes the object. Must be called immediately after instantiation.
    //

    public void init()
    {
        
        //set the layout to add items top to bottom
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        //TicTacToeSqueares should always be added to a JPanel with an X_AXIS 
        //BoxLayout, meaning we should only need to worry about the vertical 
        //alignment, but just in case, we'll set the vertical and horizontal
        setAlignmentX(LEFT_ALIGNMENT);
        setAlignmentY(TOP_ALIGNMENT);
        
        //surround this with a black border
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        //set the width and height of the panel
        Tools.setSizes(this, width, height);
        
        //set up the font for use with the button and JLabel
        font = new Font("Arial", Font.PLAIN, fontSize);

    }//end of TicTacToeSquare::init
    //--------------------------------------------------------------------------
    
    //--------------------------------------------------------------------------
    // TicTacToeSquare::setLetter
    //
    // Sets the letter of this square to pLetter.
    //
    // Pass in "" or null if no letter should be displayed.
    //

    public void setLetter(String pLetter)
    {

    }//end of TicTacToeSquare::setLetter
    //--------------------------------------------------------------------------
    
    //--------------------------------------------------------------------------
    // TicTacToeSquare::setState
    //
    // Sets the state of this square. Different actions are taken depending on
    // pState.
    //
    // Possible states:
    //      choose letter -- display button
    //      letter selected -- display label
    //      display blank -- display empty
    //

    public void setState(String pState)
    {

    }//end of TicTacToeSquare::setState
    //--------------------------------------------------------------------------
    
}//end of class TicTacToeSquare
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------

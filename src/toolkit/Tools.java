/*******************************************************************************
* Title: Tools.java
* Author: Hunter Schoonover
* Date: 01/26/13
*
* Purpose:
*
* This class contains useful tools.
*
* Open Source Policy:
*
* This source code is Public Domain and free to any interested party.  Any
* person, company, or organization may do with it as they please.
*
*/

//------------------------------------------------------------------------------

package toolkit;

//------------------------------------------------------------------------------

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.Box;
import javax.swing.JDialog;

//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
// class Tools
//

public class Tools {
    
    //--------------------------------------------------------------------------
    // Tools::centerJDialog
    //
    // Centers a passed in JDialog according to the location and size of the 
    // passed in parent dialog and the JDialog's size.
    //

    static public void centerJDialog(JDialog pDialog, Window pParent)
    {

        int parentFrameXPos = (int)pParent.getX();
        int parentFrameHalfWidth = (int)pParent.getWidth()/2;

        int parentFrameYPos = (int)pParent.getY();
        int parentFrameHalfHeight = (int)pParent.getHeight()/2;

        int parentFrameXCenter = parentFrameXPos + parentFrameHalfWidth;
        int parentFrameYCenter = parentFrameYPos + parentFrameHalfHeight;

        int dialogWidthCenter = (int)pDialog.getWidth()/2;
        int dialogHeightCenter = (int)pDialog.getHeight()/2;

        int xPosition = parentFrameXCenter - dialogWidthCenter;
        int yPosition = parentFrameYCenter - dialogHeightCenter;

        pDialog.setLocation(xPosition, yPosition);

    }// end of Tools::centerJDialog
    //--------------------------------------------------------------------------
    
    //--------------------------------------------------------------------------
    // Tools::centerWindow
    //
    // Moves pWindow to the center of the screen.
    //

    static public void centerWindow(Window pWindow)
    {
        
        //determine the x-coordinate
        int screenWidth = (int)Toolkit.getDefaultToolkit()
                                                .getScreenSize().getWidth();
        
        int windowWidth = (int)pWindow.getWidth();
        
        int x = screenWidth/2 - windowWidth/2;
        
        //determine the y-coordinate
        int screenHeight = (int)Toolkit.getDefaultToolkit()
                                                .getScreenSize().getHeight();
    
        int windowHeight = (int)pWindow.getHeight();
        
        int y = screenHeight/2 - windowHeight/2;

        //center the window using the x and y coordinates
        pWindow.setLocation(x, y);

    }// end of Tools::centerWindow
    //--------------------------------------------------------------------------
    
    //--------------------------------------------------------------------------
    // Tools::createHorizontalSpacer
    //
    // Creates and returns a horizontal spacer using pWidth.
    //

    static public Component createHorizontalSpacer(int pWidth)
    {

        return Box.createRigidArea(new Dimension(pWidth, 0));

    }// end of Tools::createHorizontalSpacer
    //--------------------------------------------------------------------------
    
    //--------------------------------------------------------------------------
    // Tools::createVerticalSpacer
    //
    // Creates and returns a vertical spacer using pHeight.
    //

    static public Component createVerticalSpacer(int pHeight)
    {

        return Box.createRigidArea(new Dimension(0, pHeight));

    }// end of Tools::createVerticalSpacer
    //--------------------------------------------------------------------------
    
    //--------------------------------------------------------------------------
    // Tools::setSizes
    //
    // Sets the min, max, and preferred sizes of pComponent to pWidth and 
    // pHeight.
    //

    static public void setSizes(Component pComponent, int pWidth, int pHeight)
    {

        pComponent.setMinimumSize(new Dimension(pWidth, pHeight));
        pComponent.setPreferredSize(new Dimension(pWidth, pHeight));
        pComponent.setMaximumSize(new Dimension(pWidth, pHeight));

    }//end of Tools::setSizes
    //--------------------------------------------------------------------------

}//end of class Tools
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------

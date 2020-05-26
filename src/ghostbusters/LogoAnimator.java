/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ghostbusters;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
/**
 *
 * @author Izabel Santos
 */
public class LogoAnimator extends JPanel {
    
    private final static String IMAGE_NAME = "deitel";
    protected ImageIcon images[];
    private final int TOTAL_IMAGES = 100;
    private int currentImage = 0;
    private final int ANIMATION_DELAY = 10;
    private int width;
    private int height;
    
    private Timer animationTimer;
    
    public LogoAnimator()
    {
        String filename;
        images = new ImageIcon[ TOTAL_IMAGES ];
        for(int count = 0; count < images.length; count++){
            filename = String.format("images/%s%04d.jpg",IMAGE_NAME, count );
            //filename = "images/" + IMAGE_NAME + count + ".jpg";
            images[count] = new ImageIcon(getClass().getResource(filename));
        }
        width = images[0].getIconWidth();
        height = images[0].getIconHeight();
    }
    
    public void paintComponent( Graphics g )
    {
        super.paintComponents(g);
        images[currentImage].paintIcon( this, g, 0, 0 );
        if (animationTimer.isRunning())
        {
            currentImage = (currentImage + 1) % TOTAL_IMAGES;
        }
    }
    
    public void startAnimation()
    {
        if( animationTimer == null )
        {
            currentImage = 0;
            animationTimer = new Timer ( ANIMATION_DELAY, new TimerHandler());
            animationTimer.start();
        }
        else
        {
            if( !animationTimer.isRunning())
            {
                animationTimer.restart();
            }
        }
    }
    
    public void stopAnimation()
    {
        animationTimer.stop();
    }
    
    public Dimension getMinimunSize()
    {
        return getPreferredSize();
    }
    
    public Dimension getPreferredSize()
    {
        return new Dimension( width, height );
    }
    
    private class TimerHandler implements ActionListener
    {
        public void actionPerformed( ActionEvent actionEvent )
        {
            repaint();
        }
    }
    
    
    
}

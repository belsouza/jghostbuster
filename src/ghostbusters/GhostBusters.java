/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ghostbusters;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
 *
 * @author Izabel Santos
 */
public class GhostBusters {

    /**
     * @param args the command line arguments
     */
    
   
    
    public static void main(String[] args) {
               
        LogoAnimator animation = new LogoAnimator();
        JFrame window = new JFrame ("Animatior test");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(animation); 
        BoardMann james = new BoardMann();
        window.addMouseListener(james);
              
        window.pack();
        window.setVisible( true );
        animation.startAnimation();        
    }
    
}
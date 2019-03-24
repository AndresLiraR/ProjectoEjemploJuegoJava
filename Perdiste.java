package pistac;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

class BackgroundImageJFrame2 extends JFrame
{

    JButton b1;
    JLabel l1;
    JButton b2;
    JLabel l2;
    JButton b3;
    JButton b4;
    public BackgroundImageJFrame2() {

        setSize(400,400);
        setVisible(true);

        //setLayout(new BorderLayout());
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize((screenWidth/2), (screenHeight/2));
        setLocation(screenWidth / 4, screenHeight / 4);

        JLabel background=new JLabel(new ImageIcon("C:\\Users\\LIRAROCCA\\Desktop\\eclipse-java-oxygen-1a-win32\\eclipse\\youlose.png"));

        add(background);

        background.setLayout(new GridBagLayout());

        l1=new JLabel("Here is a button");
        b1=new JButton("Nuevo juego");
        b1.setPreferredSize(new Dimension(150, 50));
    
        l2=new JLabel("Here is a button");
        b2=new JButton("Salir");
        b2.setPreferredSize(new Dimension(150, 50));
 
 
        b3=new JButton("Nivel 2");
        b3.setPreferredSize(new Dimension(150, 50));
        
        b4=new JButton("Nivel 3");
        b4.setPreferredSize(new Dimension(150, 50));
 
        
     
        
        b1.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	dispose();
                System.out.println("Do Something Clicked");
                carron f = new carron();
            }
        });
        
        b3.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	dispose();
                System.out.println("Do Something Clicked");
                Nivel2 f = new Nivel2();
            }
        });
        b4.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	dispose();
                System.out.println("Do Something Clicked");
                Nivel3 f= new Nivel3();
            }
        });
        b2.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               dispose();

            }
        });
        
        
       // background.add(l1);
        background.add(b1);
      //  background.add(l2);
        background.add(b3);
        background.add(b4);
        background.add(b2);
       
    }
}





 /*ImageIcon image   = new ImageIcon("C:\\Users\\LIRAROCCA\\Desktop\\eclipse-java-oxygen-1a-win32\\eclipse\\\\yoshi.jpg");
JLabel imageLabel = new JLabel(image); 
add(imageLabel);
imageLabel.setVerticalAlignment(screenHeight);
imageLabel.setVisible(true);
*/

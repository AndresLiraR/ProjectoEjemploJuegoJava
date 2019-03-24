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

class Felicidades extends JFrame
{

    JButton b1;
    JLabel l1;
    JButton b2;
    JLabel l2;
    JButton b3;
    JButton b4;
    int win;
    public Felicidades() {

        setSize(400,400);
        setVisible(true);

      
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize((screenWidth/2), (screenHeight/2));
        setLocation(screenWidth / 4, screenHeight / 4);

        JLabel background=new JLabel(new ImageIcon("C:\\Users\\LIRAROCCA\\Desktop\\eclipse-java-oxygen-1a-win32\\eclipse\\Felicidades.png"));

        add(background);

        background.setLayout(new GridBagLayout());

        l1=new JLabel("Here is a button");
        b1=new JButton("Ir al menu principal");
        b1.setPreferredSize(new Dimension(150, 50));
    
        l2=new JLabel("Here is a button");
        b2=new JButton("Salir");
        b2.setPreferredSize(new Dimension(150, 50));
 
 
   
        
     
        
        b1.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	dispose();
                System.out.println("Do Something Clicked");
                BackgroundImageJFrame f = new BackgroundImageJFrame();
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
        background.add(b1);
        background.add(b2);
      
      
    }
}
 /*ImageIcon image   = new ImageIcon("C:\\Users\\LIRAROCCA\\Desktop\\eclipse-java-oxygen-1a-win32\\eclipse\\\\yoshi.jpg");
JLabel imageLabel = new JLabel(image); 
add(imageLabel);
imageLabel.setVerticalAlignment(screenHeight);
imageLabel.setVisible(true);
*/

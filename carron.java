package pistac;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.*;



//import everything:
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;



public class carron extends JFrame
{
	
	  private boolean[] keys = new boolean[120];
	 
//this is the constant that will hold the screen size
final int WIDTH = 600, HEIGHT = 450;
//these will keep track of each player’s speed:
double p1Speed =0.2;//set to zero if not
double p2Speed =0;
//these are ints that represent directions-set int to any number
final int UP = 1, RIGHT = 2, DOWN = 3, LEFT = 4;

//these will keep track of the player’s directions (default = stationary)
int p1Direction = 0;

//create rectangles that will represent the left, right, top, bottom, and centre
Rectangle left = new Rectangle(0,0,WIDTH/9, HEIGHT);
Rectangle right = new Rectangle((WIDTH/9)*8,0,WIDTH/9,HEIGHT);
Rectangle top = new Rectangle(0,0,WIDTH,HEIGHT/8);
Rectangle bottom = new Rectangle(0,(HEIGHT/9)*8,WIDTH,HEIGHT/9);
Rectangle center = new Rectangle((int)((WIDTH/9) *2.5),(int)((HEIGHT/9)*2.5),
(int)((WIDTH/9)*5),(HEIGHT/9)*4);
//Creamos la linea blanca de llegada "La meta"

Rectangle lineO = new Rectangle(WIDTH/9,HEIGHT/2+30,(int)((WIDTH/9)*1.5),HEIGHT/140);
Rectangle line1 = new Rectangle(WIDTH/9,HEIGHT/2+50,(int)((WIDTH/9)*1.5),HEIGHT/140);

//this is the rectangle for player 1s car
Rectangle p1 = new Rectangle(WIDTH/9,HEIGHT/2, WIDTH/30,WIDTH/30);
Rectangle p2 = new Rectangle(WIDTH/9,HEIGHT/2, WIDTH/30,WIDTH/30);
 int q=0;


//the constructor- This is the brain for the whole program
public carron()
{
//the following code creates the JFrame
	
super("Racing game");
int delay = 1000;
int period = 1000;
timer = new Timer();
interval = 20;

setTitle("CUADROS VELOCES");
setSize(WIDTH,HEIGHT);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
Toolkit tk = Toolkit.getDefaultToolkit();
Dimension screenSize = tk.getScreenSize();
int screenHeight = screenSize.height;
int screenWidth = screenSize.width;
setSize((screenWidth/2)-25, (screenHeight/2)+15);
setLocation(screenWidth / 4, screenHeight / 4);
//start the inner class (which works on its own, because it is a Thread)
JLabel label1 = new JLabel("COMIENZA");
add(label1);
label1.setFont(new Font(label1.getFont().getName(), label1.getFont().getStyle(), 20));
label1.setHorizontalAlignment(SwingConstants.CENTER); 
label1.setVerticalAlignment(SwingConstants.BOTTOM);
label1.setForeground(Color.yellow);
label1.setBackground(Color.BLACK);
label1.setOpaque(true);




 /*ImageIcon image   = new ImageIcon("C:\\Users\\LIRAROCCA\\Desktop\\eclipse-java-oxygen-1a-win32\\eclipse\\\\yoshi.jpg");
JLabel imageLabel = new JLabel(image); 
add(imageLabel);
imageLabel.setVerticalAlignment(screenHeight);
imageLabel.setVisible(true);
*/


timer.scheduleAtFixedRate(new TimerTask() {

    public void run() {
       //System.out.println(--interval);
    	if(interval==0 && q==0 ) {
    		dispose();
    		new BackgroundImageJFrame4();
    		q=1;
    	}
    	label1.setText(String.valueOf(--interval));
    	
    }
}, delay, period);



Move2 m2 = new Move2();
m2.start();
Move1 m1 = new Move1();
m1.start();


}


//this will draw the cars and the race track- gets called automatically
public void paint(Graphics g)
{
	
super.paint(g);
//draw the background for the race 
g.setColor(Color.DARK_GRAY);
g.fillRect(0,0,WIDTH,HEIGHT);
//when we draw, the border will be green
g.setColor(Color.GREEN);
//the following rectangle is the start line for the player

Rectangle line1 = new Rectangle(WIDTH/9,HEIGHT/2+50,(int)((WIDTH/9)*1.5)/2,HEIGHT/140);


//now, using the rectangles, draw it
g.fillRect(left.x, left.y, left.width, right.height);
g.fillRect(right.x,right.y,right.width,right.height);
g.fillRect(top.x,top.y,top.width,top.height);
g.fillRect(bottom.x,bottom.y,bottom.width,bottom.height);
g.fillRect(center.x,center.y,center.width,center.height);

//set the starting line color to white
g.setColor(Color.WHITE);
//now draw the starting line
g.fillRect(lineO.x,lineO.y,lineO.width,lineO.height);
g.setColor(Color.ORANGE);
g.fillRect(line1.x,line1.y,line1.width+line1.width,line1.height);
//set the color to blue for p1
g.setColor(Color.BLUE);
//now draw the actual player
g.fill3DRect(p1.x,p1.y,p1.width,p1.height,true);
g.setColor(Color.RED);
g.fill3DRect(p2.x,p2.y,p2.width,p2.height,true);
}

private class Move2 extends Thread{
	public void run()
	{
 int p=0,i=0;
	//now, this should all be in an infinite loop, so the process repeats
	while(true)
	{
	//now, put the code in a “try” block. This will let the program exit
	//if there is an error.
	try
	{
	//first, refresh the screen:
	repaint();//built in method

	//check to see if car hits the outside walls.
	//If so, make it slow its speed by setting its speed
	//to -2.
	
	if(q==1) {
		break;
	}
	
	if(p==0){
		p2.y-=(int)p2Speed+15;
		if(p2.intersects(top)){
			p2.y+=(int)p2Speed+15;
			p=1;
			
		}
	}

	if(p==1){
		p2.x+=(int)p2Speed+15;
		if(p2.intersects(right)){
			p2.x-=(int)p2Speed+15;	
			p=2;
		}
	}

	if(p==2){
		p2.y+=(int)p2Speed+15;
		if(p2.intersects(bottom)){
			p2.y-=(int)p2Speed+15;	
			p=3;
		}
	}

	if(p==3){
		p2.x-=(int)p2Speed+15;
		if(p2.intersects(left)){
			p2.x+=(int)p2Speed+15;	
			p=4;
		}
	}
	if(p==4){
		p2.y-=(int)p2Speed+15;
		if(p2.intersects(line1)){
			q=1;
			dispose();
			new BackgroundImageJFrame2();
			p=5;
			
				
		}
	}
	
	//this delays the refresh rate:
	Thread.sleep(150);
	}
	catch(Exception e)
	{
	//if there is an exception (an error),
	//exit the loop.
	break;
	}
	}
	}

}


private class Move1 extends Thread implements KeyListener
{
	int win=0;
//needs this method to work
public void run()
{
//add the code to make the KeyListener “wake up”
addKeyListener(this);

//now, this should all be in an infinite loop, so the process repeats
while(true)
{
//now, put the code in a “try” block. This will let the program exit
//if there is an error.
try
{
//first, refresh the screen:
repaint();//built in method

//check to see if car hits the outside walls.
//If so, make it slow its speed by setting its speed
//to -2.
if(p1.intersects(left)|| p1.intersects(right) || p1.intersects(top) || p1.intersects(bottom)|| p1.intersects(center))
{
p1Speed = -15;
}

if(p1.intersects(lineO)){
 p1.x=WIDTH/9;
 p1.y=HEIGHT/2;
}
if(p1.intersects(line1)){
	dispose();
	q=1;
	win=1;
	new BackgroundImageJFrame3(win);
	JOptionPane.showMessageDialog(null, "PRESIONE EL BOTON PARA SELECCIONAR LA OPCION O ESPERE A QUE CARGUE EL SIGUIENTE NIVEL");
	break;
	
	}


//increase speed a bit
if(p1Speed<0) {
p1Speed+= 2;
}
//these will move the player based on direction – note that moving up has a negative. This is
//due to the coordinate system for computers- for x its normal as its the same as cartesian x axis.

if(keys[KeyEvent.VK_W] || keys[KeyEvent.VK_UP]){
	p1.y-=(int)p1Speed+15;
}

if(keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN]){
	p1.y+=(int)p1Speed+15;
}

if(keys[KeyEvent.VK_A] || keys[KeyEvent.VK_LEFT]){
	p1.x-=(int)p1Speed+15;
}

if(keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT]){
	p1.x+=(int)p1Speed+15;
}

//this delays the refresh rate:
Thread.sleep(80);
}
catch(Exception e)
{
//if there is an exception (an error),
//exit the loop.
break;
}
}
}

public void keyPressed(KeyEvent e) {
    keys[e.getKeyCode()] = true;
}

public void keyReleased(KeyEvent e) {
    keys[e.getKeyCode()] = false;
}

public void keyTyped(KeyEvent e) {
}


}
//this starts the program by calling the constructor:
static int interval;
static Timer timer;
public static void main (String[] args)
{  
    new BackgroundImageJFrame();
   
//carron f = new carron(); //could have written just “new Game();” also as there is no need to use the ‘f’ object created

}
}
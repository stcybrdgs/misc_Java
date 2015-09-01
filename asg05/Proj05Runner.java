/******************************************
* Programmer:  Stacy Bridges
* Course:      Java Programming (Intermediate)
* Assg:        Asg05
*******************************************/
import java.util.*;
import javax.swing.*;
import java.awt.*;	        // rem: includes MouseEvent
import java.awt.event.*;	// rem: includes class MouseAdapter (implements MouseListener)
							

public class Proj05Runner extends JFrame implements ActionListener, MouseListener{
    JFrame frame;
    JButton quit;
    MyComponent myLabel;	// display area for the cursor coordinates
	
    public Proj05Runner(){
        // SET UP THE JFRAME  --------------------------------------		
        super("Stacy Bridges");
	setSize(200, 200);	// (width, height);
	setDefaultCloseOperation(frame.DO_NOTHING_ON_CLOSE);
		
        // LAYOUT MANAGER  -----------------------------------------		
	// make the container use a specific layout manager:
	BorderLayout myLayout = new BorderLayout();
	setLayout(myLayout);
		
	// SET UP THE JBUTTON  -------------------------------------
	// create/add a Quit button to the UI
	quit = new JButton("Quit");
	add(quit, BorderLayout.NORTH);
		
	//  add an event listener that invokes actionPerformed(ActionEvent e)
	quit.addActionListener(this);

	// SET UP MyComponent  --------------------------------------
	// create/add an instance of MyComponent to the UI	
	myLabel = new MyComponent();
	add(myLabel);
		
	// add an event listener that invokes mousePressed(MouseEvent e)		
	myLabel.addMouseListener(this);
		
	// SHOW THE FRAME  -----------------------------------------
	setVisible(true);
		
    }// end constructor
	
    // RESPOND TO BUTTON CLICK EVENT  --------------------------
    // note: the ActionListener interface automatically sends program
    // control to actionPerformed() method when an event is detected
    // on the subject component; I get to write the method code.
    public void actionPerformed(ActionEvent event){
        // close the JFrame
	System.exit(0);	// note: setVisible(false) won't close program,
	                // and dispose() closes the JFrame but with 
			// a lag on closing the program down.
			// It seems that System.exit(0); is the
			// best match to the desired Asg05 behavior 
    }
		
    // RESPOND TO MOUSE PRESSED EVENT  -------------------------
    // note: the MouseListener interface automatically sends program
    // control to mousePressed() method when a mouse button is pressed down;
    // I get to write the method code.
    public void mousePressed(MouseEvent event){
        // update the coordinate variables of myLabel using the
	// x,y coordinates of the cursor at the time of the mousePressed event
	myLabel.x = event.getX();
	myLabel.y = event.getY();
		
	// repaint the contents of myLabel within the JFRAME
	myLabel.repaint();    // method of JComponent class
    }
	
    // the implementation requires the following methods to be present;
    // because they are not needed for this assignment, they are left undefined
    public void mouseReleased(MouseEvent event){}
    public void mouseEntered(MouseEvent event){}
    public void mouseExited(MouseEvent event){}	
    public void mouseClicked(MouseEvent event){}	

} // end class Proj05Runner

// PRINT COORDINATES TO JFRAME  -----------------------------
// JComponent contains the paintComponent() method, which receives a
// Graphics object, which in turn can be used to access drawString().
// By overriding the paintComponent() method, I get to control how my
// customized component is painted into the parent layer upon 
// the component's instantiation
class MyComponent extends JComponent{
    public int x;
    public int y;
		
    public MyComponent(){
    // no specifications for this constructor	
    }
		
    protected void paintComponent(Graphics g){
        super.paintComponent(g);		// paintComponent is method of JComponent class
        String str = x + ", " + y;
	g.setColor(Color.black);		// method of Graphics class
	g.drawString(str, x, y);		// method of Graphics class
    }
    
} // end class MyComponent

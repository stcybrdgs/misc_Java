/******************************************
* Programmer:  Stacy Bridges
* Course:   Java Programming (Intermediate)
* Assg:     Asg06
*******************************************/
import java.util.*;
import javax.swing.*;
import java.awt.*;			// rem: includes MouseEvent
import java.awt.event.*;	// rem: includes class MouseAdapter (implements MouseListener)
							
public class Proj06Runner extends JFrame implements MouseMotionListener{
	JFrame frame;
	MyComponent myLabel;	// display area for the cursor coordinates
	
	public Proj06Runner(){
	//  SET UP THE JFRAME  --------------------------------------		
		super("Stacy Bridges");
		setSize(300, 200);	// (width, height);
		setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
	//  LAYOUT MANAGER  -----------------------------------------		
		//  make the container use a specific layout manager:
		BorderLayout myLayout = new BorderLayout();
		setLayout(myLayout);
		
	//  SET UP MyComponent  --------------------------------------
		// create/add an instance of MyComponent to the UI	
		myLabel = new MyComponent();
		add(myLabel);
		
		// add an event listener that invokes mouseMoved and mouseDragged		
		myLabel.addMouseMotionListener(this);
		
	//  SHOW THE FRAME  -----------------------------------------
		setVisible(true);

	//  CALL getThis() to RETURN FRAME OBJECT TO CALLER 		
		getThis();
		
	}// end constructor
	
	public Frame getThis(){
		// cast JFrame as Frame and return object to caller 
		return (Frame)this.frame;
	}

	// RESPOND TO MOUSE DRAGGED / MOUSE MOVED EVENTS  ---------------------
	public void mouseDragged(MouseEvent event){
		myLabel.setState(1);						// set text to red
		myLabel.x = event.getX();
		myLabel.y = event.getY();
		myLabel.repaint();	
	}

	public void mouseMoved(MouseEvent event){
		myLabel.setState(0);
		myLabel.x = event.getX();
		myLabel.y = event.getY();
		myLabel.repaint();	
	}
} // end class Proj06Runner

// PRINT COORDINATES TO JFRAME  -------------------------------------------
class MyComponent extends JComponent{
	public int x;
	public int y;
	public int state;
	
	public MyComponent(){ this.state = 0; }			// constructor
		
	protected void paintComponent(Graphics g){		// paintComponent override
		super.paintComponent(g);		
		String str = x + ", " + y;
		if( getState() == 0 ){ 						// if mouse button is up
			g.setColor(Color.black);				// set text to black
		}	
		else{ 										// if mouse button is down
			g.setColor(Color.red); 					// set text to red
		}
		g.drawString(str, x, y);		
	}
		
	public int getState(){ return state; }			//  getter method
	public void setState(int x){ this.state = x;}	//	setter method
	
} // end class MyComponent

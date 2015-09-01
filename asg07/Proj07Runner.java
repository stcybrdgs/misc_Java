/******************************************
* Programmer:  Stacy Bridges
* Course:      Java Programming (Intermediate)
* Assg:        Asg07
*******************************************/
import java.util.*;
import javax.swing.*;
import java.awt.*;			
import java.awt.event.*;

public class Proj07Runner extends JFrame implements ActionListener{
    JFrame frame;
    JButton leftButton;
    JButton rightButton;
    JLabel label;
	
    public Proj07Runner(){
        this.setTitle("Stacy Bridges");
	this.setSize(250, 100);		// (width, height);
	this.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
	FlowLayout myLayout = new FlowLayout(FlowLayout.TRAILING);
	this.setLayout(myLayout);
		
	leftButton = new JButton("Left");
	label = new JLabel("Left", JLabel.CENTER);		
	label.setForeground(Color.red);
	label.setBackground(Color.yellow);
	// rem: JLabel is transparent by default, so set it opaque
	// to show background color
	label.setOpaque(true);				
	rightButton = new JButton("Right");		
		
	this.add(leftButton);	
	this.add(label);			
	this.add(rightButton);
		
        leftButton.addActionListener(this);
	rightButton.addActionListener(this);
		
	setVisible(true);
    }// end constructor
	
    public void actionPerformed(ActionEvent event){
        String buttonVal = event.getActionCommand();
	label.setText(buttonVal);
    }
    
} // end class Proj07Runner

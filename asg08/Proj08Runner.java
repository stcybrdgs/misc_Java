/******************************************
* Student:  Stacy Bridges
* Course:   ITSE2317 - Java Programming (Intermediate)
* Assg:     Asg08
* Date:     July 11, 2015
*******************************************/
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;			
import java.awt.event.*;

public class Proj08Runner extends JFrame{
	JFrame frame;
	JPanel panel;
	JLabel label;
	JSlider slider;
	
	public Proj08Runner(){
		this.setTitle("Stacy Bridges");
		this.setSize(300, 100);		// (width, height);
		this.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		//FlowLayout myLayout = new FlowLayout(FlowLayout.CENTER);
		BorderLayout myLayout = new BorderLayout();
		this.setLayout(myLayout);

		// the sample program seems to place the counter label
		//		such that it overlaps the slider a bit, so I'm
		// 		adding a panel to the frame and then placing
		//		my counter label in the panel. . . this 
		//		mechanism provides the overlap necessary to mimic
		//		the sample program. . . 
		panel = new JPanel();					//	make the panel
		this.add(panel, BorderLayout.NORTH);	//	add it to the frame
		label = new JLabel("50", JLabel.CENTER);// 	make a counter label
		panel.add(label);						//  add it to the panel
		
		// add a slider to the frame
		slider = new JSlider();
		slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);
		this.add(slider, BorderLayout.CENTER);	
		
		// add a listener to the slider
		slider.addChangeListener(new MyListener());
		
		setVisible(true);
	}// end constructor
	
class MyListener implements ChangeListener{
	public void stateChanged(ChangeEvent event){
		
		JSlider obj = (JSlider)event.getSource();	// make an obj handler
		int x = obj.getValue();						// get value of  slider
		label.setText(Integer.toString(x));			// print value to label
	}// end stateChanged()	
}// end class MyListener
	
} // end class Proj08Runner


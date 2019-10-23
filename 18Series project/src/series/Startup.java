package series;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JWindow;


public class Startup extends JWindow {
	JProgressBar pb;

	public Startup() {
		
		buildWindow();
		buildProgressBar();
		initiateProgress();
		
	}

	
	public static void main(String[] args) {
		new Startup();

	}
	
	public void buildWindow(){
		setSize(400, 400);
		setLayout(null);
		setLocationRelativeTo(null);
		setContentPane(new JLabel(new ImageIcon("images/globe.jpg")));
		setVisible(true);
	}
	
	public void buildProgressBar(){
		pb = new JProgressBar();
		pb.setBounds(0,370,400,30);
		pb.setBorderPainted(true);
		pb.setStringPainted(true);
		pb.setBackground(Color.WHITE);
		pb.setForeground(Color.BLACK);
		pb.setValue(0);
		
		add(pb);
		
	}
	
	public void initiateProgress(){
		int i=0;
	  
		while( i<=100) {
			
			try {
				/*
				 * sleep is a method of Thread
				 * sleep shows how long it is waiting in milliseconds
				 */
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pb.setValue(i);
			
			i++;
		}
		/*
		 * close the Splash screen and
		 * open the login window
		 */
		dispose();
		new Login();
		
	}//end of method initiateProgress()

}

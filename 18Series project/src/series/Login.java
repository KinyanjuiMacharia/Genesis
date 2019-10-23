package series;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jvnet.substance.skin.SubstanceBusinessLookAndFeel;
import org.jvnet.substance.skin.SubstanceMangoLookAndFeel;


public class Login extends JFrame implements ActionListener{

	Connection conn;
	//String db_url = "jdbc:mysql://localhost:3306/18series";
	/*String username;
	String password;*/
	JLabel lblUser, lblPass;
	JTextField txtUser;
	JPasswordField txtPass;
	JButton butNext, butLogin;
	JPanel panMain, panUser, panPass;
	CardLayout cl;
	GridBagLayout gbl;
	GridBagConstraints c;
	
	public Login(){
		setExtendedState(MAXIMIZED_BOTH);
		setUndecorated(true);
		
		try {
			UIManager.setLookAndFeel(new SubstanceBusinessLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Font fOne = new Font("Garamond", Font.PLAIN, 30);
		
		Font fTwo = new Font("Comic Sans Ms", Font.BOLD, 30);
		
		gbl = new GridBagLayout();
		c = new GridBagConstraints();
		
		panMain = new JPanel();
		//panMain.add(new JLabel(new ImageIcon("images/Penguins.jpg")));
		cl = new CardLayout();
		panMain.setLayout(cl);
		
		panUser = new JPanel();
		panUser.setLayout(gbl);
		
		lblUser = new JLabel("Username");
		lblUser.setFont(fOne);
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5,5,5,5);
		panUser.add(lblUser, c);
				
		txtUser = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(5,5,5,5);
		panUser.add(txtUser, c);
		
		butNext = new JButton("Next");
		butNext.setFont(fTwo);
		butNext.addActionListener(this);
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(5,5,5,5);
		panUser.add(butNext, c);
		
		panMain.add(panUser, "User");
		
		panPass = new JPanel();
		panPass.setLayout(gbl);
		
		lblPass = new JLabel("Password");
		lblPass.setFont(fOne);
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5,5,5,5);
		panPass.add(lblPass, c);
				
		txtPass = new JPasswordField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(5,5,5,5);
		panPass.add(txtPass, c);
		
		butLogin = new JButton("Login");
		butLogin.setFont(fTwo);
		butLogin.addActionListener(this);
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(5,5,5,5);
		panPass.add(butLogin, c);
		
		panMain.add(panPass, "Pass");
		
		
		
		add(panMain);
		setVisible(true);
	}

	
	public static void main(String[] args) {
		new Login();

	}


	public void actionPerformed(ActionEvent ae) {
		Object src = ae.getSource();
		
		if(src == butLogin){
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String username = txtUser.getText(); 
				String password = String.valueOf(txtPass.getPassword());
				conn =new PerConn(username, password).getConnection();
				
				JOptionPane.showMessageDialog(null, "Welcome");
				
				dispose();
				new Mzazi();
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,e.getMessage());
			} 
			/*catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
		}else{
			
			cl.show(panMain, "Pass");
			
		}
		
	}

}

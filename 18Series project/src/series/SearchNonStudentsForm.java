package series;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SearchNonStudentsForm extends JInternalFrame implements ActionListener {
	
	JLabel lblMember_ID, lblFirstName, lblLastName, lblSurname, lblPhone, lblID_or_Passport, 
	lblPlace_of_employment, lblDepartment, lblAddress, lblOccupation_or_Profession, lblEmail, lblCounty, lblSubCounty, lblWard;

	JTextField txtMember_ID, txtFirstName, txtLastName, txtSurname, txtPhone, txtID_or_Passport, 
	txtPlace_of_employment, txtDepartment, txtAddress, txtOccupation_or_Profession, txtEmail, txtCounty, txtSubCounty, txtWard;
	
	JButton butSearch;
	
	GridBagLayout gbl;
	GridBagConstraints c;
	Connection conn;
	PreparedStatement ps;
	Statement st;
	ResultSet rs;

	public SearchNonStudentsForm() {
		
		super("Search non-student form", true, true, true, true);
		setBounds(100,100,400,600);
		
		gbl = new GridBagLayout();
		c = new GridBagConstraints();
		setLayout(gbl);
		
		lblMember_ID = new JLabel("Member ID"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(10,10,10,10);
		add(lblMember_ID, c);
		
		txtMember_ID = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(10,10,10,10);
		add(txtMember_ID, c);
		
		
		lblFirstName = new JLabel("First Name");  
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(10,10,10,10);
		add(lblFirstName, c);
		
		txtFirstName = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(10,10,10,10);
		add(txtFirstName, c);
		
		lblLastName = new JLabel("Last Name"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(10,10,10,10);
		add(lblLastName, c);
		
		txtLastName = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(10,10,10,10);
		add(txtLastName, c);		
		
		lblSurname = new JLabel("Surname"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 3;
		c.insets = new Insets(10,10,10,10);
		add(lblSurname, c);
		
		txtSurname = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 3;
		c.insets = new Insets(10,10,10,10);
		add(txtSurname, c);
		
		lblPhone = new JLabel("Phone number"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 4;
		c.insets = new Insets(10,10,10,10);
		add(lblPhone, c);
		
		txtPhone = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 4;
		c.insets = new Insets(10,10,10,10);
		add(txtPhone, c);
		
		lblID_or_Passport = new JLabel("ID/ Passport number"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 5;
		c.insets = new Insets(10,10,10,10);
		add(lblID_or_Passport, c);
		
		txtID_or_Passport = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 5;
		c.insets = new Insets(10,10,10,10);
		add(txtID_or_Passport, c);
		
		lblPlace_of_employment = new JLabel("Place of employment"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 6;
		c.insets = new Insets(10,10,10,10);
		add(lblPlace_of_employment, c);
		
		txtPlace_of_employment = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 6;
		c.insets = new Insets(10,10,10,10);
		add(txtPlace_of_employment, c);
		
		lblDepartment = new JLabel("Department"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 7;
		c.insets = new Insets(10,10,10,10);
		add(lblDepartment, c);
		
		txtDepartment = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 7;
		c.insets = new Insets(10,10,10,10);
		add(txtDepartment, c);
		
		lblAddress = new JLabel("Address"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 8;
		c.insets = new Insets(10,10,10,10);
		add(lblAddress, c);
		
		txtAddress = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 8;
		c.insets = new Insets(10,10,10,10);
		add(txtAddress, c);
		
		lblOccupation_or_Profession = new JLabel("Occupation or profession"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 9;
		c.insets = new Insets(10,10,10,10);
		add(lblOccupation_or_Profession, c);
		
		txtOccupation_or_Profession = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 9;
		c.insets = new Insets(10,10,10,10);
		add(txtOccupation_or_Profession, c);
		
		lblEmail = new JLabel("Email"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 10;
		c.insets = new Insets(10,10,10,10);
		add(lblEmail, c);
		
		txtEmail = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 10;
		c.insets = new Insets(10,10,10,10);
		add(txtEmail, c);
		
		lblCounty = new JLabel("County");
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 11;
		c.insets = new Insets(10,10,10,10);
		add(lblCounty, c);
		
		txtCounty = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 11;
		c.insets = new Insets(10,10,10,10);
		add(txtCounty, c);
		
		lblSubCounty = new JLabel("Sub-county"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 12;
		c.insets = new Insets(10,10,10,10);
		add(lblSubCounty, c);
		
		txtSubCounty = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 12;
		c.insets = new Insets(10,10,10,10);
		add(txtSubCounty, c);
		
		lblWard = new JLabel("Ward");
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 13;
		c.insets = new Insets(10,10,10,10);
		add(lblWard, c);
		
		txtWard = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 13;
		c.insets = new Insets(10,10,10,10);
		add(txtWard, c);
		
		butSearch = new JButton("Search");
		butSearch.addActionListener(this);
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 14;
		c.insets = new Insets(10,10,10,10);
		add(butSearch, c);
		
		setLayout(gbl);
		
		
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		
		String id = txtMember_ID.getText();
		
		if(source == butSearch){
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			
			
			conn = new PerConn().getConnection();
			
			st = conn.createStatement();
			
			String search = "select * from non_student where Member_ID='"+id+"'";
			
			rs = st.executeQuery(search);
			
			while(rs.next()){
				
				txtFirstName.setText(rs.getString("FirstName"));
				txtLastName.setText(rs.getString("LastName")); 
				txtSurname.setText(rs.getString("Surname"));
				txtPhone.setText(rs.getString("PhoneNumber")); 
				txtID_or_Passport.setText(rs.getString("ID_or_Passport")); 
				txtPlace_of_employment.setText(rs.getString("Place_of_employment"));
				txtDepartment.setText(rs.getString("Department"));
				txtAddress.setText(rs.getString("Address"));
				txtOccupation_or_Profession.setText(rs.getString("Occupation_or_profession"));
				txtEmail.setText(rs.getString("Email")); 
				txtCounty.setText(rs.getString("County"));
				txtSubCounty.setText(rs.getString("Sub_county"));
				txtWard.setText(rs.getString("Ward"));
				
				
			}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}

}

package series;

import java.awt.BorderLayout;
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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class EditNonStudentsForm extends JInternalFrame implements ActionListener {
	
	JLabel lblMember_ID, lblFirstName, lblLastName, lblSurname, lblPhone, lblID_or_Passport, 
	lblPlace_of_employment, lblDepartment, lblAddress, lblOccupation_or_Profession, lblEmail, lblCounty, lblSubCounty, lblWard;

	JTextField txtMember_ID, txtFirstName, txtLastName, txtSurname, txtPhone, txtID_or_Passport, 
	txtPlace_of_employment, txtDepartment, txtAddress, txtOccupation_or_Profession, txtEmail, txtCounty, txtSubCounty, txtWard;
	
	JButton butSaveChanges, butEdit;
	
	GridBagLayout gbl;
	GridBagConstraints c;
	Connection conn;
	PreparedStatement ps;
	Statement st;
	ResultSet rs;
	
	JPanel panTop, panBot;

	public EditNonStudentsForm() {
		
		super("Edit non-student details", true, true, true, true);
		
		setBounds(100,100,400,600);
		
		gbl = new GridBagLayout();
		c = new GridBagConstraints();
		
		Border b = BorderFactory.createTitledBorder("Edit ID");
		panTop = new JPanel();
		panTop.setLayout(gbl);
		panTop.setBorder(b);
		
		lblMember_ID = new JLabel("Member ID"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(2,2,2,2);
		panTop.add(lblMember_ID, c);
		
		txtMember_ID = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(2,2,2,2);
		panTop.add(txtMember_ID, c);
		
		butEdit =new JButton("Edit");
		butEdit.addActionListener(this);
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(2,2,2,2);
		panTop.add(butEdit, c);
		
		Border b1 = BorderFactory.createTitledBorder("Edit Details");
		panBot = new JPanel();
		panBot.setLayout(gbl);
		panBot.setBorder(b1);
		
		lblFirstName = new JLabel("First Name");  
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(2,2,2,2);
		panBot.add(lblFirstName, c);
		
		txtFirstName = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(2,2,2,2);
		panBot.add(txtFirstName, c);
		
		lblLastName = new JLabel("Last Name"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 3;
		c.insets = new Insets(2,2,2,2);
		panBot.add(lblLastName, c);
		
		txtLastName = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 3;
		c.insets = new Insets(2,2,2,2);
		panBot.add(txtLastName, c);		
		
		lblSurname = new JLabel("Surname"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 4;
		c.insets = new Insets(2,2,2,2);
		panBot.add(lblSurname, c);
		
		txtSurname = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 4;
		c.insets = new Insets(2,2,2,2);
		panBot.add(txtSurname, c);
		
		lblPhone = new JLabel("Phone number"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 5;
		c.insets = new Insets(2,2,2,2);
		panBot.add(lblPhone, c);
		
		txtPhone = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 5;
		c.insets = new Insets(2,2,2,2);
		panBot.add(txtPhone, c);
		
		lblID_or_Passport = new JLabel("ID/ Passport number"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 6;
		c.insets = new Insets(2,2,2,2);
		panBot.add(lblID_or_Passport, c);
		
		txtID_or_Passport = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 6;
		c.insets = new Insets(2,2,2,2);
		panBot.add(txtID_or_Passport, c);
		
		lblPlace_of_employment = new JLabel("Place of employment"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 7;
		c.insets = new Insets(2,2,2,2);
		panBot.add(lblPlace_of_employment, c);
		
		txtPlace_of_employment = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 7;
		c.insets = new Insets(2,2,2,2);
		panBot.add(txtPlace_of_employment, c);
		
		lblDepartment = new JLabel("Department"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 8;
		c.insets = new Insets(2,2,2,2);
		panBot.add(lblDepartment, c);
		
		txtDepartment = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 8;
		c.insets = new Insets(2,2,2,2);
		panBot.add(txtDepartment, c);
		
		lblAddress = new JLabel("Address"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 9;
		c.insets = new Insets(2,2,2,2);
		panBot.add(lblAddress, c);
		
		txtAddress = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 9;
		c.insets = new Insets(2,2,2,2);
		panBot.add(txtAddress, c);
		
		lblOccupation_or_Profession = new JLabel("Occupation or profession"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 10;
		c.insets = new Insets(2,2,2,2);
		panBot.add(lblOccupation_or_Profession, c);
		
		txtOccupation_or_Profession = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 10;
		c.insets = new Insets(2,2,2,2);
		panBot.add(txtOccupation_or_Profession, c);
		
		lblEmail = new JLabel("Email"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 11;
		c.insets = new Insets(2,2,2,2);
		panBot.add(lblEmail, c);
		
		txtEmail = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 11;
		c.insets = new Insets(2,2,2,2);
		panBot.add(txtEmail, c);
		
		lblCounty = new JLabel("County");
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 12;
		c.insets = new Insets(2,2,2,2);
		panBot.add(lblCounty, c);
		
		txtCounty = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 12;
		c.insets = new Insets(2,2,2,2);
		panBot.add(txtCounty, c);
		
		lblSubCounty = new JLabel("Sub-county"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 13;
		c.insets = new Insets(2,2,2,2);
		panBot.add(lblSubCounty, c);
		
		txtSubCounty = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 13;
		c.insets = new Insets(2,2,2,2);
		panBot.add(txtSubCounty, c);
		
		lblWard = new JLabel("Ward");
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 14;
		c.insets = new Insets(2,2,2,2);
		panBot.add(lblWard, c);
		
		txtWard = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 14;
		c.insets = new Insets(2,2,2,2);
		panBot.add(txtWard, c);
		
		butSaveChanges = new JButton("Save Changes");
		butSaveChanges.addActionListener(this);
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 15;
		c.insets = new Insets(2,2,2,2);
		panBot.add(butSaveChanges, c);
		
		add(panTop, BorderLayout.NORTH);
		add(panBot, BorderLayout.CENTER);
				
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		
		String id = txtMember_ID.getText();
		
		if(source == butEdit){
			
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
			
		}else{
			
			String fn = txtFirstName.getText();
			String ln = txtLastName.getText();
			String sn = txtSurname.getText();
			String phone = txtPhone.getText();
			String id_Pass = txtID_or_Passport.getText();
			String pe = txtPlace_of_employment.getText();
			String dpt = txtDepartment.getText();
			String address = txtAddress.getText();
			String occupation = txtOccupation_or_Profession.getText();
			String email = txtEmail.getText();
			String county = txtCounty.getText();
			String subcounty = txtSubCounty.getText();
			String ward = txtWard.getText();
			
			try {
				
				conn = new PerConn().getConnection();
				
				st = conn.createStatement();
				
				String add = "insert into non_student values('"+id+"', '"+fn+"', '"+ln+"', '"+sn+"', '"+phone+"', '"+id_Pass+"',"
						+ " '"+pe+"', '"+dpt+"', '"+address+"', '"+occupation+"', '"+email+"', '"+county+"',"
								+ " '"+subcounty+"', '"+ward+"')";
				
				int insert = st.executeUpdate(add);
				
				txtMember_ID.setText("");
				txtFirstName.setText("");
				txtLastName.setText("");
				txtSurname.setText("");
				txtPhone.setText("");
				txtID_or_Passport.setText("");
				txtPlace_of_employment.setText("");
				txtDepartment.setText("");
				txtAddress.setText("");
				txtOccupation_or_Profession.setText("");
				txtEmail.setText("");
				txtCounty.setText("");
				txtSubCounty.setText("");
				txtWard.setText("");
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

}

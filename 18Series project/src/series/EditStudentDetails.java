/**
 * 
 */
package series;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
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

/**
 * @author ACE SD
 *
 */
public class EditStudentDetails extends JInternalFrame implements ActionListener {
	
	JLabel lblMemberID, lblFirstName, lblLastName, lblSurname, lblPhone, lblID, lblSchool, lblAddress, lblClass,
	lblAdmNumber, lblAdmYear, lblFinishYear;
	
	JTextField  txtMemberID, txtFirstName, txtLastName, txtSurname, txtPhone, txtID, txtSchool, txtAddress, txtClass,
	txtAdmNumber, txtAdmYear, txtFinishYear;
	
	JButton butSaveChanges, butEdit;
	
	GridBagLayout gbl;
	GridBagConstraints c;
	Connection conn;
	PreparedStatement ps;
	Statement st;
	ResultSet rs;

	/**
	 * 
	 */
	public EditStudentDetails() {
		super("Edit student details form", true, true, true, true);
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(d.width / 2, d.height / 2);
		
		gbl = new GridBagLayout();
		c = new GridBagConstraints();
		
		setLayout(gbl);
		
		lblMemberID = new JLabel("Member ID"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(10,10,10,10);
		add(lblMemberID, c);
		
		txtMemberID = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(10,10,10,10);
		add(txtMemberID, c);
		
		butEdit = new JButton("Edit");
		butEdit.addActionListener(this);
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(10,10,10,10);
		add(butEdit, c);
		
		lblFirstName = new JLabel("First Name"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(10,10,10,10);
		add(lblFirstName, c);
		
		txtFirstName = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(10,10,10,10);
		add(txtFirstName, c);	
		
		lblLastName = new JLabel("Last Name"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 3;
		c.insets = new Insets(10,10,10,10);
		add(lblLastName, c);
		
		txtLastName = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 3;
		c.insets = new Insets(10,10,10,10);
		add(txtLastName, c);		
		
		lblSurname = new JLabel("Surname"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 4;
		c.insets = new Insets(10,10,10,10);
		add(lblSurname, c);
		
		txtSurname = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 4;
		c.insets = new Insets(10,10,10,10);
		add(txtSurname, c);		
		
		lblPhone = new JLabel("Phone Number"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 5;
		c.insets = new Insets(10,10,10,10);
		add(lblPhone, c);
		
		txtPhone = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 5;
		c.insets = new Insets(10,10,10,10);
		add(txtPhone, c);	
		
		lblID = new JLabel("ID/ Passport number"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 6;
		c.insets = new Insets(10,10,10,10);
		add(lblID, c);
		
		txtID = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 6;
		c.insets = new Insets(10,10,10,10);
		add(txtID, c);	
		
		lblSchool = new JLabel("School/ Institution"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 7;
		c.insets = new Insets(10,10,10,10);
		add(lblSchool, c);
		
		txtSchool = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 7;
		c.insets = new Insets(10,10,10,10);
		add(txtSchool, c);	
		
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
		
		lblClass = new JLabel("Class"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 9;
		c.insets = new Insets(10,10,10,10);
		add(lblClass, c);
		
		txtClass = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 9;
		c.insets = new Insets(10,10,10,10);
		add(txtClass, c);		
		
		lblAdmNumber = new JLabel("Admission Number"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 10;
		c.insets = new Insets(10,10,10,10);
		add(lblAdmNumber, c);
		
		txtAdmNumber = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 10;
		c.insets = new Insets(10,10,10,10);
		add(txtAdmNumber, c);	
		
		lblAdmYear = new JLabel("Year of admission"); 
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 11;
		c.insets = new Insets(10,10,10,10);
		add(lblAdmYear, c);
		
		txtAdmYear = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 11;
		c.insets = new Insets(10,10,10,10);
		add(txtAdmYear, c);	
		
		lblFinishYear = new JLabel("Year of finishing");
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 12;
		c.insets = new Insets(10,10,10,10);
		add(lblFinishYear, c);
		
		txtFinishYear = new JTextField();
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 12;
		c.insets = new Insets(10,10,10,10);
		add(txtFinishYear, c);
		
		butSaveChanges = new JButton("Save changes");
		butSaveChanges.addActionListener(this);
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 13;
		c.insets = new Insets(10,10,10,10);
		add(butSaveChanges, c);
		
		
		
		setVisible(true);
	}

	
	public void actionPerformed(ActionEvent ae) {
		Object src = ae.getSource();
		

		
		String mID = txtMemberID.getText();
		String fn = txtFirstName.getText();
		String ln = txtLastName.getText();
		String sn = txtSurname.getText();
		String pn = txtPhone.getText();
		String Id = txtID.getText();
		String school = txtSchool.getText();
		String address = txtAddress.getText();
		String cls = txtClass.getText();
		String adm = txtAdmNumber.getText();
		String admYear = txtAdmYear.getText();
		String finish = txtFinishYear.getText();
		
		if(src == butEdit){
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				conn = new PerConn().getConnection();
				
				st = conn.createStatement();
				
				String search = "select * from Student where Member_ID='"+mID+"'";
				
				rs = st.executeQuery(search);
				
				while(rs.next()){
					
					txtFirstName.setText(rs.getString("FirstName"));
					txtLastName.setText(rs.getString("lastName"));
					txtSurname.setText(rs.getString("Surname"));
					txtPhone.setText(rs.getString("PhoneNumber"));
					txtID.setText(rs.getString("ID_or_Passport"));
					txtSchool.setText(rs.getString("School"));
					txtAddress.setText(rs.getString("Address"));
					txtClass.setText(rs.getString("Class"));
					txtAdmNumber.setText(rs.getString("AdmissionNumber"));
					txtAdmYear.setText(rs.getString("AdmissionYear"));
					txtFinishYear.setText(rs.getString("FinishingYear"));
					
					
				}
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				conn = new PerConn().getConnection();
				
//				txtFirstName.setText(rs.getString("FirstName"));
//				txtLastName.setText(rs.getString("lastName"));
//				txtSurname.setText(rs.getString("Surname"));
//				txtPhone.setText(rs.getString("PhoneNumber"));
//				txtID.setText(rs.getString("ID_or_Passport"));
//				txtSchool.setText(rs.getString("School"));
//				txtAddress.setText(rs.getString("Address"));
//				txtClass.setText(rs.getString("Class"));
//				txtAdmNumber.setText(rs.getString("AdmissionNumber"));
//				txtAdmYear.setText(rs.getString("AdmissionYear"));
//				txtFinishYear.setText(rs.getString("FinishingYear"));
//				
//				'"+mID+"', '"+fn+"', '"+ln+"', '"+sn+"', '"+pn+"', '"+Id+"',"
//						+ " '"+school+"', '"+address+"', '"+cls+"', '"+adm+"', '"+admYear+"', '"+finish+"'
				
				String edit = "update Student set FirstName='"+fn+"', LastName='"+ln+"', Surname='"+sn+"', PhoneNumber='"+pn+"', ID_or_Passport='"+Id+"', "
						+ "School='"+school+"', Address='"+address+"', Class='"+cls+"'"
								+ ", AdmissionNumber='"+adm+"', AdmissionYear='"+admYear+"', FinishingYear='"+finish+"'"
								+ " where Member_ID='"+mID+"'";
				
				st = conn.createStatement();
				
				int editedBook = st.executeUpdate(edit);			
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}

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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * @author kise
 *
 */
public class EditBooksForm extends JInternalFrame implements ActionListener {
	
	JLabel lblID, lblTitle, lblCategory, lblSubCategory, lblEdition, lblPublisher, lblAuthor, lblStatus;
	JTextField txtID, txtTitle, txtCategory, txtSubCategory, txtEdition, txtPublisher, txtAuthor, txtStatus;
	JButton butSaveChanges, butEdit;
	
	GridBagLayout gbl;
	GridBagConstraints c;
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	Statement st;
	Border b;
	JPanel panTop, panCentre;

	/**
	 * 
	 */
	public EditBooksForm() {
			super("Edit", true, true, true, true);
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			setSize(d.width / 2, d.height / 2);
			
			gbl = new GridBagLayout();
			c = new GridBagConstraints();
			
			setLayout(gbl);
			
			lblID = new JLabel("Book ID");
			c.anchor = GridBagConstraints.WEST;
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 0;
			c.gridy = 0;
			c.insets = new Insets(10,10,10,10);
			add(lblID, c);
			
			txtID = new JTextField();
			c.anchor = GridBagConstraints.WEST;
			c.fill = GridBagConstraints.BOTH;
			c.weightx = 1.0;
			c.gridx = 1;
			c.gridy = 0;
			c.insets = new Insets(10,10,10,10);
			add(txtID, c);
			
			butEdit = new JButton("Edit");
			butEdit.addActionListener(this);
			c.anchor = GridBagConstraints.WEST;
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 1;
			c.gridy = 1;
			c.insets = new Insets(10,10,10,10);
			add(butEdit, c);
			
			lblTitle = new JLabel("Title");
			c.anchor = GridBagConstraints.WEST;
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 0;
			c.gridy = 2;
			c.insets = new Insets(10,10,10,10);
			add(lblTitle, c);
			
			txtTitle = new JTextField();
			c.anchor = GridBagConstraints.WEST;
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 1;
			c.gridy = 2;
			c.insets = new Insets(10,10,10,10);
			add(txtTitle, c);
			
			lblCategory = new JLabel("Category");
			c.anchor = GridBagConstraints.WEST;
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 0;
			c.gridy = 3;
			c.insets = new Insets(10,10,10,10);
			add(lblCategory, c);
			
			txtCategory = new JTextField();
			c.anchor = GridBagConstraints.WEST;
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 1;
			c.gridy = 3;
			c.insets = new Insets(10,10,10,10);
			add(txtCategory, c);
			
			lblSubCategory = new JLabel("Sub category");
			c.anchor = GridBagConstraints.WEST;
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 0;
			c.gridy = 4;
			c.insets = new Insets(10,10,10,10);
			add(lblSubCategory, c);
			
			txtSubCategory = new JTextField();
			c.anchor = GridBagConstraints.WEST;
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 1;
			c.gridy = 4;
			c.insets = new Insets(10,10,10,10);
			add(txtSubCategory, c);
			
			lblEdition = new JLabel("Edition");
			c.anchor = GridBagConstraints.WEST;
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 0;
			c.gridy = 5;
			c.insets = new Insets(10,10,10,10);
			add(lblEdition, c);
			
			txtEdition = new JTextField();
			c.anchor = GridBagConstraints.WEST;
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 1;
			c.gridy = 5;
			c.insets = new Insets(10,10,10,10);
			add(txtEdition, c);
			
			lblPublisher = new JLabel("Publisher");
			c.anchor = GridBagConstraints.WEST;
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 0;
			c.gridy = 6;
			c.insets = new Insets(10,10,10,10);
			add(lblPublisher, c);
			
			txtPublisher = new JTextField();
			c.anchor = GridBagConstraints.WEST;
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 1;
			c.gridy = 6;
			c.insets = new Insets(10,10,10,10);
			add(txtPublisher, c);
			
			lblAuthor = new JLabel("Author");
			c.anchor = GridBagConstraints.WEST;
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 0;
			c.gridy = 7;
			c.insets = new Insets(10,10,10,10);
			add(lblAuthor, c);
			
			txtAuthor = new JTextField();
			c.anchor = GridBagConstraints.WEST;
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 1;
			c.gridy = 7;
			c.insets = new Insets(10,10,10,10);
			add(txtAuthor, c);
			
			lblStatus = new JLabel("Status");
			c.anchor = GridBagConstraints.WEST;
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 0;
			c.gridy = 8;
			c.insets = new Insets(10,10,10,10);
			add(lblStatus, c);
			
			txtStatus = new JTextField();
			c.anchor = GridBagConstraints.WEST;
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 1;
			c.gridy = 8;
			c.insets = new Insets(10,10,10,10);
			add(txtStatus, c);	
			
			butSaveChanges = new JButton("Save Changes");
			butSaveChanges.addActionListener(this);
			c.anchor = GridBagConstraints.WEST;
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 1;
			c.gridy = 9;
			c.insets = new Insets(10,10,10,10);
			add(butSaveChanges, c);
			
			
			setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object src = ae.getSource();
		
		String ID = txtID.getText();
		String title = txtTitle.getText();
		String cat = txtCategory.getText();
		String sub_cat = txtSubCategory.getText();
		String edition = txtEdition.getText();
		String pub = txtPublisher.getText();
		String author = txtAuthor.getText();
		String status = txtStatus.getText();
		
		if(src == butEdit){
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");				
				conn = new PerConn().getConnection();
				
			st = conn.createStatement();
			
			String search = "select * from books where BookId='"+ID+"'";
			
			rs = st.executeQuery(search);
			
			while(rs.next()){
				
				txtTitle.setText(rs.getString("Title"));
				txtCategory.setText(rs.getString("Category"));
				txtSubCategory.setText(rs.getString("Sub_Category"));
				txtEdition.setText(rs.getString("Edition"));
				txtPublisher.setText(rs.getString("Publisher"));
				txtAuthor.setText(rs.getString("Author"));
				txtStatus.setText(rs.getString("Status"));	
				
			}
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				conn = new PerConn().getConnection();
				
				String edit = "update books set Title='"+title+"', Category='"+cat+"', "
						+ "Sub_Category='"+sub_cat+"', Edition='"+edition+"', Publisher='"+pub+"', "
						+ "Author='"+author+"', Status='"+status+"' where BookId='"+ID+"'";
				
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

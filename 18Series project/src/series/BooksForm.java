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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author kise
 *
 */
public class BooksForm extends JInternalFrame implements ActionListener {
	
	JLabel lblID, lblTitle, lblCategory, lblSubCategory, lblEdition, lblPublisher, lblAuthor, lblStatus;
	JTextField txtID, txtTitle, txtCategory, txtSubCategory, txtEdition, txtPublisher, txtAuthor, txtStatus;
	JButton butSubmit;
	
	GridBagLayout gbl;
	GridBagConstraints c;
	Connection conn;
	Statement st;
	ResultSet rs;
	
	
	/**
	 * 
	 */
	public BooksForm() {
		super("Books Form", true, true, true, true);
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(d.width / 2, d.height / 2);
		
		gbl = new GridBagLayout();
		c = new GridBagConstraints();
		
		setLayout(gbl);
		
		lblID = new JLabel("Book ID");
		c.anchor = c.WEST;
		c.fill = c.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(10,10,10,10);
		add(lblID, c);
		
		txtID = new JTextField();
		c.anchor = c.WEST;
		c.fill = c.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(10,10,10,10);
		add(txtID, c);
		
		lblTitle = new JLabel("Title");
		c.anchor = c.WEST;
		c.fill = c.BOTH;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(10,10,10,10);
		add(lblTitle, c);
		
		txtTitle = new JTextField();
		c.anchor = c.WEST;
		c.fill = c.BOTH;
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(10,10,10,10);
		add(txtTitle, c);
		
		lblCategory = new JLabel("Category");
		c.anchor = c.WEST;
		c.fill = c.BOTH;
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(10,10,10,10);
		add(lblCategory, c);
		
		txtCategory = new JTextField();
		c.anchor = c.WEST;
		c.fill = c.BOTH;
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(10,10,10,10);
		add(txtCategory, c);
		
		lblSubCategory = new JLabel("Sub category");
		c.anchor = c.WEST;
		c.fill = c.BOTH;
		c.gridx = 0;
		c.gridy = 3;
		c.insets = new Insets(10,10,10,10);
		add(lblSubCategory, c);
		
		txtSubCategory = new JTextField();
		c.anchor = c.WEST;
		c.fill = c.BOTH;
		c.gridx = 1;
		c.gridy = 3;
		c.insets = new Insets(10,10,10,10);
		add(txtSubCategory, c);
		
		lblEdition = new JLabel("Edition");
		c.anchor = c.WEST;
		c.fill = c.BOTH;
		c.gridx = 0;
		c.gridy = 4;
		c.insets = new Insets(10,10,10,10);
		add(lblEdition, c);
		
		txtEdition = new JTextField();
		c.anchor = c.WEST;
		c.fill = c.BOTH;
		c.gridx = 1;
		c.gridy = 4;
		c.insets = new Insets(10,10,10,10);
		add(txtEdition, c);
		
		lblPublisher = new JLabel("Publisher");
		c.anchor = c.WEST;
		c.fill = c.BOTH;
		c.gridx = 0;
		c.gridy = 5;
		c.insets = new Insets(10,10,10,10);
		add(lblPublisher, c);
		
		txtPublisher = new JTextField();
		c.anchor = c.WEST;
		c.fill = c.BOTH;
		c.gridx = 1;
		c.gridy = 5;
		c.insets = new Insets(10,10,10,10);
		add(txtPublisher, c);
		
		lblAuthor = new JLabel("Author");
		c.anchor = c.WEST;
		c.fill = c.BOTH;
		c.gridx = 0;
		c.gridy = 6;
		c.insets = new Insets(10,10,10,10);
		add(lblAuthor, c);
		
		txtAuthor = new JTextField();
		c.anchor = c.WEST;
		c.fill = c.BOTH;
		c.gridx = 1;
		c.gridy = 6;
		c.insets = new Insets(10,10,10,10);
		add(txtAuthor, c);
		
		lblStatus = new JLabel("Status");
		c.anchor = c.WEST;
		c.fill = c.BOTH;
		c.gridx = 0;
		c.gridy = 7;
		c.insets = new Insets(10,10,10,10);
		add(lblStatus, c);
		
		txtStatus = new JTextField();
		c.anchor = c.WEST;
		c.fill = c.BOTH;
		c.gridx = 1;
		c.gridy = 7;
		c.insets = new Insets(10,10,10,10);
		add(txtStatus, c);	
		
		butSubmit = new JButton("Submit");
		butSubmit.addActionListener(this);
		c.anchor = c.WEST;
		c.fill = c.BOTH;
		c.gridx = 1;
		c.gridy = 8;
		c.insets = new Insets(10,10,10,10);
		add(butSubmit, c);
		
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		String ID = txtID.getText();
		String title = txtTitle.getText();
		String cat = txtCategory.getText();
		String sub_cat = txtSubCategory.getText();
		String edition = txtEdition.getText();
		String pub = txtPublisher.getText();
		String author = txtAuthor.getText();
		String status = txtStatus.getText();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = new PerConn().getConnection();
			
			st = conn.createStatement();
			
			String add = "insert into books values('"+ID+"', '"+title+"', '"+cat+"', '"+sub_cat+"', '"+edition+"', '"+pub+"', '"+author+"', '"+status+"')";
			
			int daniel = st.executeUpdate(add);
			
			
			txtID.setText("");
			txtTitle.setText("");
			txtCategory.setText("");
			txtSubCategory.setText("");
			txtEdition.setText("");
			txtPublisher.setText("");
			txtAuthor.setText("");
			txtStatus.setText("");
			
//			String fetchID = "select BookId from books";
//			
//			rs = st.executeQuery(fetchID);
//			
//			if(ID.equals(rs)){
//				JOptionPane.showMessageDialog(null, "ID already exists");
//			}
			
			
			
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}

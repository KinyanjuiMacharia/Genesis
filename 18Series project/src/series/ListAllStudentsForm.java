/**
 * 
 */
package series;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author ACE Developers
 *
 */
public class ListAllStudentsForm extends JInternalFrame {
	
	JTable tb;
	JScrollPane jp;
	Connection conn;
	Statement st;
	ResultSet rs;
	/**
	 * 
	 */
	public ListAllStudentsForm() {
		// TODO Auto-generated constructor stub
	super("List all students Form", true, true, true, true);
		
	setBounds(100,100,400,400);
	
	conn = new PerConn().getConnection();
	
	try {
		st=conn.createStatement();
		
		rs=st.executeQuery("select * from student");
		
		String col[]={"Member ID","First name","Last Name","Surname","Phone number","ID/ passport","school",
				"Address", "Class", "Admission Number", "Admission date", "Finishing date"};
		String rdata[][]=new String[100][12];
		
		int s=1;
		while(rs.next()){
			
			rdata[s][0]=rs.getString("Member_ID");
			rdata[s][1]=rs.getString("FirstName");
			rdata[s][2]=rs.getString("LastName");
			rdata[s][3]=rs.getString("Surname");
			rdata[s][4]=rs.getString("PhoneNumber");
			rdata[s][5]=rs.getString("ID_or_Passport");
			rdata[s][6]=rs.getString("School");
			rdata[s][7]=rs.getString("Address");
			rdata[s][8]=rs.getString("Class");
			rdata[s][9]=rs.getString("AdmissionNumber");
			rdata[s][10]=rs.getString("AdmissionYear");
			rdata[s][11]=rs.getString("FinishingYear");
			
			
			s++;
			
			tb=new JTable(rdata,col);
		    jp=new JScrollPane(tb);
		    add(jp);
			
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	setVisible(true);
	}


}

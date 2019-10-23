package series;

import javax.swing.JInternalFrame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;

import javax.swing.*;
public class ListAllBooksForm extends JInternalFrame {
	JTable tb;
	JScrollPane jp;
	Connection conn;
	
	public ListAllBooksForm() {
		
		super("List all books form", true, true, true, true);
		setBounds(100,100,400,400);
		
		setVisible(true);
		try {
			conn = new PerConn().getConnection();
			
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select * from books");
			
			String col[]={"Book ID","Title","Category","sub category","Edition","Publisher","Author","Status"};
			String rdata[][]=new String[100][8];
			
			int s=-1;
			try{
			while(rs.next()){
				++s;
				rdata[s][0]=rs.getString("BookId");  
				rdata[s][1]=rs.getString("Title");
				rdata[s][2]=rs.getString("category");
				rdata[s][3]=rs.getString("sub_category"); 
				rdata[s][4]=rs.getString("Edition");
				rdata[s][5]=rs.getString("Publisher");  
				rdata[s][6]=rs.getString("Author");
				rdata[s][7]=rs.getString("Status");
				
				tb=new JTable(rdata,col);
			    jp=new JScrollPane(tb);
			    add(jp);
			}}catch (Exception ex){
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		setVisible(true);
	}


}

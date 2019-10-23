package series;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class PerConn{
	
	private static String url="jdbc:mysql://localhost:3306/18series";
	private static String username;
	private static String password;
	private static Connection conn;
	
	
	public PerConn(String username,String password){
		this.username=username;
		this.password=password;
	}
	public PerConn(){
		
	}
	public Connection getConnection(){
		try{
		conn=DriverManager.getConnection(url,username,password);
		}
		catch(Exception na){
			JOptionPane.showMessageDialog(null,na.getMessage());
			
			
		}
		return conn;
	}
}

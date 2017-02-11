package system.commen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.PropertyResourceBundle;

public class DBConnection {
	
	private String str_URL = null;
	private String str_db_username = null;
	private String str_db_password = null;
	private String str_db_JdbcDriverName = null;
	
	private Connection conn =null;
	

	public Connection getConn() {
		return conn;
	}

	public DBConnection(){
		/*
		this.str_db_username = "root";
		this.str_db_password = "root";
		this.str_URL="jdbc:mysql://localhost:3306/mlia";
		this.str_db_JdbcDriverName= "com.mysql.jdbc.Driver";
		*/
		this.loadConnInformation();
		//loadConnInfo();
	}
	
	public boolean getConnect(){
		try {
			Class.forName(str_db_JdbcDriverName).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("failed!");
			e.printStackTrace();
			return false;
		}
		try {
			this.conn = DriverManager.getConnection(str_URL,str_db_username,str_db_password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("failed!");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	private void loadConnInformation(){
		PropertyResourceBundle   config = 
				(PropertyResourceBundle)PropertyResourceBundle
				.getBundle("system.commen.product",
						new Locale("cn","CN"));
		this.str_db_username=config.getString("username");
		this.str_db_password=config.getString("password");
		this.str_db_JdbcDriverName=config.getString("JdbcDriverName");;
		this.str_URL=config.getString("url");
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConnection db = new DBConnection();
		boolean flag = db.getConnect();
		System.out.println(flag);
	}

	
	
}

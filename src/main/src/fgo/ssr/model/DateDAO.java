package fgo.ssr.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.sql.DataSource;



import java.io.*;


public class DateDAO {
	private static final String INSERT_STMT =
            "INSERT INTO checkdate(name, date) VALUES(?,?)";
	private static final String RETRIEVE_STMT =
            "SELECT date FROM checkdate WHERE name =?";
	private static final String Check_UserExist =
            "SELECT name FROM userlist WHERE name =?";	
	//應該是建立..連線..
	public static Connection getConnection() {
	        DataSource ds = null;
	        Connection con = null;
	        try {
	            Context ctx = new InitialContext();
	            if (ctx == null) {
	                throw new RuntimeException("JDNI Context could not found");
	            }
	            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/crmDB");
	            if (ds == null) {
	                throw new RuntimeException("DataSource could not found");
	            }
	            con = ds.getConnection();
	        } catch (SQLException e) {
	            throw new RuntimeException("A database error occured. " + e.getMessage());
	        } catch (NamingException e) {
	            throw new RuntimeException("A JNDI error occured. " + e.getMessage());
	        }
	        return con;
	    }	
	//也是連線..另一種!
	public static Connection getConnection2() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/crm";
            String id = "root";
            String pw = "root";
            con = DriverManager.getConnection(url, id, pw);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    } 
	
	public boolean Exist(String name) throws IOException  {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean UserExist = false;                    
        try {
            con = getConnection();   
            // Use the Connection to create a Statement object
            stmt = con.prepareStatement(Check_UserExist);                   
            stmt.setString(1, name);            
            // Execute query using Statement, receive the ResultSet
            rs = stmt.executeQuery();            
           if(rs.next()) {
        	   UserExist = true;
        	   return UserExist;
           }
           return UserExist;
         } catch (SQLException e) {
            throw new RuntimeException("A database error occured. " + e.getMessage());           
        } finally {        	
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace(System.err);                    
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }

    }
	 public void dateCheckIn(oneDay od) throws IOException  {
	        Connection con = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        String today = od.getDate();
	        int num_of_rows = 0;        
	        
	        try {
	            con = getConnection();	          
	            // Use the Connection to create a Statement object
	            stmt = con.prepareStatement(INSERT_STMT);            	            
	            stmt.setString(1, od.getName());
	            stmt.setString(2, od.getDate());           
	            // Execute query using Statement, receive the ResultSet
	            stmt.execute();	           
	     
	            //System.out.println(rs.getInt(1));
	        } catch (SQLException e) {
	            throw new RuntimeException("A database error occured. " + e.getMessage());
	           
	        } finally {
	            if (stmt != null) {
	                try {
	                    stmt.close();
	                } catch (SQLException e) {
	                    e.printStackTrace(System.err);
	                    
	                }
	            }
	            if (con != null) {
	                try {
	                    con.close();
	                } catch (Exception e) {
	                    e.printStackTrace(System.err);
	                }
	            }
	        }

	    }
	
	 public LinkedList<String> getAllday(String name) {

		    Connection con = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
 	        
	        LinkedList<String> Allday = new LinkedList<>();
	        
	        try {
	            con = getConnection();

	            // Use the Connection to create a Statement object
	            stmt = con.prepareStatement(RETRIEVE_STMT);
	            
                stmt.setString(1, name.trim());
	            rs = stmt.executeQuery();

	            while (rs.next()) {
	               
	            	Allday.add(rs.getString("date").trim());           
	                            
	            }

	            return Allday;

	        } catch (SQLException e) {
	            throw new RuntimeException("A database error occured.(getallday) " + e.getMessage());
	        } finally {
	            if (rs != null) {
	                try {
	                    rs.close();
	                } catch (SQLException e) {
	                    e.printStackTrace(System.err);
	                }
	            }
	            if (stmt != null) {
	                try {
	                    stmt.close();
	                } catch (SQLException e) {
	                    e.printStackTrace(System.err);
	                }
	            }
	            if (con != null) {
	                try {
	                    con.close();
	                } catch (Exception e) {
	                    e.printStackTrace(System.err);
	                }
	            }
	        }
	    }
	
}

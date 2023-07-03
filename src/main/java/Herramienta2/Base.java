package Herramienta2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
 
/**
 *
 * @author sqlitetutorial.net
 */
public class Base {
 
    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     * @throws SQLException 
     */
	
    public Connection connect() throws SQLException {
        // SQLite connection string
        //String url = "jdbc:sqlite:"+Base.class.getResource("/BD/casos.db");
        String url = "jdbc:sqlite:"+"/Users/edgar.reza.sanchez/Desarrollos/casos.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
        return conn;
    }
 
    /**
     * Insert a new row into the warehouses table
     *
     * @param name
     * @param capacity
     * @throws SQLException 
     */
    public void insert(String caso, String keyword, String object, String type, String value, String paso) throws SQLException {
        String sql = "INSERT INTO casos_prueba(num_caso,keyword,object,type,value,paso) VALUES(?,?,?,?,?,?)";
        Connection conn = connect();
        
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            pstmt.setString(1, caso);
            pstmt.setString(2, keyword);
            pstmt.setString(3, object);
            pstmt.setString(4, type);
            pstmt.setString(5, value);
            pstmt.setString(6, paso);
            pstmt.executeUpdate();
            
            conn.close();

       
    }
    
    
    public ResultSet consulta(String caso) {
    	     String caso1="null";
    	     String keyword="null";
    	     String object="null";
    	     String type="null";
    	     String value="null";
    	     String caso2="null";
    	     ResultSet rs = null;
    	     
    	    	
    	try { 
    		Connection conn = this.connect();
    		 String sql = "SELECT * FROM casos_prueba where num_caso = ?";
    		 PreparedStatement ps = conn.prepareStatement(sql);
    		 ps.setString(1, caso);
    		 rs = ps.executeQuery();
    		 
    		 
    		 while(rs.next()) {
    			     				 
    		 caso1=rs.getString(1);
    		 keyword=rs.getString(2);
    		 object=rs.getString(3);
    		 type=rs.getString(4);
    		 value=rs.getString(5);
    		 
    		 System.out.println(caso1);
             System.out.println(keyword);
             System.out.println(object);
             System.out.println(type);
             System.out.println(value);		
    			 }
             
           
             
     		} catch (Exception e) {
    		 
    		 System.out.println(e.getMessage());
    		 e.printStackTrace();
    		}
		return rs;
    	
    	        }

    public static void appendToFile(Exception e,String cp, String error, String objeto) {
        try {
           FileWriter fstream = new FileWriter("C:\\Automatizacion\\errores\\"+ cp +".txt", true);
           BufferedWriter out = new BufferedWriter(fstream);
           PrintWriter pWriter = new PrintWriter(out, true);
           //e.printStackTrace(pWriter);
           //pWriter.write("/n"+ error);
           pWriter.println(error +". El elemento es:  "+ objeto);
           pWriter.close();
           
        }
        catch (Exception ie) {
           throw new RuntimeException("Could not write Exception to file", ie);
        }
     }
    
    public void update(String num_caso, String keyword, String object, String type, String value,String paso) {
    	String sql = "UPDATE casos_prueba SET num_caso=?, keyword=?, object=?, type=?,value=? WHERE num_caso=? and paso=?";
               
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, num_caso);
            pstmt.setString(2, keyword);
            pstmt.setString(3, object);
            pstmt.setString(4, type);
            pstmt.setString(5, value);
            pstmt.setString(6, num_caso);
            pstmt.setString(7, paso);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void delete(String id) {
        String sql = "DELETE FROM casos_prueba  WHERE num_caso = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, id);
            // execute the delete statement
            pstmt.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void delete_paso(String caso,String paso) {
        String sql = "DELETE FROM casos_prueba  WHERE num_caso = ? and paso = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, caso);
            pstmt.setString(2, paso);
            // execute the delete statement
            pstmt.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void insert_step(String caso, String keyword, String object, String type, String value, String paso) throws SQLException {
        String sql = "INSERT INTO casos_prueba(num_caso,keyword,object,type,value,paso) VALUES(?,?,?,?,?,?)";
        Connection conn1 = connect();
        
            PreparedStatement pstmt = conn1.prepareStatement(sql); 
            pstmt.setString(1, caso);
            pstmt.setString(2, keyword);
            pstmt.setString(3, object);
            pstmt.setString(4, type);
            pstmt.setString(5, value);
            pstmt.setString(6, paso);
            pstmt.executeUpdate();
            
            conn1.close();
        
   	    // conn.close();
    }
   	 
    public String consultar(String caso) {
    	 
    	String paso1="null";
	   
	     ResultSet rs = null;
	     
	    	
	try { 
		Connection conn = this.connect();
		 String sql = "SELECT paso, MAX(paso) paso FROM casos_prueba WHERE num_caso = ?";
		 PreparedStatement ps = conn.prepareStatement(sql);
		 ps.setString(1, caso);
		 rs = ps.executeQuery();
		 
		 
		 while(rs.next()) {
			     				 
		 paso1=rs.getString(1);
		
		 
		System.out.println(paso1);
      		
			 }
        
      
        
		} catch (Exception e) {
		 
		 System.out.println(e.getMessage());
		 e.printStackTrace();
		}
	    return paso1;
   	
   		}
   			
   	
    
    

    
    /**
     * @param args the command line arguments
     * @throws SQLException 
     */
    public static void main(String[] args) throws SQLException {
 
        Base app = new Base();
        // insert three new rows
       // app.insert("CP02", "GOTOURL","hola","hola","url","1");
        //app.consulta("CP005");
        //app.insert_step("ejemplo3", "base", "base", "base", "base","2");
        app.consultar("ejemplo3");
        //app.delete("ejemplo11");
    }
 
}
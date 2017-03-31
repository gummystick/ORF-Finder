/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orf.finder.application;

import java.sql.*;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Driver;
import java.util.ArrayList;

/**
 *
 * @Ruben vermaas
 */
public class TransportData {
    
    private Statement st;
    private Statement st2;
    private ResultSet rs;
    private Connection con;
    private Connection con2;
    
    
    String username = "owe7_pg4";
    String password = "blaat1234";
    String value = "";
    
      
    public void connectdb() {
    
        System.out.println("Testeing connection......");    
    try{
        Class.forName("oracle.jdbc.OracleDriver");
        
        con = DriverManager.getConnection("jdbc:oracle:thin:@cytosine.nl:1521:XE",username,password);
        st = con.createStatement();
    } 
    catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
        }
        System.out.println("Connection succesfull!");
    }
     
    public void getData(){
        try{
            String query = "SELECT * FROM ORF WHERE ROWNUM <= 100";
            rs = st.executeQuery(query);
            System.out.println("Resultaten: ");
            while(rs.next()){
                String orfid = rs.getString("ORF_ID");
                String readingframe = rs.getString("READING_FRAME");
                String startcodon = rs.getString("START_CODON");
                String stopcodon = rs.getString("STOP_CODON");
                System.out.println("readingframe: " + readingframe );
                System.out.println("orfid: " + orfid);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    
    public void setData(){
        
        try{
            String sql = "INSERT INTO ORF (ORF_ID, READING_FRAME, START_CODON, STOP_CODON)" + "VALUES (?,?,?,?)";
            
            
            PreparedStatement st2 = con2.prepareStatement(sql);
            
            st2.setString(1,"1235");
            st2.setString(2,"Test1");
            st2.setString(3,"Test2");
            st2.setString(4,"Test3");
            
            st2.execute();          
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
}

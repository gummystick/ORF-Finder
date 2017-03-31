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
            String query = "SELECT * FROM ORFFINDER WHERE ROWNUM <= 100";
            rs = st.executeQuery(query);
            System.out.println("Resultaten: ");
            while(rs.next()){
                String header = rs.getString("HEADER");
                String orfid = rs.getString("ORFID");
                System.out.println("header: " + header);
                System.out.println("orfid: " + orfid);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    
    public void setData(){
        
        try{
            String sql = "Insert into ORFFINDER (HEADER, ORFID, DNASEQUENTIE, POSITIE, PERCENTAGEGC) Value (?,?,?,?,?) ";
            st2 = con2.prepareStatement(sql);
            //st2.setString(1, value.get )
            //st2.execute(String);
            
            
            
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
}

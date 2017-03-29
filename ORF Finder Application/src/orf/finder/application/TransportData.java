/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orf.finder.application;

import java.sql.*;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Driver;

/**
 *
 * @Ruben vermaas
 */
public class TransportData {
    
    private Statement st;
    private ResultSet rs;
    private Connection con;
    
    String username = "SYSTEM";
    String password = "projectgroep6";
    
      
    public void connectdb() {
    
        System.out.println("Testeing connection......");    
    try{
        Class.forName("oracle.jdbc.OracleDriver");
        
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",username,password);
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
        
    }
}

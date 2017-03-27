/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orf.finder.application;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @Ruben vermaas
 */
public class TransportData {
    
    private Statement st;
    private ResultSet rs;
    private Connection con;
    
      
    public void connect() {
    try{
        Class.forName("oracle.jdbc.OracleDriver");
        
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE");
        st = con.createStatement();
    } 
    catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
        }
    }
     
    public void getData(){
        try{
            String query = "Select * from ORFFINDER";
            rs = st.executeQuery(query);
            System.out.println("Resultaten: ");
            while(rs.next()){
                String header = rs.getString("HEADER");
                String object = rs.getString("OBJECT");
                System.out.println("header: " + header);
                System.out.println("object: " + object);
            }
            
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}

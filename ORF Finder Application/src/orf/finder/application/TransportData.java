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
 * @Ruben Vermaas
 */
public class TransportData {

    
    public static Connection connect() {
    try{
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE");
        return con;
    
    } 
    catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
    return null;
    }
}

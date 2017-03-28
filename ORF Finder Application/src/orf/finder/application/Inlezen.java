/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orf.finder.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Lisanne
 */
public class Inlezen {
    
    

    public static void readFile() {
        ArrayList<String> header = new ArrayList<>();
        BufferedReader br = null;
        String path = "C:\\Users\\User\\Documents\\Course 7\\Weektaken\\Debaryomyces_occidentalis.fas";
        try {
            br = new BufferedReader(new FileReader(path));
            br.readLine();
            
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(">")){
                    header.add(line);
                }
                    
            }
            System.out.println(header);
            br.close();
        
        } catch (IOException ioe) {
         JOptionPane.showMessageDialog(null,
                    "File Error: " + ioe.toString());
        } 
        catch (NullPointerException np){
            System.out.println("Er is een fout opgetreden");
        }
        catch (Exception ex) {
            System.out.println("Onbekende fout: raadpleeg uw systeembeheerder");} 
    }
    public static void main(String[] args) {
        readFile();
    }

}

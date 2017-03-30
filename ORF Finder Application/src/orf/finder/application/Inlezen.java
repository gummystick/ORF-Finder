/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orf.finder.application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Lisanne
 */
public class Inlezen {
    
    private String filePath;
    private ArrayList<ArrayList> sequentieInfo = new ArrayList<>();
    
    public Inlezen(String path){
        filePath = path;
    }
    
    public ArrayList<ArrayList> getSequentieInfo(){
        return sequentieInfo;
    }
    public void readFile() {
        ArrayList<String> header = new ArrayList<>();
        ArrayList<String> sequentie = new ArrayList<>();
        int count =-1;
        
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            
            String line;
            while ((line = br.readLine()) != null) {
                count++;
                if (line.startsWith(">")){
                    header.add(line);
                }
                else if (count==1){
                    sequentie.add(line);
                   
                    
                }
                else if (count>1){
                    String seq = sequentie.get(0);
                    String newseq = seq+line;
                    sequentie.set(0, newseq);
                    
                }
               
                    
            }
            
            sequentieInfo.add(header);
            sequentieInfo.add(sequentie);     
            
            System.out.println(sequentieInfo);
            
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

}

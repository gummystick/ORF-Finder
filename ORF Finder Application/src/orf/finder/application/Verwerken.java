/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orf.finder.application;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Gebruiker
 */
public class Verwerken {
private static ArrayList<String> gen = new ArrayList<String>();
private static String header = "abc";
                                //"876543210987654321
                                //"AATGTAA"
                                //"TTTTTACATT"
private static String genoomSeq = "TTACAT"; //"xxxATGdxxxxxbdxxxxxxxxbTAGxxxxxxxxxxxxATGddddddbTAGxxxxxxxxx";
private static String reverseCompGenoomSeq;
private static String codonRead;
private static String[] genoomRfArray1;
private static String[] genoomRfArray2;
private static String[] genoomRfArray3;
private static String[] genoomRfArray4;
private static String[] genoomRfArray5;
private static String[] genoomRfArray6;
private static String[] startCodon = {"ATG"};
private static String[] stopCodons = {"TAA", "TAG", "TGA"};
private static ArrayList<Integer> reReadPositions = new ArrayList<Integer>();

private static boolean startFound = false;
private static boolean searchOnlyStop = false;
private static int positieStart;

//private static int positieStop;
//private static
//private static String[] stopCodons = {"123", "456", "789"};


    public static void verwerk(){
            gen.add(header);
            gen.add(genoomSeq); 
               
            makeReverseComp();
            //verwerkReadingFrame1();
           // verwerkReadingFrame2();
           // verwerkReadingFrame3();
           verwerkReadingFrame4();
           //           verwerkReadingFrame5();
           
    }
    
    public static void makeReverseComp(){
    
    StringBuilder builder = new StringBuilder(genoomSeq);
    
    reverseCompGenoomSeq = builder.reverse().toString();
   
    reverseCompGenoomSeq = reverseCompGenoomSeq.replace('A', 't');
    reverseCompGenoomSeq = reverseCompGenoomSeq.replace('T', 'A');
    reverseCompGenoomSeq = reverseCompGenoomSeq.replace('C', 'g');
    reverseCompGenoomSeq = reverseCompGenoomSeq.replace('G', 'C');
    reverseCompGenoomSeq = reverseCompGenoomSeq.toUpperCase();
    
    }
    
    public static void verwerkReadingFrame1(){    
        
        genoomRfArray1 = new String[genoomSeq.length()/3];
        for (int x = 0; x<genoomSeq.length()/3 ; x++) {
            genoomRfArray1[x] = genoomSeq.substring(0 + x*3, 3 + x*3);
        }
        for (int x = 0; x<genoomRfArray1.length; x++){
           if(genoomRfArray1[x].equals(startCodon[0])) {
                if (searchOnlyStop == false){
                positieStart = x * 3;    
                startFound = true;
                System.out.println(x * 3 + 1 + "start op hele genoom");
                searchOnlyStop = true;
                } 
            }   
            if (startFound == true){
                for (int i = 0; i<stopCodons.length; i++){
                    if (genoomRfArray1[x].equals(stopCodons[i])){
                        OrfObject orf = new OrfObject();
                        orf.setStartPositie(positieStart + 1);
                        orf.setStopPositie(x * 3 + 3);
                        orf.setORFseq(genoomSeq.substring(positieStart, x * 3 + 3));                   
                        System.out.println(positieStart + 1 + "start1 op reading frame" );
                        System.out.println(x * 3 + 3 + "stop1 op reading frame");
                        System.out.println(genoomSeq.substring(positieStart, x * 3 + 3));
                        startFound = false;
                        searchOnlyStop = false;                       
                    }
                }
            }
        }
    }                   
    
    public static void verwerkReadingFrame2(){    
        
        genoomRfArray2 = new String[(genoomSeq.length()-1)  /3 ];
        for (int x = 0; x<(genoomSeq.length()-1)/3  ; x++) {
            genoomRfArray2[x] = genoomSeq.substring(1 + x*3, 4 + x*3);
        } 
        for (int x = 0; x<genoomRfArray2.length; x++){
                if (searchOnlyStop == false){
                    if(genoomRfArray2[x].equals(startCodon[0])) {            
                    positieStart = x * 3 + 1;    
                    startFound = true;
                    System.out.println(x * 3 + 2 + "start op hele genoom");
                    searchOnlyStop = true;
                }
            }
            if (startFound == true){
                for (int i = 0; i<stopCodons.length; i++){
                    if (genoomRfArray2[x].equals(stopCodons[i])){
                        OrfObject orf = new OrfObject();
                        orf.setStartPositie(positieStart + 1);
                        orf.setStopPositie(x * 3 + 3 + 1);
                        orf.setORFseq(genoomSeq.substring(positieStart, x * 3 + 4));                   
                        System.out.println(positieStart + 1 +"start3" );
                        System.out.println(x * 3 + 3 + 1 + "stop4");
                        System.out.println(genoomSeq.substring(positieStart, x * 3 + 4));
                        startFound = false;
                        searchOnlyStop = false;                       

                    }
                }
            }
        }
    }
    
    
    public static void verwerkReadingFrame3(){    
        
        genoomRfArray3 = new String[(genoomSeq.length()-2)  /3 ];
        for (int x = 0; x<(genoomSeq.length()-2)/3  ; x++) {
            genoomRfArray3[x] = genoomSeq.substring(2 + x*3, 5 + x*3);
        } 
        for (int x = 0; x<genoomRfArray3.length; x++){
            if (searchOnlyStop == false){
                if(genoomRfArray3[x].equals(startCodon[0])) {
                    positieStart = x * 3 + 2;    
                    startFound = true;
                    System.out.println(x * 3 + 3 + "start op hele genoom");
                    searchOnlyStop = true;
                }
            }
            if (startFound == true){
                for (int i = 0; i<stopCodons.length; i++){
                    if (genoomRfArray3[x].equals(stopCodons[i])){
                        OrfObject orf = new OrfObject();
                        orf.setStartPositie(positieStart + 1);
                        orf.setStopPositie(x * 3 + 3 + 2);
                        orf.setORFseq(genoomSeq.substring(positieStart, x * 3 + 5));                   
                        System.out.println(positieStart + 1 +"start3" );
                        System.out.println(x * 3 + 3 + 2 + "stop4");
                        System.out.println(genoomSeq.substring(positieStart, x * 3 + 5));
                        startFound = false;
                        searchOnlyStop = false;                       

                    }
                }
            }
        }
    }
    
    public static void verwerkReadingFrame4(){    
                                            
        genoomRfArray4 = new String[reverseCompGenoomSeq.length()/3];
        for (int x = 0; x<reverseCompGenoomSeq.length()/3 ; x++) {
            genoomRfArray4[x] = reverseCompGenoomSeq.substring(0 + x*3, 3 + x*3);
        }
        for (int x = 0; x<genoomRfArray4.length; x++){
            if (searchOnlyStop == false){
                if(genoomRfArray4[x].equals(startCodon[0])) {
                positieStart = x * 3;    
                startFound = true;
                System.out.println(x * 3 + 1 + "start op hele genoom");
                searchOnlyStop = true;
                } 
            }   
            if (startFound == true){

                for (int i = 0; i<stopCodons.length; i++){
                    if (genoomRfArray4[x].equals(stopCodons[i])){
                        OrfObject orf = new OrfObject();
                        orf.setStartPositie(reverseCompGenoomSeq.length() -positieStart );
                        orf.setStopPositie(reverseCompGenoomSeq.length() -x * 3 -2);
                        orf.setORFseq(reverseCompGenoomSeq.substring(positieStart, x * 3 + 3));                   
                        System.out.println(positieStart + 1 + "start1 op reading frame" );
                        System.out.println(x * 3 + 3 + "stop1 op reading frame");
                        System.out.println(reverseCompGenoomSeq.substring(positieStart, x * 3 + 3));
                        System.out.println(reverseCompGenoomSeq.length() -positieStart );
                        System.out.println(reverseCompGenoomSeq.length() -x * 3 -2);
                        startFound = false;
                        searchOnlyStop = false;                       
                    }
                }
            }
        }
    }                   
    public static void verwerkReadingFrame5(){    
        
        genoomRfArray5 = new String[(reverseCompGenoomSeq.length()-1)  /3 ];
        for (int x = 0; x<(reverseCompGenoomSeq.length()-1)/3  ; x++) {
            genoomRfArray5[x] = reverseCompGenoomSeq.substring(1 + x*3, 4 + x*3);
        } 
        for (int x = 0; x<genoomRfArray5.length; x++){
                if (searchOnlyStop == false){
                    if(genoomRfArray5[x].equals(startCodon[0])) {            
                    positieStart = x * 3 + 1;    
                    startFound = true;
                    System.out.println(x * 3 + 2 + "start op hele genoom");
                    searchOnlyStop = true;
                }
            }
            if (startFound == true){
                for (int i = 0; i<stopCodons.length; i++){
                    if (genoomRfArray5[x].equals(stopCodons[i])){
                        OrfObject orf = new OrfObject();
                        orf.setStartPositie(reverseCompGenoomSeq.length() -positieStart);
                        orf.setStopPositie(reverseCompGenoomSeq.length() -x * 3 -3 -1);
                        orf.setORFseq(reverseCompGenoomSeq.substring(positieStart, x * 3 + 4));                   
                        System.out.println(reverseCompGenoomSeq.length() -positieStart +"start3" );
                        System.out.println(reverseCompGenoomSeq.length() -x * 3 -3  + "stop3");
                        //System.out.println(x * 3 + 3 + 1 + "stop4");
                        System.out.println(reverseCompGenoomSeq.substring(positieStart, x * 3 + 4)); // 13 22  tot28
                        startFound = false;
                        searchOnlyStop = false;                       

                    }
                }
            }
        }
    }
    
   //     System.out.println(genoomSeq.substring(x*3, x * 3 + 3));
    
    
   // String dna = "xxxATGdxxxxxbdxxxxxxxxbTAGxxxxxxxxx";

            
    /*genes.add(m.group().);
    m.group().replaceAll(m.group(), "");
    
    for (int x = 0; x<genes.size(); x++){
    System.out.println(genes.get(0) + x);
    }
    */
    

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       verwerk();
    }
    
}

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

private static String genoomSeq;
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
private static ArrayList<ORFObject> ORFObjectArray = new ArrayList<ORFObject>();

private static boolean startFound = false;
private static boolean searchOnlyStop = false;
private static int positieStart;

//private static int positieStop;
//private static
//private static String[] stopCodons = {"123", "456", "789"};

    /**
     *haalt de de data van genoomseq uit de arraylist sequentieInfo en roept de andere
     * methodes in deze class aan
     * @param sequentieInfo
     */
    public static void verwerk(ArrayList<ArrayList> sequentieInfo){
            
            genoomSeq = sequentieInfo.get(1).get(0).toString().toUpperCase();               
            makeReverseComp();
            verwerkReadingFrame1();                                             
            verwerkReadingFrame2();
            verwerkReadingFrame3();
            verwerkReadingFrame4();
            verwerkReadingFrame5();
            verwerkReadingFrame6();
                        
           
    }
                                             
    /**
     * keert de genoomSeq string om ver verwisseld elk voorkomen van A en T met elkaar 
     * en elk voorkomen van C en G
     */
    public static void makeReverseComp(){                                       //  
                                                                                // 
    StringBuilder builder = new StringBuilder(genoomSeq);                       //met elkaar
    
    reverseCompGenoomSeq = builder.reverse().toString();
   
    reverseCompGenoomSeq = reverseCompGenoomSeq.replace('A', 't');
    reverseCompGenoomSeq = reverseCompGenoomSeq.replace('T', 'A');
    reverseCompGenoomSeq = reverseCompGenoomSeq.replace('C', 'g');
    reverseCompGenoomSeq = reverseCompGenoomSeq.replace('G', 'C');
    reverseCompGenoomSeq = reverseCompGenoomSeq.toUpperCase();
    
    }
    
    /**
     * splits de genoomSeq in in substrings van 3 tekens groot
     * begint bij index 0 op de genoomSeq
     * zodra een stop condon na een start codon is gevonden word 
     * een ORFObject aangemaakt
     */
    public static void verwerkReadingFrame1(){                          
        startFound = false;                                               
        searchOnlyStop = false;
        genoomRfArray1 = new String[genoomSeq.length()/3];
        for (int x = 0; x<genoomSeq.length()/3 ; x++) {
            genoomRfArray1[x] = genoomSeq.substring(0 + x*3, 3 + x*3);
        }
        for (int x = 0; x<genoomRfArray1.length; x++){
           if(genoomRfArray1[x].equals(startCodon[0])) {
                if (searchOnlyStop == false){
                positieStart = x * 3;    
                startFound = true;
                searchOnlyStop = true;
                } 
            }   
            if (startFound == true){
                for (int i = 0; i<stopCodons.length; i++){
                    if (genoomRfArray1[x].equals(stopCodons[i])){
                        ORFObject orf = new ORFObject();
                        orf.setStartPositie(positieStart + 1);
                        orf.setStopPositie(x * 3 + 3);
                        orf.setORFseq(genoomSeq.substring(positieStart, x * 3 + 3));    
                        orf.setReadingFrame(1);
                        ORFObjectArray.add(orf);
                        startFound = false;
                        searchOnlyStop = false;                       
                    }
                }
            }
        }
    }                   
    
    /**
     * splits de genoomSeq in in substrings van 3 tekens groot
     * begint bij index 1 op de genoomSeq
     * zodra een stop condon na een start codon is gevonden word 
     * een ORFObject aangemaakt
     */
    public static void verwerkReadingFrame2(){    
        startFound = false;
        searchOnlyStop = false;
        genoomRfArray2 = new String[(genoomSeq.length()-1)  /3 ];
        for (int x = 0; x<(genoomSeq.length()-1)/3  ; x++) {
            genoomRfArray2[x] = genoomSeq.substring(1 + x*3, 4 + x*3);
        } 
        for (int x = 0; x<genoomRfArray2.length; x++){
                if (searchOnlyStop == false){
                    if(genoomRfArray2[x].equals(startCodon[0])) {            
                    positieStart = x * 3 + 1;    
                    startFound = true;
                    searchOnlyStop = true;
                }
            }
            if (startFound == true){
                for (int i = 0; i<stopCodons.length; i++){
                    if (genoomRfArray2[x].equals(stopCodons[i])){
                        ORFObject orf = new ORFObject();
                        orf.setStartPositie(positieStart + 1);
                        orf.setStopPositie(x * 3 + 3 + 1);
                        orf.setORFseq(genoomSeq.substring(positieStart, x * 3 + 4));    
                        orf.setReadingFrame(2);
                        ORFObjectArray.add(orf);
                        startFound = false;
                        searchOnlyStop = false;                       

                    }
                }
            }
        }
    }
    
    /**
     * splits de genoomSeq in in substrings van 3 tekens groot
     * begint bij index 2 op de genoomSeq
     * zodra een stop condon na een start codon is gevonden word 
     * een ORFObject aangemaakt
     */
    public static void verwerkReadingFrame3(){    
        startFound = false;
    searchOnlyStop = false;
        genoomRfArray3 = new String[(genoomSeq.length()-2)  /3 ];
        for (int x = 0; x<(genoomSeq.length()-2)/3  ; x++) {
            genoomRfArray3[x] = genoomSeq.substring(2 + x*3, 5 + x*3);
        } 
        for (int x = 0; x<genoomRfArray3.length; x++){
            if (searchOnlyStop == false){
                if(genoomRfArray3[x].equals(startCodon[0])) {
                    positieStart = x * 3 + 2;    
                    startFound = true;
                    searchOnlyStop = true;
                }
            }
            if (startFound == true){
                for (int i = 0; i<stopCodons.length; i++){
                    if (genoomRfArray3[x].equals(stopCodons[i])){
                        ORFObject orf = new ORFObject();
                        orf.setStartPositie(positieStart + 1);
                        orf.setStopPositie(x * 3 + 3 + 2);
                        orf.setORFseq(genoomSeq.substring(positieStart, x * 3 + 5));
                        orf.setReadingFrame(3);
                        ORFObjectArray.add(orf);
                        startFound = false;
                        searchOnlyStop = false;                       

                    }
                }
            }
        }
    }
    
    /**
     * splits de reverseCompGenoomSeq in in substrings van 3 tekens groot
     * begint bij index 0 op de reverseCompGenoomSeq
     * zodra een stop condon na een start codon is gevonden word 
     * een ORFObject aangemaakt
     */
    public static void verwerkReadingFrame4(){    
             startFound = false;
    searchOnlyStop = false;                               
        genoomRfArray4 = new String[reverseCompGenoomSeq.length()/3];
        for (int x = 0; x<reverseCompGenoomSeq.length()/3 ; x++) {
            genoomRfArray4[x] = reverseCompGenoomSeq.substring(0 + x*3, 3 + x*3);
        }
        for (int x = 0; x<genoomRfArray4.length; x++){
            if (searchOnlyStop == false){
                if(genoomRfArray4[x].equals(startCodon[0])) {
                positieStart = x * 3;    
                startFound = true;
                searchOnlyStop = true;
                } 
            }   
            if (startFound == true){

                for (int i = 0; i<stopCodons.length; i++){
                    if (genoomRfArray4[x].equals(stopCodons[i])){
                        ORFObject orf = new ORFObject();
                        orf.setStartPositie(reverseCompGenoomSeq.length() -x * 3 -2);                        
                        orf.setStopPositie(reverseCompGenoomSeq.length() -positieStart);
                        orf.setORFseq(reverseCompGenoomSeq.substring(positieStart, x * 3 + 3));     
                        orf.setReadingFrame(-1);
                        ORFObjectArray.add(orf);
                        startFound = false;
                        searchOnlyStop = false;                       
                    }
                }
            }
        }
    }                   

    /**
     * splits de reverseCompGenoomSeq in in substrings van 3 tekens groot
     * begint bij index 1 op de reverseCompGenoomSeq
     * zodra een stop condon na een start codon is gevonden word 
     * een ORFObject aangemaakt
     */
    public static void verwerkReadingFrame5(){    
        startFound = false;
    searchOnlyStop = false;
        genoomRfArray5 = new String[(reverseCompGenoomSeq.length()-1)  /3 ];
        for (int x = 0; x<(reverseCompGenoomSeq.length()-1)/3  ; x++) {
            genoomRfArray5[x] = reverseCompGenoomSeq.substring(1 + x*3, 4 + x*3);
        } 
        for (int x = 0; x<genoomRfArray5.length; x++){
                if (searchOnlyStop == false){
                    if(genoomRfArray5[x].equals(startCodon[0])) {            
                    positieStart = x * 3 + 1;    
                    startFound = true;
                    searchOnlyStop = true;
                }
            }
            if (startFound == true){
                for (int i = 0; i<stopCodons.length; i++){
                    if (genoomRfArray5[x].equals(stopCodons[i])){
                        ORFObject orf = new ORFObject();
                        orf.setStartPositie(reverseCompGenoomSeq.length() -x * 3 -3);                        
                        orf.setStopPositie(reverseCompGenoomSeq.length() -positieStart);
                        orf.setORFseq(reverseCompGenoomSeq.substring(positieStart, x * 3 + 4));
                        orf.setReadingFrame(-2);
   
                        startFound = false;
                        searchOnlyStop = false;                       

                    }
                }
            }
        }
    }

    /**
     * splits de reverseCompGenoomSeq in in substrings van 3 tekens groot
     * begint bij index 2 op de reverseCompGenoomSeq
     * zodra een stop condon na een start codon is gevonden word 
     * een ORFObject aangemaakt
     */
    public static void verwerkReadingFrame6(){    
        startFound = false;
        searchOnlyStop = false;
    
        genoomRfArray6 = new String[(reverseCompGenoomSeq.length()-2)  /3 ];
        for (int x = 0; x<(reverseCompGenoomSeq.length()-2)/3  ; x++) {
            genoomRfArray6[x] = reverseCompGenoomSeq.substring(2 + x*3, 5 + x*3);
        } 
        System.out.println("1");
        for (int x = 0; x<genoomRfArray6.length; x++){
                if (searchOnlyStop == false){
                    if(genoomRfArray6[x].equals(startCodon[0])) {            
                    positieStart = x * 3 + 2;    
                    startFound = true;
                    searchOnlyStop = true;
                }
            }System.out.println("2");
            if (startFound == true){
                for (int i = 0; i<stopCodons.length; i++){
                    if (genoomRfArray6[x].equals(stopCodons[i])){
                        ORFObject orf = new ORFObject();
                        orf.setStartPositie(reverseCompGenoomSeq.length() -x * 3 -4);                        
                        orf.setStopPositie(reverseCompGenoomSeq.length() -positieStart);
                        orf.setORFseq(reverseCompGenoomSeq.substring(positieStart, x * 3 + 5));  
                        orf.setReadingFrame(-3);
                        System.out.println("3");
                        startFound = false;
                        searchOnlyStop = false;                       

                    }
                }
            }
        }
    }    
 
    

    
   
    
}

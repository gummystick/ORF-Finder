    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orf.finder.application;

/**
 *
 * @author William
 */
public class ORFObject {
    
    protected String orfID;
    protected String dnaSequence;
    protected long positie;//could be another kind of variable, depending on the position notation
    protected double percentageGC;
    protected String test;

    
    public ORFObject(){
        
    }
    
    private void setDnaSequence(String sequence){
        dnaSequence = sequence;
    }
    
    private String getDnaSequence(){
        return dnaSequence;
    }
    
    private long getPositie(){
        return positie;
    }
    
    private double getPercentageGC(){
        return percentageGC;
    }
}
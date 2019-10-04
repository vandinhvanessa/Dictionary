/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;
 import java.util.HashMap;
 import java.util.Map;
 import java.util.Scanner;
/**
 *
 * @author vvan
 */
public class EnumDictionary extends HashMap<String, Dictionary.Word> {
    
    protected enum Word{
       
        
        
        private String name;
        private String[] nouns;
        private String[] verbs;
        private String[] adjectives;
        
       private Word(String name, String[] nouns, String[] verbs, String[] adjectives) {
           this.name = name;
           this.nouns = nouns;
           this.verbs = verbs;
           this.adjectives = adjectives;
       }

    }
}
   /* public String getName(){
        return name;
    }
    
    public String[] getNouns(){
        return nouns;
    }
    
    public String[] getVerbs(){
        return verbs;
    }
    
    public String[] getAdjectives(){
        return adjectives;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setNouns(String[] nouns){
        this.nouns = nouns;
    }
    
    public void setVerbs(String[] verbs){
        this.verbs = verbs;
    }
    
    public void setAdjectives(String [] adjectives){
        this.adjectives = adjectives;
    }*/
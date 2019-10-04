/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 *
 * @author vvan
 */
public class Dictionary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Map data = loadData();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(;;){
            try{
                System.out.print("Search: ");
                String name = reader.readline();
                
                if ("!Q".equals(name)){
                    System.out.println("-----THANK YOU-----");
                    System.exit(0);
                }
                
                String[] values = name.split(" ");
                
                String type = null;
                Map distinct = new HashMap<String, Integer>();
                boolean distinctFlag;
                distinctFlag = false;
                
                if (values.length > 1){
                    if (values[1].equals("distint")){
                        distinctFlag = true;
                        if (values.length > 2){
                            type = values[2];
                        }
                    }
                    else{
                        type = values[0];
                    }
                    name = values[0];
                }
                Dictionary x = Dictionary.valueOf(name.toUpperCase());
                Dictionary list2 = (Dictionary) data.get(x);
                String dname = x.getName();
                
               // System.out.println(Dictionary.valueOf(""));
                System.out.println(" [");
                for(Element s : list2.getList()){
                    if (type == null || type.equalsIgnoreCase(s.getType())){
                        if (!distinctFlag){
                            System.out.printf(" %s %s\n", dname, s);
                        }
                        else{
                            Integer ex = (Integer) distinct.get(s.toString());
                            if (ex == null || ex == 0){
                                System.out.printf(" %s %s\n", dname, s);
                                distinct.put(s.toString(), 1);
                            }
                        }
                    }
                }
              System.out.println("]");
              
            }
            catch(Exception e){
                System.out.println("[\n <Not Found>\n");
            }
        }
    }
    
    public enum KeyWord{
        PLACEHOLDER("PlaceHolder"), DISTINCT("Distinct"),BOOK("Book");
        List list = new ArrayList<Element>();
        String name;
        KeyWord(String s){
            this.name = s;
        }
        String getName(){
            return this.name;
        }
        public void add(Element s){
            list.add(s);
        }
        public List<Element> getList(){
            return list;
        }
        
    }
    
    private static Map<KeyWord, KeyWord> loadData(){
        Map data = new HashMap<KeyWord, List<KeyWord>>();
        
        KeyWord y = KeyWord.PLACEHOLDER;
        y.add(new Element("adverb", "Familiar. Worked in Java."));
        y.add(new Element("adverb", "Unique. No duplicates. Clearly different or of a different kind. "));
        y.add(new Element("noun", "A keyword in this assignment"));
        y.add(new Element("noun", "A keyword in this assignment"));
        
        data.put(KeyWord.PLACEHOLDER, y);
        KeyWord y2 = KeyWord.DISTINCT;
        y2.add(new Element ("noun", "A keyword in this assignment."));
        data.put(KeyWord.DISTINCT, y2);
        
        return data;
    }
    
    class Element {
        private String value;
        private String type;
        
        Element(String type, String value){
            this.type = type;
            this.value = value;
        }
        
        public String getType(){
            return type;
        }
        
        public String getValue(){
            return value;
        }
        
        @Override
        public String toString(){
            return String.format("[%s] : %s", type, value);
        }
    }
    
}







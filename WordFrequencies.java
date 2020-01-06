package RandomStory;
import edu.duke.*;
import java.util.*;

/**
 * Write a description of WordFrequencies here.
 * 
 * @author (lily) 
 * @version (a version number or a date)
 */
public class WordFrequencies {

    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies(){
        
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void findUnique(){
     
        FileResource resource = new FileResource();
        
        for(String s :resource.words()){
          s = s.toLowerCase();
          
          int index = myWords.indexOf(s);
          if(index == -1){
              myWords.add(s);
              myFreqs.add(1);
            }
            else{
                int value = myFreqs.get(index);
                myFreqs.set(index, value+1);
            }
        }
    }
    
    public void tester(){
      findUnique();
      int mostUsed = 0; 
      int totalUniqueWords =0;
      String maxWord = "";
      
      for(int k=0; k<myWords.size();k++){
          int count = myFreqs.get(k);
          System.out.println( count+ "\t" + myWords.get(k));
          if( count > mostUsed){
             mostUsed = count; 
             maxWord = myWords.get(k);
            }
        }
        System.out.println("The word that occurs most often and its count are:"+ "\t" +maxWord +"\t"+ mostUsed );
        System.out.println("unique words:" + myWords.size());
    }
    
    }
            
        
    

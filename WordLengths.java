import edu.duke.FileResource;

import java.io.File;
/**
 * Write a description of WordLengths here.
 * 
 * @author Lily
 * @version (a version number or a date)
 */
public class WordLengths {

    public void countWordLengths(FileResource resource ,int[]count){
        for(String s: resource.words()){
          char firstChar = s.charAt(0);
          char lastChar = s.charAt(s.length()-1);
          int wordLength = s.length();
          
          if(!Character.isLetter(firstChar)){
              wordLength = wordLength -1;
            }
            
          if(!Character.isLetter(lastChar)){
              wordLength = wordLength -1;
            }
           
          if(wordLength < 30 && wordLength>=0){
              count[wordLength]++;
            }
            
          else if(wordLength>30){
              count[30]++;
            }
          else{
            count[0]++;  
            }
            
            System.out.println(wordLength +":" + s);
            
        }
        
   // }
    int countAllWords = 0;
        for (int k=0; k < count.length; k++) {
            // todo add condition of non-zero printing
            if (count[k] > 0) {
                System.out.println(count[k] + " words of length " + k);
                // todo: add countAllWords
                countAllWords += count[k];
            }
        }
        System.out.println("countAllWords = " + countAllWords);
    }
    
    public void testCountWordLength(){
      
        
        FileResource fr = new FileResource();
        int[]counts = new int[31];
        countWordLengths(fr, counts);
    }
}

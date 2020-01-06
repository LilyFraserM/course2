package RandomStory;

import edu.duke.*;
import java.io.File;
import java.util.*;

/**
 * Write a description of WordsInFiles here.
 * 
 * @author (Lily) 
 * @version (a version number or a date)
 */
public class WordsInFiles {

    
    private HashMap<String, ArrayList> hashWords;
    
    public WordsInFiles(){
        hashWords = new HashMap<String, ArrayList>();
    }
    
    //This method takes a file and process the every word in them:
    private void addWordsFromFile(File file){
    
         FileResource fr = new FileResource(file);
        String fileName = file.getName();
        for (String word : fr.words()) {
            if (!hashWords.containsKey(word)) {// if hash map doesnt contain the key word
                ArrayList<String> newList = new ArrayList<String>();//create a new Arraylist
                newList.add(fileName);//add the file name to it               
                hashWords.put(word, newList);// map the word to the new list
            } else if (hashWords.containsKey(word)
                    && !hashWords.get(word).contains(fileName)) {
                        //the hash map contains the keyword but not the filename
                        // it gets stored as a new value in the
                        //arraylist of the hashmap:
                        
                ArrayList<String> currentList = hashWords.get(word);//currentList is the existing array list of files
                                                                    //for the given word
                currentList.add(fileName);//Add new file name to existing list
                hashWords.put(word, currentList);//map the 'word' to the updated arraylist
            }
        }
    }
    
    public void buildWordFileMap(){
       //This method calls the method above, which was private, for every file selected.
       hashWords.clear();
       DirectoryResource dr = new DirectoryResource();
       for (File f : dr.selectedFiles()){ //for all the files selected make the hashWords hashmap
           addWordsFromFile(f);
        }
        
    }
    
    public int maxNumber(){
        //This method iterates every value of the hashmap as a number, giving you the max value. 
        //int maxSize = 0;
          int highest = 0;
           ArrayList<String> currentFileList = null;
        for (String word : hashWords.keySet()) {
           currentFileList= hashWords.get(word);
            int currentNum = currentFileList.size();
            if (currentNum > highest) {
                highest = currentNum;
            }
          //  System.out.println("currentFileList " + currentFileList +"highest num  = "+ highest );
        }
        
        return highest;
        /*for (ArrayList s : hashWords.values()){
            if (s.size() > maxSize) {
                maxSize = s.size();
            }
        }
        return maxSize;*/
    }
    
    public ArrayList wordsInNumFiles(int number){
        /*This method creates a new arrayList with the words repeated the same amount of times
         * that the number we give as a parameter.
         */
        System.out.println("\nThese words appear " + number + " times: ");
        ArrayList<String> words = new ArrayList<String>();
        int countWordsSizeN =0;
        for (String word : hashWords.keySet()){
            int counts = hashWords.get(word).size();
            if(counts == number){//if count of this word is equal to the given number
                words.add(word);//add this word into the words Arrylist
                countWordsSizeN++;//increment the count of words of size n
              System.out.println( "words are"+ word );  
            }
             // System.out.println("total of words repeated " + number + " times: " + countWordsSizeN + "words are"+ word );
        }
        System.out.println("total of words repeated " + number + " times: " + countWordsSizeN + "words are"+ words );
        return words;
    }
    
    public void printFilesIn(String word){
        /*This method takes the word given as a parameter, and prints every filename of every
         * file where it appears.
         */
        System.out.println("\nThe word " + word + " is in the following files: ");
        for (String s : hashWords.keySet()){
            if (s.equals(word)){
                ArrayList wordAndFiles = hashWords.get(s);
                for (int i=0; i< wordAndFiles.size(); i++){
                    System.out.println(wordAndFiles.get(i));
                }
            }
        }
    }
    
    public void tester(){
        buildWordFileMap();
        ArrayList wordsInNumFiles = wordsInNumFiles(5);
        for (int i=0; i < wordsInNumFiles.size(); i++){
         //  System.out.println(wordsInNumFiles.get(i));
        }
        System.out.println("\nMaximum number of words in all the files given = " +maxNumber());
        printFilesIn("red");
        System.out.println("\n");
        for (String s :hashWords.keySet() ){
         //  System.out.println(s + hashWords.get(s) );
        }
       
    }
}

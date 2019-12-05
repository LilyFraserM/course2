import java.io.File;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
/**
 * Write a description of CaesarCipher here.
 * 
 * @author Lily 
 * @version (a version number or a date)
 */
public class CaesarCipher {

    public String encrypt(String input, int key){
        
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key)+alphabet.substring(0,key);
       // System.out.println("shiftedAlphabet = :" +shiftedAlphabet);
        for(int i=0; i < encrypted.length() ; i++){
          char curChar = encrypted.charAt(i);
          if(Character.isLowerCase(curChar)){
            curChar = Character.toUpperCase(curChar) ; 
             int index = alphabet.indexOf(curChar);
         
          if(index == -1){
              encrypted.setCharAt(i,curChar);}
          else if(index != -1){
              System.out.flush();
             //  System.out.println("indexCurchar = :" +index);
            char newChar =  shiftedAlphabet.charAt(index);
            // System.out.println("newChar = :" +newChar);
            char lowerCaseNewChar = Character.toLowerCase(newChar);
            encrypted.setCharAt(i,lowerCaseNewChar);
            }  
            } 
            
            else{
          int index = alphabet.indexOf(curChar);
          
          if(index != -1){
            char newChar =  shiftedAlphabet.charAt(index);
            encrypted.setCharAt(i,newChar);
            }
        }  
        }return  encrypted.toString();
    }
    
    public void testCaesar(){
        /*int key =3;
        FileResource fr =new FileResource();
       String msg = fr.asString();*/
       String msg = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
            
        /*String encrypted = encrypt(msg, key);
        System.out.println("encrypted " +encrypted);
        
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println("decrypted " + decrypted);*/
        
    
       String encrypted = encrypt(msg, 15);
       System.out.println("encrypted " +encrypted);
        
    }
    
    public String encryptTwoKeys(String input, int key1 , int key2){
         StringBuilder encryptedTwoKeys = new StringBuilder(input);   
         
         for(int i=0;i<input.length();i++){
             char curChar = encryptedTwoKeys.charAt(i);
             String input1 = Character.toString(curChar);
             int key =0;
             if(i % 2 == 0){
                  key = key1;
           
                }else{
                    key = key2;
             // twoKeysChar =  encrypt(input1,key).charAt(0); 
            }   char twoKeysChar = encrypt(input1,key).charAt(0);  
               encryptedTwoKeys.setCharAt(i,twoKeysChar);
            }return encryptedTwoKeys.toString();
        } 
        
   // }
     
    public void testEncryptTwoKeys(){
       /* int key =3;
        FileResource fr =new FileResource();
       String msg = fr.asString();*/
       String msg = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
            
        /*String encrypted = encrypt(msg, key);
        System.out.println("encrypted " +encrypted);
        
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println("decrypted " + decrypted);*/
        
    
       String encryptedTwoKeys = encryptTwoKeys(msg, 8, 21);
       System.out.println("encrypted " +encryptedTwoKeys);
        
    }
    /*  public String decrypt(String encrypted){
     CaesarCipher cc = new CaesarCipher();
     int [] freqs = countLetters(encrypted);
     int maxIdx = maxIndex(freqs);
     
     int dkey = maxIdx -4; //since 'e' is the most used letter in the alphabet and idx of e is 4
     if(maxIdx < 4   ){
       dkey = 26-(4-maxIdx);  
        }return cc.encrypt( encrypted , 26-dkey);
    }
    
   public int maxIndex(int []vals){
     int maxIdx =0;
     for(int k=0; k<vals.length; k++){
         if(vals[k] > vals[maxIdx]){
            maxIdx = k;
            } 
        }return maxIdx;
       
    }
    
    public int[] countLetters(String encrypted){
     String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
     int []count =  new int[26];
     for(int i=0; i< encrypted.length(); i++){
         char ch = Character.toUpperCase(encrypted.charAt(i));
         int indx = alphabet.indexOf(ch);
         
         if(indx != -1){
             count[indx]++;
            }
        }return count;
    }  
   
    public void decrypter(){
     
    
       String encrypted = encrypt(msg, 15);
       System.out.println("encrypted " +encrypted);   
      
        System.out.println("decrypted is " +decrypt(encrypted));  
       
    } */
}

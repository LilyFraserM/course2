import java.io.File;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
/**
 * Write a description of CaesarDecrypter here.
 * 
 * @author lily 
 * @version (a version number or a date)
 */
public class CaesarDecrypter {

    public String decrypt(String encrypted){
     CaesarCipher cc = new CaesarCipher();
     int [] freqs = countLetters(encrypted);
     int maxIdx = maxIndex(freqs);
     int dkey = maxIdx -4; 
      if(maxIdx < 4   ){
       dkey = 26-(4-maxIdx);  
     
        } String message = cc.encrypt(encrypted, 26 - dkey);
        return message;
    }
    
   public int maxIndex(int []vals){
     int maxIdx =0;
     for(int k=0; k<vals.length; k++){
        // System.out.println("k=" + k);
         if(vals[k] > vals[maxIdx]){
            maxIdx = k;
             //  System.out.println("maxIdx=" + maxIdx);
            } 
        }return maxIdx;
       
    }
    
    public int[] countLetters(String encrypted){
     String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
     int []count =  new int[26];
     for(int i=0; i< encrypted.length(); i++){
         char ch = Character.toUpperCase(encrypted.charAt(i));
         int indx = alphabet.indexOf(ch);
         //System.out.println("indx = " + indx);
         if(indx != -1){
             count[indx]++;
            // System.out.println("count = " + count[indx]);
            }
        }return count;
    }
    
    public void testDecrypter(){
       String encrypted = "Hfs cpwewloj loks cd Hoto kyg Cyy.";
       
      
        System.out.println("decrypted is " +decrypt(encrypted));   

    }
    
    public String decrypt2Keys(String encrypted, int key1 ,int key2)
    {
       String input0 = halfString(encrypted,0);
       String input1 = halfString(encrypted,1);
       
       String decrypt0 = decrypt1key(input0, key1);//need to write mthd to decrypt if key is already given
       String decrypt1 = decrypt1key(input1, key2);
       
       String decrypted2Key = merge(decrypt0, decrypt1);
       
       return decrypted2Key;
       
        
    }
    //if keys are not known
    public String decryptTwoUnknownKeys(String encrypted) {
        String input0 = halfString(encrypted, 0);
        String input1 = halfString(encrypted, 1);
        
       System.out.printf("key1: %d\tkey2: %d\n", getKey(input0), getKey(input1));
        
        String decrypt0 = decrypt(input0);
        String decrypt1 = decrypt(input1);
        
        return merge(decrypt0, decrypt1);
    }
    public int getKey(String msg) {
        //count letters in msg
        int[] counts = countLetters(msg);
        //find intex of highest count
        int indOfMax = maxIndex(counts);
        //find&return shift
        final int IND_E = 4;
        int key = indOfMax - IND_E;
        if (key<0) return key+26;
        else return key;
        
    }
    public String decrypt1key(String encrypted, int key){
         CaesarCipher cc = new CaesarCipher();
        return cc.encrypt(encrypted, 26 - key);
    }
    
    public String halfString( String msg, int start){
        
       StringBuilder sb = new StringBuilder();
       
       for(int i=start;i<msg.length();i+=2){
           sb.append(msg.charAt(i));
        }
        return sb.toString();
    }
    //write mthd for merge
    
    public String merge(String msg1 , String msg2){
      StringBuilder sb = new StringBuilder(msg1+msg2);
      
      for(int i=0;i< msg1.length(); i++) {
       sb.setCharAt(2*i,msg1.charAt(i)); 
        }
        
         for(int i = 0;i< msg2.length(); i++) {
       sb.setCharAt(2*i+1,msg2.charAt(i)  ); 
        }
        return sb.toString();
    }
    
    //test the decription mthd
    public void testDecrypt(){
    int key1 = 14;
        int key2=24;
        //good code uncomment after test
       /* FileResource fr = new FileResource();
        String message = fr.asString();
        String decrypted = decrypt2Keys(message, key1, key2);
        System.out.println("decrypted :" + decrypted);*/ //good code uncomment after test
        
        String message = "Hfs cpwewloj loks cd Hoto kyg Cyy.";
        String decrypted = decrypt2Keys(message, key1, key2);
        
        System.out.println("Decrypted message: " +decrypted );  
       // String decrypted = encrypt(encrypted, 26-key1, 26-key2);
//System.out.println(decrypted);    
    }
        public void testDecrypt2keys(){
    
       FileResource fr = new FileResource();
       String message = fr.asString();
       // String message = "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
        String decrypted = decryptTwoUnknownKeys(message);
        System.out.println("decrypted :" + decrypted);
        
       // String decrypted = encrypt(encrypted, 26-key1, 26-key2);
//System.out.println(decrypted);    
    }
}

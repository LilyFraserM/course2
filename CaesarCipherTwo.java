import edu.duke.DirectoryResource;
import edu.duke.FileResource;
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (Lily) 
 * @version (a version number or a date)
 */
public class CaesarCipherTwo {
     private String alphabet;
     private String shiftedAlphabet1,shiftedAlphabet2;
     private int keyFor1, keyFor2,mainkey;
     public CaesarCipherTwo(int key1,int key2){
     alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
     shiftedAlphabet1 = alphabet.substring(key1)+alphabet.substring(0,key1);
     shiftedAlphabet2 = alphabet.substring(key2)+alphabet.substring(0,key2);
     keyFor1= key1 ;
     keyFor2= key2 ;
    }
    
     public int[] countLetters(String encrypted){
     int []count =  new int[26];
     for(int i=0; i< encrypted.length(); i++){
         char ch = Character.toUpperCase(encrypted.charAt(i));
         int indx = alphabet.indexOf(ch);
         if(indx != -1){
             count[indx]++;
            }
        }return count;
    }
    
    public int maxIndex(int []vals){
     int maxIdx =0;
     for(int k=0; k<vals.length; k++){
         if(vals[k] > vals[maxIdx]){
            maxIdx = k;
            } 
        }return maxIdx;
       
    }
    
     public String halfString( String msg, int start){
        
       StringBuilder sb = new StringBuilder();
       
       for(int i=start;i<msg.length();i+=2){
           sb.append(msg.charAt(i));
        }
        return sb.toString();
    }
    
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
    
      public String encrypt(String input){
        StringBuilder sb = new StringBuilder(input);
        String alphaLower = alphabet.toLowerCase();
        String shiftLower1 = shiftedAlphabet1.toLowerCase();
        String shiftLower2 = shiftedAlphabet2.toLowerCase();
        for (int i=0; i < sb.length(); i+=2) {
            char c = sb.charAt(i);
            int idx = alphabet.indexOf(c);
            int idxLower = alphaLower.indexOf(c);
            if(Character.isLowerCase(c)){
                if(idxLower != -1){
                    c = shiftLower1.charAt(idxLower);
                    sb.setCharAt(i, c);
                }
            }
            else{
                if (idx != -1){
                    c = shiftedAlphabet1.charAt(idx);
                    sb.setCharAt(i, c);
                }
            }
        }
        for (int i=1; i < sb.length(); i+=2){
            char c = sb.charAt(i);
            int idx = alphabet.indexOf(c);
            int idxLower = alphaLower.indexOf(c);
            if(Character.isLowerCase(c)){
                if(idxLower != -1){
                    c = shiftLower2.charAt(idxLower);
                    sb.setCharAt(i, c);
                }
            }
            else{
                if (idx != -1){
                    c = shiftedAlphabet2.charAt(idx);
                    sb.setCharAt(i, c);
                }
            }
        }
        return sb.toString();
    }
        
    public String decrypt(String input){
        
        int k1 = 26 -keyFor1;
        int k2 = 26 -keyFor2;
        System.out.println("Entered decrypt" );
        CaesarCipherTwo cc = new CaesarCipherTwo(k1, k2);
        System.out.println("key -26-keyFor1 ="+ k1 );
        System.out.println("key -26-keyFo21 ="+ k2);
        String decrypt = cc.encrypt(input);
        return decrypt;
    }
    
        public void testDecrypt(){
        String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        String encryptedMessage = encrypt(message);
        System.out.println("Encrypted message: " + encryptedMessage);
        String decryptedMessage = decrypt(encryptedMessage);
        System.out.println("Decrypted message: " +decryptedMessage );  
        }
     
}

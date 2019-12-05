
/**
 * Write a description of CaesarCipherWithConstr here.
 * 
 * @author (Lily) 
 * @version (a version number or a date)
 */
public class CaesarCipherWithConstr {

    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    public CaesarCipherWithConstr(int key){
     alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
     shiftedAlphabet = alphabet.substring(key)+alphabet.substring(0,key);
     mainKey = key;
    
}
    
    public String encrypt(String input){
CaesarCipherWithConstr cc = new CaesarCipherWithConstr(mainKey);
        StringBuilder encrypted = new StringBuilder(input);
        System.out.println("Key encrypt ="+ mainKey );
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
    private char decrypt(char ch, int key) {
        char chUC = Character.toUpperCase(ch);
        int cind = alphabet.indexOf(chUC);
        // do not decrypt non letters
        if (cind == -1) return ch;
        
        // index of decrypted character
        int dind = (cind - key) % 26;
        
        // java can return negative from modulo:
        if (dind <0) dind+=26;
        
        // decrypted uppercase character
        char dch = alphabet.charAt(dind);
        
        // check original case and return decrypted char
        if (Character.isUpperCase(ch)) return dch;
        else return Character.toLowerCase(dch);
    }
    
    public String decrypt(String input){
        
        int key = 26 - mainKey;
        CaesarCipherWithConstr cc1 = new CaesarCipherWithConstr(key);  
   
        String decrypt = cc1.encrypt(input);
        return decrypt;
   
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
     int []count =  new int[26];
     for(int i=0; i< encrypted.length(); i++){
         char ch = Character.toUpperCase(encrypted.charAt(i));
         int indx = alphabet.indexOf(ch);
                if(indx != -1){
             count[indx]++;
            }
        }return count;
    }
    
    public void SimpleTest(){
      String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        String encryptedMessage = encrypt(message);
        System.out.println("Encrypted message: " + encryptedMessage);
        String decryptedMessage = decrypt(encryptedMessage);
        System.out.println("Decrypted message: " +decryptedMessage );   
    }
}
   /* public String encrypt(String input){
        StringBuilder sb = new StringBuilder(input);
        String alphaLower = alphabet.toLowerCase();
        String shiftLower = shiftedAlphabet.toLowerCase();
        for (int i=0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            int idx = alphabet.indexOf(c);
            int idxLower = alphaLower.indexOf(c);
            if(Character.isLowerCase(c)){
                if(idxLower != -1){
                    c = shiftLower.charAt(idxLower);
                    sb.setCharAt(i, c); ,.          
                }
            }
            else{
                if (idx != -1){
                    c = shiftedAlphabet.charAt(idx);
                    sb.setCharAt(i, c);
                }
            }
        }
        return sb.toString();
    }
    
    public String decrypt(String input){
        CaesarCipherWithConstr cc = new CaesarCipherWithConstr(26 - mainKey);
        String decrypt = cc.encrypt(input,26-mainKey);
        return decrypt;
    }
    
    public void testEncrypt(){
        String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        String encryptedMessage = encrypt(message);
        System.out.println(encryptedMessage);
        
        System.out.println("Decrypted message: " + decrypt(encryptedMessage));
    }
}*/
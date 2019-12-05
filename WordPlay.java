
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {

    public boolean isVowel(char ch){
       char chUpper = Character.toUpperCase(ch);
      if(ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')
      {//System.out.print("This is a Vowel");
          return true;
        }else 
       // System.out.print("This is not a Vowel");
        return false;
    }
   
    public void testIsVowel(){
     char ch = 'I';
     isVowel(ch);
    }
    
    public String replaceVowels(String phrase , char ch){
        StringBuilder input = new StringBuilder(phrase);
       // input = input.toUpperCase();
        for(int i=0;i<phrase.length();i++){
         char currCh = input.charAt(i);
         currCh = Character.toUpperCase(currCh);
         if(isVowel(currCh)){
             input.setCharAt(i,ch);
            }
        } return input.toString();
        
    }
    
    public void testreplaceVowels(){
     char ch = '*';
     String phrase = "HELLO World";
     
      System.out.println("changed phrase is :  " +replaceVowels(phrase,ch));
    }
    
    public String emphasize(String phrase, char ch){
        
         StringBuilder newPhrase = new StringBuilder(phrase);
         for(int i=0 ; i< phrase.length(); i++)
            {
              char currCh = newPhrase.charAt(i);
             currCh =  Character.toUpperCase(currCh);
             ch = Character.toUpperCase(ch);
             if(currCh == ch){
              
              if(i % 2 == 0){
                  newPhrase.setCharAt(i,'*');
                }else 
                    newPhrase.setCharAt(i,'+');
            }
            } return newPhrase.toString();
         
    }
    
    public void testEmphasize(){
        char ch ='a';
        String phrase ="Mary Bella Abracadabra";
         System.out.println("changed phrase is :  " +emphasize(phrase,ch));
    }
}

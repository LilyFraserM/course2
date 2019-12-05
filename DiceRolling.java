import java.util.Random;
/**
 * Write a description of DiceRolling here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DiceRolling {

    public void diceRollSimulate(int rolls){
     Random rand =new Random();
     int[] count= new int[13];
      
     for(int i=0;i< rolls;i++){
         
         int die1Roll = rand.nextInt(6) +1;
         int die2Roll = rand.nextInt(6) +1;
         count[die1Roll + die2Roll] ++;
        }
        
        for(int i=2;i<=12;i++){
          System.out.println(i + "'s \t" + count[i] + "\t" + 100*count[i]/rolls + "%");  
        }
    }
}

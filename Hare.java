package Race;
import java.util.Random;
public class Hare extends Racer{
    public void move(){
        Random rand = new Random();
        int i = rand.nextInt(10)+1;
        if(i<=2){
            Sleep();
        }
        else if((i >= 3) && (i <= 5)){
            Small_Hop();
        }
        else if((i >= 6) && (i <= 7)){
            Big_Hop();
        }
        else if((i >= 8) && (i <= 9)){
            Small_Slip();
        }
        else
            Big_Slip();       
    }
    
    private void Sleep(){
        int y = get_Position();
        set_Position(y);
    }; //No move at all (20% chance)
    private void Small_Hop(){
        int y = get_Position();
        set_Position(y + 1);
    }; //1 square to the right(30% chance)
    private void Big_Hop(){
        int y = get_Position();
        set_Position(y + 9);
    }; //9 squares to the right(20% chance)
    private void Small_Slip(){
        int y = get_Position();
        set_Position(y - 2);
    }; // 2 squares to the left(20% chance)
    private void Big_Slip(){
        int y = get_Position();
        set_Position(y - 12);
    }; // 12 squares to the left(10% chance)
    
}

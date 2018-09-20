/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Race;
import java.util.Random;
public class Tortoise extends Racer {
    @Override
    public void move(){
        Random rand = new Random();
        int i = rand.nextInt(10)+1;
        if(i <= 5){
            Fast_Plod();
        }
        else if(i >= 8){
            Slow_Plod();
        }
        else
            Slip();
    }
    
    private void Fast_Plod(){
        int y = get_Position();
        set_Position(y+3);
    };// 3 steps right
    
     private void Slow_Plod(){
        int y = get_Position();
        set_Position(y+1);
    }; // 1 step right
     
    private void Slip(){
        int y = get_Position();
        set_Position(y-6);
    }; //6 steps left
   
       
}

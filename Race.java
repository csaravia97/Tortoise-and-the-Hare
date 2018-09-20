package Race;
import java.util.Scanner;
public class Race {
   private Hare hare = new Hare();
   private Tortoise tortoise = new Tortoise();
   private int race_Length = 75;  
   private boolean is_Winner;
   
   public Race(){
        this.race_Length = race_Length;
        this.is_Winner = false;
   } //constructor for Race object
   
   public int Get_Length(){
       return race_Length;
   }//return length of race

   public void Set_Length(int race_Length){
       if(race_Length <= 0)
           throw new IllegalArgumentException("Race Length must be greater than 0");
       this.race_Length = race_Length;
   }//sets length of race
   
   private boolean Winner(){
       if((tortoise.get_Position() >= Get_Length()-1) && (hare.get_Position() >= Get_Length()-1)){
            System.out.println("IT'S A TIE !");
            is_Winner = true; 
       }//Checks if there's a tie      
        else if(tortoise.get_Position() >= Get_Length()-1){
            System.out.println("TURTLE WINS !");
            is_Winner = true;
        }//Checks if turtle won
        else if(hare.get_Position() >=  Get_Length()-1){
            System.out.println("HARE WINS ! " );
            is_Winner = true;
        }//check if hare won
       return is_Winner;
   } //checks if there's a winner. If there is, change truth value of is_Winner
   
    private void Reset(){
        this.is_Winner = false;
        tortoise.set_Position(0);
        hare.set_Position(0);
   } //resets all variables of the Race 
    
    public void Print_Track(int length, char racer){
        int racer_pos = 0;
        if(racer == 'T'){
            racer_pos = tortoise.get_Position();}
        
        else{
            racer_pos = hare.get_Position();}
        
        for(int i = 0; i < length; i++){
            if(i == racer_pos){
                System.out.print(racer);} 
            else{
                System.out.print("-");}
        }
        System.out.println();
            
    }//outputs the track for the given racer(H/T)   

   
   public void Print_Race(){
        this.Reset();
        System.out.printf("BANG!!!!%nAND THEY'RE OFF!!!%n");
        while(!is_Winner){
            hare.move();
            tortoise.move();
        
            if(tortoise.get_Position() >= this.Get_Length() )
                tortoise.set_Position(this.Get_Length()-1); 
            if(hare.get_Position() >= this.Get_Length() )
                hare.set_Position(this.Get_Length()-1);
            //makes sure tortoise and hare positions don't go past max length 
        
            Print_Track(this.Get_Length(), 'T');     
            Print_Track(this.Get_Length(), 'H');

            if( tortoise.get_Position() == hare.get_Position()){
                System.out.println("OUCH! ");   
            } //check if they landed on the same position
            System.out.println();
            Winner(); //checks to see if someone won the race
      
            try {
            // thread to sleep for 750 milliseconds
                Thread.sleep(750);
            } 
            catch (Exception e) {
                System.out.println(e);
            }
        } // end of while loop
    }//Prints the Race until someone wins
   
   public void Match(){
       String rematch = "";
       Scanner scan = new Scanner(System.in);
       Scanner scan2 = new Scanner(System.in);
       int length = this.Get_Length();
       
       do{
           Print_Race();
           System.out.println("Would you like a rematch? (Y/N)");
           rematch = scan.nextLine();
           if(rematch.equalsIgnoreCase("Y")){
               System.out.print("Enter new length of the race: ");
               length = scan2.nextInt();
               this.Set_Length(length);
           }
       }
       while(rematch.equalsIgnoreCase("Y"));
   }//Performs a race of default value, then asks the user for a rematch
    //Will reset variables and run the race again depending on user input
   
}


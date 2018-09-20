
package Race;

public abstract class Racer {
    private int position;
    public abstract void move();
    
    public int get_Position(){
        return position;
    }
    
    protected void set_Position(int x){
        if( x <= 0)
            position = 0;
        else
            position = x;
    }
}

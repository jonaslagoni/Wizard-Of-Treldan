package TWoT;

/**
 *
 * @author Mathias
 */
public class Exit extends Interior{
    
    private Room newRoom;

    public Exit(Room newRoom){
        this.newRoom = newRoom;
    }

    public Room getNewRoom(){
	return newRoom;
    }
}

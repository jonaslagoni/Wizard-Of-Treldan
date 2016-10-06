package TWoT;

/**
 *
 * @author Mathias
 */
public class Exit {
    
    private Room newRoom;

    public Exit(Room newRoom){
        this.newRoom = newRoom;
    }

    public Room getNewRoom(){
	return newRoom;
    }
}

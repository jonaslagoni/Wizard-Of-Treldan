package TWoT_test;


/**
 *
 * @author Mathias
 */
public class Exit extends Interior{
    private Room newRoom;
    
    /**
     * 
     * @param newRoom 
     */
    public Exit(Room newRoom){
        this.newRoom = newRoom;
    }

    /**
     * 
     * @return 
     */
    public Room getNewRoom(){
	return newRoom;
    }
}

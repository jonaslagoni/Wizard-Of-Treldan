package TWoT;

/**
 *
 * @author Mathias
 */
public class Exit extends Interior {

    private Room newRoom;

    /**
     * @param newRoom Room to go
     */
    public Exit(Room newRoom) {
        this.newRoom = newRoom;
    }

    /**
     * @return Room to go
     */
    public Room getNewRoom() {
        return newRoom;
    }
}

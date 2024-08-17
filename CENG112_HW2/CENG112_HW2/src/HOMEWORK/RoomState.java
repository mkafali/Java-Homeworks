package HOMEWORK;

public class RoomState {
    private boolean occupied;
    private boolean reserved;

    public RoomState() {
        this.occupied = false;
        this.reserved = false;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
}

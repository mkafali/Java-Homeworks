package HOMEWORK;

public class Rooms {
    private static int roomAmount = 20;
    private int roomNumber;
    private String type;
    private boolean available;

    public Rooms(String type) {
        roomNumber = roomAmount;
        roomAmount-=1;
        this.type = type;
        this.available = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getType() {
        return type;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String toString(){
        return type + " " + Integer.toString(roomNumber);
    }
}
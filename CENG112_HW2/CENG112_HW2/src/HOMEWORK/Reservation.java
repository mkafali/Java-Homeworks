package HOMEWORK;

public class Reservation<T> {
    private T bookingId;
    private String customerName;
    private String roomType;

    public Reservation(T bookingId, String customerName, String roomType) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.roomType = roomType;
    }

    public T getBookingId() {
        return bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getRoomType() {
        return roomType;
    }

    public String toString(){
        return "ReservationId: " + String.valueOf(bookingId) + ", type: " + roomType + ", Name: " + customerName;
    }
}

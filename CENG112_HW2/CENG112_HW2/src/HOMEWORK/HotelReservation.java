package HOMEWORK;

import java.util.ArrayList;
import java.util.List;

public class HotelReservation {

    public static void main(String[] args) {
        WaitingLine<Reservation<String>> waitingLine = new FileIO().createWaitingLine();
        Reservation<String>[] reservations = new FileIO().createReservationObjects();
        WaitingLine<Reservation<String>> singleWaitingLine = new FileIO().createSingleWaitingLine(reservations);
        WaitingLine<Reservation<String>> doubleWaitingLine = new FileIO().createDoubleWaitingLine(reservations);
        WaitingLine<Reservation<String>> deluxeWaitingLine = new FileIO().createDeluxeWaitingLine(reservations);
        WaitingLine<Reservation<String>> suiteWaitingLine = new FileIO().createSuiteWaitingLine(reservations);

        PileRoom<Rooms> singleRoomStack = new PileRoom<>();
        PileRoom<Rooms> doubleRoomStack = new PileRoom<>();
        PileRoom<Rooms> suiteRoomStack = new PileRoom<>();
        PileRoom<Rooms> deluxeRoomStack = new PileRoom<>();


        // Initialize lists to track available and unavailable rooms
        List<Rooms> rooms = new ArrayList<>();
        List<Rooms> unavailableRooms = new ArrayList<>();
        List<Rooms> availableRooms = new ArrayList<>();



        // Create rooms and push stacks, add lists
        for (int i = 5; i > 0; i--) {
            Rooms room = new DeluxeRoom();
            deluxeRoomStack.push(room);
            rooms.add(room);
            availableRooms.add(room);
        }
        for (int i = 5; i > 0; i--) {
            Rooms room = new SuiteRoom();
            suiteRoomStack.push(room);
            rooms.add(room);
            availableRooms.add(room);
        }
        for (int i = 5; i > 0; i--) {
            Rooms room = new DoubleRoom();
            doubleRoomStack.push(room);
            rooms.add(room);
            availableRooms.add(room);
        }
        for (int i = 5; i > 0; i--) {
            Rooms room = new SingleRoom();
            singleRoomStack.push(room);
            rooms.add(room);
            availableRooms.add(room);
        }

        System.out.println("\n\n*** Before Start ***\n");
        printResult(singleWaitingLine, suiteWaitingLine, doubleWaitingLine, deluxeWaitingLine, singleRoomStack, suiteRoomStack, doubleRoomStack, deluxeRoomStack, availableRooms, unavailableRooms, availableRooms);
        System.out.println("\n*** First Process ***\n\n");
        process(singleWaitingLine,suiteWaitingLine,doubleWaitingLine,deluxeWaitingLine,singleRoomStack,suiteRoomStack,doubleRoomStack,deluxeRoomStack,availableRooms,unavailableRooms,rooms);
        printResult(singleWaitingLine,suiteWaitingLine,doubleWaitingLine,deluxeWaitingLine,singleRoomStack,suiteRoomStack,doubleRoomStack,deluxeRoomStack,availableRooms,unavailableRooms,rooms);
        // Make Odd Rooms Available
        for(int i = 1; i < rooms.size(); i += 2){
            Rooms room = rooms.get(i);
            room.setAvailable(true);
            String type = room.getType();
            if(unavailableRooms.contains(room)){
                unavailableRooms.remove(room);
                availableRooms.add(room);
            }
            if(type.equals("Single")){
                singleRoomStack.push(room);
            }
            else if(type.equals("Suite")){
                suiteRoomStack.push(room);
            }
            else if(type.equals("Double")) {
                doubleRoomStack.push(room);
            }
            else if(type.equals("Deluxe")){
                deluxeRoomStack.push(room);
            }

        }
        System.out.println("********* Make Odd Rooms Available *********\n");
        printResult(singleWaitingLine,suiteWaitingLine,doubleWaitingLine,deluxeWaitingLine,singleRoomStack,suiteRoomStack,doubleRoomStack,deluxeRoomStack,availableRooms,unavailableRooms,rooms);
        System.out.println("\n\n*** Second Process ***\n\n");
        process(singleWaitingLine,suiteWaitingLine,doubleWaitingLine,deluxeWaitingLine,singleRoomStack,suiteRoomStack,doubleRoomStack,deluxeRoomStack,availableRooms,unavailableRooms,rooms);
        printResult(singleWaitingLine,suiteWaitingLine,doubleWaitingLine,deluxeWaitingLine,singleRoomStack,suiteRoomStack,doubleRoomStack,deluxeRoomStack,availableRooms,unavailableRooms,rooms);
        //Make odd numbers available


    }
    //Assign operations
    public static void process(WaitingLine<Reservation<String>> singleWaitingLine,WaitingLine<Reservation<String>> suiteWaitingLine,WaitingLine<Reservation<String>> doubleWaitingLine,WaitingLine<Reservation<String>> deluxeWaitingLine,PileRoom<Rooms> singleRoomStack,PileRoom<Rooms> suiteRoomStack,PileRoom<Rooms> doubleRoomStack,PileRoom<Rooms> deluxeRoomStack,List<Rooms> availableRooms,List<Rooms> unavailableRooms,List<Rooms> rooms){
            for (int i = 0; i < 5; i++) {
        if (!singleWaitingLine.isEmpty() && !singleRoomStack.isEmpty()) {
            try {
                Reservation<String> reservation = singleWaitingLine.dequeue();
                Rooms single = singleRoomStack.pop();
                single.setAvailable(false);
                availableRooms.remove(single);
                unavailableRooms.add(single);
                System.out.println("Assigned Single" + " room number " + single.getRoomNumber() + " to reservation ID " + reservation.getBookingId());
            } catch (EmptyStackException e) {
                throw new RuntimeException(e);
            } catch (EmptyQueueException e) {
                throw new RuntimeException(e);
            }

        }
        if (!suiteWaitingLine.isEmpty() && !suiteRoomStack.isEmpty()) {
            try {
                Reservation<String> reservation = suiteWaitingLine.dequeue();
                Rooms suite = suiteRoomStack.pop();
                suite.setAvailable(false);
                availableRooms.remove(suite);
                unavailableRooms.add(suite);
                System.out.println("Assigned Suite" + " room number " + suite.getRoomNumber() + " to reservation ID " + reservation.getBookingId());
            } catch (EmptyStackException e) {
                throw new RuntimeException(e);
            } catch (EmptyQueueException e) {
                throw new RuntimeException(e);
            }
        }

        if (!doubleWaitingLine.isEmpty() && !doubleRoomStack.isEmpty()) {
            try {
                Reservation<String> reservation = doubleWaitingLine.dequeue();
                Rooms doubleRoom = doubleRoomStack.pop();
                doubleRoom.setAvailable(false);
                availableRooms.remove(doubleRoom);
                unavailableRooms.add(doubleRoom);
                System.out.println("Assigned Double" + " room number " + doubleRoom.getRoomNumber() + " to reservation ID " + reservation.getBookingId());
            } catch (EmptyStackException e) {
                throw new RuntimeException(e);
            } catch (EmptyQueueException e) {
                throw new RuntimeException(e);
            }
        }

        if (!deluxeWaitingLine.isEmpty() && !deluxeRoomStack.isEmpty()) {

            try {
                Reservation<String> reservation = deluxeWaitingLine.dequeue();
                Rooms deluxe = deluxeRoomStack.pop();
                deluxe.setAvailable(false);
                availableRooms.remove(deluxe);
                unavailableRooms.add(deluxe);
                System.out.println("Assigned Deluxe" + " room number " + deluxe.getRoomNumber() + " to reservation ID " + reservation.getBookingId());
            } catch (EmptyStackException e) {
                throw new RuntimeException(e);
            } catch (EmptyQueueException e) {
                throw new RuntimeException(e);
            }
        }

    }
    }

    //print waiting lines status
    public static void printResult(WaitingLine<Reservation<String>> singleWaitingLine,WaitingLine<Reservation<String>> suiteWaitingLine,WaitingLine<Reservation<String>> doubleWaitingLine,WaitingLine<Reservation<String>> deluxeWaitingLine,PileRoom<Rooms> singleRoomStack,PileRoom<Rooms> suiteRoomStack,PileRoom<Rooms> doubleRoomStack,PileRoom<Rooms> deluxeRoomStack,List<Rooms> availableRooms,List<Rooms> unavailableRooms,List<Rooms> rooms){
        unavailablePrint(unavailableRooms);

        for(Rooms room: rooms){
            if(!unavailableRooms.contains(room) && !availableRooms.contains(room)){
                availableRooms.add(room);
            }}
        availablePrint(availableRooms);
        System.out.println("\nSingle Room Waiting Line: ");
        System.out.println(singleWaitingLine);
        System.out.println("Double Room Waiting Line: ");
        System.out.println(doubleWaitingLine);
        System.out.println("Deluxe Room Waiting Line: ");
        System.out.println(deluxeWaitingLine);
        System.out.println("Suite Room Waiting Line: ");
        System.out.println(suiteWaitingLine);
    }
    //print available rooms
    public static void availablePrint(List<Rooms> availableRooms){
        System.out.println("\nAvailable Rooms: ");
        String printAvailable = "";
        for(Rooms room: availableRooms){

            String tempString = "";
            if(!room.equals(availableRooms.get(0))) {
                tempString = room.toString() + ", " + printAvailable;
            }
            else{
                tempString = room.toString() + printAvailable;
            }
            printAvailable = tempString;

        }
        System.out.println(printAvailable);
    }
    //print unavailable rooms
    public static void unavailablePrint(List<Rooms> unavailableRooms) {
        //sort unavailable rooms
        for (int i = 0; i < unavailableRooms.size() - 1; i++) {
            for (int j = i + 1; j < unavailableRooms.size(); j++) {
                Rooms room1 = unavailableRooms.get(i);
                Rooms room2 = unavailableRooms.get(j);
                int roomNumber1 = Integer.parseInt(room1.toString().split(" ")[1]);
                int roomNumber2 = Integer.parseInt(room2.toString().split(" ")[1]);
                if (roomNumber2 > roomNumber1) {
                    // Swap
                    unavailableRooms.set(i, room2);
                    unavailableRooms.set(j, room1);
                }
            }
        }

        System.out.println("\nUnavailable Rooms: ");
        String printUnavailable = "";
        for(Rooms room: unavailableRooms){

            String tempString = "";
            if(!room.equals(unavailableRooms.get(0))) {
                tempString = room.toString() + ", " + printUnavailable;
            }
            else{
                tempString = room.toString() + printUnavailable;
            }
            printUnavailable = tempString;

        }
        System.out.println(printUnavailable);
    }
}

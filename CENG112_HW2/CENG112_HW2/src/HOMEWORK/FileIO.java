package HOMEWORK;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
public class FileIO {

    public WaitingLine<Reservation<String>> createWaitingLine() {
        WaitingLine<Reservation<String>> waitingLine = new WaitingLine<>();
        Reservation<String>[] reservationArray = createReservationObjects();
        for (Reservation<String> reservation : reservationArray) {
            if (reservation != null) {
                waitingLine.enqueue(reservation);
            }
        }
        return waitingLine;
    }

    public WaitingLine<Reservation<String>> createSuiteWaitingLine(Reservation<String>[] reservations){
        WaitingLine<Reservation<String>> waitingLine = new WaitingLine<>();
        for(Reservation<String> reservation: reservations){
            if(reservation != null && reservation.getRoomType().equals("Suite")){
                waitingLine.enqueue(reservation);
            }
        }
        return waitingLine;
    }

    public WaitingLine<Reservation<String>> createSingleWaitingLine(Reservation<String>[] reservations){
        WaitingLine<Reservation<String>> waitingLine = new WaitingLine<>();
        for(Reservation<String> reservation: reservations){
            if(reservation != null && reservation.getRoomType().equals("Single")){
                waitingLine.enqueue(reservation);
            }
        }
        return waitingLine;
    }

    public WaitingLine<Reservation<String>> createDoubleWaitingLine(Reservation<String>[] reservations){
        WaitingLine<Reservation<String>> waitingLine = new WaitingLine<>();
        for(Reservation<String> reservation: reservations){
            if(reservation != null && reservation.getRoomType().equals("Double")){
                waitingLine.enqueue(reservation);
            }
        }
        return waitingLine;
    }

    public WaitingLine<Reservation<String>> createDeluxeWaitingLine(Reservation<String>[] reservations){
        WaitingLine<Reservation<String>> waitingLine = new WaitingLine<>();
        for(Reservation<String> reservation: reservations){
            if(reservation != null && reservation.getRoomType().equals("Deluxe")){
                waitingLine.enqueue(reservation);
            }
        }
        return waitingLine;
    }


    public Reservation<String>[] createReservationObjects() {
        @SuppressWarnings("unchecked")
        Reservation<String>[] reservationArray = new Reservation[100];
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new FileInputStream("src/HOMEWORK/reservations.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File path was not found.");
            System.exit(0);
        }
        int numberOfEntries = 0;
        while (inputStream.hasNextLine()) {
            String line = inputStream.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(line, ",");
            Reservation<String> reservation = new Reservation<>(tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken().trim());
            reservationArray[numberOfEntries] = reservation;
            numberOfEntries++;
        }
        return reservationArray;
    }
}
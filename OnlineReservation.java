package OasisInfobyte;

import java.util.ArrayList;
import java.util.Scanner;

class Seat {
    private int number;
    private boolean isReserved;

    public Seat(int number) {
        this.number = number;
        this.isReserved = false;
    }

    public int getNumber() {
        return number;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void reserve() {
        isReserved = true;
    }

    public void cancelReservation() {
        isReserved = false;
    }
}

public class OnlineReservation {
    private static ArrayList<Seat> seats = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeSeats();
        while (true) {
            System.out.println("\n Online Reservation System");
            System.out.println("1. View Seat Map");
            System.out.println("2. Reserve Seat");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");
            System.out.print("Please select an option: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    viewSeatMap();
                    break;
                case 2:
                    reserveSeat();
                    break;
                case 3:
                    cancelReservation();
                    break;
                case 4:
                    System.out.println("Exiting... Thanks for Choosing us");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void initializeSeats() {
        for (int i = 1; i <= 100; i++) {
            seats.add(new Seat(i));
        }
    }

    private static void viewSeatMap() {
        System.out.println("\n Current Seat Map");
        for (Seat seat : seats) {
            if (seat.isReserved()) {
                System.out.print("X ");
            } else {
                System.out.print(seat.getNumber() + " ");
            }
            if (seat.getNumber() % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    private static void reserveSeat() {
        System.out.print("Enter seat number to reserve: ");
        int seatNumber = scanner.nextInt();
        for (Seat seat : seats) {
            if (seat.getNumber() == seatNumber) {
                if (!seat.isReserved()) {
                    seat.reserve();
                    System.out.println("Seat " + seatNumber + " reserved successfully.");
                } else {
                    System.out.println("Seat " + seatNumber + " is already reserved.");
                }
                return;
            }
        }
        System.out.println("Invalid seat number.");
    }

    private static void cancelReservation() {
        System.out.print("Enter seat number to cancel: ");
        int seatNumber = scanner.nextInt();
        for (Seat seat : seats) {
            if (seat.getNumber() == seatNumber) {
                if (seat.isReserved()) {
                    seat.cancelReservation();
                    System.out.println("Reservation for seat " + seatNumber + " cancelled successfully.");
                } else {
                    System.out.println("Seat " + seatNumber + " is not reserved.");
                }
                return;
            }
        }
        System.out.println("Invalid seat number.");
    }
}

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    /***
     * main method for manipulation
     * @param args - default param(not used)
     */
    public static void main(String[] args) {
        /***
         * PROCEDURE
         * 1. created hotel services object
         * 2. iterating while loop for choice
         */
        System.out.println("Welcome to Hotel Reservation System");
        /***
         * 1. created hotel services object
         */
        HotelServices hotelServices = new HotelServices();
        /***
         * 2. iterating while loop for choice
         */
        while (true) {
            System.out.println("1. Add hotel \n2. Find cheapest hotel by rates \n3. Find cheapest hotel by ratings" +
                    "\n4. Exit");
            System.out.print("Enter choice : ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1 :
                    hotelServices.addHotel();
                    break;
                case 2 :
                    hotelServices.findCheapestHotel(hotelServices.getBookingDates());
                    break;
                case 3 :
                    hotelServices.findCheapestHotelByRatings();
                    break;
                case 4 :
                    System.exit(0);
                    break;
                default :
                    System.out.println("Invalid input");
            }
        }
    }
}

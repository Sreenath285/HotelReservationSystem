import java.time.LocalDate;

public class Main {

    /***
     * main method for manipulation
     * @param args - default param(not used)
     */
    public static void main(String[] args) {
        /***
         * PROCEDURE
         * 1. created hotel services object
         * 2. calling add hotel method
         * 3. calling findCheapestHotel method
         */
        System.out.println("Welcome to Hotel Reservation System");
        /***
         * 1. created hotel services object
         */
        HotelServices hotelServices = new HotelServices();
        /***
         * 2. calling add hotel method
         */
        hotelServices.addHotel();
        /***
         * 3. calling findCheapestHotel method
         */
        hotelServices.findCheapestHotel();
    }
}

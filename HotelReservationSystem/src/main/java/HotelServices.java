import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class HotelServices {

    List<Hotel> hotelList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    /***
     * created addHotel method to add hotels to the list
     * @return
     */
    public void addHotel () {
        System.out.print("Enter number of hotels to add : ");
        int noOfHotels = sc.nextInt();

        for (int i = 0; i < noOfHotels; i++) {
            Hotel hotel = new Hotel();

            System.out.print("Enter hotel name : ");
            String hotelName = sc.next();
            hotel.setHotelName(hotelName);
            System.out.print("Enter week day regular rate : ");
            int weekDayRegularRate = sc.nextInt();
            hotel.setWeekDayRegularRate(weekDayRegularRate);

            hotelList.add(hotel);
        }
        hotelList.stream().forEach(hotelDetails -> System.out.println(hotelDetails));
    }
}

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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

    /***
     * created findCheapestHotel method to add hotels to the list
     * @return - returning total cost
     */
    public String findCheapestHotel() {
        System.out.print("Enter check in date : ");
        String startDate = sc.next();
        LocalDate checkInDate = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.print("Enter check out date : ");
        String endDate = sc.next();
        LocalDate checkOutDate = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        int noOfDays = (int) (ChronoUnit.DAYS.between(checkInDate, checkOutDate) + 1);
        List<Hotel> cheapestHotel = hotelList.stream()
                .sorted(Comparator.comparingInt(Hotel::getWeekDayRegularRate)).toList();
        System.out.println("Cheapest hotel : " + cheapestHotel.get(0).getHotelName());
        String totalCost = String.valueOf(cheapestHotel.get(0).getWeekDayRegularRate() * noOfDays);
        System.out.println("Total cost : " + totalCost);
        return totalCost;
    }
}

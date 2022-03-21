import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HotelServices {

    Scanner sc = new Scanner(System.in);
    List<Hotel> hotelList = new ArrayList<>();
    LocalDate[] bookingDates;
    List<Hotel> hotelBookedList = new ArrayList<>();

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
            System.out.print("Enter weekend regular rate : ");
            int weekendRegularRate = sc.nextInt();
            hotel.setWeekendRegularRate(weekendRegularRate);
            System.out.print("Enter rating : ");
            int rating = sc.nextInt();
            hotel.setRating(rating);

            hotelList.add(hotel);
        }
//        hotelList.stream().forEach(hotelDetails -> System.out.println(hotelDetails));
    }

    /***
     * created findCheapestHotel method to find the cheapest hotel
     * @param dates - when we want to book the hotel
     */
    public void findCheapestHotel(LocalDate[] dates) {
        if (hotelList.isEmpty()) {
            System.out.println("Add hotels");
            addHotel();
        }
        else {
            List<Hotel> cheapestHotel;
            for (LocalDate date : dates) {
                if (isWeekend(date)) {
                    cheapestHotel = hotelList.stream()
                            .sorted(Comparator.comparingInt(Hotel::getWeekendRegularRate)).toList();
                    hotelBookedList.add(cheapestHotel.get(cheapestHotel.size() - 1));
                }
                else {
                    cheapestHotel = hotelList.stream()
                            .sorted(Comparator.comparingDouble(Hotel::getWeekDayRegularRate)).toList();
                    hotelBookedList.add(cheapestHotel.get(0));
                }
            }
        }
    }

    /***
     * created isWeekend method if given date is weekend or not
     * @param date - passing date
     * @return - returns true if given date is weekend
     */
    private boolean isWeekend(LocalDate date) {
        DayOfWeek day = DayOfWeek.of(date.get(ChronoField.DAY_OF_WEEK));
        return day == DayOfWeek.SATURDAY || day ==DayOfWeek.SUNDAY;
    }

    /***
     * created getBookingDates method to read date form user
     * @return - returning array of dates that are booked
     */
    public LocalDate[] getBookingDates(){
        System.out.print("Enter number of days : ");
        int num = sc.nextInt();
        bookingDates = new LocalDate[num];
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        for(int i = 0; i < num; i++) {
            System.out.print("Enter date in (dd-MM-yyyy) format: ");
                bookingDates[i] = LocalDate.parse(sc.next(), dateFormat);
        }

        return bookingDates;
    }

    /***
     * created printBookedHotels method to print hotel name, cost and total cost
     */
    public void printBookedHotels(){
        int totalCostByRates = 0;
        if (hotelList.isEmpty()) {
            System.out.println("Empty hotel list");
        }
        else {
            for (int i = 0; i < hotelBookedList.size(); i++) {
                if (isWeekend(bookingDates[i])) {
                    System.out.println("Date : " + bookingDates[i]
                            + " - Hotel name : " + hotelBookedList.get(i).getHotelName()
                            + " - Weekend rate : " + hotelBookedList.get(i).getWeekendRegularRate());
                    totalCostByRates += hotelBookedList.get(i).getWeekendRegularRate();
                } else {
                    System.out.println("Date : " + bookingDates[i]
                            + " - Hotel name : " + hotelBookedList.get(i).getHotelName()
                            + " - Weekday rate : " + hotelBookedList.get(i).getWeekDayRegularRate());
                    totalCostByRates += hotelBookedList.get(i).getWeekDayRegularRate();
                }
            }
            System.out.println("Total cost : " + totalCostByRates);
        }
    }

    /***
     * created findCheapestHotelByRatings to find the cheapest hotel
     * by ratings, printing hotel name and rate
     */
    public void findCheapestHotelByRatings() {
        List<Hotel> sortedHotelList;
        String cheapestBestRatedHotel = "";
        double totalCharge = 0.0;
        if (!hotelList.isEmpty()){
            LocalDate[] bookingDates = getBookingDates();
            sortedHotelList = hotelList.stream()
                    .sorted(Comparator.comparingInt(Hotel::getRating)).toList();
            cheapestBestRatedHotel = sortedHotelList.get(sortedHotelList.size() - 1).getHotelName();
            for (LocalDate bookingDate : bookingDates) {
                if (isWeekend(bookingDate)) {
                    totalCharge += sortedHotelList.get(0).getWeekendRegularRate();
                } else {
                    totalCharge += sortedHotelList.get(0).getWeekDayRegularRate();
                }
            }
            System.out.println("Cheapest best rated hotel : " + cheapestBestRatedHotel +
                    " - Total cost : " + totalCharge);
        } else {
            System.out.println("Add hotels");
        }
    }

    /***
     * created findBestRatedHotel to find the best hotel
     * by ratings, printing hotel name and rate
     */
    public void findBestRatedHotel() {
        List<Hotel> sortedHotelList;
        String bestRatedHotel = "";
        double totalCharge = 0.0;
        if (!hotelList.isEmpty()){
            LocalDate[] bookingDates = getBookingDates();
            sortedHotelList = hotelList.stream()
                    .sorted(Comparator.comparingInt(Hotel::getRating)).toList();
            bestRatedHotel = sortedHotelList.get(sortedHotelList.size() - 1).getHotelName();
            for (LocalDate bookingDate : bookingDates) {
                if (isWeekend(bookingDate)) {
                    totalCharge += sortedHotelList.get(sortedHotelList.size() - 1).getWeekendRegularRate();
                } else {
                    totalCharge += sortedHotelList.get(sortedHotelList.size() - 1).getWeekDayRegularRate();
                }
            }
            System.out.println("Best rated hotel : " + bestRatedHotel +
                    " - Total cost : " + totalCharge);
        } else {
            System.out.println("Add hotels");
        }
    }
}



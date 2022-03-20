public class Hotel {

    private String hotelName;
    private int weekDayRegularRate, weekendRegularRate;
    private int rating;
    private int totalCost;

    public Hotel() {
    }

    public Hotel(String hotelName, int weekDayRegularRate, int weekendRegularRate,
                  int rating) {
        this.hotelName = hotelName;
        this.weekDayRegularRate = weekDayRegularRate;
        this.weekendRegularRate = weekendRegularRate;
        this.rating = rating;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getWeekDayRegularRate() {
        return weekDayRegularRate;
    }

    public void setWeekDayRegularRate(int weekDayRegularRate) {
        this.weekDayRegularRate = weekDayRegularRate;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public int getWeekendRegularRate() {
        return weekendRegularRate;
    }

    public void setWeekendRegularRate(int weekendRegularRate) {
        this.weekendRegularRate = weekendRegularRate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", weekDayRegularRate=" + weekDayRegularRate +
                ", weekendRegularRate=" + weekendRegularRate +
                ", rating=" + rating +
                ", totalCost=" + totalCost +
                '}';
    }
}

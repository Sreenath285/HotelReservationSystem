public class Hotel {

    private String hotelName;
    private int weekdayRegularRate, weekendRegularRate, weekdayRewardRates, weekendRewardRates;
    private int rating;
    private int totalCost;

    public Hotel() {
    }

    public Hotel(String hotelName, int weekdayRegularRate, int weekendRegularRate,
                 int weekdayRewardRates, int weekendRewardRates, int rating) {
        this.hotelName = hotelName;
        this.weekdayRegularRate = weekdayRegularRate;
        this.weekendRegularRate = weekendRegularRate;
        this.weekdayRewardRates = weekdayRewardRates;
        this.weekendRewardRates = weekendRewardRates;
        this.rating = rating;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getWeekdayRegularRate() {
        return weekdayRegularRate;
    }

    public void setWeekdayRegularRate(int weekdayRegularRate) {
        this.weekdayRegularRate = weekdayRegularRate;
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

    public int getWeekdayRewardRates() {
        return weekdayRewardRates;
    }

    public void setWeekdayRewardRates(int weekdayRewardRates) {
        this.weekdayRewardRates = weekdayRewardRates;
    }

    public int getWeekendRewardRates() {
        return weekendRewardRates;
    }

    public void setWeekendRewardRates(int weekendRewardRates) {
        this.weekendRewardRates = weekendRewardRates;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", weekdayRegularRate=" + weekdayRegularRate +
                ", weekendRegularRate=" + weekendRegularRate +
                ", weekdayRewardRates=" + weekdayRewardRates +
                ", weekendRewardRates=" + weekendRewardRates +
                ", rating=" + rating +
                ", totalCost=" + totalCost +
                '}';
    }
}

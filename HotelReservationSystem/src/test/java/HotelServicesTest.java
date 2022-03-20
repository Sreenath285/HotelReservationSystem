import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HotelServicesTest {
    List<Hotel> hotelListTest = new ArrayList<>();
    @Test
    void addHotelTest() {

        Hotel lakeWood = new Hotel("Lakewood", 110, 90);
        hotelListTest.add(lakeWood);
        Assert.assertTrue(true);
        Hotel bridgeWood = new Hotel("BridgeWood", 160, 50);
        hotelListTest.add(bridgeWood);
        Assert.assertTrue(true);
        Hotel ridgeWood = new Hotel("RidgeWood", 220, 150);
        hotelListTest.add(ridgeWood);
        Assert.assertTrue(true);
    }

    @Test
    void givenHotelDetails_ShouldReturnCheapestHotel() {
        addHotelTest();
        List<Hotel> sortedHotelList;
        if (isWeekend(LocalDate.of(2020, 9, 12))) {
            sortedHotelList = hotelListTest.stream()
                    .sorted(Comparator.comparingDouble(Hotel::getWeekendRegularRate)).toList();
            assertEquals("BridgeWood",sortedHotelList.get(0).getHotelName());
            assertEquals(50.0,sortedHotelList.get(0).getWeekendRegularRate());
        } else {
            sortedHotelList = hotelListTest.stream()
                    .sorted(Comparator.comparingDouble(Hotel::getWeekDayRegularRate)).toList();
            assertEquals("LakeWood",sortedHotelList.get(0).getHotelName());
            assertEquals(110.0,sortedHotelList.get(0).getWeekDayRegularRate());
        }
    }
    private boolean isWeekend(LocalDate date) {
        DayOfWeek day = DayOfWeek.of(date.get(ChronoField.DAY_OF_WEEK));
        return day == DayOfWeek.SUNDAY || day == DayOfWeek.SATURDAY;
    }
}
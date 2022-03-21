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

        Hotel lakeWood = new Hotel("LakeWood", 110, 90,
                                        3, 80,80);
        hotelListTest.add(lakeWood);
        Assert.assertTrue(true);
        Hotel bridgeWood = new Hotel("BridgeWood", 160, 50,
                                        4, 110,50);
        hotelListTest.add(bridgeWood);
        Assert.assertTrue(true);
        Hotel ridgeWood = new Hotel("RidgeWood", 220, 150,
                                        5, 100, 40);
        hotelListTest.add(ridgeWood);
        Assert.assertTrue(true);
    }

    @Test
    void givenHotelDetails_ShouldReturnCheapestHotel() {
        addHotelTest();
        List<Hotel> sortedHotelList;
        if (isWeekend(LocalDate.of(2020, 9, 12))) {
            sortedHotelList = hotelListTest.stream()
                    .sorted(Comparator.comparingInt(Hotel::getWeekendRegularRate)).toList();
            assertEquals("BridgeWood",sortedHotelList.get(0).getHotelName());
            assertEquals(50.0,sortedHotelList.get(0).getWeekendRegularRate());
        } else {
            sortedHotelList = hotelListTest.stream()
                    .sorted(Comparator.comparingInt(Hotel::getWeekdayRegularRate)).toList();
            assertEquals("LakeWood",sortedHotelList.get(0).getHotelName());
            assertEquals(110.0,sortedHotelList.get(0).getWeekdayRegularRate());
        }
    }
    private boolean isWeekend(LocalDate date) {
        DayOfWeek day = DayOfWeek.of(date.get(ChronoField.DAY_OF_WEEK));
        return day == DayOfWeek.SUNDAY || day == DayOfWeek.SATURDAY;
    }

}
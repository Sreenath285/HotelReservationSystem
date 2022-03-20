import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HotelServicesTest {

    @Test
    void addHotelTest() {
        List<Hotel> hotelListTest = new ArrayList<>();
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
        HotelServices hotelServices = new HotelServices();
        addHotelTest();
        String cheapestHotel = hotelServices.findCheapestHotel();
        Assert.assertEquals(220, cheapestHotel);
    }
}
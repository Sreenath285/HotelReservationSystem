public class CustomHotelReservationException extends Exception{

    enum ExceptionType {
        ENTERED_DATE, ENTERED_CUSTOMER
    }

    ExceptionType type;

    public CustomHotelReservationException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}

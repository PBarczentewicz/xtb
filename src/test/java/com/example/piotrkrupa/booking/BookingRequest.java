package com.example.piotrkrupa.booking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Builder
@Setter
@Getter
public class BookingRequest {

    BookingDates bookingdates;
    boolean depositpaid;
    String email;
    String firstname;
    String lastname;
    String phone;
    String roomid;

}

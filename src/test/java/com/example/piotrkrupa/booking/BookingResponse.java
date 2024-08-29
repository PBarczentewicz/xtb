package com.example.piotrkrupa.booking;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BookingResponse {

    String bookingid;
    Booking booking;

}

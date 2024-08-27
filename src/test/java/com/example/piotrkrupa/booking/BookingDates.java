package com.example.piotrkrupa.booking;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Builder
@Getter
@Setter
public class BookingDates {

    String checkin;
    String checkout;
}

package com.example.piotrkrupa.booking;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Rooms {
    String roomid;
    String roomName;
    String type;
    boolean accessible;
    String image;
    String description;
    Features features;
    String roomPrice;

}

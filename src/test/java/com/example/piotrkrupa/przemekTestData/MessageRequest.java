package com.example.piotrkrupa.przemekTestData;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MessageRequest {

    String name;
    String email;
    String phone;
    String subject;
    String description;
}

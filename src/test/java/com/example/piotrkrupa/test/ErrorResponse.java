package com.example.piotrkrupa.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {
    String errorCode;
    String error;
    String errorMessage;
    ArrayList <String> fieldErrors;





}

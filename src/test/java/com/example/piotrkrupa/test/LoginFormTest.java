package com.example.piotrkrupa.test;

import com.example.piotrkrupa.base.BaseTest;
import com.example.piotrkrupa.testdata.LoginTestData;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LoginFormTest extends BaseTest {

    private static Stream<Arguments> parametersRequiredField() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of(LoginTestData.correctUser, ""),
                Arguments.of("", LoginTestData.correctPassword)
        );
    }

    @ParameterizedTest
    @MethodSource("parametersRequiredField")
    public void requiredField(String userLogin, String userPassword) {
        navigateToLoginPage();
        loginPage.fillLoginPassword(userLogin, userPassword).submitLogin();

        if (userLogin == "")
            assertEquals("Uzupełnienie pola jest wymagane.", loginPage.getAlertRequiredText("clientLogin_error"));
        else assertFalse(loginPage.isElementExist("clientLogin_error"));

        if (userPassword == "")
            assertEquals("Uzupełnienie pola jest wymagane.", loginPage.getAlertRequiredText("clientPass_error"));
        else assertFalse(loginPage.isElementExist("clientPass_error"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"@", "#", "+", "$"})
    public void userLoginSpecialCharacters(String userLogin) {
        navigateToLoginPage();
        loginPage.fillLoginPassword(userLogin, "userPassword").submitLogin();

        assertEquals("Podaj prawidłowy login", loginPage.getAlertRequiredText("clientLogin_error"));
    }
}
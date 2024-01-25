package com.example.piotrkrupa.test;

import com.example.piotrkrupa.MailService;
import com.example.piotrkrupa.base.BaseTest;
import com.example.piotrkrupa.testdata.LoginTestData;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginUserTest extends BaseTest {

    private static Stream<Arguments> parametersIncorrectLogin() {
        return Stream.of(
                Arguments.of(LoginTestData.incorrectUser, LoginTestData.incorrectPassword),
                Arguments.of(LoginTestData.correctUser, LoginTestData.incorrectPassword),
                Arguments.of(LoginTestData.correctUser, LoginTestData.oldPassword),
                Arguments.of(LoginTestData.incorrectUser, LoginTestData.correctPassword),
                Arguments.of(LoginTestData.correctUser.toUpperCase(), LoginTestData.correctPassword)
        );
    }

    @ParameterizedTest
    @DisplayName("Niepoprawne logowanie uzytkownika")
    @MethodSource("parametersIncorrectLogin")
    public void incorrectLogin(String userLogin, String userPassword) {

        navigateToLoginPage();
        loginPage.fillLoginPassword(userLogin, userPassword).submitLogin();
        assertEquals("Nieprawidłowy login lub hasło.", loginPage.getLoginAlert().getText());
    }

    @Test
    @DisplayName("Poprawne logowanie uzytkownika")
    public void correctLogin() throws InterruptedException {
        MailService mailService = new MailService();
        mailService.clearMail();

        navigateToLoginPage();
        loginPage.fillLoginPassword(LoginTestData.correctUser, LoginTestData.correctPassword).submitLogin();

        if (loginPage.isElementExist(loginPage.captchaErrorXpath)) {
            loginPage.resolveCaptcha()
                     .fillLoginPassword(LoginTestData.correctUser, LoginTestData.correctPassword);
            Thread.sleep(500);
            loginPage.submitLogin();
        }

        JSONObject verificationMail = mailService.getMail();

        assertEquals("Twój kod jednorazowy do logowania do Panelu Klienta nazwa.pl", verificationMail.get("subject").toString());
        assertEquals("[{\"address\":\"automat@nazwa.pl\",\"name\":\"nazwa.pl\"}]", verificationMail.get("from").toString());
        assertEquals("[{\"address\":\"tester890@restmail.net\",\"name\":\"Tester Testerski\"}]", verificationMail.get("to").toString());

        navigateToAuthorisationPage();
        authorisationPage.fillAuthCode(authorisationPage.getVerificationCode(verificationMail)).submitAuthCode();

        navigateToHomePage();
        assertEquals(LoginTestData.correctUser, homePage.getLoggedUser());
    }
}
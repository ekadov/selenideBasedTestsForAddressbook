package ru.addressbook.steps;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.addressbook.pages.LoginPage;
import ru.addressbook.pages.MainPage;
import ru.addressbook.utils.ConfProperties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginStep {

    private static LoginPage loginPage = new LoginPage();

    public static MainPage loginWithValidCredentials() {
        loginPage
                .clearUsernameField()
                .clearPasswordField()
                .enterUsername(ConfProperties.getValidUsername())
                .enterPassword(ConfProperties.getValidPassword())
                .clickLoginButton();
        return new MainPage();
    }

    public static LoginPage loginWithInvalidCredentials() {
        loginPage
                .clearUsernameField()
                .clearPasswordField()
                .enterUsername(ConfProperties.getInvalidUsername())
                .enterPassword(ConfProperties.getInvalidPassword())
                .clickLoginButton();
        return new LoginPage();
    }

}

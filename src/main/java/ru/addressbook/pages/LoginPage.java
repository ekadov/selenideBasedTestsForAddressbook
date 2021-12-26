package ru.addressbook.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private SelenideElement loginField = $x("//input[@name='user']");
    private SelenideElement passwordField = $x("//input[@name='pass']");
    @Getter
    private SelenideElement loginButton = $x("//input[@type='submit']");

    public LoginPage clearUsernameField() {
        loginField.clear();
        return this;
    }

    public LoginPage enterUsername(String login) {
        loginField.sendKeys(login);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clearPasswordField() {
        passwordField.clear();
        return this;
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }


}

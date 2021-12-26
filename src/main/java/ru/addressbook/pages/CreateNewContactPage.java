package ru.addressbook.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

public class CreateNewContactPage {

    @Getter
    private SelenideElement firstNameField = $x("//input[@name='firstname']");
    private SelenideElement lastNameField = $x("//input[@name='lastname']");
    private SelenideElement nickNameField = $x("//input[@name='nickname']");
    private SelenideElement saveButton = $x("//input[@value='Enter']");
    @Getter
    private SelenideElement updateButton = $x("//input[@value='Update']");

    public CreateNewContactPage enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
        return this;
    }

    public CreateNewContactPage clearLastNameField() {
        lastNameField.clear();
        return this;
    }

    public CreateNewContactPage enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
        return this;
    }

    public CreateNewContactPage enterNickName(String nickName) {
        nickNameField.sendKeys(nickName);
        return this;
    }

    public MainPage clickSaveButton() {
        saveButton.click();
        return new MainPage();
    }

    public MainPage clickUpdateButton() {
        updateButton.click();
        return new MainPage();
    }

}

package ru.addressbook.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.addressbook.custom_elements.WebTable;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private SelenideElement homePageButton = $(By.linkText("home"));
    private SelenideElement logoutButton = $x("//a[@onclick='document.logout.submit();']");
    private SelenideElement currentUsername = $x("//*[@id='top']//b");
    private SelenideElement addNewContactButton = $x("//a[text()='add new']");
    private SelenideElement tableWithContacts = $x("//table");
    private SelenideElement firstRowEditButton = $x("//table[@id='maintable']/tbody/tr[2]/td[8]//img");
    private SelenideElement deleteButton = $x("//input[@value='Delete']");
    private SelenideElement numberOfElementsInTable = $x("//span[@id='search_count']");

    public boolean checkIfLastNameExistsInTable(String lastName) {
        WebTable table = new WebTable();
        table.setTableWithContacts(tableWithContacts);
        return table.checkIfLastNameExistsInTable(lastName);
    }

    public MainPage clickSecondCheckboxInTable() {
        WebTable table = new WebTable();
        table.setTableWithContacts(tableWithContacts);
        table.clickSecondCheckbox();
        return new MainPage();
    }

    public CreateNewContactPage clickFirstRowEditButton() {
        firstRowEditButton.click();
        return new CreateNewContactPage();
    }

    public String getUserName() {
        String userName = currentUsername.getText();
        return userName.substring(1, userName.length() - 1);
    }

    public LoginPage clickLogoutButton() {
        logoutButton.click();
        return new LoginPage();
    }

    public CreateNewContactPage clickAddNewContactButton() {
        addNewContactButton.click();
        return new CreateNewContactPage();
    }

    public MainPage clickHomePageButton() {
        homePageButton.click();
        return this;
    }

    public MainPage clickDeleteButtonAndSubmit() {
        deleteButton.click();
        Selenide.confirm();
        return new MainPage();
    }

    public String getNumberOfElementsInTable() {
        return numberOfElementsInTable.getText();
    }
}

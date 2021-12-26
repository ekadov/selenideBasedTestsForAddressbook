package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import ru.addressbook.pages.CreateNewContactPage;
import ru.addressbook.pages.MainPage;
import ru.addressbook.steps.LoginStep;
import ru.addressbook.utils.GenerateData;

import static org.assertj.core.api.Assertions.assertThat;

class EditContactTest extends BaseTestClass {

    private CreateNewContactPage createNewAddressPage = new CreateNewContactPage();
    private MainPage mainPage = new MainPage();
    private String generatedLastName = GenerateData.generateLastName();

    @Test
    @Description("Test that user can enter Edit contact page")
    void testUserCanEnterEditContactPage() {
        LoginStep.loginWithValidCredentials().clickFirstRowEditButton();
        assertThat(createNewAddressPage.getUpdateButton().isDisplayed()).isTrue();
    }

    @Test
    @Description("Test that user can edit contact")
    void testUserCanEditFirstContact() {
        LoginStep.loginWithValidCredentials()
                .clickFirstRowEditButton()
                .clearLastNameField()
                .enterLastName(generatedLastName)
                .clickUpdateButton()
                .clickHomePageButton();
        assertThat(mainPage.checkIfLastNameExistsInTable(generatedLastName)).isTrue();
    }

}

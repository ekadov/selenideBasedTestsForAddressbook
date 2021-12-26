package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import ru.addressbook.pages.CreateNewContactPage;
import ru.addressbook.pages.MainPage;
import ru.addressbook.steps.LoginStep;

import static org.assertj.core.api.Assertions.assertThat;

class CreateNewContactTest extends BaseTestClass {

    private CreateNewContactPage createNewAddressPage = new CreateNewContactPage();
    private MainPage mainPage = new MainPage();

    @Test
    @Description("Enter contact creation page")
    void testUserCanEnterNewContactPage() {
        LoginStep.loginWithValidCredentials().clickAddNewContactButton();
        assertThat(createNewAddressPage.getFirstNameField().isDisplayed()).isTrue();
    }

    @Test
    @Description("Add new contact and save")
    void testUserCanAddNewContact() {
        LoginStep.loginWithValidCredentials()
                .clickAddNewContactButton()
                .enterFirstName(generatedFirstName)
                .enterLastName(generatedLastName)
                .enterNickName(generatedNickName)
                .clickSaveButton()
                .clickHomePageButton();
        assertThat(mainPage.checkIfLastNameExistsInTable(generatedLastName)).isTrue();
    }


}

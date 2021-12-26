package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import ru.addressbook.pages.MainPage;
import ru.addressbook.steps.LoginStep;

import static org.assertj.core.api.Assertions.assertThat;

class DeleteContactTest extends BaseTestClass {

    private MainPage mainPage = new MainPage();

    @Test
    @Description("Test if user can delete first contact")
    void testUserCanDeleteFirstContact() {
        LoginStep.loginWithValidCredentials();
        String numberOfElementsBefore = mainPage.getNumberOfElementsInTable();
        mainPage
                .clickSecondCheckboxInTable()
                .clickDeleteButtonAndSubmit()
                .clickHomePageButton();
        assertThat(mainPage.getNumberOfElementsInTable()).isNotEqualTo(numberOfElementsBefore);
    }


}

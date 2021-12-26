package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import ru.addressbook.pages.LoginPage;
import ru.addressbook.pages.MainPage;
import ru.addressbook.steps.LoginStep;
import ru.addressbook.utils.ConfProperties;

import static com.codeborne.selenide.Selenide.title;
import static org.assertj.core.api.Assertions.assertThat;

class LoginTest extends BaseTestClass {

    private LoginPage loginPage = new LoginPage();
    private MainPage mainPage = new MainPage();

    @Test
    @Description("Verify page title")
    void testLoginPageIsOpenedCorrectly() {
        assertThat(title()).isEqualTo("Address book");
    }

    @Test
    @Description("Login negative test with invalid user and password")
    void testUserCanNotLoginWithInvalidCredentials() {
        LoginStep.loginWithInvalidCredentials();
        assertThat(loginPage.getLoginButton().isDisplayed()).isTrue();
    }

    @Test
    @Description("Login positive test with valid user and password")
    void testUserCanLoginWithValidCredentials() {
        LoginStep.loginWithValidCredentials();
        assertThat(mainPage.getUserName())
                .isEqualTo(ConfProperties.getValidUsername());
    }

    @Test
    @Description("Logout from portal")
    void testUserCanLogout() {
        LoginStep.loginWithValidCredentials().clickLogoutButton();
        assertThat(loginPage.getLoginButton().isDisplayed()).isTrue();
    }


}

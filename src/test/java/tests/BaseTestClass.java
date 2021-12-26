package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriverException;
import ru.addressbook.utils.ConfProperties;
import ru.addressbook.utils.GenerateData;
import ru.addressbook.utils.TestDataPreparation;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTestClass {

    protected static String generatedFirstName = GenerateData.generateFirstName();
    protected static String generatedLastName = GenerateData.generateLastName();
    protected static String generatedNickName = GenerateData.generateNickName();
    private static boolean takeScreenshot;

    static {
        TestDataPreparation.clearDataFromAddressbookTable();
        for (int i = 1; i <= 2; i++) {
            TestDataPreparation.addNewContactToDatabase(i);
        }
    }

    @BeforeAll
    public static void setupAll() throws WebDriverException {
        Configuration.startMaximized = true;
        takeScreenshot = Boolean.parseBoolean(ConfProperties.getTakeScreenshotOnFail());
    }

    @BeforeEach
    public void setUp() {
        open(ConfProperties.getPortalUrl());
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }


}

package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.DriverFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.get("http://example.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin() {
        loginPage.login("user", "password");
        // Verifica el resultado de la prueba
        assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    @AfterEach
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}

package m4n4ge.selenium_autotests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import m4n4ge.selenium_autotests.pages.DashboardPage;
import m4n4ge.selenium_autotests.pages.LandingPage;
import m4n4ge.selenium_autotests.pages.SignupPage;


public class SignupTests {
	private WebDriver driver;

    @BeforeTest
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    @Test
    public void testUserSignup() {
        LandingPage landingPage = new LandingPage(driver);

        landingPage.goTo("http://localhost:5173");
        Assert.assertTrue(landingPage.isLoaded());

        landingPage.clickSignUpButton();

        SignupPage signupPage = new SignupPage(driver);
        Assert.assertTrue(signupPage.isLoaded());

        signupPage.signup("John","Doe", "JD@test.com", "Testing123!", "Testing123!");

        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isLoaded());
    }

    @AfterTest
    public void closeDriver() {
        this.driver.quit();
    }
}

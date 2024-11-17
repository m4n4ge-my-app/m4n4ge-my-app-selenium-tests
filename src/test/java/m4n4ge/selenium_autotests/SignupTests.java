package m4n4ge.selenium_autotests;

import org.testng.Assert;
import org.testng.annotations.Test;
import m4n4ge.selenium_autotests.pages.DashboardPage;
import m4n4ge.selenium_autotests.pages.LandingPage;
import m4n4ge.selenium_autotests.pages.SignupPage;


public class SignupTests extends BaseTest {

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
        
        dashboardPage.logout();
    }

}

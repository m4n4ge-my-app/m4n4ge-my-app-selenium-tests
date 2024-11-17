package m4n4ge.selenium_autotests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import m4n4ge.selenium_autotests.pages.DashboardPage;
import m4n4ge.selenium_autotests.pages.LandingPage;
import m4n4ge.selenium_autotests.pages.SignupPage;


public class SignupTests extends BaseTest {
	private LandingPage landingPage;
    private SignupPage signupPage;
    private DashboardPage dashboardPage;

    @BeforeTest
    public void setupPages() {
        this.landingPage = new LandingPage(driver);
        this.signupPage = new SignupPage(driver);
        this.dashboardPage = new DashboardPage(driver);
    }

    @Test
    public void testUserSignup() {
        landingPage.goTo("http://localhost:5173");
        Assert.assertTrue(landingPage.isLoaded());

        landingPage.clickSignUpButton();
        Assert.assertTrue(signupPage.isLoaded());

        signupPage.signup("John","Doe", "JD@test.com", "Testing123!", "Testing123!");
        Assert.assertTrue(dashboardPage.isLoaded());
    }
    
    @Test(dependsOnMethods = "testUserSignup")
    public void testLogout() {
        dashboardPage.logout();
        Assert.assertTrue(landingPage.isLoaded());
    }

}

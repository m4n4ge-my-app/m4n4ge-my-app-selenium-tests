package m4n4ge.selenium_autotests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import m4n4ge.selenium_autotests.pages.DashboardPage;
import m4n4ge.selenium_autotests.pages.LandingPage;
import m4n4ge.selenium_autotests.pages.SignupPage;
import m4n4ge.selenium_autotests.utils.JsonUtil;


public class SignupTests extends BaseTest {
	private LandingPage landingPage;
    private SignupPage signupPage;
    private DashboardPage dashboardPage;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;
    

    @BeforeTest
    public void setupPages() {
        this.landingPage = new LandingPage(driver);
        this.signupPage = new SignupPage(driver);
        this.dashboardPage = new DashboardPage(driver);
    }
    
//    @BeforeTest
//    @Parameters({"firstName", "lastName", "email", "password", "confirmPassword"})
//    public void setupUserDetails(String firstName, String lastName, String email, String password, String confirmPassword) {
//    	this.firstName = firstName;
//    	this.lastName = lastName;
//    	this.email = email;
//    	this.password = password;
//    	this.confirmPassword = confirmPassword;
//    	
//    }
    
    @BeforeTest
    public void setupUserDetails() {
    	UserData userDetails = JsonUtil.getTestData("m4n4ge.selenium_autotests.resources/test-data/alice.json");
    	this.firstName = userDetails.firstName();
    	this.lastName = userDetails.lastName();
    	this.email = userDetails.email();
    	this.password = userDetails.password();
    	this.confirmPassword = userDetails.confirmPassword();
    	
    }

    @Test
    public void testUserSignup() {
        landingPage.goTo("http://localhost:5173");
        Assert.assertTrue(landingPage.isLoaded());

        landingPage.clickSignUpButton();
        Assert.assertTrue(signupPage.isLoaded());

        signupPage.signup(firstName, lastName, email, password, confirmPassword);
        Assert.assertTrue(dashboardPage.isLoaded());
    }
    
    @Test(dependsOnMethods = "testUserSignup")
    public void testLogout() {
        dashboardPage.logout();
        Assert.assertTrue(landingPage.isLoaded());
    }

}

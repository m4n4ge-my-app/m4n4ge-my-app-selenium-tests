package m4n4ge.selenium_autotests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {

    @FindBy(linkText = "Sign Up")
    private WebElement signUpButton;

    public LandingPage(WebDriver driver) {
    	super(driver);
    }

    public void goTo(String url) {
        this.driver.get(url);
    }

    public void clickSignUpButton() {
        this.signUpButton.click();
    }
}

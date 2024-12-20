package m4n4ge.selenium_autotests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignupPage extends BasePage {
	
	private static final Logger logger = LoggerFactory.getLogger(SignupPage.class);

	@FindBy(name = "firstName")
	private WebElement firstNameField;

	@FindBy(name = "lastName")
	private WebElement lastNameField;

	@FindBy(name = "email")
	private WebElement emailField;

	@FindBy(name = "password")
	private WebElement passwordField;

	@FindBy(name = "confirmPassword")
	private WebElement confirmPasswordField;

	@FindBy(xpath = "//button[text()='Sign Up']")
	private WebElement signUpButton;

	
	public SignupPage(WebDriver driver) {
		super(driver);
	}


	public void signup(String firstName, String lastName, String email, String password, String confirmPassword) {
		logger.info("User details: firstName={}, lastName={}, email={}, password={}, confirmPassword={}", firstName, lastName, email, password, confirmPassword);
		this.firstNameField.sendKeys(firstName);
		this.lastNameField.sendKeys(lastName);
		this.emailField.sendKeys(email);
		this.passwordField.sendKeys(password);
		this.confirmPasswordField.sendKeys(confirmPassword);
		this.signUpButton.click();
	}
	
	@Override
    public boolean isLoaded() {
        this.wait.until(ExpectedConditions.visibilityOf(this.firstNameField));
        return this.firstNameField.isDisplayed();
    }

}

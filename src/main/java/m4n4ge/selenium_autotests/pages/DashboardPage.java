package m4n4ge.selenium_autotests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	private WebDriver driver;
	
	@FindBy(linkText = "Dashboard")
    private WebElement dashboardLink;

    @FindBy(xpath = "//button[@aria-label=\"Account settings\"]")
    private WebElement accountSettingsButton;

    @FindBy(xpath = "//ul[@role=\"menu\"]/li")
    private WebElement logoutLink;

	public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	public void logout() {
        this.accountSettingsButton.click();
        this.logoutLink.click();
    }
}

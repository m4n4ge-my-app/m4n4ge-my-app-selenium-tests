package m4n4ge.selenium_autotests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {
	
	@FindBy(linkText = "Dashboard")
    private WebElement dashboardLink;

    @FindBy(xpath = "//button[@aria-label=\"Account settings\"]")
    private WebElement accountSettingsButton;

    @FindBy(xpath = "//ul[@role=\"menu\"]/li")
    private WebElement logoutLink;

	public DashboardPage(WebDriver driver) {
		super(driver);
    }

	public void logout() {
        this.accountSettingsButton.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.logoutLink));
        this.logoutLink.click();
    }
}

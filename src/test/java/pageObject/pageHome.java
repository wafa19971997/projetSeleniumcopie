package pageObject;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pageHome {
	public WebDriver driver;
	public WebDriverWait wait;

	@FindBy(how = How.ID, using = "sign-in-email-input")
	public WebElement Login;

	@FindBy(how = How.ID, using = "sign-in-password-input")
	public WebElement Password;

	@FindBy(how = How.XPATH, using = "//div[@class='MuiBox-root css-1xu9e0d']")
	public WebElement SeConnecter_bt;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div/div/div[2]/div/div[1]/div/div")
	public WebElement College_bt;

	@FindBy(how = How.XPATH, using = "//h2[normalize-space()='general statistics']")//h2[normalize-space()='general statistics']
	WebElement MessageDashboard;

	public pageHome(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}

	public void SaisirURL(String url) {
		driver.get(url);
	}

	public void SaisirLogin(String email) {
		wait.until(ExpectedConditions.visibilityOf(Login)).sendKeys(email);
	}

	public void SaisirPassword(String password) {
		wait.until(ExpectedConditions.visibilityOf(Password)).sendKeys(password);
	}

	public void ClickSeConnecter() {
		wait.until(ExpectedConditions.elementToBeClickable(SeConnecter_bt)).click();
		College_bt.click();
	}
	
	
	
	public String TexteDashboard() {
		WebElement texteDash = wait.until(ExpectedConditions.visibilityOf(MessageDashboard));
		return texteDash.getText();

	}
}

package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
public class NavigationDevis {

	public WebDriver driver;
	public WebDriverWait wait;

	
	// constructeur

	public NavigationDevis(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy(how = How.XPATH, using = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-elevation0 MuiDrawer-paper MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft css-e1df1o']")
	public WebElement SideBar;

	@FindBy(how = How.XPATH, using = "/html/body/div/div[1]/div/ul/a[3]")
	public WebElement bt_Administration;

	@FindBy(xpath = "/html/body/div/div[1]/div/ul/a[3]/div/div/div/ul[1]")
	public WebElement bt_Finances;

	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/ul/a[3]/div/div/div/ul[1]/div/div/div/ul[2]/li/div/div/span")
	public WebElement bt_Facturations;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div/ul/a[3]/div/div/div/ul[1]/div/div/div/ul[2]/div/div/div/a[1]/li/div/div/span")
	public WebElement bt_Devis;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[2]/div/div/div/div[2]/div[3]/div/div/a/div/div")
	public WebElement bt_Nouveau_Devi;

	@FindBy(how = How.XPATH, using = "//h3[normalize-space()='Nouveau devis']")
	public WebElement txt_Nouveaudevis;

	
	

	public void verifyNouveauDevisMessage() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(normalize-space(), 'Nouveau devis')]")));
	}


	
	/*/public void SlidebarScroll() {
		if (SideBar.isDisplayed()) {
			SideBar.click();
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.PAGE_DOWN).perform();
		} else {
			System.out.println("SideBar n'est pas visible !");
		}
	
	}*/
	
	public void SlidebarScroll() {
		if (SideBar.isDisplayed()) {
			// Scroll à 50% via JavaScript
			((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollTop = arguments[0].scrollHeight / 2;", SideBar
			);
		} else {
			System.out.println("Sidebar non visible");
		}
	}
	
	public void cliquer_sur_le_bt_Administration() {
		bt_Administration.click();
	}

	public void cliquer_sur_le_bt_Finances() {
	    System.out.println("Clique sur le bouton Finances !!!");

	    wait.until(ExpectedConditions.elementToBeClickable(bt_Finances));
	    bt_Finances.click();
	}


	public void cliquer_sur_le_bt_Facturations() {
		wait.until(ExpectedConditions.visibilityOf(bt_Facturations));

		bt_Facturations.click();
	}
	
	
	

	public void cliquer_sur_le_bt_Devis() {

		bt_Devis.click();
	}

	public void cliquer_sur_le_bt_Nouveau_Devi() {
		bt_Nouveau_Devi.click();
	}

}

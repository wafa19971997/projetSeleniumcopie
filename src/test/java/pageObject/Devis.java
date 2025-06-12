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

public class Devis {

	public WebDriver driver;
	public WebDriverWait wait;

	// constructeur

	public Devis(WebDriver driver) {
		this.driver = driver;
		//this.wait = new WebDriverWait(driver, 20);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div/div/form/div/div[34]/div/svg[1]/path")
	public WebElement bt_AjoutArticle;
	
	@FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div/div/form/div/div[36]/div/button")

	public WebElement articletxt;
	// @FindBy(how = How.XPATH, using = "//div[@class='MuiBox-root
	// css-1ekynt6']//div[@class='css-17v7jhj']")
	@FindBy(how = How.XPATH, using = "//div[@id='react-select-2-placeholder']")

	public WebElement bt_Destinataire;

	@FindBy(how = How.XPATH, using = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-4 css-ql0jfo']//input[@value='0']")
	public WebElement bt_Durée;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Dinar tunisien (DT)')]")
	public WebElement bt_Devise;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Dinar tunisien (DT)')]")
	public WebElement bt_TVA;

	@FindBy(how = How.XPATH, using = "//h3[normalize-space()='Nouveau devis']")
	public WebElement txt_Nouveaudevis;

	// liste deroulante destinataire

	@FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div/div/form/div/div[2]/div/div/div/div[1]/div[2]/input")
	public WebElement ListDestinataire;

	@FindBy(how = How.XPATH, using = "//*[@id=\"react-select-2-placeholder\"]")

	public WebElement bt_Article;
	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Créer le devis']")
	public WebElement bt_CreerDevis;

	@FindBy(how = How.XPATH, using = "//div[@id='swal2-html-container']") /// html/body/div[2]/div/div[2]
																			/// ////*[@id="swal2-html-container"]
	WebElement ConfirmAjout_Texte;

	@FindBy(how = How.XPATH, using = "")
	public WebElement SideBar2;

	@FindBy(how = How.XPATH, using = "//*[@id='root']/div[2]/div/div/form/div/div[2]/p")
	public WebElement errorMessageDestinataire;
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[2]/div/div/form/div/div[23]")
	public WebElement errorMessageArticle;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()='ok']")
	public WebElement bt_OK;
	// calcul automatique Total HT et TTc

	@FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div/div/form/div/div[26]/div[2]/input")

	public WebElement quantiteInput;

	@FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div/div/form/div/div[27]/div[2]/input")
	public WebElement prixHTInput;

	@FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div/div/form/div/div[28]/div/div[2]/div/div[2]/div")
	public WebElement tvaInput;

	@FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div/div/form/div/div[30]/div/div[2]/input")
	public WebElement totalHTInput;

	@FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div/div/form/div/div[31]/div/div[2]/input")
	public WebElement totalTTCInput;

	@FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div/div/form/div/div[26]/p")
	public WebElement messageErreurQuantité;
	@FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div/div/form/div/div[27]/p")
	public WebElement messageErreurPrixHT;

	public void cliquer_sur_le_bt_Destinataire() {
		bt_Destinataire.click();
	}

	// liste deroulante destinataire

	public void selectionnerPremierDestinataire() {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Assurer que l'input est focus
		WebElement input = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@role='combobox']")));
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN) // aller au premier élément
				.sendKeys(Keys.ENTER) // sélectionner
				.perform();
	}

	public void cliquer_sur_le_bt_Article() {
		bt_Article.click();
	}

	// liste deroulante destinataire

	public void selectionnerPremierArticle() {
		// Attendre que la liste s'affiche
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Assurer que l'input est focus
		WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div/div[2]/div/div/form/div/div[20]/div/div[2]/div/div/div[1]/div[2]/input")));

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN) // aller au premier élément
				.sendKeys(Keys.ENTER) // sélectionner
				.perform();
	}

	public void cliquer_sur_le_bt_Creer_devis() {
		bt_CreerDevis.click();
	}

	public String ConfirmAjout() {
		WebElement ConfirmA = wait.until(ExpectedConditions.visibilityOf(ConfirmAjout_Texte));
		return ConfirmA.getText();
	}

	public void SlidebarScroll2() {
		if (SideBar2.isDisplayed()) {
			// Scroll à 50% via JavaScript
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[0].scrollHeight / 2;",
					SideBar2);
		} else {
			System.out.println("Sidebar2 non visible");
		}
	}

	// devis champs obligatoires vide

	// 1-message d'erreur destinataire

	public void verification_message_derreur_destinataire() {
		String color = errorMessageDestinataire.getCssValue("color");

		String expectedColor = "rgba(234, 6, 6, 1)";

		// Check if the color matches
		if (color.equals(expectedColor)) {
			System.out.println("Destinataire: ✅ The error message is red.");
		} else {
			System.out.println("Destinataire: ❌ Expected color: " + expectedColor + ", but found: " + color);
		}

	}
	// 2- message d'erreur article

	public void verification_message_derreur_article() {
		String color = errorMessageArticle.getCssValue("color");
		System.out.println(color);
		String expectedColor = "rgba(52, 71, 103, 1)";

		// Check if the color matches
		if (color.equals(expectedColor)) {
			System.out.println("Article: ✅ The error message is red.");
		} else {
			System.out.println("Article: ❌ Expected color: " + expectedColor + ", but found: " + color);
		}

	}

	public void cliquer_sur_le_bt_OK_POPUP() {
		bt_OK.click();
	}

//***********calcul automatique Total HT et TTc **********************

	public void saisirQuantite(String quantite) {
		quantiteInput.clear();
		quantiteInput.sendKeys(quantite);
	}

	public void saisirPrixHT(String prix) throws InterruptedException {
		//prixHTInput.clear();
		//prixHTInput.sendKeys(prix);
		  prixHTInput.click();
		    prixHTInput.clear();
		    Thread.sleep(200); // attendre un petit moment
		    prixHTInput.sendKeys(Keys.CONTROL + "a");
		    prixHTInput.sendKeys(Keys.DELETE);
		    prixHTInput.sendKeys(prix);
	}

	public void saisirTVA(String tva) {
		tvaInput.sendKeys(tva);
	}

	public String getTotalHT() {
		return totalHTInput.getAttribute("value");
	}

	public String getTotalTTC() {
		return totalTTCInput.getAttribute("value");
	}

	public String getMessageErreur_PrixHT() {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
 // version ancienne utilise int au lieu de Duration
		WebElement messageErreurPrixHT = wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath("/html/body/div/div[2]/div/div/form/div/div[27]/p")
		));
		return messageErreurPrixHT.getText();
	}

	public String getMessageErreur_Quantité() {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
 // version ancienne utilise int au lieu de Duration
		WebElement messageErreurQuantité = wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath("/html/body/div/div[2]/div/div/form/div/div[26]/p")
				));
		return messageErreurQuantité.getText();
	}
	
	public void scrollPage(int repeat) {
	    Actions actions = new Actions(driver);
	    for (int i = 0; i < repeat; i++) {
	        actions.sendKeys(Keys.PAGE_DOWN).perform();
	    }
	}
	public void scrollToElement(WebElement element) {
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	}
	public void selectionnerPremierTVA() {
		// Attendre que la liste s'affiche
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Assurer que l'input est focus
		WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div/div[2]/div/div/form/div/div[28]/div/div[2]/div/div[1]/div[2]/input")));

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN) // aller au premier élément
				.sendKeys(Keys.ENTER) // sélectionner
				.perform();
	}
}

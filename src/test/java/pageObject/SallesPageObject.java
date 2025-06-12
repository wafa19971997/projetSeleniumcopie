package pageObject;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SallesPageObject {
	
	public WebDriver driver;
	public WebDriverWait wait;

	// constructeur

	public SallesPageObject(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-elevation0 MuiDrawer-paper MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft css-e1df1o']")
	public WebElement Sidebar;

	@FindBy(how = How.XPATH, using = "/html/body/div/div[1]/div/ul/a[6]/li/div")
	public WebElement PlanEtude;

	@FindBy(how = How.XPATH, using = "/html/body/div/div[1]/div/ul/a[6]/div/div/div/ul[1]/li/div/div/span")
	public WebElement Parametrage;

	@FindBy(how = How.XPATH, using = "/html/body/div/div[1]/div/ul/a[6]/div/div/div/ul[1]/div/div/div/ul[2]/li/div/div/span")
	public WebElement BlocetSalle;

	@FindBy(how = How.XPATH, using = "/html/body/div/div[1]/div/ul/a[6]/div/div/div/ul[1]/div/div/div/ul[2]/div/div/div/a[3]/li/div/div/span")
	public WebElement NomdesSalle;

	@FindBy(how = How.XPATH, using = "//button[@id='add']")
	public WebElement AjouterSalle_bt;

	@FindBy(how = How.XPATH, using = "//input[@id='name']")
	public WebElement Nom;

	@FindBy(how = How.XPATH, using = "//input[@id='capacity']")
	public WebElement Capacite;

	@FindBy(how = How.XPATH, using = "//div[@placeholder='Toutes les types']//input[@id='size-small-standard']")
	public WebElement TypeList;

	@FindBy(how = How.XPATH, using = "//input[@id='typeSalle']")
	public WebElement TypeListmodif;

	@FindBy(how = How.XPATH, using = "//div[@placeholder='Toutes les blocs']//input[@id='size-small-standard']")
	public WebElement BlocList;

	@FindBy(how = How.XPATH, using = "//input[@id='bloc']")
	public WebElement BlocListmodif;

	@FindBy(how = How.XPATH, using = "//button[text()='Ajouter']")
	public WebElement Ajouter_bt;

	@FindBy(how = How.XPATH, using = "//div[@id='swal2-html-container']")
	WebElement ConfirmAjout_Texte;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()='OK']")
	public WebElement OKAjout_bt;
//****
	@FindBy(how = How.XPATH, using = "//img[@alt='profile-image']")
	public WebElement Profile_bt;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Déconnecter']")
	public WebElement Deconnexion_bt;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Recherche...']")
	public WebElement BarreRecherche;

	@FindBy(how = How.XPATH, using = "//span[@id='edit-enterprise-page']")
	public WebElement Stylo_bt;

	@FindBy(how = How.XPATH, using = "//body//div[@role='presentation']//div[@role='presentation']//div[3]//div[1]//div[1]//div[1]//div[1]//button[2]//*[name()='svg']//*[name()='path' and contains(@d,'M7 10l5 5 ')]")
	public WebElement SelectType;
//****
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[1]/div/div[3]/div/div/div/div/button[2]/svg")
	public WebElement Select;

	@FindBy(how = How.XPATH, using = "//div[4]//div[1]//div[1]//div[1]//div[1]//button[2]//*[name()='svg']")
	public WebElement SelectBloc;

	@FindBy(how = How.XPATH, using = "//li[@id='typeSalle-option-1']")
	public WebElement TD;

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/div[1]/div/div[4]/div/div/div/input")
	public WebElement BlocC;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Modifier']")
	public WebElement Modif_bt;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()='OK']")
	public WebElement OK_Modif;

	@FindBy(how = How.XPATH, using = "//div[@id='swal2-html-container']")
	WebElement ConfirmModif_Texte;

	@FindBy(how = How.XPATH, using = "//span[@id='delete-enterprise']")
	public WebElement Supp_bt;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Oui, supprimer!']")
	public WebElement SuppPopup;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()='OK']")
	public WebElement OK_Supp;

	@FindBy(how = How.XPATH, using = "//div[@id='swal2-html-container']")
	WebElement ConfirmSupp_Texte;

	@FindBy(how = How.XPATH, using = "//table[@role='table']")
	List<WebElement> salles; 

	@FindBy(how = How.XPATH, using = "//span[normalize-space()='chevron_right']")
	List<WebElement> boutonSuivant;

	// _________________________________________________________________________________________________________________

	public void SlidebarScroll() {
		Sidebar.click();
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
	}

	public void ClickPlanEtude() {
		wait.until(ExpectedConditions.elementToBeClickable(PlanEtude)).click();
	}

	public void ClickParametrage() {
		wait.until(ExpectedConditions.elementToBeClickable(Parametrage)).click();
	}

	public void ClickBlocetSalle() {
		wait.until(ExpectedConditions.elementToBeClickable(BlocetSalle)).click();
	}

	public void ClickNomdesSalle() {
		wait.until(ExpectedConditions.elementToBeClickable(NomdesSalle)).click();
	}

	public void ClickAjouterSalle() {
		AjouterSalle_bt.click();
	}

	public void SaisirNom(String nom) {
		Nom.sendKeys(nom);
	}

	public void SaisirCapacite(String cap) {
		Capacite.sendKeys(cap);
	}

	public void SlectionnerType(String type) {
		TypeList.click();
		Actions Type = new Actions(driver);
		Type.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

	}

	public void SlectionnerBloc(String bloc) {
		BlocList.click();
		Actions Bloc = new Actions(driver);
		Bloc.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

	}

	public void ClickAjout() {
		Ajouter_bt.click();
	}

	public String ConfirmAjout() {
		WebElement ConfirmA = wait.until(ExpectedConditions.visibilityOf(ConfirmAjout_Texte));
		return ConfirmA.getText();
	}

	public void ClickOKAjout() {
		OKAjout_bt.click();
	}


	public void Deconnexion() {
		Profile_bt.click();
		Deconnexion_bt.click();
	}

	public boolean RechercheSalleMdf(String salle) {
		wait.until(ExpectedConditions.visibilityOfAllElements(boutonSuivant));
		try {
			while (true) {
				// Clear and enter search term
				BarreRecherche.clear();
				BarreRecherche.sendKeys(salle);
				wait.until(ExpectedConditions.textToBePresentInElementValue(BarreRecherche, salle)); // Wait for results
																										// to load

				// Check if the searched salle exists in the table
				// List<WebElement> sallesListe =
				// driver.findElements(By.xpath("//table[@role='table']//tr"));
				for (WebElement row : salles) {
					if (row.getText().contains(salle)) {
						System.out.println("La Salle est trouvée : " + salle);
						return true; // Exit function if found
					}
				}

				// Check if the "Next" button exists and is enabled
				// List<WebElement> nextButtons =
				// driver.findElements(By.xpath("//button[text()='Suivant']"));
				if (!boutonSuivant.isEmpty() && boutonSuivant.get(0).isEnabled()) {
					wait.until(ExpectedConditions.elementToBeClickable(boutonSuivant.get(0))).click();
					wait.until(ExpectedConditions.visibilityOfAllElements(salles)); // Wait for new data to load
				} else {
					System.out.println("Salle non trouvée après avoir parcouru toutes les pages.");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false; // Return false if salle not found

	}

	public void ClickModif() {
		wait.until(ExpectedConditions.elementToBeClickable(Stylo_bt)).click();
	}

	public void ChangerNomSalle(String nom) {
		Nom.sendKeys(Keys.CONTROL + "a");
		Nom.sendKeys(Keys.BACK_SPACE);
		Nom.sendKeys(nom);
	}

	public void ChangerCapacité(String cap) {
		Capacite.sendKeys(Keys.CONTROL + "a");
		Capacite.sendKeys(Keys.BACK_SPACE);
		Capacite.sendKeys(cap);
	}

	public void ChangerType(String type) {
		wait.until(ExpectedConditions.elementToBeClickable(SelectType)).click();
		wait.until(ExpectedConditions.elementToBeClickable(TD)).click();
	}

	public void ClickModifier() {
		wait.until(ExpectedConditions.elementToBeClickable(Modif_bt)).click();

	}

	public void ClickOKmodif() {
		wait.until(ExpectedConditions.elementToBeClickable(OK_Modif)).click();

	}

	public String ConfirmModif() {
		WebElement ConfirmM = wait.until(ExpectedConditions.visibilityOf(ConfirmModif_Texte));
		return ConfirmM.getText();
	}

	public boolean RechercherSalleSupp(String salle) {
		wait.until(ExpectedConditions.visibilityOfAllElements(boutonSuivant));
		try {
			while (true) {
				// Clear and enter search term
				BarreRecherche.clear();
				BarreRecherche.sendKeys(salle);
				wait.until(ExpectedConditions.textToBePresentInElementValue(BarreRecherche, salle));
				// Wait for results to load

				// Check if the searched salle exists in the table
				// List<WebElement> sallesListe =
				// driver.findElements(By.xpath("//table[@role='table']//tr"));
				for (WebElement row : salles) {
					if (row.getText().contains(salle)) {
						System.out.println("La Salle est trouvée : " + salle);
						return true; // Exit function if found
					}
				}

				// Check if the "Next" button exists and is enabled
				// List<WebElement> nextButtons =
				// driver.findElements(By.xpath("//button[text()='Suivant']"));
				if (!boutonSuivant.isEmpty() && boutonSuivant.get(0).isEnabled()) {
					wait.until(ExpectedConditions.elementToBeClickable(boutonSuivant.get(0))).click();
					wait.until(ExpectedConditions.visibilityOfAllElements(salles)); // Wait for new data to load
				} else {
					System.out.println("Salle non trouvée après avoir parcouru toutes les pages.");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false; // Return false if salle not found

	}

	public void ClickSupp() {
		wait.until(ExpectedConditions.elementToBeClickable(Supp_bt)).click();
	}

	public void ClickSuppPopup() {
		wait.until(ExpectedConditions.elementToBeClickable(SuppPopup)).click();
	}

	public void ClickOKSupp() {
		wait.until(ExpectedConditions.elementToBeClickable(OK_Supp)).click();
	}

	public String ConfirmSupp() {
		WebElement ConfirmS = wait.until(ExpectedConditions.visibilityOf(ConfirmSupp_Texte));
		return ConfirmS.getText();
	}

}


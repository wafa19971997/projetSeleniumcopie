package stepDefinition;

import java.time.Duration;

import org.junit.Assert;
//import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import hooks.SetUp;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Devis;
import pageObject.NavigationDevis;

public class CalculAutoHTetTTC {

	WebDriver driver = SetUp.driver;

	NavigationDevis devis = new NavigationDevis(driver);
	Devis formDevis = new Devis(driver);

	@Then("je vérifie la connexion par le texte {string}")
	public void je_vérifie_la_connexion_par_le_texte(String string) throws InterruptedException {
		devis.cliquer_sur_le_bt_Nouveau_Devi();
		devis.verifyNouveauDevisMessage();
		Thread.sleep(2000);
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView({block:'center'});",formDevis.articletxt);
		
		formDevis.scrollToElement(formDevis.bt_AjoutArticle);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOf(formDevis.bt_AjoutArticle));

	}

	@When("Il saisit la quantité {string}")
	public void il_saisit_la_quantité(String string) throws InterruptedException {
		Thread.sleep(1000);
		/*Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		actions.sendKeys(Keys.PAGE_DOWN).perform();*/
		formDevis.saisirQuantite(string);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(formDevis.quantiteInput));
	}

	@When("Il saisit le prix HT {string}")
	public void il_saisit_le_prix_ht(String string) throws InterruptedException {
		Thread.sleep(1000);
		//wait.until(ExpectedConditions.visibilityOf(formDevis.prixHTInput));
		formDevis.saisirPrixHT(string);
		Thread.sleep(3000);

	}

	@When("Il saisit la TVA {string}")
	public void il_saisit_la_tva(String valeurTVA) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", formDevis.tvaInput);

		    wait.until(ExpectedConditions.elementToBeClickable(formDevis.tvaInput));

		    formDevis.tvaInput.click();

		    // Saisie de la TVA avec validation via ENTER
		    Actions actions = new Actions(driver);
		    actions.moveToElement(formDevis.tvaInput)
		           .click()
		           .sendKeys(valeurTVA)
		           .sendKeys(Keys.ENTER)
		           .perform();
		/*((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", formDevis.tvaInput);
		WebDriverWait wait = new WebDriverWait(driver, 10); // pas Duration
		wait.until(ExpectedConditions.visibilityOf(formDevis.tvaInput));
	    //tvaInput.clear();
	    formDevis.tvaInput.sendKeys(valeurTVA);
		/*formDevis.saisirTVA(valeurTVA);
		WebElement tvaInput = driver.findElement(By.cssSelector("input[id^='react-select'][id$='-input']"));*/
		Thread.sleep(3000);

		//Actions actions = new Actions(driver);
		// Cliquer sur le champ pour l'activer
	//	actions.moveToElement(formDevis.tvaInput).sendKeys(Keys.ENTER);

		// Envoyer le texte puis Entrée
		//actions.sendKeys(tvaInput, valeurTVA).sendKeys(Keys.ENTER).perform();

		Thread.sleep(5000);
		//formDevis.totalHTInput.click();*/
	}

	@Then("Le champ {string} doit afficher {string}")
	public void le_champ_doit_afficher(String champ, String valeurAttendue) {
		String valeurReelle = "";

		if (formDevis == null) {
			throw new IllegalStateException("formDevis n'est pas initialisé !");
		}

		switch (champ) {
		case "Total HT":
			valeurReelle = formDevis.getTotalHT();
			break;
		case "Total TTC":
			valeurReelle = formDevis.getTotalTTC();
			break;
		default:
			throw new IllegalArgumentException("Champ non pris en charge : " + champ);
		}

		System.out.println("Champ : " + champ);
		System.out.println("Valeur attendue : " + valeurAttendue);
		System.out.println("Valeur réelle : " + valeurReelle);

		Assert.assertEquals("Erreur de valeur pour " + champ, valeurAttendue, valeurReelle);
	}

	/*@Then("Un message d'erreur s'affiche avec le texte {string}")
	public void un_message_d_erreur_s_affiche_avec_le_texte(String string) {
		// formDevis.getMessageErreur_Quantité();
		// formDevis.getMessageErreur_PrixHT();
		String message = "";
		if (formDevis.getMessageErreur_PrixHT().contains(string)) {
			message = formDevis.getMessageErreur_PrixHT();
		} else if 
			(formDevis.getMessageErreur_Quantité().contains(string)) {
				message = formDevis.getMessageErreur_Quantité();
		}
		Assert.assertTrue("Message d'erreur non trouvé", message.contains(string));
	}*/
	@Then("Un message d'erreur s'affiche avec le texte {string}")
	public void un_message_d_erreur_s_affiche_avec_le_texte(String string) {
	    String message = "";

	    try {
	        if (formDevis.getMessageErreur_PrixHT().contains(string)) {
	            message = formDevis.getMessageErreur_PrixHT();
	        }
	    } catch (TimeoutException e) {
	        // Ignorer si le message PrixHT n'est pas visible
	    }

	    try {
	        if (message.isEmpty() && formDevis.getMessageErreur_Quantité().contains(string)) {
	            message = formDevis.getMessageErreur_Quantité();
	        }
	    } catch (TimeoutException e) {
	        // Ignorer si le message Quantité n'est pas visible
	    }

	    Assert.assertTrue("Message d'erreur non trouvé", message.contains(string));
	}

}

package stepDefinition;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import hooks.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Devis;
import pageObject.NavigationDevis;

public class DevisChampsObligatoiresVidesStepDef {

	WebDriver driver = SetUp.driver;

	NavigationDevis devis = new NavigationDevis(driver);
	Devis formDevis = new Devis(driver);

	@Given("l’utilisateur est connecté et accède à Nouveau devis")
	public void l_utilisateur_est_connecté_et_accède_à_nouveau_devis() {
		devis.cliquer_sur_le_bt_Nouveau_Devi();
		devis.verifyNouveauDevisMessage();
	}

	@When("il laisse les champs obligatoires vides et clique sur {string}")
	public void il_laisse_les_champs_obligatoires_vides_et_clique_sur(String string) throws InterruptedException {
		/*
		 * Actions actions = new Actions(driver); actions.sendKeys(Keys.PAGE_DOWN,
		 * Keys.PAGE_DOWN).perform(); actions.sendKeys(Keys.PAGE_DOWN).perform();
		 */

		Thread.sleep(1000);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});",
				formDevis.bt_CreerDevis);
		Thread.sleep(1000);

		formDevis.cliquer_sur_le_bt_Creer_devis();
	}

	@Then("des messages d’erreur s’affichent")
	public void des_messages_d_erreur_s_affichent() throws InterruptedException {
		
		formDevis.cliquer_sur_le_bt_OK_POPUP();

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});",
				formDevis.bt_Article);
				formDevis.verification_message_derreur_article();
				Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});",
				formDevis.bt_Destinataire);
		        formDevis.verification_message_derreur_destinataire();
		Thread.sleep(2000);


	}


}

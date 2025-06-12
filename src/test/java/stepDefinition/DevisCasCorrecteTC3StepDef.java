package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import hooks.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Devis;
import pageObject.NavigationDevis;

public class DevisCasCorrecteTC3StepDef {

	WebDriver driver = SetUp.driver;

	NavigationDevis devis = new NavigationDevis(driver);
	Devis formDevis = new Devis(driver);

	@Given("l’utilisateur est connecté et accède uu formulaire nouveau devis")
	public void l_utilisateur_est_connecté_et_accède_uu_formulaire_nouveau_devis() {
		devis.cliquer_sur_le_bt_Nouveau_Devi();
		devis.verifyNouveauDevisMessage();
	}

	@When("il clique su le champs {string}")
	public void il_clique_su_le_champs(String string) {
		formDevis.cliquer_sur_le_bt_Destinataire();

	}

	@When("choisir un destinataire")
	public void choisir_un_destinataire() {
		formDevis.selectionnerPremierDestinataire();
	}

	@When("il clique sur le champ {string}")
	public void il_clique_sur_le_champ(String string) throws InterruptedException {

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(2000);

		formDevis.cliquer_sur_le_bt_Article();
	}

	@When("choisir un article")
	public void choisir_un_article() {
		formDevis.selectionnerPremierArticle();
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();

	}

	@When("il clique sur le bouton Créer le devis")
	public void il_clique_sur_le_bouton_créer_le_devis() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(2000);
		formDevis.cliquer_sur_le_bt_Creer_devis();
	}

	@Then("le formulaire est validé je verifie la presence de pop up {string}")
	public void le_formulaire_est_validé_je_verifie_la_presence_de_pop_up(String string) {
		Assert.assertEquals(string, formDevis.ConfirmAjout());
		System.out.println("LA Devis est creer AVEC SUCCEE");
	}
}
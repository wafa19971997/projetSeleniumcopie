package stepDefinition;

import org.openqa.selenium.WebDriver;

import hooks.SetUp;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Devis;
import pageObject.NavigationDevis;

public class DevisSimpleSansTVAStepDef {

	WebDriver driver = SetUp.driver;

	NavigationDevis devis = new NavigationDevis(driver);
	Devis formDevis = new Devis(driver);

	@When("je choisis le destinataire")
	public void je_choisis_le_destinataire() {

	}

	@When("je saisis la durée de validité {string}")
	public void je_saisis_la_durée_de_validité(String string) {

	}

	@When("je sélectionne la devise {string}")
	public void je_sélectionne_la_devise(String string) {

	}

	@When("je sélectionne {string}")
	public void je_sélectionne(String string) {

	}

	@When("je choisis les conditions de règlement {string}")
	public void je_choisis_les_conditions_de_règlement(String string) {

	}

	@When("je choisis {string}")
	public void je_choisis(String string) {

	}

	@When("je choisis le mode de paiement {string}")
	public void je_choisis_le_mode_de_paiement(String string) {

	}

	@When("je saisis un droit de timbre de {string}")
	public void je_saisis_un_droit_de_timbre_de(String string) {

	}

	@When("je saisis une retenue à la source de {string}")
	public void je_saisis_une_retenue_à_la_source_de(String string) {

	}

	@When("je sélectionne l'état de devis {string}")
	public void je_sélectionne_l_état_de_devis(String string) {

	}

	@When("j’ajoute un article {string} avec quantité {string}, prix HT {string}, TVA {string}, réduction {string}")
	public void j_ajoute_un_article_avec_quantité_prix_ht_tva_réduction(String string, String string2, String string3,
			String string4, String string5) {

	}

	@Then("le total HT doit être {string}")
	public void le_total_ht_doit_être(String string) {

	}

	@Then("le total TTC doit être {string}")
	public void le_total_ttc_doit_être(String string) {

	}
}

package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import hooks.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.SallesPageObject;

public class SallesStepDef {

	WebDriver driver = SetUp.driver;

	SallesPageObject ajout = new SallesPageObject(driver);
	

	@Given("je clique sur plan etude")
	public void je_clique_sur_plan_etude() {
		ajout.SlidebarScroll();
		   ajout.ClickPlanEtude();
	}

	@When("je clique sur parametrage")
	public void je_clique_sur_parametrage() {
		   ajout.ClickParametrage();
	}

	@When("je clique sur bloc et salle")
	public void je_clique_sur_bloc_et_salle() {
	    ajout.ClickBlocetSalle();
	}

	@When("je clique sur nom des salles")
	public void je_clique_sur_nom_des_salles() {
	   ajout.ClickNomdesSalle();
	}
//_____________________________________________________
	
	@When("je clique sur bouton ajouter salle")
	public void je_clique_sur_bouton_ajouter_salle() {
	    ajout.ClickAjouterSalle();
	}

	@When("je saisis le nom de salle {string}")
	public void je_saisis_le_nom_de_salle(String string) {
		ajout.SaisirNom(string);
	}

	@When("je saisis le la capacité de la salle {string}")
	public void je_saisis_le_la_capacité_de_la_salle(String string) {
		ajout.SaisirCapacite(string);
	}

	@When("je selectionne le type de la salle {string}")
	public void je_selectionne_le_type_de_la_salle(String string) {
		ajout.SlectionnerType(string);
	}

	@When("je selectionne le bloc de la salle {string}")
	public void je_selectionne_le_bloc_de_la_salle(String string) {
		ajout.SlectionnerBloc(string);
	}

	@When("je clique sur bouton Ajouter")
	public void je_clique_sur_bouton_ajouter() {
		ajout.ClickAjout();
	}

	@Then("je vérifie l ajout de nouvelle salle avec le message de popup {string}")
	public void je_vérifie_l_ajout_de_nouvelle_salle_avec_le_message_de_popup(String string) {
		Assert.assertEquals(string,ajout.ConfirmAjout());
	    System.out.println("LA SALLE AJOUTE AVEC SUCCEE");
	}

	@Then("je clique sur bouton OK pour confirmer l ajout")
	public void je_clique_sur_bouton_ok_pour_confirmer_l_ajout() {
		ajout.ClickOKAjout();
	    ajout.Deconnexion();
	}
//___________________________________________________
	@Given("je cherche la salle a modifer {string}")
	public void je_cherche_la_salle_a_modifer(String string) {
		ajout.RechercheSalleMdf(string);
	}

	@Given("je clique sur icon stylo")
	public void je_clique_sur_icon_stylo() {
		ajout.ClickModif();
	}

	@When("je change le nom de salle {string}")
	public void je_change_le_nom_de_salle(String string) {
		ajout.ChangerNomSalle(string);
	}

	@When("je change la capacité de la salle {string}")
	public void je_change_la_capacité_de_la_salle(String string) {
		ajout.ChangerCapacité(string);
	}

	@When("je change  le type de la salle {string}")
	public void je_change_le_type_de_la_salle(String string) {
		ajout.ChangerType(string);
	}

	@When("je clique sur bouton Modifier")
	public void je_clique_sur_bouton_modifier() {
		ajout.ClickModifier();
	}

	@Then("je vérifie la modification de nouvelle salle avec le message popup {string}")
	public void je_vérifie_la_modification_de_nouvelle_salle_avec_le_message_popup(String string) throws InterruptedException {
		Thread.sleep(2000);

		Assert.assertEquals(string, ajout.ConfirmModif());
		System.out.println("LA SALLE A ETE MODIFIE AVEC SUCCEE");
	}

	@Then("je clique sur bouton OK pour con firmer la modification")
	public void je_clique_sur_bouton_ok_pour_con_firmer_la_modification() throws InterruptedException {
		Thread.sleep(2000);

		ajout.ClickOKmodif();
		ajout.Deconnexion();
	}
//____________________________________________________
	@Given("je cherchere la salle {string}")
	public void je_cherchere_la_salle(String string) {
		ajout.RechercherSalleSupp(string);
	}

	@When("je clique sur bouton supprimer")
	public void je_clique_sur_bouton_supprimer() {
		ajout.ClickSupp();
	}

	@When("je clique bouton OUI Supprimer de popup")
	public void je_clique_bouton_oui_supprimer_de_popup() {
		ajout.ClickSuppPopup();
	}

	@Then("je vérifie la suppression de la salle avec le message popup {string}")
	public void je_vérifie_la_suppression_de_la_salle_avec_le_message_popup(String string) {
		Assert.assertEquals(string, ajout.ConfirmSupp());
		System.out.println("LA SALLE A ETE SUPPRIME AVEC SUCCEE");
	}

}

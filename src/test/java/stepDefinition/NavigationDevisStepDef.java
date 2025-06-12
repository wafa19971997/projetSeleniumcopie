package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import hooks.SetUp;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.NavigationDevis;

public class NavigationDevisStepDef {

	WebDriver driver = SetUp.driver;

	NavigationDevis devis = new NavigationDevis(driver);

	@When("il navigue vers le menu {string}")
	public void il_navigue_vers_le_menu(String string) throws InterruptedException {
        devis.SlidebarScroll();
		devis.cliquer_sur_le_bt_Administration();
		Thread.sleep(2000);
	}

	@When("il navigue vers {string}")
	public void il_navigue_vers(String string) throws InterruptedException {

		devis.cliquer_sur_le_bt_Finances();
		Thread.sleep(2000);
	}

	 @When("il clique sur {string}")
	public void il_clique_sur(String string) throws InterruptedException {

		devis.cliquer_sur_le_bt_Facturations();
		Thread.sleep(2000);
	}
	@When("il clique sur le bouton {string}")
	public void il_clique_sur_le_bouton(String string) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		devis.cliquer_sur_le_bt_Devis();
	}

	@Then("la page {string} s’affiche avec les éléments de l’interface correspondant")
	public void la_page_s_affiche_avec_les_éléments_de_l_interface_correspondant(String string) {
		devis.cliquer_sur_le_bt_Nouveau_Devi();
		Assert.assertTrue(devis.txt_Nouveaudevis.isDisplayed());

	}
}

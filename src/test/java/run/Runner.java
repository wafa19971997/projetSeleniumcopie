package run;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
//@CucumberOptions(tags = "@DevisCasCorrecteTC3" + "" + "" + "",
//@CucumberOptions(tags = "@Erudaxis_NavigationDevis" + "" + "" + "",
//@CucumberOptions(tags = "@TC4" + "" + "" + "",
//@CucumberOptions(tags = "@TC6"
@CucumberOptions(tags = "@Salles"
		+ "" + "" + "" + "",
		// glue = cest ou je trouve les annotation cucumber (@when /@then /
		// @before/@after ...)
		glue = { "stepDefinition", "hooks" },
		// features= clique droite et propriete ==> copier path a partir de src/... du
		// Package testCasesZutomationEexercice qui se trouve dans src/test/features
		features = "src/test/features/salles", monochrome = false, publish = true, plugin = { "pretty",
				"html:target/cucumber-report.html", "json:target/cucumber-reportJson",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class Runner {

}

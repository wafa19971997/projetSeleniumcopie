package hooks;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;

public class SetUp {

    @Before
    public void initial(Scenario scenario) {
        DriverManager.type_driver = "chrome";
        DriverManager.GetDriver();

        // Appliquer un zoom de 60%
        JavascriptExecutor jse = (JavascriptExecutor) DriverManager.driver;
        jse.executeScript("document.body.style.zoom = '40%';");

    }

    @BeforeStep
    public void avant_etape(Scenario scenario) {
        System.out.println("etape en cours : " + scenario.getName()); 
    }

    @AfterStep
    public void TakeScreenshot(Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot) DriverManager.driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "image");

    }

    @After
    public void terminal(Scenario scenario) {
        if (DriverManager.driver != null) {
            DriverManager.driver.close();
            DriverManager.driver = null;
        }
    }
}

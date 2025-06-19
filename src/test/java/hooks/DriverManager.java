package hooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

    public static WebDriver driver;
    public static String type_driver;

    public static WebDriver GetDriver() {

        if (driver == null) { // vérifier que le driver n'a pas déjà été créé
            if ("chrome".equals(type_driver)) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();

                // Add this to specify a unique user data directory for each session
                options.addArguments("--user-data-dir=/tmp/chrome-user-data-" + System.currentTimeMillis());

                // Add other arguments as needed for Docker/headless environments
                options.addArguments("--headless=new"); // Modern headless mode (recommended)
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--window-size=1920,1080");

                driver = new ChromeDriver(options);
              //  driver.manage().window().maximize();

                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
             //   driver = new ChromeDriver();
                
               // driver.manage().window().maximize();
               // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            } else if ("edge".equals(type_driver)) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
        }
        return driver;

    }
}


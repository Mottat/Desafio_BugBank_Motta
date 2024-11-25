package bugBank;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

    public static WebDriver driver;

    public static WebDriver startDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--kiosk");
//        options.addArguments("--headless"); // Sem abrir navegador
        driver = new ChromeDriver(options);
        return driver;
    }

    public static WebDriver getDriver(){
        if (driver == null){
            driver = startDriver();
        }
        return driver;
    }

    public static void quitDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

    @BeforeEach
    public void setUp(){
        getDriver().get("https://bugbank.netlify.app/");
    }

    @AfterEach
    public void finish(){quitDriver();}

}

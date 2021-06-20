package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserConfig {

    private WebDriver driver;

    public BrowserConfig() {
        System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.addArguments("--user-agent=" + "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36");
        options.addArguments("--lang=es");
        options.setCapability("nativeEvents", false);
    }

    public WebDriver getDriver() {
        return driver;
    }
}

package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Wait {

    private WebDriver driver;

    public Wait(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public void ForElement(WebElement elemento) {
        int tiempoAEsperar = 10;
        final WebDriverWait wait = new WebDriverWait(driver, tiempoAEsperar);
        try {
            wait.until(invisibilityOfElementLocated(By.xpath("//*[@id='spinner']")));
            wait.until(invisibilityOfElementLocated(By.xpath("//*[@class='preloader-animation']")));
            wait.until(invisibilityOfElementLocated(By.xpath("//*[@class='preloader']")));
            wait.until(refreshed(elementToBeClickable(elemento)));
            Thread.sleep(1000);

        } catch (Exception e) {
            System.out.println("--La automatizacion duro mas de " + tiempoAEsperar + " segundos esperando.");
        }
        wait.until(elementToBeClickable(elemento));
        wait.until(visibilityOfAllElements(elemento));
    }
}
package Page;

import Utils.Wait;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.io.ByteArrayInputStream;


public class HomePage extends Page{

    private WebDriver driver;
    private Wait wait;

    @FindBy(id = "search_query_top")
    private WebElement searchIpunt;
    @FindBy(xpath = "//*[@class='btn btn-default button-search']")
    private WebElement searchBtn;

    public HomePage (final WebDriver driver){
        super(driver);
        this.driver = driver;
        wait = new Wait(driver);
    }

    public void open(){
        driver.get("http://automationpractice.com/index.php");
    }

    public void selectItem(String product){
        wait.ForElement(driver.findElement(By.xpath("//*[contains(@class, 'product-name') and contains(., 'Faded')]")));
        driver.findElement(By.xpath("//*[contains(@class, 'product-name') and contains(., '"+ product +"')]")).click();
    }

    public void search(String item){
        wait.ForElement(searchIpunt);
        searchIpunt.sendKeys(item);
        wait.ForElement(searchBtn);
        searchBtn.click();
    }
}

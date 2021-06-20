package Page;

import Utils.Wait;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.io.ByteArrayInputStream;

public class ProductDetailPage extends Page{

    private WebDriver driver;
    private Wait wait;

    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    private WebElement addProductBtn;
    @FindBy(xpath = "//*[@title='Close window']")
    private WebElement closeWindowsBtn;

    private final String validation = "#layer_cart > div.clearfix";
    private final String addressTxt = "#block_contact_infos > div > ul > li:nth-child(1)";
    private final String phoneTxt = "#block_contact_infos > div > ul > li:nth-child(2)";
    private final String mailTxt = "#block_contact_infos > div > ul > li:nth-child(3)";


    public ProductDetailPage(final WebDriver driver){

        super(driver);
        this.driver = driver;
        wait = new Wait(driver);
    }

    public void addProduct(){
        wait.ForElement(addProductBtn);
        addProductBtn.click();
    }

    public void closeWindows(){
        wait.ForElement(closeWindowsBtn);
        closeWindowsBtn.click();
    }

    public boolean validateProductAdded() {
        wait.ForElement(driver.findElement(By.cssSelector(validation)));
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot)
                driver).getScreenshotAs(OutputType.BYTES)));
        return driver.findElement(By.cssSelector(validation)).getText().contains("Product successfully added");
    }

    public boolean getStoreInformation(){
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
        wait.ForElement(driver.findElement(By.cssSelector(addressTxt)));
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot)
                driver).getScreenshotAs(OutputType.BYTES)));
        return driver.findElement(By.cssSelector(addressTxt)).getText().contains("Selenium Framework, " +
                "Research Triangle Park, North Carolina, USA") &&
                driver.findElement(By.cssSelector(phoneTxt)).getText().contains("(347) 466-7432") &&
                driver.findElement(By.cssSelector(mailTxt)).getText().contains("support@seleniumframework.com");
    }
}

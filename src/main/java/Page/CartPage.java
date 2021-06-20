package Page;

import Utils.Wait;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.io.ByteArrayInputStream;

public class CartPage extends Page {

    private WebDriver driver;
    private final Wait wait;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    private WebElement cartBtn;
    @FindBy(xpath = "//*[@class='icon-trash']")
    private WebElement removeBtn;
    @FindBy(xpath = "//p[@class='alert alert-warning']")
     private WebElement validation;


    public CartPage(final WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new Wait(driver);
    }

    public void goToCart() {
        wait.ForElement(cartBtn);
        cartBtn.click();
    }

    public void removeItem() {
        wait.ForElement(removeBtn);
        removeBtn.click();
    }

    public boolean validateCartEmpty() {
        wait.ForElement(validation);
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot)
                driver).getScreenshotAs(OutputType.BYTES)));
        return driver.findElement(By.xpath("//p[@class='alert alert-warning']")).getText().contains("Your shopping cart is empty.");
    }
}

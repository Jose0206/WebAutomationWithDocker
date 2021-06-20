package Page;

import Utils.Wait;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;

import java.io.ByteArrayInputStream;


public class SearchPage extends Page{

    private WebDriver driver;
    private Wait wait;

    public SearchPage(final WebDriver driver){
        super(driver);
        this.driver = driver;
        wait = new Wait(driver);
    }

    public boolean verifyItemNotFound(){
        if (driver.findElement(By.cssSelector("#center_column > p")).getText().contains("No results were found")){
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot)
                    driver).getScreenshotAs(OutputType.BYTES)));
            return true;
        }else{
            return false;
        }
    }

    public boolean verifyItemFound(){
        wait.ForElement(driver.findElement(By.cssSelector("#center_column > h1")));
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot)
                driver).getScreenshotAs(OutputType.BYTES)));
        return driver.findElement(By.cssSelector("#center_column > div:nth-child(2) > div.sortPagiBar.clearfix > ul > li.display-title"))
                .getText().contains("View");
    }
}


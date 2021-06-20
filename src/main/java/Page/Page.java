package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Page {
    public Page(final WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }
}

import Page.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;



import java.net.MalformedURLException;
import java.net.URL;


public class Tests {

    private WebDriver driver;
    private HomePage homePage;
    private ProductDetailPage productDetailPage;
    private CartPage cartpage;
    private SearchPage searchPage;
    static final String HOST_URL = "http://localhost:4444/wd/hub";

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        ChromeOptions opt = new ChromeOptions();
        try {
            driver = new RemoteWebDriver(new URL(HOST_URL), opt);
            } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        homePage = new HomePage(driver);
        driver.get("http://automationpractice.com/index.php");
        productDetailPage = new ProductDetailPage(driver);
        cartpage = new CartPage(driver);
        searchPage = new SearchPage(driver);
    }

    @Test
    public void addItem_test(){
        homePage.selectItem("Printed Summer Dress");
        productDetailPage.addProduct();
        Assert.assertTrue(productDetailPage.validateProductAdded());
    }

    @Test
    public void removeItem_test() {
        homePage.selectItem("Printed Summer Dress");
        productDetailPage.addProduct();
        Assert.assertTrue(productDetailPage.validateProductAdded());
        productDetailPage.closeWindows();
        cartpage.goToCart();
        cartpage.removeItem();
        Assert.assertTrue(cartpage.validateCartEmpty());
    }

    @Test
    public void validateStoreInformation_test(){
        Assert.assertTrue(productDetailPage.getStoreInformation());
    }

    @Test
    public void searchItem_test(){
        homePage.search("blouse");
        Assert.assertTrue(searchPage.verifyItemFound());
    }

    @Test
    public void itemNotFound_test(){
        homePage.search("ItemNotFound");
        Assert.assertTrue(searchPage.verifyItemNotFound());
    }


    @AfterMethod
    public void close(){
        driver.close();
        driver.quit();
    }
}

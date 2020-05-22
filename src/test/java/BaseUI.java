import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import java.lang.reflect.Method;

public class BaseUI {
    WebDriver driver;
    WebDriverWait wait;

    //   Declare objects for main classes:
    //   We declare it but don't initialize it - We have constructor that asks for driver & wait
    //   Which is also empty here
    //   WebDriver driver;
    //   WebDriverWait wait;

    /*   We intialize objects after wait and driver
         driver = new ChromeDriver();
         wait = new WebDriverWait(driver, 20);
    */
    MainPage mainPage;
    PrettyWomenPage prettyWomenPage;
    SignInPage signInPage;
    GiftsPage giftsPage;
    BlogPage blogPage;
    PhotosPage photosPage;
    SoftAssert softAssert = new SoftAssert();  //VID 10 16:36

    @BeforeMethod
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser, Method method){

        // Check if parameter passed from TestNG is 'firefox'
        if (browser.equalsIgnoreCase("firefox")) {
            // Create firefox instance
            System.setProperty("webdriver.gecko.driver", "geckodriver");
            driver = new FirefoxDriver();

        }
        // Check if parameter passed as 'chrome'
        else if (browser.equalsIgnoreCase("chrome")) {
            // Set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            // Create chrome instance
            driver = new ChromeDriver();
            driver.get("chrome://settings/clearBrowserData");

        } else if (browser.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", "IEDriverServer");
            driver = new InternetExplorerDriver();
            driver.manage().deleteAllCookies();

        } else {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            driver = new ChromeDriver();
            driver.get("chrome://settings/clearBrowserData");    //clean browser data
        }

        wait = new WebDriverWait(driver, 20);
        // We initialize objects here after webdriver and wait

        mainPage = new MainPage(driver, wait);
        prettyWomenPage = new PrettyWomenPage(driver, wait);
        signInPage = new SignInPage(driver, wait);
        giftsPage = new GiftsPage(driver, wait);
        blogPage = new BlogPage(driver, wait);
        photosPage = new PhotosPage(driver, wait);
        driver.manage().window().maximize();
        driver.get(Data.mainUrl);

    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

}


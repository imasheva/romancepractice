package com.romanceabroad.ui;

import com.romanceabroad.ui.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

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
    ContactsUsPage contactUsPage;
    SoftAssert softAssert = new SoftAssert();  //VID 10 16:36

    protected TestBox testBox;

    protected enum TestBox {
        LOCAL, SAUCE
    }

    @BeforeMethod(groups = {"user", "admin", "ie"}, alwaysRun = true)
    @Parameters({"browser", "version", "platform", "testbox"})
    public void setup(@Optional("chrome") String browser, @Optional("null") String version, @Optional("null") String platform, @Optional("null") String box, @Optional("null") Method method) throws MalformedURLException {

        Reports.start(method.getDeclaringClass().getName() + " : " + method.getName());

        if (box.equalsIgnoreCase("local")) { //TestNG
            testBox = TestBox.LOCAL;
        } else if (box.equalsIgnoreCase("sauce")) {//Sauce vid.31, 55:05
            testBox = TestBox.SAUCE;
        }
        switch (testBox) {
            case LOCAL:
                if (browser.equalsIgnoreCase("firefox")) {
                    System.setProperty("webdriver.gecko.driver", "geckodriver");
                    driver = new FirefoxDriver();

                } else if (browser.equalsIgnoreCase("chrome")) {
                    System.setProperty("webdriver.chrome.driver", "chromedriver");
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
                break;
            case SAUCE:
                DesiredCapabilities capabilities = new DesiredCapabilities(); //for everything
                capabilities.setCapability("username", "anaraimasheva");
                capabilities.setCapability("accessKey", "0fa0d17c-8e86-4489-b7a1-4d1861f3b720");
                capabilities.setCapability("browserName", browser);
                capabilities.setCapability("platform", platform);
                capabilities.setCapability("version", version);
                capabilities.setCapability("name", method.getName());

                driver = new RemoteWebDriver(
                        new URL("http://" + System.getenv("SAUCE_USERNAME") + ":" + System.getenv("SAUCE_ACCES_KEY")
                                + "@ondemand.saucelabs.com:80/wd/hub"),
                        capabilities);
                break;
        }
        wait = new WebDriverWait(driver, 20);
        // We initialize objects here after webdriver and wait

        mainPage = new MainPage(driver, wait);
        prettyWomenPage = new PrettyWomenPage(driver, wait);
        signInPage = new SignInPage(driver, wait);
        giftsPage = new GiftsPage(driver, wait);
        blogPage = new BlogPage(driver, wait);
        photosPage = new PhotosPage(driver, wait);
        contactUsPage = new ContactsUsPage(driver, wait);

        driver.manage().window().maximize();
        driver.get(Data.mainUrl);

    }

    @AfterMethod
    public void closeBrowser(ITestResult testResult) {

        if (testResult.getStatus() == ITestResult.FAILURE) {
            Reports.fail(driver, testResult.getName());
        }
        Reports.stop();

        driver.quit();
    }

}


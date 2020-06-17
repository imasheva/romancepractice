package com.romanceabroad.ui;

import com.romanceabroad.ui.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

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
    protected TestBrowser testBrowser;
    protected String valueOfBox;

    protected enum TestBox {
        WEB, MOBILE, SAUCE
    }

    protected enum TestBrowser {
        CHROME, FIREFOX, IE, REMOTE_CHROME, REMOTE_FIREFOX
    }

    @BeforeMethod(groups = {"user", "admin", "ie"}, alwaysRun = true)
    @Parameters({"browser", "testbox", "platform", "version", "deviceName", "testEnv"})

    public void setup(@Optional("chrome") String browser, @Optional("web") String box,
                      @Optional("null") String platform,
                      @Optional("null") String version, @Optional("null") String device,
                      @Optional("qa") String env,
                                  Method method, ITestContext context) throws MalformedURLException {

        Reports.start(method.getDeclaringClass().getName() + " : " + method.getName());

        if (box.equalsIgnoreCase("web")) { //TestNG
            testBox = TestBox.WEB;
        } else if (box.equalsIgnoreCase("mobile")) {
            testBox = TestBox.MOBILE;
        } else if (box.equalsIgnoreCase("sauce")) {//Sauce vid.31, 55:05
            testBox = TestBox.SAUCE;
        }
        if (browser.equalsIgnoreCase("chrome")) {
            testBrowser = TestBrowser.CHROME;
        } else if (browser.equalsIgnoreCase("firefox")) {
            testBrowser = TestBrowser.FIREFOX;
        } else if (browser.equalsIgnoreCase("ie")) {
            testBrowser = TestBrowser.IE;
        }if (browser.equalsIgnoreCase("remoteChrome")) {
            testBrowser = TestBrowser.REMOTE_CHROME;
        }else if (browser.equalsIgnoreCase("remoteFirefox")) {
            testBrowser = TestBrowser.REMOTE_FIREFOX;
        }


        switch (testBox) {
            case WEB:
                switch (testBrowser) {
                    case FIREFOX:
                        System.setProperty("webdriver.gecko.driver", "geckodriver");
                        driver = new FirefoxDriver();
                        break;
                    case CHROME:
                        System.setProperty("webdriver.chrome.driver", "chromedriver");
                        driver = new ChromeDriver();
                        driver.get("chrome://settings/clearBrowserData");
                        break;
                    case IE:
                        System.setProperty("webdriver.ie.driver", "IEDriverServer");
                        driver = new InternetExplorerDriver();
                        driver.manage().deleteAllCookies();
                        break;

                    case REMOTE_FIREFOX:
                        System.out.println("Remote Firefox");
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.addArguments("--headless");
                        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
                        break;

                    case REMOTE_CHROME:
                        System.out.println("Remote Chrome");
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--headless");
                        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
                        break;

                    default:
                        System.out.println("Default!!!");
                        System.setProperty("webdriver.chrome.driver", "chromedriver");
                        driver = new ChromeDriver();
                        driver.get("chrome://settings/clearBrowserData");    //clean browser data
                        break;
                }
                 driver.manage().window().maximize();
                break;

            case MOBILE:
                switch (testBrowser) {
                    case CHROME:
                    System.out.println("Mobile Chrome");
                    Map<String, String> mobileEmulation = new HashMap<String, String>();
                    mobileEmulation.put("deviceName", "Galaxy S5");
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
                    System.setProperty("webdriver.chrome.driver", "chromedriver");
                    driver = new ChromeDriver(chromeOptions);
                    driver.get("chrome://settings/clearBrowserData");
                    break;
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

        wait = new

                WebDriverWait(driver, 20);
        // We initialize objects here after webdriver and wait
        mainPage = new  MainPage(driver, wait);
        prettyWomenPage = new PrettyWomenPage(driver, wait);
        signInPage = new SignInPage(driver, wait);
        giftsPage = new GiftsPage(driver, wait);
        blogPage = new BlogPage(driver, wait);
        photosPage = new PhotosPage(driver, wait);
        contactUsPage = new ContactsUsPage(driver, wait);

        driver.manage().window().maximize();

        PageFactory.initElements(driver, mainPage);
        PageFactory.initElements(driver, prettyWomenPage);

        if(env.contains("qa")){
            driver.get(Data.mainUrl);
        }else if(env.contains("uat")){
            driver.get("https://www.google.com/");
        }else if(env.contains("prod")){
            driver.get("https://www.yahoo.com/");
        }
         valueOfBox = box;
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


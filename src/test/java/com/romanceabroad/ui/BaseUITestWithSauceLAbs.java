/*
package com.romanceabroad.ui;

import org.openqa.selenium.JavascriptExecutor;
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

public class BaseUITestWithSauceLAbs {
    WebDriver driver;
    WebDriverWait wait;

    //   Declare objects for main classes:
    //   We declare it but don't initialize it - We have constructor that asks for driver & wait
    //   Which is also empty here
    //   WebDriver driver;
    //   WebDriverWait wait;

    */
/*   We intialize objects after wait and driver
         driver = new ChromeDriver();
         wait = new WebDriverWait(driver, 20);
    *//*

    MainPage mainPage;
    PrettyWomenPage prettyWomenPage;
    SignInPage signInPage;
    GiftsPage giftsPage;
    BlogPage blogPage;
    PhotosPage photosPage;
    ContactsUsPage contactUsPage;
    SoftAssert softAssert = new SoftAssert();  //VID 10 16:36

    @BeforeMethod
    @Parameters({"browser", "version", "platform"})
    public void setup(String browser, String version, String platform, Method method) throws MalformedURLException {

        Reports.start(method.getName());



        //Our Objects
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

        //Local Reports
        if(testResult.getStatus() == ITestResult.FAILURE){
            Reports.fail(driver, testResult.getName());
        }
        Reports.stop();

        //Sauce Labs  -bfr closing browser, gives info passed/failed
        ((JavascriptExecutor)driver).executeScript("sauce:job-result=" + (testResult.isSuccess() ? "passed" : "failed"));
        driver.quit();
    }
}

*/

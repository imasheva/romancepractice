package com.romanceabroad.ui;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignInTest extends BaseUI {
    String actualTitle;
    String actualUrlSignIn;

    //vid 16, 19:00 Set priority - most importnat part in test annotation
    // Can identify groups - smoke test, regresiion test, production, pred production
    //ie limited
    public static final boolean testCase1 = true;

    @Test

    public void testSignInTestCase1() {
        signInPage.openSignInPage();
        actualUrlSignIn = driver.getCurrentUrl();
        actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();

        softAssert.assertEquals(actualUrlSignIn, Data.expectedUrlSignIn,  "url is wrong");
        softAssert.assertEquals(actualTitle, Data.expectedTitleSignIn,  "title is wrong");
        String actualTitle = driver.findElement(Locators.TITLE_PRETTY_WOMEN).getText();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        signInPage.signIn();
        softAssert.assertAll();


    }
}
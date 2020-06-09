package com.romanceabroad.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage extends BaseActions {


    public SignInPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void openSignInPage() {

        driver.findElement(Locators.LINK_SIGN_IN).click();

    }

    public void signIn() {

        driver.findElement(Locators.EMAIL_LOGIN).sendKeys(Data.emailSignIn);
        driver.findElement(Locators.PASSWORD_LOGIN).sendKeys(Data.passwordSignIn);
        driver.findElement(Locators.BUTTON_LOGIN).click();





    }
}

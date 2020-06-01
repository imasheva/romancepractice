package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.nio.file.Files.readAllLines;

public class RegistrationTests extends BaseUI {

    public static final boolean testCase2 = true;
    public static final boolean testCase31 = true;
    public static final boolean testCase32 = true;
    public static final boolean testCase33 = true;
    public static final boolean testCase34 = true;

    String actualTooltipMessageForInvalidEmail;
    String actuaTooltpMessageForExistingUser;
    String actualTooltipMessageForInvalidPassword;


    //Passed - Oleksii's
    @Test(dataProvider = "Registration2", dataProviderClass = DataProviders.class, priority = 1, enabled = testCase2, groups = {"user", "admin"})
    public void testRegistration2(String email, String nickname, boolean requirement) {
        System.out.println(email);
        signInPage.openSignInPage();
        mainPage.clickJoinButton();
        mainPage.completeFirstPartOfRegistration(email, Data.password);
        if (!requirement) { //Vid.20,  27:08
            Assert.assertTrue(driver.findElement(Locators.TOOLTIP_ERROR).isDisplayed());
        } else {
            mainPage.clickNextButton();
            mainPage.completeSecondPartOfRegistration(nickname, Data.phone,
                    Data.month, Data.day, Data.year, Data.city, Data.location);
        }
    }


    @Test(dataProvider = "Registration3", dataProviderClass = DataProviders.class, priority = 2, enabled = testCase31, groups = {"user", "admin"})
    public void testRegistrationForInvalidEmailTestCase31(String email, String nickname, boolean requirement) {   //Vid.20,  27:08

        System.out.println(email);
        signInPage.openSignInPage();
        mainPage.clickJoinButton();
        mainPage.completeFirstPartOfRegistration(email, Data.password);

        if (!requirement) {
            Assert.assertTrue(driver.findElement(Locators.TOOLTIP_ERROR).isDisplayed());
            actualTooltipMessageForInvalidPassword = mainPage.getErrorMessageFromTooltip();
            if (actualTooltipMessageForInvalidPassword.contains("Email is incorrect")) {
                Assert.assertEquals(actualTooltipMessageForInvalidPassword, Data.expectedTootltipMessageForInvalidEmail);
                System.out.println("Message displayed: " + actualTooltipMessageForInvalidPassword);
            } else {
                mainPage.clickNextButton(); //disabled for wrong email - doesn't redirect to next modal window
                mainPage.completeSecondPartOfRegistration(nickname, Data.phone,
                        Data.month, Data.day, Data.year, Data.city, Data.location);
            }
        }
    }


    @Test(dataProvider = "Registration4", dataProviderClass = DataProviders.class, priority = 3, enabled = testCase32, groups = {"user", "admin"})
    public void testRegistrationForExistingUserTestCase32(String email, String nickname, boolean requirement) {

        System.out.println(email);
        signInPage.openSignInPage();
        mainPage.clickJoinButton();
        mainPage.completeFirstPartOfRegistration(email, Data.password);
        if (!requirement) {
            Assert.assertTrue(driver.findElement(Locators.TOOLTIP_ERROR).isDisplayed());

            actuaTooltpMessageForExistingUser = mainPage.getErrorMessageFromTooltip();

            if (actuaTooltpMessageForExistingUser.contains("User with such email")) {

                Assert.assertEquals(actuaTooltpMessageForExistingUser, Data.expectedTootltipMessageForExistingUser);
                System.out.println("Message displayed: " + actuaTooltpMessageForExistingUser);
            } else {
                mainPage.clickNextButton(); //disabled for wrong email - doesn't redirect to next modal window
                mainPage.completeSecondPartOfRegistration(nickname, Data.phone,
                        Data.month, Data.day, Data.year, Data.city, Data.location);
            }
        }

    }

    @Test(dataProvider = "Registration5", dataProviderClass = DataProviders.class, priority = 4, enabled = testCase33, groups = {"user", "admin"})
    public void testRegistrationForInvalidPasswordTestCase33(String email, String password, boolean requirement) {

        mainPage.clickJoinButton();
        mainPage.completeFirstPartOfRegistration(email, password);
        mainPage.clickNextButton();
        mainPage.performClick(driver.findElements(By.xpath("//div[@class='g-flatty-block']")).get(1));
        mainPage.javaWaitSec(3);

        if (!requirement) {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(Locators.TOOLTIP_ERROR_PASSWORD)));

            Assert.assertTrue(driver.findElement(Locators.TOOLTIP_ERROR_PASSWORD).isDisplayed());

            actualTooltipMessageForInvalidPassword = mainPage.getValidationMessageForPassword();

            if (actualTooltipMessageForInvalidPassword.contains("Please choose a password")) {

                Assert.assertEquals(actualTooltipMessageForInvalidPassword, Data.expectedMessageForInvalidPassword);

                System.out.println("Message displayed: " + actualTooltipMessageForInvalidPassword);
            }
        } else {
            System.out.println("No error message displayed");

            mainPage.completeSecondPartOfRegistration(Data.nickname, Data.phone,
                    Data.month, Data.day, Data.year, Data.city, Data.location);
        }
    }

    @Test(dataProvider = "Registration", dataProviderClass = DataProviders.class, priority = 5, enabled = testCase34, groups = {"user", "admin"})

    public void testRegistration1(String email, String password, String phone, String month, String day, String year,
                                  String city, String location) {

        signInPage.openSignInPage();
        mainPage.clickJoinButton();

        mainPage.completeFirstPartOfRegistration(email, password);

        mainPage.clickNextButton();

        mainPage.completeSecondPartOfRegistration(Data.nickname, phone, month,
                day, year, city, location);
    }


    @Test
    public static void testBoolean() {

        boolean cond1 = true;
        boolean cond2 = false;

        System.out.println("Cond1 is: " + cond1);
        System.out.println("Cond2 is: " + cond2);

        if (cond2) {     //if it's true, do action in braces
            System.out.println("Analyzing cond2");
        }
        if (cond1) {
            System.out.println("Analyzing cond1");
        }

    }


}




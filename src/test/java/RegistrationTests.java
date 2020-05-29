import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static java.nio.file.Files.find;
import static java.nio.file.Files.readAllLines;

public class RegistrationTests extends BaseUI {

    public static final boolean testCase2 = true;

//Passed - Oleksii's
    @Test(dataProvider = "Registration2", dataProviderClass = DataProviders.class)
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

    //I created

    String expectedTootltipErrorMessage;
    String actualErrorMessage;
   //booleans vid 20, 13:03
//******************************************************************************************************

    @DataProvider(name = "Registration3")
    public static Object[][] testRegistration3() {
        return new Object[][]{
                {Data.email4, Data.nickname, false},  // email -1
                {Data.email5, Data.nickname, false},  // email - exist
                {Data.email6, Data.nickname, false},  // email - empty " "
        };
    }

    @Test(dataProvider = "Registration3", dataProviderClass = DataProviders.class)
    public void testRegistration3(String email, String nickname, boolean requirement) {

        System.out.println(email);
        signInPage.openSignInPage();
        mainPage.clickJoinButton();
        mainPage.completeFirstPartOfRegistration(email, Data.password);
        //Vid.20,  27:08
        if (!requirement) {
            Assert.assertTrue(driver.findElement(Locators.TOOLTIP_ERROR).isDisplayed());
            //if displayed -> completes TC for negative test sceanrio
            actualErrorMessage = mainPage.getErrorMessageFromTooltip();
            Assert.assertEquals(actualErrorMessage, Data.expectedTootltipMessageForInvalidPassword);

        } if (!requirement) {
            Assert.assertTrue(driver.findElement(Locators.TOOLTIP_ERROR).isDisplayed());
            //for positive tc -> contiues
            actualErrorMessage = mainPage.getErrorMessageFromTooltip();
            Assert.assertEquals(actualErrorMessage, Data.expectedTootltipMessageForExistingUser);
        } else{
            mainPage.clickNextButton(); //disabled for wrong email - doesn't redirect to next modal window
            mainPage.completeSecondPartOfRegistration(nickname, Data.phone,
                    Data.month, Data.day, Data.year, Data.city, Data.location);
        }
    }

//******************************************************************************************************


    @Test(dataProvider = "Registration", dataProviderClass = DataProviders.class)

    public void testRegistration1(String email, String password, String month, String day, String year,
                                  String phone, String city, String location) {

        signInPage.openSignInPage();
        mainPage.clickJoinButton();

        mainPage.completeFirstPartOfRegistration(email, password);

        mainPage.clickNextButton();

        mainPage.completeSecondPartOfRegistration(Data.nickname, month,
                day, year, phone, city, location);
    }


    @Test
    public static void testBoolean(){

        boolean cond1 = true;
        boolean cond2 = false;

        System.out.println("Cond1 is: " + cond1);
        System.out.println("Cond2 is: " + cond2);

        if(cond2){     //if it's true, do action in braces
            System.out.println("Analyzing cond2");
        }
        if(cond1){
            System.out.println("Analyzing cond1");
        }

    }





}




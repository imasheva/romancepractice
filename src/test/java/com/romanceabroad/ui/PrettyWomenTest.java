package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PrettyWomenTest extends BaseUI {

    String currentUrlPrettyWomen;
    String actualTitlePrettyWomen;
    String name;
    String personalInfo;
    String footerName;

    public static final boolean testCase3 = true;
    public static final boolean testCase4 = true;
    public static final boolean testCase5 = true;
    public static final boolean testCase6 = true;
    public static final boolean testCase7 = true;
    public static final boolean testCase30 = true;
    public static final boolean testCase31 = true;
    public static final boolean testCase32 = true;

    @Test(priority = 1, enabled = testCase3, groups = {"user", "admin"})
    public void testPrettyWomenPageTestCase3() {

        prettyWomenPage.openPrettyWomenPage();
        currentUrlPrettyWomen = driver.getCurrentUrl();
        prettyWomenPage.javaWaitSec(3);
        actualTitlePrettyWomen = prettyWomenPage.getAnyTitle();
        Assert.assertEquals(currentUrlPrettyWomen, Data.expectedUrlPrettyWomen);
        Assert.assertEquals(actualTitlePrettyWomen, Data.expectedTitlePrettyWomen);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test(priority = 2, enabled = testCase4, groups = {"user", "admin"})
    public void testSearchByAgeTestCase4() {

        prettyWomenPage.openPrettyWomenPage();
        prettyWomenPage.javaWaitSec(3);
        prettyWomenPage.searchByAge();
    }

    @Test(priority = 3, enabled = testCase5, groups = {"user", "admin"})
    public void testDropDownViewOptionsTestCase5() {
        prettyWomenPage.openPrettyWomenPage();
        prettyWomenPage.javaWaitSec(3);
        prettyWomenPage.selectDropDownViewOptions();
    }

    @Test(priority = 4, enabled = testCase6, groups = {"user", "admin"})

    //Vid 14, 39:42
    public void selectRandomDropDownListTestCase6() {
        prettyWomenPage.openPrettyWomenPage();
        prettyWomenPage.javaWaitSec(3);

        prettyWomenPage.selectRandomDropDownList();

        int sizeOfDropDownListSortBy = prettyWomenPage.getSizeDropDownList(Locators.DROP_DOWN_LIST_SORT_BY);
        System.out.println(sizeOfDropDownListSortBy);
        for (int i = 0; i < sizeOfDropDownListSortBy; i++) {
            prettyWomenPage.selectItemRandomDropDownOption(Locators.DROP_DOWN_LIST_SORT_BY, "Sort by");
        }
    }

    @Test(priority = 5, enabled = testCase7, groups = {"user", "admin"})
    public void selectDropDownListByAgeMinTestCase7() {

        mainPage.navigateToLink(Locators.LINK_PRETTY_WOMEN);
        prettyWomenPage.javaWaitSec(3);
        prettyWomenPage.selectDropDownListByAge();

        int size = prettyWomenPage.getSizeDropDownList(Locators.DROP_DOWN_LIST_MIN_AGE);
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            prettyWomenPage.selectItemRandomDropDownOption(Locators.DROP_DOWN_LIST_MIN_AGE, "Sort by");
        }
    }
    // HELP PLEASE!!!!! -- LOCATORS CORRECT, ALL PREVIOUS TEST CASES PASSES, IN THIS TEST CASE ERROR MESSAGE FOR BY VISIBLE TEXT METHOD
    // & CAN'T FIN LOCATORS

    //DROPDOWN LISTS MAX - MIN - SORT_BY     VIDEO 21 - Advanced TestCase Data Providers created

    @Test(dataProvider = "PrettyWomen", dataProviderClass = DataProviders.class, priority = 6, enabled = testCase30, groups = {"user", "admin"})
    public void searchDifferentResultsTestCase30(String minAge, String maxAge, String sortBy) {

        int min = Integer.parseInt(minAge);  //3. Everything you take from UI always string (vid 21, 11:28)
        int max = Integer.parseInt(maxAge);  //  -> Convert data from String to Int == have to parse it
        //Then add value to - int min

        prettyWomenPage.openPrettyWomenPage(); //search pretty women link
        //interact with dropdown list, add different values from data provider
        prettyWomenPage.javaWaitSec(3);
        prettyWomenPage.getDropDownListByText(driver.findElement(Locators.DROP_DOWN_LIST_MIN_AGE), minAge);
        prettyWomenPage.getDropDownListByText(driver.findElement(Locators.DROP_DOWN_LIST_MAX_AGE), maxAge);
        prettyWomenPage.getDropDownListByText(driver.findElement(Locators.DROP_DOWN_LIST_SORT_BY), sortBy);
        prettyWomenPage.clickSearchButton(); //click the search button

        //Vid 22, 12:00
        //1. Filter data from regions
        //2. Split data
        //3. Everything you take from UI always string (vid 22, 11:28)
        //   -> Convert data from String to Int == have to parse it

        // After we collect web elements
        List<WebElement> infoAboutUser = driver.findElements(Locators.TEXT_PRETTY_WOMEN_INFO); //names, age, region

        // System.out.println(infoAboutUser.size());

        for (int i = 0; i < infoAboutUser.size(); i++) {    // prettyWomenPage.ajaxScroll(text);
            // wait.until(ExpectedConditions.visibilityOf(text));
            if (i % 2 == 0) {

                WebElement text = infoAboutUser.get(i);
                String info = text.getText();
                String[] splittedPhrase = info.split(", ");
                String age = splittedPhrase[1];
                int ageNum = Integer.parseInt(age);

                if (min <= ageNum || ageNum <= max) {
                    System.out.println("This age: " + ageNum + " is correct");
                } else {
                    Assert.fail("Wrong age: " + ageNum);
                }

            }
            prettyWomenPage.javaWaitSec(3);
            infoAboutUser = driver.findElements(Locators.TEXT_PRETTY_WOMEN_INFO); //get elements
        }
    }

    @Test
    public void testSplit() {  //video 22, 10:10
        String info = "Number, 43";
        String[] splittedPhrase = info.split(", ");
        String age = splittedPhrase[1];
        System.out.println(age);

    }

    //Homework 23
    @Test(dataProvider = "PrettyWomenProfile", dataProviderClass = DataProviders.class, priority = 7, enabled = testCase31, groups = {"user", "admin"})
    public void testUserProfile(String minAge, String maxAge, String sortBy, String name) {

        prettyWomenPage.openPrettyWomenPage();

        prettyWomenPage.javaWaitSec(3);

        prettyWomenPage.getDropDownListByText(driver.findElement(Locators.DROP_DOWN_LIST_MIN_AGE), minAge);
        prettyWomenPage.getDropDownListByText(driver.findElement(Locators.DROP_DOWN_LIST_MAX_AGE), maxAge);
        prettyWomenPage.getDropDownListByText(driver.findElement(Locators.DROP_DOWN_LIST_SORT_BY), sortBy);
        prettyWomenPage.clickSearchButton();
        prettyWomenPage.checkPeopleFound();

        prettyWomenPage.javaWaitSec(3);   // Mojno neskolko ajax waits stavit v test case? ili odin v nachale?

        Assert.assertTrue(driver.findElement(Locators.PEOPLE_FOUND).isDisplayed(), "People found not displayd");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.LIST_PROFILE_PRETTY_WOMEN));

        prettyWomenPage.ajaxClick(driver.findElement(Locators.MAIN_USERS_RESULT));

        prettyWomenPage.selectGirlByName(name);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.DESCRIPTION_OF_PROFILE));
        Assert.assertTrue(driver.findElement(Locators.DESCRIPTION_OF_PROFILE).isDisplayed(), "Description not displayed");
        prettyWomenPage.ajaxClick(Locators.DESCRIPTION_OF_PROFILE);

        personalInfo = prettyWomenPage.verifyPersonalInformation();
        System.out.println(personalInfo);
        Assert.assertTrue(personalInfo.contains(Data.expectedGender));
        Assert.assertTrue(personalInfo.contains(Data.expectedLookingForInfo));
        Assert.assertTrue(personalInfo.contains(Data.expectedUsername));
        Assert.assertTrue(personalInfo.contains(Data.expectedDateOfBirth));
        Assert.assertTrue(personalInfo.contains(Data.expectedLocation));

    }

    // Homework 26
    @Test(dataProvider = "Footer", dataProviderClass = DataProviders.class, priority = 8, enabled = testCase32, groups = {"user", "admin"})
    public void testFooter(String footer) {
        prettyWomenPage.openPrettyWomenPage();
        prettyWomenPage.javaWaitSec(3);
        WebElement footers = driver.findElement(Locators.FOOTER_PRETTY_WOMEN_PAGE);
        prettyWomenPage.ajaxScroll(footers);
        prettyWomenPage.clickValueOfLists(Locators.FOOTER_PRETTY_WOMEN_PAGE, footer); //send data from dataprovider

       /* public void clickValueOfLists(By locator, String text) {  //CLICK -> ul/li
            List<WebElement> elements = driver.findElements(locator);
            for (int i = 0; i < elements.size(); i++) {
                WebElement elementOfList = elements.get(i);
                String value = elementOfList.getText();
                if (value.contains(text)) {
                    elementOfList.click();
                }
            }
        }*/

        if(footer.contains("ContactUs")){
            Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Contact administrator')]")).isDisplayed());
        }else if(footer.contains("Sitemap")){
            Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Site map')]")).isDisplayed());
        }else if(footer.contains("How it works")){
            Assert.assertTrue(driver.findElement(By.xpath("//div[@class='title col-xs-12 col-sm-6 col-md-9 col-lg-9']")).isDisplayed());
        }else if(footer.contains("Privacy")){
            Assert.assertTrue(driver.findElement(By.xpath("//div[@class='title col-xs-12 col-sm-6 col-md-9 col-lg-9']")).isDisplayed());
        }else if(footer.contains("Terms of use")){
            Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Terms of use')]")).isDisplayed());
        }


/*
        List<WebElement> footerList = prettyWomenPage.checkEachFooterItem();

        for (int i = 0; i < footerList.size(); i++) {

            footerName = footerList.get(i).getText();
            System.out.println(footerName);

            prettyWomenPage.javaWaitSec(3);

            if (footerName.contains("Contact us")) {
                System.out.println(footerName);
                prettyWomenPage.ajaxClick(footerList.get(i));
                break;
            }
            prettyWomenPage.javaWaitSec(3);
            footerList = driver.findElements(Locators.FOOTER_PRETTY_WOMEN_PAGE);
        }*/


    }

}









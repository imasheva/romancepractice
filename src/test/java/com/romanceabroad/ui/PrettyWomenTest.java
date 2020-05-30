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

    public static final boolean testCase3 = true;
    public static final boolean testCase4 = true;
    public static final boolean testCase5 = true;
    public static final boolean testCase6 = true;
    public static final boolean testCase7 = true;
    public static final boolean testCase30 = true;

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

    @Test(dataProvider = "PrettyWomen", dataProviderClass = DataProviders.class, priority =3, enabled = testCase30, groups = {"user", "admin"})
    public void searchDifferentResultsTestCase30(String minAge, String maxAge, String sortBy) {

        int min = Integer.parseInt(minAge);
        int max = Integer.parseInt(maxAge);

        prettyWomenPage.openPrettyWomenPage();
        prettyWomenPage.javaWaitSec(3);


        prettyWomenPage.getDropDownListByText(driver.findElement(Locators.DROP_DOWN_LIST_MIN_AGE), minAge);

        prettyWomenPage.getDropDownListByText(driver.findElement(Locators.DROP_DOWN_LIST_MAX_AGE), maxAge);

        prettyWomenPage.getDropDownListByText(driver.findElement(Locators.DROP_DOWN_LIST_SORT_BY), sortBy);

        prettyWomenPage.clickSearchButton();

        List<WebElement> infoAboutUser = driver.findElements(Locators.TEXT_PRETTY_WOMEN_INFO);
        System.out.println(infoAboutUser.size());
        for (int i = 0; i < infoAboutUser.size(); i++) {

            if(i % 2==0) {

                WebElement text = infoAboutUser.get(i);
                // prettyWomenPage.ajaxScroll(text);
                wait.until(ExpectedConditions.visibilityOf(text));
                String info = text.getText();
                String[] splittedPhrase = info.split(", ");
                String age = splittedPhrase[1];
                int ageNum = Integer.parseInt(age);
                if(min <= ageNum || ageNum <= max){
                    System.out.println("This age: " + ageNum + " is correct");
                }else{
                    Assert.fail("Wrong age: " + ageNum);
                }

                System.out.println(age);
            }
            prettyWomenPage.javaWaitSec(3);
            infoAboutUser = driver.findElements(Locators.TEXT_PRETTY_WOMEN_INFO);
        }
    }
        @Test
        public void testSplit(){  //video 22, 10:10
            String info = "Name, 23";
            String[] splittedPhrase = info.split(", ");
            String age = splittedPhrase[1];
            System.out.println(age);

        }

    }

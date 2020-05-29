package com.romanceabroad.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrettyWomenTest extends BaseUI {

    String currentUrlPrettyWomen;
    String actualTitlePrettyWomen;

    public static final boolean testCase3 = true;
    public static final boolean testCase4 = true;
    public static final boolean testCase5 = true;
    public static final boolean testCase6 = true;
    public static final boolean testCase7 = true;

    @Test(priority = 1, enabled = testCase3, groups = {"user", "admin"})
    public void testPrettyWomenPageTestCase3() {

        prettyWomenPage.openPrettyWomenPage();
        currentUrlPrettyWomen = driver.getCurrentUrl();
        actualTitlePrettyWomen = prettyWomenPage.getAnyTitle();
        Assert.assertEquals(currentUrlPrettyWomen, Data.expectedUrlPrettyWomen);
        Assert.assertEquals(actualTitlePrettyWomen, Data.expectedTitlePrettyWomen);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test(priority = 1, enabled = testCase4, groups = {"user", "admin"})
    public void testSearchByAgeTestCase4() {

        prettyWomenPage.openPrettyWomenPage();
        prettyWomenPage.searchByAge();
    }

    @Test(priority = 2, enabled = testCase5, groups = {"user", "admin"})
    public void testDropDownViewOptionsTestCase5() {
        prettyWomenPage.openPrettyWomenPage();
        prettyWomenPage.javaWaitSec(3);
        prettyWomenPage.selectDropDownViewOptions();
    }

    @Test(priority = 3, enabled = testCase6, groups = {"user", "admin"})

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

    @Test(priority = 4, enabled = testCase7, groups = {"user", "admin"})
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
}
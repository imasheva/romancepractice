package com.romanceabroad.ui;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.nio.file.Files.readAllLines;

public class GiftsTest extends BaseUI {
    String currentUrlGifts;
    String giftRegular;
    String giftBestseller;
    String actualTitle;

    public static final boolean testCase20 = true;
    public static final boolean testCase21 = true;
    public static final boolean testCase22 = true;
    public static final boolean testCase33 = true;

    @Test(priority = 1, enabled = testCase20, groups = {"user", "admin"})

    public void testGiftsPageTestCase20() {

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        giftsPage.openGiftsPage();
        giftsPage.getTitleOfGiftsPage();
        actualTitle = giftsPage.getTitleOfGiftsPage();

        Assert.assertEquals(Data.expectedTitleGifts, actualTitle);
        currentUrlGifts = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlGifts, Data.expectedUrlGifts);
        System.out.println(currentUrlGifts);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2, enabled = testCase21, groups = {"user", "admin"})

    public void testSelectionOfBestsellersTestCase21() {
        giftsPage.openGiftsPage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        List<WebElement> bestSellersList = giftsPage.collectBestsellerList();

        System.out.println("Bestseller items size: " + bestSellersList.size());
        for (int i = 0; i < bestSellersList.size(); i++) {

            giftBestseller = bestSellersList.get(i).getText();

            if (giftBestseller.contains(Data.bestSellerItem)) {
                System.out.println(giftBestseller);
                giftsPage.ajaxClick(bestSellersList.get(i));
                break;
            }
        }
    }

    @Test(priority = 3, enabled = testCase22, groups = {"user", "admin"})
    public void testSelectionOfRegularGiftsTestCase22() {
        giftsPage.openGiftsPage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        List<WebElement> giftsRegularList = giftsPage.collectGiftsFromRegularList();
        System.out.println("Regular gifts size " + giftsRegularList.size());

        for (int i = 0; i < giftsRegularList.size(); i++) {

            giftRegular = giftsRegularList.get(i).getText();

            if (giftRegular.contains(Data.giftItemRegularList)) {
                System.out.println(giftRegular);
                giftsPage.ajaxClick(giftsRegularList.get(i));
                break;
            }
        }
    }
    /*

    // IN PROGRESS NOT SURE HOW TO PASS ARRAY OF STRINGS

        @Test(dataProvider = "Gifts", dataProviderClass = DataProviders.class,priority = 4, enabled = testCase33, groups = {"user", "admin"})
        public void testSelectionOfRegularGiftsTestDataProvider(String gift) {
            giftsPage.openGiftsPage();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

            List<WebElement> giftsRegularLists = giftsPage.collectGiftsFromRegularList();
            System.out.println("Regular gifts size " + giftsRegularLists.size());

            for (int i = 0; i < giftsRegularLists.size(); i++) {

                giftRegular = giftsRegularLists.get(i).getText();

                if (giftRegular.contains(Data.giftItemRegularList)) {
                    System.out.println(giftRegular);
                    giftsPage.ajaxClick(giftsRegularLists.get(i));
                    break;
                }
            }

        }

*/
    }


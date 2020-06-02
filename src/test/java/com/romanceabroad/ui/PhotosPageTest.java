package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PhotosPageTest extends BaseUI {
    String actualTitle;
    String actualUrlPhotos;
    String name;

    public static final boolean testCase8 = true;
    public static final boolean testCase9 = true;
    public static final boolean testCase32 = true;
    public static final boolean testCase33 = true;
    public static final boolean testCase34 = true;
    public static final boolean testCase35 = true;

    @Test(priority = 1, enabled = testCase8, groups = {"user", "admin"})
    public void testPhotosPageTestCase8() {
        photosPage.javaWaitSec(3);
        photosPage.openPhotosPage();

        actualTitle = photosPage.getAnyTitle();
        actualUrlPhotos = driver.getCurrentUrl();
        Assert.assertEquals(Data.expectedTitlePhotos, actualTitle);
        Assert.assertEquals(Data.expectedUrlPhotos, actualUrlPhotos);
        if (actualUrlPhotos.contains("#")) {
            Assert.fail("It contains restricted #");
        } else {
            System.out.println("No special character. It is good url!");
        }
    }

    @Test(priority = 2, enabled = testCase9, groups = {"admin"})
    public void checkPhotosListTestCase9() {

        photosPage.openPhotosPage();

        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.LIST_PHOTOS));

        List<WebElement> photosList = photosPage.collectPhotosList();
        System.out.println("Print size of photos list: " + photosList.size());

        for (int i = 0; i < photosList.size(); i++) {
            name = photosList.get(i).getText();

            if (name.contains(Data.nameOnPhoto) || name.contains(Data.nameOnPhoto2)) {
                System.out.println(name);
                mainPage.ajaxClick(photosList.get(i));
                System.out.println("Found!!!");
                break;
            }
        }
    }

    @Test(priority = 3, enabled = testCase32, groups = {"admin"})
    public void testUserTabs() {       //Vid 22  54:00
        photosPage.clickPhotosTab();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.LIST_PHOTOS));

        List<WebElement> userTabs = driver.findElements(Locators.LINK_TAB_USER_PROFILE);
        actualTitle = photosPage.getAnyTitle();
        Assert.assertEquals(actualTitle, Data.expectedTitlePhotos);

        for (int i = 0; i < userTabs.size(); i++) {
            userTabs.get(i).click();
            actualTitle = photosPage.getAnyTitle();
            if (i == 0) {
                Assert.assertEquals(actualTitle, Data.expectedTitleGallery);
            } else if (i == 1) {
                Assert.assertEquals(actualTitle, Data.expectedTitlePhotoGallery);
            } else if (i == 2) {
                Assert.assertEquals(actualTitle, Data.expectedTitleVideoGallery);
            } else if (i == 3) {
                Assert.assertEquals(actualTitle, Data.expectedTitleGalleryAlbums);
            }
            //refresh the list inside of a loop
            userTabs = driver.findElements(Locators.LINK_TAB_USER_PROFILE);
        }
    }

    @Test(priority = 4, enabled = testCase33, groups = {"admin"})
    public void testUserTabsWithMoreVerifications() {       //Vid 23
        photosPage.clickPhotosTab();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.LIST_PHOTOS));

        List<WebElement> userTabs = driver.findElements(Locators.LINK_TAB_USER_PROFILE);
        actualTitle = photosPage.getAnyTitle();
        Assert.assertEquals(actualTitle, Data.expectedTitlePhotos);

        for (int i = 0; i < userTabs.size(); i++) {
            userTabs.get(i).click();
            actualTitle = photosPage.getAnyTitle();
            if (actualTitle.contains(Data.expectedTitleGallery) || actualTitle.contains(Data.expectedTitlePhotoGallery)
                    || actualTitle.contains(Data.expectedTitleVideoGallery) || actualTitle.contains(Data.expectedTitleGalleryAlbums)) {
                System.out.println("Title is valid: " + actualTitle);
            } else {
                Assert.fail("Title is not valid");
            }
            //refresh the list inside of a loop
            userTabs = driver.findElements(Locators.LINK_TAB_USER_PROFILE);
        }
    }

    @Test(priority = 5, enabled = testCase34, groups = {"admin"})         //Vid 22  54:00, Vid 23
    public void testUserTabs2() {       //Vid 22  54:00
        photosPage.clickPhotosTab();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.LIST_PHOTOS));

        List<WebElement> userTabs = driver.findElements(Locators.LINK_TAB_USER_PROFILE);
        actualTitle = photosPage.getAnyTitle();
        Assert.assertEquals(actualTitle, Data.expectedTitlePhotos);

        for (int i = 0; i < userTabs.size(); i++) {
            userTabs.get(i).click();
            actualTitle = photosPage.getAnyTitle();
            if (i == 0) {
                Assert.assertEquals(actualTitle, Data.expectedTitleGallery);
            } else if (i == 1) {
                Assert.assertEquals(actualTitle, Data.expectedTitlePhotoGallery);
            } else if (i == 2) {
                Assert.assertEquals(actualTitle, Data.expectedTitleVideoGallery);
                photosPage.ajaxClick(Locators.VIDEO_GALLERY_FLATTY_BLOCK);

                String textMedia = driver.findElement
                        (Locators.VIDEO_GALLERY_FLATTY_BLOCK).getText();

                System.out.println(textMedia);
                if (textMedia.contains(Data.textPhotoInAlbums)) {
                    System.out.println("Text media is correct");
                }
            } else if (i == 3) {
                Assert.assertEquals(actualTitle, Data.expectedTitleGalleryAlbums);
                photosPage.ajaxClick(Locators.GALLERY_ALBUMS_MAIN_INNER_CONTAINER);
                photosPage.javaWaitSec(2);
                Assert.assertTrue(driver.findElement
                        (Locators.GALLERY_ALBUMS_DATA_CLICK_ALBUM).isDisplayed());
            }
            //refresh the list inside of a loop
            userTabs = driver.findElements(Locators.LINK_TAB_USER_PROFILE);
        }
    }

    @Test(priority = 6, enabled = testCase35, groups = {"admin"})  // Home Work 23  (vid 23)
    public void testUserTabs3() {
        photosPage.clickPhotosTab();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.LIST_PHOTOS));
        List<WebElement> userTabs = driver.findElements(Locators.LINK_TAB_USER_PROFILE);
        actualTitle = photosPage.getAnyTitle();
        Assert.assertEquals(actualTitle, Data.expectedTitlePhotos);

        for (int i = 0; i < userTabs.size(); i++) {
            userTabs.get(i).click();
            actualTitle = photosPage.getAnyTitle();
            if (i == 0) {
                Assert.assertEquals(actualTitle, Data.expectedTitleGallery);
                photosPage.ajaxClick(Locators.GALLERY_CONTAINER);
                Assert.assertTrue(driver.findElement(Locators.GALLERY_TAB_NAMES).isDisplayed());
                String tabNames = driver.findElement(Locators.GALLERY_CONTAINER).getText();

                System.out.println("Tab names for first tab verification: " + tabNames);

            } else if (i == 1) {
                Assert.assertEquals(actualTitle, Data.expectedTitlePhotoGallery);
                photosPage.ajaxClick(Locators.PHOTO_GALLERY_FLATTY_BLOCK);
                WebElement text_align = driver.findElement(Locators.PHOTO_GALLERY_TEXT_ALIGN);
                String textInside = text_align.getText();

                System.out.println("TextInside for second tab verification: " + textInside);

            } else if (i == 2) {
                Assert.assertEquals(actualTitle, Data.expectedTitleVideoGallery);
                photosPage.ajaxClick(Locators.VIDEO_GALLERY_FLATTY_BLOCK);

                String textMedia = driver.findElement
                        (Locators.VIDEO_GALLERY_FLATTY_BLOCK).getText();

                System.out.println(textMedia);

                if (textMedia.contains(Data.textPhotoInAlbums)) {

                    System.out.println("Text media is correct");
                }
            } else if (i == 3) {
                Assert.assertEquals(actualTitle, Data.expectedTitleGalleryAlbums);
                photosPage.ajaxClick(Locators.GALLERY_ALBUMS_MAIN_INNER_CONTAINER);
                photosPage.javaWaitSec(2);
                Assert.assertTrue(driver.findElement
                        (Locators.GALLERY_ALBUMS_DATA_CLICK_ALBUM).isDisplayed());
                //Removed dropdown assertion with pictures

            }
            //refresh the list inside of a loop
            photosPage.javaWaitSec(3);
            userTabs = driver.findElements(Locators.LINK_TAB_USER_PROFILE);
        }
    }


}



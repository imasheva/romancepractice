package com.romanceabroad.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PhotosPage extends BaseActions {
    public PhotosPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void openPhotosPage() {
        navigateToLink(Locators.LINK_PHOTOS_PAGE);
    }

    public void checkPhotosList() {

    }


    public List<WebElement> collectPhotosList() {

        List<WebElement> photosList = driver.findElements(Locators.LIST_PHOTOS);
        return photosList;
    }

    public void clickPhotosTab(){
        driver.findElement(Locators.LINK_PHOTOS_PAGE).click();
    }
}


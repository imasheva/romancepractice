import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PhotosPage extends BaseActions {
    public PhotosPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void verifyPhotosLinkIsDisplayed() {

        navigateToLinkPage(Locators.LINK_PHOTOS_PAGE);

    }

    public void checkPhotos() {

        navigateToLinkPage(Locators.LINK_PHOTOS_PAGE);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.LIST_PHOTOS));

        // public static final By LIST_PHOTOS = By.xpath("//div[@class='g-users-gallery__photo']//a");

        List<WebElement> photosList = driver.findElements(Locators.LIST_PHOTOS);

        System.out.println("Print size of photos list: " + photosList.size());


        for (int i = 0; i < photosList.size(); i++) {

            String info = photosList.get(i).getText();
            photosList.get(i).click();
            System.out.println(info);
        }


    }
}

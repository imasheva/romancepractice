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

    public void checkPhotosList() {

        navigateToLinkPage(Locators.LINK_PHOTOS_PAGE);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.LIST_PHOTOS));
        //    public static final By LIST_PHOTOS = By.xpath("//div[@class='g-users-gallery__info']");
        // public static final By LIST_PHOTOS = By.xpath("//div[@class='g-users-gallery__photo']//a");
       // String name = "Tanya";
        List<WebElement> photosList = driver.findElements(Locators.LIST_PHOTOS);
        System.out.println("Print size of photos list: " + photosList.size());

        for (int i = 0; i < photosList.size(); i++) {

            String info = photosList.get(i).getText();

            if (info.contains("Tanya")) {
                //photosList.get(i).click();
                ajaxClick(photosList.get(i));

                System.out.println(info + "Found Tatyana");
                break;
            }

        }


    }
}

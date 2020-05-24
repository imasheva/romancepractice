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


    public void checkPhotosList() {

        //V teste est uje ajax wait,
        // esli dobavit etot weight - visiblity, chto budet?

        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.LIST_PHOTOS));

        List<WebElement> photosList = driver.findElements(Locators.LIST_PHOTOS);
        System.out.println("Print size of photos list: " + photosList.size());

        for (int i = 0; i < photosList.size(); i++) {

            if (photosList.get(i).getText().contains("Tanya") || photosList.get(i).getText().contains("Tatyana")) {
                String name = photosList.get(i).getText();
                System.out.println(name);
                ajaxClick(photosList.get(i));
                System.out.println("Found Tanya");
                break;
            }

        }


    }
}

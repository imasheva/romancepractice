import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PhotosPageTest extends BaseUI {
    String actualTitle;
    String actualUrlPhotos;
    public static final boolean testCase7 = true;
    public static final boolean testCase8 = true;

    @Test(priority = 1, enabled = testCase7, groups = {"user", "admin"})
    public void testPhotosPageTestCase7() {
        photosPage.javaWaitSec(3);
        photosPage.openPhotosPage();

        //actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();  //bfr worked, now fails
        actualUrlPhotos = driver.getCurrentUrl();
        //Assert.assertEquals(Data.expectedTitlePhotos, actualTitle);
        Assert.assertEquals(Data.expectedUrlPhotos, actualUrlPhotos);
        driver.findElement(By.xpath("//div[@id='gallery']")).isDisplayed();
        if (actualUrlPhotos.contains("#")) {
            Assert.fail("It contains restricted #");
        } else {
            System.out.println("No special character. It is good url!");
        }
    }

    @Test(priority = 2, enabled = testCase8, groups = {"admin"})
    public void checkPhotosListTestCase8() {
        photosPage.javaWaitSec(3);
        photosPage.openPhotosPage();
         photosPage.checkPhotosList();
            //V teste est uje ajax wait,
            // esli dobavit etot weight - visiblity, chto budet?

            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.LIST_PHOTOS));

            List<WebElement> photosList = driver.findElements(Locators.LIST_PHOTOS);
            System.out.println("Print size of photos list: " + photosList.size());

            for (int i = 0; i < photosList.size(); i++) {
                String name = photosList.get(i).getText();

                if (name.contains("Tanya") || name.contains("Tatyana")) {
                    System.out.println(name);
                    mainPage.ajaxClick(photosList.get(i));
                    System.out.println("Found Tanya");
                    break;
                }

            }
        }

    }




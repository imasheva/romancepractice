import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PhotosPageTest extends BaseUI {
    String actualTitle;
    String actualUrlPhotos;
    public static final boolean testCase7 = true;
    public static final boolean testCase8 = true;

    @Test (priority = 1, enabled = testCase7, groups ={"user", "admin"})
    public void testPhotosPage() {
        photosPage.javaWaitSec(3);
        photosPage.navigateToLink(Locators.LINK_PHOTOS_PAGE);
        actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
        actualUrlPhotos = driver.getCurrentUrl();
        Assert.assertEquals(Data.expectedTitlePhotos, actualTitle);
        Assert.assertEquals(Data.expectedUrlPhotos, actualUrlPhotos);
        driver.findElement(By.xpath("//div[@id='gallery']")).isDisplayed();
        if (actualUrlPhotos.contains("#")) {
            Assert.fail("It contains restricted #");
        } else {
            System.out.println("No special character. It is good url!");
        }
    }
    @Test (priority = 1, enabled = testCase8, groups ={"admin"})
    public void checkPhotosList(){
        photosPage.javaWaitSec(3);
        photosPage.navigateToLink(Locators.LINK_PHOTOS_PAGE);
        photosPage.checkPhotosList();
        }

    }



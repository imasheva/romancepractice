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
    String name;

    public static final boolean testCase8 = true;
    public static final boolean testCase9 = true;

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

}




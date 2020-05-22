import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PhotosPageTest extends BaseUI {
    String actualTitle;
    String actualUrlPhotos;

    @Test
    public void testPhotosPage() {


        //driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        photosPage.verifyPhotosLinkIsDisplayed();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

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
    @Test
    public void checkPhotosList(){

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        photosPage.checkPhotos();
        }




    }



import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BlogPageTest extends BaseUI {
    String actualTitle;
    String actualUrlBlog;

    @Test
    public void testBlogPage() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        blogPage.verifyBlogLinkIsDisplayed();
        actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
        actualUrlBlog = driver.getCurrentUrl();

        Assert.assertEquals(Data.expectedTitleBlog, actualTitle);
        Assert.assertEquals(Data.expectedUrlBlog, actualUrlBlog);

        driver.findElement(By.xpath("//div[@class='info-content-block wysiwyg']")).isDisplayed();

        if (actualUrlBlog.contains("#")) {
            Assert.fail("It contains restricted #");
        } else {
            System.out.println("No special character. It is good url!");
        }
    }
      @Test
    public void testList(){
         // blogPage.verifyBlogLinkIsDisplayed();
          driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
          blogPage.verifyListNumber();



      }

}


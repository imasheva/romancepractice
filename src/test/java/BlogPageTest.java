import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BlogPageTest extends BaseUI {
    String actualTitle;
    String actualUrlBlog;

    public static final boolean testCase21 = true;
    public static final boolean testCase22 = true;
    public static final boolean testCase23 = true;
    public static final boolean testCase24 = true;


    @Test (priority = 1, enabled = testCase21, groups ={"user"})
    public void testBlogPage() {

        blogPage.javaWaitSec(3);
        blogPage.clickLinkBlog();

        actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
        actualUrlBlog = driver.getCurrentUrl();

        Assert.assertEquals(Data.expectedTitleBlog, actualTitle);
        Assert.assertEquals(Data.expectedUrlBlog, actualUrlBlog);

        if (actualUrlBlog.contains("#")) {
            Assert.fail("It contains restricted #");
        } else {
            System.out.println("No special character. It is good url!");
        }
    }

    @Test (priority = 1, enabled = testCase22, groups ={"user"})
    //VIDEO 11, 27:55
    public void testBlogPageListOfLinksOnRight() {
        // blogPage.verifyBlogLinkIsDisplayed();
        blogPage.javaWaitSec(3);
        blogPage.clickLinkBlog();
        blogPage.testBlogPageListOnRight();

    }

    @Test (priority = 1, enabled = testCase23, groups ={"user"})
    public void testBlogPageListOfLinksOnLeft() {
        mainPage.navigateToLink(Locators.LINK_BLOG);
        blogPage.testBlogPageLinksonOnLeft();
    }


    @Test (priority = 1, enabled = testCase24, groups ={"user"})
    public void testLinksBlogPage() {
        mainPage.navigateToLink(Locators.LINK_BLOG);
        blogPage.checkLinksOnWebPage("//a", "//href");
        blogPage.checkLinksOnWebPage("//img", "//src");

    }
}


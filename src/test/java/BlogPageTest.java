import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BlogPageTest extends BaseUI {
    String actualTitle;
    String actualUrlBlog;
    String infoListOnLeft;
    String actualUrlKharkovDatingAgency;
    String infoListOnRight;

    public static final boolean testCase21 = true;
    public static final boolean testCase22 = true;
    public static final boolean testCase23 = true;
    public static final boolean testCase24 = true;


    @Test (priority = 1, enabled = testCase21, groups ={"admin"})

    public void testBlogPageTestCase21() {
        blogPage.javaWaitSec(3);
        blogPage.openLinkBlog();
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

    @Test (priority = 2, enabled = testCase22, groups ={"admin"})

    public void testBlogPageListOfLinksOnRightTestCase22() { //VIDEO 11, 27:55
        blogPage.javaWaitSec(3);
        blogPage.openLinkBlog();
        blogPage.testBlogPageListOnRight();

        List<WebElement> list = driver.findElements(Locators.BLOG_LIST_RIGHT);
        System.out.println("Size of the list on the right: " + list.size());
        mainPage.ajaxClick(Locators.RIGHT_MENU_BLOG_PAGE_CONTAINER);
        for (int i = 0; i < list.size(); i++) {
            infoListOnRight = list.get(i).getText();
            System.out.println(infoListOnRight);

            mainPage.ajaxClick(list.get(i));

            if (infoListOnRight.contains("Kharkov dating")) {
                actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
                actualUrlKharkovDatingAgency = driver.getCurrentUrl();
                Assert.assertEquals(Data.expectedTitleKharkovDatingAgency, actualTitle);
                Assert.assertEquals(Data.expectedUrlKharkovDatingAgency, actualUrlKharkovDatingAgency);

                if (actualUrlKharkovDatingAgency.contains("#")) {
                    Assert.fail("It contains restricted #");
                } else {
                    System.out.println("No special character. It is good url!");
                }
            }
            mainPage.ajaxClick(Locators.RIGHT_MENU_BLOG_PAGE_CONTAINER);
            list = driver.findElements(Locators.BLOG_LIST_RIGHT);
        }
    }



    @Test (priority = 3, enabled = testCase23, groups ={"admin"})
    public void testBlogPageListOfLinksOnLeftTestCase23() {
        mainPage.navigateToLink(Locators.LINK_BLOG);
        blogPage.testBlogPageLinksonOnLeft();

            List<WebElement> links = driver.findElements(Locators.BLOG_LIST_LEFT);
            System.out.println("Size of the list on the left" +links.size());
            mainPage.ajaxClick(Locators.LEFT_MENU_BLOG_PAGE_CONTAINER);

            for (int i = 0; i < links.size(); i++) {

                infoListOnLeft = links.get(i).getText();
                System.out.println(infoListOnLeft);
                mainPage.ajaxClick(links.get(i));

                if(infoListOnLeft.contains("Kharkov dating agency")) {
                    actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
                    actualUrlKharkovDatingAgency = driver.getCurrentUrl();
                    Assert.assertEquals(Data.expectedTitleKharkovDatingAgency, actualTitle);
                    Assert.assertEquals(Data.expectedUrlKharkovDatingAgency, actualUrlKharkovDatingAgency);

                    if (actualUrlKharkovDatingAgency.contains("#")) {
                        Assert.fail("It contains restricted #");
                    } else {
                        System.out.println("No special character. It is good url!");
                    }
                }
                mainPage.ajaxClick(Locators.LEFT_MENU_BLOG_PAGE_CONTAINER);
                links = driver.findElements(Locators.BLOG_LIST_LEFT);
            }
        }


    @Test (priority = 4, enabled = testCase24, groups ={"admin"})
    public void testLinksBlogPageTestCase24() {
        mainPage.navigateToLink(Locators.LINK_BLOG);
        blogPage.checkLinksOnWebPage("//a", "//href");
        blogPage.checkLinksOnWebPage("//img", "//src");

    }
}


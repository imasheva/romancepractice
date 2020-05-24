import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BlogPage extends BaseActions {
    public BlogPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    String infoListOnLeft;
    String actualTitle;
    String actualUrlKharkovDatingAgency;
    String infoListOnRight;

    public void clickLinkBlog() {

        navigateToLinkPage(Locators.LINK_BLOG);
        driver.findElement(By.xpath("//div[@class='info-content-block wysiwyg']")).isDisplayed();

    }

    // RIGHT LIST

    public void testBlogPageListOnRight() {

        List<WebElement> list = driver.findElements(Locators.BLOG_LIST_RIGHT);
        System.out.println("Size of the list on the right: " + list.size());

        ajaxClick(Locators.RIGHT_MENU_BLOG_PAGE_CONTAINER);

        for (int i = 0; i < list.size(); i++) {
            infoListOnRight = list.get(i).getText();
            System.out.println(infoListOnRight);
             ajaxClick(list.get(i));

            if (infoListOnRight.contains("Kharkov dating")) {   // Tolko na 1-i link sdelala assertion, a esli na each, to dolgo

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
            ajaxClick(Locators.RIGHT_MENU_BLOG_PAGE_CONTAINER);
            list = driver.findElements(Locators.BLOG_LIST_RIGHT);
        }
    }

    //  LEFT LIST
    public void testBlogPageLinksonOnLeft() {

        List<WebElement> links = driver.findElements(Locators.BLOG_LIST_LEFT);
        System.out.println("Size of the list on the left" +links.size());
        ajaxClick(Locators.LEFT_MENU_BLOG_PAGE_CONTAINER);

        for (int i = 0; i < links.size(); i++) {

            infoListOnLeft = links.get(i).getText();
            System.out.println(infoListOnLeft);
            ajaxClick(links.get(i));

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

            ajaxClick(Locators.LEFT_MENU_BLOG_PAGE_CONTAINER);
            links = driver.findElements(Locators.BLOG_LIST_LEFT);
        }
    }

    private void clickBlogMenuRight() {
        ajaxClick(Locators.RIGHT_MENU_BLOG_PAGE);
    }

    private void clickBlogMenuLeft() {
        ajaxClick(Locators.LEFT_MENU_BLOG_PAGE);
    }



}

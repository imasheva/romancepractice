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


    public void openLinkBlog() {
        navigateToLinkPage(Locators.LINK_BLOG);
    }


    public void testBlogPageListOnRight() {

    }


    public void testBlogPageLinksonOnLeft() {

    }

    private void clickBlogMenuRight() {

        ajaxClick(Locators.RIGHT_MENU_BLOG_PAGE);
    }

    private void clickBlogMenuLeft() {

        ajaxClick(Locators.LEFT_MENU_BLOG_PAGE);
    }



}

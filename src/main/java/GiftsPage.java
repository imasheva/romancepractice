import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.sql.SQLOutput;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GiftsPage extends BaseActions {

    public GiftsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void openGiftsPage() {
        driver.findElement(Locators.LINK_GIFTS_PAGE).click();
    }

    public void selectGiftsfromBestsellers() {
    }


    public void selectGiftsFromRegularList() {

    }
}

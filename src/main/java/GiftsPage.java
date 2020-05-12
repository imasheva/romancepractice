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

    String currentUrlGifts;

    public void openGiftsPage() {

        driver.findElement(Locators.LINK_GIFTS_PAGE).click();

        currentUrlGifts = driver.getCurrentUrl();

        Assert.assertEquals(currentUrlGifts, Data.expectedUrlGifts);

        System.out.println(currentUrlGifts);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void selectGiftsfromBestsellers() {

        List<WebElement> bestSellersList = driver.findElements(Locators.BESTSELLERS_LIST);

        System.out.println("Bestseller items size: " + bestSellersList.size());

        for (int i = 0; i < bestSellersList.size(); i++) {

            System.out.println("Bestseller items name: " + bestSellersList.get(i).getText()); //How to print each

            // String name =   bestSellersList.get(i).getText(); //Nado sohranyat otdelno?

            if (bestSellersList.get(i).getText().equalsIgnoreCase("Spa")) {
                bestSellersList.get(i).click();
                break;
            }
        }
    }


    public void selectGiftsFromRegularList() {

      // DO I NEED WAITS HERE IF IT'S PASSES WITHOUT IT?

      //  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        List<WebElement> giftsRegularList = driver.findElements(Locators.REGULAR_GIFTS_LIST);

        for (int i = 0; i < giftsRegularList.size(); i++) {

            String gift = giftsRegularList.get(i).getText();

            if (gift.toLowerCase().contains(Data.giftNameFromRegularList)) {
                //click on Quick view button
                driver.findElements(Locators.BUTTON_QUICK_VIEW).get(i).click();
                break;
            }
        }



    }
}

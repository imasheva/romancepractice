import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GiftsTest extends BaseUI {
    String currentUrlGifts;
    String giftRegular;
    String giftBestseller;
    String actualTitle;

    public static final boolean testCase20 = true;
    public static final boolean testCase21 = true;
    public static final boolean testCase22 = true;

    @Test(priority = 1, enabled = testCase20, groups = {"user", "admin"})

    public void testGiftsPageTestCase20() {

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        giftsPage.openGiftsPage();
        giftsPage.getTitleOfGiftsPage();
        actualTitle = giftsPage.getTitleOfGiftsPage();

        Assert.assertEquals(Data.expectedTitleGifts, actualTitle);
        currentUrlGifts = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlGifts, Data.expectedUrlGifts);
        System.out.println(currentUrlGifts);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2, enabled = testCase21, groups = {"user", "admin"})

    public void testSelectionOfBestsellersTestCase21() {
        giftsPage.openGiftsPage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        List<WebElement> bestSellersList = giftsPage.collectBestsellerList();

        System.out.println("Bestseller items size: " + bestSellersList.size());
        for (int i = 0; i < bestSellersList.size(); i++) {

            giftBestseller = bestSellersList.get(i).getText();

            if (giftBestseller.contains(Data.bestSellerItem)) {
                System.out.println(giftBestseller);
                giftsPage.ajaxClick(bestSellersList.get(i));
                break;
            }
        }
    }


    @Test(priority = 3, enabled = testCase22, groups = {"user", "admin"})
    public void testSelectionOfRegularGiftsTestCase22() {
        giftsPage.openGiftsPage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        List<WebElement> giftsRegularList = giftsPage.collectGiftsFromRegularList();
        System.out.println("Regular gifts size " + giftsRegularList.size());

        for (int i = 0; i < giftsRegularList.size(); i++) {

            giftRegular = giftsRegularList.get(i).getText();

            if (giftRegular.contains(Data.giftItemRegularList)) {
                System.out.println(giftRegular);
                giftsPage.ajaxClick(giftsRegularList.get(i));
                break;
            }
        }


    }
}

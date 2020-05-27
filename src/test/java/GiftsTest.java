import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GiftsTest extends BaseUI {
    String currentUrlGifts;

    public static final boolean testCase18 = true;
    public static final boolean testCase19 = true;
    public static final boolean testCase20 = true;

    @Test (priority = 1, enabled = testCase18, groups ={"user", "admin"})

    public void testGiftsPageTestCase18(){
        giftsPage.openGiftsPage();
        currentUrlGifts = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlGifts, Data.expectedUrlGifts);
        System.out.println(currentUrlGifts);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test (priority = 2, enabled = testCase19, groups ={"user", "admin"})
    public void testSelectionOfBestsellersTestCase19() {

        giftsPage.openGiftsPage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        giftsPage.selectGiftsfromBestsellers();

            List<WebElement> bestSellersList = driver.findElements(Locators.BESTSELLERS_LIST);

            System.out.println("Bestseller items size: " + bestSellersList.size());
            for (int i = 0; i < bestSellersList.size(); i++) {

                System.out.println("Bestseller items name: " + bestSellersList.get(i).getText()); //How to print each?

                if (bestSellersList.get(i).getText().equalsIgnoreCase(Data.bestSellerItem)) {
                    bestSellersList.get(i).click();
                    break;
                }
            }
        }


    @Test (priority = 3, enabled = testCase20, groups ={"user", "admin"})
    public void testSelectionOfRegularGiftsTestCase20(){
        giftsPage.openGiftsPage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        giftsPage.selectGiftsFromRegularList();

        List<WebElement> giftsRegularList = driver.findElements(Locators.REGULAR_GIFTS_LIST);

        for (int i = 0; i < giftsRegularList.size(); i++) {

            WebElement element = giftsRegularList.get(i);

            String gift = element.getText();

            if (gift.toLowerCase().contains(Data.giftItemRegularList)) {
                //click on Quick view button
                driver.findElements(Locators.BUTTON_QUICK_VIEW).get(i).click();
                break;
            }
        }




    }
}

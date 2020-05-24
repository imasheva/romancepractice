import org.testng.Assert;
import org.testng.annotations.Test;

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

    //I COULDN'T GET TITLE - NETU TITLE

    @Test (priority = 1, enabled = testCase19, groups ={"user", "admin"})
    public void testSelectionOfBestsellersTestCase19() {
        giftsPage.openGiftsPage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        giftsPage.selectGiftsfromBestsellers();

    }

    @Test (priority = 1, enabled = testCase20, groups ={"user", "admin"})
    public void testSelectionOfRegularGiftsTestCase20(){
        giftsPage.openGiftsPage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        giftsPage.selectGiftsFromRegularList();

    }
}

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GiftsTest extends BaseUI {
    String currentUrlGifts;

    public static final boolean testCase12 = true;
    public static final boolean testCase13 = true;
    public static final boolean testCase14 = true;

    @Test (priority = 1, enabled = testCase12, groups ={"user"})
    public void testGiftsPage() {

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

    @Test (priority = 1, enabled = testCase13, groups ={"user"})
    public void testSelectionOfBestsellers() {
        giftsPage.openGiftsPage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        giftsPage.selectGiftsfromBestsellers();

    }

    @Test (priority = 1, enabled = testCase14, groups ={"user"})
    public void testSelectionOfRegularGifts(){
        giftsPage.openGiftsPage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        giftsPage.selectGiftsFromRegularList();

    }
}

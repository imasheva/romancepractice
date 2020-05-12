import org.testng.Assert;
import org.testng.annotations.Test;

public class GiftsTest extends BaseUI {
    String currentUrlGifts;

    @Test
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

    @Test
    public void testSelectionOfBestsellers() {
        giftsPage.openGiftsPage();
        giftsPage.selectGiftsfromBestsellers();

    }

    @Test
    public void testSelectionOfRegularGifts(){
        giftsPage.openGiftsPage();
        giftsPage.selectGiftsFromRegularList();

    }
}

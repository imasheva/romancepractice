import org.testng.annotations.Test;

public class GiftsTest extends BaseUI {

    @Test
    public void testGiftsPage() {

        giftsPage.openGiftsPage();
    }

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

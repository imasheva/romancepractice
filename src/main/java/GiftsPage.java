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


       // clickValueOfLists(Locators.BESTSELLERS_LIST, Data.bestSellerItem);
     /*

     //OLEKSII METHOD
      //  public void clickValueOfLists(By locator, String text) {
            List<WebElement> elements = driver.findElements(Locators.BESTSELLERS_LIST);
            for (int i = 0; i < elements.size(); i++) {

                WebElement elementOfList = elements.get(i);
                String value = elementOfList.getText();

                if (value.contains(Data.bestSellerItem)) {
                    elementOfList.click();
                }

            }
     */

        List<WebElement> bestSellersList = driver.findElements(Locators.BESTSELLERS_LIST);

        System.out.println("Bestseller items size: " + bestSellersList.size());
        for (int i = 0; i < bestSellersList.size(); i++) {

            System.out.println("Bestseller items name: " + bestSellersList.get(i).getText()); //How to print each

            if (bestSellersList.get(i).getText().equalsIgnoreCase(Data.bestSellerItem)) {
                bestSellersList.get(i).click();
                break;
            }
        }
    }


    public void selectGiftsFromRegularList() {

      // DO I NEED WAITS HERE IF IT'S PASSES WITHOUT IT?


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

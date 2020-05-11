import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseUI {


    String currentUrlSearch;
    String currentTitle;

    @Test
    public void testSearchPage() {

        driver.findElement(Locators.LINK_SEARCH).click();
        currentUrlSearch = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlSearch, Data.expectedUrlSearch);

        //Add assertions for getTitle



        /*

        System.out.println(currentUrlSearch);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }





      /*  Select select = new Select(driver.findElement(By.xpath("//div[@class='form-inline']//select")));
        select.selectByValue("date_created");
      */

      WebElement dropDownListSortBy = driver.findElement(Locators.DROP_DOWN_LIST_SORT_BY);

      searchPage.getDropDownListByValue(dropDownListSortBy, "date_created");

    }

*/

    }
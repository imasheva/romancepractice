import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PrettyWomenTest extends BaseUI {

    String currentUrlPrettyWomen;

    public static final boolean testCase3 = true;
    public static final boolean testCase4 = true;
    public static final boolean testCase5 = true;
    public static final boolean testCase6 = true;

    @Test (priority = 1, enabled = testCase3, groups ={"user", "admin"})
    public void testSearchByAge() {
        prettyWomenPage.openPrettyWomenPage();
        currentUrlPrettyWomen = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlPrettyWomen, Data.expectedUrlPrettyWomen);
        System.out.println(currentUrlPrettyWomen);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualTitle = driver.findElement(Locators.TITLE_PRETTY_WOMEN).getText();
        Assert.assertEquals(Data.expectedTitlePrettyWomen, actualTitle);
        prettyWomenPage.searchByAge();
    }

    @Test (priority = 2, enabled = testCase4, groups ={"user", "admin"})
    public void testDropDownViewOptions() {
        prettyWomenPage.openPrettyWomenPage();
        prettyWomenPage.javaWaitSec(3);
        prettyWomenPage.testDropDownSelectOptions();
    }

    @Test (priority = 3, enabled = testCase5, groups ={"user", "admin"})
    //Vid 14, 39:42
    public void selectRandomDropDownList() {
        prettyWomenPage.openPrettyWomenPage();
        prettyWomenPage.javaWaitSec(3);
        //By.xpath("//div[@class='form-inline']//select");
        int sizeOfDropDownListSortBy = prettyWomenPage.getSizeDropDownList(Locators.DROP_DOWN_LIST_SORT_BY);
        System.out.println(sizeOfDropDownListSortBy);
        for (int i = 0; i < sizeOfDropDownListSortBy; i++) {
            prettyWomenPage.selectItemRandomDropDownOption(Locators.DROP_DOWN_LIST_SORT_BY, "Sort by");
        }
    }
    @Test (priority = 4, enabled = testCase6, groups ={"user", "admin"})
    public void testDropDownListSelectByAgeMin(){
        mainPage.navigateToLink(Locators.LINK_PRETTY_WOMEN);
        prettyWomenPage.javaWaitSec(3);
        int size = prettyWomenPage.getSizeDropDownList(Locators.DROP_DOWN_LIST_MIN_AGE);
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            prettyWomenPage.selectItemRandomDropDownOption(Locators.DROP_DOWN_LIST_MIN_AGE, "Sort by");
        }
    }
}
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PrettyWomenTest extends BaseUI {

    String currentUrlPrettyWomen;
    String expectedTitlePrettyWomen;

    @Test
    public void testSearchByAge() {

        prettyWomenPage.openPrettyWomenPage();
        currentUrlPrettyWomen = driver.getCurrentUrl();

        Assert.assertEquals(currentUrlPrettyWomen, Data.expectedUrlSearch);
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

    @Test
    public void testDropDownViewOptions() {
        prettyWomenPage.openPrettyWomenPage();
        prettyWomenPage.testDropDownSelectOptions();
    }


    @Test
    public void testListViewOption() {
        prettyWomenPage.openPrettyWomenPage();
        prettyWomenPage.testListViewOption();

    }

}
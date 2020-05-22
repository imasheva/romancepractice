import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PrettyWomenTest extends BaseUI {

    String currentUrlPrettyWomen;
    String expectedTitlePrettyWomen;

    @Test
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

    @Test
    public void testDropDownViewOptions() {
        prettyWomenPage.openPrettyWomenPage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        prettyWomenPage.testDropDownSelectOptions();
    }


    @Test
    public void testListViewOption() {
        prettyWomenPage.openPrettyWomenPage();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        prettyWomenPage.testListViewOption();

    }

}
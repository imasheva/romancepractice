import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrettyWomenPage extends BaseActions {

    public PrettyWomenPage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
    }

    String currentUrlPrettyWomen;
    String expectedTitlePrettyWomen;

    public void openPrettyWomenPage() {

        driver.findElement(Locators.LINK_PRETTY_WOMEN).click();
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
    }

    public void searchByAge() {
        //MIN
        WebElement dropDownListSortByMinAge = driver.findElement(Locators.DROP_DOWN_LIST_MIN_AGE);

        getDropDownListByValue(dropDownListSortByMinAge, Data.min_Age);

        //MAX
        WebElement dropDownListSortByMaxAge = driver.findElement(Locators.DROP_DOWN_LIST_MAX_AGE);

        getDropDownListByValue(dropDownListSortByMaxAge, Data.max_Age);

        driver.findElement(Locators.BUTTON_SEARCH).click();


    }


    public void testDropDownSelectOptions() {

        // wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.DROP_DOWN_LIST_VIEW_OPTIONS));

        WebElement dropDownListViewOptions = driver.findElement(Locators.DROP_DOWN_LIST_VIEW_OPTIONS);
        getDropDownListByIndex(dropDownListViewOptions, Data.view_Option);

    }

    public void testListViewOption() {

        driver.findElement(Locators.LIST_VIEW_ICON).click();
        //how to verify result is displayed in
        ////div[@id='main_users_results'] displayed


    }
}





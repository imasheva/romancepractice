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

        WebElement dropDownListViewOptions = driver.findElement(Locators.DROP_DOWN_LIST_VIEW_OPTIONS);
        getDropDownListByIndex(dropDownListViewOptions, Data.view_Option);

    }

    public void testListViewOption() {

        driver.findElement(Locators.LIST_VIEW_ICON).click();
        //how to verify result is displayed in
        ////div[@id='main_users_results'] displayed


    }
}





import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseActions {

    protected WebDriver driver;
    protected WebDriverWait wait;


    public BaseActions(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public static String generateNewNumber(String name, int length) {
        return name + RandomStringUtils.random(length, "12345678");
    }
   public void navigateToLinkPage(By locator){
        driver.findElement(locator).click();
   }

    public void getDropDownListByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);

    }

    public void getDropDownListByText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }


    public void getDropDownListByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);

    }

    //CLICKS
    public void ajaxClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void ajaxClick(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        ajaxClick(driver.findElement(by));
    }

    //Works very good with Chrome, Firefox, not IE
    public void ajaxClick(By by, int index) {
    //  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by)); //double verification
        wait.until(ExpectedConditions.elementToBeClickable(by));
        ajaxClick(driver.findElements(by).get(index));
    }

    //Works very good with IE
    public void performClick(By locator) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click().build().perform();
    }
    public void performClick(By locator, int index) {
        WebElement element = driver.findElements(locator).get(index);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click().build().perform();
    }
    public void performClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click().build().perform();
    }
    public void clickUnselectedCheckbox(By checkbox) {
        WebElement currentCheckbox = driver.findElement(checkbox);
        if (!currentCheckbox.isSelected()) {
            ajaxClick(currentCheckbox);
        }
    }



    //SCROLLS

    public void scrollToBottomOfPage(){
        ((JavascriptExecutor)
                driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void ajaxScroll(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickValueOfLists(By locator, String text) {
        List<WebElement> elements = driver.findElements(locator);
        for (int i = 0; i < elements.size(); i++) {
            WebElement elementOfList = elements.get(i);
            String value = elementOfList.getText();
            if (value.contains(text)) {
                elementOfList.click();

            }

        }
    }


}

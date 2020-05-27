import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;

public class BaseActions {

    protected WebDriver driver;
    protected WebDriverWait wait;


    public BaseActions(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    // NAVIGATE
    public void navigateToLink(By locator) {
        ajaxClick(locator);
    }
    // GENERATE NUMBERS
    public static String generateNewNumber(String name, int length) {
        return name + RandomStringUtils.random(length, "12345678");
    }
   public void navigateToLinkPage(By locator){
        driver.findElement(locator).click();
   }


    // DROP DOWN SELECT class tag
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

    public int getSizeDropDownList(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

            Select select = new Select(driver.findElement(locator));
            return select.getOptions().size();
        } catch (NoSuchElementException e) {
            System.out.println("getSizeDropDownList error");
        }
        return 0;
    }

    public void selectItemRandomDropDownOption(By locator, String dropDownName) {
        try {
            WebElement element = driver.findElement(locator);
            //helps to scroll to the webelement
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Select select = new Select(driver.findElement(locator));
            select.selectByIndex((int) (Math.random() * (select.getOptions().size() - 1)) + 1);
            System.out.println(dropDownName + ": " + select.getFirstSelectedOption().getText());
        } catch (NoSuchElementException e) {
        }
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

    public void ajaxClick(By by, int index) {                //Works good with Chrome, Firefox, not IE
    //  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by)); //double verification
        wait.until(ExpectedConditions.elementToBeClickable(by));
        ajaxClick(driver.findElements(by).get(index));
    }

    public void performClick(By locator) {                      //Works very good with IE
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

    public void clickValueOfLists(By locator, String text) {  //CLICK -> ul/li

        List<WebElement> elements = driver.findElements(locator);
        for (int i = 0; i < elements.size(); i++) {
            WebElement elementOfList = elements.get(i);
            String value = elementOfList.getText();
            if (value.contains(text)) {
                elementOfList.click();
            }
        }
    }

    //WAITS

    public void javaWaitSec (int sec) {
        try{
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public void javaWait (int ms) {
        try{
            Thread.sleep(ms);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //SEND KEYS
    public void ajaxSendKeys(WebElement element, String text) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value','" + text + "')", element);
    }

    // LINKS TESTS
    public void checkLinksOnWebPage(String typeElement, String attribute) {
        List<WebElement> links = driver.findElements(By.xpath(typeElement));
        System.out.println("I start taking attributes on page");
        for (int i = 0; i < links.size(); i++) {
            WebElement ele = links.get(i);
            String url = ele.getAttribute(attribute); //attribute - src, href, img
            verifyLinkActive(url);
        }
        System.out.println("Total links are" + links.size());
    }
    private void verifyLinkActive(String linkUrl) {
        try {
            URL url = new URL(linkUrl); //links, imgs
            // in console -> //img  (class) or //a (href)
            HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
            httpURLConnect.setConnectTimeout(3000);
            httpURLConnect.connect();
            if (httpURLConnect.getResponseCode() == 200) {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
            } else if (httpURLConnect.getResponseCode() >= 400 && httpURLConnect.getResponseCode() <= 504) {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - " + httpURLConnect.getResponseMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getAnyTitle(){
        String title = driver.findElement(Locators.H1_TITLE).getText();
        return title;
    }


}

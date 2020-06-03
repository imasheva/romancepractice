package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PrettyWomenPage extends BaseActions {

    public PrettyWomenPage(WebDriver driver, WebDriverWait wait) { super(driver, wait); }


    public void openPrettyWomenPage() {

        driver.findElement(Locators.LINK_PRETTY_WOMEN).click();
    }

    public void clickPrettyWomen(){

        driver.findElement(Locators.LINK_PRETTY_WOMEN).click();

    }







    public void searchByAge() {

        WebElement dropDownListSortByMinAge = driver.findElement(Locators.DROP_DOWN_LIST_MIN_AGE);
        getDropDownListByValue(dropDownListSortByMinAge, Data.min_Age);

        WebElement dropDownListSortByMaxAge = driver.findElement(Locators.DROP_DOWN_LIST_MAX_AGE);
        getDropDownListByValue(dropDownListSortByMaxAge, Data.max_Age);

        driver.findElement(Locators.BUTTON_SEARCH).click();
    }


    public void selectDropDownViewOptions() {

        WebElement dropDownListViewOptions = driver.findElement(Locators.DROP_DOWN_LIST_VIEW_OPTIONS);
        getDropDownListByIndex(dropDownListViewOptions, Data.view_Option);
    }

    public void selectDropDownListByAge() {

    }

    public void selectRandomDropDownList() {
    }


    public void clickSearchButton(){
        driver.findElement(Locators.BUTTON_SEARCH).click();
    }


    public String checkPeopleFound() {

        String numberOfPeopleFound = driver.findElement(By.xpath("//div[@class='lh30']")).getText();
        System.out.println(numberOfPeopleFound);

        return numberOfPeopleFound;
    }

    public List<WebElement> collectProfileList() {
        List<WebElement> profileList = driver.findElements(Locators.LIST_PROFILE_PRETTY_WOMEN);
        return profileList;
    }

    public void selectGirlByName(String name) {

        List<WebElement> profileList = collectProfileList();

        System.out.println(profileList.size());


        for (int i = 0; i < profileList.size(); i++) {
            name = profileList.get(i).getText();

            if (name.contains(name))  {
                System.out.println(name);
                ajaxClick(profileList.get(i));
                profileList.get(i).click();
                System.out.println("Found girl name: " + name);
                break;
            }
        }


    }




    public String verifyPersonalInformation() {
      String  personalDetail = driver.findElement(Locators.DESCRIPTION_OF_PROFILE).getText();

   return personalDetail;
    }

    public List<WebElement> checkEachFooterItem() {
        List<WebElement> footerList = driver.findElements(Locators.FOOTER_PRETTY_WOMEN_PAGE);
        return footerList;
    }
}





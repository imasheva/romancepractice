package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Conditions extends BaseUI{

    // VIDEO 9
    @Test
  public void test11(){

      //2 conditions - 2 actions - clicks, phrase
      String fruit1 =  "orange";  //for string use " CONTAINS "
      String fruit2 =  "kiwi";  //for string use " CONTAINS "

      if(fruit1.contains("kiwi")){
          System.out.println(" We can find our fruit 1!");
      } if(fruit2.contains("orange")){
            System.out.println("We can find fruit 2");
        }
      else{
          System.out.println("We can't find fruit");
      }
}
    // IF WITH STRINGS     // if 1 ACTION - 2 CONDITIONS

      @Test
      public void oneConditionTwoActions(){

        String fruit1 = "banana";
        String fruit2 = "cherry";
                              //  || or operator
        if (fruit1.contains("banana") && fruit2.contains("cherry")){  //2 conditions should be valid,
                                                                     // if not moves to else
            System.out.println();
        }else{
            Assert.fail("We can't find fruit");
        }
      }
      // IF WITH INETEGERS
      @Test
      public void conditionsWithIntegers(){

        int number1 = 10;
        int number2 = 10;
        int sum;

        if (number1 == number2){
            sum = 95+100;
        }else{
            sum = 100-95;
        }
          System.out.println(sum);
      }

    @Test
    public void test3(){

        boolean requirement = false;
        if(!requirement){  // ! - false
            System.out.println("Boolean is true");
        }else{
            Assert.fail("Boolean is false");
        }
    }
          // HOW TO USE FOR WEB ELEMENT
    @Test
     // CONDITION FOR WEB ELEMENT
    public void test4(){

        WebElement tabSearch = driver.findElement(Locators.LINK_PRETTY_WOMEN);

      //  if (tabSearch.isDisplayed()){
     //   if(driver.findElement(Locators.LINK_PRETTY_WOMEN).getText().contains("PRETTY WOMAN")){

         if (tabSearch.getText().contains("PRETTY WOMEN")){
            tabSearch.click();

        }else{
            Assert.fail(("We can't find pretty women tab"));
        }
    }

    @Test
    public void test5(){

        mainPage.clickJoinButton();

        WebElement checkbox = driver.findElement((Locators.CHECKBOX_CONFIRMATION));

        if(!checkbox.isSelected()){
            checkbox.click();
            System.out.println("Checkbox is selected");
        }
    }
    @Test
    public void test6(){

        List <Integer> crunchifyList = new ArrayList<>(Arrays.asList(5, 10, 19));
        crunchifyList.add(10);

        System.out.println(crunchifyList);

        for (int i = 0; i<crunchifyList.size(); i++){
            int element = crunchifyList.get(i);
           // System.out.println(element);
           // System.out.println(crunchifyList.size());
        }

    }
    @Test
    public void test7(){

        List <String> crunchifyList = new ArrayList<>(Arrays.asList("apple", "kiwi", "orange"));

        crunchifyList.add("melon");
        System.out.println(crunchifyList);

        for (int i = 0; i<crunchifyList.size(); i++){
            String element = crunchifyList.get(i);
            // System.out.println(element);
            // System.out.println(crunchifyList.size());
            if (element.contains("me")){
                System.out.println("Melon inside list");
            }
        }

    }
    @Test
    public void test8(){

        String phrase = "Melon is inside list";
        List <String> crunchifyList = new ArrayList<>(Arrays.asList("apple", "kiwi", phrase));
        crunchifyList.add("melon");
        System.out.println(crunchifyList); //keep outside, if inside -> prints 4 times


        for (int i = 0; i<crunchifyList.size(); i++){

            String element = crunchifyList.get(i);
             System.out.println(i + " iteration");

            // System.out.println(crunchifyList.size());
            if (element.contains("Me")){
                System.out.println(phrase);
                continue;  //skipps the last 3 conditions
                //break; immediately completes the loop after first iteration
            }
            if (element.contains("orange")){
                System.out.println("Orange");
            }
            if (element.contains("i")){
                System.out.println("IIII");
            }else{
                System.out.println("bad loop");
            }
        }

    }
    @Test
    public void test9(){

        List <WebElement> links = driver.findElements(By.xpath("//ul[@class='navbar-nav']//li"));
        System.out.println(links.size());

        for (int i = 0; i < links.size(); i++){
            String info = links.get(i).getText();
            System.out.println(info);
            links.get(i).click();
            /*if(info.contains("WORK")){
            }*/
            driver.get(Data.mainUrl);
            links = driver.findElements(By.xpath("//ul[@class='navbar-nav']//li"));
        }

    }
    @Test
    public void checkLinksAddAssertions() {
        String actualTitle;
        String actualUrlPrettyWomen;
        String actualUrlPhotos;
        String actualUrlGifts;
        String actualUrlTourToUkraine;
        String actualUrlBlog;
        String actualUrlSignIn;
        String info;

        List<WebElement> links = driver.findElements(Locators.TAB_OF_MAIN_PAGE);

        for (int i = 0; i < links.size(); i++) {

            info = links.get(i).getText();
            System.out.println(info);
            //links.get(i).click();
            mainPage.ajaxClick(links.get(i));  //more stable click


            if (info.contains("WORK")) {
                actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
                Assert.assertEquals(Data.expectedTitleHowWeWork, actualTitle);
            }
            if (info.contains("PRETTY WOMEN")) {

                actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
                actualUrlPrettyWomen = driver.getCurrentUrl();

                Assert.assertEquals(Data.expectedTitlePrettyWomen, actualTitle);
                Assert.assertEquals(Data.expectedUrlPrettyWomen, actualUrlPrettyWomen);
                driver.findElement(By.xpath("//a[@class='g-pic-border g-rounded']")).isDisplayed();

                if(actualUrlPrettyWomen.contains("#")){
                    Assert.fail("It contains restricted #");
                }else{
                    System.out.println("No special character. It is good url!");
                }

            }
            if(info.contains("PHOTOS")){
                actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
                actualUrlPhotos = driver.getCurrentUrl();
                Assert.assertEquals(Data.expectedTitlePhotos, actualTitle);
                Assert.assertEquals(Data.expectedUrlPhotos, actualUrlPhotos);
                driver.findElement(By.xpath("//div[@class='g-users-gallery__content']")).isDisplayed();

                if(actualUrlPhotos.contains("#")){
                    Assert.fail("It contains restricted #");
                }else{
                    System.out.println("No special character. It is good url!");
                }


            }if(info.contains("GIFTS")){
                actualUrlGifts = driver.getCurrentUrl();
                Assert.assertEquals(Data.expectedUrlGifts, actualUrlGifts);
                driver.findElement(By.xpath("//div[@class='g-users-gallery__photo ']")).isDisplayed();
                if(actualUrlGifts.contains("#")){
                    Assert.fail("It contains restricted #");
                }else{
                    System.out.println("No special character. It is good url!");
                }


            }if(info.contains("TOUR")){
                actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
                actualUrlTourToUkraine = driver.getCurrentUrl();
                Assert.assertEquals(Data.expectedTitleTourToUkraine, actualTitle);
                Assert.assertEquals(Data.expectedUrlTourUkraine, actualUrlTourToUkraine);
                driver.findElement(By.xpath("//div[@class='store-content']")).isDisplayed();
                if(actualUrlTourToUkraine.contains("#")){
                    Assert.fail("It contains restricted #");
                }else{
                    System.out.println("No special character. It is good url!");
                }

            }if(info.contains("BLOG")){
                actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
                actualUrlBlog = driver.getCurrentUrl();
                Assert.assertEquals(Data.expectedTitleBlog, actualTitle);
                Assert.assertEquals(Data.expectedUrlBlog, actualUrlBlog);
                driver.findElement(By.xpath("//div[@class='info-content-block wysiwyg']")).isDisplayed();
                if(actualUrlBlog.contains("#")){
                    Assert.fail("It contains restricted #");
                }else{
                    System.out.println("No special character. It is good url!");
                }
            }if(info.contains("SIGN")){
                //   actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();   //doesn't find
                actualUrlSignIn = driver.getCurrentUrl();
                //  Assert.assertEquals(Data.expectedTitleSignIn, actualTitle);
                //   Assert.assertEquals(Data.expectedUrlSignIn, actualUrlSignIn);
                driver.findElement(By.xpath("//div[@class='lc-content-outer']")).isDisplayed();

            }

            driver.get(Data.mainUrl);
            links = driver.findElements(Locators.TAB_OF_MAIN_PAGE);

        }
    }
    @Test
    public void testScrollWithAjax(){
        mainPage.ajaxClick(driver.findElement(By.xpath("//div[@class='col-lg-12 text-center']//a[@href='#']")));
    }

    @Test
    public void testAjaxCilickByAndInt(){
     //  By linkSignIn = By.xpath("//div[@class='col-lg-12 text-center']//a[@href='#']");
     //   mainPage.ajaxClick(linkSignIn,0);
        mainPage.ajaxClick(Locators.TAB_OF_MAIN_PAGE, 3); //total 8

    }
    @Test
    public void testPerformClickByMouse(){
        mainPage.performClick(Locators.TAB_OF_MAIN_PAGE);
    }
    @Test
    public void testClickByLocatorIntIndex(){    //for list, click by index
        mainPage.performClick(Locators.TAB_OF_MAIN_PAGE, 2);

    }
    @Test
    public void scrollToTheBottomOfPage(){
        mainPage.scrollToBottomOfPage();
    }



}


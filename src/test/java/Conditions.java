import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Conditions extends BaseUI{


    @Test
    public void test() {

        String fruit1 = "kiwi";
        String fruit2 = "kiwi";

        if (fruit2.contains("kiwi") || fruit1.contains("orange")) {
            System.out.println("We can find our fruit1");

        } else {
            Assert.fail("We can't find fruit");

        }
    }

    @Test
    public void test2(){

        int number = 10;
        int sum;

        if (number==10 +5){
            sum = 95 + 100;
        }else{
            sum = 100-95;
        }
        System.out.println(sum);
    }

    @Test
    public void test3(){

        boolean requirement = true;
        if(!requirement){  // ! - false
            System.out.println("Boolean is true");
        }else{
            Assert.fail("Boolean is false");
        }
    }

    @Test
    public void test4(){
        WebElement tabSearch = driver.findElement(Locators.LINK_PRETTY_WOMEN);

        if (tabSearch.isDisplayed()){ // if (tabSearch.getText().contains("PRETTY WOMEN"))
            tabSearch.click();
        }else{
            Assert.fail(("We can't find pretty women tab"));
        }
    }
    @Test
    public void test5(){

        mainPage.clickJoinButton();

        WebElement checkbox = driver.findElement((Locators.BUTTON_NEXT));

        if(!checkbox.isSelected()){
            checkbox.click();

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

        List <WebElement> links = driver.findElements(By.xpath("//ul@class='navbar-nav']//li"));

        System.out.println(links.size());

        for (int i = 0; i < links.size(); i++){

            String info = links.get(i).getText();
            System.out.println(info);
            links.get(i).click();

            if(info.contains("WORK")){


            }
            driver.get(Data.mainUrl);
            links = driver.findElements(By.xpath("//ul@class='navbar-nav']//li"));

        }

    }



}


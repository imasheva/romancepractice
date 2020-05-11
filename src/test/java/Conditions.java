import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Conditions extends BaseActions{


    public Conditions(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

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
        WebDriver tabSearch = driver.findElement(Locators.LINK_SEARCH);

    }
}


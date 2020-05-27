import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class RegistrationTests extends BaseUI {

    public static final boolean testCase2 = true;

    @DataProvider(name = "Registration")

    public static Object[][] testRegistration() throws Exception{
        ArrayList<Object[]> out = new ArrayList<>();
        Files.readAllLines(Paths.get("Registration.csv")).stream().forEach(s-> {
            String[] data = s.split(",");
            out.add(new Object[]{data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]});
        });
        return out.toArray(new Object[out.size()][]);
    }


    @Test(dataProvider = "Registration")
    public void testRegistrationTestCase2() {
        signInPage.openSignInPage();
        mainPage.clickJoinButton();

        mainPage.completeFirstPartOfRegistration(Data.email, Data.password);

        mainPage.completeSecondPartOfRegistration(mainPage.generateNewNumber(Data.nickname, 5),Data.phone,
                Data.month, Data.day, Data.year, Data.city, Data.location);

    }


}




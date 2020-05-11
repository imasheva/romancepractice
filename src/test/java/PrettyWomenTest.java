import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PrettyWomenTest extends BaseUI {


    @Test
    public void testSearchByAge() {

        prettyWomenPage.openPrettyWomenPage();
        prettyWomenPage.searchByAge();

    }

    @Test
    public void testDropDownViewOptions() {
        prettyWomenPage.openPrettyWomenPage();
        prettyWomenPage.testDropDownSelectOptions();
    }


    @Test
    public void testListViewOption() {
        prettyWomenPage.openPrettyWomenPage();
        prettyWomenPage.testListViewOption();

    }

}
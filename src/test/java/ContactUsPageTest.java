import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsPageTest extends BaseUI {

    String currentUrlContactUsPage;
    String actualTitleContactUsPage;
    public static final boolean testCase25 = true;
    public static final boolean testCase26 = true;
    public static final boolean testCase27 = true;
    public static final boolean testCase28 = true;

    @Test(priority = 2, enabled = testCase25, groups = {"user", "admin"})
    public void testContactUsPageTestCase25() {


        contactUsPage.openContactUsPage();

        currentUrlContactUsPage = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlContactUsPage, Data.expectedUrlContactUsPage);
        System.out.println(currentUrlContactUsPage);

        actualTitleContactUsPage = driver.findElement(Locators.TITLE_CONTACT_US_PAGE).getText();
        // public static final By TITLE_CONTACT_US_PAGE = By.xpath("//h1"); ? Nado create generic GET_TITLE?
        Assert.assertEquals(Data.expectedTitleContactUsPage, actualTitleContactUsPage);
        System.out.println(actualTitleContactUsPage);
    }

    @Test(priority = 2, enabled = testCase26, groups = {"user", "admin"})
    public void verifySelectReasonDropDownTestCase26() {
        contactUsPage.openContactUsPage();
        contactUsPage.selectReasonDropDownContactUs();
    }

    @Test(priority = 3, enabled = testCase27, groups = {"user", "admin"})
    public void verifyDropDownListTestCase() {
        contactUsPage.openContactUsPage();
        contactUsPage.verifySizeOfDropDownList();
        contactUsPage.javaWaitSec(4);

        int sizeOfDropDownListReasonOnContactUsPage = contactUsPage.getSizeDropDownList(Locators.DROP_DOWN_REASON_CONTACT_US);
        System.out.println(sizeOfDropDownListReasonOnContactUsPage);

        for (int i = 0; i < sizeOfDropDownListReasonOnContactUsPage; i++) {
            contactUsPage.selectItemRandomDropDownOption(Locators.DROP_DOWN_REASON_CONTACT_US, "Reason");
        }

    }

    @Test(priority = 4, enabled = testCase28, groups = {"user", "admin"})
    public void fillOutContactAdministratorFormTestCase28() {
        contactUsPage.openContactUsPage();
        contactUsPage.selectReasonDropDownContactUs();
        // nado javawait ili ne nado pered zapolneniem multiple input fields?
        contactUsPage.javaWaitSec(4);
        contactUsPage.fillOutContactAdministratorForm(mainPage.generateNewNumber(Data.yourname, 5), Data.youremail, Data.subject, Data.message);

    }


}



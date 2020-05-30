package com.romanceabroad.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

import static java.nio.file.Files.readAllLines;

public class ContactUsPageTest extends BaseUI {

    String currentUrlContactUsPage;
    String actualTitleContactUsPage;
    public static final boolean testCase23 = true;
    public static final boolean testCase24 = true;
    public static final boolean testCase25 = true;
    public static final boolean testCase26 = true;
    public static final boolean testCase31 = true;

    @Test(priority = 1, enabled = testCase23, groups = {"user", "admin"})
    public void testContactUsPageTestCase23() {
        contactUsPage.openContactUsPage();
        currentUrlContactUsPage = driver.getCurrentUrl();
        actualTitleContactUsPage = contactUsPage.getAnyTitle();
        Assert.assertEquals(currentUrlContactUsPage, Data.expectedUrlContactUsPage);
        Assert.assertEquals(Data.expectedTitleContactUsPage, actualTitleContactUsPage);
    }

    @Test(priority = 2, enabled = testCase24, groups = {"user", "admin"})
    public void verifySelectReasonDropDownTestCase24() {
        contactUsPage.openContactUsPage();
        contactUsPage.selectReasonDropDownContactUs();
    }

    @Test(priority = 3, enabled = testCase25, groups = {"user", "admin"})
    public void verifyDropDownListTestCase25() {
        contactUsPage.openContactUsPage();
        contactUsPage.verifySizeOfDropDownList();
        contactUsPage.javaWaitSec(4);

        int sizeOfDropDownListReasonOnContactUsPage = contactUsPage.getSizeDropDownList(Locators.DROP_DOWN_REASON_CONTACT_US);
        System.out.println(sizeOfDropDownListReasonOnContactUsPage);

        for (int i = 0; i < sizeOfDropDownListReasonOnContactUsPage; i++) {
            contactUsPage.selectItemRandomDropDownOption(Locators.DROP_DOWN_REASON_CONTACT_US, "Reason");
        }
    }


  //HW 19

    @Test(dataProvider = "ContactUs", dataProviderClass = DataProviders.class, priority = 4, enabled = testCase31, groups = {"user", "admin"})
    public void fillOutContactAdministratorForm(String youremail, String subject, String message) {
        contactUsPage.openContactUsPage();
        contactUsPage.selectReasonDropDownContactUs();
        contactUsPage.javaWaitSec(3);
        contactUsPage.fillOutContactAdministratorForm(mainPage.generateNewNumber(Data.yourname, 5),
                youremail, subject, message);
    }


    //HW 18

    @Test(priority = 5, enabled = testCase26, groups = {"user", "admin"})
    public void fillOutContactAdministratorFormTestCase26() {
        contactUsPage.openContactUsPage();
        contactUsPage.selectReasonDropDownContactUs();
        contactUsPage.javaWaitSec(3);
        contactUsPage.fillOutContactAdministratorForm(mainPage.generateNewNumber(Data.yourname, 5),
                Data.youremail, Data.subject, Data.message);

    }


}



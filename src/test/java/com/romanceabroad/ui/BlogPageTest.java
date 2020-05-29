package com.romanceabroad.ui;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class BlogPageTest extends BaseUI {
    String actualTitle;
    String actualUrlBlog;
    String articleName;
    String actualUrlKharkovDatingAgency;
    String infoListOnRight;
    String nameOfArticle;
    String titleOfArticle;
    String titleOfArticleOnRight;

    public static final boolean testCase27 = true;
    public static final boolean testCase28 = true;
    public static final boolean testCase29 = true;


    @Test(priority = 1, enabled = testCase27, groups = {"admin"})

    public void testBlogPageTestCase27() {
        blogPage.javaWaitSec(3);
        blogPage.openLinkBlog();
        actualTitle = blogPage.getAnyTitle();
        actualUrlBlog = driver.getCurrentUrl();
        Assert.assertEquals(Data.expectedTitleBlog, actualTitle);
        Assert.assertEquals(Data.expectedUrlBlog, actualUrlBlog);
        if (actualUrlBlog.contains("#")) {
            Assert.fail("It contains restricted #");
        } else {
            System.out.println("No special character. It is good url!");
        }
    }


    // A lot of repeatable data in UL//li - good for autamtion & Vid 18 StaleElementReferenceException: 38.08 explains
    @Test(priority = 4, enabled = testCase28, groups = {"admin"})

    public void testArticlesAndTitlesTestCase28() {
        blogPage.clickTabBlog();
        blogPage.javaWaitSec(3);

        List<WebElement> linksOfArticles = blogPage.collectAllLinksOfArticles(); //= driver.findElements(Locators.LINKS_OF_ARTICLES);
        System.out.println("Size of the articles " + linksOfArticles.size());

        for (int i = 0; i < linksOfArticles.size(); i++) {
            WebElement link = linksOfArticles.get(i);
            nameOfArticle = link.getText();              // if can't get text, can't collect list,
                                              // can use wait -expected condition or collect list after each iteration

            if (nameOfArticle.contains("How it works")) {    //verify in dev tools
            }
            else if (nameOfArticle.contains("Kharkov dating agency")) {
            }
            else if (nameOfArticle.contains("Kiev dating agency")) {
            }
            else if (nameOfArticle.contains("Odessa dating agency")) {
            }
            else if (nameOfArticle.contains("Mail order girls")) {
            }
            else if (nameOfArticle.contains("Beautiful urkainian girls")) {
            }
            else if (nameOfArticle.contains("Real Ukrainian brides")) {
            }
            else if (nameOfArticle.contains("Eastern European women")) {
            }
            else if (nameOfArticle.contains("Marriage agency in Ukraine")) {
            }
            else if (nameOfArticle.contains("Kiev dating site")) {
            }
            else if (nameOfArticle.contains("Find Ukrainian girlfriend")) {
            }
            else if (nameOfArticle.contains("Slavic women for marriage")) {
            }
            else if (nameOfArticle.contains("Slavic women for marriage")) {
            }
            else if (nameOfArticle.contains("How to marry Ukrainian lady")) {
            }
            else if (nameOfArticle.contains("Free Ukrainian dating site")) {
            }
            else if (nameOfArticle.contains("9 Factors to Keep in Mind When Dating a Ukrainian Woman")) {
            }
            else if (nameOfArticle.contains("Is There a Difference Between Dating or Courting a Ukrainian Woman?")) {
            }

            else {                             //vid 18, 53:31 if condit not satisfied don't click & collect list again
                                               // why we don't collect -> cause didn't click
                link.click();
                titleOfArticle = blogPage.getAnyTitle();
                Assert.assertEquals(nameOfArticle, titleOfArticle);
                //  - >  *****   can use wait -expected condition or collect list after each iteration
                linksOfArticles = blogPage.collectAllLinksOfArticles();
                //if it not helps, can add explicit wait w/expected condition
            }
        }
    }
    @Test(priority = 3, enabled = testCase29, groups = {"admin"})
    public void testLinksBlogPageTestCase29() {
        mainPage.navigateToLink(Locators.LINK_BLOG);
        blogPage.checkLinksOnWebPage("//a", "//href");
        blogPage.checkLinksOnWebPage("//img", "//src");
    }

}



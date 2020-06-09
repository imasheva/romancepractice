package com.romanceabroad.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BlogPage extends BaseActions {
    public BlogPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void openLinkBlog() {
        navigateToLinkPage(Locators.LINK_BLOG);
    }


    public void testBlogPageListOnRight() {

    }


    public void testBlogPageLinksonOnLeft() {

    }

    private void clickBlogMenuRight() {

        ajaxClick(Locators.RIGHT_MENU_BLOG_PAGE);
    }

    private void clickBlogMenuLeft() {

        ajaxClick(Locators.LEFT_MENU_BLOG_PAGE);
    }

    //Video 18 10:00 A lot of repeatable data - good for autamtion

    public List<WebElement> collectAllLinksOfArticles() {  //Video 18, 28:34 instead of void return List

        List<WebElement> linksOfArticles = driver.findElements(Locators.LINKS_OF_ARTICLES);
        return linksOfArticles;
    }


    public void clickTabBlog() {
        driver.findElement(Locators.LINK_BLOG).click();
    }


    public List<WebElement> collectAllArticlesInBlogRightMenu() {

        List<WebElement> linksOfArticlesOnRight = driver.findElements(Locators.BLOG_LIST_RIGHT);
        return linksOfArticlesOnRight;

    }
}

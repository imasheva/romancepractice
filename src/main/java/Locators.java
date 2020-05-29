import org.openqa.selenium.By;

public class Locators {

   public static final By H1_TITLE = By.xpath("//h1");

    //MAIN PAGE
    public static final By LINK_HOME = By.xpath("//a[contains(text(),'HOME')]");
    //TABS ON MAIN PAGE
    public static final By TAB_OF_MAIN_PAGE = By.xpath("//ul[@class='navbar-nav']//li/a");

    //not the best solution just for example
    //  public static final By TAB_OF_MAIN_PAGE = By.cssSelector("ul[class='navbar-nav'] >li>a");


    public static final By TITLE_OF_PAGE = By.xpath("//h1");
    public static final By HEADER_ROMANCE_ABROAD = By.xpath("//a//img[@src='/img/logo.jpg']");

    public static final By IFRAME = By.xpath("//iframe[@src='https://www.youtube.com/embed/RRECuJzm3IY?start=85']");
    public static final By YOUTUBE_PLAY_BUTTON = By.cssSelector("button.ytp-large-play-button.ytp-button");
    public static final By BUTTON_REGISTRATION = By.cssSelector("#show-registration-block");

    public static final By CHECKBOX_CONFIRMATION = By.cssSelector("#confirmation");
    public static final By AUTOFILLING_FORM_LOCATION = By.xpath("//input[@name='region_name']");
    public static final By LIST_VALUE_LOCATION = By.xpath("//div[@class='dropdown dropdown_location']//ul//li");


    public static final By BOOK_NOW_TAB = By.xpath("//div[@class='discountalert']");

    //Registration part1
    public static final By TEXT_FIELD_EMAIL = By.cssSelector("#email");
    public static final By TEXT_FIELD_PASSWORD = By.cssSelector("#password");
    public static final By BUTTON_NEXT_REGISTRATION= By.xpath("//button[@data-action='next-page'][text()='Next']");
    public static final By TOOLTIP_ERROR= By.xpath("//div[@class='tooltip']");


    //Registration part2
    public static final By TEXT_FIELD_NICKNAME = By.cssSelector("#nickname");
    public static final By TEXT_FIELD_PHONE = By.cssSelector("[name='data[phone]'");

    //Boostrap dropdown for myself **diff-nt xpath
    public static final By DAY_LIST_DROPDOWN = By.xpath("//div[@id='daySelect']//ul//li");
    public static final By MONTH_LIST_DROPDOWN = By.xpath("//div[@id='monthSelect']//ul/li");
    public static final By YEAR_LIST_DROPDOWN = By.xpath("//div[@id='yearSelect']//ul/li");


    public static final By LIST_DAYS = By.xpath("//div[@id='daySelect']");     // By.cssSelector("#daySelect");
    public static final By LIST_MONTHS = By.xpath("//div[@id='monthSelect']"); //  By.cssSelector("#monthSelect");
    public static final By LIST_YEARS = By.xpath("//div[@id='yearSelect']");  // By.cssSelector("#yearSelect");


    public static final By LIST_VALUE_DAY = By.xpath("//li[@data-handler='selectDay']");
    public static final By LIST_VALUE_MONTH = By.xpath("//li[@data-handler='selectMonth']");
    public static final By LIST_VALUE_YEAR = By.xpath("//li[@data-handler='selectYear']");


    //PRETTY WOMEN page

    public static final By LINK_PRETTY_WOMEN = By.cssSelector("a[href='https://romanceabroad.com/users/search']");
    public static final By TITLE_PRETTY_WOMEN = By.xpath("//h1");


    public static final By DROP_DOWN_LIST_MIN_AGE = By.xpath("//div[@class='col-xs-5 no-padding-left']//select");
    public static final By DROP_DOWN_LIST_MAX_AGE = By.xpath("//div[@class='col-xs-5 no-padding-right']//select");
    //public static final By DROP_DOWN_MAX_AGE = By.cssSelector("select#age_max");

    public static final By BUTTON_SEARCH = By.cssSelector("#main_search_button_user_advanced");
    public static final By DROP_DOWN_LIST_VIEW_OPTIONS = By.xpath("//div[@class='form-inline']//select");
    public static final By LIST_VIEW_ICON = By.xpath("//a[contains(text(),'List view')]");
    public static final By DROP_DOWN_LIST_SORT_BY = By.xpath("//div[@class='form-inline']//select");

    //SIGN IN page
    public static final By LINK_SIGN_IN = By.xpath("//a[@href='https://romanceabroad.com/users/login_form']");
    public static final By TITLE_SIGN_IN = By.xpath("//h1");
    public static final By EMAIL_LOGIN = By.xpath("//div[@class='col-xs-8']//input[@id='email']");
    public static final By PASSWORD_LOGIN = By.xpath("//div[@class='col-xs-8']//input[@id='password']");
    public static final By BUTTON_LOGIN = By.xpath("//div[@class='col-xs-8']//input[@id='password']");


    //GIFTS

    public static final By LINK_GIFTS_PAGE = By.cssSelector("a[href='https://romanceabroad.com/store/category-sweets']");
    public static final By BESTSELLERS_LIST = By.xpath("//div[@class='g-users-gallery__item col-xs-4 col-md-3 col-lg-2 bestseller']");

    public static final By REGULAR_GIFTS_LIST = By.cssSelector(".col-xs-6.col-sm-6.col-md-3.b-store-list__item");

    public static final By TITLE_GIFT_PAGE = (By.xpath("//*[@class='title']"));

    //Media page
    public static final By LINK_MEDIA = By.cssSelector("a[href='https://romanceabroad.com/media/index']");

    //Blog page
    public static final By LINK_BLOG = By.cssSelector("a[href='https://romanceabroad.com/content/view/blog']");
    public static final By BLOG_LIST_RIGHT = By.xpath("//div[@class='info-content-block wysiwyg']//ul//li//a");
    public static final By RIGHT_MENU_BLOG_PAGE = By.xpath("//div[@class='info-content-block wysiwyg']");
    public static final By RIGHT_MENU_BLOG_PAGE_CONTAINER = By.xpath("//div[@class='info-content-block wysiwyg']");


    public static final By BLOG_LIST_LEFT = By.xpath("//div[@class='inside account_menu']//ul//li//a");
    public static final By LINKS_OF_ARTICLES = By.xpath("//ul[@class='nav nav-pills nav-stacked content-pages-tree']//li");

    public static final By LEFT_MENU_BLOG_PAGE = By.xpath("//div[@class='inside account_menu']");

    public static final By LEFT_MENU_BLOG_PAGE_CONTAINER = By.xpath("//div[@class='inside account_menu']");

    //Photos Page
    public static final By LINK_PHOTOS_PAGE = By.xpath("//a[@href='https://romanceabroad.com/media/index']");
    public static final By LIST_PHOTOS = By.xpath("//div[@class='g-users-gallery__item col-xs-6 col-sm-4 col-md-3 col-lg-2 big']");

    //Contact Us Page
    public static final By CONTACT_US_LINK = By.xpath("//a[@id='footer_footer-menu-help-item_footer-menu-tickets-item']//div");

    public static final By TITLE_CONTACT_US_PAGE = By.xpath("//h1");
    public static final By DROP_DOWN_REASON_CONTACT_US = By.cssSelector("select.form-control");

    public static final By TEXT_FIELD_YOUR_NAME = By.xpath("//input[@name='user_name']");
    public static final By TEXT_FIELD_YOUR_EMAIL = By.xpath("//input[@name='user_email']");
    public static final By TEXT_FIELD_SUBJECT = By.xpath("//input[@name='subject']");
    public static final By TEXT_FIELD_MESSAGE = By.xpath("//textarea[@name='message']");
    public static final By BUTTON_SEND_CONTACT_US_PAGE= By.xpath("//input[@name='btn_save']");










}   // HW 14 ADVANCED LOCATORS







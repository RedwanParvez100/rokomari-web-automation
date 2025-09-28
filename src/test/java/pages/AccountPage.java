package pages;

import org.openqa.selenium.By;

public class AccountPage extends BasePage{

    public String my_account_page_url = "https://www.rokomari.com/my-section/profile";

    public By my_profile = By.xpath("//a[normalize-space()='My Profile']");
    public By best_selling = By.xpath("//a[@class='navigation_menuItem__yDz2d active']");
    public By wish_list = By.xpath("//div[@id='js--desktop-header-container']//a[8]");
    public By following_author = By.xpath("//a[normalize-space()='Following Authors']");



}

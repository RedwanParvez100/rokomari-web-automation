package pages;

import org.openqa.selenium.By;

public class AccountPage extends BasePage{

    public String my_account_page_url = "https://www.rokomari.com/my-section/profile";
    public String success_msg_text = "Account updated successfully !";

    public By my_profile = By.xpath("//a[normalize-space()='My Profile']");
    public By best_selling = By.xpath("//a[@class='navigation_menuItem__yDz2d active']");
    public By wish_list = By.xpath("//div[@id='js--desktop-header-container']//a[8]");
    public By following_author = By.xpath("//a[normalize-space()='Following Authors']");
    public By change_info_option = By.xpath("//button[normalize-space()='Change Information']");
    public By gender_dropdown = By.xpath("//select[@id='gender']");
    public By male_dropdown = By.xpath("//option[@value='male']");
    public By female_dropdown = By.xpath("//option[@value='female']");
    public By save_btn = By.xpath("//button[normalize-space()='Save']");
    public By confirm_msg = By.xpath("//div[contains(text(),'Account updated successfully')]");





}

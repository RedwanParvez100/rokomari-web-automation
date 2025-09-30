package pages;

import org.openqa.selenium.By;

public class AccountPage extends BasePage{

    public String my_account_page_url = "https://www.rokomari.com/my-section/profile";
    public String success_msg_text = "Updated Successfully";

    public By my_profile = By.xpath("//a[normalize-space()='My Profile']");
    public By best_selling = By.xpath("//a[@class='navigation_menuItem__yDz2d active']");
    public By wish_list = By.xpath("//div[@id='js--desktop-header-container']//a[8]");
    public By following_author = By.xpath("//a[normalize-space()='Following Authors']");
    public By change_info_option = By.xpath("//span[@id='js--edit-personal']");
    public By gender_dropdown = By.xpath("//select[@id='gender']");
    public By male_dropdown = By.xpath("//label[@for='customRadioInline1']");
    public By female_dropdown = By.xpath("//label[@for='customRadioInline2']");
    public By default_gender_dropdown = By.xpath("//option[normalize-space()='Select gender']");
    public By save_btn = By.xpath("//input[@id='personalInfo']");
    public By confirm_msg = By.xpath("//span[@id='userInfoChangeMsg']");

    public By set_add_password = By.xpath("//span[@id='js--edit-password']");
    public By set_new_password = By.xpath("//input[@id='newPwd']");
    public By set_confirm_password = By.xpath("//input[@id='renewPwd']");
    public By save_password_btn = By.xpath("//input[@id='js--change-social-pass']");
    public By password_confirm_msg = By.xpath("//p[contains(text(),'Your password changed successfully. Please login u')]");







}

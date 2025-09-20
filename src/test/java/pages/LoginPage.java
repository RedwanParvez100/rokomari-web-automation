package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    public By email_input_box = By.xpath("//input[@placeholder='Email or phone']");
    public  By password_input_box = By.xpath("//input[@name='password']");
    public  By login_btn = By.xpath("//button[@id='js--btn-next']");
    public By otp_btn = By.xpath("//button[@id='js--btn-next']");
    public By otp_shown_msg = By.xpath("//p[@class='validation-text success']");
    public By user_icon = By.xpath("//img[@alt='Redwan Parvez user photo']");
    public  By error_msg = By.xpath("//input[@name='password']/following-sibling::p");

    public String user_email = "feciwe6718@anlocc.com";
    public String user_password = "1234567Aa";
}

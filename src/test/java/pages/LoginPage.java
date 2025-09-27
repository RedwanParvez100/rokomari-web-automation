package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    public By sign_in_btn = By.xpath("//div[normalize-space()='Sign In']");
    public By email_input_box = By.xpath("//input[@id='emailOrPhone']");
    public  By password_input_box = By.xpath("//input[@name='password']");
    public  By next_btn = By.xpath("//button[contains(text(),'পরবর্তী')]");
    public By login_btn = By.xpath("//button[normalize-space()='Login']");
    public By otp_shown_msg = By.xpath("//p[@class='text-red-500 text-sm text-']");
    public By user_icon = By.xpath("//span[@class='truncate max-w-[110px]']");
    public  By error_msg = By.xpath("//input[@name='password']/following-sibling::p");

    public By sign_in_page_title = By.xpath("//h1[@class='text-start w-fit text-[24px] font-medium']");
    public By blank_input_msg = By.xpath("//p[@class='text-red-500 text-sm text-']");
    public By invalid_email_msg = By.xpath("//p[@class='text-red-500 text-sm text-']");

    public String user_email = "feciwe6718@anlocc.com";
    public String user_password = "1234567Aa";
}

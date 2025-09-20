package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

    public String url= "https://www.rokomari.com/";
    public String title = "Buy Book Online - Best Online Book Shop in Bangladesh | Rokomari.com";
    public By login_signup_btn = By.xpath("//a[normalize-space()='Hello, Sign in']");
    public By pop_up_btn = By.xpath("//button[@class='popup-modal__close-btn close-btn-outside js--popup-modal__close-btn']//i[@class='ion-close-round']");

    public By logout_btn = By.xpath("//a[normalize-space()='Logout']");

    public void loadHomePage(){
        loadAPage(url);
    }
}

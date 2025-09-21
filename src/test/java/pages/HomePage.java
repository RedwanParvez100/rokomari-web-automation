package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

    public String url= "https://www.rokomari.com/";
    public String title = "Buy Book Online - Best Online Book Shop in Bangladesh | Rokomari.com";
    public By pop_up_btn = By.xpath("//button[@class='popup-modal__close-btn close-btn-outside js--popup-modal__close-btn']//i[@class='ion-close-round']");
    public By login_signup_btn = By.xpath("//a[normalize-space()='Hello, Sign in']");
    public By sign_out_btn = By.xpath("//a[normalize-space()='Sign Out']");

    public By book_types1 = By.xpath("//h1[contains(text(),'একাডেমিক বই')]");
    public By book_types2 = By.xpath("//h1[contains(text(),'ইসলামি বই')]");
    public By book_types3 = By.xpath("//h1[contains(text(),'ভাষা ও অভিধান বই')]");
    public By book_types4 = By.xpath("//h1[contains(text(),'উপন্যাসের বই')]");
    public By book_types5 = By.xpath("//h1[contains(text(),'মোটিভেশনাল বই')]");


    public void loadHomePage(){
        loadAPage(url);
    }
}

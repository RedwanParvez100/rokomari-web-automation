package pages;

import org.openqa.selenium.By;


public class HeaderPage extends BasePage{

    public By sign_in_option = By.xpath("//a[@class='logged-out-user-menu-btn']");
//    public By sign_in_page_msg = By.xpath("//h1[@class='text-start w-fit text-[24px] font-medium']");
    public By website_logo = By.xpath("//img[@alt='Rokomari logo']");

    public By navbar_items_1st = By.xpath("//span[contains(text(),'অর্ডার ট্র্যাক করুন')]");
    public By navbar_items_2nd = By.xpath("//span[contains(text(),'রকমারি কুইজ')]");
    public By navbar_items_3rd = By.xpath("//span[contains(text(),'রকমারি উদ্যোক্তা')]");
    public By navbar_items_4th = By.xpath("//span[contains(text(),'ঘরে বসে আয় করুন')]");
    public By navbar_items_5th = By.xpath("//span[contains(text(),'বই ডোনেশন')]");

    public By menubar_section = By.xpath("//ul[@class='main-menu d-flex justify-content-center']");
    public By menubar_items_1st = By.xpath("//a[@href='/book?ref=nm']");
    public By menubar_items_last = By.xpath("//a[contains(text(),'আজকের অফার !')]");

    public By search_bar = By.xpath("//input[@id='js--search']");
    public By search_icon = By.xpath("//button[@type='submit']//i[@class='ion-ios-search-strong']");
    public By academic_book_1 = By.xpath("//body/div[@class='container-fluid custom-container home-page-main-div']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/div[1]/img[1]");

    public By menubar_electronics = By.xpath("//a[contains(text(),'ইলেক্ট্রনিক্স')]");
    public By menubar_best_seller = By.xpath("//a[contains(text(),'বেস্টসেলার অ্যাওয়ার্ড, ২৪')]");
    public By menubar_order = By.xpath("//a[contains(text(),'প্রাতিষ্ঠানিক অর্ডার')]");
    public String order_page_url = "https://www.rokomari.com/corporate?ref=nm";
    public String history_page_url = "https://www.rokomari.com/search?term=History&search_type=ALL";



}

package pages;

import org.openqa.selenium.By;


public class HeaderPage extends BasePage{

    public By sign_in_option = By.xpath("//div[normalize-space()='Sign In']");
    public By sign_in_page_msg = By.xpath("//h1[@class='text-start w-fit text-[24px] font-medium']");
    public By website_logo = By.xpath("//img[@alt='rok main logo']");

    public By navbar_items_1st = By.xpath("//span[contains(text(),'অর্ডার ট্র্যাক করুন')]");
    public By navbar_items_2nd = By.xpath("//span[contains(text(),'রকমারি কুইজ')]");
    public By navbar_items_3rd = By.xpath("//span[contains(text(),'রকমারি উদ্যোক্তা')]");
    public By navbar_items_4th = By.xpath("//span[contains(text(),'ঘরে বসে আয় করুন')]");
    public By navbar_items_5th = By.xpath("//span[contains(text(),'বই ডোনেশন')]");

    public By menubar = By.xpath("//div[@class='menu_menuContainer__9GaZV']");
    public By menubar_items_1st = By.xpath("//a[@class='menu_menuLink___xE7K false text-[18px]']//span[contains(text(),'বই')]");
    public By menubar_items_last = By.xpath("//span[contains(text(),'আজকের অফার !')]");

    public By search_bar = By.xpath("//input[@id='desktop_search_field']");
    public By academic_book_1 = By.xpath("//img[@alt='বিজ্ঞান প্রথম বর্ষ category image']");

    public By menubar_electronics = By.xpath("//span[contains(text(),'ইলেক্ট্রনিক্স')]");
    public By menubar_best_seller = By.xpath("//span[contains(text(),'বেস্টসেলার অ্যাওয়ার্ড, ২৪')]");
    public By menubar_order = By.xpath("//span[contains(text(),'প্রাতিষ্ঠানিক অর্ডার')]");
    public String order_page_url = "https://www.rokomari.com/corporate?ref=nmm";



}

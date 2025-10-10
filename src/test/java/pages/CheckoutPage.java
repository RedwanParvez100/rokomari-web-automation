package pages;

import org.openqa.selenium.By;

public class CheckoutPage extends BasePage{

    public By author_name = By.xpath("//div[@id='js--cart-product-item-1167']//p[@class='product-info__author'][contains(text(),'হুমায়ূন আহমেদ')]");
    public By filter_option1 = By.xpath("//label[contains(text(),'সমকালীন উপন্যাস')]");
    public By filter_option3 = By.xpath("//label[@for='rok-filter-categoryIds-1321']");
    public By bottom_2ndlast_section_book2 = By.xpath("//img[@alt='Achinpur image']");
    public By bottom_2ndlast_section_book2_title = By.xpath("//a[contains(text(),'অচিনপুর')]");
    public By book2_add_cart = By.xpath("//div[@title='অচিনপুর হুমায়ূন আহমেদ']//div[1]//div[3]//button[1]");
//    public By page2_option = By.xpath("body > div:nth-child(16) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > section:nth-child(5) > div:nth-child(3) > a:nth-child(3)");
    public By page2_3rd_book = By.xpath("//img[@alt='Aisob Dinratri image']");
    public By page2_3rd_book_title = By.xpath("//a[contains(text(),'এইসব দিনরাত্রি')]");
    public By page2_3rd_book_add_cart = By.xpath("/html[1]/body[1]/div[8]/div[1]/div[1]/div[1]/section[3]/div[2]/div[1]/div[3]/div[1]/a[1]/div[1]/div[3]/button[1]");
    public By page3_4th_row_3rd_book = By.xpath("//img[@alt='Humayun Ahmed Rochonaboli - 4 image']");
    public By page3_4th_row_3rd_book_title = By.xpath("//a[contains(text(),'হুমায়ূন আহমেদ রচনাবলী - ৪')]");
    public By book3_add_cart = By.xpath("/html[1]/body[1]/div[8]/div[1]/div[1]/div[1]/section[3]/div[2]/div[1]/div[18]/div[1]/a[1]/div[1]/div[3]/button[1]");
    public By order_process_btn = By.xpath("//span[contains(text(),'অর্ডার করতে এগিয়ে যান')]");
}


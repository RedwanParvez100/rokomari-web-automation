package pages;

import org.openqa.selenium.By;

public class CheckoutPage extends BasePage{

    public By author_name = By.xpath("//div[@id='js--cart-product-item-4883']//p[@class='product-info__author'][contains(text(),'হুমায়ূন আহমেদ')]");
    public By filter_option1 = By.xpath("//label[contains(text(),'সমকালীন উপন্যাস')]");
    public By filter_option3 = By.xpath("//label[@for='rok-filter-categoryIds-1321']");
    public By bottom_2ndlast_section_book2 = By.xpath("//img[@alt='Achinpur image']");
    public By bottom_2ndlast_section_book2_title = By.xpath("//a[contains(text(),'অচিনপুর')]");
    public By book2_add_cart = By.xpath("//div[@title='অচিনপুর হুমায়ূন আহমেদ']//div[1]//div[3]//button[1]");
//    public By page2_option = By.xpath("body > div:nth-child(16) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > section:nth-child(5) > div:nth-child(3) > a:nth-child(3)");
    public By page2_5th_book = By.xpath("//img[@alt='Himu and Ekti Russian Pori image']");
    public By page2_5th_book_title = By.xpath("//a[contains(text(),'হিমু এবং একটি রাশিয়ান পরী')]");
    public By page2_5th_book_add_cart = By.xpath("//div[@title='হিমু এবং একটি রাশিয়ান পরী হুমায়ূন আহমেদ']//div[1]//div[3]//button[1]");
    public By page3_2nd_row_5th_book = By.xpath("//img[@alt='Humayun Ahmed Rochonaboli - 4 image']");
    public By page3_2nd_row_5th_book_title = By.xpath("//a[contains(text(),'হুমায়ূন আহমেদ রচনাবলী - ৪')]");
    public By book5_add_cart = By.xpath("/html[1]/body[1]/div[8]/div[1]/div[1]/div[1]/section[3]/div[2]/div[1]/div[10]/div[1]/a[1]/div[1]/div[3]/button[1]");
    public By order_process_btn = By.xpath("//span[contains(text(),'অর্ডার করতে এগিয়ে যান')]");

    public By pickup_home = By.xpath("//div[@class='delivery__location d-flex align-item-center mb-3']//p[@class='delivery__location--home']");
    public By pickup_select_home = By.xpath("//div[@class='delivery__location d-flex align-item-center mb-3']//input[@id='home']");
    public By pickup_office = By.xpath("//div[@class='delivery__location d-flex align-item-center mb-3']//label[@for='office'][normalize-space()='Office']");
    public By pickup_select_office = By.xpath("//div[@class='delivery__location d-flex align-item-center mb-3']//input[@id='office']");

    public By user_name_field = By.xpath("//div[@class='shipping-form-container']//input[@id='name']");
    public By user_name_phone = By.xpath("//fieldset[@class='group']//input[@id='phone']");
    public By user_name_alter_phone = By.xpath("//fieldset[@class='group']//input[@id='phone2']");

    public By name_validation_icon = By.xpath("//body/div[@id='shipping-payment']/div[@class='container']/div[@class='d-flex justify-content-start align-items-start']/div[@class='content__wrapper']/form[@class='js--confirm-order']/div[@class='content__wrapper--shipping']/div[@class='card']/div[@class='card-body special-shipping js--special-shipping']/div[@class='shipping-form-container']/fieldset[1]/span[1]//*[name()='svg']");
    public By phone_validation_icon = By.xpath("//div[@class='card']//div[1]//fieldset[1]//span[1]//*[name()='svg']");
    public By alter_phone_validation_icon = By.xpath("//div[@class='card']//div[1]//fieldset[2]//span[1]//*[name()='svg']");

    public By select_country = By.xpath("//select[@id='js--country']");
    public By select_bd = By.xpath("//select[@id='js--country']//option[@value='1'][normalize-space()='Bangladesh']");

    public By select_city = By.xpath("//select[@id='js--city']");
    public By select_dhaka = By.xpath("//option[contains(text(),'ঢাকা')]");

    public By select_area = By.xpath("//select[@id='js--area']");
    public By select_mirpur = By.xpath("//option[@value='62']");

    public By select_zone = By.xpath("//select[@id='js--zone']");
    public By select_1number = By.xpath("//option[@value='5038']");

    public By address_field = By.xpath("//fieldset[@class='mb-0']//textarea[@id='address']");

    public By payment_option1 = By.xpath("//label[@for='COD']");
    public By payment_option2 = By.xpath("//label[@for='B_KASH']");

    public By confirm_order_btn = By.xpath("//button[@id='js--confirm-order']");
    public By confirm_order_btn_total_amount = By.xpath("//span[contains(text(),'অর্ডার নিশ্চিত করুন')]");
}


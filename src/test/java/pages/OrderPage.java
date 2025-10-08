package pages;

import org.openqa.selenium.By;

public class OrderPage extends BasePage{

    public By academic_2nd_book_cart_button = By.xpath("//body[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/a[1]/div[1]/div[2]/button[1]");
    public By academic_3rd_book_cart_button = By.xpath("//div[@class='product-list__books']//div[1]//div[2]//div[1]//div[1]//div[3]//a[1]//div[1]//div[2]//button[1]");
    public By academic_4th_book_cart_button = By.xpath("//body[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/a[1]/div[1]/div[2]/button[1]");
    public By cart_icon = By.xpath("//a[@id='js-cart-menu']");
    public By cart_quantity_show = By.xpath("//span[@class='js--cart-quantity']");
    public By cart_total_price = By.xpath("//span[@id='js--cart-total-price']");
}

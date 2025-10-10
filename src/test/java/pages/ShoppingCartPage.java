package pages;

import org.openqa.selenium.By;

public class ShoppingCartPage extends BasePage{

    public By total_price = By.xpath("//span[@id='js--cart-total-price']");
    public By include_all_charge = By.xpath("//span[@id='js--payable-total']");
    public By shopping_cart_btn = By.xpath("//img[@alt='cart']");
    public By empty_cart_text = By.xpath("//h2[normalize-space()='Your Cart is Empty!']");
    public By book2_increase = By.xpath("//button[@id='js--btn-plus-216905']");
    public By increase_quantity_icon = By.xpath("//button[@id='js--btn-plus-91669']");
    public By decrease_quantity_icon = By.xpath("//button[@id='js--btn-minus-91669']");
    public By book2_delete = By.xpath("//div[@id='js--cart-product-item-91669']//img[@alt='trash']");
    public By book3_delete = By.xpath("//div[@id='js--cart-product-item-216905']//img[@alt='trash']");

//    public By delete_icon = By.xpath("//img[@alt='trash']");
    public By confirm_delete_btn = By.xpath("//button[contains(text(),'হ্যাঁ')]");
}

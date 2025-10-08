package pages;

import org.openqa.selenium.By;

public class ShoppingCartPage extends BasePage{

    public By total_price = By.xpath("//span[@id='js--cart-total-price']");
    public By shopping_cart_btn = By.xpath("//img[@alt='cart']");
    public By empty_cart_text = By.xpath("//h2[normalize-space()='Your Cart is Empty!']");
    public By increase_quantity_icon = By.xpath("//button[@id='js--btn-plus-91669']");
    public By decrease_quantity_icon = By.xpath("//button[@id='js--btn-minus-91669']");
}

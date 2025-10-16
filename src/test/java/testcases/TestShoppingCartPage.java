package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.*;
import utilities.DriverSetup;

public class TestShoppingCartPage extends DriverSetup {

    HeaderPage headerPage = new HeaderPage();
    HomePage homePage = new HomePage();
    BooksDisplayPage booksDisplayPage = new BooksDisplayPage();
    AuthorPage authorPage = new AuthorPage();
    OrderPage orderPage = new OrderPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();


    @BeforeSuite
    public void loadHeaderPageForTest() {
        homePage.loadHomePage();
        homePage.clickOnElement(homePage.pop_up_btn);
    }

    @Test(priority = 1, description = "Verify that the item in the shopping cart displays the correct information")
    public void TestShoppingCartInformation() throws InterruptedException {
        getDriver().navigate().back();
        booksDisplayPage.safeClick(booksDisplayPage.academic_book1);
        booksDisplayPage.hoverOnElement(booksDisplayPage.academic_book1_2nd_book);
        orderPage.clickOnElement(orderPage.academic_2nd_book_cart_button);
        booksDisplayPage.hoverOnElement(booksDisplayPage.academic_book1_3rd_book);
        orderPage.clickOnElement(orderPage.academic_3rd_book_cart_button);
        orderPage.waitForUpdatedAmount(orderPage.cart_quantity_show);
        Assert.assertEquals(orderPage.getElementText(orderPage.cart_quantity_show),"2");
    }

    @Test(priority = 2, description = "Verify that the total price is updated accordingly in the cart")
    public void TestTotalPriceIsUpdated() {
        shoppingCartPage.clickOnElement(shoppingCartPage.shopping_cart_btn);
        Assert.assertEquals(shoppingCartPage.getElementText(shoppingCartPage.total_price),"451 Tk.");
        getDriver().navigate().back();
        booksDisplayPage.hoverOnElement(booksDisplayPage.academic_book1_3rd_book);
        orderPage.clickOnElement(orderPage.academic_new3book_cart_button);
        shoppingCartPage.clickOnElement(shoppingCartPage.shopping_cart_btn);
        Assert.assertEquals(shoppingCartPage.getElementText(shoppingCartPage.total_price),"561 Tk.");
    }

    @Test(priority = 0, description = "Verify that the shopping cart button is clickable.")
    public void TestShoppingCartButtonEnable() {
        shoppingCartPage.clickOnElement(shoppingCartPage.shopping_cart_btn);
        Assert.assertTrue(shoppingCartPage.isEnable(shoppingCartPage.shopping_cart_btn));
        Assert.assertEquals(shoppingCartPage.getElementText(shoppingCartPage.empty_cart_text),"Your Cart is Empty!");
    }

    @Test(groups = "ShoppingCart", priority = 3, description = "Verify that users can change the quantity of items in the cart.")
    public void TestChangeQuantity() throws InterruptedException {
        shoppingCartPage.safeClick(shoppingCartPage.increase_quantity_icon);
        shoppingCartPage.waitForUpdatedAmount(shoppingCartPage.total_price);
        Assert.assertEquals(shoppingCartPage.getElementText(shoppingCartPage.total_price),"671 Tk.");
        shoppingCartPage.safeClick(shoppingCartPage.decrease_quantity_icon);
        shoppingCartPage.waitForUpdatedAmount(shoppingCartPage.total_price);
        Assert.assertEquals(shoppingCartPage.getElementText(shoppingCartPage.total_price),"561 Tk.");
    }

}

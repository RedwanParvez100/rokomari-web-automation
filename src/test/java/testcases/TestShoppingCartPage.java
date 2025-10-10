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
//        Thread.sleep(3000);
        booksDisplayPage.hoverOnElement(booksDisplayPage.academic_book1_3rd_book);
//        Thread.sleep(3000);
        orderPage.clickOnElement(orderPage.academic_3rd_book_cart_button);
//        booksDisplayPage.hoverOnElement(booksDisplayPage.academic_book1_4th_book);
//        orderPage.clickOnElement(orderPage.academic_4th_book_cart_button);
        orderPage.waitForUpdatedAmount(orderPage.cart_quantity_show);
        Assert.assertEquals(orderPage.getElementText(orderPage.cart_quantity_show),"2");
    }

    @Test(priority = 2, description = "Verify that the total price is updated accordingly in the cart")
    public void TestTotalPriceIsUpdated() {
        shoppingCartPage.clickOnElement(shoppingCartPage.shopping_cart_btn);
        Assert.assertEquals(shoppingCartPage.getElementText(shoppingCartPage.total_price),"409 Tk.");

        getDriver().navigate().back();
        booksDisplayPage.hoverOnElement(booksDisplayPage.academic_book1_5th_book);
        orderPage.clickOnElement(orderPage.academic_5th_book_cart_button);
        shoppingCartPage.clickOnElement(shoppingCartPage.shopping_cart_btn);
//        shoppingCartPage.waitForUpdatedAmount(shoppingCartPage.total_price);
        Assert.assertEquals(shoppingCartPage.getElementText(shoppingCartPage.total_price),"442 Tk.");

//        shoppingCartPage.clickOnElement(shoppingCartPage.book2_increase);
//        shoppingCartPage.waitForUpdatedAmount(shoppingCartPage.total_price);
//        Assert.assertEquals(shoppingCartPage.getElementText(shoppingCartPage.total_price),"1,146 Tk.");
//        shoppingCartPage.clickOnElement(shoppingCartPage.book2_delete);
//        shoppingCartPage.clickOnElement(shoppingCartPage.confirm_delete_btn);
//        shoppingCartPage.clickOnElement(shoppingCartPage.book2_delete);
//        shoppingCartPage.clickOnElement(shoppingCartPage.confirm_delete_btn);
////        booksDisplayPage.safeClick(booksDisplayPage.academic_book1);
////        booksDisplayPage.hoverOnElement(booksDisplayPage.academic_book1_2nd_book);
////        orderPage.clickOnElement(orderPage.academic_2nd_book_cart_button);
//        getDriver().navigate().back();
//        booksDisplayPage.hoverOnElement(booksDisplayPage.academic_book1_3rd_book);
//        orderPage.clickOnElement(orderPage.academic_3rd_book_cart_button);
//        shoppingCartPage.clickOnElement(shoppingCartPage.shopping_cart_btn);
//        Assert.assertEquals(shoppingCartPage.getElementText(shoppingCartPage.total_price),"848 Tk.");
    }

    @Test(priority = 0, description = "Verify that the shopping cart button is clickable.")
    public void TestShoppingCartButtonEnable() {
        shoppingCartPage.clickOnElement(shoppingCartPage.shopping_cart_btn);
        Assert.assertTrue(shoppingCartPage.isEnable(shoppingCartPage.shopping_cart_btn));
        Assert.assertEquals(shoppingCartPage.getElementText(shoppingCartPage.empty_cart_text),"Your Cart is Empty!");

//        booksDisplayPage.safeClick(booksDisplayPage.academic_book1);
//        booksDisplayPage.hoverOnElement(booksDisplayPage.academic_book1_2nd_book);
//        orderPage.clickOnElement(orderPage.academic_2nd_book_cart_button);
//        shoppingCartPage.clickOnElement(shoppingCartPage.shopping_cart_btn);
//        Assert.assertTrue(shoppingCartPage.isEnable(shoppingCartPage.shopping_cart_btn));
//        Assert.assertEquals(shoppingCartPage.getElementText(shoppingCartPage.total_price),"110 Tk.");
    }

    @Test(groups = "ShoppingCart", priority = 3, description = "Verify that users can change the quantity of items in the cart.")
    public void TestChangeQuantity() throws InterruptedException {
//        booksDisplayPage.safeClick(booksDisplayPage.academic_book1);
//        booksDisplayPage.hoverOnElement(booksDisplayPage.academic_book1_2nd_book);
//        orderPage.clickOnElement(orderPage.academic_2nd_book_cart_button);
//        shoppingCartPage.clickOnElement(shoppingCartPage.shopping_cart_btn);
//        Assert.assertEquals(shoppingCartPage.getElementText(shoppingCartPage.total_price),"110 Tk.");
        // Click on increase quantity icon
        shoppingCartPage.safeClick(shoppingCartPage.increase_quantity_icon);
        shoppingCartPage.waitForUpdatedAmount(shoppingCartPage.total_price);
        Assert.assertEquals(shoppingCartPage.getElementText(shoppingCartPage.total_price),"552 Tk.");
        // Click on decrease quantity icon
        shoppingCartPage.safeClick(shoppingCartPage.decrease_quantity_icon);
        shoppingCartPage.waitForUpdatedAmount(shoppingCartPage.total_price);
        Assert.assertEquals(shoppingCartPage.getElementText(shoppingCartPage.total_price),"442 Tk.");

    }

}

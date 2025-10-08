package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utilities.DriverSetup;

public class TestOrderPage extends DriverSetup {

    HeaderPage headerPage = new HeaderPage();
    HomePage homePage = new HomePage();
    BooksDisplayPage booksDisplayPage = new BooksDisplayPage();
    AuthorPage authorPage = new AuthorPage();
    OrderPage orderPage = new OrderPage();


    @BeforeMethod
    public void loadHeaderPageForTest() {
        homePage.loadHomePage();
        homePage.clickOnElement(homePage.pop_up_btn);
    }

    @Test(priority = 0, description = "Verify that the Add to Cart button is Clickable.")
    public void TestAddToCartButtonEnable(){
        booksDisplayPage.safeClick(booksDisplayPage.academic_book1);
        booksDisplayPage.hoverOnElement(booksDisplayPage.academic_book1_3rd_book);
        orderPage.clickOnElement(orderPage.academic_3rd_book_cart_button);
        Assert.assertTrue(orderPage.isVisible(orderPage.academic_3rd_book_cart_button));
        Assert.assertTrue(orderPage.isEnable(orderPage.academic_3rd_book_cart_button));
    }

    @Test(priority = 1, description = "Verify that a product is added to the cart after clicking the Add to Cart button")
    public void TestProductAddedTheCart(){
        booksDisplayPage.safeClick(booksDisplayPage.academic_book1);
        booksDisplayPage.hoverOnElement(booksDisplayPage.academic_book1_3rd_book);
        orderPage.clickOnElement(orderPage.academic_3rd_book_cart_button);
        Assert.assertTrue(orderPage.isVisible(orderPage.cart_icon));
        Assert.assertEquals(orderPage.getElementText(orderPage.cart_quantity_show),"1");
    }
}

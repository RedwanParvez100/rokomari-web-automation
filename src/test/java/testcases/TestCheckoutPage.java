package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.*;
import utilities.DriverSetup;

public class TestCheckoutPage extends DriverSetup {

    HomePage homePage = new HomePage();
    HeaderPage headerPage = new HeaderPage();
    LoginPage loginPage = new LoginPage();
    AuthorPage authorPage = new AuthorPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();



    @BeforeSuite
    public  void setup_class(){
        homePage.loadHomePage();
        homePage.clickOnElement(homePage.pop_up_btn);
//        homePage.clickOnElement(homePage.login_signup_btn);
//        dependsOnGroups = {"ShoppingCart"},
    }

    @Test( priority = 0, description = "Verify selection between Home and Office")
    public void TestPickUpParcelOption(){
//        loginPage.clickOnElement(loginPage.sign_in_btn);
//        loginPage.writeOnElement(loginPage.email_input_box, "pogeni9410@aiwanlab.com");
//        loginPage.clickOnElement(loginPage.next_btn);
//        loginPage.writeOnElement(loginPage.password_input_box, "redwan100");
//        loginPage.clickOnElement(loginPage.password_with_login_btn);

        authorPage.hoverOnElement(authorPage.all_author_name_section);
        authorPage.clickOnElement(authorPage.author_name1);

//        checkoutPage.scrollToAElement(checkoutPage.filter_option1, 30);
        checkoutPage.safeClick(checkoutPage.filter_option1);
        Assert.assertEquals(checkoutPage.getElement(checkoutPage.filter_option1).getText(),"সমকালীন উপন্যাস");

        checkoutPage.safeClick(checkoutPage.filter_option3);
        Assert.assertEquals(checkoutPage.getElement(checkoutPage.filter_option3).getText(),"রচনা সংকলন ও সমগ্র");
        checkoutPage.scrollToAElement(checkoutPage.bottom_2ndlast_section_book2, 220);

//        checkoutPage.safeClick(checkoutPage.bottom_2ndlast_section_book2);
        checkoutPage.hoverOnElement(checkoutPage.bottom_2ndlast_section_book2);
        checkoutPage.clickOnElement(checkoutPage.book2_add_cart);
        authorPage.safeClick(authorPage.author_name1_page2_option);

        checkoutPage.hoverOnElement(checkoutPage.page2_3rd_book);
        checkoutPage.clickOnElement(checkoutPage.page2_3rd_book_add_cart);
        authorPage.safeClick(authorPage.author_name1_page_rightward_arrow_option);

        checkoutPage.scrollAndHover(checkoutPage.page3_4th_row_3rd_book);
        checkoutPage.clickOnElement(checkoutPage.book3_add_cart);

        shoppingCartPage.clickOnElement(shoppingCartPage.shopping_cart_btn);
        Assert.assertTrue(checkoutPage.isVisible(checkoutPage.author_name));
        Assert.assertTrue(checkoutPage.isVisible(checkoutPage.order_process_btn));
        Assert.assertTrue(checkoutPage.isEnable(checkoutPage.order_process_btn));
        Assert.assertEquals(checkoutPage.getElementText(checkoutPage.author_name),"হুমায়ূন আহমেদ");
        Assert.assertEquals(checkoutPage.getElementText(checkoutPage.bottom_2ndlast_section_book2_title),"অচিনপুর");
        Assert.assertEquals(checkoutPage.getElementText(checkoutPage.page2_3rd_book_title),"এইসব দিনরাত্রি");
        Assert.assertEquals(checkoutPage.getElementText(checkoutPage.page3_4th_row_3rd_book_title),"হুমায়ূন আহমেদ রচনাবলী - ৪");
        Assert.assertEquals(shoppingCartPage.getElementText(shoppingCartPage.total_price),"1,221 Tk.");
        Assert.assertEquals(shoppingCartPage.getElementText(shoppingCartPage.include_all_charge), "1,319 TK.");




    }
}

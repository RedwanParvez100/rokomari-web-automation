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
    }

//        dependsOnGroups = {"ShoppingCart"},
    @Test( priority = 0, description = "Verify selection between Home and Office")
    public void TestPickUpParcelOption() throws InterruptedException {
        loginPage.clickOnElement(loginPage.sign_in_btn);
        loginPage.writeOnElement(loginPage.email_input_box, "redwanparvez100@gmail.com");
        loginPage.clickOnElement(loginPage.next_btn);
        loginPage.writeOnElement(loginPage.password_input_box, "redwan100");
        loginPage.clickOnElement(loginPage.password_with_login_btn);
        authorPage.hoverOnElement(authorPage.all_author_name_section);
        authorPage.clickOnElement(authorPage.author_name1);
        checkoutPage.safeClick(checkoutPage.filter_option1);
        Assert.assertEquals(checkoutPage.getElement(checkoutPage.filter_option1).getText(),"সমকালীন উপন্যাস");
        checkoutPage.safeClick(checkoutPage.filter_option3);
        Assert.assertEquals(checkoutPage.getElement(checkoutPage.filter_option3).getText(),"রচনা সংকলন ও সমগ্র");
        checkoutPage.scrollToAElement(checkoutPage.bottom_2ndlast_section_book2, 220);
        checkoutPage.hoverOnElement(checkoutPage.bottom_2ndlast_section_book2);
        checkoutPage.clickOnElement(checkoutPage.book2_add_cart);
        authorPage.safeClick(authorPage.author_name1_page2_option);
        checkoutPage.scrollToAElement(checkoutPage.page2_5th_book, 250);
        checkoutPage.hoverOnElement(checkoutPage.page2_5th_book);
        checkoutPage.clickOnElement(checkoutPage.page2_5th_book_add_cart);
        shoppingCartPage.clickOnElement(shoppingCartPage.shopping_cart_btn);
        Assert.assertTrue(checkoutPage.isVisible(checkoutPage.author_name));
        Assert.assertTrue(checkoutPage.isVisible(checkoutPage.order_process_btn));
        Assert.assertTrue(checkoutPage.isEnable(checkoutPage.order_process_btn));
        Assert.assertEquals(checkoutPage.getElementText(checkoutPage.author_name),"হুমায়ূন আহমেদ");
        Assert.assertEquals(checkoutPage.getElementText(checkoutPage.bottom_2ndlast_section_book2_title),"অচিনপুর");
        Assert.assertEquals(checkoutPage.getElementText(checkoutPage.page2_5th_book_title), "হিমু এবং একটি রাশিয়ান পরী");
//        Assert.assertEquals(checkoutPage.getElementText(checkoutPage.page3_2nd_row_5th_book_title),"হুমায়ূন আহমেদ রচনাবলী - ৪");
        Assert.assertEquals(shoppingCartPage.getElementText(shoppingCartPage.total_price),"344 Tk.");
        Assert.assertEquals(shoppingCartPage.getElementText(shoppingCartPage.include_all_charge), "394 TK.");
        checkoutPage.clickOnElement(checkoutPage.order_process_btn);
        Assert.assertTrue(checkoutPage.isVisible(checkoutPage.pickup_home));
        Assert.assertTrue(checkoutPage.isEnable(checkoutPage.pickup_home));
        Assert.assertTrue(checkoutPage.isVisible(checkoutPage.pickup_office));
        Assert.assertTrue(checkoutPage.isEnable(checkoutPage.pickup_office));
        Assert.assertTrue(checkoutPage.isSelected(checkoutPage.pickup_select_home));
        Assert.assertEquals(checkoutPage.getElementText(checkoutPage.pickup_home), "Home");
        Assert.assertFalse(checkoutPage.isSelected(checkoutPage.pickup_office));
        checkoutPage.clickOnElement(checkoutPage.pickup_office);
        Assert.assertTrue(checkoutPage.isSelected(checkoutPage.pickup_select_office));
        Assert.assertEquals(checkoutPage.getElementText(checkoutPage.pickup_office), "Office");
        Assert.assertFalse(checkoutPage.isSelected(checkoutPage.pickup_home));
    }

    @Test(priority = 1, description = "Verify that user can enter valid data in Name, Phone No, and Alternative Phone No fields")
    public void TestUserInfoField() {
        checkoutPage.writeOnElement(checkoutPage.user_name_field, "Redwan");
        checkoutPage.writeOnElement(checkoutPage.user_name_phone,"01955778899");
        checkoutPage.writeOnElement(checkoutPage.user_name_alter_phone, "01955778800");
        Assert.assertTrue(checkoutPage.isVisible(checkoutPage.name_validation_icon));
        Assert.assertTrue(checkoutPage.isVisible(checkoutPage.phone_validation_icon));
        Assert.assertTrue(checkoutPage.isVisible(checkoutPage.alter_phone_validation_icon));
    }

    @Test(priority = 2, description = "Verify that the user can select a country")
    public void TestSelectCountry() {
        checkoutPage.clickOnElement(checkoutPage.select_country);
        Assert.assertTrue(checkoutPage.isVisible(checkoutPage.select_country));
        Assert.assertTrue(checkoutPage.isEnable(checkoutPage.select_country));
        checkoutPage.clickOnElement(checkoutPage.select_bd);
        Assert.assertTrue(checkoutPage.isVisible(checkoutPage.select_bd));
        Assert.assertEquals(checkoutPage.getElementText(checkoutPage.select_bd), "Bangladesh");
    }

    @Test(priority = 3, description = "Verify city selection")
    public void TestSelectCity() {
        checkoutPage.clickOnElement(checkoutPage.select_city);
        Assert.assertTrue(checkoutPage.isVisible(checkoutPage.select_city));
        Assert.assertTrue(checkoutPage.isEnable(checkoutPage.select_city));
        checkoutPage.clickOnElement(checkoutPage.select_dhaka);
        Assert.assertTrue(checkoutPage.isVisible(checkoutPage.select_dhaka));
        Assert.assertEquals(checkoutPage.getElementText(checkoutPage.select_dhaka), "ঢাকা");
    }

    @Test(priority = 4, description = "Verify that the user can select both an area and a zone.")
    public void TestSelectAreaAndZone() {
        checkoutPage.clickOnElement(checkoutPage.select_area);
        Assert.assertTrue(checkoutPage.isVisible(checkoutPage.select_area));
        Assert.assertTrue(checkoutPage.isEnable(checkoutPage.select_area));
        checkoutPage.clickOnElement(checkoutPage.select_mirpur);
        Assert.assertTrue(checkoutPage.isVisible(checkoutPage.select_mirpur));
        Assert.assertEquals(checkoutPage.getElementText(checkoutPage.select_mirpur), "মিরপুর");
        checkoutPage.clickOnElement(checkoutPage.select_zone);
        Assert.assertTrue(checkoutPage.isVisible(checkoutPage.select_1number));
        Assert.assertEquals(checkoutPage.getElementText(checkoutPage.select_1number), "১ নাম্বার");
    }

    @Test(priority = 5, description = "Verify that the user can write the full address in the Address field.")
    public void TestAddressField() {
        checkoutPage.writeOnElement(checkoutPage.address_field, "Mirpur-01, Block:C, Dhaka-1216");
        Assert.assertTrue(checkoutPage.isVisible(checkoutPage.address_field));
    }

    @Test(priority = 6, description = "Verify that the user can select a payment option.")
    public void TestSelectPaymentOption() throws InterruptedException {
        checkoutPage.safeClick(checkoutPage.payment_option1);
        Assert.assertTrue(checkoutPage.isVisible(checkoutPage.payment_option1));
        Assert.assertTrue(checkoutPage.isEnable(checkoutPage.payment_option1));
        Assert.assertFalse(checkoutPage.isSelected(checkoutPage.payment_option2));
        Assert.assertEquals(checkoutPage.getElementText(checkoutPage.payment_option1), "ক্যাশ অন ডেলিভারি");
        Assert.assertTrue(checkoutPage.isVisible(checkoutPage.confirm_order_btn));
        Assert.assertTrue(checkoutPage.isEnable(checkoutPage.confirm_order_btn));
        Assert.assertEquals(checkoutPage.getElementText(checkoutPage.confirm_order_btn_total_amount), "অর্ডার নিশ্চিত করুন ৳394");
    }

}

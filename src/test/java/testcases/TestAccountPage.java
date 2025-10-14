package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HeaderPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverSetup;

public class TestAccountPage extends DriverSetup {

    HomePage homePage = new HomePage();
    HeaderPage headerPage = new HeaderPage();
    LoginPage loginPage = new LoginPage();
    AccountPage accountPage = new AccountPage();

    @BeforeSuite
    public  void setup_class(){
        homePage.loadHomePage();
        homePage.clickOnElement(homePage.pop_up_btn);
        loginPage.clickOnElement(loginPage.sign_in_btn);
    }

    @Test(priority = 0, description = "Verify hover menu appears")
    public void TestHoverMenu(){
        loginPage.writeOnElement(loginPage.email_input_box, "redwanparvez100@gmail.com");
        loginPage.clickOnElement(loginPage.next_btn);
        loginPage.writeOnElement(loginPage.password_input_box, "redwan100");
        loginPage.clickOnElement(loginPage.password_with_login_btn);
        loginPage.hoverOnElement(loginPage.user_icon);
        Assert.assertTrue(accountPage.isVisible(accountPage.my_profile));
    }

    @Test(priority = 1, description = "Verify hover menu options list")
    public void TestHoverMenuList(){
        Assert.assertTrue(accountPage.isVisible(accountPage.my_list));
        Assert.assertTrue(accountPage.isVisible(accountPage.wish_list));
        Assert.assertTrue(accountPage.isVisible(accountPage.following_author));
    }

    @Test(priority = 2, description = "Verify Orders navigation")
    public void TestOrdersNavigation() throws InterruptedException {
        accountPage.clickOnElement(accountPage.order_option);
        Assert.assertTrue(accountPage.isVisible(accountPage.order_amount));
        Assert.assertEquals(getDriver().getCurrentUrl(), accountPage.order_page_url);
    }

    @Test(priority = 3, description = "Verify Wishlist navigation")
    public void TestWishlistNavigation() throws InterruptedException {
        loginPage.hoverOnElement(loginPage.user_icon);
        accountPage.clickOnElement(accountPage.wishlist_option);
        Assert.assertTrue(accountPage.isVisible(accountPage.wishlist_amount));
        Assert.assertEquals(getDriver().getCurrentUrl(), accountPage.wishlist_page_url);
    }

    @Test(priority = 4, description = "Verify hover menu disappears on mouse out")
    public void TestHoverMenuDisappears(){
        headerPage.hoverOnElement(headerPage.search_bar);
        Assert.assertFalse(accountPage.isVisible(accountPage.my_profile));
        Assert.assertFalse(accountPage.isVisible(accountPage.my_list));
        Assert.assertFalse(accountPage.isVisible(accountPage.wish_list));
        Assert.assertFalse(accountPage.isVisible(accountPage.following_author));
    }

    @Test(priority = 5, description = "Verify My Profile navigation")
    public void TestProfileNavigation() throws InterruptedException {
        loginPage.hoverOnElement(loginPage.user_icon);
        accountPage.clickOnElement(accountPage.my_profile);
        Assert.assertEquals(getDriver().getCurrentUrl(), accountPage.my_account_page_url);
        Assert.assertFalse(getDriver().getCurrentUrl().equals(homePage.url));
    }

    @Test(priority = 6, description = "Verify Gender radio buttons presence")
    public void TestGenderOptionDisplay() throws InterruptedException {
        Assert.assertTrue(accountPage.isVisible(accountPage.gender_option));
    }

    @Test(priority = 7, description = "Verify Gender options")
    public void TestGenderOptions() throws InterruptedException {
        accountPage.clickOnElement(accountPage.change_info_option);
        Assert.assertTrue(accountPage.isVisible(accountPage.male_option));
        Assert.assertTrue(accountPage.isVisible(accountPage.female_option));
    }

    @Test(priority = 8, description = "Verify selecting a gender")
    public void TestSelectingGender() throws InterruptedException {
        accountPage.clickOnElement(accountPage.male_option);
        accountPage.clickOnElement(accountPage.save_btn);
        accountPage.waitForTextToBePresent(accountPage.confirm_msg);
        Assert.assertTrue(accountPage.isVisible(accountPage.male_option));
        Assert.assertTrue(accountPage.isVisible(accountPage.confirm_msg));
        Assert.assertEquals(accountPage.getElement(accountPage.male_option).getText(),"Male");
        Assert.assertEquals(accountPage.getElementText(accountPage.confirm_msg),"Updated Successfully");
    }

//
//    @Test(priority = 7, description = "Verify empty gender field")
//    public void TestEmptyGenderField() throws InterruptedException {
////        loginPage.writeOnElement(loginPage.email_input_box, "redwanparvez100@gmail.com");
////        loginPage.clickOnElement(loginPage.next_btn);
////        loginPage.WaitAndAutoClick(loginPage.otp_with_login_btn);
////        loginPage.hoverOnElement(loginPage.user_icon);
////        accountPage.clickOnElement(accountPage.my_profile);
////        accountPage.clickOnElement(accountPage.change_info_option);
//        accountPage.clickOnElement(accountPage.save_btn);
//        accountPage.waitForElementVisible(accountPage.confirm_msg, 10);
//        Assert.assertTrue(accountPage.isVisible(accountPage.confirm_msg));
//        Assert.assertEquals(accountPage.getElementText(accountPage.confirm_msg),"Updated Successfully");
//    }

    @Test(priority = 9, description = "Verify persistence of the gender field")
    public void TestPersistenceGenderField() throws InterruptedException {
        getDriver().navigate().refresh();
        Assert.assertTrue(accountPage.isVisible(accountPage.male_option));
    }


    @Test(priority = 10, description = "Verify password mismatch validation")
    public void TestPasswordMismatch() throws InterruptedException {
        accountPage.safeClick(accountPage.set_add_password);
        accountPage.writeOnElement(accountPage.set_new_password,"redwan100");
        accountPage.writeOnElement(accountPage.set_confirm_password,"redwan1001");
        Assert.assertFalse(accountPage.isEnable(accountPage.save_password_btn));
        Assert.assertEquals(accountPage.getElementText(accountPage.password_mismatch_validation_msg),"* Password doesn't match");
    }

    @Test(priority = 11, description = "Verify weak password validation")
    public void TestWeakPassword() throws InterruptedException {
        accountPage.clearInput(accountPage.set_new_password);
        accountPage.clearInput(accountPage.set_confirm_password);
        accountPage.writeOnElement(accountPage.set_new_password,"123456");
        accountPage.writeOnElement(accountPage.set_confirm_password,"123456");
        accountPage.safeClick(accountPage.save_password_btn);
        Assert.assertTrue(accountPage.isEnable(accountPage.save_password_btn));
        Assert.assertEquals(accountPage.getElementText(accountPage.weak_password_validation_msg),"New Password length can't be less than 8 characters!");
    }


    @Test(priority = 12, description = "Verify set password functionality")
    public void TestSetPasswordFunctionality() throws InterruptedException {
//        accountPage.safeClick(accountPage.old_password);
        accountPage.writeOnElement(accountPage.old_password, "redwan100");
        accountPage.writeOnElement(accountPage.set_new_password,"redwan1001");
        accountPage.writeOnElement(accountPage.set_confirm_password,"redwan1001");
        accountPage.safeClick(accountPage.save_password_btn);
        Assert.assertTrue(accountPage.isVisible(accountPage.password_confirm_msg));
        Assert.assertEquals(accountPage.getElementText(accountPage.password_confirm_msg),"Your password changed successfully. Please login using your new password.");
    }
    
    @Test(priority = 13, description = "Verify Sign Out option")
    public void TestSignOut() throws InterruptedException {
        loginPage.writeOnElement(loginPage.email_input_box, "redwanparvez100@gmail.com");
        loginPage.clickOnElement(loginPage.next_btn);
        loginPage.writeOnElement(loginPage.password_input_box, "redwan100");
        loginPage.clickOnElement(loginPage.password_with_login_btn);
        loginPage.hoverOnElement(loginPage.user_icon);
        Assert.assertTrue(loginPage.isVisible(loginPage.sign_out_btn));
        Assert.assertTrue(loginPage.isEnable(loginPage.sign_out_btn));
        accountPage.clickOnElement(loginPage.sign_out_btn);
        Assert.assertEquals(getDriver().getCurrentUrl(), homePage.url);
    }


}

package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HeaderPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverSetup;

import java.time.Duration;

public class TestAccountPage extends DriverSetup {

    HomePage homePage = new HomePage();
    HeaderPage headerPage = new HeaderPage();
    LoginPage loginPage = new LoginPage();
    AccountPage accountPage = new AccountPage();

    @BeforeMethod
    public  void setup_class(){
        homePage.loadHomePage();
//        homePage.clickOnElement(homePage.pop_up_btn);
        homePage.clickOnElement(homePage.login_signup_btn);
    }

    @Test(priority = 0, description = "Verify hover menu appears")
    public void TestHoverMenu(){
        loginPage.clickOnElement(loginPage.sign_in_btn);
        loginPage.writeOnElement(loginPage.email_input_box, "19202103100@cse.bubt.edu.bd");
        loginPage.clickOnElement(loginPage.next_btn);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        loginPage.hoverOnElement(loginPage.user_icon);
        Assert.assertTrue(accountPage.isVisible(accountPage.my_profile));
    }

    @Test(priority = 1, description = "Verify hover menu options list")
    public void TestHoverMenuList(){
        loginPage.clickOnElement(loginPage.sign_in_btn);
        loginPage.writeOnElement(loginPage.email_input_box, "19202103100@cse.bubt.edu.bd");
        loginPage.clickOnElement(loginPage.next_btn);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        loginPage.hoverOnElement(loginPage.user_icon);
        Assert.assertTrue(accountPage.isVisible(accountPage.best_selling));
        Assert.assertTrue(accountPage.isVisible(accountPage.wish_list));
        Assert.assertTrue(accountPage.isVisible(accountPage.following_author));
    }

    @Test(priority = 2, description = "Verify hover menu disappears on mouse out")
    public void TestHoverMenuDisappears(){
        loginPage.clickOnElement(loginPage.sign_in_btn);
        loginPage.writeOnElement(loginPage.email_input_box, "19202103100@cse.bubt.edu.bd");
        loginPage.clickOnElement(loginPage.next_btn);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        loginPage.hoverOnElement(loginPage.user_icon);
        headerPage.hoverOnElement(headerPage.menubar_items_last);
        Assert.assertTrue(headerPage.isVisible(headerPage.menubar_items_last));
    }

    @Test(priority = 3, description = "Verify My Profile navigation")
    public void TestProfileNavigation() throws InterruptedException {
        loginPage.clickOnElement(loginPage.sign_in_btn);
        loginPage.writeOnElement(loginPage.email_input_box, "19202103100@cse.bubt.edu.bd");
        loginPage.clickOnElement(loginPage.next_btn);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.hoverOnElement(loginPage.user_icon);
        Thread.sleep(2000);
        accountPage.clickOnElement(accountPage.my_profile);
        Thread.sleep(2000);
        Assert.assertEquals(getDriver().getCurrentUrl(), accountPage.my_account_page_url);
        Assert.assertFalse(getDriver().getCurrentUrl().equals(homePage.url));
    }

    @Test(priority = 4, description = "Verify Gender dropdown presence")
    public void TestGenderDropdownDisplay() throws InterruptedException {
        loginPage.clickOnElement(loginPage.sign_in_btn);
        loginPage.writeOnElement(loginPage.email_input_box, "redwanparvez100@gmail.com");
        loginPage.clickOnElement(loginPage.next_btn);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        loginPage.hoverOnElement(loginPage.user_icon);
        Thread.sleep(2000);
        accountPage.clickOnElement(accountPage.my_profile);
        Assert.assertTrue(accountPage.isVisible(accountPage.gender_dropdown));
    }

    @Test(priority = 5, description = "Verify Gender options")
    public void TestGenderOptions(){
        loginPage.clickOnElement(loginPage.sign_in_btn);
        loginPage.writeOnElement(loginPage.email_input_box, "redwanparvez100@gmail.com");
        loginPage.clickOnElement(loginPage.next_btn);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        loginPage.hoverOnElement(loginPage.user_icon);
        accountPage.clickOnElement(accountPage.my_profile);
        accountPage.clickOnElement(accountPage.change_info_option);
        accountPage.clickOnElement(accountPage.gender_dropdown);
        Assert.assertTrue(accountPage.isVisible(accountPage.male_dropdown));
        Assert.assertTrue(accountPage.isVisible(accountPage.female_dropdown));
    }

    @Test(priority = 6, description = "Verify selecting a gender")
    public void TestSelectingGender() throws InterruptedException {
        loginPage.clickOnElement(loginPage.sign_in_btn);
        loginPage.writeOnElement(loginPage.email_input_box, "golas94173@bitmens.com");
        loginPage.clickOnElement(loginPage.next_btn);
        Thread.sleep(15000);
//        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        loginPage.waitAndClick(loginPage.login_btn);
        loginPage.hoverOnElement(loginPage.user_icon);
        accountPage.clickOnElement(accountPage.my_profile);
        accountPage.clickOnElement(accountPage.change_info_option);
        accountPage.clickOnElement(accountPage.gender_dropdown);
        accountPage.clickOnElement(accountPage.male_dropdown);
        accountPage.clickOnElement(accountPage.save_btn);
        accountPage.waitForElementPresence(accountPage.confirm_msg);
        Assert.assertTrue(accountPage.isVisible(accountPage.male_dropdown));
        Assert.assertEquals(accountPage.getElement(accountPage.male_dropdown).getText(),"Male");
        Assert.assertTrue(accountPage.isVisible(accountPage.confirm_msg));
        Assert.assertEquals(accountPage.getElement(accountPage.confirm_msg).getText(),"Account updated successfully !");
//        Assert.assertEquals(accountPage.getElement(accountPage.confirm_msg).getText(),accountPage.success_msg_text);

    }

//    @Test(priority = 7, description = "Verify empty gender field")
//    public void TestEmptyGenderField(){
//        loginPage.clickOnElement(loginPage.sign_in_btn);
//        loginPage.writeOnElement(loginPage.email_input_box, "redwanparvez100@gmail.com");
//        loginPage.clickOnElement(loginPage.next_btn);
//        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        loginPage.hoverOnElement(loginPage.user_icon);
//        accountPage.clickOnElement(accountPage.my_profile);
//        accountPage.clickOnElement(accountPage.change_info_option);
//        accountPage.clickOnElement(accountPage.gender_dropdown);
//        accountPage.clickOnElement(accountPage.male_dropdown);
//        Assert.assertTrue(accountPage.isVisible(accountPage.male_dropdown));
//        Assert.assertEquals(accountPage.getElement(accountPage.male_dropdown).getText(),"Male");
//
//
//    }

}

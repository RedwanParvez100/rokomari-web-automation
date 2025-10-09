package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverSetup;

public class TestCheckoutPage extends DriverSetup {

    HomePage homePage = new HomePage();
    HeaderPage headerPage = new HeaderPage();
    LoginPage loginPage = new LoginPage();

    @BeforeSuite
    public  void setup_class(){
        homePage.loadHomePage();
        homePage.clickOnElement(homePage.pop_up_btn);
//        homePage.clickOnElement(homePage.login_signup_btn);
    }

    @Test( priority = 0, description = "Verify selection between Home and Office")
    public void TestSignInPagetitle(){
        loginPage.clickOnElement(loginPage.sign_in_btn);
        loginPage.writeOnElement(loginPage.email_input_box, "pogeni9410@aiwanlab.com");
        loginPage.clickOnElement(loginPage.next_btn);
        loginPage.writeOnElement(loginPage.password_input_box, "redwan100");
        loginPage.clickOnElement(loginPage.password_with_login_btn);

        Assert.assertEquals(loginPage.getElement(loginPage.sign_in_page_title).getText(),"সাইন ইন করুন");
    }
}

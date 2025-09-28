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
}

package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.HomePage;
import utilities.DriverSetup;

import java.time.Duration;

public class TestHeaderPage extends DriverSetup {

    HeaderPage headerPage = new HeaderPage();
    HomePage homePage = new HomePage();

    @BeforeMethod
    public void loadHeaderPageForTest(){
        homePage.loadHomePage();
        homePage.clickOnElement(homePage.pop_up_btn);
    }

    @Test(priority = 0, description = "Verify that the Login and Signup option is displayed.")
    public void TestLoginSignupDisplay(){
        Assert.assertTrue(headerPage.isVisible(headerPage.sign_in_option));
        Assert.assertTrue(headerPage.isEnable(headerPage.sign_in_option));
    }

    @Test(priority = 1, description = "Verify whether the logo of the website is added or not on the header.")
    public void TestWebsiteLogoDisplay(){
        Assert.assertTrue(headerPage.isVisible(headerPage.website_logo));
        Assert.assertTrue(headerPage.isEnable(headerPage.website_logo));
    }


    @Test(priority = 2, description = "Verify that all navbar items are visible.")
    public void TestNavbarItemsDisplay(){
        Assert.assertTrue(headerPage.isVisible(headerPage.navbar_items_1st));
        Assert.assertTrue(headerPage.isVisible(headerPage.navbar_items_2nd));
        Assert.assertTrue(headerPage.isVisible(headerPage.navbar_items_3rd));
        Assert.assertTrue(headerPage.isVisible(headerPage.navbar_items_4th));
        Assert.assertTrue(headerPage.isVisible(headerPage.navbar_items_5th));
    }


    @Test(priority = 3, description = "Verify that the Menu bar is added to the header.")
    public void TestMenuBarDisplay(){
        Assert.assertTrue(headerPage.isVisible(headerPage.menubar));
        Assert.assertTrue(headerPage.isVisible(headerPage.menubar_items_1st));
        Assert.assertTrue(headerPage.isVisible(headerPage.menubar_items_last));
    }

    @Test(priority = 4, description = "Verify that the Search bar is added to the header.")
    public void TestSearchBarDisplay(){
        Assert.assertTrue(headerPage.isVisible(headerPage.search_bar));
        Assert.assertTrue(headerPage.isEnable(headerPage.search_bar));
    }

    @Test(priority = 5, description = "Verify Navbar Items are Clickable")
    public void TestNavbarItemsClickable(){
        headerPage.clickOnElement(headerPage.navbar_items_1st);
        headerPage.clickOnElement(headerPage.navbar_items_2nd);
        headerPage.clickOnElement(headerPage.navbar_items_3rd);
        getDriver().navigate().back();
        headerPage.clickOnElement(headerPage.navbar_items_4th);
        headerPage.clickOnElement(headerPage.navbar_items_5th);
        Assert.assertFalse(getDriver().getCurrentUrl().equals(homePage.url));
    }

    @Test(priority = 6, description = "Verify that the \"Hello, Sign in\" button should be clickable")
    public void TestSignInButton(){
        headerPage.clickOnElement(headerPage.sign_in_option);
        Assert.assertEquals(headerPage.getElement(headerPage.sign_in_page_msg).getText(),"সাইন ইন করুন");
    }

    @Test(priority = 7, description = "Verify the Search bar functionality")
    public void TestSearchBarFunctionality(){
        headerPage.writeOnElement(headerPage.search_bar, "History");
        Assert.assertTrue(headerPage.isEnable(headerPage.search_bar));
    }

    @Test(priority = 8, description = "Verify the home page should be open by clicking on the logo on all pages.")
    public void TestOpenHomePage() throws InterruptedException {
        headerPage.scrollToAElement(headerPage.academic_book_1, -50);
//        Thread.sleep(5000);
        headerPage.clickOnElement(headerPage.academic_book_1);
//        Thread.sleep(6000);
        headerPage.clickOnElement(headerPage.website_logo);
//        Thread.sleep(6000);
        Assert.assertEquals(getDriver().getCurrentUrl(), homePage.url);
    }

    @Test(priority = 9, description = "Verify that the Menu bar all items are clickable.")
    public void TestMenuBarClickable() throws InterruptedException {
        headerPage.clickOnElement(headerPage.menubar_electronics);
//        Thread.sleep(6000);
        headerPage.clickOnElement(headerPage.menubar_best_seller);
//        Thread.sleep(6000);
        headerPage.clickOnElement(headerPage.menubar_order);
//        Thread.sleep(6000);
//        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));
        Assert.assertFalse(getDriver().getCurrentUrl().equals(homePage.url));
        Assert.assertEquals(getDriver().getCurrentUrl(), headerPage.order_page_url);
    }
}

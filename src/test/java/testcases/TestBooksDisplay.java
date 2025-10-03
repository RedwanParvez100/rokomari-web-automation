package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BooksDisplayPage;
import pages.HeaderPage;
import pages.HomePage;
import utilities.DriverSetup;

public class TestBooksDisplay extends DriverSetup {

    HeaderPage headerPage = new HeaderPage();
    HomePage homePage = new HomePage();
    BooksDisplayPage booksDisplayPage = new BooksDisplayPage();

    @BeforeMethod
    public void loadHeaderPageForTest(){
        homePage.loadHomePage();
        homePage.clickOnElement(homePage.pop_up_btn);
    }

    @Test(priority = 0, description = "Verify that the book's name and price are correctly displayed.")
    public void TestBooksNameAndPriceDisplay(){
        booksDisplayPage.safeClick(booksDisplayPage.academic_book_types);
        headerPage.clickOnElement(headerPage.website_logo);
        booksDisplayPage.safeClick(booksDisplayPage.language_book_types);
        headerPage.clickOnElement(headerPage.website_logo);
        booksDisplayPage.safeClick(booksDisplayPage.religious_book_types);
        headerPage.clickOnElement(headerPage.website_logo);
        booksDisplayPage.safeClick(booksDisplayPage.novel_types);
        headerPage.clickOnElement(headerPage.website_logo);
        Assert.assertTrue(homePage.isVisible(homePage.book_types1));
        Assert.assertTrue(homePage.isVisible(homePage.book_types2));
        Assert.assertTrue(homePage.isVisible(homePage.book_types3));
        Assert.assertTrue(homePage.isVisible(homePage.book_types4));
        Assert.assertTrue(getDriver().getCurrentUrl().equals(homePage.url));
    }

    @Test(priority = 1, description = "Verify Discount Tag/Label")
    public void TestDiscountTag(){

        /*Scroll and wait for each tag before asserting. One scroll ≠ all elements.
          You must scroll each element into view individually when the site uses lazy-loading or sliders. */

        booksDisplayPage.scrollToAElement(booksDisplayPage.discount_tag1, -100);
        booksDisplayPage.waitForElementVisible(booksDisplayPage.discount_tag1, 10);
        Assert.assertTrue(booksDisplayPage.isVisible(booksDisplayPage.discount_tag1));

        booksDisplayPage.scrollToAElement(booksDisplayPage.discount_tag3, -100);
        booksDisplayPage.waitForElementVisible(booksDisplayPage.discount_tag3, 10);
        Assert.assertTrue(booksDisplayPage.isVisible(booksDisplayPage.discount_tag3));

        booksDisplayPage.scrollToAElement(booksDisplayPage.discount_tag6, -100);
        booksDisplayPage.waitForElementVisible(booksDisplayPage.discount_tag6, 10);
        Assert.assertTrue(booksDisplayPage.isVisible(booksDisplayPage.discount_tag6));
    }

    @Test(priority = 2, description = "Verify Hover Behavior on Book Thumbnail")
    public void TestHoverBehaviorBookThumbnail(){
        booksDisplayPage.scrollToAElement(booksDisplayPage.discount_whole_section, 100);
//        booksDisplayPage.hoverOnElement(booksDisplayPage.hover_book1);
//        Assert.assertTrue(booksDisplayPage.isVisible(booksDisplayPage.hover_book1));
        booksDisplayPage.hoverOnElement(booksDisplayPage.hover_book3);
        booksDisplayPage.hoverOnElement(booksDisplayPage.hover_book5);
        Assert.assertTrue(booksDisplayPage.isVisible(booksDisplayPage.hover_book3));
        Assert.assertTrue(booksDisplayPage.isVisible(booksDisplayPage.hover_book5));
        Assert.assertEquals(booksDisplayPage.getElementText(booksDisplayPage.hover_book5_text),"Add to Cart");
    }

    @Test(priority = 3, description = "Verify that the book's author name is correctly displayed.")
    public void TestbooksAuthorNameDisplayed(){
        booksDisplayPage.hoverOnElement(booksDisplayPage.all_author_name_section);
        Assert.assertTrue(booksDisplayPage.isVisible(booksDisplayPage.author_name1));
        Assert.assertTrue(booksDisplayPage.isVisible(booksDisplayPage.author_name2));
        Assert.assertTrue(booksDisplayPage.isVisible(booksDisplayPage.author_name3));
        Assert.assertTrue(booksDisplayPage.isVisible(booksDisplayPage.author_name4));
        Assert.assertEquals(booksDisplayPage.getElementText(booksDisplayPage.author_name1),"হুমায়ূন আহমেদ");
        Assert.assertEquals(booksDisplayPage.getElementText(booksDisplayPage.author_name2),"কাজী নজরুল ইসলাম");
        Assert.assertEquals(booksDisplayPage.getElementText(booksDisplayPage.author_name3),"মানিক বন্দ্যোপাধ্যায়");
        Assert.assertEquals(booksDisplayPage.getElementText(booksDisplayPage.author_name4),"কাজী আনোয়ার হোসেন");
    }
}

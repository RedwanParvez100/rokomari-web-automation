package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AuthorPage;
import pages.BooksDisplayPage;
import pages.HeaderPage;
import pages.HomePage;
import utilities.DriverSetup;

public class TestAuthorPage extends DriverSetup {

    HeaderPage headerPage = new HeaderPage();
    HomePage homePage = new HomePage();
    BooksDisplayPage booksDisplayPage = new BooksDisplayPage();
    AuthorPage authorPage = new AuthorPage();

    @BeforeMethod
    public void loadHeaderPageForTest() {
        homePage.loadHomePage();
        homePage.clickOnElement(homePage.pop_up_btn);
    }


    @Test(priority = 8, description = "Verify clicking an author redirects to that author’s published books page")
    public void TestAuthorPublishedBooksPage() {
        authorPage.hoverOnElement(authorPage.all_author_name_section);
        authorPage.clickOnElement(authorPage.author_name1);
        Assert.assertEquals(authorPage.getElementText(authorPage.author_name1_all_books_title),"হুমায়ূন আহমেদ এর বই সমূহ");
        Assert.assertTrue(authorPage.isVisible(authorPage.author_name1_book1));
        Assert.assertTrue(authorPage.isVisible(authorPage.author_name1_book4));
    }

    @Test(priority = 9, description = "Verify the next page number option.")
    public void TestPageNumberOption() {
        authorPage.hoverOnElement(authorPage.all_author_name_section);
        authorPage.clickOnElement(authorPage.author_name1);
        authorPage.safeClick(authorPage.author_name1_page2_option);
        Assert.assertEquals(authorPage.getElementText(authorPage.author_name1_page2_text),"(Showing 61 to 120 of 506 items)");
        Assert.assertEquals(getDriver().getCurrentUrl(), authorPage.author_name1_page2_url);
    }

    @Test(priority = 10, description = "Verify the Rightward Arrow (›) option in pagination bar")
    public void TestRightwardArrowOption() {
        authorPage.hoverOnElement(authorPage.all_author_name_section);
        authorPage.clickOnElement(authorPage.author_name1);
        authorPage.safeClick(authorPage.author_name1_page_rightward_arrow_option);
        Assert.assertTrue(authorPage.isVisible(authorPage.author_name1_page2_3rd_book));
        Assert.assertEquals(authorPage.getElementText(authorPage.author_name1_page2_text),"(Showing 61 to 120 of 506 items)");
        Assert.assertEquals(getDriver().getCurrentUrl(), authorPage.author_name1_page2_url);
    }
}

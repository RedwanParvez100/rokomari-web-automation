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
    public void loadHeaderPageForTest() {
        homePage.loadHomePage();
        homePage.clickOnElement(homePage.pop_up_btn);
    }

    @Test(priority = 0, description = "Verify that the book's name and price are correctly displayed.")
    public void TestBooksNameAndPriceDisplay() {
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
    public void TestDiscountTag() {

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
    public void TestHoverBehaviorBookThumbnail() {
        booksDisplayPage.scrollToAElement(booksDisplayPage.discount_whole_section, 100);
//        booksDisplayPage.hoverOnElement(booksDisplayPage.hover_book1);
//        Assert.assertTrue(booksDisplayPage.isVisible(booksDisplayPage.hover_book1));
        booksDisplayPage.hoverOnElement(booksDisplayPage.hover_book3);
        booksDisplayPage.hoverOnElement(booksDisplayPage.hover_book5);
        Assert.assertTrue(booksDisplayPage.isVisible(booksDisplayPage.hover_book3));
        Assert.assertTrue(booksDisplayPage.isVisible(booksDisplayPage.hover_book5));
        Assert.assertEquals(booksDisplayPage.getElementText(booksDisplayPage.hover_book5_text), "Add to Cart");
    }

    @Test(priority = 3, description = "Verify that the book's author name is correctly displayed.")
    public void TestbooksAuthorNameDisplayed() {
        booksDisplayPage.hoverOnElement(booksDisplayPage.all_author_name_section);
        Assert.assertTrue(booksDisplayPage.isVisible(booksDisplayPage.author_name1));
        Assert.assertTrue(booksDisplayPage.isVisible(booksDisplayPage.author_name2));
        Assert.assertTrue(booksDisplayPage.isVisible(booksDisplayPage.author_name3));
        Assert.assertTrue(booksDisplayPage.isVisible(booksDisplayPage.author_name4));
        Assert.assertEquals(booksDisplayPage.getElementText(booksDisplayPage.author_name1), "হুমায়ূন আহমেদ");
        Assert.assertEquals(booksDisplayPage.getElementText(booksDisplayPage.author_name2), "কাজী নজরুল ইসলাম");
        Assert.assertEquals(booksDisplayPage.getElementText(booksDisplayPage.author_name3), "মানিক বন্দ্যোপাধ্যায়");
        Assert.assertEquals(booksDisplayPage.getElementText(booksDisplayPage.author_name4), "কাজী আনোয়ার হোসেন");
    }

//    @Test(priority = 4, description = "Verify linking of book image to details page")
//    public void TestLinkWithImageDetailsPage(){
////        booksDisplayPage.waitForElementToBeClickable(booksDisplayPage.book1);
//        booksDisplayPage.scrollToAElement(booksDisplayPage.book1, 130);
//        booksDisplayPage.clickOnElement(booksDisplayPage.book1);
//        Assert.assertTrue(booksDisplayPage.isVisible(booksDisplayPage.book1));
//        Assert.assertTrue(booksDisplayPage.isVisible(booksDisplayPage.book1_details));
//        Assert.assertEquals(getDriver().getCurrentUrl(), booksDisplayPage.book1_page_url);
////        Assert.assertTrue(getDriver().getCurrentUrl().equals(homePage.url));
////
////        Assert.assertEquals(booksDisplayPage.getElementText(booksDisplayPage.hover_book5_text),"Add to Cart");
//    }

//    @Test(priority = 5, description = "Verify that the user can sort the books by Price and Discount..")
//    public void TestSortingFunctionality() {
//        booksDisplayPage.scrollToAElement(booksDisplayPage.discount_whole_section, 100);
////        booksDisplayPage.hoverOnElement(booksDisplayPage.hover_book1);
////        Assert.assertTrue(booksDisplayPage.isVisible(booksDisplayPage.hover_book1));
//        booksDisplayPage.hoverOnElement(booksDisplayPage.hover_book3);
//        booksDisplayPage.hoverOnElement(booksDisplayPage.hover_book5);
//        Assert.assertTrue(booksDisplayPage.isVisible(booksDisplayPage.hover_book3));
//        Assert.assertTrue(booksDisplayPage.isVisible(booksDisplayPage.hover_book5));
//    }

    @Test(priority = 6, description = "Verify that all displayed books are clickable")
    public void TestDisplayedbBooksClickable() {
        booksDisplayPage.safeClick(booksDisplayPage.academic_book1);
        booksDisplayPage.clickAndSwitchToNewTab(booksDisplayPage.academic_book1_3rd_book);
        Assert.assertEquals(booksDisplayPage.getElementText(booksDisplayPage.academic_book1_3rd_book_title),"পদার্থবিজ্ঞান-২য় পত্র (একাদশ-দ্বাদশ শ্রেণি) (পেপারব্যাক)");
        Assert.assertEquals(booksDisplayPage.getElementText(booksDisplayPage.academic_book1_3rd_book_author_name),"প্রফেসর মোঃ আখতারুল ইসলাম");
        Assert.assertEquals(booksDisplayPage.getElementText(booksDisplayPage.academic_book1_3rd_book_price),"TK. 518");
    }

    @Test(priority = 7, description = "Verify that the selected book’s description is displayed correctly")
    public void TestSelectedBooksDescription() {
        booksDisplayPage.safeClick(booksDisplayPage.academic_book1);
        booksDisplayPage.clickAndSwitchToNewTab(booksDisplayPage.academic_book1_3rd_book);
        booksDisplayPage.clickOnElement(booksDisplayPage.academic_book1_3rd_book_details_option);
        Assert.assertEquals(booksDisplayPage.getElementText(booksDisplayPage.academic_book1_3rd_book_title),"পদার্থবিজ্ঞান-২য় পত্র (একাদশ-দ্বাদশ শ্রেণি) (পেপারব্যাক)");
        Assert.assertEquals(booksDisplayPage.getElementText(booksDisplayPage.academic_book1_3rd_book_author_name),"প্রফেসর মোঃ আখতারুল ইসলাম");
        Assert.assertEquals(booksDisplayPage.getElementText(booksDisplayPage.academic_book1_3rd_book_price),"TK. 518");
        Assert.assertEquals(booksDisplayPage.getElementText(booksDisplayPage.academic_book1_3rd_book_details),
                "পদার্থবিজ্ঞান-২য় পত্র (একাদশ-দ্বাদশ শ্রেণি) Physics-2nd Paper (XI-XII Class) রচনায়: প্রফেসর আখতারুল ইসলাম,ড.শফিকুল ইসলাম," +
                        "বিশ্বজিৎ দাস ও মো. মশিউর রহমান। জাতীয় শিক্ষাক্রম ও পাঠ্যপুস্তক বোর্ড(NCTB) কর্তৃক অনুমোদিত একাদশ-দ্বাদশ শ্রেণির বিজ্ঞান বিভাগের " +
                        "শিক্ষার্থীদের জন্য। প্রতিটি অধ্যায়ের টপিক্স এর সাথে গাণিতিক সমস্যা ও সমাধান দেয়া আছে। অনুশীলনীতে বিগত বছরের বোর্ড প্রশ্ন ও সকল প্রশ্নের " +
                        "উত্তর সংকেত সংযোজিত হয়েছে।বইয়ের শেষ অংশে বিগত সকল বছরের প্রশ্নপত্র সংযুক্ত করা আছে।");
    }

    @Test(priority = 8, description = "Verify clicking an author redirects to that author’s published books page")
    public void TestAuthorPublishedBooksPage() {
        booksDisplayPage.hoverOnElement(booksDisplayPage.all_author_name_section);
        booksDisplayPage.clickOnElement(booksDisplayPage.author_name1);
        Assert.assertEquals(booksDisplayPage.getElementText(booksDisplayPage.author_name1_all_books_title),"হুমায়ূন আহমেদ এর বই সমূহ");
        Assert.assertTrue(booksDisplayPage.isVisible(booksDisplayPage.author_name1_book1));
        Assert.assertTrue(booksDisplayPage.isVisible(booksDisplayPage.author_name1_book4));
    }
}

package pages;

import org.openqa.selenium.By;

public class AuthorPage extends BasePage{

    public By author_name2 = By.xpath("//a[contains(text(),'কাজী নজরুল ইসলাম')]");
    public By author_name3 = By.xpath("//a[contains(text(),'মানিক বন্দ্যোপাধ্যায়')]");
    public By author_name4 = By.xpath("//a[contains(text(),'কাজী আনোয়ার হোসেন')]");

    public By all_author_name_section = By.xpath("//a[@id='js--authors']");
    public By author_name1 = By.xpath("//a[contains(text(),'হুমায়ূন আহমেদ')]");
    public By author_name1_page2_text = By.xpath("//p[normalize-space()='(Showing 61 to 120 of 506 items)']");
    public String author_name1_page2_url = "https://www.rokomari.com/book/author/1/humayun-ahmed?ref=mm_p0&page=2";
    public By author_name1_page2_option = By.xpath("//a[normalize-space()='2']");
    public By author_name1_page2_3rd_book = By.xpath("//img[@alt='Putul image']");
    public By author_name1_page_rightward_arrow_option = By.xpath("//i[@class='ion-chevron-right']");
    public By author_name1_all_books_title = By.xpath("//h1[contains(text(),'হুমায়ূন আহমেদ এর বই সমূহ')]");
    public By author_name1_book1 = By.xpath("//img[@alt='Newyork Nilakashe Jakjoke Rod image']");
    public By author_name1_book4 = By.xpath("//img[@alt='Kichu Shoishob image']");
}

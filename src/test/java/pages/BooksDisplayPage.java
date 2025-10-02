package pages;

import org.openqa.selenium.By;

public class BooksDisplayPage extends BasePage{

    public String academic_books_url = "https://www.rokomari.com/academic/college/science-1st-year?science-1st-year";
    public String religious_books_url = "https://www.rokomari.com/book/category/391/islamic-ideal";
    public String language_books_url = "https://www.rokomari.com/book/category/673/language-and-grammar-learning";
    public String novel_books_url = "https://www.rokomari.com/book/category/682/novel-children-and-teens";


    public By academic_book_types = By.xpath("//body/div[@class='container-fluid custom-container home-page-main-div']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/div[1]/img[1]");
    public By religious_book_types = By.xpath("//body/div[@class='container-fluid custom-container home-page-main-div']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[3]/div[1]/img[1]");
    public By language_book_types = By.xpath("//body/div[@class='container-fluid custom-container home-page-main-div']/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/a[1]/div[1]/img[1]");
    public By novel_types = By.xpath("//body/div[@class='container-fluid custom-container home-page-main-div']/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/a[4]/div[1]/img[1]");


    public By discount_tag1 = By.xpath("//div[@class='discount-badge-common badge-yellow']//p[contains(text(),'17')]");
    public By discount_tag3 = By.xpath("(//div[contains(@class,'discount-badge-common')]//p)[3]");
    public By discount_tag6 = By.xpath("(//div[contains(@class,'discount-badge-common')]//p)[6]");

}

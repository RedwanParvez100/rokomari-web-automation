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

    public By discount_whole_section = By.xpath("//body[1]/div[8]/section[3]/section[1]");
    public By hover_book1 = By.xpath("//body[1]/div[8]/section[3]/section[1]/div[1]/div[1]/div[1]/div[1]/a[1]");
    public By hover_book5_text = By.xpath("//div[@class='d-flex justify-content-start js--book-list slick-initialized slick-slider']//div[5]//a[1]//div[1]//div[3]//button[1]");
    public By hover_book3 = By.xpath("//body[1]/div[8]/section[3]/section[1]/div[1]/div[1]/div[1]/div[3]/a[1]");
    public By hover_book5 = By.xpath("//body[1]/div[8]/section[3]/section[1]/div[1]/div[1]/div[1]/div[5]/a[1]");

    public By book_all_section = By.xpath("//h2[contains(text(),'সাম্প্রতিক যেসকল পণ্য আমাদের গ্রাহকেরা বেশি নিচ্ছে')]");
    public By book1 = By.xpath("//img[@alt=\"Zubair's GK (General Knowledge) image\"]");
    public By book1_view_details_option = By.xpath("//div[@class='d-flex justify-content-start js--book-list slick-initialized slick-slider']//div[4]//div[1]//a[1]");
    public By book1_details = By.xpath("//p[@id='js--short-description']//p[contains(text(),'বিশ্ববিদ্যালয় ভর্তি, বিসিএস ও সরকারি-বেসকারি বিভিন')]");
    public String book1_page_url = "https://www.rokomari.com/book/481666/zubair-s-gk-general-knowledge";

    public By academic_book1 = By.xpath("//body/div[@class='container-fluid custom-container home-page-main-div']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/div[1]/img[1]");
    public By academic_book1_2nd_book = By.xpath("//div[@class='product-item slick-slide slick-active']//img[@alt='তথ্য ও যোগাযোগ প্রযুক্তি - একাদশ ও দ্বাদশ শ্রেণির বইয়ের সহায়ক ডিভিডি - সিডি image']");
    public By academic_book1_3rd_book = By.xpath("//div[@class='product-list__books']//div[1]//div[2]//div[1]//div[1]//div[4]");
    public By academic_book1_4th_book = By.xpath("//div[@class='product-item slick-slide slick-active']//img[@alt='Completing Sentence image']");
    public By academic_book1_3rd_book_title = By.xpath("//h1[contains(.,'পদার্থবিজ্ঞান-২য় পত্র')]");
    public By academic_book1_3rd_book_author_name = By.xpath("//p[@class='details-book-info__content-author']//a[contains(text(),'প্রফেসর মোঃ আখতারুল ইসলাম')]");
    public By academic_book1_3rd_book_price = By.xpath("//span[@class='sell-price'][normalize-space()='TK. 518']");
    public By academic_book1_3rd_book_details_option = By.xpath("//a[@class='see-more-details']");
    public By academic_book1_3rd_book_details = By.xpath("//div[@id='js--summary-description']");

    public By right_to_left = By.xpath("//span[@class='irs js-irs-0 irs-with-grid']//span[@class='irs-slider to']");
    public By price_sorting_section = By.xpath("//p[normalize-space()='Price']");




}

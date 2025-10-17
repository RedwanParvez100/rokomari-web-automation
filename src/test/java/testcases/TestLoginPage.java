package testcases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.DataSet;
import utilities.DriverSetup;

import java.time.Duration;

public class TestLoginPage extends DriverSetup {

    private static final Logger log = LoggerFactory.getLogger(TestLoginPage.class);
    HomePage homePage = new HomePage();
    HeaderPage headerPage = new HeaderPage();
    LoginPage loginPage = new LoginPage();

    @BeforeSuite
    public void setup_class() {
        homePage.loadHomePage();
        homePage.clickOnElement(homePage.pop_up_btn);
//        homePage.clickOnElement(homePage.login_signup_btn);
    }

    @Test(priority = 0, description = "Verify the Sign In page title.")
    public void TestSignInPagetitle() {
        loginPage.clickOnElement(loginPage.sign_in_btn);
        Assert.assertEquals(loginPage.getElement(loginPage.sign_in_btn).getText(), "Sign in");
    }

    @Test(priority = 1, description = "Verify that the Sign in button is present.")
    public void TestSignInButtonIsPresent() {
        Assert.assertTrue(loginPage.isVisible(loginPage.sign_in_btn));
    }

    @Test(priority = 2, description = "Verify by clicking on the submit button for blank input.")
    public void TestSubmitButtonWithBlankInput() {
        loginPage.clickOnElement(loginPage.sign_in_btn);
        loginPage.clickOnElement(loginPage.next_btn);
        Assert.assertEquals(loginPage.getElementText(loginPage.blank_input_msg), "Please enter a valid email or phone number.");
    }

    @Test(priority = 3, description = "Verify that the system shows an error when the email is missing “@” symbol")
    public void TestEmailWithoutSymbol() {
        loginPage.clickOnElement(loginPage.sign_in_btn);
        loginPage.writeOnElement(loginPage.email_input_box, "userexample.com");
        loginPage.clickOnElement(loginPage.next_btn);
        Assert.assertEquals(loginPage.getElementText(loginPage.invalid_email_msg), "Invalid email! Please enter a valid email or phone number.");
    }

    @Test(priority = 4, description = "Verify that the system shows an error when the email is missing domain part")
    public void TestEmailWithoutDomainPart() {
        loginPage.clickOnElement(loginPage.sign_in_btn);
        loginPage.writeOnElement(loginPage.email_input_box, "user@");
        loginPage.clickOnElement(loginPage.next_btn);
        Assert.assertEquals(loginPage.getElementText(loginPage.invalid_email_msg), "Invalid email! Please enter a valid email or phone number.");
    }

    @Test(priority = 5, description = "Verify that the system shows an error when the email is missing username part")
    public void TestEmailWithOutUsernamePart() {
        loginPage.clickOnElement(loginPage.sign_in_btn);
        loginPage.writeOnElement(loginPage.email_input_box, "@gmail.com");
        loginPage.clickOnElement(loginPage.next_btn);
        Assert.assertEquals(loginPage.getElement(loginPage.invalid_email_msg).getText(), "Invalid email! Please enter a valid email or phone number.");
    }

    @Test(priority = 6, description = "Verify that the system rejects an email with space")
    public void TestEmailWithSpace() {
        loginPage.clickOnElement(loginPage.sign_in_btn);
        loginPage.writeOnElement(loginPage.email_input_box, "user @gmail.com");
        loginPage.clickOnElement(loginPage.next_btn);
        Assert.assertEquals(loginPage.getElement(loginPage.invalid_email_msg).getText(), "Invalid email! Please enter a valid email or phone number.");
    }

    @Test(priority = 7, description = "Verify that the system rejects an email with invalid characters")
    public void TestEmailWithInvalidCharacters() {
        loginPage.clickOnElement(loginPage.sign_in_btn);
        loginPage.writeOnElement(loginPage.email_input_box, "user#name@yahoo.com");
        loginPage.clickOnElement(loginPage.next_btn);
        Assert.assertEquals(loginPage.getElementText(loginPage.invalid_email_msg), "Invalid phone number! Please enter a valid email or phone number.");
    }

    @Test(priority = 8, description = "Verify that the system accepts a valid email address with dots in the username.")
    public void TestValidEmailWithDots() {
        loginPage.clickOnElement(loginPage.sign_in_btn);
        loginPage.writeOnElement(loginPage.email_input_box, "first.last@gmail.com");
        loginPage.clickOnElement(loginPage.next_btn);
        Assert.assertEquals(loginPage.getElementText(loginPage.otp_shown_msg), "OTP sent to your email. Please enter OTP bellow.");
    }

    @Test(priority = 9, description = "Verify that the system accepts a valid email address with subdomain")
    public void TestValidEmailWithSubdomain() {
        loginPage.clickOnElement(loginPage.sign_in_btn);
        loginPage.writeOnElement(loginPage.email_input_box, "user@mail.example.com");
        loginPage.clickOnElement(loginPage.next_btn);
        Assert.assertEquals(loginPage.getElementText(loginPage.otp_shown_msg), "OTP sent to your email. Please enter OTP bellow.");
    }

    @Test(priority = 10, description = "Verify that the system accepts a valid email address with different domains")
    public void TestValidEmailWithDifferentSubdomain() throws InterruptedException {
        loginPage.clickOnElement(loginPage.sign_in_btn);
        loginPage.writeOnElement(loginPage.email_input_box, "user@outlook.com");
        loginPage.clickOnElement(loginPage.next_btn);
        headerPage.clickOnElement(headerPage.website_logo);
        loginPage.clickOnElement(loginPage.sign_in_btn);
        loginPage.writeOnElement(loginPage.email_input_box, "user@hotmail.com");
        loginPage.clickOnElement(loginPage.next_btn);
        headerPage.clickOnElement(headerPage.website_logo);
        loginPage.clickOnElement(loginPage.sign_in_btn);
        loginPage.writeOnElement(loginPage.email_input_box, "user@protonmail.com");
        loginPage.clickOnElement(loginPage.next_btn);
        Assert.assertEquals(loginPage.getElementText(loginPage.otp_shown_msg), "OTP sent to your email. Please enter OTP bellow.");
    }

    @Test(priority = 11, description = "Verify that the system accepts a valid email address with uppercase characters.")
    public void TestValidEmailWithUppercase() {
        loginPage.clickOnElement(loginPage.sign_in_btn);
        loginPage.writeOnElement(loginPage.email_input_box, "USER2025@GMAIL.COM");
        loginPage.clickOnElement(loginPage.next_btn);
        Assert.assertEquals(loginPage.getElementText(loginPage.otp_shown_msg), "OTP sent to your email. Please enter OTP bellow.");

    }

    @Test(priority = 12, description = "Verify that the system accepts a valid email address")
    public void TestLoginWithValidEmail() {
        loginPage.clickOnElement(loginPage.sign_in_btn);
        loginPage.writeOnElement(loginPage.email_input_box, "redwanparvez100@gmail.com");
        loginPage.clickOnElement(loginPage.next_btn);
        Assert.assertEquals(loginPage.getElementText(loginPage.otp_shown_msg), "OTP sent to your email. Please enter OTP bellow.");
        loginPage.WaitAndAutoClick(loginPage.otp_with_login_btn);
        Assert.assertTrue(loginPage.isVisible(loginPage.user_icon));
    }

}

    /*

      @Test(dataProvider = "invalidUserCredentials", dataProviderClass = DataSet.class)
    public void testLoginWithInvalidCredentials(String email, String password, String error_msg, String validation_msg){
        loginPage.writeOnElement(loginPage.email_input_box, email);
        loginPage.writeOnElement(loginPage.password_input_box, password);
        loginPage.clickOnElement(loginPage.login_btn);
        Assert.assertEquals(loginPage.getElement(loginPage.email_input_box).getAttribute("validationMessage"), validation_msg);
        Assert.assertEquals(loginPage.getElement(loginPage.password_input_box).getAttribute("validationMessage"), validation_msg);
        if (loginPage.isVisible(loginPage.error_msg))
            Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getText(), error_msg);
        Assert.assertTrue(loginPage.isVisible(loginPage.login_btn));
    }

 */



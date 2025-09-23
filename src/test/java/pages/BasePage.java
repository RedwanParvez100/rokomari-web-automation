package pages;

//import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;

import static utilities.DriverSetup.getDriver;

public class BasePage {

    public WebElement getElement(By locator){
        return getDriver().findElement(locator);
    }

    public void clickOnElement(By locator){
        getElement(locator).click();
    }

    public void writeOnElement(By locator, String text){
        getElement(locator).sendKeys(text);
    }

    public boolean isVisible(By locator){
        try {
            return getElement(locator).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public boolean isEnable(By locator){
        return getElement(locator).isEnabled();
    }

    public void loadAPage(String url){
        getDriver().get(url);
    }

    public String getPageTitle(){
        return getDriver().getTitle();
    }

    public String getPageUrl(){
        return getDriver().getCurrentUrl();
    }

//    public void addScreenshot(String name){
//        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES)));
//    }

    public void waitForElementPresence(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void hoverOnElement(By locator) {
        Actions actions = new Actions(getDriver());
        actions.clickAndHold(getElement(locator)).build().perform();
    }

    public void scrollToAElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        // Scroll element into view
        js.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));

        // Add small offset if sticky header hides it
        js.executeScript("window.scrollBy(0, -100);");
    }
}

package pages;

//import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

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

    public void clearInput(By locator) {
        WebElement element = getElement(locator);
        element.clear();
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

    public boolean isSelected(By locator) {
        try {
            return getElement(locator).isSelected();
        } catch (Exception e) {
            return false;
        }
    }


    public void loadAPage(String url){
        getDriver().get(url);
    }

    public String getPageTitle(){
        return getDriver().getTitle();
    }

    public String getElementText(By locator) {
        return getElement(locator).getText();
    }

//    public String getElementText(By locator) {
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
//        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//        wait.until(ExpectedConditions.visibilityOf(element));
//        return element.getText().trim();
//    }



    public String getPageUrl(){
        return getDriver().getCurrentUrl();
    }

//    public void addScreenshot(String name){
//        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES)));
//    }

    // only for first one consistent text appear, not work for updated text
    public void waitForTextToBePresent(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(driver -> {
            String text = driver.findElement(locator).getText().trim();
            return !text.isEmpty();
        });
    }

    public void waitForUpdatedAmount(By locator) {
        String oldText = getDriver().findElement(locator).getText().trim();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(driver -> {
            String newText = driver.findElement(locator).getText().trim();
            return !newText.equals(oldText) && !newText.isEmpty();
        });
    }




    public void waitForElementPresence(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }


    public void waitForElementVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void WaitAndAutoClick(By locator) {
        try {
            // Wait 15 seconds
            Thread.sleep(15000);

            // Click the login button
            WebElement element = getDriver().findElement(locator);
            element.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


//    public void hoverOnElement(By locator) {
//        Actions actions = new Actions(getDriver());
//        actions.clickAndHold(getElement(locator)).build().perform();
//    }

    public void hoverOnElement(By locator) {
        WebElement element = getElement(locator); // ensure element is visible
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).perform(); // proper hover
    }


//    public void scrollToAElement(By locator) {
//        JavascriptExecutor js = (JavascriptExecutor) getDriver();
//
//        // Scroll element into view
//        js.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
//
//        // Add small offset if sticky header hides it
//        js.executeScript("window.scrollBy(0, -100);");
//    }

//    public void scrollToAElement(By locator, int offset) {
//        WebElement element = getElement(locator);
//        JavascriptExecutor js = (JavascriptExecutor) getDriver();
//        js.executeScript("arguments[0].scrollIntoView(true);", element);
//
//        if (offset != 0) {
//            js.executeScript("window.scrollBy(0, arguments[0]);", offset);
//        }
//    }

    public void scrollToAElement(By locator, int offset) {
        // Wait for element to be present and visible
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(40));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        // Scroll element into view, center it in the viewport
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);

        // Apply additional offset if needed
        if (offset != 0) {
            js.executeScript("window.scrollBy(0, arguments[0]);", offset);
        }
    }


    public void safeClick(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        // Scroll element to the center
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

        try {
            // Wait until clickable and click
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        } catch (ElementClickInterceptedException e) {
            // Fallback: JS click
            js.executeScript("arguments[0].click();", element);
        }
    }

    public void clickAndSwitchToNewTab(By locator) {
        // Click the element
        safeClick(locator);

        // Store current window handle
        String parentTab = getDriver().getWindowHandle();

        // Wait until new tab opens
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(driver -> driver.getWindowHandles().size() > 1);

        // Switch to the new tab
        Set<String> allTabs = getDriver().getWindowHandles();
        for (String tab : allTabs) {
            if (!tab.equals(parentTab)) {
                getDriver().switchTo().window(tab);
                break;
            }
        }
    }

    public void switchToNewTabAndBack(By locator) {
        String mainWindow = getDriver().getWindowHandle();

        // Click element that opens new tab
        getDriver().findElement(locator).click();

        // Wait and switch to new tab
        for (String windowHandle : getDriver().getWindowHandles()) {
            if (!windowHandle.equals(mainWindow)) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }

        // (Optional) Perform any validation or action in new tab
//        System.out.println("New tab title: " + getDriver().getTitle());

        // Close the new tab and return to main window
        getDriver().close();
        getDriver().switchTo().window(mainWindow);
    }


    public void scrollAndHover(By locator) {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Actions actions = new Actions(driver);

        // Wait until element is present & visible
        WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        // Scroll into view (centered)
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center', inline: 'center'});", target);

        // Hover
        actions.moveToElement(target).perform();
    }

    public void moveSlider(By sliderLocator, int xOffset) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        WebElement sliderHandle = wait.until(ExpectedConditions.elementToBeClickable(sliderLocator));

        Actions action = new Actions(getDriver());
        action.clickAndHold(sliderHandle).moveByOffset(xOffset, 0).release().perform();
    }











}

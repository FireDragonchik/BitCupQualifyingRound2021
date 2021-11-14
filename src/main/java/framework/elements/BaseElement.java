package framework.elements;

import framework.browser.BrowserFactory;
import framework.utils.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class BaseElement {
    By locator;
    String name;

    private static final Duration POLLING = Duration.ofSeconds(5);

    public static Logger logger = Logger.getInstance();

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public WebElement findElement() {

        return BrowserFactory.getInstanceDriver().findElement(locator);
    }

    public WebElement findElement(long timeoutInSeconds) {
        BrowserFactory.getInstanceDriver().manage().timeouts().implicitlyWait(0L, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(BrowserFactory.getInstanceDriver(), timeoutInSeconds);
        wait.pollingEvery(POLLING);
        wait.withMessage("Element " + name + " is not found");
        return wait.until(driver -> {
            List<WebElement> elements = driver.findElements(locator);
            if (!elements.isEmpty()) {
                return elements.get(0);
            } else {
                return null;
            }
        });
    }

    public boolean isDisplayed() {

        logger.info(String.format("Check if the element '%s' is displayed", name));
        return BrowserFactory.getInstanceDriver().findElement(locator).isDisplayed();
    }

    public void click() {

        logger.info(String.format("Clicking on the element '%s'", name));
        findElement().click();
    }

    public String getAttribute(String attribute) {

        return findElement().getAttribute(attribute);
    }

    public String getName() {

        return name;
    }

    public String getText() {

        return findElement().getText();
    }

    public void clear() {

        findElement().clear();
    }

    public void type(String text) {

        logger.info(String.format("Send keys '%1s' to '%2s'", text, name));
        findElement().sendKeys(text);
    }

    public void clearAndType(String text) {

        clear();
        type(text);
    }
}
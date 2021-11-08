package framework.elements;

import framework.browser.BrowserFactory;
import framework.utils.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BaseElement {
	By locator;
	String name;

	public static Logger logger = Logger.getInstance();

	public BaseElement(By locator, String name) {
		this.locator = locator;
		this.name = name;
	}

	public WebElement findElement() {

		logger.info("Looking for the element with locator: " + locator);
		return BrowserFactory.getDriver().findElement(locator);
	}

	public boolean isDisplayed() {

		logger.info("Checking the display of the element with locator: " + locator);
		return BrowserFactory.getDriver().findElement(locator).isDisplayed();
	}

	public void click() {

		findElement().click();
		logger.info("Clicking on the element with locator: " + locator);
	}

	public String getAttribute(String attribute) {

		logger.info("Getting attribute " + attribute + "  of the element with locator: " + locator);
		return findElement().getAttribute(attribute);
	}

	public String getName() {

		logger.info("Getting name of the element with locator: " + locator);
		return name;
	}
	
	public String getText() {

		logger.info("Getting text of the element with locator: " + locator);
		return findElement().getText();
	}
}
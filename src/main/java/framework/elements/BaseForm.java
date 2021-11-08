package framework.elements;

import framework.browser.BrowserFactory;
import framework.utils.ConfigManager.configProperties;
import framework.utils.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseForm {
	BaseElement element;
	String name;

	public static Logger logger = Logger.getInstance();

	public BaseForm(BaseElement element, String name) {
		this.element = element;
		this.name = name;
	}

	public boolean isDisplayed() {

		logger.info("Checking the display of a unique element");
		return element.isDisplayed();
	}

	public void waitForOpen() {

		logger.info("Wait for page open");
		WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), Integer.parseInt(configProperties.durationOfSeconds.getProperty()));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element.locator));
	}
}
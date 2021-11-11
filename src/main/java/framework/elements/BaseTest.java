package framework.elements;

import framework.browser.BrowserFactory;
import framework.utils.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {

	public static Logger logger = Logger.getInstance();

	@BeforeTest
	protected void setUp() {
		BrowserFactory.getInstanceDriver();
		BrowserFactory.getInstanceDriver().manage().window().maximize();
	}

	@AfterTest
	protected void tearDown() {
		BrowserFactory.quit();
	}
}

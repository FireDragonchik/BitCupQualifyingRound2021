package test;

import framework.browser.BrowserUtils;
import framework.elements.BaseTest;
import org.testng.annotations.Test;

public class GoogleCloudTest extends BaseTest {


	@Test
	public void googleCloud() {

		BrowserUtils.get("https://cloud.google.com/");

		logger.info("Test ended");
	}
}

package test;

import framework.browser.BrowserUtils;
import framework.elements.BaseTest;
import framework.utils.WebElementUtils;
import org.testng.annotations.Test;
import pageObject.GoogleCloudMainPage;
import pageObject.GoogleCloudSearchResultPage;

public class GoogleCloudTest extends BaseTest {

	private static final String SEARCH_TEXT = "Calculator";
	private static final String SEARCH_RESULT_TEXT = "Google Cloud Platform Pricing";

	@Test
	public void googleCloud() {

		BrowserUtils.get("https://cloud.google.com");

		GoogleCloudMainPage cloudMainPage = new GoogleCloudMainPage();
		cloudMainPage.waitPageLoaded();

		cloudMainPage.clickOnSearchBtn();
		cloudMainPage.fillSearchField(SEARCH_TEXT);
		cloudMainPage.clickEnter();

		GoogleCloudSearchResultPage searchResultPage = new GoogleCloudSearchResultPage();
		searchResultPage.waitPageLoaded();

		searchResultPage.clickOnSearchResultLink(SEARCH_RESULT_TEXT);

		logger.info("Test ended");
	}
}

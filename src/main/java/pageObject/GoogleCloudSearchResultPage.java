package pageObject;

import framework.elements.Label;
import framework.elements.Link;
import org.openqa.selenium.By;

public class GoogleCloudSearchResultPage extends GeneralGoogleCloudPage{

    private static final String XPATH_SEARCH_RESULT_LINK = "//div[contains(@class,'gs-title')]//a[contains(text(),'%s')]";

    private static final Label lblSearchResults = new Label(By.xpath("//div[@class='devsite-article-body']//*[contains(text(),'Search results')]"), "Search results Label");

    public void waitPageLoaded(){

        webElementUtils().waitForVisibilityOf(lblSearchResults, DEFAULT_TIMEOUT_TO_WAIT);
    }

    public void clickOnSearchResultLink(String text){

        webElementUtils().waitForVisibilityOf(getSearchResultLink(text), DEFAULT_TIMEOUT_TO_WAIT);
        getSearchResultLink(text).click();
    }

    private Link getSearchResultLink(String text){

        return new Link(By.xpath(String.format(XPATH_SEARCH_RESULT_LINK, text)), "Search result link " + text);
    }
}

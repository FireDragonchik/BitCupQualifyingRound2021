package pageObject;

import framework.browser.BrowserFactory;
import framework.elements.AbstractPage;
import framework.elements.Button;
import framework.elements.Input;
import framework.utils.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class GeneralGoogleCloudPage extends AbstractPage {

    protected static final long DEFAULT_TIMEOUT_TO_WAIT = 30;
    public static Logger logger = Logger.getInstance();

    private final Button btnSearch = new Button(By.xpath("//div[contains(@class,'searchbox')]//input"), "Search button");
    private final Input txtSearch = new Input(By.xpath("//div[contains(@class,'searchbox')]//input"), "Search input");

    public void clickOnSearchBtn(){

        btnSearch.click();
    }

    public void fillSearchField(String text){

        txtSearch.clearAndType(text);
    }

    public void clickEnter(){

        Actions actions = new Actions(BrowserFactory.getInstanceDriver());
        actions.sendKeys(Keys.ENTER).build().perform();
    }
}

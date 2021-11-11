package pageObject;

import framework.elements.Label;
import org.openqa.selenium.By;

public class GoogleCloudMainPage extends GeneralGoogleCloudPage{

private final Label lblNewCustomers = new Label(By.xpath("//div[contains(@class,'cws-banner')]"), "New customers label");

    public void waitPageLoaded(){

        webElementUtils().waitForVisibilityOf(lblNewCustomers, DEFAULT_TIMEOUT_TO_WAIT);
    }
}

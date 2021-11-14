package pageObject;

import framework.browser.BrowserUtils;
import framework.elements.Input;
import org.openqa.selenium.By;

public class PricingCalculatorPage extends GeneralGoogleCloudPage {

    private static final String XPATH_MAIN = "//md-input-container[@class='flex']";

    private final Input txtNumberOfInstances = new Input(By.xpath(XPATH_MAIN + "//input[@name='quantity']"), "NumberOfInstances");


    public void waitPageLoaded() {

        goToAppFrame();
        webElementUtils().waitForVisibilityOf(getTxtNumberOfInstances(), DEFAULT_TIMEOUT_TO_WAIT);
        switchToDefaultContent();
    }

    public void goToAppFrame() {

        logger.info("Switch to iframe");
        BrowserUtils.switchToIFrame(By.xpath("//article//iframe"));
    }

    public void switchToDefaultContent() {

        logger.info("Switch to default content");
        BrowserUtils.switchToDefaultContent();
    }

    public void fill(String text){

        goToAppFrame();
        getTxtNumberOfInstances().clearAndType(text);
        switchToDefaultContent();
    }

    private Input getTxtNumberOfInstances(){

        return new Input(By.xpath(XPATH_MAIN + "//input[@name='quantity']"), "NumberOfInstances");
    }
}

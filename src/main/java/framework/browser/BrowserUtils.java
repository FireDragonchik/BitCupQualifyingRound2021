package framework.browser;

import framework.utils.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BrowserUtils {

	public static Logger logger = Logger.getInstance();

	public static String getUrl(){
		return BrowserFactory.getDriver().getCurrentUrl();
	}

	public static void get(String url) {

		logger.info("Open " + url);
		BrowserFactory.getDriver().get(url);
	}

	public static void get(String protocol, String host) {

		logger.info("Open " + protocol + host);
		BrowserFactory.getDriver().get(protocol + host);
	}

	public static void get(String protocol, String host, String path) {

		logger.info("Open " + protocol + host + path);
		BrowserFactory.getDriver().get(protocol + host + path);
	}

	public static void get(String protocol, String login, String password, String host, String path) {

		logger.info("Open " + protocol + login + ":" + password + "@" + host + path);
		BrowserFactory.getDriver().get(protocol + login + ":" + password + "@" + host + path);
	}

	public static void back(){

		logger.info("Back to previous the page");
		BrowserFactory.getDriver().navigate().back();
	}

	public static void forward(){

		logger.info("Go to next the page");
		BrowserFactory.getDriver().navigate().forward();
	}

	public static void refresh(){

		logger.info("Refresh the page");
		BrowserFactory.getDriver().navigate().refresh();
	}

	public static void switchToIFrame(By iFrameLocator){

		logger.info("Switch to IFrame " + iFrameLocator);
		WebElement iFrame = BrowserFactory.getDriver().findElement(iFrameLocator);
		BrowserFactory.getDriver().switchTo().frame(iFrame);
	}

	public static void switchToDefaultContent(){

		logger.info("Switch to default content");
		BrowserFactory.getDriver().switchTo().defaultContent();
	}
}

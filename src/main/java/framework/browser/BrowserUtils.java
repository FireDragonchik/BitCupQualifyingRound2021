package framework.browser;

import framework.utils.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BrowserUtils {

	public static Logger logger = Logger.getInstance();

	public static String getUrl(){
		return BrowserFactory.getInstanceDriver().getCurrentUrl();
	}

	public static void get(String url) {

		logger.info("Open " + url);
		BrowserFactory.getInstanceDriver().get(url);
	}

	public static void get(String protocol, String host) {

		logger.info("Open " + protocol + host);
		BrowserFactory.getInstanceDriver().get(protocol + host);
	}

	public static void get(String protocol, String host, String path) {

		logger.info("Open " + protocol + host + path);
		BrowserFactory.getInstanceDriver().get(protocol + host + path);
	}

	public static void get(String protocol, String login, String password, String host, String path) {

		logger.info("Open " + protocol + login + ":" + password + "@" + host + path);
		BrowserFactory.getInstanceDriver().get(protocol + login + ":" + password + "@" + host + path);
	}

	public static void back(){

		logger.info("Back to previous the page");
		BrowserFactory.getInstanceDriver().navigate().back();
	}

	public static void forward(){

		logger.info("Go to next the page");
		BrowserFactory.getInstanceDriver().navigate().forward();
	}

	public static void refresh(){

		logger.info("Refresh the page");
		BrowserFactory.getInstanceDriver().navigate().refresh();
	}

	public static void switchToIFrame(By iFrameLocator){

		logger.info("Switch to IFrame " + iFrameLocator);
		WebElement iFrame = BrowserFactory.getInstanceDriver().findElement(iFrameLocator);
		BrowserFactory.getInstanceDriver().switchTo().frame(iFrame);
	}

	public static void switchToDefaultContent(){

		logger.info("Switch to default content");
		BrowserFactory.getInstanceDriver().switchTo().defaultContent();
	}
}

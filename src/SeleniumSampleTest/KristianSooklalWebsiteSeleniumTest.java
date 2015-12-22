package SeleniumSampleTest;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
	Simple Selenium Test Example using "Chrome Driver" to show a standalone UI testing scenario.
	
	This test will go through the main parts of my personal website.
	
 	@author kristian.sooklal
 */
public class KristianSooklalWebsiteSeleniumTest {
	private static final String BASE_URL = "http://kristiansooklal.me";
	private WebDriver chromeDriver = null;

	{
		System.setProperty("webdriver.chrome.driver", "src/SeleniumSampleTest/chromedriver.exe");
		chromeDriver = new ChromeDriver();
	}
	
	@After
	public void tearDown(){
		if (chromeDriver != null){
			chromeDriver.close();
			chromeDriver = null;
		}
	}

	@Test
	public void getToHomePage() throws InterruptedException{
		chromeDriver.get(BASE_URL);
		Thread.sleep(5000);
	
	}

	public static void waitUntilElementVisible(WebDriverWait wait, String string) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(string)));
	}

	public static void pressDownArrowAndEnter(final WebDriver webDriver) {
		new Actions(webDriver).sendKeys(Keys.chord(Keys.ARROW_DOWN)).perform();
		new Actions(webDriver).sendKeys(Keys.chord(Keys.ENTER)).perform();
	}

	public static void pressDownArrow(final WebDriver webDriver) {
		new Actions(webDriver).sendKeys(Keys.chord(Keys.ARROW_DOWN)).perform();
	}
}
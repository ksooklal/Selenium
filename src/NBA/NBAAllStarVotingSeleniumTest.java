package NBA;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NBAAllStarVotingSeleniumTest {
	public static final String [] EASTERN_CONFERENCE_PLAYERS = new String [] 
			{"John Wall", "Bradley Beal", "Marcin Gortat", "Jared Dudley", "Kris Humphries"};
	public static final String [] WESTERN_CONFERENCE_PLAYERS = new String []
			{"Kobe Bryant", "Trevor Ariza"};
	public static final String NBA_ALL_STAR_VOTING = "http://vote.nba.com/";
	public static final ArrayList<String> ALL_STAR_NOMINEES = getAllNBAAllStarVotes();

	private WebDriver chromeDriver = null;

	{
		System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
		chromeDriver = new ChromeDriver();
	}

	@After
	public void tearDown(){
		if (chromeDriver != null){
			//		chromeDriver.close();
			chromeDriver = null;
		}
	}

	private static final ArrayList<String> getAllNBAAllStarVotes() {
		ArrayList<String> allNBAAllStarVotes = new ArrayList<String>();
		for (String easternPlayer: EASTERN_CONFERENCE_PLAYERS){
			allNBAAllStarVotes.add(easternPlayer);
		}
		for (String westernPlayer: WESTERN_CONFERENCE_PLAYERS){
			allNBAAllStarVotes.add(westernPlayer);
		}
		return allNBAAllStarVotes;
	}

	public static void clickAllStarVoteButton(WebDriver webDriver){
		List<WebElement> anchors = webDriver.findElements(By.tagName("a"));
		for (WebElement anchor: anchors){
			String anchorClass = anchor.getAttribute("class");
			if (anchorClass != null && anchorClass.contains("btn-vote")){
				anchor.sendKeys(Keys.ENTER);
				return;
			}
		}
	}

	public static void clickReviewAndSubmitButton(WebDriver webDriver){
		List<WebElement> anchors = webDriver.findElements(By.tagName("a"));
		for (WebElement anchor: anchors){
			String anchorClass = anchor.getAttribute("class");
			if (anchorClass != null && anchorClass.contains("allstar-tab__reveal")){
				anchor.sendKeys(Keys.ENTER);
				return;
			}
		} 
	}

	public static void findNBAPlayer(String lastName, WebDriver webDriver){
		webDriver.findElement(By.cssSelector("input[type='text']")).clear();
		webDriver.findElement(By.cssSelector("input[type='text']")).sendKeys(lastName);
	}

	@Test
	public void getToHomePage() throws InterruptedException{
		chromeDriver.get(NBA_ALL_STAR_VOTING);

		for (String allStarNominee: ALL_STAR_NOMINEES){
			String lastName = allStarNominee.split(" ")[1];
			findNBAPlayer(lastName, chromeDriver);
			//Thread.sleep(500);
			clickAllStarVoteButton(chromeDriver);
			//Thread.sleep(500);
		}

		clickReviewAndSubmitButton(chromeDriver);
		Thread.sleep(1000);
		//chromeDriver.findElement(By.linkText("Create Account")).click();
		List<WebElement> anchors = chromeDriver.findElements(By.tagName("a"));
		for (WebElement anchor: anchors){
			String anchorText = anchor.getText();
			if (anchorText != null && anchorText.trim().equals("Create Account")){
				System.out.println(anchorText);
				anchor.sendKeys(Keys.ENTER);
			}
		} 
		//chromeDriver.findElement(By.linkText("VOTE")).click();




		//		final String userName = bcgUserName + getRandomString();
		//		System.out.println("Username: " + userName);
		//
		//		setComputedUserName(userName);
		//		chromeDriver.findElement(By.id("tUserName")).sendKeys(userName);
		//		chromeDriver.findElement(By.id("a-checkname")).click();
		//		Thread.sleep(1500);
		//		String isUserNameAvailable = chromeDriver.findElement(By.id("u-name-available")).getText();
		//		System.out.println("Username " + isUserNameAvailable);
		//		System.out.println("Username " + isUserNameAvailable);
		//		assertTrue(isUserNameAvailable != null && isUserNameAvailable.contains("Available!"));
		//
		//		chromeDriver.findElement(By.id("tPassword")).sendKeys(bcgUserPassword);
		//		chromeDriver.findElement(By.id("tPasswordRetype")).sendKeys(bcgUserPassword);
		//
		//		System.out.println("Username: " + userName + "\tPassword: " + bcgUserPassword);
		//
		//		chromeDriver.findElement(By.cssSelector("#sSec1_chosen > a.chosen-single > div > b")).click();
		//		pressDownArrowAndEnter(chromeDriver);
		//
		//		String passwordMatch = chromeDriver.findElement(By.id("result-Match")).getText();
		//		System.out.println(passwordMatch);
		//		assertTrue(passwordMatch != null && passwordMatch.contains("Match"));
		//
		//		chromeDriver.findElement(By.id("tSecAnswer1")).sendKeys(question1City);
		//		chromeDriver.findElement(By.id("tSecAnswer1Match")).sendKeys(question1City);
		//		System.out.println("Answered Security Question 1: " + question1City);
		//
		//		chromeDriver.findElement(By.cssSelector("#sSec2_chosen > a.chosen-single > div > b")).click();
		//		pressDownArrowAndEnter(chromeDriver);
		//		chromeDriver.findElement(By.id("tSecAnswer2")).sendKeys(question2Pet);
		//		chromeDriver.findElement(By.id("tSecAnswer2Match")).sendKeys(question2Pet);
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

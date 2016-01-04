package NBA;

import java.io.BufferedReader;
import java.io.FileReader;
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
	private static final String CONFIG_FILE_PATH = "resources/api.config";
	private static final String EMAIL = getEmailAddress(); /** TODO Add your email login to NBA.com here **/
	private static final String PASSWORD = getPassword(); /** TODO Add your NBA.com password here **/

	@SuppressWarnings("resource")
	private static final String getEmailAddress(){
		String line = null;
		try {
			FileReader fileReader = new FileReader(CONFIG_FILE_PATH);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while((line = bufferedReader.readLine()) != null) {
				if (line.indexOf(":") > 0 && line.indexOf("Email") >= 0){
					String email = line.split(":")[1].trim();
					return email;
				}
			}
		} catch (Exception e){
			return line;
		}
		return line;
	}

	@SuppressWarnings("resource")
	private static final String getPassword(){
		String line = null;
		try {
			FileReader fileReader = new FileReader(CONFIG_FILE_PATH);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while((line = bufferedReader.readLine()) != null) {
				if (line.indexOf(":") > 0 && line.indexOf("Password") >= 0){
					String password = line.split(":")[1].trim();
					return password;
				}
			}
		} catch (Exception e){
			return line;
		}
		return line;
	}

	private WebDriver chromeDriver = null;

	{
		System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
		chromeDriver = new ChromeDriver();
	}

	@After
	public void tearDown(){
		if (chromeDriver != null){
			chromeDriver.close();
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
		Thread.sleep(2000);
		chromeDriver.findElement(By.id("email")).sendKeys(EMAIL);
		chromeDriver.findElement(By.id("password")).sendKeys(PASSWORD);
		chromeDriver.findElement(By.cssSelector("input[type='submit']")).click();


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

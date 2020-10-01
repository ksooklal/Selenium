package Degree;

import BreatheRightNasalStrips.BreatheRightNasalStrips;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DegreeSprayDeodorantSamples {
    private ChromeDriver chromeDriver;

    {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        chromeDriver = new ChromeDriver();
    }

    @Test
    public void getDeodorantSamples() throws Exception {
        String url = "https://www.degreedeodorant.com/us/en/campaigns/dry-spray-deodorant-sampling-2020.html";
        chromeDriver.get(url);
        Thread.sleep(1738);
        chromeDriver.manage().window().maximize();
        Thread.sleep(1738);

        chromeDriver.findElementById("sgE-5627813-4-136-10475").click();

        chromeDriver.findElementByXPath("/html/body/form/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[1]/div/div[2]/div/input")
                .sendKeys(BreatheRightNasalStrips.getRandomName(true));

        chromeDriver.findElementByXPath("/html/body/form/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[2]/div/input")
                .sendKeys(BreatheRightNasalStrips.getRandomName(false));

        chromeDriver.findElementByXPath("/html/body/form/div[2]/div[2]/div[2]/div[4]/div[2]/div/input").sendKeys(BreatheRightNasalStrips.getRandomEmailAddressFromValidEmailAddresses());

        chromeDriver.findElementByXPath("/html/body/form/div[2]/div[2]/div[2]/div[4]/div[2]/div/input")
                .sendKeys(BreatheRightNasalStrips.getRandomEmailAddressFromValidEmailAddresses());

        chromeDriver.findElementByXPath("/html/body/form/div[2]/div[2]/div[2]/div[6]/div[2]/div/div[3]/div/div[2]/div/input")
                .sendKeys(BreatheRightNasalStrips.getErieSt());

        chromeDriver.findElementByXPath("/html/body/form/div[2]/div[2]/div[2]/div[6]/div[2]/div/div[4]/div/div[2]/div/input")
                .sendKeys(BreatheRightNasalStrips.getRandomAddressAttention());

        chromeDriver.findElementByXPath("/html/body/form/div[2]/div[2]/div[2]/div[6]/div[2]/div/div[6]/div/div[2]/div/input")
                .sendKeys("College Park");

        Select state = new Select(chromeDriver.findElementByXPath("/html/body/form/div[2]/div[2]/div[2]/div[6]/div[2]/div/div[7]/div/div[2]/select"));
        state.selectByValue("MD");

        chromeDriver.findElementByXPath("/html/body/form/div[2]/div[2]/div[2]/div[6]/div[2]/div/div[8]/div/div[2]/div/input").sendKeys("20740");

        Select month = new Select(chromeDriver.findElementByXPath("/html/body/form/div[2]/div[2]/div[2]/div[7]/div[2]/div/div[1]/div/div[2]/select"));
        month.selectByValue("10424");
        Select day = new Select(chromeDriver.findElementByXPath("/html/body/form/div[2]/div[2]/div[2]/div[7]/div[2]/div/div[2]/div/div[2]/select"));
        day.selectByValue("17");
        Select year = new Select(chromeDriver.findElementByXPath("/html/body/form/div[2]/div[2]/div[2]/div[7]/div[2]/div/div[3]/div/div[2]/select"));
        year.selectByValue("1991");

        chromeDriver.findElementByXPath("/html/body/form/div[2]/div[2]/div[2]/fieldset[2]/div/ul[1]/li[2]/label").click();
        chromeDriver.findElementByXPath("/html/body/form/div[2]/div[2]/div[2]/fieldset[3]/div/ul[2]/li[1]/label").click();
        chromeDriver.findElementByXPath("/html/body/form/div[2]/div[2]/div[2]/fieldset[4]/div/ul/li[1]/label").click();
        Thread.sleep(1738);
    }
}

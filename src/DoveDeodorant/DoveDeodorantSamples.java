package DoveDeodorant;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.GregorianCalendar;

public class DoveDeodorantSamples {
    private ChromeDriver chromeDriver;

    {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        chromeDriver = new ChromeDriver();
    }

    @Test
    public void getDeodorantSamples() throws Exception {
        String url = "https://topboxcircle.com/pages/2020/cs-2020-06-ul-dove";
        chromeDriver.get(url);
        Thread.sleep(5000);
        chromeDriver.findElement(By.name("sgE-5650648-4-34")).sendKeys("Kris");
        chromeDriver.findElementById("sgE-5650648-4-35-element").sendKeys("Sooklal");
        chromeDriver.findElementById("sgE-5650648-4-103-element").sendKeys("ksooklal" + new GregorianCalendar().getTimeInMillis() + "@yahoo.com");
        chromeDriver.findElementById("sgE-5650648-4-95-element").sendKeys("4809 Erie St");
        chromeDriver.findElementById("sgE-5650648-4-97-element").sendKeys("College Park");
        Select state = new Select(chromeDriver.findElementById("sgE-5650648-4-100-element"));
        state.selectByValue("MD");
        chromeDriver.findElementById("sgE-5650648-4-101-element").sendKeys("20740");
        Select month = new Select(chromeDriver.findElementById("sgE-5650648-4-109-element"));
        month.selectByValue("10424");
        Select day = new Select(chromeDriver.findElementById("sgE-5650648-4-110-element"));
        day.selectByValue("17");
        Select year = new Select(chromeDriver.findElementById("sgE-5650648-4-111-element"));
        year.selectByValue("1991");
        chromeDriver.findElementById("sgE-5650648-4-139-10497").click();
        chromeDriver.findElementById("sgE-5650648-4-140-10516").click();
        chromeDriver.findElementById("sgE-5650648-4-141-10527").click();
        chromeDriver.findElementByClassName("recaptcha-checkbox-border").click();
        chromeDriver.findElementById("sgE-5650648-4-104-10215").clear();
        chromeDriver.findElementById("sg_NextButton").click();
        Thread.sleep(1738);
    }
}

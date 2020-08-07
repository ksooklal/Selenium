package CarolinaCotton;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.GregorianCalendar;

public class CarolinaCotton {
    private ChromeDriver chromeDriver;

    {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        chromeDriver = new ChromeDriver();
    }

    @Test
    public void getCottonProductSamples () throws Exception {
        String url = "https://carolinacotton.net/request-a-sample/";
        chromeDriver.get(url);
        Thread.sleep(1738);
        chromeDriver.findElementById("nf-field-5").sendKeys("Kris");
        chromeDriver.findElementById("nf-field-6").sendKeys("Sooklal");
        chromeDriver.findElementById("nf-field-11").sendKeys("4809 Erie St.");
        chromeDriver.findElementById("nf-field-12").sendKeys("College Park");
        Select state = new Select(chromeDriver.findElementById("nf-field-13"));
        state.selectByValue("MD");
        chromeDriver.findElementById("nf-field-14").sendKeys("20740");
        chromeDriver.findElementById("nf-field-16").sendKeys("ksooklal" + new GregorianCalendar().getTimeInMillis() + "@yahoo.com");
        Thread.sleep(1738);
        chromeDriver.findElementById("nf-field-18").click();
        chromeDriver.close();
    }
}

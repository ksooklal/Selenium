package BionyxSkinCream;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.GregorianCalendar;

public class BionyxCreamSamples {
    private ChromeDriver chromeDriver;

    {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        chromeDriver = new ChromeDriver();
    }

    @Test
    public void getSkinCreamSamples() throws Exception {
        String url = "https://bionyxskincare.com/free-samples/";
        chromeDriver.get(url);
        Thread.sleep(5000);
        chromeDriver.findElementById("your-name").sendKeys("Kris Sooklal");
        chromeDriver.findElementById("your-street").sendKeys("4809 Erie St.");
        chromeDriver.findElementById("your-city").sendKeys("College Park");
        chromeDriver.findElementById("your-state").sendKeys("MD");
        chromeDriver.findElementById("your-postal").sendKeys("20910");
        chromeDriver.findElementById("your-email").sendKeys("k.sooklal" + new GregorianCalendar().getTimeInMillis() + "@yahoo.com");
    }
}

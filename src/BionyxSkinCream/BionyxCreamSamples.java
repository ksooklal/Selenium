package BionyxSkinCream;

import BreatheRightNasalStrips.BreatheRightNasalStrips;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

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
        chromeDriver.findElementById("your-name").sendKeys(BreatheRightNasalStrips.getRandomName(true) + " " +
                BreatheRightNasalStrips.getRandomName(false));
        chromeDriver.findElementById("your-street").sendKeys(BreatheRightNasalStrips.getErieSt());
        chromeDriver.findElementById("your-apt").sendKeys(BreatheRightNasalStrips.getRandomAddressAttention());
        chromeDriver.findElementById("your-city").sendKeys("College Park");
        chromeDriver.findElementById("your-state").sendKeys("MD");
        chromeDriver.findElementById("your-postal").sendKeys("20910");
        chromeDriver.findElementById("your-email").sendKeys(BreatheRightNasalStrips.getRandomEmailAddressFromValidEmailAddresses());
    }
}

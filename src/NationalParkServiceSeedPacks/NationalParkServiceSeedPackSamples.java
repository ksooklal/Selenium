package NationalParkServiceSeedPacks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.GregorianCalendar;

//@RunWith(Parameterized.class)
public class NationalParkServiceSeedPackSamples {
    private ChromeDriver chromeDriver;

//    @Parameterized.Parameters
//    public static Object[][] data() {
//        return new Object[10][0];
//    }

    {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        chromeDriver = new ChromeDriver();
    }

    @Test
    public void getFreeSeedSamples() throws Exception {
        String homeAddress = "https://altnps.org/seed-packs";
        chromeDriver.get(homeAddress);
        Thread.sleep(1738);

        chromeDriver.findElementById("first_name").sendKeys("Kris");
        chromeDriver.findElementById("last_name").sendKeys("Sooklal");
        chromeDriver.findElementById("email").sendKeys("ksooklal" + new GregorianCalendar().getTimeInMillis() + "@yahoo.com");
        chromeDriver.findElementById("phone_number").sendKeys("4437974588");
        chromeDriver.findElementById("address").sendKeys("4809 Erie St.");
        chromeDriver.findElementById("city").sendKeys("College Park");
        Select state = new Select(chromeDriver.findElementById("state"));
        state.selectByValue("MD");
        chromeDriver.findElementById("zip_code").sendKeys("20740");

        Thread.sleep(679);
        if (new GregorianCalendar().getTimeInMillis() % 2 == 1) {
            chromeDriver.findElementsByName("seed_type").get(1).click();
        } else {
            chromeDriver.findElementsByName("seed_type").get(0).click();
        }
        chromeDriver.findElementByName("agreement").click();
    }
}

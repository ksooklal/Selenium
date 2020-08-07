package CeraVeMoisturizingCream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.GregorianCalendar;

@RunWith(Parameterized.class)
public class CeraVeCreamSamples {
    private ChromeDriver chromeDriver;

    {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        chromeDriver = new ChromeDriver();
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[10][0];
    }

    @Test
    public void getDeodorantSamples() throws Exception {
        String url = "https://cloud.mail.cerave.com/MoisturizingCreamSamples";
        chromeDriver.get(url);
        Thread.sleep(1738);
        chromeDriver.findElementById("datepicker").sendKeys("04171991");
        Thread.sleep(1738);
        new Actions(chromeDriver).moveToElement(chromeDriver.findElementById("idFirstName")).click().perform();
        chromeDriver.findElementById("idFirstName").sendKeys("Kris");
        chromeDriver.findElementById("idLastName").sendKeys("Sooklal");
        chromeDriver.findElementById("idEmailAddress").sendKeys("ksooklal" + new GregorianCalendar().getTimeInMillis() + "@yahoo.com");
        chromeDriver.findElementById("idStreetAddress1").sendKeys("4809 Erie St.");
        chromeDriver.findElementById("idCity").sendKeys("College Park");
        Select state = new Select(chromeDriver.findElementById("idState"));
        state.selectByValue("MD");
        chromeDriver.findElementById("idZipCode").sendKeys("20740");
        Select skinType = new Select(chromeDriver.findElementById("idSkinType"));
        skinType.selectByValue("dry skin");
        Select skinConcern = new Select(chromeDriver.findElementById("idSkinConcern"));
        skinConcern.selectByValue("anti-aging");
        chromeDriver.findElementById("txtOptIn").click();
        Thread.sleep(1738);
        chromeDriver.findElementByClassName("submit").click();
        Thread.sleep(679);
        chromeDriver.close();
    }
}

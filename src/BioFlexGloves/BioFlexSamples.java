package BioFlexGloves;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.GregorianCalendar;

@RunWith(Parameterized.class)
public class BioFlexSamples {
    private ChromeDriver chromeDriver;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[10][0];
    }

    {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        chromeDriver = new ChromeDriver();
    }

    @Test
    public void getFreeBioFlexGloves() throws Exception{
        String homeAddress = "https://www.bio-flex.com/request-a-free-sample/";
        chromeDriver.get(homeAddress);
        Thread.sleep(1738);
        chromeDriver.findElementById("choice_1_13_3").click();
        chromeDriver.findElementById("choice_1_33_4").click();
        chromeDriver.findElementById("input_1_1_3").sendKeys("Kris");
        chromeDriver.findElementById("input_1_1_6").sendKeys("Sooklal");
        chromeDriver.findElementById("input_1_6").sendKeys("ksooklal" + new GregorianCalendar().getTimeInMillis() + "@yahoo.com");
        chromeDriver.findElementById("input_1_4").sendKeys("4437974588");
        chromeDriver.findElementById("input_1_3_1").sendKeys("4809 Erie St.");
        chromeDriver.findElementById("input_1_3_3").sendKeys("College Park");

        Select state = new Select(chromeDriver.findElementById("input_1_3_4"));
        state.selectByValue("Maryland");

        Thread.sleep(679);
        chromeDriver.findElementById("input_1_3_5").sendKeys("20740");
        chromeDriver.findElementById("gform_submit_button_1").click();
        chromeDriver.close();
    }
}

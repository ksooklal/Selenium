package CBDGroundCoffee;

import BreatheRightNasalStrips.BreatheRightNasalStrips;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.GregorianCalendar;

@RunWith(Parameterized.class)
public class CBDGroundCoffee {
    private ChromeDriver chromeDriver;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[679][0];
    }

    {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        chromeDriver = new ChromeDriver();
    }

    @Test
    public void getFreeCBDGroundCoffee() throws Exception {
        chromeDriver.manage().window().maximize();

        String url = "https://puertoricosfinest.com/25115525167/checkouts/353e22c5819d228ae20f79166c5586c9?locale=en&skip_shopify_pay=true";
        chromeDriver.get(url);
        Thread.sleep(1738 + 679);
        //Email Address
        chromeDriver.findElementById("checkout_email_or_phone").sendKeys(BreatheRightNasalStrips.getRandomEmailAddressFromValidEmailAddresses());
        //Opt out of emails
        chromeDriver.findElementById("checkout_buyer_accepts_marketing").click();
        //Get random first name
        chromeDriver.findElementById("checkout_shipping_address_first_name").sendKeys(BreatheRightNasalStrips.getRandomName(true));
        //Get random last name
        chromeDriver.findElementById("checkout_shipping_address_last_name").sendKeys(BreatheRightNasalStrips.getRandomName(false));
        //Get random attention
        String randomAttention = BreatheRightNasalStrips.getRandomAddressAttention();
        chromeDriver.findElementById("checkout_shipping_address_company").sendKeys(randomAttention);
        //Get random address line 1
        String randomAddressLine1 = BreatheRightNasalStrips.getErieSt();
        if (new GregorianCalendar().getTimeInMillis() % 2 == 0) {
            randomAddressLine1 = randomAddressLine1.trim();
        }
        chromeDriver.findElementById("checkout_shipping_address_address1").sendKeys(randomAddressLine1);
        if (new GregorianCalendar().getTimeInMillis() % 1738 == 0) {
            //Get random address line 2
            chromeDriver.findElementById("checkout_shipping_address_address2").sendKeys("ATTN: Kris Sooklal");
        }
        //Set city
        String city = "College Park";
        if (new GregorianCalendar().getTimeInMillis() % 679 == 0) {
            city = "Berwyn Heights";
        }
        chromeDriver.findElementById("checkout_shipping_address_city").sendKeys(city);
        //Set state
        Select stateSelect = new Select(chromeDriver.findElementById("checkout_shipping_address_province"));
        stateSelect.selectByValue("MD");
        //Set zip code
        chromeDriver.findElementById("checkout_shipping_address_zip").sendKeys("20740");
        Thread.sleep(679);

        //Click away from address zip code field
        chromeDriver.findElementById("checkout_remember_me").click();
        Thread.sleep(679);
        chromeDriver.findElementById("checkout_remember_me").click();
        Thread.sleep(679);

        //Click continue button
        chromeDriver.findElementById("continue_button").click();
        Thread.sleep(1738 + 1738);
        //Click continue button
        chromeDriver.findElementById("continue_button").click();
        Thread.sleep(1738 + 1738);
        //Click pay now button
        chromeDriver.findElementById("continue_button").click();
        Thread.sleep(6790);
        chromeDriver.close();
    }
}

package BreatheRightNasalStrips;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.GregorianCalendar;

@RunWith(Parameterized.class)
public class BreatheRightNasalStrips {
    private ChromeDriver chromeDriver;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[6][0];
    }

    {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        chromeDriver = new ChromeDriver();
    }

    public static String getRandomAddressAttention() {
        String [] addressLine2 = new String [] {"ATTN: Kris Sooklal", "ATTN: Kris", "ATTN: Sooklal",
                "RE: Kris Sooklal", "ATTN: Kristian Sooklal", " OR CURRENT RESIDENT", " OR CURRENT HOMEOWNER",
                " OR CURRENT TENANT", " OR CURRENT OCCUPANT", " AND FAMILY", " HOUSEHOLD"};
        int index = 0;
        index += new GregorianCalendar().getTimeInMillis() % (679);
        return index % 17 == 0 ? addressLine2[index % 1738 % addressLine2.length] : "";
    }

    public static String getRandomName(boolean getFirstName) {
        String [] lastNames = new String[] {"Sooklal", "S.", "Baratheon", "Stark", "Snow", "Lannister", "Tyrell",
                "Greyjoy", "S", "Arryn", "Tully", "Mormont", "Rayder", "Tarly", "Sanders", "Barber", "Blackwater"};
        String [] firstNames = new String[] {"Kris", "Kristian", "K", "Chris", "Stannis", "Ned", "Eddard", "Jon",
                "Tywin", "Mace", "Randall", "Mance", "Jon", "Jorah", "Euron", "Blackfish", "Brendan", "Hoster",
                "Deion", "Ronde", "House", "Bronn"};

        int index = 0;
        index += new GregorianCalendar().getTimeInMillis() % (1738 * 679);
        return getFirstName ? firstNames[index % firstNames.length] : lastNames[index % lastNames.length];
    }

    public static void goToYoutubePage(ChromeDriver webDriver) throws Exception {
        String youtubeUrl = "https://www.youtube.com/watch?v=1iW-Z7ntJPg";
        webDriver.get(youtubeUrl);
        Thread.sleep(1738 + 679);
        if (!webDriver.findElementsByClassName("ytp-large-play-button").isEmpty()) {
            try {
                webDriver.findElementByClassName("ytp-large-play-button").click();
            } catch (ElementNotVisibleException e) {
            }
        }
        Thread.sleep(24000 + 1738 + 679);
    }

    public static String getErieSt() {
        int random = 1738;
        random += (new GregorianCalendar().getTimeInMillis() % 679);
        if (random % 4 == 0) {
            return "4809 Erie St. ";
        } else if (random % 4 == 1) {
            return "4809 ERIE ST ";
        } else if (random % 4 == 2) {
            return "4809 Erie Street ";
        } else {
            return "4809 ERIE STREET ";
        }
    }

    @Test
    public void getFreeNasalStrips() throws Exception{
        //goToYoutubePage(chromeDriver);
        chromeDriver.manage().window().maximize();

        String url = "https://www.breatheright.com/samples-sign-up.html";
        chromeDriver.get(url);
        Thread.sleep(1738);
        chromeDriver.findElementById("onetrust-accept-btn-handler").click();
        Thread.sleep(1738);

        chromeDriver.findElementByXPath("/html/body/div[2]/div/div[2]/div/div/div/div/div/div/div/div/div[3]/div/div/div/div/div/div[2]/div/form/div[1]/div[2]/input").sendKeys(getRandomName(true));
        chromeDriver.findElementByXPath("/html/body/div[2]/div/div[2]/div/div/div/div/div/div/div/div/div[3]/div/div/div/div/div/div[2]/div/form/div[2]/div[1]/input").sendKeys(getRandomName(false));
        String emailAddress = getRandomEmailAddressFromValidEmailAddresses();

        chromeDriver.findElementByXPath("/html/body/div[2]/div/div[2]/div/div/div/div/div/div/div/div/div[3]/div/div/div/div/div/div[2]/div/form/div[2]/div[2]/input").sendKeys(emailAddress);
        chromeDriver.findElementByXPath("/html/body/div[2]/div/div[2]/div/div/div/div/div/div/div/div/div[3]/div/div/div/div/div/div[2]/div/form/div[2]/div[3]/input")
                .sendKeys(getErieSt() + getRandomAddressAttention());
        chromeDriver.findElementByXPath("/html/body/div[2]/div/div[2]/div/div/div/div/div/div/div/div/div[3]/div/div/div/div/div/div[2]/div/form/div[2]/div[4]/input").sendKeys("College Park");
        chromeDriver.findElementByXPath("/html/body/div[2]/div/div[2]/div/div/div/div/div/div/div/div/div[3]/div/div/div/div/div/div[2]/div/form/div[2]/div[5]/input").sendKeys("20740");
        Select state = new Select(chromeDriver.findElementByXPath("/html/body/div[2]/div/div[2]/div/div/div/div/div/div/div/div/div[3]/div/div/div/div/div/div[2]/div/form/div[2]/div[6]/select"));
        state.selectByValue("MD");
        Thread.sleep(1738);

        chromeDriver.findElementByXPath("/html/body/div[2]/div/div[2]/div/div/div/div/div/div/div/div/div[3]/div/div/div/div/div/div[2]/div/form/div[2]/div[8]/div[1]/input").click();
        chromeDriver.findElementByXPath("/html/body/div[2]/div/div[2]/div/div/div/div/div/div/div/div/div[3]/div/div/div/div/div/div[2]/div/form/div[2]/div[9]/input").click();
        chromeDriver.findElementByXPath("/html/body/div[2]/div/div[2]/div/div/div/div/div/div/div/div/div[3]/div/div/div/div/div/div[2]/div/form/div[2]/div[10]/input").click();
        Thread.sleep(1738);
        chromeDriver.close();
    }

    public static String getRandomEmailAddressFromValidEmailAddresses() {
        String [] gmailAddresses = new String [] {"kristiansooklal", "thenextrondebarber", "rgfisland6791738",
                "kristiansooklalprime09", "rondebarberfan", "kingzoo6791738", "zoovier105", "ksooklal",
                "kingzoo6791738", "kristiansooklalprime10", "leonscott170lbs", "journeymangeorge", "tyquilwoodley",
                "martyfakenewsman84kg", "ralphydosnachos", "1truekingstannisbaratheon", "lordrandalltarly",
                "lordregenteddardstark", "lordregentnedstark", "lordprotectorpetyrbaelish"};

        long timeInMillis = new GregorianCalendar().getTimeInMillis();
        int randomIndex = 0;
        randomIndex += timeInMillis % gmailAddresses.length;

        int numberOfPossiblePeriods = gmailAddresses[randomIndex].length() / 3;
        numberOfPossiblePeriods = (randomIndex + numberOfPossiblePeriods + 1) % numberOfPossiblePeriods;
        if (numberOfPossiblePeriods > gmailAddresses[randomIndex].length() || numberOfPossiblePeriods < 2) {
            numberOfPossiblePeriods = 3;
        }
        return insertMultiplePeriodsInEmailAddress(gmailAddresses[randomIndex], numberOfPossiblePeriods)
                 + "@gmail.com";

    }

    private static String insertPeriodInEmailAddress(String emailAddress){
        if (emailAddress.length() < 2 || emailAddress.contains(".")) {
            return emailAddress;
        }

        String firstCharacter = emailAddress.substring(0, 1);
        String lastCharacter = emailAddress.substring(emailAddress.length() - 1);

        if (emailAddress.length() == 2) {
            return firstCharacter + "." + lastCharacter;
        }

        String middleString = emailAddress.substring(1, emailAddress.length() - 1);

        long randomIndex = new GregorianCalendar().getTimeInMillis() % (middleString.length());
        int periodIndex = 0;
        periodIndex += randomIndex;
        if (periodIndex == 0) {
            middleString = "." + middleString;
        } else if (periodIndex == middleString.length() - 1) {
            middleString = middleString + ".";
        } else {
            middleString = middleString.substring(0, periodIndex) + "." + middleString.substring(periodIndex);
        }
        return firstCharacter + middleString + lastCharacter;
    }

    public static String insertMultiplePeriodsInEmailAddress(String emailAddress, int numberOfPeriods){
        int lengthOfEmail = emailAddress.length();
        String finalEmail = "";

        if (lengthOfEmail / numberOfPeriods >= 2) {
            int lengthOfSubString = lengthOfEmail / numberOfPeriods;
            String [] emailSubstrings = new String[numberOfPeriods];
            for (int i = 0; i < numberOfPeriods; i++) {
                if (i == (numberOfPeriods - 1)) {
                    emailSubstrings[i] = emailAddress.substring(i*lengthOfSubString);
                } else {
                    emailSubstrings[i] = emailAddress.substring(i*lengthOfSubString, (i+1)*lengthOfSubString);
                }
            }

            for (int i = 0; i < numberOfPeriods; i++) {
                emailSubstrings[i] = insertPeriodInEmailAddress(emailSubstrings[i]);
            }

            for (int i = 0; i < numberOfPeriods; i++) {
                finalEmail += emailSubstrings[i];
            }
            return finalEmail;
        } else {
            return insertPeriodInEmailAddress(emailAddress);
        }
    }
}

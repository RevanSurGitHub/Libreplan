package groupe2.libreplan;

import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SocleTechnique {

	static WebDriver driver;
	static Logger logger = LoggerFactory.getLogger(GestionDunProfilTest.class);

	public static WebDriver OpenNav (String adresseWeb, ENav navigateur) {

		switch (navigateur) {
		case firefox:
			System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(adresseWeb);
			return driver;
		case chrome:
			System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(adresseWeb);
			return driver;

		default :
			return null;
		}
	}

	public static void CloseNav(WebDriver driver) {
		driver.close();
	}


	public static void RemplirChamp(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);

	}

	public static void RemplirLoginMdp (WebElement elementLogin, WebElement elementMdp, WebElement boutonConnect, String Login, String Mdp)
	{
		RemplirChamp(elementLogin, Login);
		RemplirChamp(elementMdp, Mdp);
		boutonConnect.click();

	}





	// --------------------- Assertion maison avec logger ------------------------------

	static public void assertTrueLogger(String message, boolean condition, Logger l) {
		if (!condition) {
			l.error(message);
		}
	}


	static public void assertFalseLogger(String message, boolean condition, Logger l) {
		if (condition) {
			l.error(message);
		}
	}

	static public void assertEqualsLogger(String message, Object expected, Object actual, Logger l)
	{
		if(!(expected.equals(actual))){
			l.error(message);
			throw new AssertionError(message);
			//Assert.fail();
			
		}
	}







}

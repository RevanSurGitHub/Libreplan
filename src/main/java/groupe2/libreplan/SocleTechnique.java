package groupe2.libreplan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SocleTechnique {
	
	static WebDriver driver;

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
	
	public static void RemplirLoginMdp (WebElement elementLogin, WebElement elementMdp, String Login, String Mdp)
	{
		RemplirChamp(elementLogin, Login);
		RemplirChamp(elementMdp, Mdp);
		
	}
	
	
}

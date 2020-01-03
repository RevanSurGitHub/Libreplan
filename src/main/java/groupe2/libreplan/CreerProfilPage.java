package groupe2.libreplan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreerProfilPage {

	WebDriver driver;
	
	// Texte Créer Profil
	
	@FindBy(xpath = "//table[@class='caption-title z-caption']/tbody/tr[@valign='middle']")
	public WebElement TexteCreerProfil;
	
	
	
	public CreerProfilPage(WebDriver driver) {

		super();
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
		}
	
}

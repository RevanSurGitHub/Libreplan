package groupe2.libreplan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModifierProfilPage {
	WebDriver driver;
	
	
	//Champ Liste déroulant
	
		@FindBy(xpath = "//input[@class='z-combobox-inp']")
		public WebElement champListeDeroulante;
		
		//Bouton supprimer role 
		
		@FindBy(xpath ="//fieldset//tr[1]//tr[2]//img")
		public WebElement boutonSupprimerRole;
		
		
		//bouton supprimer rôle 2 et 3 
		
		@FindBy(xpath ="//fieldset//tr[2]//tr[2]//img")
		public WebElement boutonSupprimerRole2;
		
		@FindBy(xpath ="//fieldset//tr[3]//tr[2]//img")
		public WebElement boutonSupprimerRole3;
		
		//Message Enregistrement profil
		@FindBy(xpath ="//div[@class='message_INFO']")
		public WebElement messageInfoEnregistrement;
		
		// Champ nom ( METTRE ZERATOR1)
		
		@FindBy(xpath = "//tr[@class='z-row']/td[@class='z-row-inner'][2]/div[@class='z-row-cnt z-overflow-hidden']")
		public WebElement champNomProfil;
	
	
	public ModifierProfilPage(WebDriver driver) {

		super();
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
		}

}

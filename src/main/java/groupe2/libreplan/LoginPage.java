package groupe2.libreplan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage  {
	
	WebDriver driver;
	
	// Texte "Se connecter au Systeme"
	
	@FindBy(xpath = "//td[contains(text(),'Accèder au système')]")
	public WebElement TextePageLogin;
	
	//Champ Utilisateur 
	
	@FindBy(xpath = "//input[@id='textfield']")
	public WebElement ChampUtilisateur;
	
	// Champ Mot De Passe
	
	@FindBy(xpath = "//input[@id='textfield2']")
	public WebElement ChampPassword;

	// Bouton Se Connecter 
	
	@FindBy(xpath = "//input[@id='button']")
	public WebElement BoutonSeConnecter;
	
	
	public LoginPage(WebDriver driver) {

		super();
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
		}
		
}

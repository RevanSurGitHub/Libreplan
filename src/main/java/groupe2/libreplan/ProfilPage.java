package groupe2.libreplan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilPage {
	
	WebDriver driver;
	
	//tableau contient les colonnes Nom de profil et action 
	
	@FindBy(xpath = "//div[@class=\"clickable-rows z-grid\"]/div[1]/table/tbody[2]/tr/th[1]")
	public WebElement NomProfilColonne;
	
	@FindBy(xpath = "//div[@class=\"clickable-rows z-grid\"]/div[1]/table/tbody[2]/tr/th[2]")
	public WebElement ActionColonne;
	
	//Bouton Modifier dans Colonne action
	
	
	@FindBy(xpath = "//tr[1]/td[2]/div/table/tbody/tr/td/table/tbody/tr/td[1]/span/table/tbody/tr[2]/td[2]/img")
	public WebElement BoutonModifier;
	
	//Bouton Supprimer dans Colonne action
	
	@FindBy(xpath = "//tr[1]/td[2]/div/table/tbody/tr/td/table/tbody/tr/td[3]/span/table/tbody/tr[2]/td[2]/img")
	public WebElement BoutonSupprimer;
	
	//Bouton Créer
	
	@FindBy(xpath = "//td[@class='z-button-cm'][contains(text(),'Créer')]")
	public WebElement BoutonCreer;
	
	
	
	public ProfilPage(WebDriver driver) {

		super();
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
		}

}

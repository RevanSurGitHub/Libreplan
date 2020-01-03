package groupe2.libreplan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// sur SQUASH : GCO_01 - Créer un type d'heure

public class TypesHeuresPage extends MenuHaut {

	// Pour constructeur
	WebDriver driver;
	
	// Bouton Créer un type d'heure
	@FindBy (xpath = "//span[@class=\"create-button global-action z-button\"]//tbody//td[@class=\"z-button-cm\"]")
	WebElement boutonCreerTypeHeure;
	
	// Prix par défaut le plus récemment créé
	@FindBy (xpath = "//span[contains(text(), \"€\")][1]")
	WebElement contenuPrixParDefaut ;
	
	// Nom du type d'heure le plus récemment créé
	@FindBy (xpath = "//tr[@class=\"clickable-rows z-row\"]/td[2]")
	WebElement contenuNomTypeHeure ;
		
	// Code du type d'heure le plus récemment créé
	@FindBy (xpath="//tr[@class=\"clickable-rows z-row\"]//div[@class=\"z-row-cnt z-overflow-hidden\"]/span[@class=\"z-label\"]")
	WebElement contenuCodeTypeHeure ;
	
	// Message de confirmation après opération d'ajout / modification / suppression
	@FindBy (xpath = "//div[@class=\"message_INFO\"]")
	WebElement messageConfirmation;
	
	
	public TypesHeuresPage (WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

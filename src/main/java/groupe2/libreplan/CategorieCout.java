package groupe2.libreplan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategorieCout extends MenuHaut{

	// Pour constructeur
	WebDriver driver ;
	
	// Fil d'Ariane 2 : Coût
	@FindBy (xpath = "//tr[@class=\"ruta\"]//td[4]/table[2]/tbody/tr/td/table/tbody//tr/td[1]/table/tbody/tr/td/table/tbody/tr/td[3]/span")
	WebElement contenuCout ;
	
	// Fil d'Ariane 3 : Catégories de coût
	@FindBy (xpath = "//tr[@class=\"ruta\"]//td[4]/table[2]/tbody/tr/td/table/tbody//tr/td[3]/table/tbody/tr/td/table/tbody/tr/td[3]/span")
	WebElement contenuCategorieDeCout ;
	
	// Bouton Créer
	@FindBy (xpath = "//td[contains(text(), \"Créer\")]")
	WebElement boutonCreer ;
	
	// ________________________________________Formulaire Créer une Catégorie de Coûts__________________________________________________________
	
	
	
	public CategorieCout (WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }	
}


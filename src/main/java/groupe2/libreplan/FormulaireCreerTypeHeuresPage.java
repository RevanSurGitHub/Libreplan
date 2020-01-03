package groupe2.libreplan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormulaireCreerTypeHeuresPage extends MenuHaut {
	
	// Pour constructeur
	WebDriver driver ;
	
	// Message d'erreur si 1 champ est vide
	@FindBy (xpath = "//div[@class=\"z-errbox-right z-errbox-close\"]")
	WebElement messageErreurChampVide;
	
	// Champ du code de type d'heure
	@FindBy (xpath = "//tr[@valign=\"top\"]//input[@class=\"z-textbox\"]")
	WebElement champCode ;
	
	// Checkbox "Générer le code"
	@FindBy (xpath ="//tr[@valign=\"top\"]//input[@type=\"checkbox\"]")
	WebElement cbGenererLeCode ;

	// Champ du Nom
	@FindBy (xpath = "//tr[@class=\"z-row z-grid-odd\"]//input[@class=\"z-textbox\"]")
	WebElement champNom ;
	
	// Champ Prix par défaut
	@FindBy (xpath = "//input[@class=\"z-decimalbox\"]")
	WebElement champPrixParDefaut ;
	
	// Boutton Enregistrer
	@FindBy (xpath = "//td[contains(text(), \"Enregistrer\")]")
	WebElement boutonEnregistrer ;
	
	// Boutton Sauver et continuer
	@FindBy (xpath = "//td[contains(text(), \"Sauver\")]")
	WebElement boutonSauver ;
	
	// Boutton Annuler
	@FindBy (xpath = "//td[contains(text(), \"Annuler\")]")
	WebElement boutonAnnuler ;
	
	// Checkbox "Activé"
	@FindBy (xpath ="tr[@class=\"z-row z-grid-odd\"]//input[@type=\"checkbox\"]")
	WebElement cbActive ;
	
	
	public FormulaireCreerTypeHeuresPage (WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }	
}

package groupe2.libreplan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormulaireCreerTypeHeuresPage extends MenuHaut {
	
	// Pour constructeur
	WebDriver driver ;
	
	// Champ du code de type d'heure
	@FindBy (xpath = "//tr[@valign=\"top\"]//input[@class=\"z-textbox\"]")
	WebElement champCode ;
	
	// Checkbox "Générer le code"
	@FindBy (xpath ="//tr[@valign=\"top\"]//input[@type=\"checkbox\"]")
	WebElement cbGenererLeCode ;

	
	
	
	
}

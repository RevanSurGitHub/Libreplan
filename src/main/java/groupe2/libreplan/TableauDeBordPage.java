package groupe2.libreplan;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TableauDeBordPage extends MenuHaut {

	//Titre page Tableau de Bord
	@FindBy (xpath = "//div[@class='z-window-embedded-header']")
	WebElement titlePage;
	
}

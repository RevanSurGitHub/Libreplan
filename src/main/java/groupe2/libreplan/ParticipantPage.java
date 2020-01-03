package groupe2.libreplan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ParticipantPage {
	
	//Titre page participant
	@FindBy (xpath = "//div[contains(text(), 'participants')]")
	WebElement titlePage;
	
	//Colonne Surnom
	@FindBy (xpath = "//div[text() = 'Surnom']")
	WebElement colSurnom;
	
	//Colonne Prenom
	@FindBy (xpath = "//div[text() = 'Prénom']")
	WebElement colPrenom;
		
	//Colonne ID
	@FindBy (xpath = "//div[text() = 'ID']")
	WebElement colID;
		
	//Colonne Code
	@FindBy (xpath = "//div[text() = 'Code']")
	WebElement colCode;
		
	//Colonne En file
	@FindBy (xpath = "//div[text() = 'En file']")
	WebElement colEnFile;
		
	//Colonne Operation
	@FindBy (xpath = "//div[text() = 'Opération']")
	WebElement colOperation;

	//Titre du champ filtre
	@FindBy (xpath = "//span[contains(@title, 'filtrer')]")
	WebElement titleFiltre;
	
	//Champ de filtre
	@FindBy (xpath = "//td/span/i/input[contains(@class, 'bandbox')]")
	WebElement champFiltre;	

	//Bouton filtrer en forme de loupe
	@FindBy (xpath = "//td/span/i/i[contains(@class, 'bandbox-btn')]")
	WebElement buttonLoupe;
		
	//Titre du champ Détails Personnels
	@FindBy (xpath = "//span[contains(text(), 'Détails')]")
	WebElement tilteDetail;	
	
	//Champ Détails Personnels
	@FindBy (xpath = "//td[7]/input[@class='z-textbox']")
	WebElement champDetail;
	
	//Bouton Plus d'options
	@FindBy (xpath = "//table[@class='z-caption']/tbody/tr/td[contains(@id,'cnt')]")
	WebElement buttonOption;
	
	//Bouton Filtre
	@FindBy (xpath = "//td[text()='Filtre']")
	WebElement buttonFiltre;	
	
	//Bouton Créer
	@FindBy (xpath = "//div/span/table/tbody/tr/td[text()='Créer']")
	WebElement buttonCreer;		
	
	WebDriver driver;
			
	
	public ParticipantPage (WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

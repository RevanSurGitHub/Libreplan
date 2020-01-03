package groupe2.libreplan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ParticipantPage extends MenuHaut {
	
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
	
	//Message "Participant Enregistré"
	@FindBy (xpath = "//div[@class='message_INFO']/span")
	WebElement messageParticipantEnregistre;	
	
	// Surnom du participant 1 (ligne 1 colonne 1)
	@FindBy (xpath = "//div[4]/div[3]//tr[1]/td[1]/div/span")
	WebElement surnomParticipant1;
	
	// Prenom du participant 1 (ligne 1 colonne 2)
	@FindBy (xpath = "//div[4]/div[3]//tr[1]/td[2]/div/span")
	WebElement prenomParticipant1;
	
	// ID du participant 1 (ligne 1 colonne 3)
	@FindBy (xpath = "//div[4]/div[3]//tr[1]/td[3]/div/span")
	WebElement idParticipant1;
	
	// Code du participant 1 (ligne 1 colonne 4)
	@FindBy (xpath = "//div[4]/div[3]//tr[1]/td[4]/div/span")
	WebElement codeParticipant1;
	
	// "En file" du participant 1 (ligne 1 colonne 5)
	@FindBy (xpath = "//div[4]/div[3]//tr[1]/td[5]/div/span")
	WebElement fileParticipant1;
	
	// titre champ "Période active depuis" du sous menu Option
	@FindBy (xpath = "//td[9]//td[1]/span[@class='z-label']")
	WebElement titlePeriodeActiveDebut;
	
	// Champ "Période active depuis" du sous menu Option
	@FindBy (xpath = "//div[3]/table/tbody/tr/td/table//td[3]//input[@class='z-datebox-inp']")
	WebElement champPeriodeActiveDebut;
	
	// titre champ "à" du sous menu Option
	@FindBy (xpath = "//td[9]//td[5]/span[@class='z-label']")
	WebElement titlePeriodeActiveFin;
	
	// Champ "à" du sous menu Option
	@FindBy (xpath = "//div[3]/table/tbody/tr/td/table//td[7]//input[@class='z-datebox-inp']")
	WebElement champPeriodeActiveFin;
	
	// Titre menu deroulant "Type" du sous menu Option
	@FindBy (xpath = "//td[9]//td[9]/span[@class='z-label']")
	WebElement titleType;
	
	// Menu deroulant "Type" du sous menu Option
	@FindBy (xpath = "//td[11]/select")
	WebElement selectType;
	
	//Champ numero page
	@FindBy (xpath = "//div[4]/div[4]//input")
	WebElement champNumeroPage;
	
	//bouton page suivante
	@FindBy (xpath = "//div[4]/div[4]//button[@class='z-paging-next']")
	WebElement pageSuivante;
	
	//bouton page precedente
	@FindBy (xpath = "//div[4]/div[4]//button[@class='z-paging-prev']")
	WebElement pagePrecedente;
	
	//bouton page fin
	@FindBy (xpath = "//div[4]/div[4]//button[@class='z-paging-last']")
	WebElement pageFin;
	
	//bouton page debut
	@FindBy (xpath = "//div[4]/div[4]//button[@class='z-paging-first']")
	WebElement pageDebut;
	
	WebDriver driver;
			
	
	public ParticipantPage (WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

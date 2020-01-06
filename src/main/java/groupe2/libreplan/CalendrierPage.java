package groupe2.libreplan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendrierPage {

	WebDriver driver;

	// _____________________ ! LISTE CALENDRIERS ! _____________//
	
	// Nom Page

	// Tableau Colonne Nom
	
	@FindBy(xpath = "//div[2]/div/div/div/div/div[1]/div[2]/div/div/div")
	public WebElement nomPage;

	@FindBy(xpath = "//tbody/tr[@class='z-treecols']/th[1]")
	public WebElement nomColonneNom;

	// Tableau Colonne hérité de date

	@FindBy(xpath = "//tbody/tr[@class='z-treecols']/th[2]")
	public WebElement nomColonneHeriteDate;

	// Tableau Colonne héritage à jour

	@FindBy(xpath = "//tbody/tr[@class='z-treecols']/th[3]")
	public WebElement nomColonneHeriteJour;

	// Tableau Colonne Opérations

	@FindBy(xpath = "//tbody/tr[@class='z-treecols']/th[4]")
	public WebElement nomColonneOpérations;

	//	Bouton Créer

	@FindBy(xpath = "//div[3]/span//tr[2]/td[2]")
	public WebElement BoutonCreer;

	// _____________________ ! CREER CALENDRIER ! _____________//

	//Texte Créer calendrier


	@FindBy(xpath = "//td[@class='z-caption-l']")
	public WebElement texteCreerCalendrier;


	//Texte Données de calendrier

	@FindBy(xpath = "//div[3]/div/div[1]/div[3]/ul/li[1]/div/div/div/span")
	public WebElement texteDonneesCalendrier;

	// Formulaire de calendrier

	@FindBy(xpath = "//div[2]/div[3]/div/div[2]")
	public WebElement FormulaireCalendrier;

	// Bouton Enregistrer

	@FindBy(xpath = "//div[2]/div[3]/table//td[1]/span//tr[2]/td[2]")
	public WebElement boutonEnregistrer;

	// Bouton Enregistrer et Continuer

	@FindBy(xpath = "//div[2]/div[3]/table//td[3]//tr[2]/td[2]")
	public WebElement boutonEnregistrerContinuer;

	// Bouton Annuler

	@FindBy(xpath = "//div[2]/div[3]//td[5]/span//tr[2]/td[2]")
	public WebElement boutonAnnuler;

	// Nom Calendrier

	@FindBy(xpath = "//div[2]//tr[1]/td[2]/div/input")
	public WebElement champNomCalendrier;

	// _____________________ !RETOUR LISTE CALENDRIERS ! _____________//

	// Verification Presence Calendrier Test1 
	@FindBy(xpath = "//div[@class='z-treecell-cnt z-overflow-hidden']/span[contains(text(),'test1')]")
	public WebElement presenceTest1;

	//Bouton Créer une dérive

	@FindBy(xpath = "//tr[2]/td[4]//span[1]//tr[2]/td[2]/img")
	public WebElement boutonDerive;

	// _____________________ ! CALENDRIERS DERIVE ! _____________//

	// Nom Calendrier Derive

	@FindBy(xpath = "//div[2]//tr[1]/td[2]/div/input")
	public WebElement champNomCalendrierDerive;

	// Nom Type Dérivé du calendrier test1

	@FindBy(xpath = "//div/div/div[3]/table//tr[2]/td[2]/div/table//td/span")
	public WebElement nomType;


	// Bouton Enregistrer et Continuer

	@FindBy(xpath = "//div[2]/div[3]/table//td[3]//tr[2]/td[2]")
	public WebElement boutonEnregistrerContinuerDerive;

	//Message Alerte "Calendrier - Test 1 existe déjà"

	@FindBy(xpath = "//div[@class='message_WARNING']")
	public WebElement messageAlerte;

	// Message Info calendrier Enregistrement 

	@FindBy(xpath = "//div[@class='message_INFO']")
	public WebElement messageInfoEnregistrement;

	//Texte Créer Nouveau Nom calendrier


	@FindBy(xpath = "//td[@class='z-caption-l']")
	public WebElement texteNouveauNomCreerCalendrier;

	// Bouton Annuler Derive

		@FindBy(xpath = "//div[2]/div[3]//td[5]/span//tr[2]/td[2]")
		public WebElement boutonAnnulerDerive;
		
		
		// _____________________ !RETOUR LISTE CALENDRIERS 2 ! _____________//
		
		
		// Verification Presence Calendrier - Test 1 et Sous Calendrier - Test Calendrier Dérivé		
		
		@FindBy(xpath = "//td[1]//span[3]")
		public WebElement presenceSousCalendrierTest1;
		
		// Bouton Arborescence moins
		
		@FindBy(xpath = "//div[1]/div[3]/div/div[3]//tr[2]/td[1]/div/span[1]")
		public WebElement boutonMoinsArborescence;
		
		//Bouton Créer Copie Calendrier 
		
		@FindBy(xpath = "//tr[2]/td[4]//span[2]//td[2]/img")
		public WebElement boutonCreerCopie;
		
		// _____________________ !Page Copie Calendrier ! _____________//
	
		//Texte Créer calendrier


		@FindBy(xpath = "//td[@class='z-caption-l']")
		public WebElement texteCreerCalendrierCopie;
		
		// Nom Calendrier Copie

		@FindBy(xpath = "//div[2]//tr[1]/td[2]/div/input")
		public WebElement champNomCalendrierCopie;

		// Nom Type  calendrier Copie

		@FindBy(xpath = "//div/div/div[3]/table//tr[2]/td[2]/div/table//td/span")
		public WebElement nomTypeCopie;
		
		// Bouton Enregistrer et Continuer

		@FindBy(xpath = "//div[2]/div[3]/table//td[3]//tr[2]/td[2]")
		public WebElement boutonEnregistrerContinuerCopie;
		
		
		//Message Alerte "Calendrier - Test 1 existe déjà"

		@FindBy(xpath = "//div[@class='message_WARNING']")
		public WebElement messageAlerteCopie;
		
		// Bouton Enregistrer

		@FindBy(xpath = "//div[2]/div[3]/table//td[1]/span//tr[2]/td[2]")
		public WebElement boutonEnregistrerCopie;
		
		
		// _____________________ !RETOUR LISTE CALENDRIERS 3 ! _____________//
		
		
		// Message Info calendrier Enregistrement 

		@FindBy(xpath = "//div[@class='message_INFO']")
		public WebElement messageInfoEnregistrement2;
		
		// Verification Presence Calendrier - Test 2
		
		@FindBy(xpath = "		//div[1]/div[3]//div[3]//tbody[2]/tr[4]/td[1]/div")
		public WebElement presenceSousCalendrierTest2;
				
		
	public CalendrierPage(WebDriver driver) {

		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}

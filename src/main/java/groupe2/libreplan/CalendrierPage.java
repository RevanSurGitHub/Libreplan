package groupe2.libreplan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendrierPage {
	
	WebDriver driver;
	
	// _____________________ ! LISTE CALENDRIERS ! _____________//
	
	// Tableau Colonne Nom
	
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
	
	
	
	
	public CalendrierPage(WebDriver driver) {

		super();
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
		}

}

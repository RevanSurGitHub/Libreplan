package groupe2.libreplan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreerProfilPage {

	WebDriver driver;
	
	// Texte Créer Profil
	
	@FindBy(xpath = "//table[@class='caption-title z-caption']/tbody/tr[@valign='middle']")
	public WebElement texteCreerProfil;
	
	// Texte données de profil 
	
	@FindBy(xpath = "//span[@class='z-tab-text']")
	public WebElement texteDonneesProfil;
	
	// Champ nom ( METTRE ZERATOR)
	
	@FindBy(xpath = "//tr[@class='z-row']/td[@class='z-row-inner'][2]/div[@class='z-row-cnt z-overflow-hidden']")
	public WebElement champNomProfil;
	
	
	//Nom Bloc association avec les rôles
	
	@FindBy(xpath = "//legend[@class='z-caption z-caption-readonly']/span")
	public WebElement champNomBloc;

	//liste deroulante
	
	@FindBy(xpath = "//i[@class='z-combobox-btn']")
	public WebElement listeDeroulante;
	
	//Champ Liste déroulant
	
	@FindBy(xpath = "//input[@class='z-combobox-inp']")
	public WebElement champListeDeroulante;
	
	//Bouton Ajouter un rôle
	
	@FindBy(xpath = "//span[@class='z-button']/table/tbody/tr/td[@class='z-button-cm']")
	public WebElement boutonAjouterRole;
	
	//Nom Colonne "nom rôle"
	
	@FindBy(xpath = "//div[@class='z-grid']/div[contains(@style,'width: 636px')]/table/tbody[2]/tr[@class='z-columns']/th[1]")
	public WebElement nomRoleColonne;
	
	// Nom colonne "Actions"
	
	@FindBy(xpath = "//div[@class='z-grid']/div[contains(@style,'width: 636px')]/table/tbody[2]/tr[@class='z-columns']/th[2]")
	public WebElement actionsColonne;
	
	// Bouton Enregistrer
	
	@FindBy(xpath = "//span [@class='save-button global-action z-button']/table/tbody/tr/td[@class='z-button-cm']")
	public WebElement boutonEnregistrer;
	
	//Bouton Sauver et continuer
	
	@FindBy(xpath = "//span [@class='saveandcontinue-button global-action z-button']/table/tbody/tr/td[@class='z-button-cm']")
	public WebElement boutonSauverEtContinuer;
	
	//Bouton Annuler
	
	@FindBy(xpath = "//span [@class='cancel-button global-action z-button']/table/tbody/tr/td[@class='z-button-cm']")
	public WebElement boutonAnnuler;
	
	//Bouton supprimer après "ajouter un role" et pop up avec message "supprimer"
	
	@FindBy(xpath ="//fieldset//tr[1]//tr[2]//img")
	public WebElement boutonSupprimerRole;
	
	@FindBy(xpath ="//div[@class='z-row-cnt z-overflow-hidden']/span[@title='Supprimer']") 
	public WebElement popUpSupprimer;
	
	//bouton supprimer rôle 2 et 3 
	
	@FindBy(xpath ="//fieldset//tr[2]//tr[2]//img")
	public WebElement boutonSupprimerRole2;
	
	@FindBy(xpath ="//fieldset//tr[3]//tr[2]//img")
	public WebElement boutonSupprimerRole3;
	

	
	
	
	public CreerProfilPage(WebDriver driver) {

		super();
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
		}
	
}
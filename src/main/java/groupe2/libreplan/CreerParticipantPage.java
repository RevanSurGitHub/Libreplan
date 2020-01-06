package groupe2.libreplan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreerParticipantPage extends MenuHaut {
	
	//Onglet Données Personnelles
	@FindBy (xpath ="//span[contains(text(),'personnelles')]")
	WebElement ongletDonneesPersonnelles;
	
	//Titre bloc Données de base
	@FindBy (xpath ="//span[contains(text(),'Données de base')]")
	WebElement blocDonneesDeBase;
	
	//Titre champ Code
	@FindBy (xpath ="//fieldset[1]//tr[1]//div/span")
	WebElement titleChampCode;
	
	//Champ Code 
	@FindBy (xpath ="//input[@class='z-textbox z-textbox-disd z-textbox-text-disd']")
	WebElement champCode;
	
	//CheckBox Code 
	@FindBy (xpath ="//fieldset//tr//input[@type='checkbox']")
	WebElement cbCode;
	
	//Titre checkBox Code 
	@FindBy (xpath ="//fieldset//tr//label")
	WebElement titleCbCode;
	
	//Titre champ Prenom (2éme ligne)
	@FindBy (xpath ="//fieldset[1]//tr[2]//span")
	WebElement titleChampPrenom;
	
	//Champ Prenom (2éme ligne)
	@FindBy (xpath ="//fieldset[1]//tr[2]//input")
	WebElement champPrenom;
	
	//titre du champ Nom (4éme ligne)
	@FindBy (xpath ="//fieldset[1]//tr[4]//span")
	WebElement titleChampNom;
	
	//Champ Nom (4éme ligne)
	@FindBy (xpath ="//fieldset[1]//tr[4]//input")
	WebElement champNom;
	
	//titre du champ ID (ligne 5)
	@FindBy (xpath ="//fieldset[1]//tr[5]//span")
	WebElement titleChampID;
	
	//Champ ID
	@FindBy (xpath ="//fieldset[1]//tr[5]//input")
	WebElement champID;
	
	//titre du champ Type
	@FindBy (xpath ="//fieldset[1]//tr[6]//span")
	WebElement titleChampType;
	
	//titre de la liste Type
	@FindBy (xpath ="//fieldset[1]//select")
	WebElement selectChampType;
	
	//titre bloc Utilisateur lié
	@FindBy (xpath ="//fieldset[2]/legend/span")
	WebElement blocUtilisateur;
	
	//titre bouton radio "non lié"
	@FindBy (xpath ="//fieldset[2]//span[1]/label")
	WebElement titleNonLie;
	
	//Bouton radio "Non lié"
	@FindBy (xpath ="//fieldset[2]//span[1]/input")
	WebElement radioNonLie;
	
	//titre bouton radio "Utilisateur existant"
	@FindBy (xpath ="//fieldset[2]//span[2]/label")
	WebElement titleUtilisateurExistant;
	
	//Bouton radio "Utilisateur Existant"
	@FindBy (xpath ="//fieldset[2]//span[2]/input")
	WebElement radioUtilisateurExistant;
	
	//titre bouton radio "Creer un nouvel utilisateur"
	@FindBy (xpath ="//fieldset[2]//span[3]/label")
	WebElement titleCreerUtilisateur;
	
	//Bouton radio "Creer un nouvel Utilisateur"
	@FindBy (xpath ="//fieldset[2]//span[3]/input")
	WebElement radioCreerUtilisateur;
	
	//Bouton "Enregistrer"
	@FindBy (xpath ="//div[2]/div[3]/span[1]//td[@class='z-button-cm']")
	WebElement buttonEnregistrer;	
	
	//Bouton "Sauver et continuer"
	@FindBy (xpath ="//div[2]/div[3]/span[2]//td[@class='z-button-cm']")
	WebElement buttonSauverContinuer;	
	
	//Bouton "Annuler"
	@FindBy (xpath ="//div[2]/div[3]/span[3]//td[@class='z-button-cm']")
	WebElement buttonAnnuler;	
	
	//Bloc Nouvel Utilisateur
	@FindBy (xpath ="//fieldset[2]//div[2]/div[@class='z-panel-header ']")
	WebElement blocNouvelUtilisateur;
	
	//Titre champ Nom d'utilisateur  (ligne 1 colonne 1)
	@FindBy (xpath ="//div[2]/div[2]//tr[1]/td[1]/div/span")
	WebElement titleNomUtilisateur;
	
	//Champ Nom d'utilisateur (ligne 1 colonne 2)
	@FindBy (xpath ="//div[2]/div[2]//tr[1]/td[2]/div/span")
	WebElement champNomUtilisateur;	
	
	//Titre champ Mot de passe (ligne 2 colonne 1)
	@FindBy (xpath ="//div[2]/div[2]//tr[2]/td[1]/div/span")
	WebElement titleMotPasse;	
	
	//Champ Mot de passe (ligne 2 colonne 2)
	@FindBy (xpath ="//div[2]/div[2]//tr[2]/td[2]/div/span")
	WebElement champMotPasse;	
	
	//Titre champ Confirmer le mot de passe (ligne 3 colonne 1)
	@FindBy (xpath ="//div[2]/div[2]//tr[3]/td[1]/div/span")
	WebElement titleConfirmerMotPasse;	
	
	//Titre champ Nom d'utilisateur (ligne 3 colonne 2)
	@FindBy (xpath ="//div[2]/div[2]//tr[3]/td[2]/div/span")
	WebElement champConfirmerMotPasse;	
	
	//Titre champ Email (ligne 4 colonne 1)
	@FindBy (xpath ="//div[2]/div[2]//tr[4]/td[1]/div/span")
	WebElement titleEmail;	
	
	//Champ Email (ligne 4 colonne 2)
	@FindBy (xpath ="//div[2]/div[2]//tr[4]/td[2]/div/span")
	WebElement champEmail;	

	public CreerParticipantPage (WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
}

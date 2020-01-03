package groupe2.libreplan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// sur SQUASH : GCO_01 - Créer un type d'heure

public class TypesHeuresPage extends MenuHaut {

	// Pour constructeur
	WebDriver driver;
	
	// Titre de la page : Types d'heures liste
	@FindBy (xpath ="//div[@class=\"z-window-embedded-cnt-noborder\"]/div[1]//div[@class=\"z-window-embedded-header\"]")
	WebElement titrePageTypes ;

	// Bouton : Créer un type d'heure
	@FindBy(xpath = "//span[@class=\"create-button global-action z-button\"]//tbody//td[@class=\"z-button-cm\"]")
	WebElement boutonCreerTypeHeure;

	// Prix par défaut le plus récemment créé
	@FindBy(xpath = "//span[contains(text(), \"€\")][1]")
	WebElement contenuPrixParDefaut;

	// Nom du type d'heure le plus récemment créé
	@FindBy(xpath = "//tr[@class=\"clickable-rows z-row\"]/td[2]")
	WebElement contenuNomTypeHeure;

	// Code du type d'heure le plus récemment créé
	@FindBy(xpath = "//tr[@class=\"clickable-rows z-row\"]//div[@class=\"z-row-cnt z-overflow-hidden\"]/span[@class=\"z-label\"]")
	WebElement contenuCodeTypeHeure;

	// Message de confirmation après opération d'ajout / modification / suppression
	@FindBy(xpath = "//div[@class=\"message_INFO\"]")
	WebElement messageConfirmation;

	// ________________________________________Formulaire Créer un Type d'Heures__________________________________________________________

	// Titre de la page : Créer Type d'heures 
	@FindBy (xpath = "//td[@class=\"z-caption-l\"]")
	WebElement titrePageCreerType ;
	
	// Message d'erreur si 1 champ est vide
	@FindBy(xpath = "//div[@class=\"z-errbox-right z-errbox-close\"]")
	WebElement messageErreurChampVide;

	// Message d'erreur si prix mal rempli
	@FindBy(xpath = "//div[@title=\"Allez sur le mauvais champ\"]/div[@class=\"z-errbox-right z-errbox-close\"])")
	WebElement messageErreurPrix;

	// Champ : Code Disabled
	@FindBy(xpath = "//input[@class=\"z-textbox z-textbox-disd z-textbox-text-disd\"]")
	WebElement champCodeDisabled;

	// Champ du Code
	@FindBy(xpath = "//tr[@valign=\"top\"]//input[@class=\"z-textbox\"]")
	WebElement champCode;

	// Checkbox : Générer le code
	@FindBy(xpath = "//tr[@valign=\"top\"]//input[@type=\"checkbox\"]")
	WebElement cbGenererLeCode;

	// Champ du Nom
	@FindBy(xpath = "//input[@class=\"z-textbox\"]")
	WebElement champNom;

	// Champ Prix par défaut VIDE
	@FindBy(xpath = "//input[@class=\"z-decimalbox\"]")
	WebElement champPrixParDefaut;

	// Checkbox : Activé
	@FindBy(xpath = "tr[@class=\"z-row z-grid-odd\"]//input[@type=\"checkbox\"]")
	WebElement cbActive;

	// Boutton : Enregistrer
	@FindBy(xpath = "//td[contains(text(), \"Enregistrer\")]")
	WebElement boutonEnregistrer;

	// Boutton : Sauver et continuer
	@FindBy(xpath = "//td[contains(text(), \"Sauver\")]")
	WebElement boutonSauver;

	// Boutton : Annuler
	@FindBy(xpath = "//td[contains(text(), \"Annuler\")]")
	WebElement boutonAnnuler;
	
	public TypesHeuresPage (WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

package groupe2.libreplan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoriesCoutPage extends MenuHaut {

	// Pour constructeur
	WebDriver driver ;
	
	// Titre de la page : Catégories de coût Liste
	@FindBy (xpath ="//div[@class=\"z-window-embedded-cnt-noborder\"]/div[1]//div[@class=\"z-window-embedded-header\"]")
	WebElement titreCategoriesListe ;
	
	// Bouton Créer
	@FindBy (xpath = "//td[contains(text(), \"Créer\")]")
	WebElement boutonCreer ;
	
	// Titre colonne 1 : Nom de catégorie 
	@FindBy (xpath = "//div[@class=\"clickable-rows z-grid\"]//th[1]//div[@class=\"z-column-cnt\"]") 
	WebElement titreColonneNomCategorie ;
	
	// Titre colonne 1 : Activé
	@FindBy (xpath = "//div[@class=\"clickable-rows z-grid\"]//th[2]//div[@class=\"z-column-cnt\"]")
	WebElement titreColonneActive ;
	
	// Titre colonne 1 : Actions
	@FindBy (xpath = "//div[@class=\"clickable-rows z-grid\"]//th[3]//div[@class=\"z-column-cnt\"]")
	WebElement titreColonneActions ;
	
	
	// ________________________________________Formulaire Créer une Catégorie de Coûts__________________________________________________________
	
	// Titre page Créer Catégorie de coût
	@FindBy (xpath = "//td[@class=\"z-caption-l\"]")
	WebElement titreCreerCategorie ;
	
	// Titre onglet : Donnée de catégorie
	@FindBy (xpath = "//span[@class=\"z-tab-text\"]")
	WebElement titreOnglet ;
	
	// Champ Code Disabled (si pb xpath : //input[@class=\"z-textbox z-textbox-disd z-textbox-text-disd\"] )
	@FindBy(xpath = "//td[1]/input")
	WebElement champCodeDisabled;
	
	// Champ du Code (si pb xpath : //tr[@valign=\"top\"]//input[@class=\"z-textbox\"] )
	@FindBy(xpath = "//td[1]/input")
	WebElement champCode;

	// Checkbox "Générer le code" (si pb xpath : //tr[@valign=\"top\"]//input[@type=\"checkbox\"] )
	@FindBy(xpath = "//td[3]/span/input")
	WebElement cbGenererLeCode;
	
	// Champ du Nom (si pb xpath : //input[@class=\"z-textbox\"] )
	@FindBy(xpath = "//div/input")
	WebElement champNom;
	
	// Checkbox : Activé
	@FindBy (xpath ="//div/span/input[@type=\"checkbox\"]")
	WebElement cbActive ;
	
	// Titre block : Coûts des heures
	@FindBy (xpath = "//tr[3]/td/div/div[1]")
	WebElement titreBlockCouts ;
	
	// Bouton : Ajouter une ligne (si pb xpath : //tr[3]//td[@class="z-button-cm"] )
	@FindBy (xpath = "//div/table/tbody/tr/td/table/tbody/tr/td/span/table/tbody/tr[2]/td[2]")
	WebElement boutonAjouterUneLigne ;
		
	// Tableau : Coûts des heures > colonne : Code
	@FindBy (xpath = "//div[@class=\"z-panel-body\"]//th[1]/div[@class=\"z-column-cnt\"]")
	WebElement titreColonneCode ;
	
	// Tableau : Coûts des heures > colonne : Type
	@FindBy (xpath = "//div[@class=\"z-panel-body\"]//th[2]/div[@class=\"z-column-cnt\"]")
	WebElement titreColonneType ;
	
	// Tableau : Coûts des heures > colonne : Coût horaire
	@FindBy (xpath = "//div[@class=\"z-panel-body\"]//th[3]/div[@class=\"z-column-cnt\"]")
	WebElement titreColonneCoutHoraire ;
	
	// Tableau : Coûts des heures > colonne : Date de début
	@FindBy (xpath = "//div[@class=\"z-panel-body\"]//th[4]/div[@class=\"z-column-cnt\"]")
	WebElement titreColonneDateDebut ;
	
	// Tableau : Coûts des heures > colonne : Date de fin
	@FindBy (xpath = "//div[@class=\"z-panel-body\"]//th[5]/div[@class=\"z-column-cnt\"]")
	WebElement titreColonneDateFin ;
	
	// Tableau : Coûts des heures > colonne : Opérations
	@FindBy (xpath = "//div[@class=\"z-panel-body\"]//th[5]/div[@class=\"z-column-cnt\"]")
	WebElement titreColonneOperations ;
	
	// Bouton : Enregistrer
	@FindBy (xpath = "//span[@class=\"save-button global-action z-button\"]//td[@class=\"z-button-cm\"]")
	WebElement boutonEnregistrer ;
	
	// Bouton : Sauvegarder et continuer
	@FindBy (xpath = "//span[@class=\"saveandcontinue-button global-action z-button\"]//td[@class=\"z-button-cm\"]")
	WebElement boutonSauvegarder ;
	
	// Bouton : Annuler
	@FindBy (xpath = "//span[@class=\"cancel-button global-action z-button\"]//td[@class=\"z-button-cm\"]")
	WebElement boutonAnnuler ;
	
	// Champ : Code Disabled dans Tableau Coûts des heures
	@FindBy (xpath = "//div/input[@class=\"z-textbox z-textbox-disd z-textbox-text-disd\"])")
	WebElement champCodeTableau ;
	
	// Menu déroulant : Type dans Tableau Coûts des heures
	@FindBy (xpath = "//select")
	WebElement selectType;
	
	// Champ : Coût Horaire dans Tableau Coûts des heures
	@FindBy (xpath = "//input[@class=\"z-decimalbox\"]")
	WebElement champCoutHoraireTableau ;
	
	// Champ : Date de début dans Tableau Coûts des heures
	@FindBy (xpath = "//tr[@class=\"z-row\"]/td[4]//input[@class=\"z-datebox-inp\"]")
	WebElement champDateDeDebut ;
	
	// Champ : Date de fin dans Tableau Coûts des heures
	@FindBy (xpath = "//tr[@class=\"z-row\"]/td[5]//input[@class=\"z-datebox-inp\"]")
	WebElement champDateDeFin ;
	
	// Icone : poubelle pour supprimer la ligne dans Tableau Coûts des heures
	@FindBy (xpath  ="//span[@title=\"Supprimer\"]//img")
	WebElement iconeSupprimer ;
	
	public CategoriesCoutPage (WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

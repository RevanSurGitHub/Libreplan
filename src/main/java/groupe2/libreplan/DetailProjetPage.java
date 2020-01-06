package groupe2.libreplan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailProjetPage extends MenuHaut {
	
	//Menu vertical Planification Projet
	@FindBy (xpath="//div[1]/div/table//tr[3]//tr[1]/td/span//td[@class='z-button-cm']")
	WebElement menuPlanificationProjet;
	
	//Menu vertical Detail Projet
	@FindBy (xpath="//tr[5]//td[@class='z-button-cm']")
	WebElement menuDetailProjet;
	
	//Menu vertical Chargement des ressources
	@FindBy (xpath="//tr[9]//td[@class='z-button-cm']")
	WebElement menuChargementRessources;
	
	//Menu vertical Allocation Avancée
	@FindBy (xpath="//tr[17]//td[@class='z-button-cm']")
	WebElement menuAllocationAvance;
	
	//Menu vertical Tableau de Bord
	@FindBy (xpath="//tr[21]//td[@class='z-button-cm']")
	WebElement menuTableauBord;
	
	//Liste des onglets
	@FindBy (xpath="//div[2]/div/div/div[1]/div[3]/ul")
	WebElement listOnglets;
	
	//Onglet WBS
	@FindBy (xpath="//div[2]/div/div/div[1]/div[3]/ul/li[1]//span")
	WebElement ongletWBS;
	
	//Onglet Données Générales
	@FindBy (xpath="//div[2]/div/div/div[1]/div[3]/ul/li[2]//span")
	WebElement ongletDonneesGenerales;
	
	//Onglet Coût
	@FindBy (xpath="//div[2]/div/div/div[1]/div[3]/ul/li[3]//span")
	WebElement ongletCout;
	
	//Onglet Avancement
	@FindBy (xpath="//div[2]/div/div/div[1]/div[3]/ul/li[4]//span")
	WebElement ongletAvancement;
	
	//ONglet Libellées
	@FindBy (xpath="//div[2]/div/div/div[1]/div[3]/ul/li[5]//span")
	WebElement ongletLibelles;
	
	//Onglet Exigences Critères
	@FindBy (xpath="//div[2]/div/div/div[1]/div[3]/ul/li[6]//span")
	WebElement ongletExigenceCritere;
	
	//Onglet Materiel
	@FindBy (xpath="//div[2]/div/div/div[1]/div[3]/ul/li[7]//span")
	WebElement ongletMateriels;
	
	//Onglet formulaire de qualité des tâches
	@FindBy (xpath="//div[2]/div/div/div[1]/div[3]/ul/li[8]//span")
	WebElement ongletFormulaireQualite;
	
	//Onglet Autorisation
	@FindBy (xpath="//div[2]/div/div/div[1]/div[3]/ul/li[9]//span")
	WebElement ongletAutorisation;
	
	//Bouton enregistrer Projet
	@FindBy (xpath="//td/table//table//td[1]/span//tr[2]//img")
	WebElement buttonEnregistrerProjet;
	
	//Bouton annuler Edition
	@FindBy (xpath="//div/table//td/table//table//td[3]//tr[2]//img")
	WebElement buttonAnnulerEdition;
	
	//Texte de l'alerte d'annulation d'Edition
	@FindBy (xpath="//td//td[3]/div/span")
	WebElement alertSortie;
	
	//Bouton OK de l'alerte
	@FindBy (xpath="//td[text()='OK']")
	WebElement buttonAlertOK;
	
	//Bouton Annuler de l'alerte
	@FindBy (xpath="//table[2]//td[text()='Annuler']")
	WebElement buttonAlertAnnuler;
	
	public DetailProjetPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

package groupe2.libreplan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccueilPage extends MenuHaut {
	
	//Bouton creer un projet
	@FindBy (xpath = "//img[@src='/libreplan/common/img/ico_add.png']")
	WebElement buttonCreerProjet;
	
	//Fenetre de création de projet titre du champ Nom
	@FindBy (xpath="//tr[1]/td[1]/div/span")
	WebElement tilteNom;
	
	//Fenetre de création de projet champ Nom
	@FindBy (xpath ="//div/input")
	WebElement champNom;
	
	//Fenetre de création de projet titre du champ Modele
	@FindBy (xpath="//tr[2]/td[1]//span")
	WebElement tilteModele;
	
	//Fenetre de création de projet champ Modele
	@FindBy (xpath ="//tr[2]//input")
	WebElement champModele;
	
	//Fenetre de création de projet titre du champ Code
	@FindBy (xpath="//tr[3]/td[1]/div/span")
	WebElement tilteCode;
	
	//Fenetre de création de projet champ Code
	@FindBy (xpath ="//tr/td[1]/input")
	WebElement champCode;
	
	//Fenetre de création de projet titre de la checkbox Generer Code
	@FindBy (xpath="//td[3]//label")
	WebElement tilteGenererCode;
	
	//Fenetre de création de projet titre checkbox Generer Code
	@FindBy (xpath ="//td[3]//input[@type='checkbox']")
	WebElement cbGenererCode;
	
	//Fenetre de création de projet titre du champ Date de Debut
	@FindBy (xpath="//tr[4]/td[1]//span")
	WebElement tilteDateDebut;
	
	//Fenetre de création de projet champ Date de Debut
	@FindBy (xpath ="//tr[4]/td[2]/div/i/input")
	WebElement champDateDebut;
	
	//Fenetre de création de projet titre du champ Echeance
	@FindBy (xpath="//tr[5]/td[1]/div/span")
	WebElement tilteEcheance;
	
	//Fenetre de création de projet champ Echeance
	@FindBy (xpath ="//tr[5]/td[2]/div/i/input")
	WebElement champEcheance;
	
	//Fenetre de création de projet titre du champ Client
	@FindBy (xpath="//tr[6]/td[1]//span")
	WebElement tilteClient;
	
	//Fenetre de création de projet champ Client
	@FindBy (xpath ="//tr[6]//input")
	WebElement champClient;
	
	//Fenetre de création de projet titre du menu deroulant Calendrier
	@FindBy (xpath="//tr[7]/td[1]//span")
	WebElement tilteCalendrier;
	
	//Fenetre de création de projet menu deroulant Calendrier
	@FindBy (xpath ="//tr[7]//input")
	WebElement selectCalendrier;
	
	//Fenetre de création de projet bouton Accepter
	@FindBy (xpath="//td[text()='Accepter']")
	WebElement buttonAccepter;
	
	//Fenetre de création de projet bouton Annuler
	@FindBy (xpath="//td[text()='Annuler']")
	WebElement buttonAnnuler;
	
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
	
	
	
	
	public AccueilPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
}

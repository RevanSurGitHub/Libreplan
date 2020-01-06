package groupe2.libreplan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListeProjetPage extends MenuHaut {

	//Menu vertical Planification Projet
	@FindBy (xpath="//div[1]/div/table//tr[3]//tr[1]/td/span//td[@class='z-button-cm']")
	WebElement menuPlanificationProjet;
	
	//Tableau présentant la liste des projets
	@FindBy (xpath="//span//div[@class='z-center-body']")
	WebElement tableProjet;
	
	//Nom du premier projet du tableau
	@FindBy (xpath="//td[2]/div/span[@class='z-label']")
	WebElement textNomProjet;
	
	//Date de Debut du premier projet du tableau
	@FindBy (xpath="//td[3]/div/span[@class='z-label']")
	WebElement textDateDebutProjet;
	
	//Echeance du premier projet du tableau
	@FindBy (xpath="//td[4]/div/span[@class='z-label']")
	WebElement textEcheanceProjet;
	
	//Client du premier projet du tableau
	@FindBy (xpath="//td[5]/div/span[@class='z-label']")
	WebElement textClientProjet;
	
	//Budget total du premier projet du tableau
	@FindBy (xpath="//td[6]/div/span[@class='z-label']")
	WebElement textBudgetProjet;
	
	//Heures du premier projet du tableau
	@FindBy (xpath="//td[7]/div/span[@class='z-label']")
	WebElement textHeuresProjet;
	
	//Etat du premier projet du tableau
	@FindBy (xpath="//td[8]/div/span[@class='z-label']")
	WebElement textEtatProjet;
	
	//Icone Modifier de la cellule Operations du premier projet du tableau
	@FindBy (xpath="//td[9]//td[1]/span//img")
	WebElement iconeModifierProjet;
	
	//Icone Supprimer de la cellule Operations du premier projet du tableau
	@FindBy (xpath="//td[9]//td[3]/span//img")
	WebElement iconeSupprimerProjet;
	
	//Icone Voir la Prevision de la cellule Operations du premier projet du tableau
	@FindBy (xpath="//td[9]//td[5]/span//img")
	WebElement iconePrevisionProjet;
	
	//Icone Créer un Modèle de la cellule Operations du premier projet du tableau
	@FindBy (xpath="//td[9]//td[7]/span//img")
	WebElement iconeModeleProjet;


	public ListeProjetPage(WebDriver driver) {
		super();
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
		}
		
}

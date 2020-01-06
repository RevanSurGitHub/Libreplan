package groupe2.libreplan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccueilPage extends MenuHaut {

	@FindBy (xpath = "//img[@src='/libreplan/common/img/ico_add.png']")
	WebElement buttonCreerProjet;
	
	@FindBy (xpath="//tr[1]/td[1]/div/span")
	WebElement tilteNom;
	
	@FindBy (xpath ="//div/input")
	WebElement champNom;
	
	@FindBy (xpath="//tr[2]/td[1]//span")
	WebElement tilteModele;
	
	@FindBy (xpath ="//tr[2]//input")
	WebElement champModele;
	
	@FindBy (xpath="//tr[3]/td[1]/div/span")
	WebElement tilteCode;
	
	@FindBy (xpath ="//tr/td[1]/input")
	WebElement champCode;
	
	@FindBy (xpath="//td[3]//label")
	WebElement tilteGenererCode;
	
	@FindBy (xpath ="//td[3]//input[@type='checkbox']")
	WebElement cbGenererCode;
	
	@FindBy (xpath="//tr[4]/td[1]//span")
	WebElement tilteDateDebut;
	
	@FindBy (xpath ="//tr[4]/td[2]/div/i/input")
	WebElement champDateDebut;
	
	@FindBy (xpath="//tr[5]/td[1]/div/span")
	WebElement tilteEcheance;
	
	@FindBy (xpath ="//tr[5]/td[2]/div/i/input")
	WebElement champEcheance;
	
	@FindBy (xpath="//tr[6]/td[1]//span")
	WebElement tilteClient;
	
	@FindBy (xpath ="//tr[6]//input")
	WebElement champClient;
	
	@FindBy (xpath="//tr[7]/td[1]//span")
	WebElement tilteCalendrier;
	
	@FindBy (xpath ="//tr[7]//input")
	WebElement selectCalendrier;
	
	@FindBy (xpath="//td[text()='Accepter']")
	WebElement buttonAccepter;
	
	@FindBy (xpath="//td[text()='Annuler']")
	WebElement buttonAnnuler;
	
	@FindBy (xpath="//div[1]/div/table//tr[3]//tr[1]/td/span//td[@class='z-button-cm']")
	WebElement menuPlanificationProjet;
	
	@FindBy (xpath="//tr[5]//td[@class='z-button-cm']")
	WebElement menuDetailProjet;
	
	@FindBy (xpath="//tr[9]//td[@class='z-button-cm']")
	WebElement menuChargementRessources;
	
	@FindBy (xpath="//tr[17]//td[@class='z-button-cm']")
	WebElement menuAllocationAvance;
	
	@FindBy (xpath="//tr[21]//td[@class='z-button-cm']")
	WebElement menuTableauBord;
	
	@FindBy (xpath="//div[2]/div/div/div[1]/div[3]/ul/li[1]//span")
	WebElement ongletWBS;
	
	@FindBy (xpath="//div[2]/div/div/div[1]/div[3]/ul/li[2]//span")
	WebElement ongletDonneesGenerales;
	
	@FindBy (xpath="//div[2]/div/div/div[1]/div[3]/ul/li[3]//span")
	WebElement ongletCout;
	
	@FindBy (xpath="//div[2]/div/div/div[1]/div[3]/ul/li[4]//span")
	WebElement ongletAvancement;
	
	@FindBy (xpath="//div[2]/div/div/div[1]/div[3]/ul/li[5]//span")
	WebElement ongletLibelles;
	
	@FindBy (xpath="//div[2]/div/div/div[1]/div[3]/ul/li[6]//span")
	WebElement ongletExigenceCritere;
	
	@FindBy (xpath="//div[2]/div/div/div[1]/div[3]/ul/li[7]//span")
	WebElement ongletMateriels;
	
	@FindBy (xpath="//div[2]/div/div/div[1]/div[3]/ul/li[8]//span")
	WebElement ongletFormulaireQualite;
	
	@FindBy (xpath="//div[2]/div/div/div[1]/div[3]/ul/li[9]//span")
	WebElement ongletAutorisation;
	
	
	public AccueilPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
}

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
	
	
	
	
	
	public AccueilPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
}

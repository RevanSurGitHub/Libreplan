package groupe2.libreplan;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;

public class GestionDunProfilTest {

	WebDriver driver;
	LoginPage login;
	AccueilPage accueil;
	
	String User = "admin";
	String MDP = "admin";
			
	String adresse = "http://localhost:8090/libreplan/common/layout/login.zul";
	
	
	@Before
	public void OuvrirNavEtConnexion ()
	{
		// Ouverture du navigateur et navigation vers la page de login 
		driver = SocleTechnique.OpenNav(adresse, ENav.firefox);
		// Incorporation d'un Implicit wait 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		login = new LoginPage(driver);
		// Remplir le champ login et mot de passe, puis cliquer sur le bouton valider
		SocleTechnique.RemplirLoginMdp(login.champUtilisateur, login.champPassword, login.boutonSeConnecter, User, MDP);
		

	}
	
	@Test
	public void TestGestionProfil ()
	{
		accueil = new AccueilPage(driver);

		// Hover le menu configuration 
		Actions a = new Actions(driver);
		a.moveToElement(accueil.ongletConfigurationMenuHaut).build().perform();
		accueil.ssMenuConfigurationProfilMenuHaut.click();
		
		
		
		
	}
}

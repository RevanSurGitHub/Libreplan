package groupe2.libreplan;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import javax.security.auth.login.CredentialExpiredException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GestionDunProfilTest {

	WebDriver driver;
	LoginPage login;
	AccueilPage accueil;
	ProfilPage profil;
	CreerProfilPage creerProfil;
	

	String User = "admin";
	String MDP = "admin";

	String adresse = "http://localhost:8090/libreplan/common/layout/login.zul";

	// Création d'un logger 
	static Logger logger = LoggerFactory.getLogger(GestionDunProfilTest.class);
	
	

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
	public void TestGestionProfil () throws InterruptedException
	{
		accueil = new AccueilPage(driver);

		// Hover le menu configuration 
		Actions a = new Actions(driver);
		a.moveToElement(accueil.ongletConfigurationMenuHaut).build().perform();
		// Click sur le sous menu 
		accueil.ssMenuConfigurationProfilMenuHaut.click();
		profil = new ProfilPage(driver);
		
		// Verifier la présence des tableaux
		SocleTechnique.assertTrueLogger("La colonne Action n'est pas affichée",profil.actionColonne.isDisplayed(), logger);
		logger.info("Le tableau a bien une colonne Actions");
		SocleTechnique.assertTrueLogger("La colonne nom profil n'est pas affiché",profil.nomProfilColonne.isDisplayed(), logger);
		logger.info("Le tableau a bien une colonne Nom de profil");
		
		//Verifier la présence du bouton créer 
		SocleTechnique.assertTrueLogger("Le bouton créer n'est pas présent",profil.boutonCreer.isDisplayed(), logger);
		logger.info("Le bouton créer est présent");
		
		// Cliquer sur le bouton créer 
		profil.boutonCreer.click();
		creerProfil = new CreerProfilPage(driver);
	
		
		// Verifier la présence du champ nom 
		SocleTechnique.assertTrueLogger("Le champ nom n'est pas présent",creerProfil.champNomProfil.isDisplayed(), logger);
		logger.info("Le champ nom est présent");
		// Verifier la présence de la liste déroulante 
		SocleTechnique.assertTrueLogger("La liste déroulante n'est pas présente",creerProfil.listeDeroulante.isDisplayed(), logger);
		logger.info("La liste déroulante est présente");
		// Verifier la présence du champ de saisie de la liste déroulante 
		SocleTechnique.assertTrueLogger("Le champ de siasie de la liste déroulante n'es pas présent",creerProfil.champListeDeroulante.isDisplayed(), logger);
		logger.info("Le champ de saisie de la liste déroulante est présente");
		
		// Vérifier la présence des colonnes du tableau 
		SocleTechnique.assertTrueLogger("Le tableau n'a pas les deux colonnes action et nom du role",creerProfil.actionsColonne.isDisplayed() && creerProfil.nomRoleColonne.isDisplayed(), logger);
		logger.info("Le tableau a bien deux colones: action et nom du role");
		
		// Verifier la présence des boutons 
		SocleTechnique.assertTrueLogger("Le bouton enregistrer n'est pas présent",creerProfil.boutonEnregistrer.isDisplayed(), logger);
		logger.info("Le bouton enregistrer est présent");
		
		// verifier la présence du bouton annuler 
		SocleTechnique.assertTrueLogger("Le bouton annulé n'est pas présent",creerProfil.boutonAnnuler.isDisplayed(), logger);
		logger.info("Le bouton annulé est présent ");
		
		// Verifier la présence du bouton sauver et continuer 
		SocleTechnique.assertTrueLogger("Le bouton sauver et continuer n'est pas présent",creerProfil.boutonSauverEtContinuer.isDisplayed(), logger);
		logger.info("Le bouton sauver et continuer est présent");
		
		// Saisir une valeur dans le champ nom 
		//SocleTechnique.RemplirChamp(creerProfil.champNomProfil, "Zerator");
		
		creerProfil.champNomProfil.sendKeys("Zerator");
		
		// Choisir un role dans la liste déroulante 
		Actions b = new Actions(driver);
		creerProfil.listeDeroulante.click();
		
		// Solution de contournement du move to element 
		creerProfil.champListeDeroulante.sendKeys(Keys.DOWN);
		creerProfil.champListeDeroulante.sendKeys(Keys.DOWN);
		creerProfil.champListeDeroulante.sendKeys(Keys.DOWN);
		creerProfil.champListeDeroulante.sendKeys(Keys.DOWN);
		creerProfil.champListeDeroulante.sendKeys(Keys.DOWN);
		creerProfil.champListeDeroulante.sendKeys(Keys.DOWN);
		creerProfil.champListeDeroulante.sendKeys(Keys.DOWN);
		creerProfil.champListeDeroulante.sendKeys(Keys.RETURN);
		
		// Cliquer sur le bouton ajouer un role 
		creerProfil.boutonAjouterRole.click();
		
		// Verifier que le nouveau role apparait dans le tableau
		
		

		
		

		
		
		





	}
}

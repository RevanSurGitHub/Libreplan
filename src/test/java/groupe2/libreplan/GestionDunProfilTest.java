package groupe2.libreplan;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import javax.security.auth.login.CredentialExpiredException;

import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GestionDunProfilTest {

	WebDriver driver;
	LoginPage login;
	AccueilPage accueil;
	ProfilPage profil;
	CreerProfilPage creerProfil;
	

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
		assertTrue(profil.actionColonne.isDisplayed());
		System.out.println("Le tableau a bien une colonne Action");
		assertTrue(profil.nomProfilColonne.isDisplayed());
		System.out.println("Le tableau a bien une colonne Nom de profil");
		
		//Verifier la présence du bouton créer 
		assertTrue(profil.boutonCreer.isDisplayed());
		System.out.println("Le bouton créer est présent");
		
		// Cliquer sur le bouton créer 
		profil.boutonCreer.click();
		creerProfil = new CreerProfilPage(driver);
		
		
		// Verifier la présence du champ nom 
		assertTrue(creerProfil.champNomProfil.isDisplayed());
		System.out.println("Le champ nom est présent");
		// Verifier la présence de la liste déroulante 
		assertTrue(creerProfil.listeDeroulante.isDisplayed());
		System.out.println("La liste déroulante est présente");
		// Verifier la présence du champ de saisie de la liste déroulante 
		assertTrue(creerProfil.champListeDeroulante.isDisplayed());
		System.out.println("Le champ de saisie de la liste déroulante est présente");
		
		// Vérifier la présence des colonnes du tableau 
		assertTrue(creerProfil.actionsColonne.isDisplayed() && creerProfil.nomRoleColonne.isDisplayed());
		System.out.println("Le tableau a bien deux colones: action et nom du role");
		
		// Verifier la présence des boutons 
		assertTrue(creerProfil.boutonEnregistrer.isDisplayed());
		System.out.println("Le bouton enregistrer est présent");
		
		// verifier la présence du bouton annuler 
		assertTrue(creerProfil.boutonAnnuler.isDisplayed());
		System.out.println("Le bouton annulé est présent ");
		
		// Verifier la présence du bouton sauver et continuer 
		assertTrue(creerProfil.boutonSauverEtContinuer.isDisplayed());
		System.out.println("Le bouton sauver et continuer est présent");
		
		// Saisir une valeur dans le champ nom 
		//SocleTechnique.RemplirChamp(creerProfil.champNomProfil, "Zerator");
		
		creerProfil.champNomProfil.sendKeys("Zerator");
		
		// Choisir un role dans la liste déroulante 
		creerProfil.listeDeroulante.click();
		Thread.sleep(300);
		Actions b = new Actions(driver);
		b.moveToElement(creerProfil.choixMenuDeroulant1).click().build().perform();
		
		
		// Cliquer sur le bouton ajouer un role 
		creerProfil.boutonAjouterRole.click();
		

		
		

		
		
		





	}
}

// Corresspondance SQUASH : 09 - Gestion des coûts >  GCO_02 - Créer une catégorie de coût 
package groupe2.libreplan;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class CategoriesCoutTest {

	WebDriver driver;
	LoginPage login;
	AccueilPage accueil;
	ProfilPage profil;
	CategoriesCoutPage categoriesCout;
	
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
	public void TestCreerCategorieCout() {
		accueil = new AccueilPage(driver);
		
		// Vérification de l'affichage de l'onglet : Calendrier
		assertTrue(accueil.ongletCalendrierMenuHaut.isDisplayed());

		// Hover le menu : Coût 
		Actions a = new Actions(driver);
		a.moveToElement(accueil.ongletCoutMenuHaut).build().perform();
		
		// Click sur le sous menu : Catégories de coût
		accueil.ssMenuCoutCategorieHeureMenuHaut.click();
		categoriesCout = new CategoriesCoutPage(driver);
		
		// Vérification
		// Affichage de la page : Catégories de coût Liste
		// La page contient : un tableau avec les colonnes suivantes : Nom de catégorie, Activé, Actions
		// un bouton [Créer]
		assertTrue(categoriesCout.titreCategoriesListe.isDisplayed());
		assertTrue(categoriesCout.titreColonneNomCategorie.isDisplayed());
		assertTrue(categoriesCout.titreColonneActive.isDisplayed());
		assertTrue(categoriesCout.titreColonneActions.isDisplayed());
		assertTrue(categoriesCout.boutonCreer.isDisplayed());
		
		
	}


}




































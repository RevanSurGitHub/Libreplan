// Corresspondance SQUASH : 09 - Gestion des coûts >  GCO_02 - Créer une catégorie de coût 
package groupe2.libreplan;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CategoriesCoutTest {

	WebDriver driver;
	LoginPage login;
	AccueilPage accueil;
	ProfilPage profil;
	CategoriesCoutPage categoriesCout;
	
	String User = "admin";
	String MDP = "admin";

	String adresse = "http://localhost:8090/libreplan/common/layout/login.zul";
	
	// Création d'un logger 
	static Logger logger = LoggerFactory.getLogger(CategoriesCoutTest.class);
	
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
		SocleTechnique.assertTrueLogger("Le titre de la page : 'Catégories de coût Liste' n'apparaît pas", categoriesCout.titreCategoriesListe.isDisplayed(), logger);
		SocleTechnique.assertEqualsLogger("Le titre de la colonne : 'Nom de catégorie' n'apparaît pas", "Nom de catégorie", categoriesCout.titreColonneNomCategorie.getText(), logger);
		SocleTechnique.assertEqualsLogger("Le titre de la colonne : 'Activé' n'apparaît pas", "Activé", categoriesCout.titreColonneActive.getText(), logger);
		SocleTechnique.assertEqualsLogger("Le titre de la colonne : 'Actions' n'apparaît pas", "Actions", categoriesCout.titreColonneActions.getText(), logger);
		SocleTechnique.assertTrueLogger("Le bouton : 'Créer' n'apparaît pas", categoriesCout.boutonCreer.isDisplayed(), logger);

		// Vérification du fil d'Ariane : DEBUT > Coût > Catégories de coût
		SocleTechnique.assertTrueLogger("La partie 1 / 3 du fil d'Ariane : 'Début' ne s'affiche pas", accueil.filDarianneDebut.isDisplayed(), logger);
		SocleTechnique.assertEqualsLogger("La partie 2 / 3 du fil d'Ariane : 'Coût' ne s'affiche pas", "Coût", accueil.filDarianneNomDonglet.getText(), logger);
		SocleTechnique.assertEqualsLogger("La partie  / 3 du fil d'Ariane : 'Catégories de coût' ne s'affiche pas", "Catégories de coût", accueil.filDarianneNomSSMenu.getText(), logger);

		// Cliquer sur bouton Créer
		categoriesCout.boutonCreer.click();
		
		// Vérification de l'affichage de la page : Créer Catégorie de coût + onglet : Données de catégorie, avec :
		SocleTechnique.assertTrueLogger("La page : 'Créer Catégorie de coût' ne s'affiche pas", categoriesCout.titreCreerCategorie.isDisplayed(), logger);
		SocleTechnique.assertTrueLogger("L'onglet : 'Données de catégorie' ne s'affiche pas", categoriesCout.titreOnglet.isDisplayed(), logger);	
		
		// champ de saisie : Code, grisé, renseigné avec une valeur par défaut non modifiable
		SocleTechnique.assertTrueLogger("Le champ de saisie : 'Code' n'apparaît pas", categoriesCout.champCodeDisabled.isDisplayed(), logger);
		SocleTechnique.assertFalseLogger("Le champ : Code est modificable par défaut", categoriesCout.champCodeDisabled.isEnabled(), logger);
		
		// associé à une checkbox : Générer le code, cochée par défaut
		SocleTechnique.assertTrueLogger("La checbox : 'Générer le code' n'apparaît pas", categoriesCout.cbGenererLeCode.isDisplayed(), logger);
		SocleTechnique.assertTrueLogger("La checbox : 'Générer le code' n'apparaît pas", categoriesCout.cbGenererLeCode.isSelected() , logger);

		// champ de saisie : Nom, vide
		SocleTechnique.assertTrueLogger("Le champ : 'Nom' n'apparaît pas", categoriesCout.champNom.isDisplayed(), logger);
//		SocleTechnique.assertTrueLogger("Le champ : 'Nom' n'est pas vide", categoriesCout.champNom , logger);
		
		// checkbox : Activé, cochée par défaut
		// bloc : Coûts des heures contenant :
			// bouton [Ajouter une ligne]
			// tableau vide avec les colonnes : Code, Type, Coût horaire, Date de début, Date de fin, Opérations
		// 3 boutons : Enregister, Sauver et continuer, Annuler
		
		
		
		
		
		
	}


}




































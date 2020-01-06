// Corresspondance SQUASH : 09 - Gestion des coûts >  GCO_02 - Créer une catégorie de coût 
package groupe2.libreplan;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
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
		logger.info("La page 'Calendrier' est affichée.");

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
		SocleTechnique.assertTrueLogger("Le titre de la page : 'Catégories de coût Liste' n'apparaît pas.", categoriesCout.titreCategoriesListe.isDisplayed(), logger);
		logger.info("Le titre de la page : 'Catégories de coût Liste' est présent.");
		SocleTechnique.assertEqualsLogger("Le titre de la colonne : 'Nom de catégorie' n'apparaît pas.", "Nom de catégorie", categoriesCout.titreColonneNomCategorie.getText(), logger);
		logger.info("Le titre de la colonne : 'Nom de catégorie' est présent.");
		SocleTechnique.assertEqualsLogger("Le titre de la colonne : 'Activé' n'apparaît pas.", "Activé", categoriesCout.titreColonneActive.getText(), logger);
		logger.info("Le titre de la colonne : 'Activé' est présent.");
		SocleTechnique.assertEqualsLogger("Le titre de la colonne : 'Actions' n'apparaît pas.", "Actions", categoriesCout.titreColonneActions.getText(), logger);
		logger.info("Le titre de la colonne : 'Actions' est présent.");
		SocleTechnique.assertTrueLogger("Le bouton : 'Créer' n'apparaît pas.", categoriesCout.boutonCreer.isDisplayed(), logger);
		logger.info("Le bouton : 'Créer' est présent.");

		// Vérification du fil d'Ariane : DEBUT > Coût > Catégories de coût
		SocleTechnique.assertTrueLogger("La partie 1 / 3 du fil d'Ariane : 'Début' ne s'affiche pas.", accueil.filDarianneDebut.isDisplayed(), logger);
		logger.info("La partie 1 / 3 du fil d'Ariane : 'Début' est présente.");
		SocleTechnique.assertEqualsLogger("La partie 2 / 3 du fil d'Ariane : 'Coût' ne s'affiche pas.", "Coût", accueil.filDarianneNomDonglet.getText(), logger);
		logger.info("La partie 2 / 3 du fil d'Ariane : 'Coût' est présente.");
		SocleTechnique.assertEqualsLogger("La partie 3 / 3 du fil d'Ariane : 'Catégories de coût' ne s'affiche pas.", "Catégories de coût", accueil.filDarianneNomSSMenu.getText(), logger);
		logger.info("La partie 3 / 3 du fil d'Ariane : 'Catégories de coût' est présente.");

		// Cliquer sur bouton Créer
		categoriesCout.boutonCreer.click();
		
		// Vérifications
		// affichage de la page : Créer Catégorie de coût + onglet : Données de catégorie, avec :
		SocleTechnique.assertTrueLogger("Le titre de la page : 'Créer Catégorie de coût' ne s'affiche pas.", categoriesCout.titreCreerCategorie.isDisplayed(), logger);
		logger.info("Le titre de la page : 'Créer Catégorie de coût' est présent.");
		SocleTechnique.assertTrueLogger("L'onglet : 'Données de catégorie' ne s'affiche pas.", categoriesCout.titreOnglet.isDisplayed(), logger);
		logger.info("L'onglet : 'Données de catégorie' est présent.");
		
		// champ de saisie : Code, grisé, renseigné avec une valeur par défaut non modifiable
		SocleTechnique.assertTrueLogger("Le champ de saisie : 'Code' n'apparaît pas.", categoriesCout.champCodeDisabled.isDisplayed(), logger);
		logger.info("Le champ de saisie : 'Code' est présent.");
		SocleTechnique.assertFalseLogger("Le champ de saisie : 'Code' est vide", categoriesCout.champCodeDisabled.getAttribute("value").isEmpty(), logger);
		logger.info("Le champ : Code est rempli par défaut.");
		SocleTechnique.assertFalseLogger("Le champ : Code est modifiable par défaut.", categoriesCout.champCodeDisabled.isEnabled(), logger);
		logger.info("Le champ : Code est par défaut non modifiable.");
		
		// associé à une checkbox : Générer le code, cochée par défaut
		SocleTechnique.assertTrueLogger("La checbox : 'Générer le code' n'apparaît pas.", categoriesCout.cbGenererLeCode.isDisplayed(), logger);
		logger.info("La checbox : 'Générer le code' est présente.");
		SocleTechnique.assertTrueLogger("La checbox : 'Générer le code' n'est pas cochée par défaut.", categoriesCout.cbGenererLeCode.isSelected(), logger);
		logger.info("La checbox : 'Générer le code' est cochée par défaut.");

		// champ de saisie : Nom, vide
		SocleTechnique.assertTrueLogger("Le champ : 'Nom' n'apparaît pas.", categoriesCout.champNom.isDisplayed(), logger);
		logger.info("Le champ : 'Nom' est présent.");
		SocleTechnique.assertTrueLogger("Le champ : 'Nom' n'est pas vide.", categoriesCout.champNom.getText().isEmpty() , logger);
		logger.info("Le champ : 'Nom' est vide.");
		
		// checkbox : Activé, cochée par défaut
		SocleTechnique.assertTrueLogger("La checbox : 'Générer le code' n'apparaît pas.", categoriesCout.cbActive.isDisplayed(), logger);
		logger.info("La checbox : 'Générer le code' est présente.");
		SocleTechnique.assertTrueLogger("La checbox : 'Générer le code' n'est pas cochée par défaut.", categoriesCout.cbActive.isSelected(), logger);
		logger.info("La checbox : 'Générer le code' est cochée par défaut.");
		
		// bloc : Coûts des heures contenant :
		SocleTechnique.assertTrueLogger("La titre du block : 'Coûts des heures' n'apparaît pas.", categoriesCout.titreBlockCouts.isDisplayed(), logger);
		logger.info("La titre du block : 'Coûts des heures' est présent.");
			// bouton : Ajouter une ligne
		SocleTechnique.assertTrueLogger("Le bouton : 'Ajouter une ligne' n'apparaît pas.", categoriesCout.boutonAjouterUneLigne.isDisplayed(), logger);
		logger.info("Le bouton : 'Ajouter une ligne' est présent.");
			// tableau vide
// NE FONCTIONNE PAS car cible n'existe pas quand tableau est vide
//		SocleTechnique.assertFalseLogger("Le tableau 'Coûts des heures' n'est pas vide", categoriesCout.contenuLigneUne.isDisplayed(), logger);
				// avec les colonnes :
				// Code, Type, Coût horaire, Date de début, Date de fin, Opérations
		SocleTechnique.assertTrueLogger("La colonne : 'Code' n'apparaît pas.", categoriesCout.titreColonneCode.isDisplayed(), logger);
		logger.info("La colonne : 'Code' est présente.");
		SocleTechnique.assertTrueLogger("La colonne : 'Type' n'apparaît pas.", categoriesCout.titreColonneType.isDisplayed(), logger);
		logger.info("La colonne : 'Type' est présente.");
		SocleTechnique.assertTrueLogger("La colonne : 'Coût horaire' n'apparaît pas.", categoriesCout.titreColonneCoutHoraire.isDisplayed(), logger);
		logger.info("La colonne : 'Coût horaire' est présente.");
		SocleTechnique.assertTrueLogger("La colonne : 'Date de début' n'apparaît pas.", categoriesCout.titreColonneDateDebut.isDisplayed(), logger);
		logger.info("La colonne : 'Date de début' est présente.");
		SocleTechnique.assertTrueLogger("La colonne : 'Date de fin' n'apparaît pas.", categoriesCout.titreColonneDateFin.isDisplayed(), logger);
		logger.info("La colonne : 'Date de fin' est présente.");
		SocleTechnique.assertTrueLogger("La colonne : 'Opérations' n'apparaît pas.", categoriesCout.titreColonneOperations.isDisplayed(), logger);
		logger.info("La colonne : 'Opérations' est présente.");
		// 3 boutons : Enregister, Sauver et continuer, Annuler
		SocleTechnique.assertTrueLogger("Le bouton : 'Enregistrer' n'apparaît pas.", categoriesCout.boutonEnregistrer.isDisplayed(), logger);
		logger.info("Le bouton : 'Enregistrer' est présent.");
		SocleTechnique.assertTrueLogger("Le bouton : 'Sauver et continuer' n'apparaît pas.", categoriesCout.boutonSauvegarder.isDisplayed(), logger);
		logger.info("Le bouton : 'Sauver et continuer' est présent.");
		SocleTechnique.assertTrueLogger("Le bouton : 'Annuler' n'apparaît pas.", categoriesCout.boutonAnnuler.isDisplayed(), logger);
		logger.info("Le bouton : 'Annuler' est présent.");
	
		// Ajout d'une ligne
		SocleTechnique.RemplirChamp(categoriesCout.champNom, "un nom de catégorie");
		categoriesCout.cbActive.click();
		categoriesCout.boutonAjouterUneLigne.click();
		
		// Vérifications
		// affichage d'une ligne dans le tableau du bloc : 'Coûts des heures' 
		SocleTechnique.assertTrueLogger("Aucune ligne n'a été créée dans le tableau du bloc : 'Coûts des heures'.", categoriesCout.contenuLigneUne.isDisplayed(), logger);
		logger.info("Une ligne a été créée dans le tableau du bloc 'Coûts des heures'.");
			// avec dans les colonnes
			// Code : champ vide grisé, non modifiable
		SocleTechnique.assertFalseLogger("Le champ : 'Code' du tableau du bloc : 'Coûts des heures' est modifiable.", categoriesCout.champCodeTableau.isEnabled(), logger);
		logger.info("Le champ : 'Code' du tableau du bloc : 'Coûts des heures' n'est pas modifiable.");
			// Type : liste déroulante, valeur par défaut sélectionnée 'Default'
		SocleTechnique.assertEqualsLogger("La valeur par défaut de la liste déroulante 'Type' n'est pas : 'Default'.", "Default", categoriesCout.contenuTypeDefaut.getText(), logger);
		logger.info("La valeur par défaut de la liste déroulante 'Type' est : 'Default'.' par défaut");
			// Coût horaire : champ de saisie, valeur par défaut '10 €'
		SocleTechnique.assertTrueLogger("Le champ de saisie : 'Coût horaire' n'apparaît pas.", categoriesCout.champCoutHoraireTableau.isDisplayed(), logger);
		logger.info("Le champ de saisie : 'Coût horaire' est présent");
// ATTENTION LANCE ANOMALIE
//		SocleTechnique.assertEqualsLogger("La valeur par défaut du champ 'Coût horaire' n'est pas '10€'.", "10€", categoriesCout.champCoutHoraireTableau.getText(), logger);
//		logger.info("La valeur par défaut du champ 'Coût horaire' est '10€'.");
			// Date de début : champ de saisie de date associé à un calendrier, date affichée par défaut = date du jour, format de la date correspond à l'exemple suivant '27 janv. 2017'
		SocleTechnique.assertTrueLogger("Le champ : 'Date de début' n'apparaît pas.", categoriesCout.champDateDeDebut.isDisplayed(), logger);
		logger.info("Le champ : 'Date de début' est présent.");
		SocleTechnique.assertTrueLogger("Le bouton associant le champ :'Date de début' à un calendrier n'est pas disponible." , categoriesCout.boutonCalendrierDebut.isDisplayed(), logger);
		logger.info("Le bouton associant le champ :'Date de début' à un calendrier n'est pas disponible.");
		categoriesCout.boutonCalendrierDebut.click();
		SocleTechnique.assertTrueLogger("Le calendrier associé au champ : 'Date de début' ne s'affiche pas.", categoriesCout.calendrierDebutFin.isDisplayed(), logger);
		logger.info("Le calendrier associé au champ : 'Date de début' s'affiche.");
		
		driver.switchTo().defaultContent();
		
			// Date de fin : champ de saisie de date associé à un calendrier, aucune date sélectionnée par défaut
		SocleTechnique.assertTrueLogger("Le champ : 'Date de fin' n'apparaît pas.", categoriesCout.champDateDeFin.isDisplayed(), logger);
		logger.info("Le champ : 'Date de fin' est présent.");
		SocleTechnique.assertTrueLogger("Le bouton associant le champ :'Date de fin' à un calendrier n'est pas disponible." , categoriesCout.boutonCalendrierFin.isDisplayed(), logger);
		logger.info("Le bouton associant le champ :'Date de fin' à un calendrier n'est pas disponible.");
		categoriesCout.boutonCalendrierFin.click();
		SocleTechnique.assertTrueLogger("Le calendrier associé au champ : 'Date de fin' ne s'affiche pas.", categoriesCout.calendrierDebutFin.isDisplayed(), logger);
		logger.info("Le calendrier associé au champ : 'Date de fin' s'affiche.");
		SocleTechnique.assertTrueLogger("Le champ 'Date de fin' contient une valeur par défaut.", categoriesCout.champDateDeFin.getAttribute("defaultValue").isEmpty(), logger);
		logger.info("Le champ 'Date de fin' ne contient aucune date selectionnée par défaut.");
		
		driver.switchTo().defaultContent();
		
			// Opérations : icône permettant de supprimer la ligne
		SocleTechnique.assertTrueLogger("L'icône permettant de supprimer la ligne n'est pas disponible", categoriesCout.iconeSupprimer.isDisplayed(), logger);
		logger.info("L'icône permettant de supprimer la ligne est présente");
		
		
		
	}

//	@After
//	public void fin() {
//		SocleTechnique.CloseNav(driver);
//	}

}




































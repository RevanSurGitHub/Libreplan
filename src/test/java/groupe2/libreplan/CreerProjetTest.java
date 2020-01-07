package groupe2.libreplan;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreerProjetTest {

	WebDriver driver;
	
	LoginPage login;
	AccueilPage accueil;
	DetailProjetPage detailProjet;
	ListeProjetPage listeProjet;
	
	String User = "admin";
	String MDP = "admin";
	
	String datD;
	String datF;
	
	String adresse = "http://localhost:8090/libreplan/common/layout/login.zul";
	
	// Création d'un logger 
		static Logger logger = LoggerFactory.getLogger(CreerProjetTest.class);
		

		@Before
		public void OuvrirNavEtConnexion ()
		{
			// Ouverture du navigateur et navigation vers la page de login 
			driver = SocleTechnique.OpenNav(adresse, ENav.firefox);
			// Incorporation d'un Implicit wait 
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			login = new LoginPage(driver);
			// _______________Step 1_______________  
			// Remplir le champ login et mot de passe, puis cliquer sur le bouton valider
			SocleTechnique.RemplirLoginMdp(login.champUtilisateur, login.champPassword, login.boutonSeConnecter, User, MDP);

		}
		
		@Test
		public void TestCreerProjet() {
			accueil = new AccueilPage(driver);
			//Cliquer sur le bouton creer projet
			accueil.buttonCreerProjet.click();
			//_______________Step 2_______________ 
			//Vérifier les champs proposé par la fenêtre de création de projet
			//Champ Nom
			SocleTechnique.assertEqualsLogger("Le titre du champ n'est pas Nom", "Nom", accueil.tilteNom.getText(), logger);
			logger.info("Dans la fenêtre de création de projet le titre du premier champ est bien Nom");
			SocleTechnique.assertTrueLogger("Le champ Nom n'est pas vide", accueil.champNom.getText().isEmpty(), logger);
			logger.info("Le champ Nom est bien vide");
			//Champ Modele
			SocleTechnique.assertEqualsLogger("Le titre du champ n'est pas Modèle", "Modèle", accueil.tilteModele.getText(), logger);
			logger.info("Dans la fenêtre de création de projet le titre du deuxième champ est bien Modèle");
			SocleTechnique.assertTrueLogger("Le champ Modèle n'est pas vide", accueil.champModele.getText().isEmpty(), logger);
			logger.info("Le champ Modèle est bien vide");
			//Champ Code et Checkbox Générer le code
			SocleTechnique.assertEqualsLogger("Le titre du champ n'est pas Code", "Code", accueil.tilteCode.getText(), logger);
			logger.info("Dans la fenêtre de création de projet le titre du troisième champ est bien Code");
			SocleTechnique.assertEqualsLogger("Le titre de la checkbox n'est pas Générer le code", "Générer le code", accueil.tilteGenererCode.getText(), logger);
			logger.info("Le titre de la checkbox est bien Générer le code");
			SocleTechnique.assertTrueLogger("La case Generer Code n'est pas séléctionnée", accueil.tilteGenererCode.isSelected(), logger);
			logger.info("La case Generer Code est séléctionnée");
			SocleTechnique.assertFalseLogger("Le champ Code est accessible", accueil.champCode.isEnabled(), logger);
			logger.info("Le champ Code est bien innaccessible");
			SocleTechnique.assertFalseLogger("Le champ Code est vide", accueil.champCode.getText().isEmpty(), logger);
			logger.info("Le champ Code est bien pré-rempli");
			//Champ Date de début
			SocleTechnique.assertEqualsLogger("Le titre du champ n'est pas Date de début", "Date de début", accueil.tilteDateDebut.getText(), logger);
			logger.info("Dans la fenêtre de création de projet le titre du quatrième champ est bien Date de début");
			//Création de la date d'aujourd'hui et vérification de la correspondance avec le champ Date de début
			datD = SocleTechnique.DateJour();
			SocleTechnique.assertEqualsLogger("La date n'est pas "+datD,datD, accueil.champDateDebut.getAttribute("value"), logger);
			logger.info("La date est bien "+datD);
			//Champ Echéance
			SocleTechnique.assertEqualsLogger("Le titre du champ n'est pas Echéance", "Echéance", accueil.tilteEcheance.getText(), logger);
			logger.info("Dans la fenêtre de création de projet le titre du cinquième champ est bien Echéance");
			SocleTechnique.assertTrueLogger("Le champ Echéance n'est pas vide", accueil.champEcheance.getText().isEmpty(), logger);
			logger.info("Le champ Echéance est bien vide");
			//Champ Client
			SocleTechnique.assertEqualsLogger("Le titre du champ n'est pas Client", "Client", accueil.tilteClient.getText(), logger);
			logger.info("Dans la fenêtre de création de projet le titre du sixième champ est bien Client");
			SocleTechnique.assertTrueLogger("Le champ Client n'est pas vide", accueil.champClient.getText().isEmpty(), logger);
			logger.info("Le champ Client est bien vide");
			//Menu déroulant Calendrier
			SocleTechnique.assertEqualsLogger("Le titre du champ n'est pas Calendrier", "Calendrier", accueil.tilteCalendrier.getText(), logger);
			logger.info("Dans la fenêtre de création de projet le titre du septième champ est bien Calendrier");
			SocleTechnique.assertEqualsLogger("Le menu déroulant Calendrier n'est pas positionné sur Default", "Default", accueil.selectCalendrier.getAttribute("value"), logger);
			logger.info("Dans la fenêtre de création de projet le menu déroulant Calendrier est bien positionné sur Default");
			
			//_______________Step 3_______________ 
			//Remplir les champs et création d'un projet
			//Champ Nom
			SocleTechnique.RemplirChamp(accueil.champNom, "PROJET_TEST1");
			//Décocher Générer le code et remplir le champ Code
			accueil.cbGenererCode.click();
			SocleTechnique.RemplirChamp(accueil.champCode, "PRJTEST001");
			//Champ date de début
			datF = SocleTechnique.DateFuture(5);
			SocleTechnique.RemplirChamp(accueil.champDateDebut, datF);
			//Champ Echéance
			datF = SocleTechnique.DateFuture(15);
			SocleTechnique.RemplirChamp(accueil.champEcheance, datF);
			//Cliquer sur Accepter
			accueil.buttonAccepter.click();
			
			//Accès à la page Detail Projet
			detailProjet = new DetailProjetPage(driver);
			//Vérification des éléments de la page
			SocleTechnique.assertTrueLogger("Le menu vertical Détail du projet n'est pas séléctionné", detailProjet.menuDetailProjet.isSelected(), logger);
			logger.info("Le menu vertical Détail du projet est séléctionné");
			SocleTechnique.assertTrueLogger("L'onglet WBS (tâches) n'est pas séléctionné", detailProjet.ongletWBS.isSelected(), logger);
			logger.info("L'onglet WBS (tâches) est séléctionné");
			
			//_______________Step 4_______________ 
			//Vérification des éléments du menu vertical
			SocleTechnique.assertEqualsLogger("Le nom du premier menu vertical n'est pas Planification de projet", "Planification de projet", detailProjet.menuPlanificationProjet.getText(), logger);
			logger.info("Le nom du premier menu vertical est bien Planification de projet");
			SocleTechnique.assertEqualsLogger("Le nom du deuxième menu vertical n'est pas Détail du projet", "Détail du projet", detailProjet.menuDetailProjet.getText(), logger);
			logger.info("Le nom du deuxième menu vertical est bien Détail du projet");
			SocleTechnique.assertEqualsLogger("Le nom du troisième menu vertical n'est pas Chargement des ressources", "Chargement des ressources", detailProjet.menuChargementRessources.getText(), logger);
			logger.info("Le nom du troisième menu vertical est bien Chargement des ressources");
			SocleTechnique.assertEqualsLogger("Le nom du quatrième menu vertical n'est pas Allocation avancée", "Allocation avancée", detailProjet.menuAllocationAvance.getText(), logger);
			logger.info("Le nom du quatième menu vertical est bien Allocation avancée");
			SocleTechnique.assertEqualsLogger("Le nom du cinquième menu vertical n'est pas Tableau de bord", "Tableau de bord", detailProjet.menuTableauBord.getText(), logger);
			logger.info("Le nom du cinquième menu vertical est bien Tableau de bord");
			
			//_______________Step 5_______________ 
			//Vérification des onglets
			SocleTechnique.assertTrueLogger("Les onglets ne sont pas affichés", detailProjet.listOnglets.isDisplayed(), logger);
			logger.info("Les onglets sont affichés");
			SocleTechnique.assertEqualsLogger("Le nom du premier onglet n'est pas WBS (tâches)", "WBS (tâches)", detailProjet.ongletWBS.getText(), logger);
			logger.info("Le nom du premier onglet est bien WBS (tâches)");
			SocleTechnique.assertEqualsLogger("Le nom du deuxième onglet n'est pas Données générales", "Données générales", detailProjet.ongletDonneesGenerales.getText(), logger);
			logger.info("Le nom du premier onglet est bien Données générales");
			SocleTechnique.assertEqualsLogger("Le nom du troisième onglet n'est pas Coût", "Coût", detailProjet.ongletCout.getText(), logger);
			logger.info("Le nom du premier onglet est bien Coût");
			SocleTechnique.assertEqualsLogger("Le nom du quatième onglet n'est pas Avancement", "Avancement", detailProjet.ongletAvancement.getText(), logger);
			logger.info("Le nom du premier onglet est bien Avancement");
			SocleTechnique.assertEqualsLogger("Le nom du cinquième onglet n'est pas Libellés", "Libellés", detailProjet.ongletLibelles.getText(), logger);
			logger.info("Le nom du premier onglet est bien Libellés");
			SocleTechnique.assertEqualsLogger("Le nom du sixième onglet n'est pas Exigence de critère", "Exigence de critère", detailProjet.ongletExigenceCritere.getText(), logger);
			logger.info("Le nom du premier onglet est bien Exigence de critère");
			SocleTechnique.assertEqualsLogger("Le nom du septième onglet n'est pas Matériels", "Matériels", detailProjet.ongletMateriels.getText(), logger);
			logger.info("Le nom du premier onglet est bien Matériels");
			SocleTechnique.assertEqualsLogger("Le nom du huitième onglet n'est pas Formulaires qualité des tâches", "Formulaires qualité des tâches", detailProjet.ongletFormulaireQualite.getText(), logger);
			logger.info("Le nom du premier onglet est bien Formulaires qualité des tâches");
			SocleTechnique.assertEqualsLogger("Le nom du neuvième onglet n'est pas Autorisation", "Autorisation", detailProjet.ongletAutorisation.getText(), logger);
			logger.info("Le nom du premier onglet est bien Autorisation");
			
			//_______________Step 6_______________ 
			//Verifier la présence des boutons enregistrer le projet et annuler l'édition et de leurs icones
			SocleTechnique.assertTrueLogger("Le bouton Annuler l'édition n'est pas affiché", detailProjet.buttonAnnulerEdition.isDisplayed(), logger);
			logger.info("Le bouton Annuler l'édition est bien affiché");
			SocleTechnique.assertEqualsLogger("Le bouton Annuler l'édition n'est pas représenté par le bonne icone", "http://localhost:8090/libreplan/common/img/ico_back.png", detailProjet.buttonAnnulerEdition.getAttribute("src"), logger);
			logger.info("Le bouton Annuler l'édition est bien représenté par le bon icone");
			SocleTechnique.assertTrueLogger("Le bouton Enregistrer Projet n'est pas affiché", detailProjet.buttonEnregistrerProjet.isDisplayed(), logger);
			logger.info("Le bouton Enregistrer le projet est bien affiché");
			SocleTechnique.assertEqualsLogger("Le bouton Enregistrer le projet n'est pas représenté par le bonne icone", "http://localhost:8090/libreplan/common/img/ico_save.png", detailProjet.buttonEnregistrerProjet.getAttribute("src"), logger);
			logger.info("Le bouton Enregistrer le projet est bien représenté par le bon icone");

			
			//_______________Step 7_______________ 
			//Cliquer sur le bouton annuler l'édition, verifier l'affichage d'une alerte et de son message
			detailProjet.buttonAnnulerEdition.click();
			SocleTechnique.assertTrueLogger("La fenêtre d'alerte ne s'affiche pas", detailProjet.alertSortie.isDisplayed(), logger);
			logger.info("La fenêtre d'alerte est bien affichée");
			SocleTechnique.assertEqualsLogger("Le message de l'alerte n'est pas conforme", "Les modifications non enregistrées seront perdues. Êtes-vous sûr ?", detailProjet.alertSortie.getText(), logger);
			logger.info("Le message de l'alerte est bien conforme");
			SocleTechnique.assertTrueLogger("Le bouton OK de l'alerte n'est pas present", detailProjet.buttonAlertOK.isDisplayed(), logger);
			logger.info("Le bouton OK de l'alerte est bien affiché");
			SocleTechnique.assertTrueLogger("Le bouton Annuler de l'alerte n'est pas present", detailProjet.buttonAlertAnnuler.isDisplayed(), logger);
			logger.info("Le bouton Annuler de l'alerte est bien affiché");
			
			
			//_______________Step 8_______________ 
			//Cliquer sur le bouton annuler de l'alerte annuler l'édition
			detailProjet.buttonAlertAnnuler.click();
			SocleTechnique.assertFalseLogger("La fenêtre d'alerte est toujours affichée", detailProjet.iframeAlert.isDisplayed(), logger);
			logger.info("La fenêtre d'alerte est bien fermée");
			//Vérifier les élements selectionné dans les menu verticaux et les onglets horizontaux
			SocleTechnique.assertTrueLogger("Le menu vertical Détail du projet n'est pas séléctionné", detailProjet.menuDetailProjet.isSelected(), logger);
			logger.info("Le menu vertical Détail du projet est séléctionné");
			SocleTechnique.assertTrueLogger("L'onglet WBS (tâches) n'est pas séléctionné", detailProjet.ongletWBS.isSelected(), logger);
			logger.info("L'onglet WBS (tâches) est séléctionné");
			
			//_______________Step 9_______________ 
			//Cliquer sur le bouton annuler l'édition, verifier l'affichage d'une alerte et de son message
			detailProjet.buttonAnnulerEdition.click();
			SocleTechnique.assertTrueLogger("La fenêtre d'alerte ne s'affiche pas", detailProjet.alertSortie.isDisplayed(), logger);
			logger.info("La fenêtre d'alerte est bien affichée");
			SocleTechnique.assertEqualsLogger("Le message de l'alerte n'est pas conforme", "Les modifications non enregistrées seront perdues. Êtes-vous sûr ?", detailProjet.alertSortie.getText(), logger);
			logger.info("Le message de l'alerte est bien conforme");
			SocleTechnique.assertTrueLogger("Le bouton OK de l'alerte n'est pas present", detailProjet.buttonAlertOK.isDisplayed(), logger);
			logger.info("Le bouton OK de l'alerte est bien affiché");
			SocleTechnique.assertTrueLogger("Le bouton Annuler de l'alerte n'est pas present", detailProjet.buttonAlertAnnuler.isDisplayed(), logger);
			logger.info("Le bouton Annuler de l'alerte est bien affiché");
			
			//_______________Step 10______________
			//Cliquer sur le bouton OK de l'alerte de sortie
			detailProjet.buttonAlertOK.click();
			accueil = new AccueilPage(driver);
			SocleTechnique.assertTrueLogger("Le menu vertical Planification de projet n'est pas séléctionné", detailProjet.menuPlanificationProjet.isSelected(), logger);
			logger.info("Le menu vertical Planification de projet est séléctionné");

			//_______________Step 11______________
			//Accès à la page liste des projets
			Actions a = new Actions(driver);
			a.moveToElement(accueil.ongletCalendrierMenuHaut).build().perform();
			accueil.ssMenuCalendrierProjetMenuHaut.click();
			listeProjet = new ListeProjetPage (driver);
			SocleTechnique.assertTrueLogger("Le menu vertical Liste des projets n'est pas séléctionné", listeProjet.menuListeProjet.isSelected(), logger);
			logger.info("Le menu vertical Liste des projets est bien séléctionné");
			
			//_______________Step 12______________
			//Vérification des informations du projet
			//Verification du Nom
			SocleTechnique.assertEqualsLogger("L'information du champ Nom est incorrecte", "PROJET_TEST1", listeProjet.textNomProjet.getText(), logger);
			logger.info("L'information du champ Nom est correcte");
			//Verification du Code
			SocleTechnique.assertEqualsLogger("L'information du champ Code est incorrecte", "PRJTEST001", listeProjet.textCodeProjet.getText(), logger);
			logger.info("L'information du champ Code est correcte");
			//Verification de la Date de début
			datF = SocleTechnique.DateFuture(5);
			SocleTechnique.assertEqualsLogger("L'information du champ Date de début est incorrecte", datF, listeProjet.textDateDebutProjet.getText(), logger);
			logger.info("L'information du champ Date de début est correcte");
			//Verification de l'Echéance
			datF = SocleTechnique.DateFuture(15);
			SocleTechnique.assertEqualsLogger("L'information du champ Echeance est incorrecte", datF, listeProjet.textEcheanceProjet.getText(), logger);
			logger.info("L'information du champ Echéance est correcte");
			//Verification de Client
			SocleTechnique.assertTrueLogger("Le champ Client n'est pas vide", listeProjet.textClientProjet.getText().isEmpty(), logger);
			logger.info("Le champ Client est bien vide");
			//Verification du Budget total
			SocleTechnique.assertEqualsLogger("L'information du champ Budget total est incorrecte", "0 €", listeProjet.textBudgetProjet.getText(), logger);
			logger.info("L'information du champ Budget total est correcte");
			//Verification du Heures
			SocleTechnique.assertEqualsLogger("L'information du champ Heures est incorrecte", "0", listeProjet.textHeuresProjet.getText(), logger);
			logger.info("L'information du champ Heures est correcte");
			//Verification du Etat
			SocleTechnique.assertEqualsLogger("L'information du champ Etat est incorrecte", "PRE-VENTES", listeProjet.textEtatProjet.getText(), logger);
			logger.info("L'information du champ Etat est correcte");
			//Vérification des icones de la cellule opération
			SocleTechnique.assertEqualsLogger("L'icone Modifier du champ Opération est incorrecte", "http://localhost:8090/libreplan/common/img/ico_editar1.png", listeProjet.iconeModifierProjet.getAttribute("src"), logger);
			logger.info("L'icone Modifier du champ Operation est correcte");
			SocleTechnique.assertEqualsLogger("L'icone Supprimer du champ Opération est incorrecte", "http://localhost:8090/libreplan/common/img/ico_borrar1.png", listeProjet.iconeSupprimerProjet.getAttribute("src"), logger);
			logger.info("L'icone Supprimer du champ Operation est correcte");
			SocleTechnique.assertEqualsLogger("L'icone Voir la Prevision du champ Opération est incorrecte", "http://localhost:8090/libreplan/common/img/ico_planificador1.png", listeProjet.iconePrevisionProjet.getAttribute("src"), logger);
			logger.info("L'icone Voir la prévision du champ Operation est correcte");
			SocleTechnique.assertEqualsLogger("L'icone Creer un Modele du champ Opération est incorrecte", "http://localhost:8090/libreplan/common/img/ico_derived1.png", listeProjet.iconeModeleProjet.getAttribute("src"), logger);
			logger.info("L'icone Creer un Modele du champ Operation est correcte");
			
		}
	
}

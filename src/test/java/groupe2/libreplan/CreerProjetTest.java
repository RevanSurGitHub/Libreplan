package groupe2.libreplan;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
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
		public void TestCreerProjet() {
			accueil = new AccueilPage(driver);
			//Cliquer sur le bouton creer projet
			accueil.buttonCreerProjet.click();
			
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
			
			//Remplir les champs
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
			
			
			
			
			
			
			
		}
	
}

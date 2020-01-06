package groupe2.libreplan;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreerUnCalendrierTest {

	WebDriver driver;
	LoginPage login;
	AccueilPage accueil;
	CalendrierPage calendrier;

	String User = "admin";
	String MDP = "admin";

	String adresse = "http://localhost:8090/libreplan/common/layout/login.zul";

	// Création d'un logger 
	static Logger logger = LoggerFactory.getLogger(CreerUnCalendrierTest.class);

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
		a.moveToElement(accueil.ongletRessourcesMenuHaut).build().perform();
		// Click sur le sous menu 
		accueil.ssMenuRessourcesCalendrierMenuHaut.click();

		calendrier = new CalendrierPage (driver);

		/// __________ Pas Test 2 _______

		// Verifier Affichage de la page "Liste de calendriers".
		SocleTechnique.assertTrueLogger("le Nom de la page n'est pas le bon ", calendrier.nomPage.isDisplayed(), logger);
		logger.info("Le Nom de la page est bien Liste des calendriers");

		// Verifier la présence des tableaux
		SocleTechnique.assertTrueLogger("le Nom de la colonne n'est pas le bon ", calendrier.nomColonneNom.isDisplayed(), logger);
		logger.info("Le Nom de la Colonne est bien Nom");

		SocleTechnique.assertTrueLogger("le Nom de la colonne n'est pas le bon ", calendrier.nomColonneHeriteDate.isDisplayed(), logger);
		logger.info("Le Nom de la Colonne est bien Herité de la Date");

		SocleTechnique.assertTrueLogger("le Nom de la colonne n'est pas le bon ", calendrier.nomColonneHeriteJour.isDisplayed(), logger);
		logger.info("Le Nom de la Colonne est bien Heritage à Jour");

		SocleTechnique.assertTrueLogger("le Nom de la colonne n'est pas le bon ", calendrier.nomColonneOpérations.isDisplayed(), logger);
		logger.info("Le Nom de la Colonne est bien Opérations");

		// Verifier la présence du bouton Créer
		SocleTechnique.assertTrueLogger("le Bouton Créer n'est pas présent ", calendrier.boutonCreer.isDisplayed(), logger);
		logger.info("Le Bouton Créer est présent dans la page ");

		/// __________ Pas Test 3 _______

		// Click sur le bouton créer 
		calendrier.boutonCreer.click();

		// Verifier Affichage de la page "Créer Calendrier".
		SocleTechnique.assertTrueLogger("le Nom de la page n'est pas le bon ", calendrier.nomCreerCalendrier.isDisplayed(), logger);
		logger.info("Le Nom de la page est bien Créer calendrier");

		// Verifier Affichage de l'onglet "données de calendrier" contenant un formulaire.
		SocleTechnique.assertTrueLogger("le Nom de l'onglet n'est pas le bon ", calendrier.ongletDonneesCalendrier.isDisplayed(), logger);
		logger.info("Le Nom de l'onget est bien Données dans de calendrier ");

		SocleTechnique.assertTrueLogger("le Formulaire n'est pas présent dans l'onglet ", calendrier.formulaireCalendrier.isDisplayed(), logger);
		logger.info("Le formulaire est bien présent dans l'onglet ");


		// Verifier la présence des boutons [Enregistrer], [Enregistrer et continuer] et [Annuler]
		SocleTechnique.assertTrueLogger("le Bouton Enregistrer n'est pas présent ", calendrier.boutonEnregistrer.isDisplayed(), logger);
		logger.info("Le Enregistrer est bien présent ");

		SocleTechnique.assertTrueLogger("le Bouton Enregistrer et continuer n'est pas présent ", calendrier.boutonEnregistrerContinuer.isDisplayed(), logger);
		logger.info("Le Enregistrer et Continuer est bien présent ");

		SocleTechnique.assertTrueLogger("le Bouton Annuler et continuer n'est pas présent ", calendrier.boutonAnnuler.isDisplayed(), logger);
		logger.info("Le Annuler est bien présent ");


		/// __________ Pas Test 4 _______

		// Entrer la donnée Test1 dans le nom du calendrier 
		calendrier.champNomCalendrier.sendKeys("Test1");

		// Cliquer sur le bouton Enregistrer
		calendrier.boutonEnregistrer.click();

		// Verifier le retour à la page "Liste de calendriers".
		SocleTechnique.assertTrueLogger("le retour à la page est incorrect ", calendrier.nomPage.isDisplayed(), logger);
		logger.info("Le retour à la page Liste des calendriers s'est bien effectué");

		// Verifier la présence du calendrier créé
		SocleTechnique.assertTrueLogger("Le Calendrier Test1 n'est pas présent ", calendrier.presenceTest1.isDisplayed(), logger);
		logger.info("Le calendrier Test1 est bien présent ");

		/// __________ Pas Test 5 _______

		// Cliquer sur l'icône "Créer une dérive" dans la colonne "Opération" pour le calendrier "Calendrier - Test 1".
		calendrier.boutonDerive.click();

		// Verifier Affichage de la page "Créer Calendrier".
		SocleTechnique.assertTrueLogger("le Nom de la page n'est pas le bon ", calendrier.nomCreerCalendrier.isDisplayed(), logger);
		logger.info("Le Nom de la page est bien Créer calendrier");

		// Verifier que le champ nom est vide 
		SocleTechnique.assertTrueLogger("Le champ Nom n'est pas vide ", calendrier.champNomCalendrierDerive.getText().isEmpty(), logger);
		logger.info("Le champ Nom est vide");

		// Verifier le nom du champ Type " Dérivé du calendrier calendrier 1"
		//System.out.println(calendrier.nomType.getText());
		//logger.info(calendrier.nomType.getText());
		SocleTechnique.assertEqualsLogger("Le nom de Type n'est pas bon", "Dérivé du calendrier Test1", calendrier.nomType.getText(), logger);
		logger.info("Le  Nom Type est valide");

		/// __________ Pas Test 6 _______


		// Entrer la donnée Test1 dans le nom du calendrier 
		calendrier.champNomCalendrier.sendKeys("Test1");

		// cliquer sur Enregistrer et continuer
		calendrier.boutonEnregistrerContinuerDerive.click();

		//Verifier couleur du message d'erreur

		String color = calendrier.messageAlerte.getCssValue("color");
		//System.out.println(color);
		String hex = Color.fromString(color).asHex();
		//System.out.println(hex);
		SocleTechnique.assertEqualsLogger("la couleur n'est pas bonne", "#cc5013", hex , logger);
		logger.info("La couleur est orange");

		// Verifier contenu du message "Calendrier - Test 1 existe déjà"
		SocleTechnique.assertEqualsLogger("Le message pas bon", "Test1 existe déjà", calendrier.messageAlerte.getText(), logger);
		logger.info("Le message est valide");

		/// __________ Pas Test 7 _______

		// Clear champ Nom 

		calendrier.champNomCalendrier.clear();

		// Entrer la donnée Test Calendrier dérivé dans le nom du calendrier 
		calendrier.champNomCalendrier.sendKeys("Test Calendrier Dérivé");

		// cliquer sur Enregistrer et continuer
		calendrier.boutonEnregistrerContinuerDerive.click();

		//Affichage du message "Calendrier de base "Calendrier - Test Calendrier Dérivé" enregistré".
		//System.out.println(calendrier.messageInfoEnregistrement.getText());
		SocleTechnique.assertEqualsLogger("Le message d'enregistrement n'est pas bon", "Calendrier de base \"Test Calendrier Dérivé\" enregistré", calendrier.messageInfoEnregistrement.getText(), logger);
		logger.info("Le message d'enregistrement est valide");

		// Verifier le titre de la page : Le titre de la page est : "Créer Calendrier: Calendrier - Test Calendrier Dérivé"

		SocleTechnique.assertEqualsLogger("Le Nouveau nom de page n'est pas bon", "Créer Calendrier: Test Calendrier Dérivé", calendrier.texteNouveauNomCreerCalendrier.getText(), logger);
		logger.info("Le nom de la page est valide");

		/// __________ Pas Test 8 _______

		// Cliquer sur le bouton annuler 
		calendrier.boutonAnnulerDerive.click();

		// Verifier Affichage de la page "Liste de calendriers".
		SocleTechnique.assertTrueLogger("le Nom de la page n'est pas le bon ", calendrier.nomPage.isDisplayed(), logger);
		logger.info("Le Nom de la page est bien Liste des calendriers");

		// Verifier la présence du calendrier Test1
		SocleTechnique.assertTrueLogger("Le Calendrier Test1 n'est pas présent ", calendrier.presenceTest1.isDisplayed(), logger);
		logger.info("Le calendrier Test1 est bien présent ");


		// Verifier la présence du calendrier de Calendrier - Test Calendrier Dérivé
		SocleTechnique.assertTrueLogger("Le Calendrier Test Calendrier dérivé n'est pas présent ", calendrier.presenceSousCalendrierTest1.isDisplayed(), logger);
		logger.info("Le calendrier Test Calendrier dérivé est bien présent ");

		// Verifier la présence du calendrier de Calendrier - Test Calendrier Dérivé Dans test 1 
		SocleTechnique.assertTrueLogger("Le Calendrier Test Calendrier dérivé n'est pas présent dans Test 1  ", calendrier.boutonMoinsArborescence.isDisplayed(), logger);
		logger.info("Le calendrier Test Calendrier dérivé est bien présent dans test 1  ");

		/// __________ Pas Test 9 _______

		// Cliquer sur le bouton [-] associé au calendrier "Calendrier - Test 1".
		calendrier.boutonMoinsArborescence.click();

		// Verifier l'absence du calendrier de Calendrier - Test Calendrier Dérivé 
		SocleTechnique.assertFalseLogger("Le Calendrier Test Calendrier dérivé n'est pas présent ", calendrier.presenceSousCalendrierTest1.isDisplayed(), logger);
		logger.info("Le calendrier Test Calendrier dérivé est bien présent dans test 1 ");

		/// __________ Pas Test 10 _______

		//Cliquer sur l'icône "Créer une copie" dans la colonne "Opération" pour le calendrier "Calendrier - Test 1".
		calendrier.boutonCreerCopie.click();

		// Verifier Affichage de la page "Créer Calendrier : Calendrier - Test 1"

		SocleTechnique.assertEqualsLogger("Le Nouveau nom de page n'est pas bon", "Créer Calendrier: Test1", calendrier.texteCreerCalendrierCopie.getText(), logger);
		logger.info("Le nom de la page est valide");

		//  Verifier que le Nom du calendrier = Test1 
		SocleTechnique.assertEqualsLogger("Le nom n'est pas bien rempli", "Test1", calendrier.champNomCalendrierCopie.getAttribute("value"), logger);
		logger.info("Le nom est bien Test1");

		// Verifier le nom du champ Type " Calendrier source"

		SocleTechnique.assertEqualsLogger("Le nom de Type n'est pas bon", "Calendrier source", calendrier.nomTypeCopie.getText(), logger);
		logger.info("Le  Nom Type est valide");

		/// __________ Pas Test 11 _______

		//Ne pas modifier le nom du calendrier puis cliquer sur le bouton [Enregistrer et continuer].
		calendrier.boutonEnregistrerContinuerCopie.click();

		String color2 = calendrier.messageAlerteCopie.getCssValue("color");
		//System.out.println(color);
		String hex2 = Color.fromString(color2).asHex();
		//System.out.println(hex);
		SocleTechnique.assertEqualsLogger("la couleur n'est pas bonne", "#cc5013", hex2 , logger);
		logger.info("La couleur est orange");

		// Verifier contenu du message "Calendrier - Test 1 existe déjà"
		SocleTechnique.assertEqualsLogger("Le message n'est pas bon", "Test1 existe déjà", calendrier.messageAlerteCopie.getText(), logger);
		logger.info("Le message est valide");

		/// __________ Pas Test 12 _______


		// Clear champ Nom 

		calendrier.champNomCalendrier.clear();

		// Entrer la donnée Test Calendrier dérivé dans le nom du calendrier 
		calendrier.champNomCalendrier.sendKeys("Test2");

		// cliquer enregistrer copie
		calendrier.boutonEnregistrerContinuerCopie.click();

		// cliquer annuler copie
		calendrier.boutonAnnulerDerive.click();

		// Verifier présence message message  "Calendrier - Test 2" enregistré"
		SocleTechnique.assertEqualsLogger("Le message n'est pas bon", "Calendrier de base \"Test2\" enregistré", calendrier.messageInfoEnregistrement2.getText(), logger);
		logger.info("Le calendrier Test2 est bien enregistré");

		// Verifier la présence du calendrier créé
		SocleTechnique.assertTrueLogger("Le Calendrier Test2 n'est pas présent ", calendrier.presenceSousCalendrierTest2.isDisplayed(), logger);
		logger.info("Le calendrier Test2 est bien présent ");





	}
}

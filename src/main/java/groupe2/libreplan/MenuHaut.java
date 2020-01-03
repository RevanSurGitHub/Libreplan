package groupe2.libreplan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuHaut {

	WebDriver driver;
	
	
	// ____________________ Onglet menu ___________________________________
	
	// Onglet calendrier 
	@FindBy(xpath="//button[contains(text(), 'Calendrier ')]")
	WebElement ongletCalendrierMenuHaut;
	
	// Onglet Ressources
	@FindBy(xpath="//button[contains(text(), 'Ressources ')]")
	WebElement ongletRessourcesMenuHaut;
	
	// Onglet Coût
	@FindBy(xpath="//button[contains(text(), 'Coût ')]")
	WebElement ongletCoutMenuHaut;
	
	// Onglet configuration 
	@FindBy(xpath="//button[contains(text(), 'Configuration ')]")
	WebElement ongletConfigurationMenuHaut;
	
	//_______________Sous menu _____________________________________________
	
	
	// Sous menu Calendrier/Projet
	@FindBy(xpath="//div[@class='submenu z-menu-popup z-menu-popup-shadow']/ul/li[2]//a")
	WebElement ssMenuCalendrierProjetMenuHaut;
	
	// Sous menu Coût/Type D'heure
	@FindBy(xpath="//div[@class='submenu z-menu-popup z-menu-popup-shadow']/ul/li[6]//a")
	WebElement ssMenuCoutTypeHeureMenuHaut;
	
	// Sous menu Coût/Catégorie de cout
	@FindBy(xpath="//div[@class='submenu z-menu-popup z-menu-popup-shadow']/ul/li[5]//a")
	WebElement ssMenuCoutCategorieHeureMenuHaut;
	
	
	// Sous menu Coût/Feuille de temps
	@FindBy(xpath="//div[@class='submenu z-menu-popup z-menu-popup-shadow']/ul/li[1]//a")
	WebElement ssMenuCoutFeuilleTempsMenuHaut;
	
	
	// Sous menu Ressources/Participants
	@FindBy(xpath="//div[@class='submenu z-menu-popup z-menu-popup-shadow']/ul/li[1]//a")
	WebElement ssMenuRessourcesParticipantMenuHaut;
	
	// Sous menu Ressources/Type d'avancement
	@FindBy(xpath="//div[@class='submenu z-menu-popup z-menu-popup-shadow']/ul/li[7]//a")
	WebElement ssMenuRessourcesTyoeAvancementMenuHaut;
	
	// Sous menu Ressources/Formulaire qualité
	@FindBy(xpath="//div[@class='submenu z-menu-popup z-menu-popup-shadow']/ul/li[11]//a")
	WebElement ssMenuRessourcesFormulaireQualiteMenuHaut;
	
	// Sous menu Ressources/Critere
	@FindBy(xpath="//div[@class='submenu z-menu-popup z-menu-popup-shadow']/ul/li[6]//a")
	WebElement ssMenuRessourcesCritereMenuHaut;
	
	// Sous menu Ressources/Calendrier
	@FindBy(xpath="//div[@class='submenu z-menu-popup z-menu-popup-shadow']/ul/li[4]//a")
	WebElement ssMenuRessourcesCalendrierMenuHaut;
	
	// Sous menu Configuration/Profil
	@FindBy(xpath="//div[@class='submenu z-menu-popup z-menu-popup-shadow']/ul/li[3]//a")
	WebElement ssMenuConfigurationProfilMenuHaut;

	//_________________________________ Fil d'arianne ___________________________________
	
	
	// Fil d'arianne "DEBUT"
	@FindBy(xpath="//tr[@class=\"ruta\"]/td[2]")
	WebElement filDarianneDebut;
	
	
	
	// 2 eme element file d'arianne (nom de l'onglet)//tr[@class="ruta"]//td[4]/table[2]/tbody/tr/td/table/tbody//tr/td[1]/table/tbody/tr/td/table/tbody/tr/td[3]/span
	
	// 3 eme element file d'arianne (nom du sous menu) //tr[@class="ruta"]//td[4]/table[2]/tbody/tr/td/table/tbody//tr/td[3]/table/tbody/tr/td/table/tbody/tr/td[3]/span
	
	
}

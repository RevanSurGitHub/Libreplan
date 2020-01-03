package groupe2.libreplan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccueilPage extends MenuHaut {

	@FindBy (xpath = "//img[@src='/libreplan/common/img/ico_add.png']")
	WebElement buttonCreerProjet;
	
	
	public AccueilPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
}

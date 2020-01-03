package groupe2.libreplan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AccueilPage extends MenuHaut {

	
	public AccueilPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
}

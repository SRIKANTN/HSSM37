package Com_ActiTime_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com_ActiTime_Generic.BasePage;

public class actiTIMEEnterTimeTrackPage extends BasePage
{
	@FindBy(id = "logoutLink")
	private WebElement logout;

	public actiTIMEEnterTimeTrackPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLogout()
	{
		logout.click();
	}

}

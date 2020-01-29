package Com_ActiTime_Tests;
import org.testng.annotations.Test;
import Com_ActiTime_Generic.BaseTest;
import Com_ActiTime_Generic.ExcelData;
import Com_ActiTime_Pages.actiTIMEEnterTimeTrackPage;
import Com_ActiTime_Pages.actiTIMELoginPage;
public class ValidLoginLogoutTest extends BaseTest
{
	@Test(priority = 1)
	public void ValidLoginLogout()
	{
		//reading data form excel file 
		String lgtitle = ExcelData.getData(file_path, "TC01", 1, 2);
		String un = ExcelData.getData(file_path, "TC01", 1, 0);
		String pw  = ExcelData.getData(file_path, "TC01", 1, 1);
		String hptitle = ExcelData.getData(file_path, "TC01", 1, 3);
		//creating object to the login page object 
		actiTIMELoginPage lp = new actiTIMELoginPage(driver);
		//creating object to the time track page object 
		actiTIMEEnterTimeTrackPage hp = new actiTIMEEnterTimeTrackPage(driver);
		//to verify the login page title
		lp.verifyTitle(lgtitle);
		//enter the user name 
		lp.EnterUserName(un);
		//to enter the password
		lp.EnterPassword(pw);
		//to click on login button
		lp.ClickOnLogin();
		//to verify the time track page title
		lp.verifyTitle(hptitle);
		// to click on logout button
		hp.clickOnLogout();
		//to verify the login page title
		lp.verifyTitle(lgtitle);
	}

}

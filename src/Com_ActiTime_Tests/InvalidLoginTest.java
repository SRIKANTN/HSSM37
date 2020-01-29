package Com_ActiTime_Tests;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import Com_ActiTime_Generic.BaseTest;
import Com_ActiTime_Generic.ExcelData;
import Com_ActiTime_Pages.actiTIMELoginPage;
public class InvalidLoginTest extends BaseTest
{
	@Test(priority = 2)
	public void InvalidLogin() throws InterruptedException
	{
		String title = ExcelData.getData(file_path, "TC01", 1, 2);
		actiTIMELoginPage lp = new actiTIMELoginPage(driver);
		lp.verifyTitle(title);
		int rc = ExcelData.getRowCount(file_path, "TC02");
		for(int i = 1; i <=rc; i++)
		{
			String un = ExcelData.getData(file_path, "TC02", i, 0);
			String pw = ExcelData.getData(file_path, "TC02", i, 1);
			Reporter.log("User name= "+un,true);
			lp.EnterUserName(un);
			Reporter.log("Password= "+pw,true);
			lp.EnterPassword(pw);
			lp.ClickOnLogin();
			String aerror = lp.verifyErrorMSG();
			String eerror = ExcelData.getData(file_path, "TC02", 1, 2);
			Assert.assertEquals(aerror, eerror);
			Reporter.log("==========================================",true);
			Thread.sleep(1000);
		}
	}

}

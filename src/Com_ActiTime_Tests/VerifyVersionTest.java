package Com_ActiTime_Tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Com_ActiTime_Generic.BaseTest;
import Com_ActiTime_Generic.ExcelData;
import Com_ActiTime_Pages.actiTIMELoginPage;
public class VerifyVersionTest extends BaseTest
{
	@Test(priority = 3)
	public void VerifyVersion()
	{
		String title = ExcelData.getData(file_path, "TC01", 1, 2);
		actiTIMELoginPage lp = new actiTIMELoginPage(driver);
		lp.verifyTitle(title);
		String aversion = lp.verifyVersion();
		String eversion = ExcelData.getData(file_path, "TC03", 1, 0);
		Assert.assertEquals(aversion, eversion);
	}

}

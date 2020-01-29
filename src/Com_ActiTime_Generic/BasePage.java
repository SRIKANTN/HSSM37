package Com_ActiTime_Generic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage 
{
	/***
	 * @author srikanth
	 * @category to create supper constructor 
	 * @param WebDriver driver reference
	 */
	WebDriver driver;
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
	}
	/***
	 * @author srikanth
	 * @category to verify the web page title
	 * @param to pass web page title as arguments
	 */
	public void verifyTitle(String title)
	{
		WebDriverWait  wait = new WebDriverWait(driver, 10);
		try
		{
		wait.until(ExpectedConditions.titleIs(title));
		Reporter.log("Title is matching = "+title,true);
		}
		catch (Exception e) 
		{
			Reporter.log("Title is not matching....",true);
			Reporter.log("Actual title "+driver.getTitle(),true);
			Assert.fail();
		}
	}
	/***
	 * @author srikanth
	 * @category to verify the elements in web page
	 * @param to pass WebElement as arguments
	 */
	public void verifyElement(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try
		{
		wait.until(ExpectedConditions.visibilityOf(element));
		Reporter.log("Elemente is present....."+element.getText(),true);
		}
		catch (Exception e)
		{
			Reporter.log("Element is not present....",true);
			Assert.fail();
		}
	}
}

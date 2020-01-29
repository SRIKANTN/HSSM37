package Com_ActiTime_Generic;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.google.common.io.Files;
public class GenericUtils 
{
	/***
	 * @author srikanth
	 * @category to take a screen shoot
	 * @param webdriver reference
	 * @param screen shot name
	 */
	public static void getScreenShot(WebDriver driver,String name)
	{
		SimpleDateFormat s1 = new SimpleDateFormat("dd-MM-yyyy");
		String day = s1.format(new Date());
		try
		{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File("./ScreenShot/'"+day +"'"+name+".png"));
		}
		catch (Exception e) 
		{
		}
	}
	/***
	 * @author srikanth
	 * @category to handle the list box
	 * @param WebElement element reference
	 * @param to select the option form list box based on index value
	 */
	public static void selectByIndexValue(WebElement element, int index) 
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/***
	 * @author srikanth
	 * @category to handle the list box
	 * @param WebElement element reference
	 * @param to select the option form list box based on attribute value
	 */
	public static void selectByAttributeValue(WebElement element,String AttributeValue)
	{
		Select sel = new Select(element);
		sel.selectByValue(AttributeValue);
	}
	/***
	 * @author srikanth
	 * @category to handle the list box
	 * @param WebElement element reference
	 * @param to select the option form list box based on visible text
	 */
	public void selectByVisibleTextvalue(WebElement element,String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	/***
	 * @author srikanth
	 * @category to handle the list box
	 * @param WebElement element reference
	 * @param to deselect the option form list box based on index value
	 */
	public static void deSelectByIndexValue(WebElement element, int index) 
	{
		Select sel = new Select(element);
		sel.deselectByIndex(index);
	}
	/***
	 * @author srikanth
	 * @category to handle the list box
	 * @param WebElement element reference
	 * @param to deselect the option form list box based on attribute value
	 */
	public static void deSelectByAttributeValue(WebElement element,String AttributeValue)
	{
		Select sel = new Select(element);
		sel.deselectByValue(AttributeValue);
	}
	/***
	 * @author srikanth
	 * @category to handle the list box
	 * @param WebElement element reference
	 * @param to deselect the option form list box based on visible text
	 */
	public static void deselectByVisibleTextvalue(WebElement element,String text)
	{
		Select sel = new Select(element);
		sel.deselectByVisibleText(text);
	}
	/***
	 * @author srikanth
	 * @category to handle the JavaScriptPopup
	 * @param WebDriver driver reference
	 * @param to click on ok button
	 */
	public static void clickOnOKButtonInJavaScriptPopup(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/***
	 * @author srikanth
	 * @category to handle the JavaScriptPopup
	 * @param WebDriver driver reference
	 * @param to click on cancel button
	 */
	public static void clickOnCancelButtonInJavaScriptPopup(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/***
	 * @author srikanth
	 * @category to handle the JavaScriptPopup
	 * @param WebDriver driver reference
	 * @param enter the text to popup
	 * @param to click on ok button
	 */
	public static void enterTheTextInJavaScriptPopup(WebDriver driver,String text)
	{
		Alert a = driver.switchTo().alert();
		a.sendKeys(text);
		a.accept();
	}
	/***
	 * @author srikanth
	 * @category to handle the JavaScriptPopup
	 * @param WebDriver driver reference
	 * @param to get the text from popup
	 */
	public static String getTheTextFormJavaScriptPopup(WebDriver driver)
	{
		String text = driver.switchTo().alert().getText();
		return text;
	}
	
	public void switchToWindows(WebDriver driver,String etitle)
	{
		Set<String> allwin = driver.getWindowHandles();
		Iterator<String> itr = allwin.iterator();
		while(itr.hasNext())
		{
			String win = itr.next();
			driver.switchTo().window(win);
			if(driver.getTitle().equals(etitle))
			{
				break;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

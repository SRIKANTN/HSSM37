package Com_ActiTime_Generic;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class windowUtility 
{
	public static void switchWindow(WebDriver driver, String etitle)
	{
		Set<String> allwh = driver.getWindowHandles();
		Iterator<String> itr = allwh.iterator();
		while(itr.hasNext())
		{
			String wh =itr.next();
			driver.switchTo().window(wh);
			if(driver.getTitle().equals(etitle))
			{
				break;
			}
		}
	}
}

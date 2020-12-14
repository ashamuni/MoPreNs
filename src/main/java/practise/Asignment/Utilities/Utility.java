package practise.Asignment.Utilities;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	WebDriver driver;
	static JavascriptExecutor js = null;
	static WebDriverWait wait = null;
	
	static Actions action;
	public Utility(WebDriver driver)
	{
		action = new Actions(driver);
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver,30);
	}
	
	public void performEnterOperation()
	{
		action.sendKeys(Keys.ENTER).build().perform();;
	}
	
	public static void mousehover(WebElement target,int xoffset,int yoffset)
	{
		action.moveToElement(target, xoffset, yoffset).perform();
	}
	
	public static void select_Value(WebElement element, String Value){
		Select oselect = new Select(element);
		oselect.selectByValue(Value);
	}
	public static void scrollPage()
	{
		js.executeScript("window.scrollBy(0,3500)");
	}
	
	public static void scrollPage(WebElement element)
	{
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	public static void visibleElement(By place)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) place));
	}
	
	public WebDriver switchWindows(String window,WebDriver driver)
	{
		Set<String> sWindow = driver.getWindowHandles();
		Iterator<String> it = sWindow.iterator();
		while(it.hasNext())
		{
			String child = it.next();
			if(!window.equals(child))
			{
				driver.switchTo().window(child);
			}
		}
		return driver;
	}
	
	public WebDriver switchWindows(Set<String> windows, WebDriver driver) {
		Set<String> sWindow = driver.getWindowHandles();
		Iterator<String> it = sWindow.iterator();
		while(it.hasNext())
		{
			String win1= it.next();
			int cnt=0;
			for(String win : sWindow)
			{
				
				if(win1.equals(win))
				{
					break;
				}
				else
					cnt++;
			}
			if(cnt == windows.size())
			{
				driver.switchTo().window(win1);
			}
		}
		return driver;
	}
}

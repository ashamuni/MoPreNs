package practise.Assignment.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import practise.Asignment.Utilities.Utility;

public class TripSearchPage {

	WebDriver driver;

	By search = By.xpath("//*[@name='q' and @placeholder = 'Where to?']");
	By place = By.xpath("//div[@class='location-meta-block']");
	By reviews = By.xpath("//div[@class='_2cefqRQ2']");
	
	public TripSearchPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebDriver searchItem(WebDriver driver,String itemName)
	{
		driver.findElement(search).sendKeys(itemName);
		
		return driver;
	}
	
	public WebDriver selectFirstResult(WebDriver driver)
	{
		try{
		driver.findElement(place).click();
		}
		catch(NoSuchElementException e)
		{
			Utility.visibleElement(place);
			driver.findElement(place).click();
		}
		return driver;
	}
	
	public WebDriver review(WebDriver driver)
	{
		driver.findElement(reviews).click();
		return driver;
	}

}

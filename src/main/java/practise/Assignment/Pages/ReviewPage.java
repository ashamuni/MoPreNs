package practise.Assignment.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import practise.Asignment.Utilities.Utility;

public class ReviewPage {
	WebDriver driver;
	
	public ReviewPage(WebDriver driver)
	{
		this.driver = driver;
	}

	By rate = By.xpath("//*[@id='bubble_rating']");
	By re_title= By.xpath("//*[@id='ReviewTitle']");
	By re_Text =  By.xpath("//*[@id='ReviewText']");
	By submit =  By.xpath("//*[@id='SUBMIT']");
	By sort = By.xpath("//*[@class='c-cell jfy_cloud tag content category-familyYoungChildren']");
	By select = By.xpath("//*[@id='trip_date_month_year']");
	By hotel_service = By.xpath("//*[@class='detailsQuestion question']");
	By rate_service = By.xpath("//*[@id='qid12_bubbles'or @data-name = 'Service']");
	By rate_value = By.xpath("//span[@id = 'qid13_bubbles' or @data-name ='Value']");
	By rate_rooms = By.xpath("//span[@id = 'qid11_bubbles' or @data-name ='Rooms']");
	By rate_clean = By.xpath("//*[@id = 'qid14_bubbles' or @data-name = 'Service']");
	By rate_sleep = By.xpath("//span[@id = 'qid190_bubbles' or @data-name ='Sleep Quality']");
	By rate_location = By.xpath("//span[@id = 'qid47_bubbles' or @data-name ='Location']");
	By box = By.xpath("//*[@id='noFraud']");
	
	public WebDriver rating(WebDriver driver)
	{
		WebElement element = driver.findElement(rate);
		Utility.mousehover(element, 32, 160);
		element.click();
		return driver;
	}
	
	public WebDriver review_title(String message, WebDriver driver)
	{
		WebElement element =driver.findElement(re_title);
		element.sendKeys(message);
		return driver;
	}
	public WebDriver review_text(String message, WebDriver driver)
	{
		driver.findElement(re_Text).sendKeys(message);
		return driver;
	}
	
	public WebDriver sort_trip( WebDriver driver)
	{
		driver.findElement(sort).click();
		return driver;
	}
	
	public WebDriver travelDate( WebDriver driver)
	{
		WebElement element =driver.findElement(select);
		Utility.scrollPage(element);
		Utility.select_Value(element, "11,2020");
		return driver;
	}
	
	public WebDriver hotel_rating(WebDriver driver)
	{
		Utility.scrollPage();
		List<WebElement> list= driver.findElements(hotel_service);
		for(WebElement rating_Service : list)
		{
			String service_name = rating_Service.getText();
			if(service_name.equalsIgnoreCase("Service"))
				driver.findElement(rate_service).click();
			else if(service_name.equalsIgnoreCase("Value"))
				driver.findElement(rate_value).click();
			else if(service_name.equalsIgnoreCase("Rooms"))
				driver.findElement(rate_rooms).click();
			else if(service_name.equalsIgnoreCase("Cleanliness"))
				driver.findElement(rate_clean).click();
			else if(service_name.equalsIgnoreCase("Location"))
				driver.findElement(rate_location).click();
			else
				driver.findElement(rate_sleep).click();
		}
		return driver;
	}
	
	public WebDriver checkbox(WebDriver driver)
	{
		WebElement element = driver.findElement(box);
		element.click();
		return driver;
	}
	public WebDriver submit_review(WebDriver driver)
	{
		
		WebElement element = driver.findElement(submit);
		element.click();
		return driver;
	}
}

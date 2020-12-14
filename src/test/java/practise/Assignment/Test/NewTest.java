package practise.Assignment.Test;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import practise.Asignment.Utilities.PropertyFileReader;
import practise.Asignment.Utilities.Utility;
import practise.Assignment.Pages.ReviewPage;
import practise.Assignment.Pages.TripSearchPage;


public class NewTest {
	
	public WebDriver driver = null;
	TripSearchPage searchPage;
	ReviewPage reviewPage;
	Utility utils;
	
	@BeforeSuite
	public void config()
	{
		PropertyFileReader.configFileReader();
	}
	
	@BeforeClass
	public void OpenBrowser()
	{
		  searchPage = new TripSearchPage(driver);
		  reviewPage = new ReviewPage(driver);
		  String src = System.getProperty("user.dir") + PropertyFileReader.getChromeBrowser();
		  System.setProperty("webdriver.chrome.driver", src); 
		  driver = new ChromeDriver();
		  utils = new Utility(driver);
	}
   @Test
   public void f() 
   {
	   String parent = driver.getWindowHandle();
	   driver.manage().window().maximize();
	   driver.get(PropertyFileReader.getTripUrl());
	   driver = searchPage.searchItem(driver,"Club Mahindra");
	   utils.performEnterOperation();
	   driver = searchPage.selectFirstResult(driver);
	   driver = utils.switchWindows(parent, driver);
	   Set<String> windows = driver.getWindowHandles();
	   Utility.scrollPage();
	   driver = searchPage.review(driver);
	   driver = utils.switchWindows(windows, driver);
	   driver = reviewPage.rating(driver);
	   driver = reviewPage.review_title("Hospitality", driver);
	   driver = reviewPage.review_text("Amazing environment and surronding of the place. Amazed with with the warmth of the place and service. Spent Good time. Reaaly excellent room service. neat and clean."
	   		+ "It is very much in the current suitation the place should clean and they have disinfectant and hand wash which is very much required at present. It is safe and protected well.....", driver);
	   driver = reviewPage.sort_trip(driver);
	   driver = reviewPage.travelDate(driver);
	   driver = reviewPage.hotel_rating(driver);
	   driver = reviewPage.checkbox(driver);
	   driver = reviewPage.submit_review(driver); 
   }
}

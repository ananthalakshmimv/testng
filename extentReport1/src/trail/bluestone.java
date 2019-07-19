package trail;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class bluestone {
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
	  	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  	driver.manage().window().maximize();
	  	driver.get("https://www.bluestone.com/");
	  	Actions act=new Actions(driver);
	  	
	  	//to create html file
	  	ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(new File("C:/Users/HP/Desktop/qccm9/extentReport1/Report.html"));
	  	
	  	//attach & create a test
	  	ExtentReports extent = new ExtentReports();
	  	extent.attachReporter(htmlReporter);
	  	
	  	//create test
	  	ExtentTest test = extent.createTest("launch bluestone");
	   	WebElement search = driver.findElement(By.xpath("//input[@id='search_query_top_elastic_search']"));
	  	Thread.sleep(2000);
	  	search.sendKeys("rings",Keys.ENTER);
	  	test.log(Status.PASS, "cursor moved to gender");
	  	
	  	WebElement gen = driver.findElement(By.xpath("//div/descendant::span[@class='title style-fill i-right']/span[text()='Gender']"));
		Thread.sleep(2000);
		act.moveToElement(gen).perform();
		test.log(Status.PASS, "cursor m oved to gender");
		
		WebElement count = driver.findElement(By.xpath("//form[@id='gender']/descendant::span/following-sibling::span[text()='(1664)']"));
		Thread.sleep(5000);
		String wc = count.getText();
		test.log(Status.PASS, "the count of women"+wc);
		driver.close();
		extent.flush();
	}


}
		// TODO Auto-generated method stub

	



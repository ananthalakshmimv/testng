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

public class countOfPlatinum {
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
	  	Thread.sleep(2000);
	  	
ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(new File("C:/Users/HP/Desktop/qccm9/extentReport1/Report1.html"));
	  	
	  	//attach & create a test
	  	ExtentReports extent = new ExtentReports();
	  	extent.attachReporter(htmlReporter);
	  	
	  	//create test
	  	ExtentTest test = extent.createTest("the count of platinum");
	  	test.log(Status.INFO, "rings is entered into the textbox");
	  	WebElement search = driver.findElement(By.xpath("//input[@id='search_query_top_elastic_search']"));
	  	Thread.sleep(2000);
	  	search.sendKeys("rings",Keys.ENTER);
	  	
		test.log(Status.PASS, "mouse is moved to more filters");
	  	WebElement metal = driver.findElement(By.xpath("//div[@id='top-filter']/div/section[@id='Metal-form']/descendant::span[text()='Metal']"));
	  	Thread.sleep(2000);
	  	act.moveToElement(metal).perform();
	  	
	  	test.log(Status.PASS, "count of the platinum rings is");
	  	WebElement count = driver.findElement(By.xpath("//form[@id='metal']/descendant::div/span[@class='prcs-dlh']/descendant::span/following-sibling::span[text()='(47)']"));
	  	Thread.sleep(2000);
	  	String text = count.getText();
	  	test.log(Status.INFO, "the count of platinum is:"+text);
	  	driver.close();
	  	extent.flush();
	  	
	}
		// TODO Auto-generated method stub

	}



package trail;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class selectsize {
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver=new ChromeDriver();
	  	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  	driver.manage().window().maximize();
	  	driver.get("https://www.bluestone.com/");
	  	Actions act=new Actions(driver);
	  	Thread.sleep(2000);
	  	
		//to create html file
	  	ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(new File("C:/Users/HP/Desktop/qccm9/extentReport1/Report2.html"));
	  	
	  	//attach & create a test
	  	ExtentReports extent = new ExtentReports();
	  	extent.attachReporter(htmlReporter);
	  	//to give additional information
	  	extent.setSystemInfo("environment", "Test");
	  	extent.setSystemInfo("engineer name","Ananthu");
	  	extent.setSystemInfo("Build no","12.99");
	  	extent.setSystemInfo("Platform", "windows 10");
	  	
	  	//create test
	  	ExtentTest test = extent.createTest("Take screenshot of after selecting size");
	  	
	  	test.log(Status.INFO, "clicked on jewellry");
	  	new Actions(driver).moveToElement(driver.findElement(By.xpath("//a[text()='All Jewellery '] "))).perform();
	  	Thread.sleep(2000);
	  	
	  	test.log(Status.INFO, "selected the kadas");
	  	driver.findElement(By.xpath("//a[text()='Kadas']")).click();
	  	Thread.sleep(3000);
	  	
	  	test.log(Status.INFO, "clicked on one kada");
	  	driver.findElement(By.xpath("//img[@class='hc img-responsive center-block']")).click();
	  	Thread.sleep(1000);
	  	
	  	test.log(Status.INFO,"selected the size");
	  	driver.findElement(By.xpath("//span[text()=' Select Size ']")).click();
	  	Thread.sleep(1000);
	  	
	  	test.log(Status.INFO, "sixe is displayed");
	  	WebElement size1 = driver.findElement(By.xpath("//span[@class='size']"));
	  	String size = size1.getText();
	  	test.log(Status.PASS,"size is selected"+size);
	  	size1.click();
	  	//Thread.sleep(2000);
	  	test.log(Status.PASS, "clicked on buy now");
	  	driver.findElement(By.xpath("//input[@value='Buy Now']")).click();
	  	Thread.sleep(1000);
	  	String title = driver.getTitle();
	  	test.log(Status.PASS, "title of the page is: "+title);
	  	
	  	test.log(Status.INFO,"bangle size is selected");
	  	WebElement size2 = driver.findElement(By.xpath("(//div[text()=' Bangle Size ']/..)/div[2]"));
	    String size3 = size2.getText();   
	    test.log(Status.PASS, "cartpage size "+size3);
	    
	    //take screen shot
	    TakesScreenshot ts = (TakesScreenshot)driver;
	    File src = ts.getScreenshotAs(OutputType.FILE);
	    File des = new File("C:/Users/HP/Desktop/qccm9/extentReport1/Report2.html");
	    FileUtils.copyFile(src,des);
	    test.addScreencastFromPath("C:/Users/HP/Desktop/qccm9/extentReport1/Report2.html");
	    Thread.sleep(2000);
	    if(size.equals(size3))
	    {
	    	test.log(Status.PASS, "sizes are equal");
	    }
	    else
	    {
	    	test.log(Status.FAIL, "sizes are not equal");
	    }
	  driver.close();
	  extent.flush();
	}
	

	
	}



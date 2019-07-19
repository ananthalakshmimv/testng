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

public class blueStoneScreenShot {
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
	  	ExtentTest test = extent.createTest("Take Screenshot of error messega");
	  	test.log(Status.INFO, "move cursor to the All jewellery");
	  	WebElement jewel = driver.findElement(By.xpath("//a[text()='All Jewellery '] "));
	  	act.moveToElement(jewel);
	  	Thread.sleep(2000);
	  	
	  	test.log(Status.PASS, "clicked on Kadas");
	  	driver.findElement(By.xpath("//a[text()='Kadas']")).click();
	  	Thread.sleep(3000);
	  	
	  	test.log(Status.INFO, "clicked on the image of kadas");
	  	driver.findElement(By.xpath("//img[@class='hc img-responsive center-block']")).click();
	  	Thread.sleep(1000);
	  	
	  	test.log(Status.INFO, "clicked on buy now button");
	    WebElement bnw = driver.findElement(By.xpath("//input[@value='Buy Now']"));
	    bnw.click();
	    
	    //capture the error message of the display
	    TakesScreenshot ts = (TakesScreenshot)driver;
	    File src = ts.getScreenshotAs(OutputType.FILE);
	    File des = new File("C:/Users/HP/Desktop/qccm9/extentReport1/Report2.html");
	    //FileUtils.copyFile(src,des);
	    //Attaching screenshot to the extent reports
	    test.addScreencastFromPath("C:/Users/HP/Desktop/qccm9/extentReport1/Report2.html");
	    FileUtils.copyFile(src,des);
	    Thread.sleep(2000);
	    
	    driver.close();
	    extent.flush();
		

	}

}

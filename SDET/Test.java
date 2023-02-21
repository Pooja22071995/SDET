package SDET;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Test 
{
	public static void main(String[] args) throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver","D:\\Java\\New Browser\\chromedriver_win32\\chromedriver.exe\\");
		
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.imdb.com/");
		
		//driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		
		Thread.sleep(2000);
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='suggestion-search']")).sendKeys("Pushpa");
		
		Thread.sleep(2000);
		
		//driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[text()='Pushpa: The Rise - Part 1']")).click();
		
		WebElement details = driver.findElement(By.xpath("//span[text()='Box office']"));
		
		((JavascriptExecutor)driver).executeScript("argument[0].scrollIntoView();", details);
		
		Thread.sleep(9000);
		
		WebElement date = driver.findElement(By.xpath("//a[text()='December 17, 2021 (United States)']"));
		
		WebElement country = driver.findElement(By.xpath("//a[text()='India']"));
		
		String S1 = date.getText();
		
		String S2 = country.getText();
		
		System.out.println(S1);
		
		System.out.println(S2);
		
		 File Source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	       
	      System.out.println(Source);
	       
	      File Destination = new File("D:\\ScreenShot\\Sample6.jpg");
	       
	      FileHandler.copy(Source, Destination);
		
		
		
	}

}

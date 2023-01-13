package TPACKAGE;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ASSESSMENT {
	
	WebDriver driver;
	
	@SuppressWarnings("deprecation")
	public void invokebrowser() {
		try {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Desktop\\ECLIPSE\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://the-internet.herokuapp.com/");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
			//driver.findElement(By.id("username")).sendKeys("tomsmith");
			//driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
			driver.findElement(By.linkText("Form Authentication")).click();
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void validlogin() {
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.className("fa fa-2x fa-sign-in")).click();
		driver.findElement(By.className("flash success")).isDisplayed();
		
	}

	
	public void invalidlogin() {
		driver.findElement(By.id("username")).sendKeys("thomas");
		driver.findElement(By.id("password")).sendKeys("SuperPassword!");
		driver.findElement(By.className("flash error")).isDisplayed();
		
	}

		
   public void closebrowser() {
	  //closebrowser();
	  driver.close();
	  try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   //driver.quit();
	   //chromeDriver.close();
	  
	  
   }
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ASSESSMENT obj = new ASSESSMENT();
		obj.invokebrowser();
		
		obj.validlogin();
		obj.closebrowser();
		obj.invokebrowser();
		
		obj.invalidlogin();
		

	}

}

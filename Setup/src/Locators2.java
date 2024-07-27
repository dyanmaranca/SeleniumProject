import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String name = "rahul";
		
		System.setProperty("webdriver.chrome.driver", "/Users/dyanmaranca/chromedriver");
		//Invoking Browser
		WebDriver driver = new ChromeDriver();
		
		//wait - global
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String password = getPassword(driver);
		
		//open website
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		
		//find fields by id, name and classname.. enter values and click button
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		
		Thread.sleep(2000);
		
		//validate successful sign in
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
		
		//find element based on text for log out
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();
		
		
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		//click Forgot password, find by link text
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);

		//click reset button
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		//get the password
		String passwordText = driver.findElement(By.cssSelector("form p")).getText();
		String [] passwordArray = passwordText.split("'");
		String password = passwordArray[1].split("'")[0];
		return password;
		
	}

}

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/dyanmaranca/chromedriver");
		//Invoking Browser
		WebDriver driver = new ChromeDriver();
		
		//wait - global
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//open website
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		
		//find fields by id, name and classname.. enter values and click button
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("signInBtn")).click();
		
		//find error message by CSS selector and output
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		//click Forgot password, find by link text
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		Thread.sleep(1000);
		
		//find fields by xpath
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
		
		//find fields by css selector
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");
		
		//find field by xpath using common attribute and clear
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		
		//find fields by css selector using common attribute, re-enter email
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");
		
		//find fields by parent-child tags using xpath
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("1234567830");
		
		//click reset button
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		//find error message by CSS selector and output
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		
		//Login
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

	}

}

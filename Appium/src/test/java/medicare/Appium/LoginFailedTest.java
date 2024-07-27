package medicare.Appium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginFailedTest extends Base {
	
	//validate login is disabled when entering invalid Email format
	@Test
	public void invalidEmailFormatTest () {
	
		
		driver.findElement(By.id("com.og.medicare:id/username")).sendKeys("nidhip@");
		driver.findElement(By.id("com.og.medicare:id/password")).sendKeys("123456");
		boolean btnEnable = driver.findElement(By.id("com.og.medicare:id/login")).isEnabled();
		
		//check user redirected to correct page
		Assert.assertFalse(btnEnable);
	}
	
	//validate login is disabled when entering invalid password format
	@Test
	public void invalidPasswordFormatTest () {
	
		
		driver.findElement(By.id("com.og.medicare:id/username")).sendKeys("nidhip@gmail.com");
		driver.findElement(By.id("com.og.medicare:id/password")).sendKeys("12345");
		boolean btnEnable = driver.findElement(By.id("com.og.medicare:id/login")).isEnabled();
		
		//check user redirected to correct page
		Assert.assertFalse(btnEnable);
	}
	
	//validate error is shown when entering unauthorized email address
	@Test
	public void unauthorizedUserTest () {
	
		
		driver.findElement(By.id("com.og.medicare:id/username")).sendKeys("test@mail.com");
		driver.findElement(By.id("com.og.medicare:id/password")).sendKeys("123456");
		driver.findElement(By.id("com.og.medicare:id/login")).click();
		
		//check message is displayed
		String toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMsg, "Login failed");
		
		//check user redirected to correct page
		Assert.assertEquals(driver.currentActivity(), ".ui.login.LoginActivity");
	}
	
	//validate error is shown when entering unauthorized password  
	@Test
	public void unauthorizedPasswordTest () {
	
		
		driver.findElement(By.id("com.og.medicare:id/username")).sendKeys("nidhip@gmail.com");
		driver.findElement(By.id("com.og.medicare:id/password")).sendKeys("1234567");
		driver.findElement(By.id("com.og.medicare:id/login")).click();
		
		//check message is displayed
		String toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMsg, "Authentication failed.");
		
		//check user redirected to correct page
		Assert.assertEquals(driver.currentActivity(), ".ui.login.LoginActivity");
	}
	

}

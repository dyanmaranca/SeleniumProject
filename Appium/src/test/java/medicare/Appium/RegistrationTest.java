package medicare.Appium;

import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class RegistrationTest extends Base{

	@Test (priority = 0)
	public void SubmitEmptyRegistrationTest () throws InterruptedException {
		//Login to application
		driver.findElement(By.id("com.og.medicare:id/username")).sendKeys("nidhip@gmail.com");
		driver.findElement(By.id("com.og.medicare:id/password")).sendKeys("123456");
		driver.findElement(By.id("com.og.medicare:id/login")).click();
				
		//Navigate to Add Inventory page
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")).click();
		driver.findElement(By.id("com.og.medicare:id/nav_register")).click();
		
		driver.findElement(By.id("com.og.medicare:id/fab")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("com.og.medicare:id/register")).click();
		
		String toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		AssertJUnit.assertEquals("All fields are required", toastMsg);
	}
	
	@Test (priority = 1)
	public void RegistrationSuccessTest () {
		
		driver.findElement(By.id("com.og.medicare:id/name")).sendKeys("john1");
		driver.findElement(By.id("com.og.medicare:id/email")).sendKeys("john1@gmail.com");
		driver.findElement(By.id("com.og.medicare:id/hstation")).sendKeys("Rizal");
		//driver.findElement(By.id("com.og.medicare:id/com.og.medicare:id/text_input_end_icon")).click();
		driver.findElement(By.id("com.og.medicare:id/roles")).sendKeys("user");
		
		driver.findElement(By.id("com.og.medicare:id/register")).click();
		
		String toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		AssertJUnit.assertEquals("User added successfully", toastMsg);
	}
	
//	@Test (priority = 2)
//	public void DuplicateRegistrationTest () {
//		
//		driver.findElement(By.id("com.og.medicare:id/name")).sendKeys("john");
//		driver.findElement(By.id("com.og.medicare:id/email")).sendKeys("john@gmail.com");
//		driver.findElement(By.id("com.og.medicare:id/hstation")).sendKeys("Rizal");
//		//driver.findElement(By.id("com.og.medicare:id/com.og.medicare:id/text_input_end_icon")).click();
//		driver.findElement(By.id("com.og.medicare:id/roles")).sendKeys("user");
//		
//		driver.findElement(By.id("com.og.medicare:id/register")).click();
//		
//		String toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
//		AssertJUnit.assertEquals("Failed to add user", toastMsg);
//	}
	
}

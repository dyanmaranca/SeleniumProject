package medicare.Appium;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginSuccess extends Base {
	
	//validate login successful message when submitting valid email and password
	@Test
	public void LoginSuccessTest() {
		
		
		driver.findElement(By.id("com.og.medicare:id/username")).sendKeys("nidhip@gmail.com");
		driver.findElement(By.id("com.og.medicare:id/password")).sendKeys("123456");
		driver.findElement(By.id("com.og.medicare:id/login")).click();
		
		//check message is displayed
		String toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		AssertJUnit.assertEquals(toastMsg, "Authentication success");
		//System.out.println(driver.currentActivity());
		
		//check user redirected to correct page
		AssertJUnit.assertEquals(driver.currentActivity(), ".Home2");
	}
	
	
}

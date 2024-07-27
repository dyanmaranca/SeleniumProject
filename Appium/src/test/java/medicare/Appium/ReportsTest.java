package medicare.Appium;

import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class ReportsTest extends Base {

	@Test (priority = 0)
	public void SubmitEmptyReportTest() throws InterruptedException {
		
		//Login to application
		driver.findElement(By.id("com.og.medicare:id/username")).sendKeys("nidhip@gmail.com");
		driver.findElement(By.id("com.og.medicare:id/password")).sendKeys("123456");
		driver.findElement(By.id("com.og.medicare:id/login")).click();
		
		//Navigate to Add Order page
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")).click();
		driver.findElement(By.id("com.og.medicare:id/nav_report")).click();
		
		driver.findElement(By.id("com.og.medicare:id/fab")).click();
		
		driver.findElement(By.id("com.og.medicare:id/btn_submit")).click();
		
		Thread.sleep(2000);
		
		String toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		AssertJUnit.assertEquals("Report type is required", toastMsg);
		
	}
	
	@Test (priority = 1)
	public void SubmitReportTest() throws InterruptedException {
		
		driver.findElement(By.id("com.og.medicare:id/mReportType")).sendKeys("expiry report");
		driver.findElement(By.id("com.og.medicare:id/btn_submit")).click();
		
		Thread.sleep(2000);
		
		String toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		AssertJUnit.assertEquals("Report generated successfully", toastMsg);
		
	}
}

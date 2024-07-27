package medicare.Appium;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderTest extends Base{

	String medicine = "";
	String dateRequested = "";
	String qtyRequested = "";
	String requestedBy = "";
	String healthStation = "";
	String invSearch = "";
	String invCount = "";
	String generic = "";
	
	//Validate error when adding blank fields
	@Test (priority = 0)
	public void SubmitEmptyOrderTest() {
		//Login to application
		driver.findElement(By.id("com.og.medicare:id/username")).sendKeys("nidhip@gmail.com");
		driver.findElement(By.id("com.og.medicare:id/password")).sendKeys("123456");
		driver.findElement(By.id("com.og.medicare:id/login")).click();
		
		//Navigate to Add Order page
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")).click();
		driver.findElement(By.id("com.og.medicare:id/nav_order")).click();
		
		driver.findElement(By.id("com.og.medicare:id/fab")).click();
		
		driver.findElement(By.id("com.og.medicare:id/btn_submit")).click();
		String toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		AssertJUnit.assertNotSame(toastMsg, "Record added successfully");
	}
	
	//Validate able to add order record and shows Success message
	@Test (priority = 1)
	public void AddOrderTest () throws Exception {
		
		//Open file for test data
		FileInputStream file = new FileInputStream(new File("/Users/dyanmaranca/eclipse-workspace/Appium/src/test/java/resources/medicare.xlsx"));
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheetAt(1);
		
		Row row = sheet.getRow(1);
		medicine = row.getCell(0).getStringCellValue();
		dateRequested = row.getCell(1).getStringCellValue();
		qtyRequested = row.getCell(2).getStringCellValue();
		requestedBy = row.getCell(3).getStringCellValue();
		healthStation = row.getCell(4).getStringCellValue();
		invSearch = row.getCell(5).getStringCellValue();
		invCount = row.getCell(6).getStringCellValue();
		generic = row.getCell(8).getStringCellValue();
		
		//Search for inventory count
		//driver.findElement(By.id("com.og.medicare:id/search")).sendKeys(invSearch);
		//String initialQty = (driver.findElement(By.id("com.og.medicare:id/qty")).getText());
		
		driver.findElement(By.id("com.og.medicare:id/text_input_end_icon")).click();
		
		driver.findElement(By.id("com.og.medicare:id/dpMedicineName")).sendKeys(medicine);
		driver.findElement(By.id("com.og.medicare:id/editTextOrderDate")).sendKeys(dateRequested);
		driver.findElement(By.id("com.og.medicare:id/editTextQuantity")).sendKeys(qtyRequested);
		driver.findElement(By.id("com.og.medicare:id/editTextRequestedBy")).sendKeys(requestedBy);
		driver.findElement(By.id("com.og.medicare:id/editTextHealthStation")).sendKeys(healthStation);
		
		
		driver.findElement(By.id("com.og.medicare:id/btn_submit")).click();
		
		String toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		AssertJUnit.assertEquals(toastMsg, "Order added successfully");
	}
	
	@Test (priority = 2)
	public void SearchOrderTest () {
		
		driver.findElement(By.id("com.og.medicare:id/search")).sendKeys(generic);
		
		String genName = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.og.medicare:id/title\"])[1]")).getText();
		AssertJUnit.assertEquals(generic, genName);
	}
	
	
	//Validate inventory count of medicine from order is updated
	/*
	 * @Test (priority = 2) public void ValidateOrderTest () { //Navigate to
	 * Homepage page driver.findElement(By.
	 * xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]"
	 * )).click(); driver.findElement(By.id("com.og.medicare:id/nav_home")).click();
	 * 
	 * //Search for inventory and validate that order is removed from inventory
	 * driver.findElement(By.id("com.og.medicare:id/search")).sendKeys(invSearch);
	 * String newQty =
	 * driver.findElement(By.id("com.og.medicare:id/qty")).getText(); String
	 * newQtyTrim = newQty.substring(0,newQty.length()-2);
	 * AssertJUnit.assertEquals(invCount, newQtyTrim);
	 * 
	 * }
	 */
}

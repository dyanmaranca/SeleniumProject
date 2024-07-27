package medicare.Appium;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryTest extends Base {
	
	String genericName = "";
	String brandName = "";
	String expiryDate = "";
	String quantity = "";
	String lotNumber = "";
	String unitMeasure = "";
	
	//Validate error when adding blank fields
	@Test (priority = 0)
	public void SubmitEmptyInventoryTest() {
		
		//Login to application
		driver.findElement(By.id("com.og.medicare:id/username")).sendKeys("nidhip@gmail.com");
		driver.findElement(By.id("com.og.medicare:id/password")).sendKeys("123456");
		driver.findElement(By.id("com.og.medicare:id/login")).click();
		
		//Navigate to Add Inventory page
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")).click();
		driver.findElement(By.id("com.og.medicare:id/nav_inventory")).click();
		
		driver.findElement(By.id("com.og.medicare:id/btn_submit")).click();
		String toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		AssertJUnit.assertNotSame(toastMsg, "Record added successfully");
	}
	
	//Validate able to add distribution record and shows Success message
	@Test (priority = 1)
	public void AddInventoryTest( ) throws Exception {
	
	//Open file for test data
	FileInputStream file = new FileInputStream(new File("/Users/dyanmaranca/eclipse-workspace/Appium/src/test/java/resources/medicare.xlsx"));
	Workbook workbook = new XSSFWorkbook(file);
	Sheet sheet = workbook.getSheetAt(0);
	
	
	//for (int i=1; i<= sheet.getLastRowNum();i++) {
		Row row = sheet.getRow(2);
		genericName = row.getCell(0).getStringCellValue();
		brandName = row.getCell(1).getStringCellValue();
		expiryDate = row.getCell(2).getStringCellValue();
		quantity = row.getCell(3).getStringCellValue();
		lotNumber = row.getCell(4).getStringCellValue();
		unitMeasure = row.getCell(5).getStringCellValue();
		
		driver.findElement(By.id("com.og.medicare:id/et_generic_name")).sendKeys(genericName);
		driver.findElement(By.id("com.og.medicare:id/et_brand_name")).sendKeys(brandName);
		driver.findElement(By.id("com.og.medicare:id/et_expiry_date")).sendKeys(expiryDate);
		driver.findElement(By.id("com.og.medicare:id/et_quantity")).sendKeys(quantity);
		driver.findElement(By.id("com.og.medicare:id/et_lot_number")).sendKeys(lotNumber);
		driver.findElement(By.id("com.og.medicare:id/et_unit_measure")).sendKeys(unitMeasure);
		
		driver.findElement(By.id("com.og.medicare:id/btn_submit")).click();
		String toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		AssertJUnit.assertEquals(toastMsg, "Record added successfully");

	}
	
	//Validate searching inventory is working
	@Test (priority = 2)
	public void SearchInventoryTest () {
		//Navigate to Homepage page
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")).click();
		driver.findElement(By.id("com.og.medicare:id/nav_home")).click();
			
		//Search for inventory
		driver.findElement(By.id("com.og.medicare:id/search")).sendKeys(brandName);
		String genName = driver.findElement(By.id("com.og.medicare:id/name")).getText();
		AssertJUnit.assertEquals(genericName, genName);
}
	
	//Validate adding same record will show Failed to add message
	/*
	 * @Test (priority = 3) public void AddDuplicateInventoryTest () {
	 * driver.findElement(By.id("com.og.medicare:id/et_generic_name")).sendKeys(
	 * genericName);
	 * driver.findElement(By.id("com.og.medicare:id/et_brand_name")).sendKeys(
	 * brandName);
	 * driver.findElement(By.id("com.og.medicare:id/et_expiry_date")).sendKeys(
	 * expiryDate);
	 * driver.findElement(By.id("com.og.medicare:id/et_quantity")).sendKeys(quantity
	 * ); driver.findElement(By.id("com.og.medicare:id/et_lot_number")).sendKeys(
	 * lotNumber);
	 * driver.findElement(By.id("com.og.medicare:id/et_unit_measure")).sendKeys(
	 * unitMeasure);
	 * 
	 * driver.findElement(By.id("com.og.medicare:id/btn_submit")).click(); //String
	 * toastMsg =
	 * driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute(
	 * "name"); //AssertJUnit.assertEquals(toastMsg, "Failed to add record"); }
	 */
	
}

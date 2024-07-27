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

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class DistributionTest extends Base {
	
	String dateDispensed = "";
	String genericName = "";
	String brandName = "";
	String unitMeasure = "";
	String qtyDispensed = "";
	String lotNumber = "";
	String expiryDate = "";
	String patientName = "";
	String patientDOB = "";
	String address = "";
	String diagnosis = "";
	
	//Validate error when adding blank fields
	@Test (priority = 0)
	public void SubmitEmptyDistributionTest () throws InterruptedException {
		//Login to application
		driver.findElement(By.id("com.og.medicare:id/username")).sendKeys("nidhip@gmail.com");
		driver.findElement(By.id("com.og.medicare:id/password")).sendKeys("123456");
		driver.findElement(By.id("com.og.medicare:id/login")).click();
				
		//Navigate to Add Distribution page
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")).click();
		driver.findElement(By.id("com.og.medicare:id/nav_distribution")).click();
		
		Thread.sleep(1000);
		
		//scroll down to last element - button
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Submit\"));"));
		driver.findElement(By.id("com.og.medicare:id/et_patient_diagnosis")).sendKeys(diagnosis);
		driver.findElement(By.id("com.og.medicare:id/btn_submit")).click();
		
		//validate first required field is displayed
		boolean topField = driver.findElement(By.id("com.og.medicare:id/et_date_dispensed")).isDisplayed();
		Assert.assertTrue(topField);

	}
	
	//Validate able to add distribution record and shows Success message
	@Test (priority = 1)
	public void AddDistributionTest() throws Exception {
		
		//Open file for test data
		FileInputStream file = new FileInputStream(new File("/Users/dyanmaranca/eclipse-workspace/Appium/src/test/java/resources/medicare.xlsx"));
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheetAt(2);
		
		
		//for (int i=1; i<= sheet.getLastRowNum();i++) {
		Row row = sheet.getRow(2);
		dateDispensed = row.getCell(0).getStringCellValue();
		genericName = row.getCell(1).getStringCellValue();
		brandName = row.getCell(2).getStringCellValue();
		unitMeasure = row.getCell(3).getStringCellValue();
		qtyDispensed = row.getCell(4).getStringCellValue();
		lotNumber = row.getCell(5).getStringCellValue();
		expiryDate = row.getCell(6).getStringCellValue();
		patientName = row.getCell(7).getStringCellValue();
		patientDOB = row.getCell(8).getStringCellValue();
		address = row.getCell(9).getStringCellValue();
		diagnosis = row.getCell(10).getStringCellValue();
		
		driver.findElement(By.id("com.og.medicare:id/et_date_dispensed")).sendKeys(dateDispensed);
		driver.findElement(By.id("com.og.medicare:id/et_generic_name")).sendKeys(genericName);
		driver.findElement(By.id("com.og.medicare:id/et_brand_name")).sendKeys(brandName);
		driver.findElement(By.id("com.og.medicare:id/et_unit_measure")).sendKeys(unitMeasure);
		driver.findElement(By.id("com.og.medicare:id/et_quantity_dispensed")).sendKeys(qtyDispensed);
		driver.findElement(By.id("com.og.medicare:id/et_lot_number")).sendKeys(lotNumber);
		driver.findElement(By.id("com.og.medicare:id/et_expiration_date")).sendKeys(expiryDate);
		driver.findElement(By.id("com.og.medicare:id/et_patient_name")).sendKeys(patientName);
		driver.findElement(By.id("com.og.medicare:id/et_patient_birth_date")).sendKeys(patientDOB);
		
		//scroll down to last element - button
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Submit\"));"));
		
		driver.findElement(By.id("com.og.medicare:id/et_patient_address")).sendKeys(address);
		driver.findElement(By.id("com.og.medicare:id/et_patient_diagnosis")).sendKeys(diagnosis);
		
		driver.findElement(By.id("com.og.medicare:id/btn_submit")).click();
		String toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		AssertJUnit.assertEquals(toastMsg, "Record added successfully");
		
	}
	
	//Validate adding same record will show Failed to add message
	@Test (priority = 2)
	public void AddDuplicateDistributionTest() {
		driver.findElement(By.id("com.og.medicare:id/et_date_dispensed")).sendKeys(dateDispensed);
		driver.findElement(By.id("com.og.medicare:id/et_generic_name")).sendKeys(genericName);
		driver.findElement(By.id("com.og.medicare:id/et_brand_name")).sendKeys(brandName);
		driver.findElement(By.id("com.og.medicare:id/et_unit_measure")).sendKeys(unitMeasure);
		driver.findElement(By.id("com.og.medicare:id/et_quantity_dispensed")).sendKeys(qtyDispensed);
		driver.findElement(By.id("com.og.medicare:id/et_lot_number")).sendKeys(lotNumber);
		driver.findElement(By.id("com.og.medicare:id/et_expiration_date")).sendKeys(expiryDate);
		driver.findElement(By.id("com.og.medicare:id/et_patient_name")).sendKeys(patientName);
		driver.findElement(By.id("com.og.medicare:id/et_patient_birth_date")).sendKeys(patientDOB);
		
		//scroll down to last element - button
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Submit\"));"));
		
		driver.findElement(By.id("com.og.medicare:id/et_patient_address")).sendKeys(address);
		driver.findElement(By.id("com.og.medicare:id/et_patient_diagnosis")).sendKeys(diagnosis);
		
		driver.findElement(By.id("com.og.medicare:id/btn_submit")).click();
		String toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		AssertJUnit.assertEquals(toastMsg, "Failed to add record");
		
	}
	
	//Validate added distribution are listed in distribution list
	@Test (priority = 3)
	public void SearchDistributionTest () {
		//Navigate to Add Distribution page
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")).click();
		driver.findElement(By.id("com.og.medicare:id/nav_distribution_list")).click();
		
		driver.findElement(By.id("com.og.medicare:id/search")).sendKeys(patientName);
		
		String genName = driver.findElement(By.id("com.og.medicare:id/title")).getText();
		AssertJUnit.assertEquals(genericName, genName);
	}
	
	

}

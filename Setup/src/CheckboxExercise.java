import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckboxExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/dyanmaranca/chromedriver");
		//Invoking Browser
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		driver.findElement(By.id("checkBoxOption1")).click();
		System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		//count all checkboxes
		
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
	}

}

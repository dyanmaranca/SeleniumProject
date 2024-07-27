import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/dyanmaranca/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ca.kayak.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("(//svg[@class='S9tW-chevron'])[2]")).click();
		Thread.sleep(2000);
	
		
		//click number of Adults multiple times
//		int i = 1;
//		while(i< 5) //4 times
//		{
//			driver.findElement(By.id("hrefIncAdt")).click(); 
//			i++;
//		}
		
		System.out.println(driver.findElement(By.xpath("//span[@class='S9tW-title']")).getText());
		
		for (int i=1;i<5;i++) {
			driver.findElement(By.xpath("(//input[@class='bCGf-mod-theme-default'])[3]")).click(); 
		}
	
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.xpath("//span[@class='S9tW-title']")).getText());
	}

}

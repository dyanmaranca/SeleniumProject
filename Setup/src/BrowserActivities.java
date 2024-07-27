import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserActivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/dyanmaranca/chromedriver");
		//Invoking Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://google.com"); //waits for components to load
		driver.navigate().to("https://rahulshettyacademy.com"); //move to another web page but does not wait component loading
		driver.navigate().back();
		driver.navigate().forward();

	}

}

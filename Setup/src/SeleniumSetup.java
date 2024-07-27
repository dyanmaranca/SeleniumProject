import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

public class SeleniumSetup {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/dyanmaranca/chromedriver");
		//Invoking Browser
		//WebDriver driver = new ChromeDriver();
		
		//Firefox Launch
		System.setProperty("webdriver.gecko.driver", "/Users/dyanmaranca/geckodriver");
		//WebDriver driver = new FirefoxDriver();
		
		//Edge Launch
		System.setProperty("webdriver.edge.driver", "/Users/dyanmaranca/msedgedriver");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		
	}

}

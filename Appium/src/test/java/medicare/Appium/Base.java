package medicare.Appium;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void configureAppium() throws MalformedURLException {
		
		//run Appium automatically
		/*service = new AppiumServiceBuilder().withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(60)).build();
		
		service.start(); */
		
		//create capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel_8_API_34");
		options.setApp(System.getProperty("user.dir")+"/src/test/java/resources/app-debug.apk");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}
	
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
		//service.stop();
	}
	
	
}

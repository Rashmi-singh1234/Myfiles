package crossBrowser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class chrome {
	static WebDriver driver;
	static Properties prop = new Properties();
	static String projectPath = System.getProperty("user.dir");
	public static void main(String[] args) throws IOException {
		/*WebDriverManager.chromedriver().browserVersion(prop.getProperty("version")).setup();
		driver =new ChromeDriver();
		driver.get("https://www.google.co.in/");*/
		InputStream input = new FileInputStream(projectPath + "/src/test/java/DataStore/data01.properties");
		prop.load(input);
		String browserType=null; 
		browserType=prop.getProperty("browser");
		if (browserType.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		} 
		else if (browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\RASHMI\\Downloads\\bselenium\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(new FirefoxProfile());
			options.addPreference("dom.webnotifications.enabled", false);

			driver = new FirefoxDriver(options);
		}
		

	}
}

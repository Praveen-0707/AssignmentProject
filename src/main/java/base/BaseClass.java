package base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public RemoteWebDriver driver;
	public ChromeOptions chromeOptions;
	public static WebDriverWait wait;
	public String remoteRun;
	
	private static ThreadLocal<RemoteWebDriver> localDriver = new ThreadLocal<RemoteWebDriver>();
	
	public void setDriver(RemoteWebDriver driver)
	{
		localDriver.set(driver);
	}
	
	public static synchronized RemoteWebDriver getDriver()
	{
		return localDriver.get();
	}
	
	public static final String URL = "https://oauth-praveen.beula77-586b7:9261db47-d810-4a8f-8c07-50a085624764@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
	
	@BeforeMethod
	public void launchApp()
	{
		remoteRun = "true";

		DesiredCapabilities dcaps = new DesiredCapabilities();
		dcaps.setCapability("browserName", "chrome");
		dcaps.setCapability("browserVersion", "latest");
		dcaps.setCapability("platformName", "Windows 10");
		dcaps.setCapability("extendedDebugging", "true");
		
		if(remoteRun.equalsIgnoreCase("true"))
			try {
					WebDriverManager.chromedriver().setup();
					dcaps.setCapability(ChromeOptions.CAPABILITY, setChromeOptions());
					driver = new RemoteWebDriver(new URL(URL), dcaps);
					setDriver(driver);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		else
		{
			WebDriverManager.chromedriver().setup();
			chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-notifications");
			driver = new ChromeDriver(chromeOptions);
			setDriver(driver);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		getDriver().manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		
		String URL = "https://login.salesforce.com/";
		getDriver().get(URL);
	}
	
	public ChromeOptions setChromeOptions()
	{
		  chromeOptions = new ChromeOptions();
		  chromeOptions.addArguments("--disable-notifications");
		  return chromeOptions;
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		getDriver().close();
	}
	
}

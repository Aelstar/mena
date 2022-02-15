package baseSetup;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import listenners.WebDriverEventListenners;
import testUtils.Screenshot;



public class Config_Setup {


	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebDriverEventListenners weblistener;
	public static ExtentReports extent;
	public static ExtentTest logger;



	public Config_Setup() throws IOException {

		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\StandardProject\\Test Data\\properties.properties");
		prop.load(fis);

	}

	@BeforeMethod
	@Parameters({"browsers"})
	public void Setup(Method method, String browser){

		logger=extent.startTest(method.getName());
		
			if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","D:\\Ahmed\\istqb\\Selenium Course\\chromedriver_path\\chromedriver_win32 (2)\\chromedriver.exe");

			ChromeOptions option=new ChromeOptions();
			option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			driver=new ChromeDriver(option);

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//driver.manage().window().maximize();


			//driver.get(prop.getProperty("URL"));

}

		else if(browser.equalsIgnoreCase("Firfox")) {

			System.setProperty("webdriver.gecko.driver", "D:\\Ahmed\\istqb\\Selenium Course\\chromedriver_path\\geckodriver-v0.29.0-win32\\geckodriver.exe");

			driver=new FirefoxDriver();

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}


		e_driver=new EventFiringWebDriver(driver);
		weblistener=new  WebDriverEventListenners();
		e_driver.register(weblistener);

		
		



	}


	@AfterMethod
	public void after_Method(ITestResult result, Method method) throws Exception {


		Screenshot.takeScreenshot(method.getName());


		if (result.getStatus()==ITestResult.SUCCESS) {

			logger.log(LogStatus.PASS, "Test Passes");
			logger.log(LogStatus.PASS,"<a href='" + result.getName() + ".png" + "'><span class='lable info'>Download Snapshot</span></a>");
			logger.log(LogStatus.PASS,"<a href='" + result.getName() + ".mov" + "'><span class='lable info'>Download Video</span></a>");

		}else if (result.getStatus()==ITestResult.FAILURE) {

			logger.log(LogStatus.FAIL,"test fail"+result.getThrowable());
		

		}else {
			logger.log(LogStatus.SKIP,"test skipped");
			
		}


		driver.quit();



	}








}

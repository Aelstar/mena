package testCases;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;

import baseSetup.Config_Setup;

public class Reports extends Config_Setup {

	public Reports() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@BeforeSuite
	public void before_Method() {
		
		extent= new ExtentReports("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\StandardProject\\Output Tests\\index.html", true);
		extent.addSystemInfo("Tester","ahmed");
		
		
	}
	
	@AfterSuite
	public void after_Suite() {
		
		extent.flush();
		
	}
}

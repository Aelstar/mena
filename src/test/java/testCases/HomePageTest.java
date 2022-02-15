package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import baseSetup.Config_Setup;
import testPages.HomePage;
import testPages.LoginPage;

public class HomePageTest extends Config_Setup{

	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	

	LoginPage login;
	
	
	
	
	@Test
	public void test_homePage4() throws InterruptedException, Exception {
		login=new LoginPage();
		
		login.openPage();
		
		Thread.sleep(3000);
		
		System.out.println("homepage Test");
	}
}

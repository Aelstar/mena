package testCases;

import java.io.IOException;
import org.testng.annotations.Test;
import baseSetup.Config_Setup;
import testPages.LoginPage;


public class LoginPageTest extends Config_Setup{


	LoginPage login;




	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(enabled=true)
	public void Test1() throws Exception {

		login=new LoginPage();
		login.openPage();

		login.getTitle();

	}


	@Test(enabled=true)
	public void Test2() {

		login.openPage();

		login.getURL();


		System.out.println("test 2 check");
	}

	@Test(enabled= false)
	public void Test3() throws Exception {


		login.openPage();

		System.out.println("Test 3 check before click");

		//login.clickAtProduct();
login.search();

		System.out.println("Test 3 check navigate click");




		Thread.sleep(3000);

	}
}

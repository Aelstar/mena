package testPages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseSetup.Config_Setup;

public class LoginPage  extends Config_Setup{
	public LoginPage() throws IOException {
		
		PageFactory.initElements(driver, this);

	}


	@FindBy (id="signupModalButton")
	WebElement getstarted;


	@FindBy(tagName="button")
	WebElement button;


	@FindBy(xpath="//input[@id='search2']")
	WebElement search;



	public String getTitle() {

		String Title=	driver.getTitle();
		System.out.println(Title);
		return Title;
	}


	public String getURL() {

		String geturl=driver.getCurrentUrl();

		System.out.println(geturl);
		return geturl;

	}

	public  void  startedClick()  {

		getstarted.click();

	}
	public void button() {

		button.click();
	}

	public void openPage() {

		driver.get(prop.getProperty("URL"));
	}

	public void clickAtProduct() throws InterruptedException  {

		Actions action= new Actions(driver);
		action.moveToElement(search).build().perform();
		search.sendKeys("searchh");
		Thread.sleep(3000);

	}

	public WebElement search() {

		search.sendKeys("Ahmed");
		System.out.println("fddsfd");
		return search;
	}
}

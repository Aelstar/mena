package testUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import baseSetup.Config_Setup;

public class Screenshot extends Config_Setup{
	
	
	public Screenshot() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void takeScreenshot(String name) throws Exception {
		
File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

FileUtils.copyFile(srcfile, new File("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\StandardProject\\Output Tests\\"+name+".png"), false);

	}

}

package lib;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {

	public static String captuerScreenshot(WebDriver driver, String screenshotName) throws Exception {

		try {

			TakesScreenshot scrShot = ((TakesScreenshot) driver);

			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

			File DestFile = new File("./Screenshot/" + screenshotName + System.currentTimeMillis() + ".jpg");

			FileUtils.copyFile(SrcFile, DestFile);

			System.out.println("Screenshot Captured");

		} catch (Exception e) {

			System.out.println("Exception while taking Screesnhot" + e.getMessage());
		}
		return screenshotName;

	}

}

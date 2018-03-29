package com.test.hooks;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.utils.WaitMethods;

import cucumber.api.java.Before;

public class Hooks {
	public static WebDriver driver;
	public static String targetURL = "https://weather-acceptance.herokuapp.com/";
	public static String browserName = "GC";
	public static int ImageNumber = 0;
	public static String TakeScreenShot = "Yes";
	public static String CurrentTime;

	// browsers pathS
	public static String ChromeDriverPath = "src/test/resources\\drivers\\Chrome\\chromedriver.exe";
	// public static String ChromeDriverPath = "/usr/bin/chromedriver";
	public static String IEDriverPath = "src/test/resources\\driver\\IEDriverServer.exe";
	public static String FFDriverPath = "";

	// To get Current System date
	static DateFormat df1 = new SimpleDateFormat("_yyyy-MM-dd_hh-mm-ss a");
	static Date date1 = new Date();
	static String CurrentExecution = df1.format(date1);

	// To get Result in html view
	public static ExtentReports er = new ExtentReports("ExtentReports\\Log" + CurrentExecution + ".html");
	public static ExtentTest et = er.startTest("Weather Acceptance Heroku App Automation Test ");

	/*
	 * RE-USABLE METHODS *******
	 * 
	 */

	// Launch site
	public static void LaunchBrowser() throws Exception {
		try {
			if (browserName.equals("GC")) {
				System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
				driver = new ChromeDriver();
			} else if (browserName.equals("IE")) {
				System.setProperty("webdriver.ie.driver", IEDriverPath);
				driver = new InternetExplorerDriver();
			}
			// NEED TO ADD DRIVER
			else if (browserName.equals("FF")) {
				System.setProperty("webdriver.gecko.driver", FFDriverPath);
				driver = new FirefoxDriver();
			} else if (browserName.equals("SAFARI")) {
				driver = new SafariDriver();
			}
		} catch (Exception e) {
			et.log(LogStatus.INFO, "The Required browser is not available");
			captureScreenshot();
		}

		driver.get(targetURL);
		driver.manage().window().maximize();
		et.log(LogStatus.INFO, "Application has Launched successfully");
		WaitMethods.wait5();
	}

	// close
	public static void close() throws Exception {
		// close site
		WaitMethods.implicitlyWait();
		driver.close();

		// save and close reports
		er.flush();
		er.endTest(et);
	}

	// TO Get Screenshots
	public static void captureScreenshot() throws InterruptedException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH mm");
		Date date = new Date();
		CurrentTime = df.format(date);
		if (TakeScreenShot.equalsIgnoreCase("Yes")) {
			/* et.log(LogStatus.PASS,"Current Time is:: "+df.format(date)); */
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				ImageNumber = ImageNumber + 1;
				FileUtils.copyFile(src, new File("ScreenShots\\" + CurrentTime + "\\Error_Img" + ImageNumber + ".png"));
			} catch (Exception e) {
				captureScreenshot();
				et.log(LogStatus.INFO, "Screenshot failed");
			}
		}
	}

}

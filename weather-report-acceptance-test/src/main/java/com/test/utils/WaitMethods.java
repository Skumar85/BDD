package com.test.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.hooks.Hooks;

public class WaitMethods extends Hooks {
	// wait methods from Selenium code
	public static void implicitlyWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// explicity define
	public static WebDriverWait wd = new WebDriverWait(driver, 15);

	public static void wait3() throws Exception {
		Thread.sleep(3000);
	}

	public static void wait2() throws Exception {
		Thread.sleep(2000);
	}

	public static void wait5() throws Exception {
		Thread.sleep(5000);
	}

}

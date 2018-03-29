package com.test.steps;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;
import com.test.hooks.Hooks;
import com.test.pages.HomePage;
import com.test.utils.WaitMethods;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Homepage_Step extends Hooks {
	@Given("^I launch the application$")
	public void launch_the_application() throws Exception {
		LaunchBrowser();
	}
	
	@When("^I enter \"(.*)\"$")
	public void I_enter_cityName(String City) throws Throwable 
	{
		WaitMethods.wd.until(ExpectedConditions.elementToBeClickable(HomePage.EnterCity_Name));
		driver.findElement(HomePage.EnterCity_Name).clear();
		driver.findElement(HomePage.EnterCity_Name).sendKeys(City,Keys.ENTER);
		WaitMethods.implicitlyWait();
		
	}
	

	@Then("^I should see the Weather Forcast for 5 days$")
	public void Observe_wheather_all_resepctive_days_are_displaying_or_not() throws Exception {
		WebElement tue = driver.findElement(HomePage.Tue);
		WebElement wed = driver.findElement(HomePage.Wed);
		WebElement thu = driver.findElement(HomePage.Thu);
		WebElement fri = driver.findElement(HomePage.Fri);
		WebElement sat = driver.findElement(HomePage.Sat);

		Assert.assertTrue("Tuesday element dispalyed", tue.isDisplayed());
		Assert.assertTrue("Wednesday element dispalyed", wed.isDisplayed());
		Assert.assertTrue("Thursday element dispalyed", thu.isDisplayed());
		Assert.assertTrue("Friday element dispalyed", fri.isDisplayed());
		Assert.assertTrue("Saturday element dispalyed", sat.isDisplayed());

	}

	@Then("^close the application$")
	public void close_the_application() throws Exception {
		close();
	}

}

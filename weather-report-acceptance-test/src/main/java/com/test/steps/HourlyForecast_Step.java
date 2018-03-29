package com.test.steps;

import java.util.ArrayList;
import java.util.List;

import org.apache.xalan.templates.ElemElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;
import com.test.hooks.Hooks;
import com.test.pages.HomePage;
import com.test.utils.WaitMethods;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HourlyForecast_Step extends Hooks {

	@When("^Enter city Name as \"([^\"]*)\"$")
	public void Enter_city_Name_as(String CityName) throws Throwable {
		driver.findElement(HomePage.EnterCity_Name).clear();
		driver.findElement(HomePage.EnterCity_Name).sendKeys(CityName, Keys.ENTER);
		WaitMethods.wait2();

	}

	@Then("^Get Forecast for \"([^\"]*)\"$")
	public void Get_Forecast_for(String CityName) throws Throwable {
		if (CityName.contains("Valid")) {
			try {
				if (driver.findElement(HomePage.Tue).isDisplayed()
						&& driver.findElement(HomePage.maxForTue).isDisplayed()) {
					et.log(LogStatus.PASS, "Test Passed for Valid City Name");
				}
			} catch (Exception e) {
				et.log(LogStatus.INFO, "Test Interrupted at Valid Input data");
			}
		}
	}

	@Then("^Select the \"([^\"]*)\"$")
	public void Select_the(String day) throws Throwable {
		if (day.equalsIgnoreCase("Tue")) {
			driver.findElement(HomePage.Tue).click();
		} else if (day.equalsIgnoreCase("Wed")) {
			driver.findElement(HomePage.Wed).click();
		} else if (day.equalsIgnoreCase("Thu")) {
			driver.findElement(HomePage.Thu).click();
		} else if (day.equalsIgnoreCase("Fri")) {
			driver.findElement(HomePage.Fri).click();
		} else if (day.equalsIgnoreCase("Sat")) {
			driver.findElement(HomePage.Sat).click();
		} else {
			Assert.fail("Given " + day + "day is un known");
		}

		WaitMethods.implicitlyWait();

	}

	@Then("^I should see the details as \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void I_should_see_the_details_as_(String firstHour, String maxTemp, String minTemp, String speed,
			String direction, String rainfall, String pressure) throws Throwable {
		List<WebElement> findElements = driver.findElement(HomePage.GridForTue).findElements(By.cssSelector("span"));

		List<String> hours = new ArrayList<String>();
		List<String> maxTems = new ArrayList<String>();
		List<String> minTems = new ArrayList<String>();
		List<String> speeds = new ArrayList<String>();
		List<String> rainfalls = new ArrayList<String>();
		List<String> pressures = new ArrayList<String>();

		for (WebElement element : findElements) {
			String text = element.getText();
			String attribute = element.getAttribute("data-test");
			if (text != null && attribute != null) {

				attribute = attribute.toUpperCase();
				if (attribute.contains("HOUR")) {
					hours.add(text);

				}
				if (attribute.contains("MAX")) {
					maxTems.add(removeSpecialChar(text));
				}
				if (attribute.contains("MIN")) {
					minTems.add(removeSpecialChar(text));
				}
				if (attribute.contains("SPEED")) {
					speeds.add(text);
				}
				if (attribute.contains("RAINFALL")) {
					rainfalls.add(text);
				}
				if (attribute.contains("PRESSURE")) {
					pressures.add(text);
				}
			}

		}

		Assert.assertTrue(hours.contains(firstHour));
		Assert.assertTrue(maxTems.contains(maxTemp));
		Assert.assertTrue(minTems.contains(minTemp));
		Assert.assertTrue(rainfalls.contains(rainfall));
		Assert.assertTrue(pressures.contains(pressure));
		Assert.assertTrue(speeds.contains(speed));
	}

	private String removeSpecialChar(String text) {
		return text.substring(0, text.length() - 1);
	}

}

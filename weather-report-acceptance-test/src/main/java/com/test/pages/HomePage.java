package com.test.pages;

import org.openqa.selenium.By;

public class HomePage 
{
	
	//days
	public static By Tue= By.xpath("//span[contains(text(),'Tue')]");
	public static By Wed= By.xpath("//span[contains(text(),'Wed')]");
	public static By Thu= By.xpath("//span[contains(text(),'Thu')]");
	public static By Fri= By.xpath("//span[contains(text(),'Fri')]");
	public static By Sat= By.xpath("//span[contains(text(),'Sat')]");
	
	
	//Search box 
	public static By EnterCity_Name = By.id("city");
	public static By Error_Alert = By.xpath("//div[contains(text(),'Error retrieving')]");
	
	//getting max and min values of the each day
	public static By maxForTue = By.xpath("//span[@data-test='maximum-1']");
	public static By MinForTue = By.xpath("//span[@data-test='minimum-1']");
	
	public static By maxForWed = By.xpath("//span[@data-test='maximum-2']");
	public static By MinForWed = By.xpath("//span[@data-test='minimum-2']");
	
	public static By maxForThu = By.xpath("//span[@data-test='maximum-3']");
	public static By MinForThu = By.xpath("//span[@data-test='minimum-3']");
	
	public static By maxForFri = By.xpath("//span[@data-test='maximum-4']");
	public static By MinForFri = By.xpath("//span[@data-test='minimum-4']");
	
	public static By maxForSat = By.xpath("//span[@data-test='maximum-5']");
	public static By MinForSat = By.xpath("//span[@data-test='minimum-5']");
	
	//Individual Sub Values for each Day
	
	public static By GridForTue = By.xpath(".//*[@id='root']/div/div[1]/div[2]");
	public static By GridForWed = By.xpath(".//*[@id='root']/div/div[2]/div[2]");
	public static By GridForThu = By.xpath(".//*[@id='root']/div/div[3]/div[2]]");
	public static By GridForFri = By.xpath(".//*[@id='root']/div/div[4]/div[2]");
	public static By GridForSat = By.xpath(".//*[@id='root']/div/div[5]/div[2]");
	
	public static By Tue_First_Hour = By.xpath("//span[@data-test='hour-1-1']");
	public static By Tue_First_Hour_Max_Tem = By.xpath("//span[@data-test='maximum-1-1']");
	public static By Tue_First_Hour_Min_Tem = By.xpath("//span[@data-test='minimum-1-1']");
	public static By Tue_First_Hour_speed = By.xpath("//span[@data-test='speed-1-1']");
	public static By Tue_First_Hour_rainfall = By.xpath("//span[@data-test='rainfall-1-1']");
	public static By Tue_First_Hour_pressure = By.xpath("//span[@data-test='pressure-1-1']");
	

	
	
	
	
}

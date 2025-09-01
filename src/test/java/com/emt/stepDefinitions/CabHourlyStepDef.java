package com.emt.stepDefinitions;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.emt.hooks.Hooks;
import com.emt.pages.HomePage;
import com.emt.pages.HourlyCabPage;
import com.emt.utils.DriverSetup;
import com.emt.utils.JsonDataReader;
import com.emt.utils.JsonDataWriter;
import com.emt.utils.ScreenshotUtil;
import com.google.gson.JsonObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/*
 * Step definition class for automating Hourly cab booking scenarios 
 * on EaseMyTrip using the Cucumber framework.
 * 
 * Loads test data from JSON, interacts with the UI via Page Objects,
 * and logs test execution flow, including filtering and result validation.
 */

public class CabHourlyStepDef {

	static WebDriver driver;
	static DriverSetup setUp;
	static HomePage home;
	static HourlyCabPage hour;
	public static Logger log;
	String fileName = "HourlyCabs.json";
	JsonObject cabData = JsonDataReader.getCabData("Hourly", fileName);

	@Given("user open the browser and navigate to EaseMyTrip")
	public void openBrowser() {
		log = DriverSetup.getLogger();
		log.info("***** TC_05-Hourly cabs*****");
		driver = Hooks.driver;
		Assert.assertNotNull(driver, "Driver is null");
		home = new HomePage(driver);
		hour = new HourlyCabPage(driver);

	}

	@When("The user go to Cabs and select hourly")
	public void the_user_go_to_cabs_and_select_hourly() {
		home.goToCabs();
		boolean urlCheck = driver.getCurrentUrl().contains("cabs");
		Assert.assertTrue(urlCheck, "Not navigated to cabs page");
		hour.goToHourly();
		log.info("Switched to Hourly Cabs");
	}

	@When("The user search hourly cab from Visakhapatnam on 14 September 2026 at 8:30 AM for 4 hours")
	public void the_user_search_hourly_cab_from_on_at_for_hours() {
		log.info("entering data...");
		String city = cabData.get("City").getAsString();
		String day = cabData.get("Day").getAsString();
		String month = cabData.get("Month").getAsString();
		String year = cabData.get("Year").getAsString();
		String time = cabData.get("Time").getAsString();
		String hours = cabData.get("Hours").getAsString();
		hour.searchCab(city, day, month, year, time, hours);

	}

	@Then("The user apply SUV filter")
	public void the_user_apply_suv_filter() {
		log.info("entered data and clicked on search");
		hour.filterSUV();
	}

	@Then("The user print the least fare")
	public void the_user_print_the_least_fare() throws IOException {
		JsonDataWriter.writeSimpleData("SUV", hour.getLeastFare(), "HourlyWriting.json");
		log.info("displayed data");
		ScreenshotUtil.captureScreenShot(driver, "CabHourlyTC");
		log.info("Hourly  cabs TC completed");
	}
}

package PL;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CountryandSalesLine;
import pages.FileUploadEngine;
import pages.Login;
import selenium_demo.selenium_demo.JsonData;
import selenium_demo.selenium_demo.LoadDrivers_remote;
//import selenium_demo.selenium_demo.LoadDrivers;
import selenium_demo.selenium_demo.Prerequizites;

public class TestFlowPL1 {
	public WebDriver driver;
	public static List<String> jsondata;
	public static List<String> dbvalue;
	final static Logger logger = Logger.getLogger(TestFlowPL1.class);

	String browser = System.getProperty("propertyName");

	@BeforeClass
	public void before() throws IOException, InterruptedException {
		logger.info("start load data ");
		jsondata = JsonData.returnCredential(0); // return first block from json (country DE)
		// driver = LoadDrivers_remote.driver(browser, jsondata.get(9));
		driver = LoadDrivers_remote.driver(browser, jsondata.get(9));
		logger.info("end start load data ");
		Login login = new Login(driver);
		boolean objectscheck_login = login.check_objects();
		Assert.assertTrue(objectscheck_login);
		login.typeUserName(jsondata.get(7));
		Thread.sleep(1000);
		login.typePassword(jsondata.get(8));
		Thread.sleep(1000);
		login.clickOnLoginButton();
		Thread.sleep(5000);
		String title = driver.getTitle();
		System.out.println("afisare titlul 1: = " + title);
		Assert.assertEquals(title, "INBound Mass Upload");
		logger.info("login succesfully");
	}

	@Test(priority = 1)

	public void countrySaleslinecheck() throws InterruptedException {
		CountryandSalesLine cas = new CountryandSalesLine(driver);
		cas.salesLine("REAL");
		Thread.sleep(1000);
		logger.info("check the button querry");
		if (cas.querry()) {
			logger.info("Button querry exist");
		}
		cas.back_MCC();

		System.out.println("Disable automatically refresh");

		cas.disable_refresh();

		cas.select_country();

		/*
		 * cas.displayperiod_selectfirstvalue(); Thread.sleep(1000);
		 * cas.perform_querry(); Thread.sleep(1000);
		 * cas.displayperiod_selectsecondvalue(); Thread.sleep(1000);
		 * cas.perform_querry(); Thread.sleep(1000);
		 * cas.displayperiod_selectthirdvalue(); Thread.sleep(1000);
		 * cas.perform_querry(); Thread.sleep(1000);
		 * cas.displayperiod_selectfourthvalue(); Thread.sleep(1000);
		 * cas.perform_querry(); Thread.sleep(1000);
		 * cas.displayperiod_selectfiftvalue(); Thread.sleep(1000);
		 * cas.perform_querry(); Thread.sleep(1000);
		 */
	}

	@Test(priority = 2)

	public void fileUploadEnginecheck() throws InterruptedException {

		// Prerequizites.runcurl();
		Prerequizites.runcurltest();
		Thread.sleep(10000);

		FileUploadEngine uploadfile = new FileUploadEngine(driver);
		uploadfile.uploadFile();

		Thread.sleep(5000);
	}

//mvn clean test -Dvar1="firefox" -DtestngFile=testngDE_Flow1.xml  --command for run the maven project
	@Test(priority = 1)
	public void test9App() throws IOException, InterruptedException {
		System.out.println("TEST INTERMEDIAR");
	}

	@AfterClass
	public void after() throws IOException {

		driver.quit();

	}
	// mvn clean test -Dvar1="firefox" -DtestngFile=testngES_CancelRequest.xml

	// mvn clean test -Dvar1="firefox" -DtestngFile=testngDE_Flow1.xml
}
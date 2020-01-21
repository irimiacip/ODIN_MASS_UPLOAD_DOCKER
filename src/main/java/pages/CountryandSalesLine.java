package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CountryandSalesLine {
	final static Logger logger = Logger.getLogger(CountryandSalesLine.class);
	static WebDriver driver;

	By country = By.id("country-select inside");
	By salesline_mcc = By.cssSelector("label.btn-primary:nth-child(1)");
	By salesline_real = By.cssSelector("label.btn-primary:nth-child(2)");
	By querry = By.cssSelector("#queryBtn > span:nth-child(2)");
	By disable_refresh = By.cssSelector("div.toggle:nth-child(4)");

	public CountryandSalesLine(WebDriver driver) {
		this.driver = driver;
	}

	public String salesLine(String salesline_value) throws InterruptedException {
		Thread.sleep(5000);
		String sales;
		WebElement value = driver.findElement(salesline_mcc);
		// Highlighlit.highLighterMethod(driver,value);
		Thread.sleep(5000);
		sales = value.getText();
		System.out.println("afiseaza initial value: " + sales);
		if (sales.equals(salesline_value)) {
			logger.info("the salesline value doesn'r need to be changed");
		} else {
			value.click();
			sales = value.getText();
		}
		return sales;
	}

	public void back_MCC() throws InterruptedException {
		WebElement value = driver.findElement(salesline_real);
		value.click();
		// Highlighlit.highLighterMethod(driver,value);
		Thread.sleep(5000);
		String sales;
		sales = value.getText();
		if (sales.contains("MCC")) {
			System.out.println("sales line back to MCC");
		}
	}

	public void disable_refresh() {
		WebElement disable = driver.findElement(disable_refresh);
		// Highlighlit.highLighterMethod(driver,disable);
		disable.click();
	}

	public void select_country() throws InterruptedException {
		logger.info("Select Poland");
		WebElement period = driver.findElement(By.cssSelector("#country_selector"));
		// Highlighlit.highLighterMethod(driver,period);
		Thread.sleep(5000);
		period.clear();
		period.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		period.sendKeys(Keys.DELETE);
		Thread.sleep(5000);
		period.sendKeys("Poland");
		Thread.sleep(4000);
		period.sendKeys(Keys.TAB);

	}

	public void displayperiod_selectfirstvalue() throws InterruptedException {
		logger.info("select first value from drop down list");
		WebElement period = driver.findElement(By.cssSelector("#filesHistoryWeeks_selector"));
		// Highlighlit.highLighterMethod(driver,period);
		Thread.sleep(5000);
		Select first_value = new Select(driver.findElement(By.cssSelector("#filesHistoryWeeks_selector")));
		first_value.selectByVisibleText("Last 1 week");
		first_value.selectByIndex(1);
	}

	public void displayperiod_selectsecondvalue() throws InterruptedException {
		logger.info("select second value from drop down list");
		WebElement period = driver.findElement(By.cssSelector("#filesHistoryWeeks_selector"));
		// Highlighlit.highLighterMethod(driver,period);
		Thread.sleep(5000);
		Select first_value = new Select(driver.findElement(By.cssSelector("#filesHistoryWeeks_selector")));
		first_value.selectByVisibleText("Last 2 weeks");
		first_value.selectByIndex(2);
	}

	public void displayperiod_selectthirdvalue() throws InterruptedException {
		logger.info("select third value from drop down list");
		WebElement period = driver.findElement(By.cssSelector("#filesHistoryWeeks_selector"));
		// Highlighlit.highLighterMethod(driver,period);
		Thread.sleep(5000);
		Select first_value = new Select(driver.findElement(By.cssSelector("#filesHistoryWeeks_selector")));
		first_value.selectByVisibleText("Last 4 weeks");
		first_value.selectByIndex(3);
	}

	public void displayperiod_selectfourthvalue() throws InterruptedException {
		logger.info("select fourth value from drop down list");
		WebElement period = driver.findElement(By.cssSelector("#filesHistoryWeeks_selector"));
		// Highlighlit.highLighterMethod(driver,period);
		Thread.sleep(5000);
		Select first_value = new Select(driver.findElement(By.cssSelector("#filesHistoryWeeks_selector")));
		first_value.selectByVisibleText("Last 12 weeks");
		first_value.selectByIndex(4);
	}

	public void displayperiod_selectfiftvalue() throws InterruptedException {
		logger.info("select fifth value from drop down list");
		WebElement period = driver.findElement(By.cssSelector("#filesHistoryWeeks_selector"));
		// Highlighlit.highLighterMethod(driver,period);
		Thread.sleep(5000);
		Select first_value = new Select(driver.findElement(By.cssSelector("#filesHistoryWeeks_selector")));
		first_value.selectByVisibleText("Last 2 years");

	}

	public boolean querry() {
		boolean value = true;

		if (driver.findElement(querry).isDisplayed()) {

			WebElement button = driver.findElement(querry);
			// Highlighlit.highLighterMethod(driver,button);
			logger.info("the  button querry is present");
		} else {
			value = false;
		}

		return value;
	}

	public void perform_querry() {
		driver.findElement(querry).click();
	}
}

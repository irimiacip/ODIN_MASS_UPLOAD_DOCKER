package selenium_demo.selenium_demo;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class LoadDrivers {

	public static WebDriver driver(String browser, String url) throws IOException {

		if (browser.equals("firefox")) {
			System.out.println("Afiseaza input value :" + browser);
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/src/main/resources/drivers/geckodriver");
			WebDriver driver = new FirefoxDriver();
			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(true);
			options.addArguments("-headless");
			options.addArguments("disable-infobars");
			driver.manage().window().maximize();
			driver.get(url);
			return driver;
		} else {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver");

			WebDriver driver = new ChromeDriver();

			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("useAutomationExtension", false);
			options.setHeadless(true);
			options.addArguments("disable-infobars");

			driver.manage().window().maximize();
			driver.get(url);
			return driver;
		}

	}

}
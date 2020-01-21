package selenium_demo.selenium_demo;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoadDrivers_remote {

	/*
	 * public static final String USERNAME = "TEST_CIPRIAN"; public static final
	 * String ACCESS_KEY = "8376e7f2-8541-41a0-9710-f33e16db971d"; //public static
	 * final String URL = "https://" + "TEST_CIPRIAN" + ":" +
	 * "8376e7f2-8541-41a0-9710-f33e16db971d" +
	 * "@ondemand.saucelabs.com:443/wd/hub"; //US server public static final String
	 * URL = "https://" + "TEST_CIPRIAN" + ":" +
	 * "8376e7f2-8541-41a0-9710-f33e16db971d" +
	 * "@ondemand.eu-central-1.saucelabs.com/wd/hub";
	 */

	public static final String USERNAME = "METRO_FINS_MRC";
	public static final String ACCESS_KEY = "a8e9353b-a546-4a74-9282-5f9f6bfad7c9";
	// public static final String URL = "https://" + "TEST_CIPRIAN" + ":" +
	// "8376e7f2-8541-41a0-9710-f33e16db971d" +
	// "@ondemand.saucelabs.com:443/wd/hub"; //UE
	public static final String URL = "https://" + "METRO_FINS_MRC" + ":" + "a8e9353b-a546-4a74-9282-5f9f6bfad7c9"
			+ "@ondemand.eu-central-1.saucelabs.com/wd/hub";

	public static WebDriver driver(String browser, String url) throws IOException {

		if (browser.equals("firefox")) {
			System.out.println("Afiseaza input value :" + browser);
			// System.setProperty("webdriver.gecko.driver","/home/ciprian/Downloads/drivers/geckodriver");
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/src/main/resources/drivers/geckodriver");
			FirefoxOptions caps = new FirefoxOptions();
			// DesiredCapabilities caps = DesiredCapabilities.firefox();
			// caps.setCapability("platform", "Windows 10");

			caps.setCapability("platform", "Linux");
			caps.setCapability("version", "latest");
			caps.setCapability("screenResolution", "1024x768");
			caps.setCapability("name", "Web Driver demo Test");
			caps.setCapability("tags", "Tag1");
			caps.setCapability("build", "build-1234");
			System.out.println("TEST");
			caps.setCapability("app", "sauce-storage:test.txt");
			// caps.setCapability("prerun", WindowsExecutable.callExe());
			System.err.println("TEST END");
			WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
			((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
			System.out.println("TEST");
			System.out.println("CACA" + driver.toString());
			System.err.println("TEST END");

			/*
			 * FirefoxOptions options = new FirefoxOptions();
			 * options.addArguments("disable-infobars"); String hubURL =
			 * "http://10.97.178.217:4444/wd/hub"; WebDriver driver = new
			 * RemoteWebDriver(new URL(hubURL), options);
			 */

			// WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(url);

			return driver;
		} else if (browser.equals("chrome")) {
			// System.setProperty("webdriver.chrome.driver","/home/ciprian/Downloads/drivers/chromedriver");
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver");

			DesiredCapabilities caps = DesiredCapabilities.chrome();
			// caps.setCapability("platform", "Windows 10");
			caps.setCapability("platform", "Linux");
			caps.setCapability("version", "latest");
			caps.setCapability("screenResolution", "1024x768");
			caps.setCapability("name", "Web Driver demo Test");
			caps.setCapability("tags", "Tag1");
			caps.setCapability("build", "build-1234");
			WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
			((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
			/*
			 * ChromeOptions options = new ChromeOptions();
			 * options.setExperimentalOption("useAutomationExtension", false);
			 * options.addArguments("disable-infobars"); String hubURL =
			 * "http://10.97.178.217:4444/wd/hub"; WebDriver driver = new
			 * RemoteWebDriver(new URL(hubURL), options);
			 */
			// WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			return driver;
		} else if (browser.equals("Iexplorer")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "/src/main/resources/drivers/IEDriverServer.exe");

			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability("platform", "Windows 10");
			caps.setCapability("version", "latest");
			caps.setCapability("screenResolution", "1920x1200");
			caps.setCapability("name", "Web Driver demo Test");
			caps.setCapability("tags", "Tag1");
			caps.setCapability("build", "build-1234");
			// caps.setCapability("app","sauce-storage:test.exe");
			// caps.setCapability("prerun", WindowsExecutable.callExe());

			// test.loadInternetExplorerDesiredCaps();
			WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
			// caps.setCapability("executable","sauce-storage:test.exe");
			driver.manage().window().maximize();
			// caps.setCapability("app","sauce-storage:test.exe");

			driver.get(url);

			return driver;
		} else if (browser.equals("ChromeW")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");

			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability("platform", "Windows 10");
			caps.setCapability("version", "latest");
			caps.setCapability("screenResolution", "1280x1024");
			caps.setCapability("name", "Web Driver demo Test");
			caps.setCapability("tags", "Tag1");
			caps.setCapability("build", "build-1234");
			// caps.setCapability("app","sauce-storage:test.exe");
			// caps.setCapability("prerun", WindowsExecutable.callExe());

			// test.loadInternetExplorerDesiredCaps();
			WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
			// caps.setCapability("executable","sauce-storage:test.exe");

			driver.manage().window().maximize();
			// caps.setCapability("app","sauce-storage:test.exe");

			driver.get(url);

			return driver;
		} else {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/src/main/resources/drivers/geckodriver.exe");

			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability("platform", "Windows 10");
			caps.setCapability("version", "latest");
			caps.setCapability("screenResolution", "1280x1024");
			caps.setCapability("name", "Web Driver demo Test");
			caps.setCapability("tags", "Tag1");
			caps.setCapability("build", "build-1234");
			// caps.setCapability("app","sauce-storage:test.exe");
			// caps.setCapability("prerun", WindowsExecutable.callExe());

			// test.loadInternetExplorerDesiredCaps();
			WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
			// caps.setCapability("executable","sauce-storage:test.exe");

			driver.manage().window().maximize();
			// caps.setCapability("app","sauce-storage:test.exe");

			driver.get(url);

			return driver;
		}

	}

}
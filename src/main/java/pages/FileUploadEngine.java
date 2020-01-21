package pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadEngine {
	static WebDriver driver;
	By path = By.id("country-select inside");
	By uploadpath = By.cssSelector("label.btn-primary:nth-child(1)");
	By choose_file = By.cssSelector("label.btn-primary:nth-child(2)");
	By upload = By.cssSelector("#queryBtn > span:nth-child(2)");

	public FileUploadEngine(WebDriver driver) {
		this.driver = driver;
	}

	public static void uploadFile() throws InterruptedException {
		// WebElement uploadElement1 = driver.findElement(By.id("uploadfile_0"));

		WebElement uploadElement = driver.findElement(By.cssSelector("body > div:nth-child(16) > input:nth-child(1)"));

		// Highlighlit.highLighterMethod(driver, uploadElement);

		Thread.sleep(10000);

		// enter the file path onto the file-selection input field
		// uploadElement.sendKeys("/home/ciprian/Downloads/test/1.csv");
		String xxx = System.getProperty("var");
		File f = new File("/tmp/" + xxx);
		System.out.println("verificatre fisier downloadat inainte de ulpoad: " + f.exists());

		// uploadElement.sendKeys("/tmp/DeliveryFlagMassUpload.csv");
		// verificare ACU!!!

		uploadElement.sendKeys("/tmp/" + xxx);

		// click the "UploadFile" button
		Thread.sleep(10000);
		WebElement push = driver.findElement(By.id("uploadButton"));
		// Highlighlit.highLighterMethod(driver, push);
		push.click();
	}

}

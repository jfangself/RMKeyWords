package rm.testScript;

import static rm.util.WaitUitl.sleep;
import static rm.util.WaitUitl.waitWebElement;

import java.net.MalformedURLException;
import java.net.URL;

import junit.framework.Assert;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HelloWorld {

	WebDriver driver;
	String baseUrl = "https://www.sogou.com";
	// define node url
	String nodeUrl = "http://10.13.16.198:6655/wd/hub";

	@Test
	public void helloWorld() {
		System.out.println("Hello World Sougou");
		driver.get(baseUrl);
		// sleep(10000);
		waitWebElement(driver, "//*[@id='query']");

		WebElement searchTxt = driver.findElement(By.xpath("//*[@id='query']"));
		WebElement searchBtn = driver.findElement(By.xpath("//*[@id='stb']"));

		searchTxt.clear();
		searchTxt.sendKeys("Hello World,I am Joey");
		searchBtn.click();
		sleep(4000);

		waitWebElement(driver, "//*[@id='sogou_next']");

		Assert.assertTrue(driver.getPageSource().contains("Joey"));
	}

	@BeforeClass
	public void beforeClass() throws MalformedURLException {

		// DesiredCapabilities capability =
		// DesiredCapabilities.internetExplorer();
		// capability.setBrowserName("internetExplorer");
		// capability.setPlatform(Platform.WINDOWS);

		DesiredCapabilities capability = DesiredCapabilities.firefox();
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.WINDOWS);

		DOMConfigurator.configure("Log4j.xml");
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe"
		 * ); driver = new ChromeDriver();
		 */

		driver = new RemoteWebDriver(new URL(nodeUrl), capability);

	}

	@AfterClass
	public void afterClass() {

		driver.quit();

	}
}

package rm.testScript;

import static rm.util.WaitUitl.sleep;
import static rm.util.WaitUitl.waitWebElement;
import junit.framework.Assert;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HelloWorld {

	WebDriver driver;
	String baseUrl = "https://www.sogou.com";

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
	public void beforeClass() {

		DOMConfigurator.configure("Log4j.xml");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@AfterClass
	public void afterClass() {

		driver.quit();

	}
}

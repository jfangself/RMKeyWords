package rm.testScript;

import static rm.util.WaitUitl.*;
import static rm.util.WaitUitl.*;

import org.apache.xerces.impl.xpath.XPath;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

public class LoginRM {

	WebDriver driver;
	String baseUrl = "http://rwcvmx40q0499.openwave.com:8010/ox6/ox.html?admin=true";

	@Test
	public void loginRM() {

		driver.get(baseUrl);
		sleep(4000);
		WebElement userName = driver.findElement(By
				.xpath("//*[@id='username']"));
		WebElement password = driver.findElement(By
				.xpath("//*[@id='password']"));
		WebElement loginBtn = driver.findElement(By
				.xpath("//*[@id='inner-login-button']"));

		userName.clear();
		userName.sendKeys("jf000006@belgacom.com");
		password.clear();
		password.sendKeys("jf000006");
		loginBtn.click();

		waitWebElement(driver, "//*[@id='popup.wizzard.header']");

		Assert.assertTrue(IsElementPresent(driver,
				"//*[@id='wizzardStartImage']"));
	}

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@AfterClass
	public void afterClass() {

		driver.quit();

	}

}

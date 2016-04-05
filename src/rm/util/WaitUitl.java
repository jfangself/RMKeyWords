package rm.util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class WaitUitl {
	// 用于测试执行过程中暂停程序执行的休眠方法
	public static void sleep(long millisecond) {
		try {
			// 线程休眠 millisecond参数定义的毫秒数
			Thread.sleep(millisecond);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 显示等待页面元素出现的封装方法，参数为页面元素的xpath定位字符串
	public static void waitWebElement(WebDriver driver, String xpathExpression) {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		// 调用expectconditions的presenceOfElementLocated方法判断页面元素是否出现
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath(xpathExpression)));
	}

	// 显示等待页面元素出现的封装方法，参数表示页面元素的By对象，此函数可以支持更多定位表达式
	public static void waitWebElement(WebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		// 调用expectedcondition的方法判断页面元素是否出现
		wait.until(ExpectedConditions.presenceOfElementLocated(by));

	}

	public static boolean IsElementPresent(WebDriver driver,
			String xpathExpression) {

		try {

			driver.findElement(By.xpath(xpathExpression));
			return true;

		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/*
	 * public static boolean IsElementPresent(By by) {
	 * 
	 * try { System.setProperty("webdriver.chrome.driver",
	 * "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe"
	 * ); WebDriver driver = new ChromeDriver(); driver.findElement(by); return
	 * true;
	 * 
	 * } catch (NoSuchElementException e) { return false; } }
	 */
}

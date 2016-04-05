package rm.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class WaitUitl {
	// ���ڲ���ִ�й�������ͣ����ִ�е����߷���
	public static void sleep(long millisecond) {
		try {
			// �߳����� millisecond��������ĺ�����
			Thread.sleep(millisecond);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ��ʾ�ȴ�ҳ��Ԫ�س��ֵķ�װ����������Ϊҳ��Ԫ�ص�xpath��λ�ַ���
	public static void waitWebElement(WebDriver driver, String xpathExpression) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		// ����expectconditions��presenceOfElementLocated�����ж�ҳ��Ԫ���Ƿ����
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathExpression)));
	}

	// ��ʾ�ȴ�ҳ��Ԫ�س��ֵķ�װ������������ʾҳ��Ԫ�ص�By���󣬴˺�������֧�ָ��ඨλ����ʽ
	public static void waitWebElement(WebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		// ����expectedcondition�ķ����ж�ҳ��Ԫ���Ƿ����
		wait.until(ExpectedConditions.presenceOfElementLocated(by));

	}
}
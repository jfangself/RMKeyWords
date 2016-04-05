package rm.util;

import org.apache.log4j.Logger;

public class Log {

	private static Logger Log = Logger.getLogger(Log.class.getName());

	// �������������ʼִ�еĴ�ӡ����������־�д�ӡ����������ʼִ�е���Ϣ

	public static void startTestCase(String testCaseName) {
		Log.info("---------        \"" + testCaseName + "\"begin execution     ---------");
	}

	// �����������ִ����Ϻ�Ĵ�ӡ����������־�д�ӡ��������ִ����ϵ���Ϣ

	public static void endTestCase(String testCaseName) {
		Log.info("---------        \"" + testCaseName
				+ "\"end execution     ---------");
	}

	// �����ӡinfo������־�ķ���

	public static void info(String message) {
		Log.info(message);
	}

	// �����ӡdebug������־�ķ���

	public static void debug(String message) {
		Log.debug(message);
	}
}

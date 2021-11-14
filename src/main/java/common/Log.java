package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import managers.FileReaderManager;

public class Log {
	public static Logger logInfo= Logger.getLogger("Global");

	public static void initializeLog() {

		Properties logProperties = new Properties();

		// load log4j properties configuration file
		try {
			logProperties.load(new FileInputStream(FileReaderManager.getInstance().getConfigReader().getLogPropertiesPath()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logInfo.error("Log properties file not found :", e);
		} catch (IOException e) {
			e.printStackTrace();
			logInfo.error("Unable to load logging property :", e);
		}
	}

}

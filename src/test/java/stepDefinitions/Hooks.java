package stepDefinitions;

import common.Log;
import cucumber.api.java.Before;
import managers.WebDriverManager;

public class Hooks {
	@Before
	public void initDriver() {
		WebDriverManager.getDriver();
		Log.initializeLog();
	}
}

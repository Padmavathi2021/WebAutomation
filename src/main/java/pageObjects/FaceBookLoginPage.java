package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import common.Log;
import managers.FileReaderManager;
import managers.PageObjectManager;

public class FaceBookLoginPage extends PageObjectManager {

	public FaceBookLoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.ID, using = "email")
	private WebElement username;

	@FindBy(how = How.ID, using = "pass")
	private WebElement password;

	@FindBy(how = How.NAME, using = "login")
	private WebElement login;
	
	public void getAppUrl() {
		driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getFaceBookUrl());
	}

	public void enterUserName(String text) {
		enterText(username, text);
	}

	public void enterPassword(String text) {
		enterText(password, text);
	}

	public void clickLogin() {
		clickElement(login);
		Log.logInfo.info("Clicking login button");
		waitForPageLoad();
	}
}

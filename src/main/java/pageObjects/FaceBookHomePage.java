package pageObjects;

import java.util.concurrent.TimeUnit;

import org.joda.time.LocalDate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import common.Log;
import managers.PageObjectManager;

public class FaceBookHomePage extends PageObjectManager{

	public FaceBookHomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.CSS, using = "div[aria-label='Menu']")
	WebElement menu;

	@FindBy(how = How.XPATH, using = "//span[text()='Post']")
	WebElement postMenu;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@aria-label,'on your mind')]")
	WebElement status;
	
	@FindBy(how = How.XPATH, using = "//div[@aria-label='Post']")
	WebElement post;

	
	public void enterStatusMessage(String text) {
		clickElement(menu);
		Log.logInfo.info("Clicking post under the menu");
		clickElement(postMenu);
		waitForElementToBeClickable(status);
		clickElement(status);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		enterText(status, text + LocalDate.now().toString());
		Log.logInfo.info("Posted a status message");
		clickElement(post);
		Log.logInfo.info("Clicking post button");
	}
}

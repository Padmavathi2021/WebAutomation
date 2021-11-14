package pageObjects;

import java.util.function.Function;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.Log;

public class BasePage {

	private static final int TIMEOUT = 5;
	private static final int POLLING = 60;

	protected WebDriver driver;
	private WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, TIMEOUT, POLLING);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
	}

	protected void waitForElement(WebElement element) {
		waitForPageLoad();
		waitForElementToBeVisible(element);
	}

	protected void waitForElementToBeVisible(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("Element is not visible");
		}

	}

	protected void waitForPageLoad() {
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
						.equals("complete");
			}
		});
	}

	protected void waitForElementToBeClickable(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("Element is not clickable");
		}
	}

	protected void waitForElementToBeInvisible(WebElement element) {
		try {
			wait.until(ExpectedConditions.invisibilityOf(element));
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("Element is not invisible");
		}
	}

	protected void enterText(WebElement element, String text) {
		try {
			element.sendKeys(text);
			Log.logInfo.info("Entering value in the text field" + element);
		} catch (TimeoutException ex) {
			waitForElementToBeVisible(element);
			element.sendKeys(text);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("Unable to enter text in the text field");
		}
	}

	protected void clickElement(WebElement element) {
		try {
			element.click();
			Log.logInfo.info(element + "is clicked");
		} catch (TimeoutException ex) {
			waitForElementToBeVisible(element);
			element.click();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("Element is not present to be clicked");
		}
	}

	protected void mouseHover(WebElement element) {
		Actions action = new Actions(driver);
		try {
			action.moveToElement(element).build().perform();
			Log.logInfo.info(element + "Hovered");
		} catch (TimeoutException ex) {
			waitForElementToBeVisible(element);
			action.moveToElement(element).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("Unable to mouse hover on the element");
		}
	}

	protected void scrollIntoView(WebElement element) {
		Log.logInfo.info("Scroll in to view of the element" + element);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
	}
	
	protected void scrollToTop() {
		Log.logInfo.info("Scroll to top of the element");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
	}
}

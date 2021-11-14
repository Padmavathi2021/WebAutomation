package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.BasePage;
import pageObjects.FaceBookHomePage;
import pageObjects.FaceBookLoginPage;

public class PageObjectManager extends BasePage{
	private FaceBookLoginPage faceBookLoginPage;
	private FaceBookHomePage faceBookHomePage;
	
	public PageObjectManager(WebDriver driver) {
		super(driver);
	}

	public FaceBookLoginPage getFaceBookLoginPage(){
		return (faceBookLoginPage == null) ? faceBookLoginPage = new FaceBookLoginPage(driver) : faceBookLoginPage;
	}

	public FaceBookHomePage getFaceBookHomePage(){
		return (faceBookHomePage == null) ? faceBookHomePage = new FaceBookHomePage(driver) : faceBookHomePage;
	}
}

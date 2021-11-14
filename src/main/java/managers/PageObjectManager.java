package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.BasePage;
import pageObjects.FaceBookHomePage;
import pageObjects.FaceBookLoginPage;
import pageObjects.WalletHubProfilePage;
import pageObjects.WalletHubReviewPage;

public class PageObjectManager extends BasePage{
	private FaceBookLoginPage faceBookLoginPage;
	private FaceBookHomePage faceBookHomePage;
	private WalletHubReviewPage walletHubReviewPage;
	private WalletHubProfilePage walletHubProfilePage;
	
	public PageObjectManager(WebDriver driver) {
		super(driver);
	}

	public FaceBookLoginPage getFaceBookLoginPage(){
		return (faceBookLoginPage == null) ? faceBookLoginPage = new FaceBookLoginPage(driver) : faceBookLoginPage;
	}

	public FaceBookHomePage getFaceBookHomePage(){
		return (faceBookHomePage == null) ? faceBookHomePage = new FaceBookHomePage(driver) : faceBookHomePage;
	}
	
	public WalletHubReviewPage getWalletHubReviewPage(){
		return (walletHubReviewPage == null) ? walletHubReviewPage = new WalletHubReviewPage(driver) : walletHubReviewPage;
	}
	
	public WalletHubProfilePage getWalletHubProfilePage(){
		return (walletHubProfilePage == null) ? walletHubProfilePage = new WalletHubProfilePage(driver) : walletHubProfilePage;
	}
}

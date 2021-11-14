package stepDefinitions;

import common.Log;
import common.TestContext;
import cucumber.api.java.en.*;
import managers.FileReaderManager;
import pageObjects.FaceBookHomePage;
import pageObjects.FaceBookLoginPage;
import testDataTypes.FaceBook;

public class FaceBookStepDefinition {
	TestContext testContext;
	FaceBookLoginPage faceBookLoginPage;
	FaceBookHomePage faceBookHomePage;
	FaceBook user;

	public FaceBookStepDefinition(TestContext context) {
		testContext = context;
		faceBookLoginPage = testContext.getPageObjectManager().getFaceBookLoginPage();
		faceBookHomePage = testContext.getPageObjectManager().getFaceBookHomePage();
	}

	@When("^I launch facebook url$")
	public void i_launch_facebook_url() throws Throwable {
		Log.logInfo.info("Launching facebook url");
		faceBookLoginPage.getAppUrl();
	}

	@When("I login to facebook with username {string}")
	public void i_login_to_facebook_with_username(String userName) {
		user = FileReaderManager.getInstance().getJsonReader().getUserName(userName);
		faceBookLoginPage.enterUserName(user.userName);
		faceBookLoginPage.enterPassword(user.password);
		faceBookLoginPage.clickLogin();
	}

	@When("I post a status message")
	public void i_post_a_status_message() {
		faceBookHomePage.enterStatusMessage(user.statusMessage);
	}
}

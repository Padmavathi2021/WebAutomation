package pageObjects;

import common.Log;
import managers.FileReaderManager;
import managers.PageObjectManager;
import org.joda.time.LocalDate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.concurrent.TimeUnit;

public class FlowChartPage extends PageObjectManager{

	public FlowChartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//div[@class='geSidebar']//a[5]")
	private WebElement eclipse;

	@FindBy(how = How.XPATH, using = "//div[@class='geSidebar']//a[40]")
	private WebElement arrow;

	@FindBy(how = How.XPATH, using = "//div[@class='geSidebar']//a[10]")
	private WebElement parallelogram;

	@FindBy(how = How.XPATH, using = "//div[@class='geSidebar']//a[1]")
	private WebElement rectangle;

	@FindBy(how = How.XPATH, using = "//div[@class='geSidebar']//a[7]")
	private WebElement circle;

	@FindBy(how = How.CSS, using = "[class='geBackgroundPage']")
	private WebElement backgroundPage;

	@FindBy(how = How.XPATH, using = "//span[text()='Decide later']")
	private WebElement decideLater;


	public void getAppUrl() {
		driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getFlowchartUrl());
		clickElement(decideLater);
	}

	public void drawFlowChart(){
		this.addShape("eclipse");
		clickElement(arrow);
		this.addShape("parallelogram");
		clickElement(arrow);
		this.addShape("rectangle");
		clickElement(arrow);
		this.addShape("parallelogram");
		clickElement(arrow);
		this.addShape("eclipse");
		Log.logInfo.info("Flowchart is drawn");
	}

	public void addShape(String shape){
		switch(shape) {
			case "eclipse":
				clickElement(eclipse);
				break;
			case "rectangle":
				clickElement(rectangle);
				break;
			case "circle":
				clickElement(circle);
			case "parallelogram":
				clickElement(parallelogram);
		}
	}

}

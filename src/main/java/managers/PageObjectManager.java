package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.BasePage;
import pageObjects.FlowChartPage;

public class PageObjectManager extends BasePage{

	private FlowChartPage flowChartPage;
	
	public PageObjectManager(WebDriver driver) {
		super(driver);
	}

	public FlowChartPage getFlowChartPage(){
		return (flowChartPage == null) ? flowChartPage = new FlowChartPage(driver) : flowChartPage;
	}
}

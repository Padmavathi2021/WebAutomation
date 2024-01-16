package stepDefinitions;

import common.Log;
import common.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.FlowChartPage;

public class FlowChartStepDefinition {
	TestContext testContext;
	FlowChartPage flowChartPage;

	public FlowChartStepDefinition(TestContext context) {
		testContext = context;
		flowChartPage = testContext.getPageObjectManager().getFlowChartPage();
	}

	@When("I launch flowchart url")
	public void i_launch_flowchart_url() {
		Log.logInfo.info("Launching flowchart url");
		flowChartPage.getAppUrl();
	}

	@When("I draw a flowchart")
	public void i_draw_a_flowchart() {
		flowChartPage.drawFlowChart();
	}

	@When("I add a shape in the flowchart")
	public void i_add_a_shape_in_the_flowchart() {
		flowChartPage.addShape("circle");
	}
}

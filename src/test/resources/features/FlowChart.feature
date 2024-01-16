Feature: Flowchart feature
  I want to draw a flowchart

@Test
  Scenario: Verify I am able to add a shape in the flowchart
  When I launch flowchart url
    And I draw a flowchart
    And I add a shape in the flowchart

Feature: FaceBook feature
  I want to post a message

  @Test
  Scenario: Verify message post in facebook
  When I launch facebook url 
  And I login to facebook with username "username"
  And I post a status message
    
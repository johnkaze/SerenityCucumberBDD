Feature: Walmart test feature

  @Smoke
  Scenario: scenario one
    Given Home page of the application
    Then The Excel SS should be reset
    When Click on the Search In button
    Then Should see the Cell Phones selection
    Then Click on the Cell Phones selection
    And Enter Mobile Phone as criteria
    Then Click on Search Submit
    When Scrolled thru all of the selection pages while writing the selections in the SS
    Then Close the SS and all windows

#  @Regression
#  Scenario Outline: scenario two
#    Given I am at home page of the application
#    And I enter <username> and <password> as credentials
#    When I click on Login button
#    Then I should see SignOff link
#    And I click on Logout button
#    Then I should see SignOn link

 #   Examples:
 #     | username | password |
 #     | demo     | demo     |
 #     | demo     | demo     |

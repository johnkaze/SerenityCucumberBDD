Feature: Walmart Order Feature

  @Smoke
  Scenario: scenario one
    Given Walmart home page
    Then Login from Excel SS
    When When valid Login Click Search In button
    Then Should see Cell Phones selection
    Then Click Cell Phones selection
    And Enter iPhone 6s plus criteria
    Then Click Search Submit
    When Items page is displayed Click $150 - $200 filter
    Then Click the second offering
    When Second offering page is displayed Click rose color option
    Then Click Add to Cart button
    When Preview Cart page is displayed Verify selection and Click Check Out button
    When Checkout page is displayed Click Continue button
    When Confirm Delivery address page is displayed Click Add new address option
    Then Populate shipping address and Click Save Address button
    When Confirm delivery address is displayed Click Continue button
	When Enter payment method is displayed Verify shipping address and Click shopping cart icon
	When Shopping cart page is displayed Click account icon
	Then Click Sign Out option   
    Then Close all windows

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

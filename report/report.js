$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/WalmartDemo.feature");
formatter.feature({
  "name": "Walmart test feature",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "scenario one",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Smoke"
    }
  ]
});
formatter.step({
  "name": "Home page of the application",
  "keyword": "Given "
});
formatter.match({
  "location": "WalmartDemoStepDefs.atHomePageOfTheApplication()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The Excel SS should be reset",
  "keyword": "Then "
});
formatter.match({
  "location": "WalmartDemoStepDefs.the_Excel_SS_should_be_reset()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on the Search In button",
  "keyword": "When "
});
formatter.match({
  "location": "WalmartDemoStepDefs.click_on_the_Search_In_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Should see the Cell Phones selection",
  "keyword": "Then "
});
formatter.match({
  "location": "WalmartDemoStepDefs.should_see_the_Cell_Phones_selection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on the Cell Phones selection",
  "keyword": "Then "
});
formatter.match({
  "location": "WalmartDemoStepDefs.clickOnCellPhonesSelection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter Mobile Phone as criteria",
  "keyword": "And "
});
formatter.match({
  "location": "WalmartDemoStepDefs.enterCriteria(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Search Submit",
  "keyword": "Then "
});
formatter.match({
  "location": "WalmartDemoStepDefs.clickOnSearchSubmit()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Scrolled thru all of the selection pages while writing the selections in the SS",
  "keyword": "When "
});
formatter.match({
  "location": "WalmartDemoStepDefs.scrollPagesandWriteSS()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Close the SS and all windows",
  "keyword": "Then "
});
formatter.match({
  "location": "WalmartDemoStepDefs.shutdownApplication()"
});
formatter.result({
  "status": "passed"
});
});
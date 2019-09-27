package starter.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import starter.pages.WalmartDemoPage;

public class WalmartDemoStepDefs {

    @Steps
    WalmartDemoPage walmartDemoPage;

    private static final Logger logger = LoggerFactory.getLogger(WalmartDemoStepDefs.class);

    @Given("^Home page of the application$")
    public void atHomePageOfTheApplication() {
        walmartDemoPage.open();
        walmartDemoPage.PFInitit();
    }
    
    @Then("^The Excel SS should be reset$")
    public void the_Excel_SS_should_be_reset() throws Exception {
    	walmartDemoPage.resetExcelSS();
        return;

    }    

    @When("^Click on the Search In button$")
    public void click_on_the_Search_In_button() {
        walmartDemoPage.clickSearchIn();

    }

    @Then("^Should see the Cell Phones selection$")
    public void should_see_the_Cell_Phones_selection() throws Exception {
        Assert.assertTrue(walmartDemoPage.VerifyCellPhonesDisplayed());

    }
    
    @Then("^Click on the Cell Phones selection$")
    public void clickOnCellPhonesSelection() {
        walmartDemoPage.clickOnCellPhones();
    }      
    
    @And("^Enter (.*) as criteria$")
    public void enterCriteria(String arg1) {
        walmartDemoPage.enterSearchString(arg1);
    }
    
    @Then("^Click on Search Submit$")
    public void clickOnSearchSubmit() {
        walmartDemoPage.clickOnSearchSubmit();
    }
    
    @When("^Scrolled thru all of the selection pages while writing the selections in the SS$")
    public void scrollPagesandWriteSS() {
    	walmartDemoPage.scrollPhonePagesandWriteSS();
        return;

    } 
    
    @Then("^Close the SS and all windows$")
    public void shutdownApplication() {
    	walmartDemoPage.closeExcelSS();
        walmartDemoPage.getDriver().quit();
    }    


//    @Then("^I should see SignOn link$")
//    public void iShouldSeeSignOnLink() {
//        walmartDemoPage.VerifySignInLinkDisplayed();
//    }

}
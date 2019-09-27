package starter.stepdefinitionsorder;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import starter.pages.WalmartOrderPage;

public class WalmartOrderStepDefs {

    @Steps
    WalmartOrderPage walmartOrderPage;

    private static final Logger logger = LoggerFactory.getLogger(WalmartOrderStepDefs.class);

    @Given("^Walmart home page$")
    public void atHomePageOfTheApplication() {
        walmartOrderPage.open();
        walmartOrderPage.PFInitit();
    }
    
    @Then("^Login from Excel SS$")
    public void loginFromExeclSS() throws Exception {
    	walmartOrderPage.loginFromExcelSS();
        return;

    }    

    @When("^When valid Login Click Search In button$")
    public void click_on_the_Search_In_button() {
    	walmartOrderPage.validateLogin();
        walmartOrderPage.clickSearchIn();
    }

    @Then("^Should see Cell Phones selection$")
    public void should_see_the_Cell_Phones_selection() throws Exception {
        Assert.assertTrue(walmartOrderPage.VerifyCellPhonesDisplayed());

    }
    
    @Then("^Click Cell Phones selection$")
    public void clickOnCellPhonesSelection() {
        walmartOrderPage.clickOnCellPhones();
    }      
    
    @And("^Enter (.*) criteria$")
    public void enterCriteria(String arg1) {
        walmartOrderPage.enterSearchString(arg1);
    }
    
    @Then("^Click Search Submit$")
    public void clickOnSearchSubmit() {
        walmartOrderPage.clickOnSearchSubmit();
    }
    
    @When("^Items page is displayed Click \\$150 - \\$200 filter$")
    public void clickRangeFilter() {
    	walmartOrderPage.clickDollarRange();
        return;

    } 
    
    @When("^Click the second offering$")
    public void clickOffering() {
    	walmartOrderPage.clickOffering();
        return;

    }
    @When("^Second offering page is displayed Click rose color option$")
    public void clickRoseColor() {
    	walmartOrderPage.clickRoseColor();
        return;
    } 
    @Then("^Click Add to Cart button$")
    public void clickAddtoCart() {
    	walmartOrderPage.clickAddtoCart();
        return;
    }
    @When("^Preview Cart page is displayed Verify selection and Click Check Out button$")
    public void clickCheckOut() {
    	walmartOrderPage.clickCheckOut();
        return;
    }
    @When("^Checkout page is displayed Click Continue button$")
    public void clickContinue1() {
    	walmartOrderPage.clickContinue1();
        return;
    }
    @When("^Confirm Delivery address page is displayed Click Add new address option$")
    public void clickAddAddress() {
    	walmartOrderPage.clickAddAddress();
        return;
    } 
    @Then("^Populate shipping address and Click Save Address button$")
    public void saveShippingAddress() {
    	walmartOrderPage.saveShippingAddress();
        return;
    }
    @When("^Confirm delivery address is displayed Click Continue button$")
    public void clickContinue2() {
    	walmartOrderPage.clickContinue2();
        return;
    } 
    @When("^Enter payment method is displayed Verify shipping address and Click shopping cart icon$")
    public void verifyShippingAddress() {
    	walmartOrderPage.verifyShippingAddress();
        return;
    }
    @When("^Shopping cart page is displayed Click account icon$")
    public void clickAccountIcon() {
    	walmartOrderPage.clickAccountIcon();
        return;
    }
    @Then("^Click Sign Out option$")
    public void clickSignOut() {
    	walmartOrderPage.clickSignOut();
    }    

    @Then("^Close all windows$")
    public void shutdownApplication() {
        walmartOrderPage.getDriver().quit();
    }    


}
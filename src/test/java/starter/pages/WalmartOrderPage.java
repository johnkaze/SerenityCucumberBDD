package starter.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Constants;
import util.FileUtils;
import util.SeleniumUtils;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

import objectrepository.ObjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@UseTestDataFrom(value="src/test/resources/testdata/TestData.csv")
public class WalmartOrderPage extends UIInteractionSteps {

	private static final Logger logger = LoggerFactory.getLogger(WalmartOrderPage.class);	
	private XSSFWorkbook wb = null;
	private FileOutputStream out = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell0 = null;
	private XSSFCell cell1 = null;
	private XSSFCellStyle cellStyle = null;
	private WebDriverWait wait;
	private String userName = null;
	private String passWord = null;
	private WebDriver driver;
	private SeleniumUtils seleniumUtils;
	private Properties properties;
	private boolean status1;
	Select stateSelect = null;
	
	List<WebElement> links = null;
	List<WebElement> anchors = null;
	String phonedescriptionList = null;
	String phonedescriptionCart = null;	
	
    @Step("Enter search string using criteria{0}")
    public void enterSearchString(String criteria) {
//        waitFor(titleContains("Welcome: Mercury Tours"));
        Assert.assertEquals("Welcome: Mercury Tours","Welcome: Mercury Tours");
        ObjectRepository.searchInput.sendKeys(criteria);
        return;
    }

	public void PFInitit() {
		PageFactory.initElements(this.getDriver(), new ObjectRepository());
		driver = this.getDriver();
		wait = new WebDriverWait(this.getDriver(), 5);
        FileUtils fileUtils = new FileUtils();        // Creating FileUtils object.
        properties = fileUtils.readTestProps(Constants.PROPERTIES_DIR + "test.properties");
        seleniumUtils = new SeleniumUtils(properties); // Calling SeleniumUtils class to use webDriver methods
		return;
	}
	public void loginFromExcelSS() {
    	XSSFWorkbook wb = null;
//    	FileInputStream inFile = null;
    	XSSFSheet sheet = null;
    	XSSFRow row = null;
    	XSSFCell cell0 = null;
    	XSSFCell cell1 = null;

    	DataFormatter dataFormatter = new DataFormatter();		
//
//    	Login using ID and Password provided in Excel format   	
//
    	try {
			wb = (XSSFWorkbook) XSSFWorkbookFactory.createWorkbook(new File(Constants.XLSX_INPUT_DIR + Constants.USERNAME_PASSWORD_XLSX), true);
			sheet = wb.getSheetAt(0);
			row = sheet.getRow(1);
			cell0 = row.getCell(0);
			cell1 = row.getCell(1);
			userName = dataFormatter.formatCellValue(cell0);
			passWord = dataFormatter.formatCellValue(cell1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.accountDropDown));
    	ObjectRepository.accountDropDown.click();
    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.signIn));
    	ObjectRepository.signIn.click();
    	ObjectRepository.userId.clear();
//    	ObjectRepository.userId.sendKeys(properties.getProperty("UserID"));
    	ObjectRepository.userId.sendKeys(userName);
    	ObjectRepository.passWord.clear();
//    	ObjectRepository.userId.sendKeys(properties.getProperty("UserPW"));
    	ObjectRepository.passWord.sendKeys(passWord);
    	
    	ObjectRepository.logInButton.click();    	
    	
		return;
	}
	public void validateLogin() {
		seleniumUtils.waitForPageLoad(driver, 500);
		//
		//	 	Validate login 
		//	        	

		wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.accountDropDown));
		ObjectRepository.accountDropDown.click();
		wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.accountProfile)); 
		ObjectRepository.accountProfile.click();
		seleniumUtils.waitForPageLoad(driver, 500);
		wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.accountEmailOption)); 
		ObjectRepository.accountEmailOption.click();
		seleniumUtils.waitForPageLoad(driver, 500); 	
		Assert.assertEquals(userName,ObjectRepository.accountEmail.getText());
		return;
	}		

	
	public void clickDollarRange() {
    	seleniumUtils.waitForPageLoad(driver, 1000);

//    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.dollarRange));
		status1 = seleniumUtils.waitForElementClickable(driver, ObjectRepository.dollarRange);
		System.out.println("dollarRange " + status1);
    	ObjectRepository.dollarRange.click();
    	return;
	}

    public void clickSearchIn() {
    	ObjectRepository.searchDropdown.click();
    	return;
    }
    public boolean VerifyCellPhonesDisplayed() {
        return ObjectRepository.cellPhones.isDisplayed();
    }

    public void clickOnCellPhones() {
    	ObjectRepository.cellPhones.click();
    	return;
    }

    public void clickOnSearchSubmit() {
    	ObjectRepository.searchSubmit.click();
    	return;
    }
    public void clickOffering() {
    	seleniumUtils.waitForPageLoad(driver, 1000);
		
//
//	 	Add the second iPhone 6s plus displayed to the shopping cart after 	
//		selecting the gray color.
//
		
//    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.firstIphone6s));
		status1 = seleniumUtils.waitForElementClickable(driver, ObjectRepository.firstIphone6s);
		System.out.println("firstIphone6s " + status1);
    	links = ObjectRepository.unorderedList.findElements(By.tagName("li"));
		anchors = links.get(1).findElements(By.tagName("a"));
		phonedescriptionList = anchors.get(1).getAttribute("title");
    	ObjectRepository.firstIphone6s.click();
    	return;
    }
    public void clickRoseColor() {
    	seleniumUtils.waitForPageLoad(driver, 1000);
		
//		Actions builder = new Actions(driver);
//		builder.moveToElement(ObjectRepository.darkButton).build().perform();
//    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.colorButton));
		status1 = seleniumUtils.waitForElementClickable(driver, ObjectRepository.colorButton);
		System.out.println("colorButton " + status1);    	
    	ObjectRepository.colorButton.click();
    	return;
    }
    public void clickAddtoCart() {
		status1 = seleniumUtils.waitForElementClickable(driver, ObjectRepository.addToCart);
		System.out.println("addToCart " + status1);  
    	ObjectRepository.addToCart.click();
    	return;
    }
    public void clickCheckOut() {
    	seleniumUtils.waitForPageLoad(driver, 500);
//    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.checkoutButton));
		status1 = seleniumUtils.waitForElementClickable(driver, ObjectRepository.checkoutButton);
		System.out.println("checkoutButton " + status1);   
    	phonedescriptionCart = ObjectRepository.cartDescription.getText();
 
//
//	 	Validate that the phone was added to the cart.
//
    	
        Assert.assertEquals(phonedescriptionList,phonedescriptionCart);
        ObjectRepository.checkoutButton.click();
        return;
    }
    public void clickContinue1() {
//
//	 	Place a break point on the following line of code to stop execution in order to handle 	
//		a possible (not always required) manual re-entry of the password.
//
        
    	seleniumUtils.waitForPageLoad(driver, 500);
//    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.continueButton1));
		status1 = seleniumUtils.waitForElementClickable(driver, ObjectRepository.continueButton1);
		System.out.println("continueButton1 " + status1);   
    	ObjectRepository.continueButton1.click();
    	return;
    }  
    public void clickAddAddress() {
//    	seleniumUtils.waitForPageLoad(driver, 1000);
//    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.continueButton1));
//    	ObjectRepository.continueButton1.click();    	
    	
//
//	 	Add a new shipping address before proceeding with checkout. 	
//
    	
    	seleniumUtils.waitForPageLoad(driver, 500);
//    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.addNewAddress));
		status1 = seleniumUtils.waitForElementClickable(driver, ObjectRepository.addNewAddress);
		System.out.println("addNewAddress " + status1);  
    	ObjectRepository.addNewAddress.click();
    	return;
    }
    public void saveShippingAddress() {
    	seleniumUtils.waitForPageLoad(driver, 500);
    	
//    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.firstName));
		status1 = seleniumUtils.waitForElementClickable(driver, ObjectRepository.firstName);
		System.out.println("firstName " + status1);  
    	ObjectRepository.firstName.clear();
    	ObjectRepository.firstName.sendKeys("Don");
    	ObjectRepository.lastName.clear();
    	ObjectRepository.lastName.sendKeys("Burroughs");
    	ObjectRepository.phoneNumber.clear();
    	ObjectRepository.phoneNumber.sendKeys("(215) 483-1796");
    	ObjectRepository.streetAddress.clear();
    	ObjectRepository.streetAddress.sendKeys("574 Rector Street");
    	ObjectRepository.aptNumber.clear();
    	ObjectRepository.cityName.clear();
    	ObjectRepository.cityName.sendKeys("Philadelphia");
    	stateSelect = new Select(ObjectRepository.stateID);
    	stateSelect.selectByVisibleText("Pennsylvania");
    	ObjectRepository.zipCode.clear();
    	ObjectRepository.zipCode.sendKeys("19128");
    	ObjectRepository.saveAddress.click();
    	return;
    }
    public void clickContinue2() {
    	seleniumUtils.waitForPageLoad(driver, 1000);
		status1 = seleniumUtils.waitForElementClickable(driver, ObjectRepository.continueButton2);
		System.out.println("continueButton2 " + status1);  
    	ObjectRepository.continueButton2.click();
    	return;
    }
    public void verifyShippingAddress() {
    	//
//	 	Validate the new shipping address and logout (logout executed by calling method) without
//		entering credit card details.
// 

    	seleniumUtils.waitForPageLoad(driver, 7000);
//    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.shoppingCart));
		status1 = seleniumUtils.waitForElementClickable(driver, ObjectRepository.shoppingCart);
		System.out.println("shoppingCart " + status1);  
    	
        Assert.assertEquals("Don Burroughs",ObjectRepository.shippingName.getText());
        Assert.assertEquals("574 Rector Street",ObjectRepository.shippingStreet.getText());
        Assert.assertEquals("Philadelphia, PA 19128",ObjectRepository.shippingCityStateZip.getText());

    	ObjectRepository.shoppingCart.click();
    	return;
    }
    public void clickAccountIcon() {
    	seleniumUtils.waitForPageLoad(driver, 500);
//    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.accountDropDown));
		status1 = seleniumUtils.waitForElementClickable(driver, ObjectRepository.accountDropDown);
		System.out.println("accountDropDown " + status1); 
    	ObjectRepository.accountDropDown.click();
    	return;
    }
    public void clickSignOut() {
    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.signOut));
    	logger.info("SignOff text from appln is :: " + ObjectRepository.signOut.getText());
    	Assert.assertEquals(ObjectRepository.signOut.getText(),"Sign Out");
    	ObjectRepository.signOut.click();
    	return;

    }      
    
    
//    private void threadSleep (int duration) {
//		try {
//			Thread.sleep(duration);
//		} catch (InterruptedException e1) {
//			e1.printStackTrace();
//		}
//		return;
//    	
//    }
    
	

}

package starter.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Constants;
//import gherkin.formatter.Reporter;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;

import objectrepository.ObjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

//@UseTestDataFrom(value="src/test/resources/testdata/TestData.csv")
public class WalmartDemoPage extends UIInteractionSteps {

    /*private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }*/

//    @FindBy(xpath = "//input[@name='userName']")
//    private WebElement userId;
//
//    @FindBy(xpath = "//input[@name='password']")
//    private WebElement pasword;
//
//    @FindBy(xpath = "//input[@name='login']")
//    private WebElement loginButton;
//
//    @FindBy(xpath = "//a[text()='SIGN-OFF']")
//    private WebElement logoutButton;
	private static final Logger logger = LoggerFactory.getLogger(WalmartDemoPage.class);	
	private XSSFWorkbook wb = null;
	private FileOutputStream out = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell0 = null;
	private XSSFCell cell1 = null;
	private XSSFCellStyle cellStyle = null;
	private	int lastRow = 1;
	
    @Step("Enter search string using criteria{0}")
    public void enterSearchString(String criteria) {
//        waitFor(titleContains("Welcome: Mercury Tours"));
        Assert.assertEquals("Welcome: Mercury Tours","Welcome: Mercury Tours");
        ObjectRepository.searchInput.sendKeys(criteria);
        return;
    }
	public void PFInitit() {
		PageFactory.initElements(this.getDriver(), new ObjectRepository());
		return;
		
	}
	public void resetExcelSS() {
		//
//    	Delete old Excel spreadsheet & create a new replacement spreadsheet that will be loaded    	
//		with all the mobile phones from the walmart site
//        	    	
    	
    	try{ 
    		Files.deleteIfExists(Paths.get(Constants.XLSX_DIR + Constants.MOBILE_PHONE_XLSX)); 
    	} 
    	catch(NoSuchFileException e){ 
//    		System.out.println("No such file/directory exists");
            logger.info("No such file/directory exists");    		
//    		Reporter.log("No such file/directory exists", true);
    	} 
    	catch(DirectoryNotEmptyException e){ 
//    		System.out.println("Directory is not empty");
            logger.info("Directory is not empty");    		
//    		Reporter.log("Directory is not empty", true);
    	} 
    	catch(IOException e){ 
//    		System.out.println("Invalid permissions");
            logger.info("Invalid permissions");    		
//    		Reporter.log("Invalid permissions", true);
    	} 
//    	System.out.println("Excel File Deletion Successful");
        logger.info("Excel File Deletion Successful");    		
//		Reporter.log("Excel File Deletion Successful", true);

		wb = new XSSFWorkbook();
		sheet = wb.createSheet();
		row = sheet.createRow(0);
		cell0 = row.createCell(0);
   		cell1 = row.createCell(1);
		sheet.setColumnWidth(0, sheet.getColumnWidth(0) * 25);
		sheet.setColumnWidth(1, sheet.getColumnWidth(1) * 2);   		
   		cellStyle = wb.createCellStyle();
  		cellStyle.setVerticalAlignment(VerticalAlignment.TOP);
  		cellStyle.setWrapText(true);
  		cell0.setCellStyle(cellStyle);
  		cell1.setCellStyle(cellStyle);
  		cell0.setCellValue("Description");
  		cell1.setCellValue("Price");
    	try{
			out = new FileOutputStream(new File(Constants.XLSX_DIR + Constants.MOBILE_PHONE_XLSX));
    	}
    	catch(Exception e){
    		e.printStackTrace();
//    		System.out.println("Excel File Creation Failed");
            logger.info("Excel File Creation Failed");    		
//    		Reporter.log("Excel File Creation Failed", true);
    		}
		
		return;
	}
	public void scrollPhonePagesandWriteSS() {
    	WebElement pricecurrency = null;
    	WebElement pricecharacteristic = null;
    	WebElement pricemark = null;
    	WebElement pricemantissa = null;
//    	List<WebElement> pages = null;
    	List<WebElement> listViewItems = null;
    	List<WebElement> anchors = null;
    	String phonedescription = null;
    	String phoneprice = null; 
    	boolean notEof = true;

    	WebDriverWait wait;
		
//
//    	Load & iterate thru all of the mobile phone selection pages. For each phone displayed, write a
//		row into the newly created spreadsheet.
//
    	
    	wait=new WebDriverWait(this.getDriver(), 10);
    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.searchDropdown));
		ObjectRepository.searchDropdown.click();
    	wait.until(ExpectedConditions.elementToBeClickable(ObjectRepository.cellPhones));
		ObjectRepository.cellPhones.click();
		ObjectRepository.searchInput.sendKeys("Mobile Phone");
		ObjectRepository.searchSubmit.click();
        notEof = true;
    	while (notEof)
        {
//        	seleniumUtils.waitForPageLoad(driver, 1500);
    		try {
    			Thread.sleep(1500);
    		} catch (InterruptedException e1) {
    			e1.printStackTrace();
    		}
//    		this.waitOnPage();
//        	pages = ObjectRepository.unorderedPages.findElements(By.tagName("a"));

//    		status1 = seleniumUtils.waitForElementClickable(driver, pages.get(0));
//    		System.out.println(status1);

        	listViewItems = ObjectRepository.listView.findElements(By.className("arrange"));

        	for (int i = 0; i < listViewItems.size(); i++)
        	{
        		try {
            		anchors = listViewItems.get(i).findElements(By.tagName("a"));
            		phonedescription = "";
            		for (int j = 1; j < anchors.size(); j++) {
            			phonedescription = anchors.get(j).getAttribute("title");
            			if (phonedescription.length() > 0) break;
        			// 	phonedescription = anchors.get(2).getText();
            		}

        		} catch (Exception e) {
        			phonedescription = "No Title";	
        		}
        		try {
            		pricecurrency = listViewItems.get(i).findElement(By.className("price-currency"));
            		pricecharacteristic = listViewItems.get(i).findElement(By.className("price-characteristic"));
            		pricemark = listViewItems.get(i).findElement(By.className("price-mark"));
            		pricemantissa = listViewItems.get(i).findElement(By.className("price-mantissa"));
            		phoneprice = pricecurrency.getText() + pricecharacteristic.getText() + pricemark.getText() + pricemantissa.getText();
        		} catch (Exception e) {
        			phoneprice = "No Price";
        		}
//        		System.out.println(phonedescription);
//        		System.out.println(phoneprice);
        		Reporter.log(phonedescription, true);
        		Reporter.log(phoneprice, true);

        		row = sheet.createRow(lastRow++);
        		cell0 = row.createCell(0);
           		cell1 = row.createCell(1);
          		cell0.setCellStyle(cellStyle);
          		cell1.setCellStyle(cellStyle);
          		cell0.setCellValue(phonedescription);
          		cell1.setCellValue(phoneprice);
        	}
        	try {
        		if (ObjectRepository.nextPage.isDisplayed()) {
        			ObjectRepository.nextPage.click();
        		} else {
        			notEof = false;
        		}
        	} catch (Exception e) {
        		notEof = false;
        	}
        }
		
		return;
	}
	public void closeExcelSS() {
//
//		Write and close the Excel spreadsheet.
//
    	
    	try {
    		wb.write(out);
			if(out!=null)
				out.close();
			if(wb!=null)
				wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        Reporter.log("", true);
        Reporter.log("    Loaded Phones = " + (lastRow - 1), true);
        Reporter.log("*** End of Mobile Phones Load   ***", true);
        Reporter.log("", true);
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
    
//    public boolean VerifySignInLinkDisplayed() {
//        return loginButton.isDisplayed();
//    }
//	@FindBy(xpath = "//button[@id='header-account-toggle']")
//	private WebElement accountDropDown;
//
//	@FindBy(xpath = "//div[contains(text(),'Sign In')]")
//	private WebElement signIn;
//
//	@FindBy(xpath = "//input[@id='email']")
//	private WebElement userId;
//
//	@FindBy(xpath = "//input[@id='password']")
//	private WebElement passWord;
//
//	@FindBy(xpath = "//button[@class='button m-margin-top'][contains(text(),'Sign In')]")
//	private WebElement logInButton;
//
//	@FindBy(xpath = "//div[@class='variant-options-container']//span[2]")	
////	@FindBy(xpath = "div.js-content:nth-child(1) div.page-wrapper div.page-full-wrapper div.js-body-content:nth-child(2) div.ProductPage-verticalTheme-standard.ProductPage-verticalId-standard.feature-productHighlights div.atf-content div.ProductPage-verticalTheme-standard.ProductPage-verticalId-standard.feature-productHighlights div.atf-content div.ResponsiveContainer.ny-atf-container.mweb-enhanced-atf div.Grid div.Grid:nth-child(4) div.Grid-col.u-size-1-2-m:nth-child(2) div.hf-Bot.hf-PositionedRelative div.hf-BOTContainer.bot-atc-so-po-layout.bot-enhanced-mweb div.prod-VariantsSection.hf-BotRow:nth-child(6) div.variants-category-wrapper div.variant-category-container div.variants-container.variant-swatches-outer-wrapper div.variant-options-container span.variant-option-outer-container.display-inline-block.valign-top:nth-child(2) > div.variant-option-inner-container")
////	@FindBy(css = "div.js-content:nth-child(1) div.page-wrapper div.page-full-wrapper div.js-body-content:nth-child(2) div.ProductPage-verticalTheme-standard.ProductPage-verticalId-standard.feature-productHighlights div.atf-content div.ProductPage-verticalTheme-standard.ProductPage-verticalId-standard.feature-productHighlights div.atf-content div.ResponsiveContainer.ny-atf-container.mweb-enhanced-atf div.Grid div.Grid:nth-child(4) div.Grid-col.u-size-1-2-m:nth-child(2) div.hf-Bot.hf-PositionedRelative div.hf-BOTContainer.bot-so-atc-po-layout.bot-enhanced-mweb div.prod-VariantsSection.hf-BotRow:nth-child(6) div.variants-category-wrapper div.variant-category-container div.variants-container.variant-swatches-outer-wrapper div.variant-options-container span.variant-option-outer-container.display-inline-block.valign-top:nth-child(2) div.variant-option-inner-container > div.option-overlay")
//	private WebElement colorButton;
//
//	@FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
//	private WebElement addToCart;
//	
//	@FindBy(xpath = "//button[@class='button ios-primary-btn-touch-fix hide-content-max-m checkoutBtn button--primary']//span[@class='button-wrapper'][contains(text(),'Check Out')]")
//	private WebElement checkoutButton;
//	
//	@FindBy(xpath = "//span[contains(text(),'Continue')]")
//	private WebElement continueButton1;
//	
//	@FindBy(xpath = "//span[@class='elc-icon elc-icon-add elc-icon-18 valign-middle']")
//	private WebElement addNewAddress;
//	
//	@FindBy(xpath = "//input[@id='firstName']")
//	private WebElement firstName;
//	
//	@FindBy(xpath = "//input[@id='lastName']")
//	private WebElement lastName;
//	
//	@FindBy(xpath = "//input[@id='phone']")
//	private WebElement phoneNumber;
//	
//	@FindBy(xpath = "//input[@id='addressLineOne']")
//	private WebElement streetAddress;
//	
//	@FindBy(xpath = "//input[@id='addressLineTwo']")
//	private WebElement aptNumber;
//	
//	@FindBy(xpath = "//input[@id='city']")
//	private WebElement cityName;
//	
//	@FindBy(xpath = "//select[@id='state']")
//	private WebElement stateID;	
//	
//	@FindBy(xpath = "//input[@id='postalCode']")
//	private WebElement zipCode;
//	
//	@FindBy(xpath = "//span[contains(text(),'Save Address')]")
//	private WebElement saveAddress;
//	
//	@FindBy(xpath = "//span[contains(text(),'Continue')]")
//	private WebElement continueButton2;
//	
//	@FindBy(css = "div.js-content:nth-child(1) div.use-new-orange div.checkout-wrapper:nth-child(1) div.accordion-outer-wrapper div.accordion-inner-wrapper div.pos-relative.checkout-header.checkout-header-ny.access-header-container div.checkout-responsive-container.ResponsiveContainer div.text-left.Grid div.Grid-col.u-size-4-12:nth-child(3) div.checkout-header-cart-ny a.pull-right > span.elc-icon.elc-icon-cart.elc-icon-16")
//	private WebElement shoppingCart;
//	
//	@FindBy(xpath = "//div[contains(text(),'Sign Out')]")
//	private WebElement signOut;
//
//	@FindBy(xpath = "//button[@id='global-search-dropdown-toggle']//span[@class='g_a g_f']")
//	private WebElement searchDropdown;
//
//	@FindBy(xpath = "//div[@id='SearchDropdown-list']//div[1]//button[6]")
//	private WebElement cellPhones;
//
//	@FindBy(xpath = "//input[@id='global-search-input']")
//	private WebElement searchInput;
//
//	@FindBy(xpath = "//button[@id='global-search-submit']//span[@class='g_a g_f']")
//	private WebElement searchSubmit;
//	
//	@FindBy(xpath = "//span[contains(text(),'$150 - $200')]")
//	private WebElement dollarRange;
//
//	@FindBy(xpath = "//li[2]//div[1]//div[2]//div[5]//div[1]//a[1]")
////	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[4]/div[2]/div[2]/ul[1]/li[1]/div[1]/div[2]/div[5]/div[1]/a[1]/span[1]")
//	private WebElement firstIphone6s;
//
//	@FindBy(xpath = "//ul[@class='paginator-list']")
//	private WebElement unorderedPages;
//
//	@FindBy(xpath = "//ul[@class='search-result-gridview-items four-items']")
//	private WebElement unorderedList;
//
//	@FindBy(xpath = "//button[@class='elc-icon paginator-hairline-btn paginator-btn paginator-btn-next outline']")
//	private WebElement nextPage;
//	
//	@FindBy(xpath = "//a[@class='js-btn-product btn-fake-link cart-item-name-link']")
//	private WebElement cartDescription;
//	
//	@FindBy(xpath = "//span[@class='shipping-address-long-word']")
//	private WebElement shippingName;	
//
//	@FindBy(xpath = "//div[@class='font-semibold']//span[contains(text(),'574 Rector Street')]")
//	private WebElement shippingStreet;
//	
//	@FindBy(xpath = "//div[@class='CXO_module_header normal ResponsiveContainer']//span[3]")
//	private WebElement shippingCityStateZip;
//	
//	@FindBy(xpath = "//p[contains(text(),'jkaze@si.rr.com')]")
//	private WebElement signonEmail;
//	
//	@FindBy(xpath = "//div[contains(text(),'Account')]")
//	private WebElement accountProfile;	
//
//	@FindBy(xpath = "//a[contains(text(),'Profile & Password')]")
//	private WebElement accountEmailOption;	
//	
//	@FindBy(xpath = "//p[contains(text(),'jkaze@si.rr.com')]")
//	private WebElement accountEmail;	
//
//	
//	
////  ************************	
//	
//	@FindBy(xpath = "//div[@class='search-result-listview-items']")
//	private WebElement listView;	
	

}

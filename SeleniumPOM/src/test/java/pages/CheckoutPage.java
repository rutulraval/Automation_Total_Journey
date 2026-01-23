package pages;
import base.BaseSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // first-name
    @FindBy(id="first-name")
    WebElement fName;

    // last-name
    @FindBy(id="last-name")
    WebElement lName;

    // postal-code
    @FindBy(id="postal-code")
    WebElement pCode;

    // continue
    @FindBy(id="continue")
    WebElement continueBtn;

    // xpath : //*[@id="checkout_summary_container"]/div/div[1]/div[3]/div[2]/div[2]/div
    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")
    WebElement priceOnCheckout;

    @FindBy(id="finish")
    WebElement finishBtn;

    public void setfName(String str){
        fName.click();
        fName.sendKeys(str);
    }

    public void setlName(String str){
        lName.click();
        lName.sendKeys(str);
    }

    public void setpCode(String str){
        pCode.click();
        pCode.sendKeys(str);
    }

    public void clickContinue(){
        continueBtn.click();
    }

    public boolean compareOnCheckout(){
        if(HomePage.priceOfProduct == priceOnCheckout.getText())
            return true;
        else return false;
    }

    public void clickOnFinishBtn(){
        finishBtn.click();
    }
}
/*
    Locate:
    First name, Last Name, ZIP code boxes.
    Continue button

    Tests to do:
    1. Click on Continue button without entering any data, assert Error appears
    2. Enter data in all 3 boxes, click on Continue
    3. Locate Price written under the item, match it with price stored in HomePage.
    4. Locate Finish button, click on it.
    5. Go to Thanks Page


 */
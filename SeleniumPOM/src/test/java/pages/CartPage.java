package pages;

import base.BaseSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage  {

    WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "shopping_cart_container")
    WebElement cartButton;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeButton;

    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")
    WebElement priceOnCartPage;


    WebElement checkoutBtn;

    public void clickOnCart(){
        cartButton.click();
    }

    public void clickOnRemove(){
        removeButton.click();
    }

    public boolean comparePrice(){
        if(HomePage.priceOfProduct == priceOnCartPage.getText())
            return true;
        else return false;
    }

    public void clickCheckout(WebDriverWait wait){
        checkoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));
        checkoutBtn.click();
    }
}
/*
   Locate cart button, click on it
   Verify price displayed on Cart page with price stored on HomePage
   Locate Checkout button, click on it

   Test2:
   Locate cart button, click on it.
   Locate Remove button, click on it
 */
package pages;

import base.BaseSetup;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // locate Test.allTheThings() T-Shirt (Red)
    // in that Element try to find Add to Cart button
    @FindBy(id="item_3_title_link")
    WebElement product; // item_3_title_link - bring this element into scrollable view

    static String priceOfProduct;

//    {
//        priceOfProduct = product.getText();
//    }

    @FindBy(id="add-to-cart-test.allthethings()-t-shirt-(red)")
    WebElement addToCartButton; //id="add-to-cart-test.allthethings()-t-shirt-(red)"

    //method to bring product into scrollable view
    public void bringProductIntoView(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",product);
    }

    //method to click on "add-to-Cart" button
    public void clickAddToCartButton(){
        addToCartButton.click();
    }
}

//Handle alert by clicking on OK
//Scroll down to locate : Test.allTheThings() T-Shirt (Red), add it to the cart
//Store price of this element, to confirm on Cart page
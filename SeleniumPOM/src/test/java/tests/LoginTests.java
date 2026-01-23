package tests;

import base.BaseSetup;
import org.testng.Assert;
import pages.*;
import org.testng.annotations.Test;

import java.awt.*;


public class LoginTests extends BaseSetup {


    @Test
    public void verifyOrderPlacement() {

        LoginPage login = new LoginPage(driver);
        HomePage products = new HomePage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);
        ThanksPage thanksPage = new ThanksPage(driver);

        login.login("standard_user", "secret_sauce");
        products.bringProductIntoView();
        products.clickAddToCartButton();
        cart.clickOnCart();
        //jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        cart.clickCheckout(wait);
        checkout.setfName("Rutul");
        checkout.setlName("RRR");
        checkout.setpCode("1356-1356");
        checkout.clickContinue();
        checkout.clickOnFinishBtn();

        Assert.assertEquals(
                thanksPage.getSuccessMessage(),
                "Thank you for your order!"
        );
    }

    @Test
    public void loginBlankUser(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("","");
        Assert.assertEquals(loginPage.getErrorMsg(),"Epic sadface: Username is required");
    }
}

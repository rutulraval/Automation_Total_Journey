package stepDefinitions;

import io.cucumber.java.After;
import org.testng.Assert;
import utils.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class MyStepdefs {

    WebDriver driver;
    LoginPage loginPage;

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
    }

    @When("user enters valid credentials")
    public void userEntersValidCredentials() {
        loginPage.login("Admin", "admin123");
    }

    @Then("user should see dashboard")
    public void userShouldSeeDashboard() {
        Assert.assertTrue(loginPage.isDashboardDisplayed());
        loginPage.logout();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    By username = By.xpath("//input[@name=\"username\"]");//
    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    //WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"username\"]")));
    By password = By.xpath("//input[@name=\"password\"]");
    By loginBtn = By.xpath("//button[@type='submit']");

    By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
    By userDropdown = By.className("oxd-userdropdown-name");
    By logoutBtn = By.xpath("//a[text()='Logout']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    public void login(String user, String pass) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"username\"]")));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    public boolean isDashboardDisplayed() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
        return driver.findElement(dashboardHeader).isDisplayed();
    }

    public void logout() {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("oxd-userdropdown-name")));
        driver.findElement(userDropdown).click();
        driver.findElement(logoutBtn).click();
    }
}

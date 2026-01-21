import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

// Video 5a add to basket demo program
// Exercise 1 find how many objects/instances are created for every testcase
public class countInstancesOfTests {
    private WebDriver d = null; // Global WebDriver object
    static int counter;//to count how many instances were created

    static Logger logger = Logger.getLogger(countInstancesOfTests.class);

    public countInstancesOfTests() {
        counter++;
        System.out.println("Counter in constructor: " + counter);
    }

    countInstancesOfTests(WebDriver d) {
        this.d = d;
    }

    @BeforeClass
    public static void beforeClassSetup() {
        //because this dependency is necessary for every test we just load it once
        //as soon as the class is loaded, even before any test runs
        WebDriverManager.chromedriver().setup();//downloads all dependencies for ChromeDriver()
        PropertyConfigurator.configure("log4j.properties");//This
        // needs to be done only once when the class is loaded, so we use @BeforeClass annotation.
        // @BeforeClass works as a static block, gets executed only once.
        logger.info("INFO LOGGER");
        logger.trace("TRACE LOGGER");
        logger.debug("DEBUG LOGGER");
        logger.warn("WARNING LOGGER");
        logger.fatal("FATAL LOGGER");
    }

    @Before
    public void setup() {
        d = new ChromeDriver();
//        System.out.println("Counter is: " + counter);
    }

    @Test
    public void launchBrowser(){
        logger.info("Launching Browser");
        d.get("https://www.BBC.com");}
    @Test
    public void testLaunchSauce() {
        //tell selenium with the help of object of WebDriver to open the link/homepage
        d.get("https://www.saucedemo.com/");
        //we tell selenium to find the element username
        //By is the class, xpath() is a static method
        WebElement uName = d.findElement(By.xpath("//*[@id=\"user-name\"]"));
        uName.sendKeys("standard_user");
        //we tell selenium to find the element password
        WebElement pass = d.findElement(By.xpath(
                "//*[@id=\"password\"]"));////*[@id="password"]
        pass.sendKeys("secret_sauce");
        //we tell selenium to find the element login button and click it
        WebElement loginButton = d.findElement(By.xpath(
                "//*[@id=\"login-button\"]"));
        loginButton.click();
        WebElement prodLabel = d.findElement(By.xpath(
                "//*[@id=\"header_container\"]//div[2]//span"));
        System.out.println(prodLabel.isDisplayed());
        //For that we use Assert class's method, comparing expected output and obtained output.
        Assert.assertTrue(prodLabel.isDisplayed());
    }

    @Test
    public void emptyPassword() {

        //tell selenium with the help of object of WebDriver to open the link/homepage
        d.get("https://www.saucedemo.com/");
        //we tell selenium to find the element username
        //By is the class, xpath() is a static method
        WebElement uName = d.findElement(By.xpath("//*[@id=\"user-name\"]"));
        uName.sendKeys("standard_user");//standard_user provided
        //we tell selenium to find the element password
        WebElement pass = d.findElement(By.xpath(
                "//*[@id=\"password\"]"));////*[@id="password"]
        pass.sendKeys("");//not passing any password
        //we tell selenium to find the element login button and click it
        WebElement loginButton = d.findElement(By.xpath(
                "//*[@id=\"login-button\"]"));
        loginButton.click();
        //there are 8 strategies to locate the element
        // and if we see some certain element in the opened webpage,
        // we can tell that our testcase is passed. For example a tag containing Products
        //here we want to see that box which displays the message "Password is required"
        WebElement uMessage = (WebElement) d.findElement(By.xpath(
                "//*[@id=\"login_button_container\"]//div//form//div[3]//h3"));//*[@id="login_button_container"]/div/form/div[3]/h3/text()
        System.out.println(uMessage.isDisplayed());
        //For that we use Assert class's method, comparing expected output and obtained output.
        Assert.assertTrue(uMessage.isDisplayed() && uMessage.getText().equals("Epic sadface: Password is required"));
    }

    @Test
    public void addRemoveItem() {
        //tell selenium with the help of object of WebDriver to open the link/homepage
        d.get("https://www.saucedemo.com/");
        //we tell selenium to find the element username
        //By is the class, xpath() is a static method
        WebElement uName = d.findElement(By.xpath("//*[@id=\"user-name\"]"));
        uName.sendKeys("standard_user");//standard_user provided
        //we tell selenium to find the element password
        WebElement pass = d.findElement(By.xpath(
                "//*[@id=\"password\"]"));////*[@id="password"]
        pass.sendKeys("secret_sauce");//not passing any password
        //we tell selenium to find the element login button and click it
        WebElement loginButton = d.findElement(By.xpath(
                "//*[@id=\"login-button\"]"));
        loginButton.click();
        d.get("https://www.saucedemo.com/inventory.html");
        // add 4 items in basket, and remove 1
        WebElement addToBasket1 = d.findElement(By.xpath(
                "//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
        addToBasket1.click();
        WebElement addToBasket2 = d.findElement(By.xpath(
                "//*[@id=\"add-to-cart-sauce-labs-bike-light\"]"));
        addToBasket2.click();
        WebElement addToBasket3 = d.findElement(By.xpath(
                "//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]"));
        addToBasket3.click();
        WebElement addToBasket4 = d.findElement(By.xpath(
                "//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]"));
        addToBasket4.click();
        WebElement removeFromBasket5 = d.findElement(By.xpath(
                "//*[@id=\"remove-sauce-labs-backpack\"]"));
        removeFromBasket5.click();
        //now assert basket has 3 items left
        //
        Assert.assertEquals("3", ((WebElement) d.findElement(By.xpath(
                "//*[@id=\"shopping_cart_container\"]/a/span"))).getText());
    }

    @After
    public void cleanUp() {
        logger.info("performing clean up");
        d.quit();
    }
}


//20:00 Video 6 Lombok
//        --------
//        Builder Pattern with @Builder annotation:
//        -----------------------------------
//
//        If any class has 20 member variables, and we want a constructor which only initializes 4 of them, we can't use @AllArgsConstructor annotation for such scenario.
//
//        That's when we use @Builder, it is called Builder Pattern.

@AllArgsConstructor
@Builder
class StudEnt {
    private int rollNo;
    private String name;
    private String address;
    private String ClassTeacher;

    public String toString() {
        return "StudEnt(rollNo=" + this.rollNo + ", name=" + this.name + ", address=" + this.address + ", ClassTeacher=" + this.ClassTeacher + ")";
    }
}
class DemoLombOk{
    public static void main(String[] args) {
//        StudEnt s = new StudEnt();
        StudEnt s = StudEnt.builder().name("Greg").ClassTeacher("Becky").build();
        System.out.println(s);
    }
}
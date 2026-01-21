    import io.github.bonigarcia.wdm.WebDriverManager;
    import org.junit.After;
    import org.junit.Assert;
    import org.junit.Before;
    import org.junit.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;

    public class FirstSauceDemo {
        private WebDriver d = null; // Global WebDriver object

        @Before
        public void setup() {
            WebDriverManager.chromedriver().setup();
            d = new ChromeDriver();
        }
        @Test
        public void testLaunchSauce(){
    //tell selenium with the help of object of WebDriver to open the link/homepage
            d.get("https://www.saucedemo.com/");
    //we tell selenium to find the element username
    //By is the class, xpath() is a static method
            WebElement uName= d.findElement(By.xpath("//*[@id=\"user-name\"]"));
            uName.sendKeys("standard_user");
    //we tell selenium to find the element password
            WebElement pass= d.findElement(By.xpath(
                    "//*[@id=\"password\"]"));////*[@id="password"]
            pass.sendKeys("secret_sauce");
    //we tell selenium to find the element login button and click it
            WebElement loginButton = d.findElement(By.xpath(
                    "//*[@id=\"login-button\"]"));
            loginButton.click();
    //there are 8 strategies to locate the element
    // and if we see some certain element in the opened webpage,
    // we can tell that our testcase is passed. For example a tag containing Products
            WebElement prodLabel = d.findElement(By.xpath(
                    "//*[@id=\"header_container\"]//div[2]//span"));
            System.out.println(prodLabel.isDisplayed());
    //For that we use Assert class's method, comparing expected output and obtained output.
            Assert.assertTrue(prodLabel.isDisplayed());
        }

        @Test
        public void wrongLoginTest(){

    //tell selenium with the help of object of WebDriver to open the link/homepage
            d.get("https://www.saucedemo.com/");
    //we tell selenium to find the element username
    //By is the class, xpath() is a static method
            WebElement uName= d.findElement(By.xpath("//*[@id=\"user-name\"]"));
            uName.sendKeys("random");
    //we tell selenium to find the element password
            WebElement pass= d.findElement(By.xpath(
                    "//*[@id=\"password\"]"));////*[@id="password"]
            pass.sendKeys("random");
    //we tell selenium to find the element login button and click it
            WebElement loginButton = d.findElement(By.xpath(
                    "//*[@id=\"login-button\"]"));
            loginButton.click();
    //there are 8 strategies to locate the element
    // and if we see some certain element in the opened webpage,
    // we can tell that our testcase is passed. For example a tag containing Products
            WebElement prodLabel = d.findElement(By.xpath(
                    "//*[@id=\"login_button_container\"]//div//form//div[3]//h3"));////*[@id="\login_button_container\"]//div//form//div[3]//h3
            System.out.println(prodLabel.isDisplayed());
    //For that we use Assert class's method, comparing expected output and obtained output.
            Assert.assertTrue(prodLabel.isDisplayed());
        }

        @Test
        public void urlChangeTest(){

            //tell selenium with the help of object of WebDriver to open the link/homepage
            d.get("https://www.saucedemo.com/");
            //Get current url
            String url1 = d.getCurrentUrl();
            //we tell selenium to find the element username
            //By is the class, xpath() is a static method
            WebElement uName= d.findElement(By.xpath("//*[@id=\"user-name\"]"));
            uName.sendKeys("standard_user");
            //we tell selenium to find the element password
            WebElement pass= d.findElement(By.xpath(
                    "//*[@id=\"password\"]"));////*[@id="password"]
            pass.sendKeys("secret_sauce");
            //we tell selenium to find the element login button and click it
            WebElement loginButton = d.findElement(By.xpath(
                    "//*[@id=\"login-button\"]"));
            loginButton.click();
            //there are 8 strategies to locate the element
            //let's get URL after logging in, if it is different consider this test passed
            String url2 = d.getCurrentUrl();
            //For that we use Assert class's method, comparing expected output and obtained output.
            //If both URL are not same, then we consider test passed
            Assert.assertNotEquals(url1, url2);

        }

        @Test
        public void emptyDetailsForlogin(){

            //tell selenium with the help of object of WebDriver to open the link/homepage
            d.get("https://www.saucedemo.com/");
            //we tell selenium to find the element username
            //By is the class, xpath() is a static method
            WebElement uName= d.findElement(By.xpath("//*[@id=\"user-name\"]"));
            uName.sendKeys("");//not passing any username
            //we tell selenium to find the element password
            WebElement pass= d.findElement(By.xpath(
                    "//*[@id=\"password\"]"));////*[@id="password"]
            pass.sendKeys("");//not passing any password
            //we tell selenium to find the element login button and click it
            WebElement loginButton = d.findElement(By.xpath(
                    "//*[@id=\"login-button\"]"));
            loginButton.click();
            //there are 8 strategies to locate the element
            // and if we see some certain element in the opened webpage,
            // we can tell that our testcase is passed. For example a tag containing Products
            //here we want to see that box which displays the message "username is required"
            WebElement uMessage = (WebElement) d.findElement(By.xpath(
                    "//*[@id=\"login_button_container\"]//div//form//div[3]//h3"));//*[@id="login_button_container"]/div/form/div[3]/h3/text()
            System.out.println(uMessage.isDisplayed());
            //For that we use Assert class's method, comparing expected output and obtained output.
            Assert.assertTrue(uMessage.isDisplayed() && uMessage.getText().equals("Epic sadface: Username is required"));

        }

        @Test
        public void emptyPassword(){

            //tell selenium with the help of object of WebDriver to open the link/homepage
            d.get("https://www.saucedemo.com/");
            //we tell selenium to find the element username
            //By is the class, xpath() is a static method
            WebElement uName= d.findElement(By.xpath("//*[@id=\"user-name\"]"));
            uName.sendKeys("standard_user");//standard_user provided
            //we tell selenium to find the element password
            WebElement pass= d.findElement(By.xpath(
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

        @After
        public void cleanUp() {
            d.quit(); // Close the browser after every test case
        }

    }
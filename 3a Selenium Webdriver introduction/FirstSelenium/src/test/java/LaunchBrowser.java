import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LaunchBrowser {
    public static void main(String[] args) throws IOException {
        WebDriver d = new FirefoxDriver();//store class object in interface type ref
        d.get("https://www.bbc.com");//get will open the website in chrome
        if(d.getTitle().startsWith("BBC")){
            System.out.println("Firefox Test passed");
        }else{
            System.out.println("Firefox test failed");
        }
        Properties p = new Properties();
        File f = new File("selenium.properties");
        FileInputStream f1 = new FileInputStream(f);
        p.load(f1);
        System.out.println(p.get("firefox.driver.path"));
    }
}

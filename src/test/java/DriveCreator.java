import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriveCreator {

    public WebDriver openBrowser(String browser) {

        WebDriver driver;

        if (browser.equals("edge")) {
            System.setProperty("webdriver.edge.driver", "C:/Selenium/msedgedriver.exe");
            driver = new EdgeDriver();
            driver.get("https://login.mailchimp.com/signup/");
        } else if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://login.mailchimp.com/signup/");
        } else {
            System.setProperty("webdriver.gecko.driver", "C:/Selenium/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.get("https://login.mailchimp.com/signup/");
        }

        return driver;
    }

}
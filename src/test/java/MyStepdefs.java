import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static org.junit.Assert.assertEquals;


public class MyStepdefs {

    public String aEmail, aUsername, aPassword;
    private WebDriver driver;

    @Given("I have started {string} browser")
    public void iHaveStartedBrowser(String browser) {
        DriveCreator creator = new DriveCreator();
        driver = creator.openBrowser(browser);
    }

    @Given("I have written an email {string}")
    public void iHaveWrittenAnEmail(String email) {
        aEmail = email;

        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
        Date dateTime = new Date();

        if (email.equals("mail")) {
            sendKeys(driver, By.id("email"), formatter.format(dateTime) + "@maila.nu");
        } else
            sendKeys(driver, By.id("email"), email);
    }

    @Given("I have written a username {string}")
    public void iHaveWrittenAUsername(String user) {
        aUsername = user;

        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
        Date dateTime = new Date();

        if (user.equals("longUsername")) {
            for (int i = 0; i < 10; i++)
                sendKeys(driver, By.id("new_username"), user);
        } else if (user.equals("ViktorsAccount")) {
            sendKeys(driver, By.id("new_username"), user);
        } else
            sendKeys(driver, By.id("new_username"), formatter.format(dateTime));
    }

    @Given("I have written a password {string}")
    public void iHaveWrittenAPassword(String password) {
        aPassword = password;
        sendKeys(driver, By.id("new_password"), password);
    }

    @Given("I check the box")
    public void iCheckTheBox() {
        click(driver, By.cssSelector("#marketing_newsletter"));
    }

    @When("I click the Sign Up button")
    public void iClickTheSignUpButton() {
        scroll(driver);
        click(driver, By.id("create-account"));
    }

    @Then("my account registers success with {string}")
    public void myAccountRegistersStatusWith(String result) {
        WebElement account = driver.findElement(By.xpath("//*[@id=\"signup-content\"]/div/div/div/h1"));
        account.getText();

        assertEquals(result, account.getText());

        driver.quit();
    }

    @Then("my account registers fail with {string}")
    public void myAccountRegistersStatusWith2(String result) {
        WebElement account2 = driver.findElement(By.className("invalid-error"));
        account2.getText();

        assertEquals(result, account2.getText());

        driver.quit();
    }

    private static void sendKeys(WebDriver driver, By by, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));

        element.sendKeys(text);
    }

    private static void click(WebDriver driver, By by) {
        WebDriverWait foobar = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = foobar.until(ExpectedConditions.elementToBeClickable(by));

        element.click();
    }

    private static void scroll(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
    }


}
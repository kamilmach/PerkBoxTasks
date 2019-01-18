import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import  org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.testng.Assert.*;

public class PerkBoxTests {




    @Test
    public void LogInToApp() {
        System.setProperty("webdriver.gecko.driver","geckodriver.exe");
        FirefoxDriver driver=new FirefoxDriver();
        driver.get("https://app.perkbox.com");
        WebElement emailField =  driver.findElement(By.xpath("//input[@name='email']"));
        WebElement continueButton =  driver.findElement(By.xpath("//button[contains(.,'Continue')]"));
        emailField.sendKeys("pooja@perkbox.co.uk");
        continueButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@name='themistrypenguin']")));
        assertTrue(driver.findElement(By.xpath("//div[@name='themistrypenguin']")).isEnabled());
        driver.close();
    }


    @Test
    public void EnterInvalidEmail() {
        System.setProperty("webdriver.gecko.driver","geckodriver.exe");
        FirefoxDriver driver=new FirefoxDriver();
        driver.get("https://app.perkbox.com");
        WebElement emailField =  driver.findElement(By.xpath("//input[@name='email']"));
        WebElement continueButton =  driver.findElement(By.xpath("//button[contains(.,'Continue')]"));
        emailField.sendKeys("pooja");
        continueButton.click();
        assertTrue(driver.findElement(By.xpath("(//div[contains(.,'This email address is not valid')])[19]")).isDisplayed());
        driver.close();
    }
}
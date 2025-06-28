package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Properties;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Properties config;

    public LoginPage(WebDriver driver, WebDriverWait wait, Properties config) {
        this.driver = driver;
        this.wait = wait;
        this.config = config;
    }

    public void loginToAdminPanel() {
        driver.get(config.getProperty("baseUrl"));

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p[@class='homepage-login-button-text']")));
        loginButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")))
                .sendKeys(config.getProperty("userName"));
        driver.findElement(By.id("password")).sendKeys(config.getProperty("passWord"));
        driver.findElement(By.id("kc-login")).click();
        WebElement dashboardButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[1]/div/div/div")));
        dashboardButton.click();
        System.out.println(dashboardButton);
    }
}

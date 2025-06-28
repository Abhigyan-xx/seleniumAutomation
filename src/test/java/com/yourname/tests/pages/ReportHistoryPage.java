package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ReportHistoryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ReportHistoryPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickReportHistoryTab() {
        WebElement reportHistory = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//h2[text()='Report History']")));
        reportHistory.click();
    }

    public boolean isReportTableVisible() {
        WebElement reportTable = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table//tr[contains(@class, 'MuiTableRow-root')]")));
        return reportTable.isDisplayed();
    }

    public void searchByPAN(String pan) {
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@placeholder='Search By User name, Contact number or PAN number.']")));
        searchBox.click();
        searchBox.sendKeys(pan);
        WebElement searchIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div[2]/div[1]/button")));
        searchIcon.click();
    }
}

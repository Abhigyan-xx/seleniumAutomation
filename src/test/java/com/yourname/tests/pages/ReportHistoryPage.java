package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.*;

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
        searchBox.clear();
        searchBox.sendKeys(pan);

        WebElement searchIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(@class, 'MuiIconButton-root')]")));
        searchIcon.click();
    }

    public void printSearchedPanTableData() {
        WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='MuiTableContainer-root css-1exj0wg']"))); // Update this XPath based on actual HTML

        List<WebElement> rows = table.findElements(By.xpath(".//table/tbody/tr"));

        System.out.println("======= Searched PAN Table Data =======");

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                System.out.print(cell.getText() + " | ");
            }
            System.out.println();
        }
    }

}

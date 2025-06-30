package com.yourname.tests.stepdefs;

import com.yourname.tests.base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.ReportHistoryPage;

import java.io.FileInputStream;
import java.util.Properties;

public class ReportHistorySteps extends BaseTest {
    LoginPage loginPage;
    ReportHistoryPage reportHistoryPage;
    Properties config = new Properties();

    @Before
    public void init() throws Exception {
        setup();
        FileInputStream fis = new FileInputStream("src/test/resources/features/config.properties");
        config.load(fis);
        loginPage = new LoginPage(driver, wait, config);
        reportHistoryPage = new ReportHistoryPage(driver, wait);
    }

    @After
    public void cleanup() {
        teardown();
    }

    @Given("I open the CorpVue Admin Panel in a browser")
    public void i_open_admin_panel() {
    }

    @And("I log in using valid admin credentials {string} and {string}")
    public void i_login_with_credentials(String username, String password) {
        loginPage.loginToAdminPanel();
    }

    @When("I navigate to the {string} tab")
    public void i_navigate_to_report_history(String tabName) {
        reportHistoryPage.clickReportHistoryTab();
    }

    @Then("I should see the list of all GST reports generated for all users")
    public void i_should_see_gst_report_list() {
        assert reportHistoryPage.isReportTableVisible();
    }

    @Then("I search using the PAN {string}")
    public void i_search_using_pan(String pan) {
        reportHistoryPage.searchByPAN(pan);
    }
    @Then("I print the searched pan table to verify the search box functionality")
    public void print_table(){
        reportHistoryPage.printSearchedPanTableData();
    }
}

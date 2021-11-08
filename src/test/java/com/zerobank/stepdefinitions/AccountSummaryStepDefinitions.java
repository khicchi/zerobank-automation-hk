package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.MasterPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class AccountSummaryStepDefinitions {

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        Driver.get().get(ConfigurationReader.get("url"));
        new LoginPage().loginAsUser();
        Driver.get().findElement(By.id("details-button")).click();
        Driver.get().findElement(By.id("proceed-link")).click();
    }

    @When("user navigates to the {string} page")
    public void user_navigates_to_the_page(String pageName) {
        new MasterPage().navigateToTabAndModule(pageName);
    }

    @Then("page should have to following account types")
    public void page_should_have_to_following_account_types(List<String> accountTypeNames) {
        var aa = new AccountSummaryPage().accountTypeHeaders;
        Assert.assertEquals(BrowserUtils.getElementsText(new AccountSummaryPage().accountTypeHeaders), accountTypeNames);
    }


    @Then("Credit Accounts table must have these columns")
    public void creditAccountsTableMustHaveTheseColumns(List<String> creditAccountHeaders) {
        Assert.assertEquals(BrowserUtils.getElementsText(new AccountSummaryPage().creditAccountsTableHeaders), creditAccountHeaders);
    }

    @Then("page should have the title {string}")
    public void pageShouldHaveTheTitle(String title) {
        Assert.assertEquals(title, Driver.get().getTitle());
    }


}

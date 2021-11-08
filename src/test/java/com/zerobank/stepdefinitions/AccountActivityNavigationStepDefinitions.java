package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountActivityNavigationStepDefinitions {

    private AccountSummaryPage accountSummaryPage;

    @When("the user is on the page")
    public void theUserIsOnThePage() {
        accountSummaryPage = new AccountSummaryPage();
    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String linkName) {
        accountSummaryPage.getLinkByText(linkName).click();
        BrowserUtils.waitFor(2);
    }

    @Then("{string} page should be displayed")
    public void page_should_be_displayed(String pageName) {
        Assert.assertEquals("Zero - " + pageName, Driver.get().getTitle());
    }
}

package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountActivityStepDefinitions {

    @Then("Account dropdown's default option should be {string}")
    public void accountDropdownSDefaultOptionShouldBe(String selectedDropDownOption) {
        Assert.assertEquals(selectedDropDownOption, new AccountActivityPage().getSelectedOptionOfAccountDropDown());
    }

    @Then("Account dropdown should have the following options")
    public void accountDropdownShouldHaveTheFollowingOptions(List<String> dropDownOptions) {
        Assert.assertEquals(dropDownOptions, BrowserUtils.getElementsText(new AccountActivityPage().getAccountDropDownOptions()));
    }


    @Then("Transactions table should have column names")
    public void transactionsTableShouldHaveColumnNames(List<String> columnNames) {
        Assert.assertEquals(columnNames, BrowserUtils.getElementsText(new AccountActivityPage().transactionTableColumns));
    }

}

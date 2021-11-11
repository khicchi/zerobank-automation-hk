package com.zerobank.stepdefinitions;

import com.zerobank.enums.EComparisonClause;
import com.zerobank.enums.ETransactionTableColumnName;
import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class AccountActivityStepDefinitions {

    private AccountActivityPage accountActivityPage;

    @Given("Account Actitivty page is initialized")
    public void account_Actitivty_page_is_initialized() {
        accountActivityPage = new AccountActivityPage();
    }

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

    @Given("the user accesses the {string} tab")
    public void the_user_accesses_the_tab(String tabName) {
        accountActivityPage.openTab(tabName);
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String dateFrom, String dateTo) {
        accountActivityPage.getFindTransactionsTab().dateFrom.clear();
        accountActivityPage.getFindTransactionsTab().dateTo.clear();
        accountActivityPage.getFindTransactionsTab().dateFrom.sendKeys(dateFrom);
        accountActivityPage.getFindTransactionsTab().dateTo.sendKeys(dateTo);
        BrowserUtils.waitFor(2);
    }
    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String dateIntervalStart, String dateIntervalTo) {
        BrowserUtils.waitFor(2);
        LocalDate dateFrom = LocalDate.parse(dateIntervalStart);
        LocalDate dateTo = LocalDate.parse(dateIntervalTo);

        List<LocalDate> datesFromTable = accountActivityPage.getFindTransactionsTab().getDatesFromTable();
        for(LocalDate dateFromTable:datesFromTable){
            Assert.assertTrue(dateFromTable.compareTo(dateFrom) >= 0 && dateTo.compareTo(dateFromTable) >= 0);
        }
    }
    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        List<LocalDate> datesFromTable = accountActivityPage.getFindTransactionsTab().getDatesFromTable();
        Iterator<LocalDate> datesIterator = datesFromTable.iterator();

        LocalDate currentDate = datesIterator.next();
        while (datesIterator.hasNext()){
            if(currentDate.compareTo(datesIterator.next()) < 0){
                Assert.fail("Date is not descending order");
                break;
            }
        }

    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String excludedDate) {
        Assert.assertFalse(BrowserUtils.getElementsText(accountActivityPage.getFindTransactionsTab().valuesDateFromTable).contains(excludedDate));
    }

    @And("clicks search")
    public void clicksSearch() {
        accountActivityPage.getFindTransactionsTab().btnFind.click();
    }


    @When("the user enters description {string}")
    public void theUserEntersDescription(String description) {
        accountActivityPage.getFindTransactionsTab().txtDescription.clear();
        accountActivityPage.getFindTransactionsTab().txtDescription.sendKeys(description);
    }

    @Then("results table should only show descriptions containing {string}")
    public void resultsTableShouldOnlyShowDescriptionsContaining(String description) {
        BrowserUtils.waitFor(2);

        try{
            String dum = accountActivityPage.getFindTransactionsTab().lblNoResultsMessage.getText();
            Assert.fail();
            BrowserUtils.waitFor(1);
        }catch (NoSuchElementException e){
            for (WebElement descriptionElementFromTable :
                    accountActivityPage.getFindTransactionsTab().valuesDescriptionFromTable) {
                Assert.assertTrue(descriptionElementFromTable.getText().contains(description));
            }
        }
    }

    @But("results table should not show descriptions containing {string}")
    public void resultsTableShouldNotShowDescriptionsContaining(String description) {
        for (WebElement descriptionElementFromTable :
                accountActivityPage.getFindTransactionsTab().valuesDescriptionFromTable) {
            Assert.assertTrue(!descriptionElementFromTable.getText().contains(description));
        }
    }

    @Then("results table should show {string} {int} result under {string}")
    public void resultsTableShouldShowResultUnder(String comparisonClause, int resultCount, String columnName) {
       BrowserUtils.waitFor(2);

        List<WebElement> valuesByColumn = accountActivityPage.getFindTransactionsTab().
                getValuesByColumnName(Arrays.stream(ETransactionTableColumnName.values()).filter(e -> e.getColumnName().equals(columnName)).findFirst().get());

        long validResultCountFromTable = valuesByColumn.stream().filter(e -> e.getText() != null &&
                !e.getText().isEmpty()).count();

        if (EComparisonClause.clause_exactly.getClause().equals(comparisonClause))
            Assert.assertEquals(resultCount, validResultCountFromTable);
        else if (EComparisonClause.clause_atLeast.getClause().equals(comparisonClause))
            Assert.assertTrue(validResultCountFromTable >= resultCount);

    }

    @When("user selects type {string}")
    public void userSelectsType(String type) {
        new Select(accountActivityPage.getFindTransactionsTab().ddlType).selectByVisibleText(type);
    }
}

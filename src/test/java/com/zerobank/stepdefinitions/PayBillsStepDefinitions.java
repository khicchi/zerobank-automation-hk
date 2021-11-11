package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class PayBillsStepDefinitions {

    PayBillsPage payBillsPage;

    @And("the user on the page")
    public void theUserOnThePage() {
        payBillsPage = new PayBillsPage();
    }

    @And("the user enters amount")
    public void the_user_enters_amount() {
        payBillsPage.getModulePaySavedPayee().txtAmount.sendKeys("20");
    }

    @And("the user enters date")
    public void the_user_enters_date() {
        payBillsPage.getModulePaySavedPayee().txtDate.sendKeys("2021-11-15");
    }

    @And("the user enters description")
    public void theUserEntersDescription() {
        payBillsPage.getModulePaySavedPayee().txtDescription.sendKeys("description");
    }

    @When("the user clicks Pay button")
    public void the_user_clicks_Pay_button() {
        payBillsPage.getModulePaySavedPayee().btnPay.click();
    }

    @Then("{string} message should be displayed.")
    public void message_should_be_displayed(String message) {
        Assert.assertTrue(payBillsPage.getModulePaySavedPayee().messageSpan.isDisplayed());
        Assert.assertEquals(message, payBillsPage.getModulePaySavedPayee().messageSpan.getText());
    }

    @Then("{string} warning message should be displayed for {string}.")
    public void warningMessageShouldBeDisplayedFor(String message, String control) {
        WebElement webElementToCheckMessage = null;
        if (control.equals("amount"))
            webElementToCheckMessage = payBillsPage.getModulePaySavedPayee().txtAmount;
        else if (control.equals("date"))
            webElementToCheckMessage = payBillsPage.getModulePaySavedPayee().txtDate;

        String validationMessage = webElementToCheckMessage.getAttribute("validationMessage");
        boolean required = Boolean.parseBoolean(webElementToCheckMessage.getAttribute("required"));
        Assert.assertEquals(message, validationMessage);
        Assert.assertTrue(required);
    }

    @When("the user enters {string} as amount")
    public void the_user_enters_as_amount(String amount) {
        payBillsPage.getModulePaySavedPayee().txtAmount.sendKeys(amount);
    }

    @Then("Amount field should not accept non-numeric characters")
    public void amount_field_should_not_accept_non_numeric_characters() {
        Assert.assertFalse(payBillsPage.getModulePaySavedPayee().messageSpan.isDisplayed());
        Assert.assertNotEquals("The payment was successfully submitted.", payBillsPage.getModulePaySavedPayee().messageSpan.getText());
    }


    @And("the user leaves description blank")
    public void theUserLeavesDescriptionBlank() {

    }


    @And("the user enters {string} as date")
    public void theUserEntersAsDate(String date) {
        payBillsPage.getModulePaySavedPayee().txtDate.sendKeys(date);
    }

    @Then("Date field should not accept alphabetical characters")
    public void dateFieldShouldNotAcceptAlphabeticalCharacters() {
        Assert.assertTrue(payBillsPage.getModulePaySavedPayee().txtDate.getText().isEmpty());
        Assert.assertTrue(payBillsPage.getModulePaySavedPayee().txtDate.getText().isBlank());
    }

    @Given("User navigates to {string} tab")
    public void userNavigatesToTab(String tabName) {
        payBillsPage.openTab(tabName);
    }

    @And("creates new payee using following information")
    public void createsNewPayeeUsingFollowingInformation(Map<String, String> payeeInfo) {
        payBillsPage.getModuleAddNewPayee().txtPayeeName.sendKeys(payeeInfo.get("Payee Name"));
        payBillsPage.getModuleAddNewPayee().txtPayeeAddress.sendKeys(payeeInfo.get("Payee Address"));
        payBillsPage.getModuleAddNewPayee().txtAccount.sendKeys(payeeInfo.get("Account"));
        payBillsPage.getModuleAddNewPayee().txtPayeeDetails.sendKeys(payeeInfo.get("Payee Details"));
        payBillsPage.getModuleAddNewPayee().btnAdd.click();
    }

    @Then("{string} message should be displayed")
    public void messageShouldBeDisplayed(String message) {
        Assert.assertTrue(payBillsPage.getModuleAddNewPayee().lblMessage.isDisplayed());
        Assert.assertTrue(payBillsPage.getModuleAddNewPayee().lblMessage.getText().equals(message));
    }

    @Then("following currencies should be available")
    public void followingCurrenciesShouldBeAvailable(List<String> currencyList) {
        Assert.assertEquals(currencyList, payBillsPage.getForeignCurrency().getCurrencySelectValues().subList(1, payBillsPage.getForeignCurrency().getCurrencySelectValues().size() - 1));
    }

    @Then("error message should be displayed")
    public void errorMessageShouldBeDisplayed() {
        Assert.assertTrue(Driver.get().switchTo().alert() != null);
    }

    @When("user tries to calculate cost without selecting a currency")
    public void userTriesToCalculateCostWithoutSelectingACurrency() {
        payBillsPage.getForeignCurrency().txtAmount.clear();
        payBillsPage.getForeignCurrency().txtAmount.sendKeys("20");
        payBillsPage.getForeignCurrency().btnCalculateCosts.click();
    }

    @When("user tries to calculate cost without entering a value")
    public void userTriesToCalculateCostWithoutEnteringAValue() {
        payBillsPage.getForeignCurrency().txtAmount.clear();
        payBillsPage.getForeignCurrency().getDDLCurrencySelect().selectByIndex(3);
        payBillsPage.getForeignCurrency().btnCalculateCosts.click();
    }
}

package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

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
        Assert.assertTrue(payBillsPage.messageSpan.isDisplayed());
        Assert.assertEquals(message, payBillsPage.messageSpan.getText());
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
        Assert.assertFalse(payBillsPage.messageSpan.isDisplayed());
        Assert.assertNotEquals("The payment was successfully submitted.", payBillsPage.messageSpan.getText());
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
}

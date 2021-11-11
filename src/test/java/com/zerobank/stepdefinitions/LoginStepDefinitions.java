package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginStepDefinitions {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user enters {string} as username and {string} as password")
    public void the_user_enters_as_username_and_as_password(String userName, String password) {
        new LoginPage().login(userName, password);
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        Driver.get().findElement(By.id("details-button")).click();
        Driver.get().findElement(By.id("proceed-link")).click();

        Assert.assertEquals("Zero - Account Summary", Driver.get().getTitle());
    }


}

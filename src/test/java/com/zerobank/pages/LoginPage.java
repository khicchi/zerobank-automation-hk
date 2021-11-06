package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "user_login")
    private WebElement txtUserName;

    @FindBy(id = "user_password")
    private WebElement txtPassword;

    @FindBy(css = ".btn.btn-primary")
    private WebElement btnLogin;

    public void login(String userName, String password){
        txtUserName.sendKeys(userName);
        txtPassword.sendKeys(password);
        btnLogin.click();
    }

    public void loginAsUser(){
        login(ConfigurationReader.get("username"), ConfigurationReader.get("password"));
    }

}

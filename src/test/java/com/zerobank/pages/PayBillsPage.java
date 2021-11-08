package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayBillsPage {

    public PayBillsPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    public PaySavedPayee getModulePaySavedPayee(){
        return new PaySavedPayee();
    }

    @FindBy(css = "#alert_content span")
    public WebElement messageSpan;

    public class PaySavedPayee extends PayBillsPage {
        @FindBy(id = "sp_amount")
        public WebElement txtAmount;

        @FindBy(id = "sp_date")
        public WebElement txtDate;

        @FindBy(id = "sp_description")
        public WebElement txtDescription;

        @FindBy(id = "pay_saved_payees")
        public WebElement btnPay;



    }
}

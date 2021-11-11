package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PayBillsPage {

    public PayBillsPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    public PaySavedPayee getModulePaySavedPayee(){
        return new PaySavedPayee();
    }

    public AddNewPayee getModuleAddNewPayee(){return new AddNewPayee();}

    public ForeignCurrency getForeignCurrency(){return new ForeignCurrency();}

    public void openTab(String tabName){
        Driver.get().findElement(By.linkText(tabName)).click();
    }

    public class PaySavedPayee extends PayBillsPage {
        @FindBy(id = "sp_amount")
        public WebElement txtAmount;

        @FindBy(id = "sp_date")
        public WebElement txtDate;

        @FindBy(id = "sp_description")
        public WebElement txtDescription;

        @FindBy(id = "pay_saved_payees")
        public WebElement btnPay;

        @FindBy(css = "#alert_content span")
        public WebElement messageSpan;
    }

    public class AddNewPayee extends PayBillsPage{
        @FindBy(id = "np_new_payee_name")
        public WebElement txtPayeeName;

        @FindBy(id = "np_new_payee_address")
        public WebElement txtPayeeAddress;

        @FindBy(id = "np_new_payee_account")
        public WebElement txtAccount;

        @FindBy(id = "np_new_payee_details")
        public WebElement txtPayeeDetails;

        @FindBy(id = "add_new_payee")
        public WebElement btnAdd;

        @FindBy(id = "alert_content")
        public WebElement lblMessage;
    }

    public class ForeignCurrency extends PayBillsPage{
        @FindBy(id = "pc_currency")
        public WebElement ddlCurrency;

        @FindBy(id = "pc_amount")
        public WebElement txtAmount;

        @FindBy(id = "pc_calculate_costs")
        public WebElement btnCalculateCosts;

        @FindBy(id = "purchase_cash")
        public WebElement btnPurchaseCash;

        public Select getDDLCurrencySelect(){return new Select(ddlCurrency);}

        public List<String> getCurrencySelectValues(){
            return BrowserUtils.getElementsText(getDDLCurrencySelect().getOptions());
        }
    }
}

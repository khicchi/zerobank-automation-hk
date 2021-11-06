package com.zerobank.pages;

import com.zerobank.enums.ETab;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MasterPage {

    public MasterPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "account_summary_tab")
    private WebElement tab_accountSummary;

    @FindBy(id = "account_activity_tab")
    private WebElement tab_accountActivity;

    @FindBy(id = "transfer_funds_tab")
    private WebElement tab_transferFunds;

    @FindBy(id = "pay_bills_tab")
    private WebElement tab_payBills;

    @FindBy(id = "money_map_tab")
    private WebElement tab_moneyMap;

    @FindBy(id = "online_statements_tab")
    private WebElement tab_onlineStatements;

    public void navigateToTabAndModule(String pageName){
        if (pageName.equals(ETab.tab_accountSummary.getName()))
            tab_accountSummary.click();
        else if (pageName.equals(ETab.tab_accountActivity.getName()))
            tab_accountActivity.click();
        else if (pageName.equals(ETab.tab_transferFunds.getName()))
            tab_transferFunds.click();
        else if (pageName.equals(ETab.tab_payBills.getName()))
            tab_payBills.click();
        else if (pageName.equals(ETab.tab_moneyMap.getName()))
            tab_moneyMap.click();
        else if (pageName.equals(ETab.tab_onlineStatements.getName()))
            tab_onlineStatements.click();
    }
}

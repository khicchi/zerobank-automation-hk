package com.zerobank.pages;

import com.zerobank.enums.ETransactionTableColumnName;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountActivityPage {

    private final String accountDropDownID = "aa_accountId";

    public AccountActivityPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    public FindTransactions getFindTransactionsTab(){return new FindTransactions();}

    @FindBy(id = accountDropDownID)
    public WebElement accountDropDown;

    @FindBy(css = ".table.table-condensed.table-hover th")
    public List<WebElement> transactionTableColumns;

    @FindBy(linkText = "Show Transactions")
    public WebElement tabShowTransactions;

    @FindBy(linkText = "Find Transactions")
    public WebElement tabFindTransactions;

    private Select getAccountDropDownSelect(){
        return new Select(Driver.get().findElement(By.id(accountDropDownID)));
    }

    public String getSelectedOptionOfAccountDropDown(){
        return getAccountDropDownSelect().getFirstSelectedOption().getText();
    }

    public List<WebElement> getAccountDropDownOptions(){
        return getAccountDropDownSelect().getOptions();
    }

    public void openTab(String tabName){
        Driver.get().findElement(By.linkText(tabName)).click();
    }

    public class FindTransactions extends AccountActivityPage{
        @FindBy(id = "aa_fromDate")
        public WebElement dateFrom;

        @FindBy(id = "aa_toDate")
        public WebElement dateTo;

        @FindBy(xpath = "//button[text()='Find']")
        public WebElement btnFind;

        @FindBy(id = "aa_description")
        public WebElement txtDescription;

        @FindBy(xpath = "//div[@id='filtered_transactions_for_account']/table/tbody//tr//td[1]")
        public List<WebElement> valuesDateFromTable;

        @FindBy(xpath = "//div[@id='filtered_transactions_for_account']/table/tbody//tr//td[2]")
        public List<WebElement> valuesDescriptionFromTable;

        @FindBy(xpath = "//div[@id='filtered_transactions_for_account']/table/tbody//tr//td[3]")
        public List<WebElement> valuesDepositFromTable;

        @FindBy(xpath = "//div[@id='filtered_transactions_for_account']/table/tbody//tr//td[4]")
        public List<WebElement> valuesWithdrawalFromTable;

        @FindBy(css = ".well")
        public WebElement lblNoResultsMessage;

        @FindBy(id = "aa_type")
        public WebElement ddlType;

        public List<WebElement> getValuesByColumnName(ETransactionTableColumnName columnName){
            if (columnName == ETransactionTableColumnName.column_date)
                return valuesDateFromTable;
            else if (columnName == ETransactionTableColumnName.column_deposit)
                return valuesDepositFromTable;
            else if (columnName == ETransactionTableColumnName.column_description)
                return valuesDescriptionFromTable;
            else if (columnName == ETransactionTableColumnName.column_withdrawal)
                return valuesWithdrawalFromTable;
            else
                return null;
        }

        public List<LocalDate> getDatesFromTable(){
            List<LocalDate> localDates = new ArrayList<>();
            valuesDateFromTable.forEach(d -> localDates.add(LocalDate.parse(d.getText())));
            return localDates;
        }


    }
}

package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage {

    private final String accountDropDownID = "aa_accountId";

    public AccountActivityPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = accountDropDownID)
    public WebElement accountDropDown;

    @FindBy(css = ".table.table-condensed.table-hover th")
    public List<WebElement> transactionTableColumns;

    private Select getAccountDropDownSelect(){
        return new Select(Driver.get().findElement(By.id(accountDropDownID)));
    }

    public String getSelectedOptionOfAccountDropDown(){
        return getAccountDropDownSelect().getFirstSelectedOption().getText();
    }

    public List<WebElement> getAccountDropDownOptions(){
        return getAccountDropDownSelect().getOptions();
    }
}

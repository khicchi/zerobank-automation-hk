package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSummaryPage {
    public AccountSummaryPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = ".board-header")
    public List<WebElement> accountTypeHeaders;

    @FindBy(xpath = "//h2[.='Credit Accounts']/following-sibling::div[1]//table//th")
    public List<WebElement> creditAccountsTableHeaders;

    @FindBy(linkText = "Savings")
    public WebElement linkSavings;

    @FindBy(css = "a[style='text-decoration: underline']")
    public List<WebElement> links;

    public WebElement getLinkByText(String linkText){
        return links.stream().filter(e -> e.getText().equals(linkText)).findFirst().get();
    }
}

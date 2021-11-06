package com.zerobank.enums;

public enum ETab {

    tab_accountSummary("Account Summary", null),
    tab_accountActivity("Account Activity", new ESubTab[]{ESubTab.tab_showTransactions, ESubTab.tab_findTransactions}),
    tab_transferFunds("Transfer Funds", null),
    tab_payBills("Pay Bills", new ESubTab[]{ESubTab.tab_paySavedPayee, ESubTab.tab_addNewPayee, ESubTab.tab_purchaseForeignCurrency}),
    tab_moneyMap("My Money Map", null),
    tab_onlineStatements("Online Statements", null);

    private String name;
    private ESubTab[] subTab;

    ETab(String name, ESubTab[] subTab) {
        this.name = name;
        this.subTab = subTab;
    }

    public String getName() {
        return name;
    }

    public ESubTab[] getSubTab() {
        return subTab;
    }

    public String getTitle(){
        return "Zero - " + name;
    }
}

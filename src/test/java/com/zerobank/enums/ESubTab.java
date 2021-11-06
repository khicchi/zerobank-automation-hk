package com.zerobank.enums;

public enum ESubTab {

    tab_showTransactions("Show Transactions"),
    tab_findTransactions("Find Transactions"),
    tab_paySavedPayee("Pay Saved Payee"),
    tab_addNewPayee("Add New Payee"),
    tab_purchaseForeignCurrency("Purchase Foreign Currency");


    private String name;
    ESubTab(String name){
        this.name = name;
    }

}

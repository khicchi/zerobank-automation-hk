package com.zerobank.enums;

public enum ETransactionTableColumnName {

    column_date("Date"),
    column_description("Description"),
    column_deposit("Deposit"),
    column_withdrawal("Withdrawal");

    private String columnName;
    ETransactionTableColumnName(String columnName){
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }
}

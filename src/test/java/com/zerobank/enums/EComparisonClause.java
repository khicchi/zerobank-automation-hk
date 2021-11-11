package com.zerobank.enums;

public enum EComparisonClause {
    clause_exactly("exactly"),
    clause_atLeast("at least");

    private String clause;
    EComparisonClause(String clause){
        this.clause = clause;
    }

    public String getClause() {
        return clause;
    }
}

package com.salesmanager.models;

import java.io.Serializable;

public class Customer implements Serializable {

    String Operator;
    String CNPJ;
    String Name;
    String BusinessArea;

    public String getOperator() {
        return Operator;
    }

    public void setOperator(String operator) {
        Operator = operator;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBusinessArea() {
        return BusinessArea;
    }

    public void setBusinessArea(String businessArea) {
        BusinessArea = businessArea;
    }
}

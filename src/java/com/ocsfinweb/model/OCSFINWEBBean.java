/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ocsfinweb.model;

/**
 *
 * @author MAXWELLPAYNE
 */
public class OCSFINWEBBean {
    
    private String invoiceId,expenseType,currency,description,tranDate,xmlData;
    private float currAmt,usdAmt;
    
    public String getInvoiceNo(){return invoiceId;}
    public void setInvoiceNo(String invoiceId){this.invoiceId=invoiceId;}
    
    public String getExpenseType(){return expenseType;}
    public void setExpenseType(String expenseType){this.expenseType=expenseType;}
    
    public String getCurrency(){return currency;}
    public void setCurrency(String currency){this.currency=currency;}
    
    public String getDescription(){return description;}
    public void setDescription(String description){this.description=description;}
    
    public String getTranDate(){return tranDate;}
    public void setTranDate(String tranDate){this.tranDate=tranDate;}
    
    public String getXmlData(){return xmlData;}
    public void setXmlData(String xmlData){this.xmlData=xmlData;}
    
    public float getCurrAmt(){return currAmt;}
    public void setCurrAmt(float currAmt){this.currAmt=currAmt;}
    
    public float getUsdAmt(){return usdAmt;}
    public void setUsdAmt(float usdAmt){this.usdAmt=usdAmt;}
    
    
}

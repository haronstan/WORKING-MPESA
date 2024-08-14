package com.example.mpesa_test.Model;

import com.google.gson.annotations.SerializedName;

// This class represents the response from an STK (Sim Tool Kit) callback in an M-Pesa transaction.
public class STKCallbackResponse {

    // Mapped to the JSON key "ResultCode", this field represents the result code of the transaction.
    @SerializedName("ResultCode")
    private String resultCode;

    // Mapped to the JSON key "ResultDesc", this field represents the result description of the transaction.
    @SerializedName("ResultDesc")
    private String resultDesc;

    // Mapped to the JSON key "CheckoutRequestID", this field represents the unique ID for the checkout request.
    @SerializedName("CheckoutRequestID")
    private String checkoutRequestID;

    // Mapped to the JSON key "ResponseCode", this field represents the response code of the transaction.
    @SerializedName("ResponseCode")
    private String responseCode;

    // Mapped to the JSON key "ResponseDescription", this field represents the response description of the transaction.
    @SerializedName("ResponseDescription")
    private String responseDescription;

    // Mapped to the JSON key "MerchantRequestID", this field represents the merchant's request ID for the transaction.
    @SerializedName("MerchantRequestID")
    private String merchantRequestID;

    // Getter for the resultCode field.
    public String getResultCode() {
    return resultCode;
    }

    // Setter for the resultCode field.
    public void setResultCode(String resultCode) {
    this.resultCode = resultCode;
    }

    // Getter for the resultDesc field.
    public String getResultDesc() {
    return resultDesc;
    }

    // Setter for the resultDesc field.
    public void setResultDesc(String resultDesc) {
    this.resultDesc = resultDesc;
    }

    // Getter for the checkoutRequestID field.
    public String getCheckoutRequestID() {
    return checkoutRequestID;
    }

    // Setter for the checkoutRequestID field.
    public void setCheckoutRequestID(String checkoutRequestID) {
    this.checkoutRequestID = checkoutRequestID;
    }

    // Getter for the responseCode field.
    public String getResponseCode() {
    return responseCode;
    }

    // Setter for the responseCode field.
    public void setResponseCode(String responseCode) {
    this.responseCode = responseCode;
    }

    // Getter for the responseDescription field.
    public String getResponseDescription() {
    return responseDescription;
    }

    // Setter for the responseDescription field.
    public void setResponseDescription(String responseDescription) {
    this.responseDescription = responseDescription;
    }

    // Getter for the merchantRequestID field.
    public String getMerchantRequestID() {
    return merchantRequestID;
    }

    // Setter for the merchantRequestID field.
    public void setMerchantRequestID(String merchantRequestID) {
    this.merchantRequestID = merchantRequestID;
    }
    }
